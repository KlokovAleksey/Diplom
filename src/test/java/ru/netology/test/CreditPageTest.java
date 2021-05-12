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
import ru.netology.page.CreditPage;
import ru.netology.page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditPageTest {

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
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getApprovedCard());
        creditPage.getSuccessfulOperation();
        assertEquals("APPROVED", DbHelper.getPaymentStatus());
    }

    @Test
    void shouldDeclinedCardOperation() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getDeclinedCard());
        creditPage.getRejectedOperation();
        assertEquals("DECLINED",DbHelper.getCreditStatus());
    }


    @Test
    void shouldDoubleNameInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getDoubleNameInFieldOwnerApprovedCard());
        creditPage.getSuccessfulOperation();
    }

    @Test
    void shouldDoubleNameInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getDoubleNameInFieldOwnerDeclinedCard());
        creditPage.getRejectedOperation();
    }

    @Test
    void shouldShortNameInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getShortNameInFieldOwnerApprovedCard());
        creditPage.getSuccessfulOperation();
    }

    @Test
    void shouldShortNameInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getShortNameInFieldOwnerDeclinedCard());
        creditPage.getRejectedOperation();
    }

    @Test
    void getInvalidFieldMessageEmptyFormCreditPage() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getEmptyForm());
        creditPage.getInvalidField();
        assertEquals("Неверный формат", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageInvalidMonthApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getInvalidMonthApprovedCard());
        assertEquals("Неверно указан срок действия карты", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageInvalidMonthDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getInvalidMonthDeclinedCard());
        assertEquals("Неверно указан срок действия карты", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageBygoneMonthApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getBygoneMonthApprovedCard());
        assertEquals("Неверно указан срок действия карты", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageBygoneMonthDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getBygoneMonthDeclinedCard());
        assertEquals("Неверно указан срок действия карты", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageIncompleteFieldCreditPage() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getIncompleteField());
        assertEquals("Неверный формат", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageSpecialCharactersInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getSpecialCharactersInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageSpecialCharactersInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getSpecialCharactersInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageOneSymbolInFieldApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getOneSymbolInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageOneSymbolInFieldDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getOneSymbolInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageNumberInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getNumberInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageNumberInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getNumberInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageDoubleDashInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getDoubleDashInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageDoubleDashInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getDoubleDashInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageBygoneYearApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getBygoneYearApprovedCard());
        assertEquals("Истёк срок действия карты", creditPage.getInvalidField());
    }

    @Test
    void getInvalidFieldMessageBygoneYearDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getBygoneYearDeclinedCard());
        assertEquals("Истёк срок действия карты", creditPage.getInvalidField());
    }

}
