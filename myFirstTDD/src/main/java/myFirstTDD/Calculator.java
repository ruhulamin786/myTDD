package myFirstTDD;

public class Calculator {
	
	private String defaultDelimiter = "\n|,";
	private String newLineDelimiter = "\n";
	private int thresoldNumber=1000;
	public int add(String numbers) throws NegativeNumberException{
		
		int sum=0;
		boolean isNegativeNumberFound=false;
		String exceptionMessage = "negatives not allowed - ";
		if(numbers == null || numbers.isEmpty()){
			return sum;
		}
		String delimiterToUse = defaultDelimiter;
		String[] numbersArray = null;
		
		if(numbers.startsWith("//")){
			delimiterToUse = (numbers.split(newLineDelimiter)[0]).replace("//", "");
			numbersArray = numbers.split(newLineDelimiter)[1].split(delimiterToUse);
		}else{
			numbersArray = numbers.split(delimiterToUse);
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
