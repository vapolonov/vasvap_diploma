package ru.apolonov.tests.ui;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.apolonov.config.huddleteam.HuddleApp;
import ru.apolonov.tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LoginHuddleTeamTests extends TestBase {

    @BeforeAll
    static void configureBaseUrl() {
        Configuration.baseUrl = HuddleApp.config.webUrl();
    }

    @Test
    @DisplayName("Successful Login")
    @Description("Successful Login with correct parameters")
    void successLoginTest() {
        step("Complete authorization form", () -> {
            step("Open page https://www.huddle.team/login", () -> open("/login"));
            step("Enter email", () -> $("#login_email").setValue(HuddleApp.config.userLogin()));
            step("Enter password", () -> $("#password").setValue(HuddleApp.config.userPassword()));
            step("Press Submit", () -> $("#loginformsubmit").click());
        });
        step("Check successful login", () -> {
            step("Check name Account Administrator", () ->
                    $("div.column-line.clearfix span.credentials-value.pull-right")
                            .find(byText("Vasiliy Apolonov")).shouldBe(visible));
            step("Check email Account Administrator", () ->
                    $("div.column-line.clearfix span.credentials-value.pull-right.small")
                            .find(byText("vasvap@gmail.com")).shouldBe(visible));
        });
    }

    @Test
    @DisplayName("Unsuccessful login")
    @Description("Unsuccessful login without password")
    void loginWithoutPasswordTest() {
        step("Complete authorization form without password", () -> {

            step("Open page https://www.huddle.team/login", () -> open("/login"));

            step("Enter email", () -> $("#login_email").setValue(HuddleApp.config.userLogin()));
            step("Press Submit", () -> $("#loginformsubmit").click());
        });

        step("Check unsuccessful login", () -> {
            step("Check label with error", () ->
                    $(".parsley-required").shouldHave(text("This value is required")));
            step("Check error label color", () ->
                    $(".parsley-required").shouldHave(cssValue("color", "rgba(242, 66, 53, 1)")));
        });
    }

    @Test
    @DisplayName("Unsuccessful login")
    @Description("Unsuccessful login without email and password")
    void loginWithoutLoginTest() {
        step("Complete authorization form without email", () -> {

            step("Open page https://www.huddle.team/login", () ->
                    open("/login"));
            step("Press Submit", () ->
                    $("#loginformsubmit").click());
        });

        step("Check unsuccessful login", () -> {
            step("Check label with error under email input", () ->
                    $("#parsley-id-5").shouldHave(text("This value is required")));
            step("Check email input border color", () ->
                    $("#login_email").shouldHave(cssValue("border-color", "rgb(242, 66, 53)")));
            step("Check error email label color", () ->
                    $("#parsley-id-5").shouldHave(cssValue("color", "rgba(242, 66, 53, 1)")));
            step("Check label with error under password input", () ->
                    $("#parsley-id-7").shouldHave(text("This value is required")));
            step("Check password input border color", () ->
                    $("#password").shouldHave(cssValue("border-color", "rgb(242, 66, 53)")));
            step("Check error password label color", () ->
                    $("#parsley-id-7").shouldHave(cssValue("color", "rgba(242, 66, 53, 1)")));
        });
    }

    @Test
    @DisplayName("Password recovery")
    @Description("Check password recovery")
    void passwordRecoveryTests() {
        step("Complete forgot password form", () -> {
            step("Open page https://www.huddle.team/login", () -> open("/login"));
            step("Click on 'Forgot your password?' link", () ->
                    $(byAttribute("title", "Forgot your password?")).click());
            step("Enter email", () ->
                    $("#forgot_password_email").setValue(HuddleApp.config.userLogin()));
            step("Press Submit", () ->
                    $("a#loginformsubmit").click());
        });

        step("Check popup window about sending email", () ->
                $(".alert-success").shouldHave(text("Credentials email sent")));
    }
}
