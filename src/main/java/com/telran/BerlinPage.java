package com.telran;

import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BerlinPage {
    public BerlinPage() {
    }

    public void acceptCookies() {
        if ($(byText("Accept all")).exists()) {
            $(byText("Accept all")).click();
        }
    }

    public BerlinPage clickOnTopRate() {
        $("[data-qa=filter-button-top-rated]").click();
        return this;
    }

    public int getResultsCount() {
        String[] str = $("[data-qa=results-count]").getText().split(" ");
        return Integer.parseInt(str[0].replace("+", "").replace("\n", ""));
    }

    public BerlinPage clickOnAfricanCheckbox() {
        $(byText("African")).click();
        return this;
    }

    public int getCountOfAfricanRestaurants() {
        String str = $("[data-qa=filter-cuisine-label-03c331d2-8f5f-4d45-8731-e5e98ebfee00] span.ulye33-6.hZxYrh").getText();
        return Integer.parseInt(str.substring(1, str.length() - 1));
    }

    public boolean isRestaurantAfrican(int i) {
        return $(byXpath("//*[@id=\"tab-merchants\"]/div[" + i + "]//div[@class=\"sc-fzozJi nBSn\"]/span")).getText().equals("African");
    }
}
