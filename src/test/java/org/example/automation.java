package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class automation {


    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.google.com");

        // Perform actions on the page
        System.out.println("Page Title: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }


    }