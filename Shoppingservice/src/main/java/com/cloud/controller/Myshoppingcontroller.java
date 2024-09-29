package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/shopping")
public class Myshoppingcontroller {
	@Autowired 
	private RestTemplate restTemplate;
	@GetMapping("/test")
	public String home() {
		return "welcome to shoppingservice";
	}
	@GetMapping("/pay/{price}")
	public String paymentmethod(@PathVariable double price) {
		String url="http://PAYMENTSERVER/payment/pay/"+price;
		return  restTemplate.getForObject(url,String.class);
	
	
	}

}
