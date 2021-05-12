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
    void shouldNotGiveDiscountWhenPurchaseIsUntil499(){
        //given
        double purchaseValue = 499.99;
        double expectedValue = 499.99;

        //when
        double purchaseWithDiscount = discountCalculator.calculatePurchaseWithDiscount(purchaseValue);

        //then
        Assertions.assertEquals(expectedValue, purchaseWithDiscount);
    }



}
