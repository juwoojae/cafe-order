package com.example.cafeorder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafeorder.model.dto.MenuResponse;
import com.example.cafeorder.service.MenuService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuController {

	private final MenuService menuService;

	/**
	 * 커피 메뉴 목록 조회 API
	 * @return
	 */
	@GetMapping("/menus")
	public List<MenuResponse> getMenus() {

		return menuService.getMenus();
	}

}
