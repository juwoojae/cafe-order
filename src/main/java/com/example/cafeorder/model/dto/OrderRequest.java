package com.example.cafeorder.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

	private Long userId;
	private Long menuId;
}
