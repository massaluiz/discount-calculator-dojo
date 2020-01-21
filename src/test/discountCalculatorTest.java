package test;

import discountCalculator.DiscountCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class discountCalculatorTest {
    DiscountCalculator discountCalculator = new DiscountCalculator();

    @Test
    public void notGiveDiscountWhenSaleValueIsLessThan499(){
        double salesValue = 499.99;
        double finalValue = 499.99;

        Assertions.assertEquals(finalValue, discountCalculator.calculateSalesFinalValue(salesValue));
    }
}
