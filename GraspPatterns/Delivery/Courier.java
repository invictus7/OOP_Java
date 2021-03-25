package GraspPatterns.Delivery;

public class Courier {

    private double ID;
    private boolean isFree;

    public Courier(boolean isFree){
        this.ID = Math.random() * (100.0 - 0.0 + 1.0) + 0.0;
        this.isFree = isFree;
    }

    public double getID() {
        return ID;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
