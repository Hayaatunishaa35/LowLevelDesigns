package models;

public class DeliveryOrder extends Order{
    private String userAddress;

    public DeliveryOrder(){
        userAddress = "";
    }

    public void setUserAddress(String addr) {
        userAddress = addr;
    }

    public String getUserAddress() {
        return userAddress;
    }
    
    @Override
    public String getType(){
        return "Delivery";
    }
}
