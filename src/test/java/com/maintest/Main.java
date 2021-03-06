package com.maintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Main {
    private WebDriver browser;

    @BeforeMethod
    public void setup() {
        DriverSingleton singleton = DriverSingleton.getInstance();
        browser = singleton.browser;

        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void login() {
        browser.get("https://ticket-dev.fusemachines.com");
        WebElement usernameField = browser.findElement(By.name("email"));
        WebElement passwordField = browser.findElement(By.name("password"));
        WebElement loginButton = browser.findElement(By.cssSelector(".auth0-lock-submit"));
        usernameField.sendKeys("viral@fusemachines.com");
        passwordField.sendKeys("Test1234");
        loginButton.click();


        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement header = browser.findElement(By.cssSelector("#app > div > header"));
        if (header.isDisplayed())
            Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void knowledgeDropdown() {
        WebElement knowledgeBase = browser.findElement(By.cssSelector(".btn.btn-secondary.dropdown-toggle"));
        knowledgeBase.click();
        WebElement searchTerm = browser.findElement(By.name("searchTerm"));
        Assert.assertTrue(searchTerm.isDisplayed());

    }

    @Test(priority = 3)
    public void addQuestion() {
        WebElement addQuestion = browser.findElement(By.linkText("Add Question"));
        addQuestion.click();
        String currentUrl = browser.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://ticket-dev.fusemachines.com/add-question");


    }

    @Test(priority = 4)
    public void question() {
        WebElement question = browser.findElement(By.name("question"));
        question.sendKeys("What is Artificial Intelligence");

        WebElement answer = browser.findElement(By.name("answer"));
        answer.sendKeys("An executive guide to artificial intelligence, from machine learning and general AI to neural networks");

        WebElement save = browser.findElement(By.cssSelector(".save-btn.G1Q-zPSDVcBZ5m9TS9wnC"));
        save.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test(priority = 5)
    public void searchQuestion() {
        WebElement searchQ = browser.findElement(By.name("search"));
        searchQ.sendKeys("What is Artificial Intelligence?");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement searchButton = browser.findElement(By.cssSelector(".fa.fa-search.icon-flipped"));
        searchButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 6)
    public void Edit() {
        WebElement questionEdit = browser.findElement(By.cssSelector(".not-answered.search-results>li:nth-child(1)>a>i"));
        questionEdit.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7)
    public void delete() {
        WebElement deleteQuestion = browser.findElement(By.className("delete"));
        deleteQuestion.click();
        WebElement yes = browser.findElement(By.cssSelector(".btn.save"));
        yes.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 8)
    public void Setting() {
        WebElement dropDown = browser.findElement(By.cssSelector(".fa.fa-angle-down"));
        dropDown.click();
        WebElement selectSetting = browser.findElement(By.className("dropdown-item"));
        selectSetting.click();
    }


    @Test(priority = 9)
    public void Adduser() {
        WebElement addUser = browser.findElement(By.linkText("Add User"));
        addUser.click();


        WebElement firstName = browser.findElement(By.name("firstName"));
        firstName.sendKeys("Ritu");

        WebElement lastName = browser.findElement(By.name("lastName"));
        lastName.sendKeys("Stha");

        WebElement email = browser.findElement(By.name("email"));
        email.sendKeys("ritu12@fusemachines.com");

        WebElement password = browser.findElement(By.name("password"));
        password.sendKeys("Test1234");

        WebElement confirmPassword = browser.findElement(By.name("confirmPassword"));
        confirmPassword.sendKeys("Test1234");

        WebElement addButton = browser.findElement(By.cssSelector(".save-btn.G1Q-zPSDVcBZ5m9TS9wnC"));
        addButton.click();

        WebElement closebutton = browser.findElement(By.cssSelector(".fas.fa-chevron-down.pull-right"));
        closebutton.click();
    }

    @Test(priority = 10)
    public void Revoke() {
        WebElement revoke = browser.findElement(By.linkText("Revoke Zendesk"));
        revoke.click();
        WebElement revokebutton = browser.findElement(By.cssSelector(".cancel.G1Q-zPSDVcBZ5m9TS9wnC"));
        revokebutton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement selectYes = browser.findElement(By.cssSelector(".btn.save"));
        selectYes.click();

    }

    @Test(priority = 11)
    public void integrate() {
        WebElement integrateUrl = browser.findElement(By.name("url"));
        integrateUrl.sendKeys("https://fusemachines101.zendesk.com");

        WebElement email = browser.findElement(By.name("email"));
        email.sendKeys("demoem123@gmail.com");

        WebElement API = browser.findElement(By.name("key"));
        API.sendKeys("6ucD1OipFvccTSEmMevwO6PvREVaeVYryd9qbaTl");

        WebElement integrateButton = browser.findElement(By.cssSelector(".save-btn.G1Q-zPSDVcBZ5m9TS9wnC"));
        integrateButton.click();


    }
//    @Test (priority = 12)
//    public void dashboard (){
//        WebElement dashboard = browser.findElement(By.linkText("Viral Launch"));
//        dashboard.click();
//    }
}














