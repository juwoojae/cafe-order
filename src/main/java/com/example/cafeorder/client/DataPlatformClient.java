package com.example.cafeorder.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.cafeorder.model.dto.DataPlatformOrderRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataPlatformClient {

	private final RestTemplate restTemplate;
	private final String endpoint;

	public DataPlatformClient(RestTemplate restTemplate, @Value("${data-platform.endpoint}") String endpoint) {
		this.restTemplate = restTemplate;
		this.endpoint = endpoint;
	}

	public boolean sendOrder(DataPlatformOrderRequest request) {
		try {
			ResponseEntity<Void> response = restTemplate.postForEntity(endpoint, request, Void.class);
			return response.getStatusCode().is2xxSuccessful();
		} catch (RestClientException ex) {
			log.warn("Failed to send order to data platform", ex);
			return false;
		}
	}
}
