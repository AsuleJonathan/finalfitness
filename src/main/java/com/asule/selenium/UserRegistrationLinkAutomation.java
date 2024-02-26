package com.asule.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRegistrationLinkAutomation {
    private static WebDriver driver;

    public static void main(String[] args) {
        // Set up ChromeDriver
        driver = new ChromeDriver();

        getLandingPage();
    }

    public static void getLandingPage() {
        // Navigate to the page containing the user registration link
        driver.get("http://34.141.74.71:8080/FitnessTracking/");

        // Find the user registration link and click on it
        WebElement registrationLink = driver.findElement(By.linkText("User registration"));
        registrationLink.click();

        // Proceed with registration form automation
        registrationFormAutomation();
    }

    public static void registrationFormAutomation() {
        // Create WebDriverWait with 10 seconds timeout
        try{
            Thread.sleep(10000 );
        }catch(Exception i){
            System.out.println(i.getMessage());
        }

        // Find input fields and submit button
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement confirmPasswordInput = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

        // Enter registration information
        usernameInput.sendKeys("example_user");
        passwordInput.sendKeys("password123");
        confirmPasswordInput.sendKeys("password123");

        // Click on the submit button
        submitButton.click();

        // Proceed with login form automation
        loginFormAutomation();
    }

    public static void loginFormAutomation() {
        // Find username, password fields, and login button
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Input username and password
        usernameInput.sendKeys("example_user");
        passwordInput.sendKeys("password123");

        // Click on the login button
        loginButton.click();

        // Get the title of the page
        String title = driver.getTitle();

        // Print the title
        System.out.println("Title is: " + title);
    }
}
