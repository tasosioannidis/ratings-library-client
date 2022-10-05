package com.baeldung.evaluation.ratings.restaurant.application;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.evaluation.ratings.lib.domain.Review;
import com.baeldung.evaluation.ratings.restaurant.domain.MenuItem;
import com.baeldung.evaluation.ratings.restaurant.infrastructure.persistence.MenuItemRepository;

@Service
public class MenuItemService {

	private final MenuItemRepository repository;

	public MenuItemService(MenuItemRepository repository) {
		this.repository = repository;
	}

	public Optional<MenuItem> fetchMenuItem(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Optional<MenuItem> addReview(Long id, Review review) {
		return repository.findById(id).map(menuItem -> {
			menuItem.addReview(review);
			return repository.save(menuItem);
		});
	}

}
