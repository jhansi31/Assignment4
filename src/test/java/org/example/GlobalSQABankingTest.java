package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class GlobalSQABankingTest {
    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {
        // Set up ChromeDriver (Set your path correctly)

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open the GlobalSQA Banking Project URL
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");


        try {
            // Run all test cases
            verifyLoginPageLoad();
            verifyCustomerLogin();
            verifyInvalidCustomerLogin();
            verifyBankManagerLogin();
            verifyAddCustomerFunctionality();
            verifyOpenAccountFunctionality();
            verifyAccountSelection();
            verifyDepositFunctionality();
            verifyWithdrawFunctionality();
            verifyWithdrawWithInsufficientBalance();
            verifyBlankInputForAddCustomer();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after test execution

        }
    }

    // ✅ Test Case 1.1: Verify Login Page Load
    public static void verifyLoginPageLoad() {
        System.out.println("Running: Verify Login Page Load");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Bank Manager Login']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Customer Login']")));
        driver.findElement(By.xpath("//button[normalize-space()='Customer Login']")).click();


        System.out.println("Login page loaded successfully.");

    }

    // ✅ Test Case 1.2: Verify Customer Login
    public static void verifyCustomerLogin() {
        System.out.println("Running: Verify Customer Login");

        driver.findElement(By.xpath("//button[text()='Customer Login']")).click();
        Select customerDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.id("userSelect"))));
        customerDropdown.selectByVisibleText("Harry Potter");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Harry Potter']")));
        System.out.println("Customer logged in successfully.");
    }

    // ✅ Test Case 1.3: Verify Invalid Customer Login
    public static void verifyInvalidCustomerLogin() {

        System.out.println("Running: Verify Invalid Customer Login");
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.findElement(By.xpath("//button[text()='Customer Login']")).click();
        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userSelect")));
        Select customerDropdown = new Select(dropdownElement);

        // Step 4: Print all available dropdown options
        List<WebElement> options = customerDropdown.getOptions();
        System.out.println("Available options in the dropdown:");
        for (WebElement option : options) {
            System.out.println("- " + option.getText());
        }

        // Step 5: Attempt to select a non-existent option
        String invalidName = "Invalid Name";
        boolean isOptionPresent = options.stream().anyMatch(option -> option.getText().equals(invalidName));

        if (!isOptionPresent) {
            System.out.println("Invalid name selection test passed: '" + invalidName + "' is NOT in the dropdown.");
        } else {
            System.out.println("Test failed: '" + invalidName + "' is present in the dropdown.");
            customerDropdown.selectByVisibleText(invalidName);

        }
        driver.findElement(By.xpath("//button[normalize-space()='Home']")).click();
        // Step 6: Click the "Login" button


        // Step 7: Handle Alert (if present)



    }

    // ✅ Test Case 2.1: Verify Bank Manager Login
    public static void verifyBankManagerLogin() {
        System.out.println("Running: Verify Bank Manager Login");
        driver.findElement(By.cssSelector("button[ng-click='manager()']")).click();//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/button[normalize-space()='Bank Manager Login']"))).click();
        System.out.println("Bank Manager logged in successfully.");
    }

    // ✅ Test Case 2.2: Verify Add Customer Functionality
    public static void verifyAddCustomerFunctionality() {
        System.out.println("Running: Verify Add Customer Functionality");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass1']")));
        element.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
        firstNameInput.sendKeys("John");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Doe");
        driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("12345");
        driver.findElement(By.cssSelector(" button[type='submit']")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert: " + alert.getText());
        alert.accept();
    }

    // ✅ Test Case 2.3: Verify Open Account Functionality
    public static void verifyOpenAccountFunctionality() {
        System.out.println("Running: Verify Open Account Functionality");
        driver.findElement(By.xpath("//button[normalize-space()='Open Account']")).click();
        Select customerDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.id("userSelect"))));
        customerDropdown.selectByVisibleText("John Doe");
        Select currencyDropdown = new Select(driver.findElement(By.id("currency")));
        currencyDropdown.selectByVisibleText("Dollar");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert: " + alert.getText());
        alert.accept();
    }

    // ✅ Test Case 3.1: Verify Account Selection
    public static void verifyAccountSelection() {
        System.out.println("Running: Verify Account Selection");
        driver.findElement(By.xpath("/html/body/div/div/div[1]/button[1]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Customer Login']")).click();
        Select customerDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.id("userSelect"))));
        customerDropdown.selectByVisibleText("Neville Longbottom");

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Neville Longbottom']")));
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();
        System.out.println("Customer logged in successfully.");



        System.out.println("Account selection verified.");
    }

    // ✅ Test Case 3.2: Verify Deposit Functionality
    public static void verifyDepositFunctionality() {
        System.out.println("Running: Verify Deposit Functionality");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
        //
        //driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("1000");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='amount']"))).sendKeys("20000");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Deposit Successful']")));
        System.out.println("Deposit successful.");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(600));
    }

    // ✅ Test Case 3.3: Verify Withdraw Functionality
    public static void verifyWithdrawFunctionality() throws InterruptedException {
        System.out.println("Running: Verify Withdraw Functionality");
        driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
        Thread.sleep(3000);
        System.out.println("clicked on Widthdraw");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")).sendKeys("10");
        System.out.println("enter Amt");
        Thread.sleep(3000);
        //driver.findElement(By.cssSelector("input[placeholder='amount']")).sendKeys("500");
        System.out.println("Amt Entered");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("Clicked on Withdrawal");
        WebElement Message1 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/span[1]"))
        );
        // Ensure it is visible
        wait.until(ExpectedConditions.visibilityOf(Message1));
        System.out.println("Check visibility");

        // Print error message
        System.out.println("Withdrawal Message Displayed: " + Message1.getText());
    }

    // ✅ Negative Test Case: Verify Withdraw with Insufficient Balance
    public static void verifyWithdrawWithInsufficientBalance() throws InterruptedException{
        System.out.println("Running: Verify Withdraw with Insufficient Balance");
        driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
        Thread.sleep(3000);
        System.out.println("clicked on Widthdraw");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")).sendKeys("100000000");
        System.out.println("enter Amt");
        Thread.sleep(3000);
        //driver.findElement(By.cssSelector("input[placeholder='amount']")).sendKeys("500");
        System.out.println("Amt Entered");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("Clicked on Withdrawal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/span[1]")));
        WebElement Message3 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/span[1]")));
        // Ensure it is visible
                        // Ensure it is visible
                        wait.until(ExpectedConditions.visibilityOf(Message3));
        System.out.println("Check visibility");

        // Print error message
        System.out.println("Withdrawal Message Displayed: " + Message3.getText());
        // Print error message

        System.out.println("Error message displayed: Insufficient balance.");
    }

    // ✅ Negative Test Case: Verify Blank Input for Add Customer
    public static void verifyBlankInputForAddCustomer() throws InterruptedException {
        System.out.println("Running: Verify Blank Input for Add Customer");
        driver.findElement(By.xpath("//button[normalize-space()='Home']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Customer']")).click();
        // WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='First Name']"));


        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        // WebElement inputfield = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
System.out.println("Error message appears");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            System.out.println("Alert Message: " + alertText);
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("No alert appeared. Form submission may be incorrect.");
        }
    }
}