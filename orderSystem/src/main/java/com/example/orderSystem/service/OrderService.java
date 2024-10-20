package com.example.orderSystem.service;


import com.example.orderSystem.dto.OrderDto;
import com.example.orderSystem.dto.request.DeleteOrderRequestDto;
import com.example.orderSystem.dto.request.OrderRequestDto;
import com.example.orderSystem.dto.request.UpdateStatusRequestDto;
import com.example.orderSystem.enums.OrderStatus;
import com.example.orderSystem.exception.invalid.DuplicateOrderIdException;
import com.example.orderSystem.exception.invalid.InvalidStatusException;
import com.example.orderSystem.exception.invalid.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final ConcurrentHashMap<Long, OrderDto> orderDtoMap = new ConcurrentHashMap<>();


    // 주문 추가
    public void addOrder(OrderRequestDto orderRequestDto) {

        synchronized (this){
            OrderDto orderDto = new OrderDto();
            orderDto.setOrderId(orderRequestDto.getOrderId());
            orderDto.setCustomerName(orderRequestDto.getCustomerName());
            orderDto.setOrderDate(orderRequestDto.getOrderDate());

            if (orderDtoMap.putIfAbsent(orderRequestDto.getOrderId(), orderDto) != null) {
                throw new DuplicateOrderIdException();
            }

            try{
                OrderStatus status = OrderStatus.valueOf(orderRequestDto.getStatus().toUpperCase());
                orderDto.setStatus(status);
            } catch (IllegalArgumentException e){
                throw new InvalidStatusException();
            }

            orderDtoMap.put(orderDto.getOrderId(), orderDto);
        }

    }

    // 모든 주문 조회
    public List<OrderDto> getAllOrders() {
        return new ArrayList<>(orderDtoMap.values());
    }

    // 특정 주문 조회
    public OrderDto getOrderById(Long orderId) {
        OrderDto orderDto = orderDtoMap.get(orderId);
        if(orderDto == null){
            throw new OrderNotFoundException();
        }
        return orderDto;
    }

    // 주문 상태 변경
    public OrderDto updateOrderById(UpdateStatusRequestDto updateStatusRequestDto){

        synchronized (this){
            OrderDto orderDto = orderDtoMap.get(updateStatusRequestDto.getOrderId());
            if(orderDto == null){
                throw new OrderNotFoundException();
            }
            try{
                OrderStatus status = OrderStatus.valueOf(updateStatusRequestDto.getStatus().toUpperCase());
                orderDto.setStatus(status);
            } catch (IllegalArgumentException e){
                throw new InvalidStatusException();
            }
            return orderDto;
        }


    }

    // 주문 삭제
    public void deleteOrder(DeleteOrderRequestDto deleteOrderRequestDto) {
        OrderDto orderDto =  orderDtoMap.get(deleteOrderRequestDto.getOrderId());
        if(orderDto == null){
            throw new OrderNotFoundException();
        }
        orderDtoMap.remove(deleteOrderRequestDto.getOrderId());

    }
}
