package discountCalculator;

public class DiscountCalculator {

    public double calculatePurchaseWithDiscount(double purchaseValue) {
        if(purchaseValue <= 499.99){
            return purchaseValue;
        }
        return 0d;
    }
}
