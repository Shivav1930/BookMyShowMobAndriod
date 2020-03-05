package cucumberRunnerTest;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentProperties;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
/*@CucumberOptions(
		features = "Feature"
		,glue={"stepDefinition"},
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:Report/Cucumber.html"},
		monochrome = true
		)public class TestRunner extends AbstractTestNGCucumberTests{

}*/
//@RunWith(Cucumber.class)

@CucumberOptions(
		features = "Feature",
		glue={"stepDefinition"},
		/*tags= {"@firstMovie"},*/
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},
		monochrome = false
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@BeforeClass
	public static void setup() {
		Date date = new Date();
      DateFormat dateFormat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
      String date1= dateFormat.format(date);
      String fileName="Cucumber"+ "_" + date1;
	ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	extentProperties.setReportPath("Report/"+fileName+".html");
	}
}

