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
        creditPage.verifySuccessfulOperation();
        assertEquals("APPROVED", DbHelper.getPaymentStatus());
    }

    @Test
    void shouldDeclinedCardOperation() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getDeclinedCard());
        creditPage.verifyRejectedOperation();
        assertEquals("DECLINED",DbHelper.getCreditStatus());
    }


    @Test
    void shouldDoubleNameInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getDoubleNameInFieldOwnerApprovedCard());
        creditPage.verifySuccessfulOperation();
    }

    @Test
    void shouldDoubleNameInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getDoubleNameInFieldOwnerDeclinedCard());
        creditPage.verifyRejectedOperation();
    }

    @Test
    void shouldShortNameInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getShortNameInFieldOwnerApprovedCard());
        creditPage.verifySuccessfulOperation();
    }

    @Test
    void shouldShortNameInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getShortNameInFieldOwnerDeclinedCard());
        creditPage.verifyRejectedOperation();
    }

    @Test
    void shouldInvalidFieldMessageEmptyFormCreditPage() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getEmptyForm());
        creditPage.getInvalidFieldMessage();
        assertEquals("???????????????? ????????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageInvalidMonthApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getInvalidMonthApprovedCard());
        assertEquals("?????????????? ???????????? ???????? ???????????????? ??????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageInvalidMonthDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getInvalidMonthDeclinedCard());
        assertEquals("?????????????? ???????????? ???????? ???????????????? ??????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageBygoneMonthApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getBygoneMonthApprovedCard());
        assertEquals("?????????????? ???????????? ???????? ???????????????? ??????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageBygoneMonthDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getBygoneMonthDeclinedCard());
        assertEquals("?????????????? ???????????? ???????? ???????????????? ??????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageIncompleteFieldCreditPage() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getIncompleteField());
        assertEquals("???????????????? ????????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageSpecialCharactersInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getSpecialCharactersInFieldOwnerApprovedCard());
        assertEquals("???????????????? ????????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageSpecialCharactersInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getSpecialCharactersInFieldOwnerDeclinedCard());
        assertEquals("???????????????? ????????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageOneSymbolInFieldApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getOneSymbolInFieldOwnerApprovedCard());
        assertEquals("???????????????? ????????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageOneSymbolInFieldDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getOneSymbolInFieldOwnerDeclinedCard());
        assertEquals("???????????????? ????????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageNumberInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getNumberInFieldOwnerApprovedCard());
        assertEquals("???????????????? ????????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageNumberInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getNumberInFieldOwnerDeclinedCard());
        assertEquals("???????????????? ????????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageDoubleDashInFieldOwnerApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getDoubleDashInFieldOwnerApprovedCard());
        assertEquals("???????????????? ????????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageDoubleDashInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getDoubleDashInFieldOwnerDeclinedCard());
        assertEquals("???????????????? ????????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageBygoneYearApprovedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getBygoneYearApprovedCard());
        assertEquals("?????????? ???????? ???????????????? ??????????", creditPage.getInvalidFieldMessage());
    }

    @Test
    void shouldInvalidFieldMessageBygoneYearDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferCreditPage();
        val creditPage = new CreditPage();
        creditPage.fillForm(DataHelper.getBygoneYearDeclinedCard());
        assertEquals("?????????? ???????? ???????????????? ??????????", creditPage.getInvalidFieldMessage());
    }

}
