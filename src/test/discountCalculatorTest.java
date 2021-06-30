package test;

import discountCalculator.business.DiscountCalculator;
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
    void shouldGiveTenPercentDiscountWhenPurchaseStartIn500() throws Exception {

        double purchaseValue = 500.00;
        double expectedValue = 450.00;

        double purchaseWithTenPercentDiscount = discountCalculator.calculatePurchaseWithDiscount(purchaseValue);

        Assertions.assertEquals(expectedValue, purchaseWithTenPercentDiscount);

    }

    @Test
    void shouldGiveTenPercentDiscountWhenPurchaseStartMajor500Until1000() throws Exception {

        double purchaseValue = 750.00;
        double expectedValue = 675.00;

        double purchaseWithTenPercentDiscount = discountCalculator.calculatePurchaseWithDiscount(purchaseValue);

        Assertions.assertEquals(expectedValue, purchaseWithTenPercentDiscount);

    }

    @Test
    void shouldGiveTwentyPercentDiscountWhenPurchaseStartIn1000() throws Exception {

        double purchaseValue = 1000.00;
        double expectedValue = 800.00;

        double purchaseWithTwentyPercentDiscount = discountCalculator.calculatePurchaseWithDiscount(purchaseValue);

        Assertions.assertEquals(expectedValue, purchaseWithTwentyPercentDiscount);

    }

    @Test
    void shouldGiveTwentyPercentDiscountWhenPurchaseStartMajor1300() throws Exception {

        double purchaseValue = 1300.00;
        double expectedValue = 1040.00;

        double purchaseWithTwentyPercentDiscount = discountCalculator.calculatePurchaseWithDiscount(purchaseValue);

        Assertions.assertEquals(expectedValue, purchaseWithTwentyPercentDiscount);

    }


    @Test
    void shouldGiveFivePercentDiscountWhenPurchaseIsLess500() throws Exception {

        double purchaseValue = 100.00;
        double expectedValue = 95.00;

        double purchaseWithFivePercentDiscount = discountCalculator.calculatePurchaseWithDiscount(purchaseValue);

        Assertions.assertEquals(expectedValue, purchaseWithFivePercentDiscount);

    }


    @Test
    void shouldThrownExceptionWhenPurchaseValueIsZero() {

        double purchaseValue = 0;
        String expectedMessage = "Invalid Value";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            discountCalculator.calculatePurchaseWithDiscount(purchaseValue);
        });
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void shouldThrownExceptionWhenPurchaseValueIsNegative() {

        double purchaseValue = -200.50;
        String expectedMessage = "Invalid Value";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            discountCalculator.calculatePurchaseWithDiscount(purchaseValue);
        });
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }


    @Test
    void shouldThrownExceptionWhenPercentIsZero() {

        int percent = 0;
        double value = 100;
        String expectedMessage = "Invalid value";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            discountCalculator.calculatePercent(value, percent);
        });
        String actualMessage = exception.getMessage();


        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldThrownExceptionWhenPercentIsNegative() {

        int percent = -15;
        double value = 100;
        String expectedMessage = "Invalid value";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            discountCalculator.calculatePercent(value, percent);
        });
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void shouldReturn20WhenValueIs100() throws Exception {

        int percent = 20;
        double value = 100;
        double expectedValue = 20;

        double purchaseWithFivePercentDiscount = discountCalculator.calculatePercent(value, percent);

        Assertions.assertEquals(expectedValue, purchaseWithFivePercentDiscount);

    }

    @Test
    void shouldThrownExceptionWhenValueIsZero() {

        int percent = 50;
        double value = 0.0;
        String expectedMessage = "Invalid value";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            discountCalculator.calculatePercent(value, percent);
        });
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldThrownExceptionWhenValueIsNegative() {

        int percent = 50;
        double value = -100;
        String expectedMessage = "Invalid value";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            discountCalculator.calculatePercent(value, percent);
        });
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

}
