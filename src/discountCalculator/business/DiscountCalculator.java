package discountCalculator.business;

import discountCalculator.enums.DiscountEnum;

public class DiscountCalculator {

    public double calculatePurchaseWithDiscount(double purchaseValue) throws Exception {

        if(purchaseValue <= 0.0) {
            throw new Exception("Invalid Value");
        }

        for (DiscountEnum discount : DiscountEnum.values()) {
            if(discount.giveDiscount(purchaseValue) != -1) {
                return purchaseValue - calculatePercent(purchaseValue, discount.giveDiscount(purchaseValue));
            }
        }

        return 0d;
    }


    public double calculatePercent(double value, int percent) throws Exception {

        if(value <= 0.0 || percent <= 0) {
            throw new Exception("Invalid value");
        }
        return (value*percent)/100;
    }
}
