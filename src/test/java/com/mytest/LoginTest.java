package com.mytest;

import com.mypages.HomePage;
import com.mypages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void verifyLoginPageTitleTest() {
        String title = page.getInstance(LoginPage.class).getLoginPageTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Login - LambdaTest");
    }

    @Test(priority = 2)
    public void verifyLoginPageHeaderTest() {
        String header = page.getInstance(LoginPage.class).getLoginPageHeader();
        System.out.println(header);
        Assert.assertEquals(header, "Welcome Back !");
    }

    @Test(priority = 3)
    public void doLoginTest() {
        HomePage homepage = page.getInstance(LoginPage.class).doLogin("sandipgit1987@gmail.com", "Fenal@1987");
        String headerHome = homepage.getHomePageHeader();
        System.out.println(headerHome);
        Assert.assertEquals(headerHome, "Hello super !");
    }
}
