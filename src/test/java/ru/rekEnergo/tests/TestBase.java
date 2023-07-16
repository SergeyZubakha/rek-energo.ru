package ru.rekEnergo.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.rekEnergo.helpers.Attach;
import ru.rekEnergo.pages.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    MainPage mainPage = new MainPage();
    @BeforeAll
    static void beforeAll() {
        //Configuration.baseUrl = "https://rek-energo.ru/#;
        //Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
        //Configuration.screenshots = false;
        //Configuration.savePageSource = false;
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; //для запуска тестов удаленно
        Configuration.pageLoadStrategy = "eager";

        Configuration.remote = System.getProperty("selenoidUrl"); //для запуска тестов удаленно
        Configuration.baseUrl = System.getProperty("baseUrl", "https://rek-energo.ru/#");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }
}
