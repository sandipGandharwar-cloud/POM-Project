package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private By emailId = By.name("email");
    private By password = By.name("password");
    private By loginButton = By.xpath("//button[@class='btn btn-dark submit-btn']");
    private By header = By.className("form_title");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailId() {
        return getElement(emailId);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginButton() {
        return getElement(loginButton);
    }

    public WebElement getHeader() {
        return getElement(header);
    }

    public String getLoginPageTitle() {
        return getPageTitle();
    }

    public String getLoginPageHeader() {
        return getPageHeader(header);
    }

    public HomePage doLogin(String username, String pwd) {
        getEmailId().sendKeys(username);
        getPassword().sendKeys(pwd);
        getLoginButton().click();

        return getInstance(HomePage.class);
    }

    public void doLogin() {
        getEmailId().sendKeys("");
        getPassword().sendKeys("");
        getLoginButton().click();
    }

    public void doLogin(String userCred) {
        if (userCred.contains("username")) {
            getEmailId().sendKeys(userCred.split(":")[1].trim());
        } else if (userCred.contains("password")) {
            getEmailId().sendKeys(userCred.split(":")[1].trim());
        }
        getLoginButton().click();
    }
}
