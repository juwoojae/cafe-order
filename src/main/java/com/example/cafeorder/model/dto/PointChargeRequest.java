package com.example.cafeorder.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointChargeRequest {

	private Long userId;
	private Integer amount;
}
