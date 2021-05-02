package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;


public class MainPage {

    private SelenideElement heading = $(withText("Путешествие дня"));
    private SelenideElement payment = $(byText("Купить"));
    private SelenideElement credit = $(byText("Купить в кредит"));

    public MainPage() {
        heading.shouldBe(visible);
    }

    public PaymentPage transferPaymentPage() {
        payment.click();
        return new PaymentPage();
    }

    public CreditPage transferCreditPage() {
        credit.click();
        return new CreditPage();
    }
}
