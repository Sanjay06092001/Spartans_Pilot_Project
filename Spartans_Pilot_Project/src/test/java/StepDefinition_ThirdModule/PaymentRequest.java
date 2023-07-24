package StepDefinition_ThirdModule;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PaymentRequest {
	public static WebDriver driver;
	@Given("User should launch the cyclos website and login with the Correct credentials")
	public void user_should_launch_the_cyclos_website_and_login_with_the_correct_credentials() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	   driver.get("https://cyclos.org");
	   WebDriverWait wait = new WebDriverWait(driver,30);
	   PageFactory.initElements(driver, Repository.class);
	   Repository.product.click();
	   String parent=driver.getWindowHandle();
	   Repository.visitOnlineDemo.click();
	   Set<String>s=driver.getWindowHandles();
	   Iterator<String> I= s.iterator();
	   while(I.hasNext())
	   {
	   String child_window=I.next();
	   if(!parent.equals(child_window))
	   {
	   driver.switchTo().window(child_window);
	   }
	   }
	   wait.until(ExpectedConditions.visibilityOf(Repository.login));
	   Repository.login.click();
	   Repository.username.sendKeys("demo");
	   Repository.password.sendKeys("1234");
	   Repository.submit.click();
	}

	@Given("click on banking option")
	public void click_on_banking_option() throws InterruptedException {
		Thread.sleep(5000);
		Repository.banking.click();
	}

	@Given("click on payment request")
	public void click_on_payment_request() throws InterruptedException {
		Thread.sleep(3000);
		Repository.PaymentRequest.click();
		
	}

	@When("User click an send a new request")
	public void user_click_an_send_a_new_request() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(Repository.newRequest));
	    Repository.newRequest.click();
	    wait.until(ExpectedConditions.visibilityOf(Repository.contactbook));
	}

	@When("Pick the receiver from contact book")
	public void pick_the_receiver_from_contact_book() {
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    Repository.contactbook.click();
		wait.until(ExpectedConditions.visibilityOf(Repository.selectGoldenTravels));
		Repository.selectGoldenTravels.click();
	}

	@When("Enter the amount")
	public void enter_the_amount() {
	    Repository.amount.sendKeys("100");
	}

	@When("enter the expiry date")
	public void enter_the_expiry_date() throws InterruptedException {
	    Repository.date.sendKeys("31/07/2023");
	    Thread.sleep(3000);
	}

	@When("Click the recurring payments in scheduling")
	public void click_the_recurring_payments_in_scheduling() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(Repository.paynow));
		Repository.paynow.click();
		wait.until(ExpectedConditions.visibilityOf(Repository.recurringPayment));
		Repository.recurringPayment.click();
	}

	@When("select the occurance option")
	public void select_the_occurance_option() {
	    Repository.paymentAcceptance.click();
	}

	@When("enter description in the textarea")
	public void enter_description_in_the_textarea() throws InterruptedException {
		Thread.sleep(3000);
	    Repository.description.sendKeys("Transaction is processed");
	}

	@Then("Click confirm")
	public void click_confirm() throws InterruptedException {
		Thread.sleep(3000);
	    Repository.confirm.click();
	}

	@Then("click confirm option in reconfirmation tab")
	public void click_confirm_option_in_reconfirmation_tab() throws InterruptedException {
		Thread.sleep(3000);
	    Repository.reconfirm.click();
	}

	@Then("Check if the transaction is successfully completed or not")
	public void check_if_the_transaction_is_successfully_completed_or_not() throws InterruptedException {
		Thread.sleep(3000);
	    boolean displayed = Repository.successSent.isDisplayed();
	    if (displayed) {
			System.out.println("Transaction status : "+Repository.successSent.getText());
		}else {
			System.out.println("Transaction Failure");
		}
	}

}