package com.example.cafeorder;

import org.springframework.stereotype.Component;

import com.example.cafeorder.entity.Menu;
import com.example.cafeorder.entity.User;
import com.example.cafeorder.repository.MenuRepository;
import com.example.cafeorder.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

/**
 * ?????????Úâ? åÚ????Ý¹??? ?ªì?
 */
@Component
@RequiredArgsConstructor
public class TestDataInit {

	private final UserRepository userRepository;
	private final MenuRepository menuRepository;

	@PostConstruct
	public void init(){
		userRepository.save(new User());  // id = 1
		userRepository.save(new User());  // id = 2
		userRepository.save(new User());  // id = 3

		menuRepository.save(Menu.builder().name("Americano").price(4500).build());
		menuRepository.save(Menu.builder().name("Cafe Latte").price(5000).build());
		menuRepository.save(Menu.builder().name("Vanilla Latte").price(5500).build());
		menuRepository.save(Menu.builder().name("Cold Brew").price(5200).build());
	}
}
