package test;

import ru.netology.mode.DataHelper;
import ru.netology.mode.SQLHelter;
import ru.netology.page.LoginPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import javax.xml.crypto.Data;

import static ru.netology.mode.SQLHelter.cleanDatabase;

public class BankLoginTest {

    @AfterAll
    static void  teardown() {
        cleanDatabase();
    }

    @Test
    @DisplayName("Should succesfully login to dashbord with exist login and password from sut test data")
    void  shouldSuccessfulLogin() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfoWithTestData();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verifyVerificationPageVisiblity();
        var verificationCode = SQLHelter.getVerificationCode();
        verificationPage.vakidVerify(verificationCode.getCode());
    }

    @Test
    @DisplayName("Should get error notification if user is not exist in base")
    void shouldGetNotificationLoginWithRandomUserWithoutAddingToBase() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.generateRandomUser();
        loginPage.validLogin(authInfo);
        loginPage.verifyErrorNotificationVisiblity();
    }

    @Test
    @DisplayName("Should get error notification if login with exist in base and active user and random verification code")
    void shouldGetErroeNotificationIFLoginWithExistUserAndRandomVerificationCode() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfoWithTestData();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verifyVerificationPageVisiblity();
        var verificationCode = DataHelper.generateRandomVerificationCode();
        verificationPage.verify(DataHelper.VerificationCode.getCode());
        verificationPage.verifyErrorNotificationVisiblity();
    }

}
