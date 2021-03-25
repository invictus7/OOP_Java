package GraspPatterns.Delivery;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private List<Courier> courierList;

    Dispatcher(){
        this.courierList = new ArrayList<>();
    }

    public void addCourier(){
        courierList.add(new Courier(false));
    }

    public void delCourier(int ID){
        courierList.removeIf(courier -> ID == courier.getID());

    }

    public List<Courier> getCourierList() {
        return courierList;
    }

    public void updCourier(int ID, boolean Free){
        for (Courier courier: courierList){
            if (courier.getID() == ID){
                courier.setFree(Free);
            }
        }
    }



}
