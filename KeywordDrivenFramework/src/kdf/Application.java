package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.GenericMethods;

public class Application {

	@Test
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelApr17\\TestData.xlsx", "Sheet2");
		Methods mtd = new Methods();
		SoftAssert softassert = new SoftAssert();
		for(int i = 1;i<data.length;i++) {
			
			switch(data[i][3]) {
			case "openBrowser":
				mtd.openBrowser();
				break;
			case "maxBrowser":
				mtd.maximizeBrowserWindow();
				break;
			case "impWait":
				mtd.implementImplicitWait();
				break;
			case "navigateToApp":
				mtd.navigateToApp(data[i][6]);
				break;
			case "enterInTextBox":
				mtd.enterTextBox(data[i][5], data[i][6]);
				break;
			case "clickButton":
				mtd.clickButton(data[i][4],data[i][5]);
				break;
			case "verifyMsg":
				String actualText = mtd.getMessage(data[i][4],data[i][5]);
				String expectedText = data[i][6];
				
				softassert.assertEquals(actualText, expectedText);
				break;
			case "closeApp":
				mtd.closeApplication();
				break;
			case "clickLink":
				mtd.clickLink(data[i][5]);
				break;
			}
			
		}
		softassert.assertAll();
	}
}
