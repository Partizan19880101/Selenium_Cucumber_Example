package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.TestBase;

import java.net.MalformedURLException;

public class StepsDefinition extends TestBase {
    @Before
    public void initialization() throws MalformedURLException {
        start();
    }

    @After
    public void teardown() {
        finish();
    }


    @Given("I go to main page")
    public void iGoToMainPage() {
       main.goTo();
    }

    @When("I select {string} task")
    public void iSelectTask(String taskNumber) {
        main.chooseTask(taskNumber);
    }

    @And("I login as {string} with password {string}")
    public void iLoginAsWithPassword(String login, String password) {
        taskSix.checkAllElementsOnPagePresent()
                .fillInLogin(login)
                .fillInPassword(password)
                .loginButtonClick();
    }

    @Then("I should (see|not see) the link download file$")
    public void iShouldSeeTheLinkDownloadFile(String visibility) {
        if(visibility.equals("see")) {
            taskSix.isLoginCorrect();
        } else {
            taskSix.isLoginWrong();
        }

    }
}