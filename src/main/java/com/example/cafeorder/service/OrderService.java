package com.example.cafeorder.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.cafeorder.client.DataPlatformClient;
import com.example.cafeorder.entity.Menu;
import com.example.cafeorder.model.dto.DataPlatformOrderRequest;
import com.example.cafeorder.model.dto.OrderRequest;
import com.example.cafeorder.model.event.OrderEvent;
import com.example.cafeorder.producer.OrderProducer;
import com.example.cafeorder.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderProducer orderProducer;
	private final MenuRepository menuRepository;
	private final DataPlatformClient dataPlatformClient;

	@Transactional
	public void placeOrder(OrderRequest orderRequest) {

		String paidAt = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		Menu menu = menuRepository.findById(orderRequest.getMenuId())
			.orElseThrow(() -> new IllegalArgumentException("Menu Not Found"));

		OrderEvent event = OrderEvent.builder()
			.userId(orderRequest.getUserId())
			.menuId(menu.getId())
			.paidAt(paidAt)
			.build();
		// 카프카에 이벤트 보내기
		orderProducer.send(event);

		// 주문 내역을 데이터 수집 플랫폼으로 실시간 전송하는 로직 (
		DataPlatformOrderRequest payload = DataPlatformOrderRequest.builder()
			.userId(orderRequest.getUserId())
			.menuId(menu.getId())
			.price(menu.getPrice())
			.build();

		boolean sent = dataPlatformClient.sendOrder(payload);
		if (!sent) {
			throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "failed to send order to data platform");
		}
	}
}



