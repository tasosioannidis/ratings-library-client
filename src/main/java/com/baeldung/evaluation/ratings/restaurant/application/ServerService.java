package com.baeldung.evaluation.ratings.restaurant.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baeldung.evaluation.ratings.lib.domain.Review;
import com.baeldung.evaluation.ratings.restaurant.domain.Server;
import com.baeldung.evaluation.ratings.restaurant.infrastructure.persistence.ServerRepository;

@Service
public class ServerService {

	private final ServerRepository repository;

	public ServerService(ServerRepository repository) {
		this.repository = repository;
	}

	public Optional<Server> fetchServer(Long id) {
		return repository.findById(id);
	}

	public Optional<Server> addReview(Long id, Review review) {
		return repository.findById(id).map(server -> {
			server.addReview(review);
			return repository.save(server);
		});
	}

}
