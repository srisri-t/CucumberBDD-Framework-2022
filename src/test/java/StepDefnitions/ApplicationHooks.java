/**
 *************************** 		Do not change anything in this file			 **************************
 */
package StepDefnitions;

import com.qa.base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class ApplicationHooks extends TestBase {

	@Before
	public void setUP() throws IOException {
		initialization();

	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		try {

		if (scenario.isFailed()) {
			closeBrowser();
			driver.quit();
		} 			}
		catch (Exception e)
		{
			e.printStackTrace();
			driver.quit();
		}
	}
}
