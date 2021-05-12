package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.netology.data.CardInfo;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class CreditPage {

    private SelenideElement cardNumber = $(byText("Номер карты")).parent().$(".input__control");
    private SelenideElement month = $(byText("Месяц")).parent().$(".input__control");
    private SelenideElement year = $(byText("Год")).parent().$(".input__control");
    private SelenideElement owner = $(byText("Владелец")).parent().$(".input__control");
    private SelenideElement cvc = $(byText("CVC/CVV")).parent().$(".input__control");
    private SelenideElement button = $(byText("Продолжить"));
    private SelenideElement heading = $(withText("Кредит по данным карты"));
    private SelenideElement statusOk = $(By.xpath("//div[@id='root']/div/div[2]/div[@class='notification__title']"));
    private SelenideElement statusError = $(By.xpath("//div[@id='root']/div/div[3]/div[@class='notification__title']"));
    private SelenideElement invalidField = $(".input__sub");

    public CreditPage() {
        heading.shouldBe(visible);
    }

    public void fillForm(CardInfo cardInfo) {
        cardNumber.setValue(cardInfo.getNumber());
        month.setValue(String.valueOf(cardInfo.getMonth()));
        year.setValue(String.valueOf(cardInfo.getYear()));
        owner.setValue(cardInfo.getOwner());
        cvc.setValue(cardInfo.getCvc());
        button.click();
    }

    public void getSuccessfulOperation() {
        statusOk.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void getRejectedOperation() {
        statusError.shouldBe(visible, Duration.ofSeconds(15));
    }

    public String getInvalidField() {
        return invalidField.getText();
    }

}


