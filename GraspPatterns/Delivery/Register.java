package GraspPatterns;


import GraspPatterns.Delivery.Courier;
import GraspPatterns.Delivery.Delivery;
import GraspPatterns.Delivery.LocationList;
import GraspPatterns.SalesDepartment.Catalog;
import GraspPatterns.SalesDepartment.ProductDesc;
import GraspPatterns.SalesDepartment.Sale;

import java.util.*;
import java.util.stream.Collectors;

public class Register {

    private List<Sale> sales;
    private Catalog catalog;
    private List<Delivery> deliveries;

    public Register(List<Sale> sales) {
        this.sales = sales;

    }




    public boolean makePaymentDel(double amount, double ID ){
        for(Delivery delivery: deliveries){
            if (delivery.getID() == ID){
                if (amount >= delivery.getPriceByLocAndSale(delivery.getSale(), delivery.getLocation())){
                            delivery.addPayment(new Payment(amount));
                            return true;
                }
            }
        }
        return false;

    }

    public void createDelivery(double ID, LocationList location){
        for (Sale sale: sales){
            if (sale.getID() == ID){
                deliveries.add(new Delivery(sale, location, new Courier(false)));
            }
        }

    }




    public double getTotalBalance(boolean hasTax) {
        double total = 0.0;
        for (Sale item : sales) {
            total = total + item.getTotal(hasTax);
        }
        return total;

    }


    public String makePayment(double amount, int saleId) {
        List<Sale> selectedSale = sales.stream().filter(sl -> sl.getID() == saleId).collect(Collectors.toList());
        if (selectedSale.isEmpty()) throw new NoSuchElementException("Sale with id " + saleId + " nor found!!");
        Sale current = selectedSale.get(0);
        current.receivePayment(new Payment(amount));

        return current.isPaid() ? "PAID" : "NOT PAID";
    }




    public Sale getSaleByID(int saleID){

        for (Sale item: sales){
            if (item.getID() == saleID){
                return item;
            }
        }
        return null;
    }

    public void addItemToSale(int saleID, int itemID, int quantity) {
        if (quantity > 0) {
            ProductDesc productDesc = catalog.searchProdDesc(itemID);
            Sale sale = getSaleByID(saleID);
            sale.addLineItem(productDesc, quantity);
        }
    }



}
