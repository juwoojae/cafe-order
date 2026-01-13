package com.example.cafeorder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DataPlatformOrderRequest {

	private Long userId;
	private Long menuId;
	private Integer price;
}
