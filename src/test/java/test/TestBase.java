package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import page.Main;
import page.TaskOne;
import page.TaskSix;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import com.codeborne.selenide.WebDriverRunner;

public class TestBase {
    public WebDriver driver;
    public Main main;
    public TaskOne taskOne;
    public TaskSix taskSix;



    public void start() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        final String url = "http://localhost:4444/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(url), DesiredCapabilities.chrome());

        //driver = new ChromeDriver();
        //options.setHandless(true);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        main = PageFactory.initElements(driver, Main.class);
        taskOne = PageFactory.initElements(driver, TaskOne.class);
        taskSix = PageFactory.initElements(driver, TaskSix.class);
        WebDriverRunner.setWebDriver(driver);
    }

    public void finish() {
        Optional.ofNullable(WebDriverRunner.getWebDriver()).ifPresent(WebDriver::quit);
        //driver.quit();
    }
}
