package strategies;

public class UpiPaymentStrategy implements PaymentStrategy{
    private String upiId;

    public UpiPaymentStrategy(String upiId){
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount){
        System.out.println("Amount "+ amount + " rupees paid via upi id "+upiId);
    }

}
