package projectUtilities;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverManager;

public class Hooks {
	WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}
	public Hooks() {
		DriverManager dm = new DriverManager();
		if(driver==null) {
		dm.intiateDriver();
		}	
		driver=dm.getDriver();
	}
	Scenario scenario;
	@Before
	public void setUp(Scenario scenario) {
		this.scenario=scenario;
		
	}
	@After
	public void tearDown() {
		driver.quit();
		
	}

}
