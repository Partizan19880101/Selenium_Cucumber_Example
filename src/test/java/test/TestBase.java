package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import page.Main;
import page.TaskOne;
import page.TaskSix;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public Main main;
    public TaskOne taskOne;
    public TaskSix taskSix;



    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //options.setHandless(true);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        main = PageFactory.initElements(driver, Main.class);
        taskOne = PageFactory.initElements(driver, TaskOne.class);
        taskSix = PageFactory.initElements(driver, TaskSix.class);
    }

    public void finish() {

        driver.quit();
    }
}
