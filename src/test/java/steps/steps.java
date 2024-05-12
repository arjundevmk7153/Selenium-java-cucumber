package steps;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class steps {
    WebDriver driver;

    @Given("I am a jobseeker on NHS Jobs website")
    public void iamajobseekeronnhsjobswebsite() {
        System.setProperty("webdriver.chrome.driver", "/Users/amavelikizhakkeyil/SeleniumCucumber/demo/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.jobs.nhs.uk/candidate/search");
    }

    @When("I put my preferences into search functionality")
    public void i_search_for() {
        WebElement acceptCookie= driver.findElement(By.xpath("//button[@id='accept-cookies']"));
        acceptCookie.click();
        WebElement keywordInput = driver.findElement(By.xpath("//input[@id='keyword']"));
        keywordInput.sendKeys("Software");
        WebElement locationInput = driver.findElement(By.xpath("//input[@id='location']"));
        locationInput.sendKeys("London");
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='search']"));
        searchButton.click();
    }

    // @Then("I should get a list of jobs that match my preferences")
    // public void the_list_of_jobs(String string) {
    //     // Code to check the page title
    // }

    // @Then("sort my search results with the newest Date posted")
    // public void sort_search(String string) {
    //     // Code to check the page title
    // }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}