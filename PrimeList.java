     /**
	 * This This subclass behaves quite differently from the parent class.
	 * Rather than add integers one-by-one, the user specifies an upper bound, and the add method appends all of the prime numbers that are less than or equal to this value that are not already in the list.
	 * @author Kashaf Mujeeb
	 * @version 0.1
	 */
public class PrimeList extends IntegerList {
	
	private static final int FIRST_PRIME = 2;
	
	/**
	 * This constructor is calling the constructor from the parent class to make an empty list with an initial capacity of MIN_CAPACITY.
	 */
	public PrimeList() {
		super();
	}

	/**
	 * This constructor constructs a list that contains all the prime numbers less than or equal to
	 * the given upperbound in ascending order.
	 * 
	 * @param upperBound  the given upperBound
	 */
	public PrimeList(int upperBound) {
		// The parent class constructor called to create an empty list with MIN_CAPACITY.
		super();
		//if upperbound is 0 or less than 0 we throw an exception because prime numbers are positive and greater than 0 always.
		if (upperBound <= 0) {
			throw new IllegalArgumentException("The upper bound must be positive.");
		}
		for (int j = 1; j <= upperBound; j++) {
			//Helper methods used to check if the given number j is a prime or not
			if (Prime(j) == true) {
				/*if it is then we use the insert method from parent class to insert that prime number at the index size() in that way when new elements are added the whole list
				* the whole list will be pushed to the right.
				*/ 
				super.insert(size(), j);
			}
		}

	}
	
	/**
	 * This method adds all the prime numbers greater than the last prime in the list and less than or equal to the given upper bound (in ascending order).
	 * @param upperBound the given upperBound for prime numbers.
	 */
	public void add(int upperBound) {
		//if there are no elements in the list and the given upperbound is less than 2, we throw execption
		if (super.size() == 0 && upperBound < FIRST_PRIME) {
			throw new IllegalArgumentException("The upper bound cannot be less than 2.");
		}
		
		//if the list is empty, we will add the prime numbers to it considering the Upperbound.
		if (super.size() == 0) {
			for (int i = FIRST_PRIME; i <= upperBound; i++) {
				if (Prime(i) == true) {
					super.insert(size(), i);
				}
			}
			//if the last element of the list is equal to the upperbound we give an error.
		} else if (super.get(size() - 1) == upperBound) {
			throw new IllegalArgumentException(
					"The upper bound must be greater than the last prime " + "in the list: " + upperBound + ".");
		} else {
			for (int j = super.get(size() - 1) + 1; j <= upperBound; j++) {
				if (Prime(j) == true) {
					super.insert(size(), j);
				}
			}
		}

	}

	/**
	 * This method throws an UnsupportedOperationException to disable itself.
	 * @param index
	 * @param integer
	 */
	public void insert(int index, int integer) {
		throw new UnsupportedOperationException();
	}


	/**
	 * This method removes all of the integers with indices greater than or equal to the given index and return the number that were removed
	 * @param index index where the number has to be removed from.
	 * @return the number of integers that were removed
	 */
	public int remove(int index) {
		//we will return this removed_Num.
		int count = 0;
		
		int size = size();
		
		if (index < 0 || index >= size) {
			String message = "The index is outside the range [0, " + (size - 1) + "].";
			throw new IndexOutOfBoundsException(message);
		}
		for (int j = index ; j < size; j++) {
			//calling parent class remove method to remove the number.
			super.remove(index);
			//keeping a count of removed numbers.
			count++;
		}
		return count;
	}

	/**
	 * This is a helper method created to check if the given number is prime or not.
	 * @param number the number to be checked if it is prime or not
	 * @return this method returns true if the numer is prime and false otherwise
	 */
	public boolean Prime(int number) {
		int z  = 0;
		
		boolean result = false;
		
		for (int x = 1; x <= number; x++) {
			if (number % x == 0) {
				z++;
			}
		}
		if (z == 2) {
			result = true;
		}
		return result;
	}

}
