package com.example.cafeorder.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.cafeorder.model.dto.MenuResponse;
import com.example.cafeorder.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService {

	private final MenuRepository menuRepository;

	public List<MenuResponse> getMenus() {
		return menuRepository.findAll().stream()
			.map(menu -> new MenuResponse(menu.getId(), menu.getName(), menu.getPrice()))
			.collect(Collectors.toList());
	}

}
