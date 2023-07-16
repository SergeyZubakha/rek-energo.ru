package ru.rekEnergo.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class CheckLanding extends TestBase {
    @Test
    @Tag("Smoke")
    @DisplayName("Проверка главной")
    void checkMainPage() {
        mainPage.openPage()
                .assertHeader()
                .assertTitle1()
                .clickActivity();
        sleep(10000);
        mainPage.assertTitle2()
                .clickMoreInfo()
                .assertPopupTitle();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Проверка публикации информации")
    void checkPublicationsPage() {
        mainPage.openPage()
                .clickPublications()
                .assertInfoTitle();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Проверка контактов")
    void checkAboutCompany() {
        mainPage.openPage()
                .clickContacts()
                .assertOurContacts();
    }
}
