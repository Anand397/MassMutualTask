package stepDefinition;

import org.openqa.selenium.WebDriver;

import Pages.havenLifePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testTaskStepDef {
	
	WebDriver driver = null;
	havenLifePage havenLife;
	
	@Given("^User launch the havenlife insurence page$")
	public void User_launch_the_havenlife_insurence_page() {
		havenLife = new havenLifePage(driver);
		havenLife.launchApp();	
	}
	
	@When("^User verify fourty years of mary quote result with good health$")
	public void User_verify_mary_quote_result(DataTable tables) throws InterruptedException {
		havenLife.maryQuoteResults(tables);
	}
	
	@Then("^User verify fifty yeasrs of male gender quote result with fair health$")
	public void User_verify_quote_result(DataTable tables) throws InterruptedException {
		havenLife.fiftyYeasrsOfMaleGenderQuote(tables);
	}
	
	@And("^User verify percentage of mary and male gender quote$")
	public void User_verify_percentage_of_mary_and_male_gender_quote() {
		havenLife.compareBothQuotePercenatage();
		
	}
	
	@Then("^User verify the quote amounts shown for the state of Montana unique$")
	public void User_verify_the_quote_amounts_shown_for_the_state_of_Montana_unique(DataTable tables) throws InterruptedException {
		havenLife.theStateOfMontanaUniqueQuoteAmount(tables);
	}

}
