package steps;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.*;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constants;

public class AllSteps {

	@After

	public void tearDown(Scenario sc) {

		if (driver != null) {
			driver.quit();
			sc.write("Quiting driver");
		}

	}

	WebDriver driver;

	@Given("User navigates to rediff login")
	public void user_navigates_to_rediff_login() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Constants.url);

	}

	@Then("Click navigates Create User page")
	public void click_navigates_Create_User_page() {
		driver.findElement(By.linkText("Create Account")).click();
	}

	@Then("Fills the Form data")
	public void fills_the_Form_data(DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//input[starts-with(@name,'name')]"))
				.sendKeys(data.get(0).get("fullname").toString());
		driver.findElement(By.xpath("//input[starts-with(@name,'login')]"))
				.sendKeys(data.get(0).get("rediffmailid").toString());

	}

	@Then("user searches product {string}")
	public void user_searches_product(String product) {
		driver.findElement(By.xpath("//input[@id='srchword']")).sendKeys(product, Keys.ENTER);
	}

}
