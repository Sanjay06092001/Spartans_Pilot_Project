package StepDefinition_SixthModule;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AdRepoClass {
	@FindBy(xpath ="//input[@placeholder='User']" )
    public static WebElement username;
    @FindBy(xpath = "//input[@type='password']")
    public static WebElement password;
    @FindBy(xpath = "//span[text()='Submit']")
    public static WebElement submit;
	@FindBy (xpath="//div[text()='Marketplace']")//click the marketplace
	public static WebElement mark;
	
	@FindBy (xpath="//div[@class=\"nav-item-text\"]")//clicking the advertisement
	public static WebElement ad;
	@FindBy (xpath="///div[text()='Show less filters']")//click the filter
	public static WebElement filter;
	@FindBy (id ="id_100")//enter the keyword
	public static WebElement key;
	@FindBy (xpath="//label[@for='id_98'][1]")//click checkbox
	public static WebElement checkbox;
	@FindBy (id  ="id_102")//click minprice
	public static WebElement minprice;
	@FindBy (xpath  ="/input[@id=\"id_103\"]")//click maxprice
	public static WebElement maxprice;
	//6.6
	@FindBy (xpath  ="//button[@id=\"id_157\"]")//click orderBy
	public static WebElement orderBy;
	//select the drop down last published
	//6
	@FindBy (id ="id_100")//enter the keyword
	public static WebElement key1;
	//click show advertisement
	//6.8
//	@FindBy (xpath ="//a[@class='category-title-text']")//enter the community
//	public static WebElement community;
	//6.9
	@FindBy (xpath="//div[@class=\"nav-item-text\"]")//clicking the advertisement
	public static WebElement ad1;

	@FindBy (xpath ="//a[@class='sub-category-text'][1][1]")//enter the activity
	public static WebElement activity;
	@FindBy(xpath="//div[text()=' Ravi ']")
	public static WebElement click;
}
