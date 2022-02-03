package com.telran;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.telran.CommonPage.BASE_URL;

public class BerlinPage {

    private static By firstRestaurant = By.xpath("//*[@id='tab-merchants']/div[2]");
    private static By firstRestaurantRating = By.xpath("//*[@id='tab-merchants']/div[2]//div[@class='sc-1n6pbmb-2 WkOwr']");
    private static By ratingNumber = By.xpath("//div[@class='sc-1atis9w-1 bYipHC']");
    private static By topRateButton = By.cssSelector("[data-qa=filter-button-top-rated]");
    private static By selectResult = By.cssSelector("[data-qa=results-count]");
    private static By countAfricanRestaurants = By.cssSelector("[data-qa=filter-cuisine-label-03c331d2-8f5f-4d45-8731-e5e98ebfee00] span.ulye33-6.hZxYrh");
    private static By search = By.cssSelector("[data-qa='search-bar-dining-input']");
    private static By firstEl = By.xpath("//form[@id='searchForm']/div/div/div/div[2]/li/div/span[2]");
    private static By checkBox = By.cssSelector("[data-cuisine-id='03c331d2-8f5f-4d45-8731-e5e98ebfee00']");
    private static By africanCuisineFilter = By.xpath("//div[@data-qa='filter-cuisine-label-03c331d2-8f5f-4d45-8731-e5e98ebfee00']");
    private static By cuisineFilter = By.cssSelector(".sc-1w62342-6.jZYVwn span");

    public BerlinPage() {
    }

    public BerlinPage openPage() {
        open(BASE_URL + "en/berlin");
        getWebDriver().manage().window().maximize();
        return page(BerlinPage.class);
    }

    public BerlinPage clickOnTopRate() {
        $(topRateButton).click();
        return this;
    }

    public int getResultsCount() {
        String[] str = $(selectResult).getText().split(" ");
        return Integer.parseInt(str[0].replace("+", "").replace("\n", ""));
    }

    public BerlinPage clickOnAfricanCheckbox() {
        $(africanCuisineFilter).click();
        return this;
    }

    public int getCountOfAfricanRestaurants() {
        String str = $(countAfricanRestaurants).getText();
        return Integer.parseInt(str.substring(1, str.length() - 1));
    }

    public SelenideElement africanRestaurant(int i) {
        return $(byXpath("//*[@id='tab-merchants']/div[" + i + "]//div[@class='sc-fzozJi nBSn']/span"));
    }

    public RestaurantPage clickOnFirstRestaurant() {
        $(firstRestaurant).click();
        return new RestaurantPage();
    }

    public String getFirstRestRating() {
        String s = $(firstRestaurantRating).getText();
        return s.substring(0, s.length() - 2);
    }

    public BerlinPage searchBy(String s){
        $(search).setValue(s);
        $(firstEl).click();
        return page(BerlinPage.class);
    }

    public SelenideElement africanCheckBox() {
        return $(checkBox);
    }

    public SelenideElement cuisineFilter(){
        return $(cuisineFilter);
    }
}
