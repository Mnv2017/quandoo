package com.telran;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.telran.CommonPage.BASE_URL;

public class RestaurantPage {

    private static ElementsCollection ratingInfoBlocks;

    private static By endOfPage = By.cssSelector("[data-qa=make-enquiry-button]");
    private static By ratingInfo = By.cssSelector(("[data-qa=merchant-rating]"));
    private static By ratingNumber = By.cssSelector(("[data-qa=reviews-score]>span.r91qah-1.DYnWo"));

    public RestaurantPage openPage() {
        open(BASE_URL + "en/berlin");
        getWebDriver().manage().window().maximize();
        return page(RestaurantPage.class);
    }

    public RestaurantPage initLocators() {
        $(endOfPage).scrollIntoView(false);
        ratingInfoBlocks = $$(ratingInfo);
        return this;
    }

    public SelenideElement getLocatorRating(int i) {
        return ratingInfoBlocks.get(i).find(ratingNumber);
    }

}
