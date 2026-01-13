package com.example.cafeorder.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.cafeorder.model.dto.PointChargeResponse;
import com.example.cafeorder.entity.User;
import com.example.cafeorder.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PointService {

	private final UserRepository userRepository;

	@Transactional
	public PointChargeResponse chargePoints(Long userId, Integer amount) {
		if (amount == null || amount <= 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "charge amount must be positive");
		}

		User user = userRepository.findById(userId)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));

		int current = user.getPoint();
		int updated = current + amount;
		user.updatePoint(updated);

		return new PointChargeResponse(user.getId(), user.getPoint());
	}
}
