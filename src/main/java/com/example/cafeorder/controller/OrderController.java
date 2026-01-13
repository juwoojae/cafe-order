package com.example.cafeorder.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafeorder.model.dto.OrderRequest;
import com.example.cafeorder.model.dto.OrderResponse;
import com.example.cafeorder.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	/**
	 * 커피 주문, 결제 하기 API
	 * @param request
	 * @return
	 */
	@PostMapping("/order")
	public OrderResponse placeOrder(@RequestBody OrderRequest request) {
		return orderService.placeOrder(OrderRequest);
	}
}
