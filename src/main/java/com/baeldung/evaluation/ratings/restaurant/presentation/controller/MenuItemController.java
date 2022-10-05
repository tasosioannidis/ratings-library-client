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
import com.baeldung.evaluation.ratings.restaurant.application.MenuItemService;
import com.baeldung.evaluation.ratings.restaurant.presentation.dto.MenuItemDto;

@RestController
@RequestMapping(value = "/menu-items")
public class MenuItemController {

	private MenuItemService service;

	public MenuItemController(MenuItemService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public MenuItemDto getById(@PathVariable Long id) {
		return service.fetchMenuItem(id).map(MenuItemDto::new)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/{id}/reviews")
	public MenuItemDto addReview(@PathVariable Long id, @RequestBody Review review) {
		return service.addReview(id, review).map(MenuItemDto::new)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
