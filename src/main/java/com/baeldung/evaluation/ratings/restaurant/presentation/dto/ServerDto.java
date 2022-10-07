package com.baeldung.evaluation.ratings.restaurant.presentation.dto;

import java.util.Objects;

import com.baeldung.evaluation.ratings.lib.presentation.dto.ReviewableDto;
import com.baeldung.evaluation.ratings.restaurant.domain.Server;

public class ServerDto extends ReviewableDto<Server> {

	private Long id;
	private String firstName;
	private String lastName;

	private ServerDto() {
		super(null);
	}

	private ServerDto(Server server) {
		super(server);
		this.id = server.getId();
		this.firstName = server.getFirstName();
		this.lastName = server.getLastName();
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
			return new ServerDto(model);
		}
	}
}
