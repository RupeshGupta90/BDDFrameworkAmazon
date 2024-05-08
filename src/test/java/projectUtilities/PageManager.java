package projectUtilities;

import org.openqa.selenium.WebDriver;

import pages.HomePage;

public class PageManager {
    WebDriver driver;
	public HomePage homePage;
	public PageManager(WebDriver driver) {
		this.driver=driver;
	}
	public HomePage getHomePage() {
		if(homePage==null) {
			homePage=new HomePage(driver);
		}
		return homePage;
	}
	

}
