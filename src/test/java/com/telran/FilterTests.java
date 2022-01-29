package com.telran;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class FilterTests {

    @BeforeEach
    public void ensurePreconditions() {
        open("http://www.quandoo.de/en/berlin");
        new BerlinPage().acceptCookies();
    }

    @Test
    public void filterTopRatedTest() {
        BerlinPage berlinPage = new BerlinPage();
        int countBefore = berlinPage.getResultsCount();
        berlinPage.clickOnTopRate();
        sleep(3000); // ждем обновления результатов отбора
        Assertions.assertTrue(berlinPage.getResultsCount() <= countBefore);
    }

    @Test
    public void filterCuisineTest() {
        BerlinPage berlinPage = new BerlinPage();
        int countRestaurants = berlinPage.getCountOfAfricanRestaurants();
        berlinPage.clickOnAfricanCheckbox();
        sleep(2000);
        Assertions.assertEquals(berlinPage.getResultsCount(), countRestaurants);
        for (int i = 2; i < countRestaurants + 1; i++) {
            Assertions.assertTrue(berlinPage.isRestaurantAfrican(i));
        }
    }
}
