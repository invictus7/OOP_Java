package GraspPatterns.SalesDepartment;

import GraspPatterns.SalesDepartment.ProductDesc;
import GraspPatterns.SalesDepartment.SalesLineItem;

import java.util.List;

public class Discount {

    private List<SalesLineItem> salesLineItems;
    private double disc;
    private ProductDesc prodDesc;
    private int quantity;
    private double ID;

// переробити під сейлзлайнайтем
    Discount(double ID){
        for (SalesLineItem item: salesLineItems){
            if (ID == item.getID()){

                this.prodDesc = item.getProductDesc();
                this.quantity = item.getQuantity();
                this.disc = item.getSubTotal(true) * this.quantity / 2;
            }
        }
    }


    public double getDisc() {
        return disc;
    }

}
