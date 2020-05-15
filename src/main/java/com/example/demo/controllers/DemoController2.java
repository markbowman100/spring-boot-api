package com.example.demo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Greeting;

@RestController
@RequestMapping(value = {"/test"})
public class DemoController2 {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greetings")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PostMapping("/resets")
	public Greeting reset() {
		counter.set(0);
		return new Greeting(counter.incrementAndGet(), null);
	}
	
	@GetMapping("/{id}")
	public Greeting greeting(@PathVariable() int id) {
		return new Greeting(counter.incrementAndGet(), "" + id);
	}

}