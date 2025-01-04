package org.example;

public class NotificationDemo {
    public static void main(String[] args) {
        // Create EmailNotification object
        Notification email = new EmailNotification("example@example.com");
        email.sendNotification("Your email verification code is 123456.");

        // Create SMSNotification object
        Notification sms = new SMSNotification("+1234567890");
        sms.sendNotification("Your SMS verification code is 654321.");
    }
}
