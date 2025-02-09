package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFormAutomation {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver


        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the registration form page
            driver.get("https://dspmuranchi.in/registration/signup");

            // Maximize browser window
            driver.manage().window().maximize();

            // Fill Chancellor Reg.No./DSPMU Form No.
            WebElement regNoField = driver.findElement(By.name("application_no")); // Update the locator based on the actual 'name' or 'id'
            regNoField.sendKeys("123456");

            // Fill Name fields
            WebElement firstNameField = driver.findElement(By.name("first_name_search")); // Update locator
            firstNameField.sendKeys("John");

            WebElement middleNameField = driver.findElement(By.name("middle_name_search")); // Update locator
            middleNameField.sendKeys("A");

            WebElement lastNameField = driver.findElement(By.name("last_name_search")); // Update locator
            lastNameField.sendKeys("Doe");

            // Fill Father's Name
            WebElement fatherNameField = driver.findElement(By.name("father_name")); // Update locator
            fatherNameField.sendKeys("Robert Doe");

            // Fill Mother's Name
            WebElement motherNameField = driver.findElement(By.name("mother_name")); // Update locator
            motherNameField.sendKeys("Jane Doe");

            Select selectDobDayField = new Select(driver.findElement(By.id("dobday_search"))); // Update locator
            selectDobDayField.selectByVisibleText("12");

// Select Month
            Select selectDobMonthField = new Select(driver.findElement(By.id("dobmonth_search"))); // Update locator
            selectDobMonthField.selectByVisibleText("January");

// Select Year
            Select selectDobYearField = new Select(driver.findElement(By.id("dobyear_search"))); // Update locator
            selectDobYearField.selectByVisibleText("2000");

            // Click Search button
            WebElement searchButton = driver.findElement(By.cssSelector("button[type='button']")); // Update locator
            searchButton.click();

            // Add some delay to observe the result
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}