package com.baeldung.evaluation.ratings.restaurant.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baeldung.evaluation.ratings.restaurant.domain.Server;

public interface ServerRepository extends JpaRepository<Server, Long> {

}
