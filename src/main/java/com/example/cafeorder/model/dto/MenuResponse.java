package com.example.cafeorder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MenuResponse {

	private Long id;
	private String name;
	private Integer price;
}
