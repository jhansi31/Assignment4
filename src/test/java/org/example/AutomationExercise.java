package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationExercise {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        // Set up the WebDriver


        try {
            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait for 10 seconds

            // Launch the website
            driver.get("http://automationexercise.com");
            driver.manage().window().maximize();

            try {
                // Wait for the "Accept" button (or equivalent) to be clickable
                By consentButton = By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/button[2]/p"); // This is the typical XPath for "Accept" button on Google consent
                wait.until(ExpectedConditions.elementToBeClickable(consentButton)).click();
                driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[3]/div[2]/button[1]")).click();
                System.out.println("Consent given successfully.");
            } catch (Exception e) {
                System.out.println("Consent popup not displayed or already dismissed.");
            }

            // Continue with further actions on the page
            System.out.println("Proceeding with the next steps on the page...");


            // Click on 'Signup / Login' button
            WebElement signupButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")));
            signupButton.click();

            // Enter name and email address
            driver.findElement(By.name("name")).sendKeys("good User");
            driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("emeeuser@example.com");

            // Click 'Signup' button
            driver.findElement(By.xpath("//button[text()='Signup']")).click();


            // Verify that 'ENTER ACCOUNT INFORMATION' is visible
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Enter Account Information']"))).isDisplayed()) {
                System.out.println("'ENTER ACCOUNT INFORMATION' is visible.");
            } else {
                System.out.println("'ENTER ACCOUNT INFORMATION' is not visible.");
                return;
            }

            driver.findElement(By.id("id_gender1")).click(); // Title
            //driver.findElement(By.name("name")).sendKeys("Test User"); // Name
           // driver.findElement(By.name("email")).sendKeys("testuser@example.com"); // Email
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Test@12345");
            Select selectDobDayField = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]"))); // Update locator
            selectDobDayField.selectByVisibleText("12");

// Select Month
            Select selectDobMonthField = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]"))); // Update locator
            selectDobMonthField.selectByVisibleText("January");

// Select Year
            Select selectDobYearField = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]"))); // Update locator
            selectDobYearField.selectByVisibleText("2000");

            // Click Search button

            // 10. Select checkbox 'Sign up for our newsletter!'
                //driver.findElement(By.id("newsletter")).click();
            WebElement checkbox = driver.findElement(By.id("newsletter"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
            checkbox.click();
            // 11. Select checkbox 'Receive special offers from our partners!'
            driver.findElement(By.id("optin")).click();

            // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
            driver.findElement(By.id("first_name")).sendKeys("Test"); // First name
            driver.findElement(By.id("last_name")).sendKeys("User"); // Last name
            driver.findElement(By.id("company")).sendKeys("Test Company"); // Company
            driver.findElement(By.id("address1")).sendKeys("123 Main Street"); // Address
            driver.findElement(By.id("address2")).sendKeys("Suite 456"); // Address 2
            driver.findElement(By.id("country")).sendKeys("India"); // Country
            driver.findElement(By.id("state")).sendKeys("Maharashtra"); // State
            driver.findElement(By.id("city")).sendKeys("Mumbai"); // City
            driver.findElement(By.id("zipcode")).sendKeys("400001"); // Zipcode
            driver.findElement(By.id("mobile_number")).sendKeys("1234567890"); // Mobile number

            // 13. Click 'Create Account' button
            driver.findElement(By.xpath("//button[text()='Create Account']")).click();

            Thread.sleep(5000);


            // 14. Verify that 'ACCOUNT CREATED!' is visible
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"))).isDisplayed()) {
                System.out.println("'ACCOUNT CREATED!' is visible.");
                driver.findElement(By.xpath("//a[text()='Continue']")).click(); // Click 'Continue'
            } else {
                System.out.println("'ACCOUNT CREATED!' is not visible.");
                return;

            }
           // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



            // ✅ Proceed with further actions (Example: Clicking Continue button)
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

// Wait until the element is present
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")));
            System.out.println("Element is present!");

// Now, wait for it to be clickable
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")));
            clickableElement.click();
            System.out.println("Click on Delet Acc");
            // 16. Verify that 'Logged in as username' is visible


            // 17. Click 'Delete Account' button
            //driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a]")).click();
            driver.findElement(By.xpath("/html/body/section/div/div/div/div/a")).click();
            System.out.println("Click on cont");
            // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
            //WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2/b[contains(text(), 'Account Deleted')]")));
            //WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[normalize-space()='Account Deleted!']")));
            System.out.println("deleted");
           //driver.findElement(By.xpath("//a[text()='Continue']")).click();
           } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }


    }}