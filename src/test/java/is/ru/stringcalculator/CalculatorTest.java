package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest 
{

	public static void main(String args[]) 
	{
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
	
	@Test
	public void testNumberWithNewLine(){
		assertEquals(3, Calculator.add("1\n2"));
	}
	
	@Test 
	public void testNumberWithNewLineAndComma(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}
		@Test(expected = IllegalArgumentException.class)
	public void testStringWithNegativeNumbers(){
    	assertEquals(3, Calculator.add("-1,2"));
    	assertEquals(2, Calculator.add("2,2,-2,1,-3,-5,2,1"));
	}
	@Test
	public void testNumberBiggerThan1000(){
		assertEquals(2000, Calculator.add("1001,1000,500,500"));
	}
	@Test
    public void testDelimiterNormal() {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
}
