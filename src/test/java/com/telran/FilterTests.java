package com.telran;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;

public class FilterTests {
    BerlinPage berlinPage;

    @BeforeEach
    public void ensurePreconditions() {
        berlinPage = new BerlinPage().openPage();
        new CommonPage().acceptCookies();
    }

    @Test
    public void filterTopRatedTest() {
        int countBefore = berlinPage.getResultsCount();
        berlinPage.clickOnTopRate();
//        sleep(1000); // ждем обновления результатов отбора
        Assertions.assertTrue(berlinPage.getResultsCount() <= countBefore);
    }

    @Test
    public void filterCuisineTest() {
        int countRestaurants = berlinPage.getCountOfAfricanRestaurants();
        berlinPage.clickOnAfricanCheckbox();
        sleep(1000);
        Assertions.assertEquals(berlinPage.getResultsCount(), countRestaurants);
        for (int i = 2; i < countRestaurants + 1; i++) {
            berlinPage.africanRestaurant(i).shouldHave(exactText("African"));
        }
    }

    @Test
    public void searchCuisineTest() {
        berlinPage.searchBy("African");
        berlinPage.cuisineFilter().shouldHave(text("Cuisine"));
        berlinPage.africanCheckBox().shouldBe(selected);
        sleep(1000);
        Assertions.assertEquals(berlinPage.getResultsCount(), berlinPage.getCountOfAfricanRestaurants());
    }

}
