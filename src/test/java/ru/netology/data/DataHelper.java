package ru.netology.data;

import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;

public class DataHelper {

    private DataHelper() {
    }


    public static String getMonth() {
        LocalDate localDate = LocalDate.now();
        return String.format("%02d", localDate.getMonthValue());
    }

    public static String getBygoneMonth() {
        LocalDate localDate = LocalDate.now();
        int month = localDate.minusMonths(1).getMonthValue();
        return String.format("%02d", month);
    }

    public static String getYear() {
        DateFormat df = new SimpleDateFormat("yy");
        String formattedDate = ((SimpleDateFormat) df).format(Calendar.getInstance().getTime());
        return formattedDate;
    }

    public static String getBygoneYear() {
        LocalDate localDate = LocalDate.now();
        int year = localDate.minusYears(1).getYear();
        return String.format("%02d", year);
    }

    public static String getName() {
        Faker faker = new Faker();
        String name = faker.name().firstName() + " " + faker.name().lastName();
        return name;
    }

    public static String getDoubleName() {
        Faker faker = new Faker();
        String name = faker.name().firstName() + " " + faker.name().lastName() + "-" + faker.name().lastName();
        return name;
    }

    public static String getDoubleDashInName(){
        Faker faker = new Faker();
        String name = faker.name().firstName() + " " + faker.name().lastName() + "-" + "-" + faker.name().lastName();
        return name;
    }

    public static String getCvc() {
        Random random = new Random();
        int cvc = random.nextInt((1000 - 1));
        return String.format("%03d", cvc);
    }

    public static String getApprovedCardNumber() {
        String cardNumber = "4444 4444 4444 4441";
        return cardNumber;
    }

    public static String getDeclinedCardNumber() {
        String cardNumber = "4444 4444 4444 4442";
        return cardNumber;
    }

    public static CardInfo getApprovedCard() {
        return new CardInfo(getApprovedCardNumber(), getMonth(), getYear(), getName(), getCvc());
    }

    public static CardInfo getDeclinedCard() {
        return new CardInfo(getDeclinedCardNumber(), getMonth(), getYear(), getName(), getCvc());
    }

    public static CardInfo getDoubleNameInFieldOwnerApprovedCard() {
        return new CardInfo(getApprovedCardNumber(), getMonth(), getYear(), getDoubleName(), getCvc());
    }

    public static CardInfo getDoubleNameInFieldOwnerDeclinedCard() {
        return new CardInfo(getDeclinedCardNumber(), getMonth(), getYear(), getDoubleName(), getCvc());
    }

    public static CardInfo getShortNameInFieldOwnerApprovedCard() {
        return new CardInfo(getApprovedCardNumber(), getMonth(), getYear(), "Li", getCvc());
    }

    public static CardInfo getShortNameInFieldOwnerDeclinedCard() {
        return new CardInfo(getDeclinedCardNumber(), getMonth(), getYear(), "Li", getCvc());
    }

    public static CardInfo getEmptyForm() {
        return new CardInfo();
    }

    public static CardInfo getInvalidMonthApprovedCard() {
        return new CardInfo(getApprovedCardNumber(), "13", getYear(), getName(), getCvc());
    }

    public static CardInfo getInvalidMonthDeclinedCard() {
        return new CardInfo(getDeclinedCardNumber(), "13", getYear(), getName(), getCvc());
    }

    public static CardInfo getBygoneMonthApprovedCard() {
        return new CardInfo(getApprovedCardNumber(), getBygoneMonth(), getYear(), getName(), getCvc());
    }

    public static CardInfo getBygoneMonthDeclinedCard() {
        return new CardInfo(getDeclinedCardNumber(), getBygoneMonth(), getYear(), getName(), getCvc());
    }

    public static CardInfo getIncompleteField() {
        return new CardInfo("4444 4444 4444 444", "1", "2", "A", "11");
    }

    public static CardInfo getSpecialCharactersInFieldOwnerApprovedCard() {
        return new CardInfo(getApprovedCardNumber(), getMonth(), getYear(), "<#%^*&$@>", getCvc());
    }

    public static CardInfo getSpecialCharactersInFieldOwnerDeclinedCard() {
        return new CardInfo(getDeclinedCardNumber(), getMonth(), getYear(), "<#%^*&$@>", getCvc());
    }

    public static CardInfo getOneSymbolInFieldOwnerApprovedCard() {
        return new CardInfo(getApprovedCardNumber(), getMonth(), getYear(), "I", getCvc());
    }

    public static CardInfo getOneSymbolInFieldOwnerDeclinedCard() {
        return new CardInfo(getDeclinedCardNumber(), getMonth(), getYear(), "I", getCvc());
    }

    public static CardInfo getNumberInFieldOwnerApprovedCard() {
        return new CardInfo(getApprovedCardNumber(), getMonth(), getYear(), "86573737264", getCvc());
    }

    public static CardInfo getNumberInFieldOwnerDeclinedCard() {
        return new CardInfo(getDeclinedCardNumber(), getMonth(), getYear(), "86573737264", getCvc());
    }

    public static CardInfo getDoubleDashInFieldOwnerApprovedCard(){
        return new CardInfo(getApprovedCardNumber(), getMonth(), getYear(), getDoubleDashInName() , getCvc());
    }

    public static CardInfo getDoubleDashInFieldOwnerDeclinedCard(){
        return new CardInfo(getDeclinedCardNumber(), getMonth(), getYear(), getDoubleDashInName() , getCvc());
    }

    public static CardInfo getBygoneYearApprovedCard(){
        return new CardInfo(getApprovedCardNumber(), getMonth(), getBygoneYear(), getName() , getCvc());
    }

    public static CardInfo getBygoneYearDeclinedCard(){
        return new CardInfo(getApprovedCardNumber(), getMonth(), getBygoneYear(), getName() , getCvc());
    }
}



