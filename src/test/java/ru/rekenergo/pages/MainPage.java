package ru.rekenergo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    public SelenideElement header = $(".header__inner"),
            title1 = $(".main"),
            activity = $("[href = '../#activity']"),
            title2 = $(".slider__content"),
            moreInfo = $(byText("Подробнее")),
            popupTitle = $(".popup__content"),
            publications = $("[href = '../publikacziya-informaczii.html']"),
            infoTitle = $(".info__content"),
            contacts = $("[href = '../#contacts']"),
            ourContacts = $(".text__footer"),
            engineeringActivities = $(byText("Инжиниринговая деятельность")),
            engineeringActivitiesContent = $(".secondary-slide");


    public MainPage openPage() {
        open("https://rek-energo.ru/#");
        return this;
    }

    public MainPage clickActivity() {
        activity.click();
        return this;
    }

    public MainPage clickMoreInfo() {
        moreInfo.hover();
        moreInfo.click();
        return this;
    }

    public MainPage clickPublications() {
        publications.click();
        return this;
    }

    public MainPage clickContacts() {
        contacts.click();
        return this;
    }

    public MainPage clickEngineeringActivities() {
        engineeringActivities.click();
        return this;
    }
}

