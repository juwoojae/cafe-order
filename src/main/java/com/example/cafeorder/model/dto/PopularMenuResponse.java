package com.example.cafeorder.model.dto;

import lombok.Getter;

@Getter
public class PopularMenuResponse {

	private final Long menuId;
	private final String name;
	private final Integer price;
	private final Long orderCount;

	public PopularMenuResponse(Long menuId, String name, Integer price, Long orderCount) {
		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.orderCount = orderCount;
	}
}
