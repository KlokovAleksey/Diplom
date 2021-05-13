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
        paymentPage.verifySuccessfulOperation();
        assertEquals("APPROVED", DbHelper.getPaymentStatus());
    }

    @Test
    void shouldDeclinedCardOperation() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDeclinedCard());
        paymentPage.verifyRejectedOperation();
        assertEquals("DECLINED",DbHelper.getCreditStatus());
    }


    @Test
    void shouldDoubleNameInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDoubleNameInFieldOwnerApprovedCard());
        paymentPage.verifySuccessfulOperation();
    }

    @Test
    void shouldDoubleNameInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDoubleNameInFieldOwnerDeclinedCard());
        paymentPage.verifyRejectedOperation();
    }

    @Test
    void shouldShortNameInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getShortNameInFieldOwnerApprovedCard());
        paymentPage.verifySuccessfulOperation();
    }

    @Test
    void shouldShortNameInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getShortNameInFieldOwnerDeclinedCard());
        paymentPage.verifyRejectedOperation();
    }

    @Test
    void shouldInvalidFieldMessageEmptyFormPaymentPage() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getEmptyForm());
        paymentPage.getInvalidFieldMessage();
        assertEquals("Неверный формат", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageMonthApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getInvalidMonthApprovedCard());
        assertEquals("Неверно указан срок действия карты", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageMonthDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getInvalidMonthDeclinedCard());
        assertEquals("Неверно указан срок действия карты", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageBygoneMonthApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getBygoneMonthApprovedCard());
        assertEquals("Неверно указан срок действия карты", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageBygoneMonthDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getBygoneMonthDeclinedCard());
        assertEquals("Неверно указан срок действия карты", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageIncompleteFieldPaymentPage() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getIncompleteField());
        assertEquals("Неверный формат", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageSpecialCharactersInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getSpecialCharactersInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageSpecialCharactersInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getSpecialCharactersInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageOneSymbolInFieldApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getOneSymbolInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageOneSymbolInFieldDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getOneSymbolInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageNumberInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getNumberInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageNumberInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getNumberInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageDoubleDashInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDoubleDashInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageDoubleDashInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDoubleDashInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessagedBygoneYearApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getBygoneYearApprovedCard());
        assertEquals("Истёк срок действия карты", paymentPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageBygoneYearDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getBygoneYearDeclinedCard());
        assertEquals("Истёк срок действия карты", paymentPage.getInvalidFieldMessage());
    }

}
