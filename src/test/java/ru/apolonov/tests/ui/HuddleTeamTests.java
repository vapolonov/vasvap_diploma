package ru.apolonov.tests.ui;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.apolonov.config.huddleteam.HuddleApp;
import ru.apolonov.helpers.DriverUtils;
import ru.apolonov.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class HuddleTeamTests extends TestBase {

    @BeforeAll
    static void configureBaseUrl() {
        Configuration.baseUrl = HuddleApp.config.webUrl();
    }

    @Test
    @Description("Main page title header test")
    @DisplayName("Main page title should have header text")
    void titleTest() {
        step("Open url 'https://www.huddle.team'", () ->
            open("/"));

        step("Page title should have text 'Next Generation Video Conferencing and Collaboration | Huddle.Team'", () -> {
            String expectedTitle = "Next Generation Video Conferencing and Collaboration | Huddle.Team";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Console test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.huddle.team'", () ->
            open("/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Description("Main menu test")
    @DisplayName("Main menu has items")
    void generatedTest() {
        step("Open https://www.huddle.team", () -> open("/"));

        step("Check main menu (.nav.navbar-nav is not null)", () -> {
            $$x("//ul[@class='nav navbar-nav'][not(@class='navbar-right')]//li[@class='visible-lg']")
                    .shouldHave(sizeGreaterThan(0));
        });
    }
}