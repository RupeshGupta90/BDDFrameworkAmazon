package stepDefinition;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import projectUtilities.Hooks;
import projectUtilities.PageManager;

public class AddCartStepDefinition {
	Hooks hooks;
	PageManager pageManager;
	ArrayList<String> prices = new ArrayList<String>();
	public AddCartStepDefinition() {
		 hooks= new Hooks();
		pageManager= new PageManager(hooks.getDriver());
		
	}
	@When("Open Amazon.com")
	public void open_amazon_com() {	
		hooks.getDriver().get("https://www.amazon.in/");
	  
	}

	@When("User Search for {string}")
	public void user_search_for(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    pageManager.getHomePage().searchTextandEnter(string);
	    
	}

	@When("Select {int} item and add into cart")
	public void select_item_and_add_into_cart(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		pageManager.getHomePage().AddToCart(int1);
		pageManager.homePage.closeCart();
		prices.add(pageManager.homePage.getDisplayPrice().trim());
		System.out.println("Prices :"+prices);
	}

	@When("Open cart from Left Up")
	public void open_cart_from_left_up() {
	    // Write code here that turns the phrase above into concrete actions
		pageManager.homePage.navigateToShoppingCart();
	}

	@Then("Verify that the price is identical to the product page")
	public void verify_that_the_price_is_identical_to_the_product_page() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(pageManager.homePage.getDisplayPrice(), pageManager.homePage.getCartPrice().trim());
	    
	}

	@Then("Verify that the sub total is identical to the product page")
	public void verify_that_the_sub_total_is_identical_to_the_product_page() {
		Float subtotal = 0.00f;
		for(String price:prices) {
			System.out.println("Subtotal Price List1:"+price.replace(",",""));
			subtotal=subtotal+Float.parseFloat( price.replace(",","").trim());
			System.out.println("Subtotal Price List:"+subtotal);
		}
		String subTotalSt = new DecimalFormat("#,###.00").format(subtotal);
		System.out.println("Subtotal Price:"+subTotalSt);
		Assert.assertEquals(subTotalSt, pageManager.homePage.getSubTotal().trim());
	    // Write code here that turns the phrase above into concrete actions
	 
	}
}
