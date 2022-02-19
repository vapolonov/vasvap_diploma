package ru.apolonov.tests.api;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.apolonov.models.*;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static ru.apolonov.tests.api.specs.Specs.*;


public class ApiReqresInTests {

    @Test
    @Description("Register with correct user data")
    @DisplayName("Register successful reqres.in")
    void registerSuccessfulTest() {
        RegisterUser registrationData = new RegisterUser();
        registrationData.setEmail("eve.holt@reqres.in");
        registrationData.setPassword("pistol");

        CreateUserResponse response = given()
                .spec(specRequest)
                .body(registrationData)
                .when()
                .post("/api/register")
                .then()
                .spec(specResponse200)
                .extract().as(CreateUserResponse.class);

        assertEquals("4", response.getId());
        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
    }

    @Test
    @Description("Login with incorrect user data")
    @DisplayName("Negative login reqres.in")
    void negativeLoginTest() {
        RegisterUser registrationData = new RegisterUser();
        registrationData.setEmail("eve.holt@reqres.in");
        registrationData.setPassword("");

        CreateUserResponse response = given()
                .spec(specRequest)
                .body(registrationData)
                .when()
                .post("api/login")
                .then()
                .spec(specResponse400)
                .extract().as(CreateUserResponse.class);

        assertEquals("Missing password", response.getError());
    }

    @Test
    @Description("Create new user")
    @DisplayName("Create user reqres.in")
    void createUserTest() {
        CreateUserRequest newCreateUser = new CreateUserRequest("John Snow", "Targarien");

        CreateUserResponse response = given()
                .spec(specRequest)
                .body(newCreateUser)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .extract().as(CreateUserResponse.class);

        assertEquals(newCreateUser.getName(), response.getName());
        assertEquals(newCreateUser.getJob(), response.getJob());
        assertThat(newCreateUser.getJob()).isEqualTo("Targarien");
        assertFalse(response.getId().isEmpty());
        assertFalse(response.getCreatedAt().isEmpty());
    }

    @Test
    @Description("Get single user data")
    @DisplayName("Get single user data reqres.in")
    void singleUserTest() {

        UserData data = given()
                .spec(specRequest)
                .when()
                .get("/api/users/2")
                .then()
                .spec(specResponse200)
                .extract().as(UserData.class);
        assertEquals(2, data.getUser().getId());
        assertEquals("Janet", data.getUser().getFirstName());
        assertEquals("janet.weaver@reqres.in", data.getUser().getEmail());
        assertThat(data.getUser().getLastName()).isEqualTo("Weaver");
    }

    @Test
    @Description("Update existing user")
    @DisplayName("Update user reqres.in")
    void updateUser() {
        UpdateUserRequest newUpdateUser = new UpdateUserRequest("morpheus", "zion resident");

        UpdateUserResponse response = given()
                .spec(specRequest)
                .body(newUpdateUser)
                .when()
                .patch("/api/users/2")
                .then()
                .spec(specResponse200)
                .extract().as(UpdateUserResponse.class);

        assertThat(response.getName()).isEqualTo("morpheus");
        assertThat(response.getJob()).isEqualTo("zion resident");
        assertFalse(response.getUpdatedAt().isEmpty());
    }

    @Test
    @Description("Delete user")
    @DisplayName("Delete user reqres.in")
    void deleteUser() {
        given()
                .spec(specRequest)
                .when()
                .delete("/api/users/2")
                .then()
                .log().all()
                .statusCode(204);
    }
}
