package ru.netology.page;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VerificationPage {
    @FindBy(css = "[data-test-id=code] input")
    private SelenideElement codeField;

    @FindBy(css = "[data-test-id=action-verify]")
    private SelenideElement verifyButton;

    @FindBy(css = "[data-test-id='error-notification']")
    private SelenideElement errorNotification;

    public void verifyErrorNotificationVisiblity() {
        errorNotification.shouldBe(visible);
    }

    public void verifyVerificationPageVisiblity() {
        codeField.shouldBe(visible);
    }

    public void verifyErrorNotificationVisiblity() {
        errorNotification.shouldBe(visible);
    }

    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return new DashboardPage();
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}
