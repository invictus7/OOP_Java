package GraspPatterns.SalesDepartment;

public class SalesLineItem {

    private int quantity;
    private ProductDesc productDesc;
    private double tax;
    private double ID;

    SalesLineItem(ProductDesc productDesc, int quantity) {
        this.productDesc = productDesc;
        this.quantity = quantity;
        this.ID = Math.random() * (100.0 - 0.0 + 1.0) + 0.0;;

    }

    public double getID() {
        return ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDesc getProductDesc() {
        return productDesc;
    }

    public double getSubTotal(boolean includeTax) {

        if (!includeTax){
            this.tax = 1;
        }

        return (productDesc.getPrice() * quantity
                - productDesc.getPrice() * quantity  / 100) * productDesc.getPrice() * quantity * tax;


    }
}
