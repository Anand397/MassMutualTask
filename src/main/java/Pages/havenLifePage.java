package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;

public class havenLifePage {
	
	WebDriver driver;
	String path = System.getProperty("user.dir");
	
	double maryQuoteResult;
	double maleGenderQuote;
	
	By dropdown = By.xpath("//select[@data-automation-id='quote-state']");

	By women_radio_button = By.xpath("//label[@data-automation-id='quote-gender-female']");
	
	By men_radio_button = By.xpath("//label[@data-automation-id='quote-gender-male']");
	
	By dateField = By.xpath("//input[@id='input-birthdate']");

	By nicotine_No = By.xpath("//label[@data-automation-id='quote-nicotine-use-false']");
		
	By nicotine_Yes = By.xpath("//label[@data-automation-id='quote-nicotine-use-true']");
	
	By good_health_radioButton = By.xpath("//label[@data-automation-id='quote-health-good']");

	By fair_health_radioButton = By.xpath("//label[@data-automation-id='quote-health-average']");
	
	By amout_of_coverage_field = By.xpath("//input[@id='input-face-amount']");
	
	By twanty_years_coverage_radio = By.xpath("//label[@data-automation-id='quote-term-20']");
		
	By get_a_quote_button = By.xpath("//button[@id='get-a-quote']");

	By quote_results = By.xpath("//span[@id='quote-results-monthly-rate']");
	
	public havenLifePage(WebDriver driver) {
		this.driver = driver;
	}

	public void launchApp() {
		System.out.println("filePath: " +path); // root directory path
		System.setProperty("webdriver.chrome.driver", path +"\\src\\test\\java\\resources\\chromedriver.exe");
        driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://havenlife.com/life-insurance-rates");	
	}
	
	public void maryQuoteResults(DataTable tables) throws InterruptedException {
		
		List<String> data = tables.row(0);
		
		WebElement element = driver.findElement(dropdown);
		Select sct = new Select(element);
		sct.selectByVisibleText(data.get(0));
		
		WebElement womenRadioButton = driver.findElement(women_radio_button);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", womenRadioButton);
		
		driver.findElement(dateField).sendKeys(data.get(1));
		
		WebElement nicotineNo = driver.findElement(nicotine_No);
		js.executeScript("arguments[0].click();", nicotineNo);
		
		WebElement goodHealthRadioButton = driver.findElement(good_health_radioButton);
		js.executeScript("arguments[0].click();", goodHealthRadioButton);
		
		driver.findElement(amout_of_coverage_field).sendKeys(data.get(2));
		WebElement coverageRadioButton = driver.findElement(twanty_years_coverage_radio);
		js.executeScript("arguments[0].click();", coverageRadioButton);
		
		WebElement quote_button = driver.findElement(get_a_quote_button);
		js.executeScript("arguments[0].click();", quote_button);
		
		Thread.sleep(5000);
		
		WebElement quote_result = driver.findElement(quote_results);
		String text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", quote_result);
		
		System.out.println("mary quote result: "+text);
		String subString = text.substring(1, 5);
		maryQuoteResult = Double.parseDouble(subString);
		System.out.println(maryQuoteResult);
	}
	
	public void fiftyYeasrsOfMaleGenderQuote(DataTable tables) throws InterruptedException {
        List<String> data = tables.row(0);
		
        WebElement element = driver.findElement(dropdown);
		Select sct = new Select(element);
		sct.selectByVisibleText(data.get(0));
		
		WebElement menRadioButton = driver.findElement(men_radio_button);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", menRadioButton);
		
		driver.findElement(dateField).sendKeys(data.get(1));
		WebElement nicotineYes = driver.findElement(nicotine_Yes);
		js.executeScript("arguments[0].click();", nicotineYes);
		
		WebElement fairHealthRadioButton = driver.findElement(fair_health_radioButton);
		js.executeScript("arguments[0].click();", fairHealthRadioButton);
		driver.findElement(amout_of_coverage_field).clear();
		driver.findElement(amout_of_coverage_field).sendKeys(data.get(2));
		WebElement coverageRadioButton = driver.findElement(twanty_years_coverage_radio);
		js.executeScript("arguments[0].click();", coverageRadioButton);
		
		WebElement quote_button = driver.findElement(get_a_quote_button);
		js.executeScript("arguments[0].click();", quote_button);
		
		Thread.sleep(5000);
		
		WebElement quote_result = driver.findElement(quote_results);
		String text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", quote_result);
		//String quoteResult = driver.findElement(quote_results).getText();
		System.out.println("nicotine health quote result: "+text);
		String subString = text.substring(1, 6);
		maleGenderQuote = Double.parseDouble(subString);
		System.out.println(maleGenderQuote);
	}
	
	public void compareBothQuotePercenatage() {
		
		// Calculate the percentage
        double percentage = (maleGenderQuote / maryQuoteResult) * 100.0;
        
        //Display the result
        System.out.println("input changes causes the highest percent change: " + percentage + "% ");
	}
	
	public void theStateOfMontanaUniqueQuoteAmount(DataTable tables) throws InterruptedException {
		
        List<String> data = tables.row(0);
		
        WebElement element = driver.findElement(dropdown);
		Select sct = new Select(element);
		sct.selectByVisibleText(data.get(0));
		
		WebElement womenRadioButton = driver.findElement(women_radio_button);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", womenRadioButton);
		
		driver.findElement(dateField).sendKeys(data.get(1));
		
		WebElement nicotineNo = driver.findElement(nicotine_No);
		js.executeScript("arguments[0].click();", nicotineNo);
		
		WebElement goodHealthRadioButton = driver.findElement(good_health_radioButton);
		js.executeScript("arguments[0].click();", goodHealthRadioButton);
		
		driver.findElement(amout_of_coverage_field).clear();
		driver.findElement(amout_of_coverage_field).sendKeys(data.get(2));
		WebElement coverageRadioButton = driver.findElement(twanty_years_coverage_radio);
		js.executeScript("arguments[0].click();", coverageRadioButton);
		
		WebElement quote_button = driver.findElement(get_a_quote_button);
		js.executeScript("arguments[0].click();", quote_button);
		
		Thread.sleep(5000);
		
		WebElement quote_result = driver.findElement(quote_results);
		String text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", quote_result);
		
		System.out.println("the quote amounts shown for the state of Montana unique: "+text);
		
	}

}
