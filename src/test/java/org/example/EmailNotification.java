package org.example;

class EmailNotification implements Notification {
    private String emailAddress;

    // Constructor
    public EmailNotification(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email to " + emailAddress + ": " + message);
    }
}
