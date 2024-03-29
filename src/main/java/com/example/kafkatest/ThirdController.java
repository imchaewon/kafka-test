package com.example.kafkatest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/third")
@RequiredArgsConstructor
@Slf4j
public class ThirdController {

	@Autowired
	private CustomProducer producer;

	@PostMapping("/publish")
	public void producer(@RequestBody Map<String, String> message){
		log.info(">>> start event publish");
		producer.send(message.get("msg"));
	}

}
