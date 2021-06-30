package test;

import discountCalculator.DiscountCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class discountCalculatorTest {

    DiscountCalculator discountCalculator;

    @BeforeEach
    void setUp(){
        discountCalculator = new DiscountCalculator();
    }

    @Test
    void shouldNotGiveDiscountWhenPurchaseIsUntil499() throws Exception {
        //given
        double purchaseValue = 499.99;
        double expectedValue = 499.99;

        //when
        double purchaseWithDiscount = discountCalculator.calculatePurchaseWithDiscount(purchaseValue);

        //then
        Assertions.assertEquals(expectedValue, purchaseWithDiscount);
    }

    @Test
    void shouldGiveTenPercentDiscountWhenPurchaseStartIn500() throws Exception {

        //given
        double purchaseValue = 500.00;
        double expectedValue = 450.00;

        //when
        double purchaseWithTenPercentDiscount = discountCalculator.calculatePurchaseWithDiscount(purchaseValue);

        //then
        Assertions.assertEquals(expectedValue, purchaseWithTenPercentDiscount);

    }

    @Test
    void shouldGiveTenPercentDiscountWhenPurchaseStartMajor500Until1000() throws Exception {

        //given
        double purchaseValue = 750.00;
        double expectedValue = 675.00;

        //when
        double purchaseWithTenPercentDiscount = discountCalculator.calculatePurchaseWithDiscount(purchaseValue);

        //then
        Assertions.assertEquals(expectedValue, purchaseWithTenPercentDiscount);

    }

    @Test
    void shouldGiveTwentyPercentDiscountWhenPurchaseStartIn1000() throws Exception {

        //given
        double purchaseValue = 1000.00;
        double expectedValue = 800.00;

        //when
        double purchaseWithTwentyPercentDiscount = discountCalculator.calculatePurchaseWithDiscount(purchaseValue);

        //then
        Assertions.assertEquals(expectedValue, purchaseWithTwentyPercentDiscount);

    }

    @Test
    void shouldGiveTwentyPercentDiscountWhenPurchaseStartMajor1300() throws Exception {

        //given
        double purchaseValue = 1300.00;
        double expectedValue = 1040.00;

        //when
        double purchaseWithTwentyPercentDiscount = discountCalculator.calculatePurchaseWithDiscount(purchaseValue);

        //then
        Assertions.assertEquals(expectedValue, purchaseWithTwentyPercentDiscount);

    }


    @Test
    void shouldGiveFivePercentDiscountWhenPurchaseIsLess500() throws Exception {

        //given
        double purchaseValue = 100.00;
        double expectedValue = 95.00;

        //when
        double purchaseWithFivePercentDiscount = discountCalculator.calculatePurchaseWithDiscount(purchaseValue);

        //then
        Assertions.assertEquals(expectedValue, purchaseWithFivePercentDiscount);

    }


    @Test
    void shouldThrownExceptionWhenPurchaseValueIsZero() {

        //given
        double purchaseValue = 0;
        String expectedMessage = "Invalid Value";

        //when
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            discountCalculator.calculatePurchaseWithDiscount(purchaseValue);
        });
        String actualMessage = exception.getMessage();


        //then
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void shouldThrownExceptionWhenPurchaseValueIsNegative() {

        //given
        double purchaseValue = -200.50;
        String expectedMessage = "Invalid Value";

        //when
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            discountCalculator.calculatePurchaseWithDiscount(purchaseValue);
        });
        String actualMessage = exception.getMessage();


        //then
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }


    @Test
    void shouldThrownExceptionWhenPercentIsZero() {

        //given
        int percent = 0;
        double value = 100;
        String expectedMessage = "Invalid value";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            discountCalculator.calculatePercent(value, percent);
        });
        String actualMessage = exception.getMessage();


        //then
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldThrownExceptionWhenPercentIsNegative() {

        //given
        int percent = -15;
        double value = 100;
        String expectedMessage = "Invalid value";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            discountCalculator.calculatePercent(value, percent);
        });
        String actualMessage = exception.getMessage();


        //then
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void shouldReturn20WhenValueIs100() throws Exception {

        //given
        int percent = 20;
        double value = 100;
        double expectedValue = 20;

        //when
        double purchaseWithFivePercentDiscount = discountCalculator.calculatePercent(value, percent);

        //then
        Assertions.assertEquals(expectedValue, purchaseWithFivePercentDiscount);

    }

    @Test
    void shouldThrownExceptionWhenValueIsZero() {

        //given
        int percent = 50;
        double value = 0.0;
        String expectedMessage = "Invalid value";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            discountCalculator.calculatePercent(value, percent);
        });
        String actualMessage = exception.getMessage();


        //then
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldThrownExceptionWhenValueIsNegative() {

        //given
        int percent = 50;
        double value = -100;
        String expectedMessage = "Invalid value";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            discountCalculator.calculatePercent(value, percent);
        });
        String actualMessage = exception.getMessage();


        //then
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }





}
