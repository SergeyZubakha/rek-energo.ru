package ru.rekEnergo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    SelenideElement header = $(".header__inner"),
            title1 = $(".main"),
            activity = $("[href = '../#activity']"),
            title2 = $(".slider__content"),
            moreInfo = $(byText("Подробнее")),
            popupTitle = $(".popup__content"),
            publications = $("[href = '../publikacziya-informaczii.html']"),
            infoTitle = $(".info__content"),
            contacts = $("[href = '../#contacts']"),
            ourContacts = $(".text__footer");

    public MainPage openPage() {
        open("https://rek-energo.ru/#");
        return this;
    }

    public MainPage assertHeader() {
        header.shouldHave(text("Главная\n" +
                "Деятельность\n" +
                "Публикация информации\n" +
                "О компании\n" +
                "Лицензии и документы\n" +
                "Контакты"));
        return this;
    }

    public MainPage assertTitle1() {
        title1.shouldHave(text("ООО «Региональная Энергетическая Компания»"));
        return this;
    }

    public MainPage clickActivity() {
        activity.click();
        return this;
    }

    public MainPage assertTitle2() {
        title2.shouldHave(text("Энергосбытовая деятельность"));
        return this;
    }

    public MainPage clickMoreInfo() {

        moreInfo.hover();
        moreInfo.click();
        return this;
    }

    public MainPage assertPopupTitle() {
        popupTitle.shouldHave(text("Взаимодействие с потенциальными клиентами включает в себя:"));
        return this;
    }

    public MainPage clickPublications() {
        publications.click();
        return this;
    }

    public MainPage assertInfoTitle() {
        infoTitle.$(".title").shouldHave(text("Публикация информации"));
        infoTitle.shouldHave(text("Раскрытие годовой финансовой (бухгалтерской) отчетности, а также аудиторского заключения ведется в эСМИ \"для-публикации-информации.рф\" (Эл № ФС77-69756 от 05 мая 2017г.)"));
        return this;
    }

    public MainPage clickContacts() {
        contacts.click();
        return this;
    }

    public MainPage assertOurContacts() {
        ourContacts.shouldHave(text("Наши контакты\n" + "121151, г. Москва, ул. Можайский Вал, д.8, эт.6, пом. LXI, ком.17\n" + "+7 (495) 771-72-02\n" + "info@rek-energo.ru\n"));
        return this;
    }
}

