package stepDefinition;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import com.bookmyshow.pom.pages.MovieTicketBooking;
import com.bookmyshow.pom.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppiumParallelExecution1 implements Runnable {
   
    String port;
    String udid;
    public static ExtentTest startExtent;
    public ExtentReports extent = ExtentManager.getInstance();
   
    public AppiumParallelExecution1(String portNumber, String udid) {
        this.port = portNumber;
        this.udid = udid;
    }
    AppiumDriver<WebElement> driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();
   
   
    private void openAppAndPerformSomeActions() {
        capabilities.setCapability("deviceName", "My Mobile Device");
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.bt.bms");
        capabilities.setCapability("appActivity", "com.movie.bms.splashscreen.SplashScreenActivity");
       
        try {
            driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:" + port + "/wd/hub"), capabilities);
            Thread.sleep(10000);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
        
    }
   
        public static void main(String args[]) {
        Runnable r1 = new AppiumParallelExecution1("5000", "4200cc386a65847f"); //device id of first mobile device
        Runnable r2 = new AppiumParallelExecution1("4723", "2ed7a8b8"); //device id of second mobile device  
       
        new Thread(r1).start();
        new Thread(r2).start();
        
    }

      public void SelectEngLang () throws Exception{startExtent=extent.startTest("End To End Scenario cucumber");
   	 	Thread.sleep(5000);		
   	 	MovieTicketBooking.SelectEngLang(startExtent,driver);
		MovieTicketBooking.Movies(startExtent,driver);
		MovieTicketBooking.EnterMovieName(startExtent,driver);
   		
   	 }
        
    public void run() {
        openAppAndPerformSomeActions();
        try {
			SelectEngLang ();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}