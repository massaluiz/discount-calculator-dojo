package discountCalculator.enums;

public enum DiscountEnum {
    FIVE_PERCENT_DISCOUNT {
        @Override
        public int giveDiscount(double purchaseValue) {
            int discount = -1;
            if(purchaseValue < 500) {
                discount = 5;
            }
            return discount;
        }
    },
    TEN_PERCENT_DISCOUNT {
        @Override
        public int giveDiscount(double purchaseValue) {
            int discount = -1;
            if(purchaseValue >= 500.00 && purchaseValue < 1000.00) {
                discount = 10;
            }
            return discount;
        }
    },
    TWENTY_PERCENT_DISCOUNT {
        @Override
        public int giveDiscount(double purchaseValue) {
            int discount = -1;
            if(purchaseValue >= 1000.00) {
                discount = 20;
            }
            return discount;
        }


    };
    public abstract int giveDiscount(double purshaseValue);
}
