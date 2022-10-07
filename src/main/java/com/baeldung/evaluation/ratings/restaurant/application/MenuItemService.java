package com.baeldung.evaluation.ratings.restaurant.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baeldung.evaluation.ratings.restaurant.domain.MenuItem;
import com.baeldung.evaluation.ratings.restaurant.infrastructure.persistence.MenuItemRepository;

/**
 *
 * @author rozagerardo
 */
@Service
public class MenuItemService {

    private final MenuItemRepository repository;

    public MenuItemService(MenuItemRepository repository) {
        this.repository = repository;
    }

    public List<MenuItem> fetchAll() {
        return repository.findAll();
    }

    public Optional<MenuItem> fetchMenuItem(Long id) {
        return repository.findById(id);
    }

    public MenuItem createServer(MenuItem menuItem) {
        return repository.save(menuItem);
    }
}
