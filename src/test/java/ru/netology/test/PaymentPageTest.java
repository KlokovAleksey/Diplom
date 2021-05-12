package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.DbHelper;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentPageTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUp() {
        String url = System.getProperty("http.url");
        open(url);
        DbHelper.cleanDataBase();
    }

    @Test
    void shouldApprovedCardOperation() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getApprovedCard());
        paymentPage.getSuccessfulOperation();
        assertEquals("APPROVED", DbHelper.getPaymentStatus());
    }

    @Test
    void shouldDeclinedCardOperation() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDeclinedCard());
        paymentPage.getRejectedOperation();
        assertEquals("DECLINED",DbHelper.getCreditStatus());
    }


    @Test
    void shouldDoubleNameInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDoubleNameInFieldOwnerApprovedCard());
        paymentPage.getSuccessfulOperation();
    }

    @Test
    void shouldDoubleNameInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDoubleNameInFieldOwnerDeclinedCard());
        paymentPage.getRejectedOperation();
    }

    @Test
    void shouldShortNameInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getShortNameInFieldOwnerApprovedCard());
        paymentPage.getSuccessfulOperation();
    }

    @Test
    void shouldShortNameInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getShortNameInFieldOwnerDeclinedCard());
        paymentPage.getRejectedOperation();
    }

    @Test
    void getInvalidFieldMessageEmptyFormPaymentPage() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getEmptyForm());
        paymentPage.getInvalidField();
        assertEquals("Неверный формат", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageMonthApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getInvalidMonthApprovedCard());
        assertEquals("Неверно указан срок действия карты", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageMonthDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getInvalidMonthDeclinedCard());
        assertEquals("Неверно указан срок действия карты", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageBygoneMonthApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getBygoneMonthApprovedCard());
        assertEquals("Неверно указан срок действия карты", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageBygoneMonthDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getBygoneMonthDeclinedCard());
        assertEquals("Неверно указан срок действия карты", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageIncompleteFieldPaymentPage() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getIncompleteField());
        assertEquals("Неверный формат", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageSpecialCharactersInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getSpecialCharactersInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageSpecialCharactersInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getSpecialCharactersInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageOneSymbolInFieldApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getOneSymbolInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageOneSymbolInFieldDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getOneSymbolInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageNumberInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getNumberInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageNumberInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getNumberInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageDoubleDashInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDoubleDashInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageDoubleDashInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDoubleDashInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessagedBygoneYearApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getBygoneYearApprovedCard());
        assertEquals("Истёк срок действия карты", paymentPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageBygoneYearDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getBygoneYearDeclinedCard());
        assertEquals("Истёк срок действия карты", paymentPage.getInvalidField());
    }

}
