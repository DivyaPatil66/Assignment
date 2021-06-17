package com.cognixia.TestNG.com.cognixia.TestNGProjects;
import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognixia.training.MavenTestNGSelenium.common.ReadFromExcel;

public class GoogleExternalFromExcel  extends TestNGBase{

	@Test (dataProvider = "getDataFromExcel")
	public void myTest(String searchstring, String Expectedstring ) {
		String Searchstring1 = searchstring;
		searchbox.sendKeys(Searchstring1);
		searchbox.submit();
		String expected = Expectedstring;
		String actual = driver.getTitle();
        Assert.assertEquals(driver.getTitle(),expected);
	}

	@DataProvider
	public Object[][] getDataFromExcel() throws IOException {
		return ReadFromExcel.readExcelData("resources/Selenium.xlsx");
	}
}