package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.CreditPage;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentPageTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @Test
    void shouldApprovedCardOperation() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getApprovedCard());
        paymentPage.successfulOperation();
    }

    @Test
    void shouldDeclinedCardOperation() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDeclinedCard());
        paymentPage.rejectedOperation();
    }


    @Test
    void shouldDoubleNameInFieldOwnerApprovedCard(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDoubleNameInFieldOwnerApprovedCard());
        paymentPage.successfulOperation();
    }

    @Test
    void shouldDoubleNameInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getDoubleNameInFieldOwnerDeclinedCard());
        paymentPage.rejectedOperation();
    }

    @Test
    void shouldShortNameInFieldOwnerApprovedCard(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getShortNameInFieldOwnerApprovedCard());
        paymentPage.successfulOperation();
    }

    @Test
    void shouldShortNameInFieldOwnerDeclinedCard() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getShortNameInFieldOwnerDeclinedCard());
        paymentPage.rejectedOperation();
    }

    @Test
    void shouldEmptyFormPaymentPage() {
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getEmptyForm());
        paymentPage.shouldInvalidField();
        assertEquals("Неверный формат",paymentPage.shouldInvalidField());
    }

    @Test
    void shouldInvalidMonthApprovedCard(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getInvalidMonthApprovedCard());
        assertEquals("Неверно указан срок действия карты",paymentPage.shouldInvalidField());
    }

    @Test
    void shouldInvalidMonthDeclinedCard(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getInvalidMonthDeclinedCard());
        assertEquals("Неверно указан срок действия карты",paymentPage.shouldInvalidField());
    }

    @Test
    void shouldBygoneMonthApprovedCard(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getBygoneMonthApprovedCard());
        assertEquals("Неверно указан срок действия карты",paymentPage.shouldInvalidField());
    }

    @Test
    void shouldBygoneMonthDeclinedCard(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getBygoneMonthDeclinedCard());
        assertEquals("Неверно указан срок действия карты",paymentPage.shouldInvalidField());
    }

    @Test
    void shouldIncompleteFieldPaymentPage(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getIncompleteField());
        assertEquals("Неверный формат",paymentPage.shouldInvalidField());
    }

    @Test
    void shouldSpecialCharactersInFieldOwnerApprovedCard(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getSpecialCharactersInFieldOwnerApprovedCard());
        assertEquals("Неверный формат",paymentPage.shouldInvalidField());
    }

    @Test
    void shouldSpecialCharactersInFieldOwnerDeclinedCard(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getSpecialCharactersInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат",paymentPage.shouldInvalidField());
    }

    @Test
    void shouldOneSymbolInFieldApprovedCard(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getOneSymbolInFieldOwnerApprovedCard());
        assertEquals("Неверный формат",paymentPage.shouldInvalidField());
    }

    @Test
    void shouldOneSymbolInFieldDeclinedCard(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getOneSymbolInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат",paymentPage.shouldInvalidField());
    }

    @Test
    void shouldNumberInFieldOwnerApprovedCard(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getNumberInFieldOwnerApprovedCard());
        assertEquals("Неверный формат",paymentPage.shouldInvalidField());
    }

    @Test
    void shouldNumberInFieldOwnerDeclinedCard(){
        MainPage mainPage = new MainPage();
        mainPage.transferPaymentPage();
        val paymentPage = new PaymentPage();
        paymentPage.fillForm(DataHelper.getNumberInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат",paymentPage.shouldInvalidField());
    }



}
