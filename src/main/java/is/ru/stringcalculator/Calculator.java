package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator 
{
	public static int add(String text)
	{
		if(containsNewLine(text))
		{
			text = replaceNewLine(text);
		}
		if(text.equals(""))
		{
			return 0;
		}
		else if(checkDelimeter(text))
		{
			if(checkCustomDelimeter(text))
			{
				return 0;
			}
			else
				return handleDelimeters(text);
		}
		else if(text.contains(","))
		{
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers)
	{
	    return numbers.split(",");
	}
      
    private static int sum(String[] numbers)
	{
 	    int total = 0;
        for(String number : numbers){
			if(toInt(number) < 0)
			{
				throw new IllegalArgumentException(StringWithNegativeNumbers(numbers));
			}
		    if(toInt(number) <= 1000)
			{
			total += toInt(number);
			}
		}
		return total;
    }
	private static boolean containsNewLine(String text) 
	{
    	return text.contains("\n");
	}
	private static String replaceNewLine(String text) 
	{
    	return text.replace("\n",",");
	}
	private static String StringWithNegativeNumbers(String[] numbers) 
	{
    	String errorMessage = "Negatives not allowed: ";
    	for(String number : numbers) {
    		if(toInt(number) < 0) {
    			errorMessage += number + ", ";
    		} 
    	}
    	if(errorMessage.charAt(errorMessage.length() - 1) == ',') 
		{
    		errorMessage = errorMessage.substring(0, errorMessage.length() - 2);
    	}
    	return errorMessage;
    }
	private static boolean checkDelimeter(String text)
	{
		return (text.charAt(0) == '/' && text.charAt(1) == '/');
	}
	private static boolean checkCustomDelimeter(String text)
	{
		return (text.charAt(0) == '/' && text.charAt(1) == '/' && text.charAt(2) == '[');	
	}
	private static int handleDelimeters(String text)
	{
		String delimeter = String.valueOf(text.charAt(2));
		text = text.substring(4, text.length());
		return sum(text.split(delimeter));
	}

}