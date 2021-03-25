package GraspPatterns.Delivery;

public class LocationList {

    Location location;


    LocationList(Location location){
        this.location = location;


    }

    public String getLocation() {
        return location.getStreet();
    }

    public double getPriceByLocation(){
        double total = 0.0;
        if (location.getStreet().startsWith("A"))
        {
            total = 1.0;
        }
        else{
            total = 5.0;
        }

        return total;

    }


}
