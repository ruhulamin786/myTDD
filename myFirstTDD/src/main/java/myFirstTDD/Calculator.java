package myFirstTDD;

public class Calculator {
	
	public int add(String numbers){
		int sum=0;
		if(numbers == null || numbers.isEmpty()){
			return sum;
		}
		String[] numbersArray = numbers.split(",");
		for (String number : numbersArray){
			sum=sum+Integer.parseInt(number);
		}
		
		return sum;
	}

}
