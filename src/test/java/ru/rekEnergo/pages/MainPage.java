package ru.rekEnergo.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public MainPage openPage() {
        open("https://rek-energo.ru/#");
        return this;
    }

    public MainPage assertHeader() {
        $(".header__inner").shouldHave(text("Главная\n" +
                "Деятельность\n" +
                "Публикация информации\n" +
                "О компании\n" +
                "Лицензии и документы\n" +
                "Контакты"));
        return this;
    }

    public MainPage assertTitle1() {
        $(".main").shouldHave(text("ООО «Региональная Энергетическая Компания»"));
        return this;
    }

    public MainPage clickActivity() {
        $("[href = '../#activity']").click();
        return this;
    }

    public MainPage assertTitle2() {
        $(".slider__content").shouldHave(text("Энергосбытовая деятельность"));
        return this;
    }

    public MainPage clickMoreInfo() {
        $(".buttons").click();
        return this;
    }

    public MainPage assertPopupTitle() {
        $(".popup__content").shouldHave(text("Взаимодействие с потенциальными клиентами включает в себя:"));
        return this;
    }

    public MainPage clickPublications() {
        $("[href = '../publikacziya-informaczii.html']").click();
        return this;
    }

    public MainPage assertInfoTitle() {
        $(".info__content").$(".title").shouldHave(text("Публикация информации"));
        $(".info__content").shouldHave(text("Раскрытие годовой финансовой (бухгалтерской) отчетности, а также аудиторского заключения ведется в эСМИ \"для-публикации-информации.рф\" (Эл № ФС77-69756 от 05 мая 2017г.)"));
        return this;
    }

    public MainPage clickContacts() {
        $("[href = '../#contacts']").click();
        return this;
    }

    public MainPage assertOurContacts() {
        $(".text__footer").shouldHave(text("Наши контакты\n" + "121151, г. Москва, ул. Можайский Вал, д.8, эт.6, пом. LXI, ком.17\n" + "+7 (495) 771-72-02\n" + "info@rek-energo.ru\n"));
        return this;
    }
}

