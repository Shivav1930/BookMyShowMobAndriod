package stepDefinition;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.bookmyshow.pom.testcases.base.BaseTest;
import com.bookmyshow.pom.util.ExtentManager;
import com.bookmyshow.pom.util.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import com.bookmyshow.pom.base.BasePage;
import com.bookmyshow.pom.pages.LoginPage;
import com.bookmyshow.pom.pages.MovieTicketBooking;
import com.bookmyshow.pom.pages.Mughal;
import com.bookmyshow.pom.testcases.base.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test_Steps extends BaseTest {

public ExtentReports extent = ExtentManager.getInstance();
    public static ExtentTest startExtent;
public static ExtentTest test;
public static WebDriver driver;
public static WebDriver driver2;
public  LoginPage loginTest;
public  BasePage utility;

@Given("^The application is launched$")

public void startTest()
   {
    //Set up desired capabilities and pass the Android app-activity and app-package to Appium
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("BROWSER_NAME", "Android");
    capabilities.setCapability("udid", "4200cc386a65847f");    
    capabilities.setCapability("deviceName","Galaxy J7 Max");
    capabilities.setCapability("platformName","Android");
    capabilities.setCapability("platformversion", "7.0");
    capabilities.setCapability("appPackage","com.bt.bms");
    capabilities.setCapability("appActivity","com.movie.bms.splashscreen.SplashScreenActivity");
   
    DesiredCapabilities capabilities2 = new DesiredCapabilities();
    capabilities2.setCapability("BROWSER_NAME", "Android");
    capabilities2.setCapability("udid", "2ed7a8b8");
    capabilities2.setCapability("deviceName","Galaxy J7 Max");
    capabilities2.setCapability("platformName","Android");
    capabilities2.setCapability("platformversion", "9");
    // config the app
    capabilities2.setCapability("appPackage","com.bt.bms");
    capabilities2.setCapability("appActivity","com.movie.bms.splashscreen.SplashScreenActivity");
   
    try {
    driver = new AndroidDriver<WebElement>(new URL ("http://0.0.0.0:4723/wd/hub"), capabilities);
    //driver2 = new AndroidDriver<WebElement>(new URL ("http://0.0.0.0:5000/wd/hub"), capabilities2);
} catch (MalformedURLException e) {
e.printStackTrace();
}
    /*loginTest =new LoginPage();
    utility=new BasePage();*/
   }
 
@When("^English is selected as the language$")
public void SelectEngLang () throws Exception
{startExtent=extent.startTest("End To End Scenario cucumber");
Thread.sleep(5000);
MovieTicketBooking.SelectEngLang(startExtent,driver);
//MovieTicketBooking.SelectEngLang(startExtent,driver2);

}

@Then ("^Movies is selected in the header$")
public void Movies() throws Exception{
MovieTicketBooking.Movies(startExtent,driver);
// MovieTicketBooking.Movies(startExtent,driver2);
}

@Then("^Movie name is entered in the field$")
public void EnterMovieName() throws Exception{
MovieTicketBooking.EnterMovieName(startExtent,driver);
//MovieTicketBooking.EnterMovieName(startExtent,driver2);
}

@Then("^proceed to booking$")
public void Book() throws Exception{
MovieTicketBooking.Book(startExtent,driver);
//MovieTicketBooking.Book(startExtent,driver2);
}
@When("^the date and time is selected$")
public void DateTime() throws Exception{
MovieTicketBooking.DateTime(startExtent,driver);
//MovieTicketBooking.DateTime(startExtent,driver2);
}
@Then("^accept the terms and conditions$")
public void Tc() throws Exception{
MovieTicketBooking.Tc(startExtent,driver);
//MovieTicketBooking.Tc(startExtent,driver2);
}
@When("^seat is selected$")
public void Selecttheseats() throws Exception{
MovieTicketBooking.Selecttheseats(startExtent,driver);
// MovieTicketBooking.Selecttheseats1(startExtent,driver2);
}
@Then("^Enter the personal details$")
public void Details() throws Exception{

MovieTicketBooking.Details(startExtent,driver);
//MovieTicketBooking.Details1(startExtent,driver2);
}

/*public void quit() {
       if (extent != null) {
           extent.endTest(startExtent);
           extent.flush();
       }
       if (driver != null) {
           try {
               driver.quit();
           } catch (Exception e) {
               driver.quit();
           }
       }
   }*/

}