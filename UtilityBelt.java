/**
* This class provides several useful static methods and is part of the CS111 course material
* MiraCosta College 2020
*
* @author Nery Chapeton-Lamas <nery@miracosta.edu>
* @author Gabriel Siguenza <gebsiguenza@gmail.com>
*
* @version 1.2
*/

import java.util.Scanner;

public class UtilityBelt
{
	private static Scanner keyboard = new Scanner(System.in); //used by all methods, MUST be kept clean

	/**
	* Centers and prints text value within total width (like width in printf) given for one line,
	* ends with new line (uses getCentered method)
	*
	* @param width minimum width for one line, assuming width is greater than text length
	* @param text string value to be displayed in centered format
	*/
	public static void printCentered(int width, String text)
	{
		System.out.println( UtilityBelt.getCentered(width, text) );
	}

	/**
	* Centers and returns text value within total width (like width in printf) given
	*
	* @param width minimum width for one line, assuming width is greater than text length
	* @param text string value to be put in centered format
	* 
	* @return text centered within width given, padded on right with spaces
	*/
	public static String getCentered(int width, String text)
	{
		int leftWidth, rightPadding;
		String specData, specPadding, fullSpec;

		leftWidth = (width + text.length() ) / 2;
		rightPadding = width - leftWidth;
		
		specData = "%" + leftWidth + "s";
		specPadding = "%" + rightPadding + "s";
		fullSpec = specData + specPadding;

		return String.format(fullSpec, text, ""); //"" is so spaces get padded to the right
	}

	/**
	* Creates line of text using given length and symbol
	*
	* @param length number of characters long line should be
	* @param symbol character to use in line
	*
	* @return String of given length of symbols, no new line at the end
	*/
	public static String getLine(int length, char symbol)
	{
		String result = "";
		
		for(int i = 0; i < length; i++)
		{
			result += symbol;
		}
		
		return result;
	}

	/**
	* Reads input from user until valid integer value entered (error-checked using bounds)
	*
	* @param prompt string value containing the question to ask user for input (assuming in format "question: ")
	* @param lower an integer for the lower bounds for input, assume lower < upper
	* @param upper an integer for the upper bounds for input, assume upper > lower
	*
	* @return returns integer value between lower and upper (inclusive)
	*/
	public static int readInt(String prompt, int lower, int upper)
	{
		String temp;
		int result;
		boolean isNotValid;
		
		isNotValid = true; // initialize loop variables, compiler will complain because they are initialized in try/catch
		result = 0;
		
		do
		{
			System.out.print(prompt);
			temp = keyboard.nextLine();
			
			try
			{
				result = Integer.parseInt(temp);
				isNotValid = (result < lower) || (result > upper);
				
				if(isNotValid)
				{
					System.out.println("ERROR: please enter value between " + lower + " - " + upper);
				}
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Error: integer input is required");
			}
			
		} while(isNotValid);


		return result;
	}
	
	/**
	* Reads input from user and returns exactly what they typed in
	*
	* @param prompt String value containing the question to ask user for input (assuming in format "question: ")
	*
	* @return returns String of whatever user typed in
	*/
	public static String readString(String prompt)
	{
		String result;
		
		System.out.print(prompt);
		result = keyboard.nextLine();
		
		return result;
	}
	
	
	/**
	* Reads input from user until valid double value entered (error-checked using bounds)
	*
	* @param prompt string value containing the question to ask user for input (assuming in format "question: ")
	* @param lower an double for the lower bounds for input, assume lower < upper
	* @param upper an double for the upper bounds for input, assume upper > lower
	*
	* @return returns double value between lower and upper (inclusive)
	*/
	public static double readDouble(String prompt, double lower, double upper)
	{
		String temp;
		double result;
		boolean isNotValid;
		
		isNotValid = true;
		result = 0;
		
		do
		{
			System.out.print(prompt);
			temp = keyboard.nextLine();
			
			try
			{
				result = Double.parseDouble(temp);
				isNotValid = (result < lower) || (result > upper);
				
				if(isNotValid)
				{
					System.out.println("ERROR: please enter value between " + lower + " - " + upper);
				}
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("ERROR: double input is required");
			}
		} while(isNotValid);


		return result;
	}


	/**
	* Reads input from user until valid char value entered (error-checked using validChars)
	*
	* @param prompt string value containing the question to ask user for input (assuming in format "question: ")
	* @param validChars string value containing exhaustive list of all valid chars (i.e., "YyNn")
	*
	* @return returns char value within validChars provided
	*/
	public static char readChar(String prompt, String validChars)
	{
		String temp;
		char result;
		boolean isNotValid;
		
		isNotValid = true;
		result = 0;
		
		do
		{
			System.out.print(prompt);
			temp = keyboard.nextLine();
			try
			{
				result = temp.charAt(0);
				isNotValid = validChars.indexOf(result) == -1;
			
				if(isNotValid)
				{
					System.out.println("ERROR: please enter one of the following valid characters: " + validChars);
				}
			}
			catch(StringIndexOutOfBoundsException sOutOfBounds)
			{
				System.out.println("ERROR: input type does not match");
			}
		} while(isNotValid);


		return result;
	}
	
  /**
   * Reformats string data as a title (capitalizes first letter of every word and removes extra whitespace)
   * 
   * @param value string data to be reformatted
   * 
   * @return returns new string in title format
   **/ 
	public static String toTitle(String value)
	{
		StringBuffer titledSentence = new StringBuffer();
		String[] words = value.split(" ");
		
		for(String word : words)
		{
			word = UtilityBelt.toTitleWord(word);
			titledSentence.append(word + " ");
		}
		
		return titledSentence.toString().trim(); //trim off last space
	}
	
	/**
	 * Helper method for toTitle method, returns reformatted and appended string as a capitalized word
	 * 
	 * @param word string value passed in as a single word with no leading or trailing whitespace
	 * 
	 * @return returns appended string with capitalization
	 **/ 
	private static String toTitleWord(String word)
	{
		char firstLetterUpper = Character.toUpperCase( word.charAt(0) );
		String restOfWordLower = word.substring(1).toLowerCase();
		
		return firstLetterUpper + restOfWordLower;
	}
}
