package com.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;

public class RatingTests {
    BerlinPage berlinPage;
    RestaurantPage restaurantPage;

    @BeforeEach
    public void ensurePreconditions() {
        berlinPage = new BerlinPage().openPage();
        new CommonPage().acceptCookies();
    }

    @Test
    public void ratingTest() {
        String firstRestaurantRating = berlinPage.getFirstRestRating();
        restaurantPage = new BerlinPage().clickOnFirstRestaurant().initLocators();
        restaurantPage.getLocatorRating(0).shouldHave(exactText(firstRestaurantRating));
        restaurantPage.getLocatorRating(2).shouldHave(exactText(firstRestaurantRating));
    }
}
