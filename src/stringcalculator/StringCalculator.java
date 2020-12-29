package stringcalculator;

import java.util.LinkedList;
import java.util.List;

/**
 *  The StringCalculator class provides methods to perform addition of given two numbers.
 *  @author Pavithra Ganesan
 */
public class StringCalculator {

	/** To take the input from given String value*/
	private final String inputString;

	/** Constructor for the class StringCalculator where the 
	 *  inputString is globally instantiated
	 */
	public StringCalculator(String inputString) {
		this.inputString = inputString;
	}

	/**
	 * add method where the method call for addition is called
	 * @return
	 */
	public int add() {
		if ("".equals(inputString)) // If empty string is given, 0 will be returned
			return 0;		

		return addTheNumbers();
	}

	/**
	 * Method having logic to perform addition 
	 * @return sum
	 */
	private int addTheNumbers() {		
		int sum = 0;
		for (Integer num : toNumbers()) {
			sum += num;
		}
		return sum;
	}

	/**
	 * Method to convert given strings to numbers ignoring their delimiters
	 * @return list
	 */
	private final List<Integer> toNumbers() {
		List<Integer> list = new LinkedList<Integer>();
		for (String num : inputString.split(",")) {
			list.add(Integer.parseInt(num));
		}

		return list;
	}

}
