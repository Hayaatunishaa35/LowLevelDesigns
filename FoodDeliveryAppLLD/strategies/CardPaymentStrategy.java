package strategies;

public class CardPaymentStrategy implements PaymentStrategy{
    private String cardNumber;

    public CardPaymentStrategy(String cardNumber){
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount){
        System.out.println("Amount "+ amount + " rupees paid via card number "+cardNumber);
    }
}
