package com.example.cafeorder.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafeorder.model.dto.PointChargeRequest;
import com.example.cafeorder.model.dto.PointChargeResponse;
import com.example.cafeorder.service.PointService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PointController {

	private final PointService pointService;

	/**
	 * 포인트 충전 API
	 * @param request
	 * @return
	 */
	@PostMapping("/charge")
	public PointChargeResponse chargePoints(@RequestBody PointChargeRequest request) {
		return pointService.chargePoints(request.getUserId(), request.getAmount());
	}
}
