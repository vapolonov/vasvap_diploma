package ru.apolonov.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserResponse {
    private String id;
    private String token;
    private String name;
    private String job;
    private String createdAt;
    private String error;
}
