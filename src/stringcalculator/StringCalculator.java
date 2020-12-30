package stringcalculator;

import java.util.Iterator;
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
		for (String num : inputString.replace("\n", delimiter()).split(delimiter())) {
			Integer integerValue = toInt(num);
			if(integerValue < 1000) {
				list.add(toInt(num));	
			}
		}

		return list;
	}

	/**
	 * Method to handle handle format exception while inputting with custom
	 * delimiters
	 * @param inputString
	 * @return integer
	 */
	private static final Integer toInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return 0;
		}
	}
	/**
	 * delimiter method is to replace the \n to comma
	 * @return the comma
	 */
	private String delimiter() {
		return hasCustomDelimiter() ? customDelimiter() : ",";
	}

	/**
	 * customDelimiter is to get the delimiter in the inputString
	 * @return delimiter
	 */
	private String customDelimiter() {
		return inputString.substring(2, 3);
	}

	/**
	 * hasCustomDelimiter is to check whether the delimiter is present
	 * @return boolean value
	 */
	private boolean hasCustomDelimiter() {
		return inputString.startsWith("//");
	}

	/**
	 * Method to throw exception for negative number inputs
	 */
	private void throwIfNegatives() {
        List<Integer> negatives = filterForNegativeNumbers();

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(formatExceptionMessage(negatives));
        }
    }

	/**
	 * FormatExceptionMessage for negative numbers
	 * @param negative numbers
	 * @return the message to be thrown
	 */
    private static String formatExceptionMessage(List<Integer> negatives) {
        StringBuilder sb = new StringBuilder("Negatives not allowed: ");

        for (Iterator<Integer> itr = negatives.iterator(); itr.hasNext();) {
            sb.append(itr.next());

            if (itr.hasNext()) sb.append(", ");
        }

        return sb.toString();
    }
    
    /**
     * Method to list out the negative numbers in the given numbers
     * @return negative numbers list
     */
    private List<Integer> filterForNegativeNumbers() {
        List<Integer> negatives = new LinkedList<Integer>();
        for (Integer num : toNumbers()) {
            if (num < 0) {
                negatives.add(num);
            }
        }
        return negatives;
    }
}
