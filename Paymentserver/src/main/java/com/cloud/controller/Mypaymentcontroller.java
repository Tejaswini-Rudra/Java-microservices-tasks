package com.cloud.controller;


	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	@RestController
	@RequestMapping("/payment")
	public class Mypaymentcontroller {
		@GetMapping("/test")
		public String savedata() {
			return  "welcome to payment service";
		}
		@GetMapping("/pay/{price}")
		public String getprice(@PathVariable double price) {
			return " the amount"+price+"updated sucessfully";
		}
		
		

	}




