package com.telran;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CommonPage {
    public static final String BASE_URL = "https://www.quandoo.de/";

    private static By accCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    public void acceptCookies() {
        if ($(accCookies).exists()) {
            $(accCookies).click();
        }
    }

}
