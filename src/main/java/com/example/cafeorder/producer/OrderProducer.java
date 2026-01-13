package com.example.cafeorder.producer;

import static com.example.cafeorder.model.topic.KafkaTopic.*;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.cafeorder.model.event.OrderEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderProducer {

	// 카프카에 메시지를 보내주는 역할 수행
	// 스프링 부트와 카프카가 소통할때 필요하느 kafkaTemplate 선언
	private final KafkaTemplate<String, OrderEvent> paymentCompletedEventProducerFactory;
	//
	public void send(OrderEvent event){

		paymentCompletedEventProducerFactory.send(TOPIC_ORDER_COMPLETED, event);
	}
}
