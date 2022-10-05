package com.baeldung.evaluation.ratings.restaurant.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.baeldung.evaluation.ratings.lib.domain.Review;
import com.baeldung.evaluation.ratings.restaurant.application.ServerService;
import com.baeldung.evaluation.ratings.restaurant.presentation.dto.ServerDto;

@RestController
@RequestMapping(value = "/servers")
public class ServerController {

	private ServerService service;

	public ServerController(ServerService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public ServerDto getById(@PathVariable Long id) {
		return service.fetchServer(id).map(ServerDto::new)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/{id}/reviews")
	public ServerDto addReview(@PathVariable Long id, @RequestBody Review review) {
		return service.addReview(id, review).map(ServerDto::new)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
