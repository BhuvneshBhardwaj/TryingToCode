package practice;

import appcode.SomeClassToTest;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest {
	@Test(groups = "calculator")
	public void sumTest() {
		Calc calc = new Calc();

		int resultadd = calc.add(10, 20);
		assertEquals(resultadd, 30);
	}

	@Test(groups = "calculator")
	public void subTest() {
		Calc calc = new Calc();
		int resultsub = calc.sub(10, 20);
		assertEquals(resultsub, -10);
	}

	@Test(groups = "calculator")
	public void mulTest() {
		Calc calc = new Calc();
		int resultmul = calc.mul(10, 20);
		assertEquals(resultmul, 200);
	}

	@Test(groups = "calculator")
	public void divTest() {
		Calc calc = new Calc();
		int resultdiv = calc.div(80, 20);
		assertEquals(resultdiv, 4);
	}

	@Test(groups="strings")
	//testing SomeClassToTest
	public void test() {
		SomeClassToTest scttObj = new SomeClassToTest();
		String concat = scttObj.addStrings("Bhuvnesh", "Bhardwaj");
		Assert.assertEquals(concat, "Bhuvnesh Bhardwaj");

	}
}
