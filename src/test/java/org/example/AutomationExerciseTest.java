package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class AutomationExerciseTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://automationexercise.com");
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Step 3: Verify home page is visible
            WebElement homePage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='Website for automation practice']")));
            if (homePage.isDisplayed()) {
                System.out.println("Home page is visible successfully.");
            }

            // Step 4: Handle overlay if present
            try {
                WebElement overlay = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("fc-dialog-overlay")));
                WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fc-close")));
                closeButton.click();
                System.out.println("Overlay closed successfully.");
            } catch (Exception e) {
                System.out.println("No overlay displayed.");
            }

            // Step 4: Click on 'Signup / Login' button
            WebElement signupLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Signup / Login")));
            signupLoginButton.click();
            System.out.println("Clicked on 'Signup / Login' button.");

            // Step 5: Verify 'New User Signup!' is visible
            WebElement newUserSignup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='New User Signup!']")));
            if (newUserSignup.isDisplayed()) {
                System.out.println("'New User Signup!' is visible.");
            }

            // Step 6: Enter name and email address
            driver.findElement(By.name("name")).sendKeys("John Doe");
            driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("john.doe" + System.currentTimeMillis() + "@example.com");

            // Step 7: Click 'Signup' button
            driver.findElement(By.xpath("//button[text()='Signup']")).click();

            // Step 8: Verify 'ENTER ACCOUNT INFORMATION' is visible
            try {
                // Wait for any potential overlay or spinner to disappear
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-spinner"))); // Adjust class name as needed

                // Wait for 'ENTER ACCOUNT INFORMATION' header to appear and be visible
                WebElement accountInfoHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Enter Account Information')]")));
                if (accountInfoHeader.isDisplayed()) {
                    System.out.println("'ENTER ACCOUNT INFORMATION' is visible.");
                }
            } catch (Exception e) {
                System.out.println("Error: 'ENTER ACCOUNT INFORMATION' is not visible.");
                e.printStackTrace();

            }

            // Step 9: Fill details
            driver.findElement(By.id("id_gender1")).click();
            driver.findElement(By.id("password")).sendKeys("Password123");
            new Select(driver.findElement(By.id("days"))).selectByValue("10");
            new Select(driver.findElement(By.id("months"))).selectByValue("5");
            new Select(driver.findElement(By.id("years"))).selectByValue("1990");

            // Step 10: Select 'Sign up for our newsletter!' checkbox
            driver.findElement(By.id("newsletter")).click();

            // Step 11: Select 'Receive special offers from our partners!' checkbox
            driver.findElement(By.id("optin")).click();

            // Step 12: Fill personal details
            driver.findElement(By.id("first_name")).sendKeys("John");
            driver.findElement(By.id("last_name")).sendKeys("Doe");
            driver.findElement(By.id("company")).sendKeys("TestCompany");
            driver.findElement(By.id("address1")).sendKeys("123 Test St");
            driver.findElement(By.id("address2")).sendKeys("Suite 456");
            new Select(driver.findElement(By.id("country"))).selectByVisibleText("United States");
            driver.findElement(By.id("state")).sendKeys("California");
            driver.findElement(By.id("city")).sendKeys("Los Angeles");
            driver.findElement(By.id("zipcode")).sendKeys("90001");
            driver.findElement(By.id("mobile_number")).sendKeys("1234567890");

            // Step 13: Click 'Create Account' button
            driver.findElement(By.xpath("//button[text()='Create Account']")).click();

            // Step 14: Verify 'ACCOUNT CREATED!' is visible
            WebElement accountCreated = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@data-qa='account-created']")));
            if (accountCreated.isDisplayed()) {
                System.out.println("'ACCOUNT CREATED!' is visible.");
            }

            // Step 15: Click 'Continue' button
            driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

            // Step 16: Verify 'Logged in as username' is visible
            WebElement loggedInAs = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(), 'Logged in as')]")));
            if (loggedInAs.isDisplayed()) {
                System.out.println("'Logged in as username' is visible.");
            }

            // Step 17: Click 'Delete Account' button
            driver.findElement(By.xpath("//a[text()='Delete Account']")).click();

            // Step 18: Verify 'ACCOUNT DELETED!' is visible and click 'Continue' button
            WebElement accountDeleted = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@data-qa='account-deleted']")));
            if (accountDeleted.isDisplayed()) {
                System.out.println("'ACCOUNT DELETED!' is visible.");
            }
            driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}