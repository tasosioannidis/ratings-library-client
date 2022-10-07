package com.baeldung.evaluation.ratings.restaurant.presentation.dto;

import java.util.Objects;

import com.baeldung.evaluation.ratings.restaurant.domain.Server;

/**
 *
 * @author rozagerardo
 */
public class ServerDto {

    private Long id;
    private String firstName;
    private String lastName;

    private ServerDto() {
    }

    private ServerDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class Mapper {
        public static Server toModel(ServerDto dto) {
            Server model = new Server(dto.firstName, dto.lastName);
            if (Objects.nonNull(dto.id)) {
                model.setId(dto.id);
            }
            return model;
        }

        public static ServerDto toDto(Server model) {
            if (model == null)
                return null;
            return new ServerDto(model.getId(), model.getFirstName(), model.getLastName());
        }
    }
}
