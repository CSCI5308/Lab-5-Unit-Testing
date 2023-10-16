package model;

import utils.InsufficientFundsException;
import utils.Printer;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Checkout {

    private static final int MIN_POINTS_DISCOUNT = 1000;
    private static final double POINTS_DISCOUNT = 0.07;
    private static final double LOYALTY_DISCOUNT = 0.05;
    private static final int LOYALTY_YEARS = 1;
    private static final double HST_RATE = 0.15;
    private Customer customer;

    public Checkout(Customer customer) {
        this.customer = customer;
    }

    public boolean isEligibleForLoyaltyDiscount() {
        return ChronoUnit.YEARS.between(this.customer.getJoinedOn(), LocalDateTime.now()) >= LOYALTY_YEARS;
    }

    public boolean isEligibleForPointsDiscount() {
        int currentPoints = this.customer.getPoints();
        int shoppingCartPoints = this.customer.getShoppingCart().getPoints();

        return (currentPoints+shoppingCartPoints) >= MIN_POINTS_DISCOUNT;
    }

    public double calculateOrderWithDiscounts() {
        double total = this.customer.getShoppingCart().getTotal();
        double totalDiscount = 0.0;

        if (isEligibleForPointsDiscount()) {
            totalDiscount += POINTS_DISCOUNT;
        }

        if (isEligibleForLoyaltyDiscount()) {
            totalDiscount += LOYALTY_DISCOUNT;
        }

        total = total - (total * totalDiscount);

        return total;

    }

    public void processOrder() throws InsufficientFundsException {
        double customerBalance = this.customer.getBalance();
        double totalBeforeTax = calculateOrderWithDiscounts();

        double totalAfterTax = totalBeforeTax + (totalBeforeTax * HST_RATE);

        if (customerBalance < totalAfterTax) {
            throw new InsufficientFundsException("Insufficient Funds");
        }

        int totalPoints = this.customer.getPoints() + this.customer.getShoppingCart().getPoints();
        this.customer.setPoints(totalPoints);


        Printer.checkoutPrinter(this.customer.getShoppingCart(), totalAfterTax);
    }

}
