package com.baeldung.evaluation.ratings.restaurant.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baeldung.evaluation.ratings.restaurant.domain.MenuItem;

/**
 *
 * @author rozagerardo
 */
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
