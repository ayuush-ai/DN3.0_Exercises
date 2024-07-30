// Save this file as AdapterPatternExample.java

// Step 2: Define Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Step 3: Implement Adaptee Classes

// Adaptee Class 1: PayPal
class PayPal {
    public void sendPayment(double amount) {
        System.out.println("your payment forPayPal payment of $" + amount+"on the way");
    }
}

// Adaptee Class 2: Stripe
class Stripe {
    public void makePayment(double amount) {
        System.out.println("your payment for Stripe payment of $" + amount);
    }
}

// Adaptee Class 3: Square
class Square {
    public void pay(double amount) {
        System.out.println("your payment for Square payment of $" + amount+"is on the way");
    }
}

// Step 4: Implement the Adapter Class

// Adapter Class for PayPal
class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
}

// Adapter Class for Stripe
class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

// Adapter Class for Square
class SquareAdapter implements PaymentProcessor {
    private Square square;

    public SquareAdapter(Square square) {
        this.square = square;
    }

    @Override
    public void processPayment(double amount) {
        square.pay(amount);
    }
}

// Step 5: Test the Adapter Implementation

public class Exercise_4_Implementing_the_Adapter_Pattern {
    public static void main(String[] args) {
        // Using PayPal through Adapter
        PayPal payPal = new PayPal();
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        payPalAdapter.processPayment(76800.0);

        // Using Stripe through Adapter
        Stripe stripe = new Stripe();
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        stripeAdapter.processPayment(57648900.0);

        // Using Square through Adapter
        Square square = new Square();
        PaymentProcessor squareAdapter = new SquareAdapter(square);
        squareAdapter.processPayment(385300.0);
    }
}
