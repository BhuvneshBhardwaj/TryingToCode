package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {

	@DataProvider(name="inputs")
	public Object[][] provideData() {
		return new Object[][] { { "language", "Java" }, { "framework", "selenium" } };

	}

	@Test(dataProvider = "inputs")
	public void getData(String input1,String input2 ) {
		System.out.println(input1);
		System.out.println(input2);

	}

}
