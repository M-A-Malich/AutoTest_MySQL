package ru.netology.page;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id='date']");
    public DashboardPage() {
        heading.shouldBe(visible);

    }
}
