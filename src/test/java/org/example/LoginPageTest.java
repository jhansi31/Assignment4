package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPageTest {
    public static void main(String[] args) {
        // Set the path to your chromedriver executable

        WebDriver driver = new ChromeDriver();

        // Define the URL for the login page (replace with the actual URL)
        String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"; // Replace with actual URL

        // Initialize WebDriverWait for waiting elements
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Open the login page URL
            driver.get(url);

            // Wait for the page to load (wait for the login form or any specific element on the page)
            WebElement loginForm = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button"))); // Replace with the actual element ID of the login form

            // Verify the page has loaded by checking for the presence of the login form or a key element
            if (loginForm != null) {
                System.out.println("Login page loaded successfully.");
            } else {
                System.out.println("Failed to load the login page.");
            }
        } catch (TimeoutException e) {
            System.out.println("Timed out waiting for the page to load.");
        } catch (NoSuchElementException e) {
            System.out.println("The login form element was not found on the page.");
        } finally {
            // Quit the driver (close the browser)
            driver.quit();
        }
    }
}