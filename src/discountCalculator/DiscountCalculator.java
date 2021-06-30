package discountCalculator;

public class DiscountCalculator {

    public double calculatePurchaseWithDiscount(double purchaseValue) throws Exception {

        if(purchaseValue <= 0.0) {
            throw new Exception("Invalid Value");
        }

        if(purchaseValue <= 499.99){
            return purchaseValue - calculatePercent(purchaseValue, 5);
        } else if (purchaseValue >= 500.00 && purchaseValue < 1000.00) {
            return purchaseValue - calculatePercent(purchaseValue, 10);
        } else if (purchaseValue >= 1000.00) {
            return  purchaseValue - calculatePercent(purchaseValue, 20);
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
