package com.baeldung.evaluation.ratings.restaurant.presentation.controller;

import java.util.List;

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
import com.baeldung.evaluation.ratings.restaurant.domain.Server;
import com.baeldung.evaluation.ratings.restaurant.presentation.dto.ServerDto;

/**
 *
 * @author rozagerardo
 */
@RestController
@RequestMapping(value = "/servers")
public class ServerController {

    private ServerService service;

    public ServerController(ServerService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServerDto> getList() {
        return service.fetchAll()
            .stream()
            .map(ServerDto.Mapper::toDto)
            .toList();
    }

    @GetMapping("/{id}")
    public ServerDto getById(@PathVariable Long id) {
        return service.fetchServer(id)
            .map(ServerDto.Mapper::toDto)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ServerDto create(@RequestBody ServerDto newServer) {
        Server model = ServerDto.Mapper.toModel(newServer);
        Server createdModel = this.service.createServer(model);
        return ServerDto.Mapper.toDto(createdModel);
    }

    @PostMapping("/{id}/reviews")
    public ServerDto addReview(@PathVariable Long id, @RequestBody Review review) {
        return service.addReview(id, review)
            .map(ServerDto.Mapper::toDto)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
