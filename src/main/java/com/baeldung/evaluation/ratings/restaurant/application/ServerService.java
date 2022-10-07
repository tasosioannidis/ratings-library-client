package com.baeldung.evaluation.ratings.restaurant.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baeldung.evaluation.ratings.restaurant.domain.Server;
import com.baeldung.evaluation.ratings.restaurant.infrastructure.persistence.ServerRepository;

/**
 *
 * @author rozagerardo
 */
@Service
public class ServerService {

    private final ServerRepository repository;

    public ServerService(ServerRepository repository) {
        this.repository = repository;
    }

    public List<Server> fetchAll() {
        return repository.findAll();
    }

    public Optional<Server> fetchServer(Long id) {
        return repository.findById(id);
    }

    public Server createServer(Server server) {
        return repository.save(server);
    }
}
