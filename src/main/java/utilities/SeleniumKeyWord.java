package utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumKeyWord {
	WebDriver driver;
	WebDriverWait wait;
	String handle;

	public SeleniumKeyWord(WebDriver driver) {
		this.driver=driver;	
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		handle=driver.getWindowHandle();

	}
	public boolean enterText(WebElement elem,String text) {
		try { 
			wait.until(ExpectedConditions.visibilityOf(elem)).clear();
			elem.sendKeys(text);
			return true;
		}
		catch(Exception ex) {
			System.out.println("Exception while entering text"+ex.getStackTrace());
			return false;
		}
	}
	public String getText(WebElement elem) {
		try {
			return elem.getText();	
		}
		catch(Exception ex) {
			System.out.println("Exception while getting"+ex.getMessage());
			return null;
		}
	}
	public boolean clickElement(WebElement elem) {
		try {
			wait.until(ExpectedConditions.visibilityOf(elem)).click();
			return true;
		}
		catch(Exception ex) {
			System.out.println("Exception while clicking:"+ex.getMessage());
			return false;
		}
	}
	public boolean pressEnter() {
		try {
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			return true;
		}
		catch(Exception ex) {
			System.out.println("Exception while pressing enter"+ex.getStackTrace());
			return false;
		}
	}
	public void wait_for_second(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean SwitchToChildWindow() {
		try {
			System.out.println(handle);
			Set<String> handles= driver.getWindowHandles();
			for(String hand:handles) {
				if(!hand.equalsIgnoreCase(handle)) {
					System.out.println(hand);
					driver.switchTo().window(hand);
					System.out.println("Switched to new Window");			
				}
			}
			return true;
		}
		catch(Exception ex) {
			System.out.println("Exception while pressing enter"+ex.getStackTrace());
			return false;
		}
	}
	public void scrollTop() {
		try {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].scrollIntoView()", elem);
			 js.executeScript("window.scroll(0,0);");
			 wait_for_second(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
