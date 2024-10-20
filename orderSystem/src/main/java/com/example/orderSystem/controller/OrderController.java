package com.example.orderSystem.controller;

import com.example.orderSystem.dto.request.DeleteOrderRequestDto;
import com.example.orderSystem.dto.request.OrderRequestDto;
import com.example.orderSystem.dto.request.UpdateStatusRequestDto;
import com.example.orderSystem.dto.response.ResponseDto;
import com.example.orderSystem.exception.invalid.InvalidNameException;
import com.example.orderSystem.exception.invalid.InvalidOrderIdException;
import com.example.orderSystem.exception.invalid.InvalidRequestFormatException;
import com.example.orderSystem.exception.invalid.InvalidStatusException;
import com.example.orderSystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class OrderController {

    private final OrderService orderService;
    @GetMapping
    public ResponseDto getAllOrder(){
        return ResponseDto.ok(orderService.getAllOrders());
    }

    @GetMapping("selectOrder")
    public ResponseDto getOrderById(@RequestParam Long orderId){
        return ResponseDto.ok(orderService.getOrderById(orderId));
    }

    @PostMapping("save")
    public ResponseDto saveOrder(@RequestBody OrderRequestDto orderRequestDto){
        if(orderRequestDto.getOrderId() == null) throw new InvalidOrderIdException();
        if(orderRequestDto.getCustomerName() == null) throw new InvalidNameException();
        orderService.addOrder(orderRequestDto);
        return ResponseDto.ok();
    }

    @PutMapping("updateOrder")
    public ResponseDto updateOrder(@RequestBody UpdateStatusRequestDto updateStatusRequestDto){
        return ResponseDto.ok(orderService.updateOrderById(updateStatusRequestDto));
    }

    @DeleteMapping("deleteOrder")
    public ResponseDto deleteOrder(@RequestBody DeleteOrderRequestDto deleteOrderRequestDto){
        orderService.deleteOrder(deleteOrderRequestDto);
        return ResponseDto.ok();
    }


}
