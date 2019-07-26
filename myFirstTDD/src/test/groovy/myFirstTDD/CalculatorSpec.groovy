package myFirstTDD

import spock.lang.Specification

class CalculatorSpec extends Specification{

	def "Sum of Two numbers "(){
		given:
		Calculator calculator = new Calculator();
		when:
		int sumReturned = calculator.add(numbers);
		then:
		sumReturned == sumExpected
		where:
		numbers     | sumExpected
		"1,2"  | 3
		"2"   | 2
		""|0
	}
	
	def "Sum of Unknown Numbers numbers "(){
		given:
		Calculator calculator = new Calculator();
		when:
		int sumReturned = calculator.add(numbers);
		then:
		sumReturned == sumExpected
		where:
		numbers     | sumExpected
		"1,2,3,4,5,6,7"  | 28
		"1,2,3"   | 6
		"1,2"  | 3
		"2"   | 2
		""|0
	}
}
