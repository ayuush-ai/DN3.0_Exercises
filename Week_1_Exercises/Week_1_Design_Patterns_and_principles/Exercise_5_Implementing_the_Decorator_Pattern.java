// Save this file as DecoratorPatternExample.java

// Step 2: Define Component Interface
interface Notifier {
    void send(String message);
}

// Step 3: Implement Concrete Component

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email with message: " + message);
    }
}

// Step 4: Implement Decorator Classes

// Abstract Decorator Class
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

// Concrete Decorator Class for SMS
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}

// Concrete Decorator Class for Slack
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending_Slack_message: " + message);
    }
}

// Step 5: Test the Decorator Implementation

public class Exercise_5_Implementing_the_Decorator_Pattern {
    public static void main(String[] args) {
        // Create a basic email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate the email notifier with SMS functionality
        Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);

        // Decorate the email + SMS notifier with Slack functionality
        Notifier slackSmsEmailNotifier = new SlackNotifierDecorator(smsEmailNotifier);

        // Send a message using the decorated notifier
        slackSmsEmailNotifier.send("this is a test notification!");
    }
}
