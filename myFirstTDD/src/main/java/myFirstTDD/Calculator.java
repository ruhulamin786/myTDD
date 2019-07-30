package myFirstTDD;

import java.util.regex.Pattern;

public class Calculator {
	
	private String defaultDelimiterRegEx = "[,\n]";
	private String newLineDelimiterRegEx = "[\n]";
	private int thresoldNumber=1000;
	public int add(String numbers) throws NegativeNumberException{
		
		int sum=0;
		if(numbers == null || numbers.isEmpty()){
			return sum;
		}
		boolean isNegativeNumberFound=false;
		String exceptionMessage = "negatives not allowed - ";
		String delimiterToUse = defaultDelimiterRegEx;
		String[] numbersArray = null;
		 Pattern pattern = null;
		
		if(numbers.startsWith("//")){
			pattern = Pattern.compile(newLineDelimiterRegEx);
			numbersArray = pattern.split(numbers);
			delimiterToUse = (numbersArray[0]).replace("//", "");
			pattern = Pattern.compile(delimiterToUse);
			numbersArray = pattern.split(numbersArray[1]);
		}else{
			pattern = Pattern.compile(delimiterToUse);
			numbersArray = pattern.split(numbers);
		}
		for (String number : numbersArray){
			int parsedNumber = Integer.parseInt(number.trim());
			if(parsedNumber>thresoldNumber){
				
			}else if(parsedNumber >= 0 && parsedNumber <= thresoldNumber){
			sum=sum+parsedNumber;
			}else{
				exceptionMessage = exceptionMessage+parsedNumber+" ,";
				isNegativeNumberFound=true;
			}
		}
		
		if(isNegativeNumberFound){
			throw new NegativeNumberException(exceptionMessage);
		}
		return sum;
	}
	
	

}
