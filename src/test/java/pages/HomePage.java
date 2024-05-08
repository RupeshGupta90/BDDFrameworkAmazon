package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumKeyWord;

public class HomePage {

	WebDriver driver;

	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBoxTxt;
	@FindBy(xpath="(//input[@title='Add to Shopping Cart'])[last()]")
	private WebElement addToCart;
	@FindBy(xpath="(//span[@class='a-price-whole'])[1]")
	private WebElement displayPriceTxt;
	@FindBy(xpath="(//span[@class='a-price-fraction'])[1]")
	private WebElement displayFractPriceTxt;

	@FindBy(xpath="(//a[contains(@class,'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal')])[1]")
	private WebElement productDisplayed;
	@FindBy(css ="a[id='attach-close_sideSheet-link']")
	private WebElement closeCartBtn;

	@FindBy(id="nav-cart-count")
	private WebElement navigateToCart;
	@FindBy(xpath=" //div[@class='sc-badge-price-to-pay']/div/span")
	private WebElement priceInCart;
	@FindBy(xpath="//span[@id='sc-subtotal-amount-activecart']/span")
	private WebElement subTotalInCart;



	String displayPrice;
	public String getDisplayPrice() {
		return displayPrice;
	}
	SeleniumKeyWord skw ;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		skw= new SeleniumKeyWord(driver);
		PageFactory.initElements(driver, this);
	}
	public boolean searchTextandEnter(String itemTxt) {
		boolean result=true;
		skw.scrollTop();
		result&=skw.enterText(searchBoxTxt, itemTxt);
		result&=skw.pressEnter();
		return result;
	}
	public boolean AddToCart(int number) {
		boolean result=true;
		By productDisplayedBy=By.xpath("(//a[contains(@class,'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal')])["+number+"]");
		result&=skw.clickElement(driver.findElement(productDisplayedBy));
		result&=skw.SwitchToChildWindow();
		skw.wait_for_second(5);
		displayPrice=skw.getText(displayPriceTxt)+"."+skw.getText(displayFractPriceTxt);
		System.out.println("Display price:"+displayPrice);
		result&=skw.clickElement(addToCart);
		return result;
	}
	public boolean closeCart() {
		return skw.clickElement(closeCartBtn);
	}
	public boolean navigateToShoppingCart() {
		skw.scrollTop();
		return skw.clickElement(navigateToCart);
	}
	public String getCartPrice() {	
		return priceInCart.getText();
	}
	public String getSubTotal() {	
		return subTotalInCart.getText();
	}

}
