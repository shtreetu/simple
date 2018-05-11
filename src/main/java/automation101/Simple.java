package automation101;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Simple {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\dependencies\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://ticket-dev.fusemachines.com");
        WebElement usernameField = browser.findElement(By.name("email"));
        WebElement passwordField = browser.findElement(By.name("password"));
        WebElement loginButton = browser.findElement(By.cssSelector(".auth0-lock-submit"));

        //functions starts here
        usernameField.sendKeys("reetu@fusemachines.com");
        passwordField.sendKeys("Test1234");
        loginButton.click();


        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement knowledgeBase = browser.findElement(By.cssSelector(".btn.btn-secondary.dropdown-toggle"));
        knowledgeBase.click();

        WebElement addQuestion = browser.findElement(By.linkText("Add Question"));
        addQuestion.click();

        WebElement questionType = browser.findElement(By.name("question"));
        questionType.sendKeys("What is Artificial Intelligence");

        WebElement answerType = browser.findElement(By.name("answer"));
        answerType.sendKeys("An executive guide to artificial intelligence, from machine learning and general AI to neural networks.");

        WebElement save = browser.findElement(By.cssSelector(".save-btn.G1Q-zPSDVcBZ5m9TS9wnC"));
        save.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement searchKnowledge = browser.findElement(By.name("search"));
        searchKnowledge.sendKeys("What is Artificial Intelligence?");


        WebElement search = browser.findElement(By.cssSelector(".fa.fa-search.icon-flipped"));
        search.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement questionEdit = browser.findElement(By.cssSelector(".not-answered.search-results>li:nth-child(1)>a>i"));
        questionEdit.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement deleteQuestion = browser.findElement(By.className("delete"));
        deleteQuestion.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement yes = browser.findElement(By.cssSelector(".btn.save"));
        yes.click();

        try {
          Thread.sleep(4000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

        WebElement dropDown = browser.findElement(By.cssSelector(".fa.fa-angle-down"));
        dropDown.click();

        WebElement selectSetting = browser.findElement(By.className("dropdown-item"));
         selectSetting.click();

        //browser.close();
    }
}
