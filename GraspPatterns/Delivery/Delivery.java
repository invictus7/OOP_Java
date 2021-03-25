package GraspPatterns.Delivery;

import GraspPatterns.Payment;
import GraspPatterns.SalesDepartment.Sale;

import java.util.List;

public class Delivery {

    private Sale sale;
    private LocationList location;
    private Courier courier;
    private List<Payment> payments;
    private double ID;
    // how to do better? update couries via dispatcher or directly
    private List<Dispatcher> dispatchers;


    public Delivery(Sale sale, LocationList location, Courier courier){
        this.sale = sale;
        this.location = location;
        this.courier = courier;
        this.ID = Math.random() * (100.0 - 0.0 + 1.0) + 0.0;
    }

    public double getPriceByLocAndSale(Sale sale, LocationList location){

        return sale.getTotal(true) + sale.getTotalWithDisc(true) + location.getPriceByLocation();
    }

    public double getID() {
        return ID;
    }

    // have two similar methods: addPayment in Delivery and checkIfPaid
    public boolean addPayment(Payment some){
        return payments.add(some);
    }

    public void setFree(){
        courier.setFree(true);
    }

    public Sale getSale() {
        return sale;
    }


    public LocationList getLocation() {
        return location;
    }
}

//todo 1. Delivery(Sale, Location, cuirer)
//todo 2. Register -> create Delivery -> makePayment
//todo 3. Dispatcher -> CRUD Courier