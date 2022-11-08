import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import java.text.SimpleDateFormat;

public class HomePage
{
   //importing AfterMethod Annotation to close the opened browser After each Method
    @AfterMethod
    public void closeBrowser()
    {
    driver.quit();
    }
    //importing DateFormat by creating object add time
    public String addtime()
    {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }
    //imported inbuilt class through object
    protected  static WebDriver driver;
    //importing before method to open browser and open the url Before each Method
    @BeforeMethod
    public void openBrowser()
    {
        // set the system property for Chrome driver
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        // Create driver object for CHROME browser
        driver = new ChromeDriver();
        //opens and mange and maximize the window
        driver.manage().window().maximize();
        // get the current URL of the page
        driver.get("https://demo.nopcommerce.com/");

    }
    //creating an object for click action to click on the element
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }
    //creating an object for sendKeys to write the string value
    public void writeText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    //creating an object for get text to get text from an element and return the value
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }
    //Test method for Registration
    @Test
    public void Registration()
    {
        // finding a location of register button by classname to click on register button
        clickOnElement(By.className("ico-register"));
        // finding a location of Gender (female)radio button by xpath to select the gender(female)radio button
        clickOnElement(By.xpath("//label[@for=\"gender-female\"]"));
        //finding a location of  first name text box by id to Click on the first name text box and send value
        writeText(By.id("FirstName"),"Dipika");
        //finding a location of last name text box by id to Click on the last name text box and send value
        writeText(By.id("LastName"),"Patel");
        //finding a location of date for date of birth by classname to click and select the date
        Select selectDay = new Select( driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByIndex(7);
        //finding a location of month for month of birth by xpath to click and select the month
        Select selectMonth = new Select (driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByValue("11");
        //finding a location of year for year of birth by xpath to click and select the year
        Select selectYear = new Select (driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByVisibleText("1999");
        // finding a location of email text box  by id to  Click on the email text box and send value
        writeText(By.id("Email"),("pdipika0713" + addtime() +"@gmail.com"));
        //finding a location of company name by id to click on the company name and send value
        writeText(By.id("Company"),"ABC.LTD");
        //finding a location of Newsletter: checkbox by id to unselect or unTick the checkbox
        clickOnElement(By.id("Newsletter"));
        // finding a location of password text box by id to Click on the password text box and send value
        writeText(By.id("Password"),"Dipika123");
        //finding a location of confirmPassword text box by id to Click on the confirmPassword text box and send value
        writeText(By.id("ConfirmPassword"),"Dipika123");
        //finding a location of register button by id to Click on the register button
        clickOnElement(By.id("register-button"));
        //finding a location of string by classname to returns Text of the element
        String regMsg = getTextFromElement(By.className("result"));
        System.out.println(regMsg);

    }
    //Test Method for Products
@Test
public void Products(){
    //finding a location of computers by xpath to click and go in to computers sub menu
    clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/a"));
    //finding a location of desktop by xpath to clicks on desktop
    clickOnElement(By.xpath("//ul[@class=\"sublist\"]/li[1]/a"));
    //finding a location of 1st product string(given name of the product) value to returns Text of the element for Product 1
    String readText1 = getTextFromElement(By.xpath("//div[@class=\"details\"]/h2//a[@ href=\"/build-your-own-computer\"]"));
    System.out.println("Product 1 " + readText1);
    // finding a location of 2nd product string (given name of the product) value to returns Text of the element for Product 2
    String readText2 = getTextFromElement(By.xpath("//div[@class=\"details\"]/h2//a[@ href=\"/digital-storm-vanquish-3-custom-performance-pc\"]"));
    System.out.println("Product 2 " + readText2);
    //finding a location of 3rd product string(given name of the product) value to returns Text of the element for Product 3
    String readText3 = getTextFromElement(By.xpath("//div[@class=\"details\"]/h2//a[@ href=\"/lenovo-ideacentre-600-all-in-one-pc\"]"));
    System.out.println("Product 3 " + readText3);
}
//Test Method for Email a Friend
@Test
    public void EmailAFriend(){
    //  finding the element by xpath of  Apple MacBook Pro picture to get it click on Apple MacBook Pro picture to open the product detail
    clickOnElement(By.xpath("//img[@alt=\"Picture of Apple MacBook Pro 13-inch\"]"));
    //  finding a location of email a friend button by classname to Clicks on the email a friend button
    clickOnElement(By.className("email-a-friend"));
    // finding a location of friend's email Text box by id to Click on the friend's email Text box and send value
    writeText(By.id("FriendEmail"),"dipikapatel44@yahoo.com");
    //finding a location of Your email Text by id to Click on  Your email Text box and send value
    writeText(By.id("YourEmailAddress"),"Pdipika123@gmail.com");
    // finding a location of  personal message Text box by id to Click on the personal message Text box and send value
    writeText(By.id("PersonalMessage"),"Please can you check this Product");
    // finding a location of send email button by class name to Clicks on the send email button
    clickOnElement(By.className("buttons"));
    // finding a location by xpath of the string value to returns Text of the element
    String errorMsg = getTextFromElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]//li"));
    System.out.println(errorMsg);
}
//Test Method for HomePageCategories
  @Test
    public void HomePageCategories(){
      //finding a location of header menu by class name to go through the menu
      clickOnElement(By.className("header-menu"));
      //returns Text of the element of product1 of  by xpath
      String readText1 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]"));
      System.out.println("Category 1 " + readText1);
      //returns Text of the element of product2 of  by xpath
      String readText2 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]"));
      System.out.println("Category 2 " + readText2);
      //returns Text of the element of product3 of  by xpath
      String readText3 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[3]"));
      System.out.println("Category 3 " + readText3);
      //returns Text of the element of product4 of  by xpath
      String readText4 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[4]"));
      System.out.println("Category 4 " + readText4);
      //returns Text of the element of product5 of  by xpath
      String readText5 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[5]"));
      System.out.println("Category 5 " + readText5);
      //returns Text of the element of product6 of  by xpath
      String readText6 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[6]"));
      System.out.println("Category 6 " + readText6);
      //returns Text of the element of product7 of  by xpath
      String readText7 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[7]"));
      System.out.println("Category 7 " + readText7);
  }
    //Test Method for NewsComments
  @Test
    public void NewsComments(){
//finding a location of news button by xpath click on the news button
      clickOnElement(By.xpath("//div[@class=\"news-items\"]/div[2]/div[3]/a"));
      //finding a location of Title Text box by id to Click on Title Text box and send value
      writeText(By.id("AddNewComment_CommentTitle"),"New products");
      //finding a location of Add new comments Text box by id Click on Add new comments Text box and send value
      writeText(By.id("AddNewComment_CommentText"),"New Produts will be added soon");
      //finding a location of Add new comments button by classname Click on Add new comments
      clickOnElement(By.className("buttons"));
      //finding a location of string by classname to returns Text of the element
      String newsMsg = getTextFromElement(By.className("result"));
      System.out.println(newsMsg);
  }
}