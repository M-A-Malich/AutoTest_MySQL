package ru.netology.mode;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private static Faker faker =new Faker(new Locale("en"));
    private DataHelper() {
    }
    private static AuthInfo getAuthInfoWithTestData() {
        return new AuthInfo("vasya", "qwerty123");
    }
    private static String generateRandomLogin() {
        return faker.name().username();
    }
    private static String generateRandomPassword() {
        return faker.internet().password();
    }
    private static String generateRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }
    private static VerificationCode generateRandomVerificationCode() {
        return new VerificationCode(faker.numerify("######"));
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
    @Value
    public static class VerificationCode {
        String code;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthInfo {
        private String id;
        private String user_id;
        private String code;
        private String created;
    }

}
