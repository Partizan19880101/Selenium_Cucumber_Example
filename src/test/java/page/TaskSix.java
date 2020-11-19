package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TaskSix extends BasePage {
    public TaskSix(WebDriver driver) {
        super(driver);
    }

    public TaskSix fillInLogin(String login){
        writeText(By.id("LoginForm__username"), login);
        return this;
    }

    public TaskSix fillInPassword(String password){
        writeText(By.id("LoginForm__password"), password);
        return this;

    }

    public TaskSix loginButtonClick(){
        click(By.id("LoginForm_save"));
        return this;
    }

    public TaskSix isLoginCorrect(){
        isElementDisplayed(By.id("logout"));
        return this;
    }

    public TaskSix checkAllElementsOnPagePresent(){
        isElementDisplayed(By.id("LoginForm__username"));
        isElementDisplayed(By.id("LoginForm__password"));
        isElementDisplayed(By.id("LoginForm_save"));
        return this;
    }

    public TaskSix isLoginWrong(){
        isElementNotDisplayed(By.id("logout"));
        return this;
    }
}