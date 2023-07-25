package ru.rekenergo.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.rekenergo.pages.MainPage;

import static com.codeborne.selenide.Condition.text;

public class CheckLanding extends TestBase {
    MainPage mainPage = new MainPage();
    @Test
    @Tag("Smoke")
    @DisplayName("Проверка главной")
    void checkMainPage() {
        mainPage.openPage();
        mainPage.header.shouldHave(text("Главная\n" +
                "Деятельность\n" +
                "Публикация информации\n" +
                "О компании\n" +
                "Лицензии и документы\n" +
                "Контакты"));
        mainPage.title1.shouldHave(text("ООО «Региональная Энергетическая Компания»"));
        mainPage.clickActivity();
        mainPage.title2.shouldHave(text("Энергосбытовая деятельность"));
        mainPage.clickMoreInfo();
        mainPage.popupTitle.shouldHave(text("Взаимодействие с потенциальными клиентами включает в себя:"));
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Проверка публикации информации")
    void checkPublicationsPage() {
        mainPage.openPage()
                .clickPublications();
        mainPage.infoTitle.$(".title").shouldHave(text("Публикация информации"));
        mainPage.infoTitle.shouldHave(text("Раскрытие годовой финансовой (бухгалтерской) отчетности, а также аудиторского заключения ведется в эСМИ \"для-публикации-информации.рф\" (Эл № ФС77-69756 от 05 мая 2017г.)"));
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Проверка контактов")
    void checkAboutCompany() {
        mainPage.openPage()
                .clickContacts();
        mainPage. ourContacts.shouldHave(text("Наши контакты\n" + "121151, г. Москва, ул. Можайский Вал, д.8, эт.6, пом. LXI, ком.17\n" + "+7 (495) 771-72-02\n" + "info@rek-energo.ru\n"));
    }
    @Test
    @Tag("Smoke")
    @DisplayName("Проверка раздела Инжиниринговая деятельность")
    void checkEngineeringActivities() {
        mainPage.openPage()
                .clickEngineeringActivities();
        mainPage.engineeringActivitiesContent.shouldHave(text("Инжиниринговая деятельность"));
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Проверка услуг рздела Инжиниринговая деятельность")
    void checkServiceEngineeringActivities() {
        mainPage.openPage()
                .clickEngineeringActivities();
        mainPage.engineeringActivitiesContent.shouldHave(text("Проектирование, строительство и модернизация объектов энергоснабжения."));
        mainPage.engineeringActivitiesContent.shouldHave(text("Проектирование, строительство и модернизация автоматизированных систем коммерческого и технического учета."));
    }
}
