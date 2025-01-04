package org.example;

class SMSNotification implements Notification {
    private String phoneNumber;

    // Constructor
    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}
