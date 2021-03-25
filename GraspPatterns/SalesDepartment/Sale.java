package GraspPatterns.SalesDepartment;

import GraspPatterns.Payment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sale {

    private LocalDateTime date;
    private List<SalesLineItem> salesLineItems;
    private List<Payment> payments;
    private double ID;
    private Discount discount;



    public Sale() {
        this.salesLineItems = new ArrayList<>();
        this.date = LocalDateTime.now();
        this.ID = Math.random() * (100.0 - 0.0 + 1.0) + 0.0;
    }

    public List<SalesLineItem> getSalesLineItems() {
        return salesLineItems;
    }

    public double getTotalWithDisc(boolean hasTax){
        double total = 0.0;
        for (SalesLineItem item: salesLineItems){
            Discount discount = new Discount(item.getID());
            total = total + item.getSubTotal(hasTax) + discount.getDisc();
        }
        return total;
    }



    public boolean isPaid(){

        return getTotal(true) <= getTotalPaymentsAmount();

    }

    public double getTotalPaymentsAmount(){
        double total = 0.0;
        for(Payment payment: payments){
            total = payment.getAmount() + total;
        }

        return total;
    }
// чи можна об'єднати ці функції?
    public void createPayment(double amount) {
        payments.add(new Payment(amount));

    }

    public void receivePayment(Payment some)
    {
        payments.add(some);
    }
    public double getID() {
        return ID;
    }

    public double getTotal(boolean hasTax) {
        double total = 0.0;

        for (SalesLineItem item : salesLineItems) {
            total = item.getSubTotal(hasTax) + total;
        }
        return total;
    }



    public void addLineItem(ProductDesc productDesc, int quantity) {
        salesLineItems.add(new SalesLineItem(productDesc, quantity));

    }




}
