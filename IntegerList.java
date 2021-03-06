import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Resizable array structure for integers. Internal array doubles at 100% 
 * capacity and halves at 25% capacity.
 * 
 * @author Cameron Bost
 * @version 0.2
 */
public class IntegerList {
	
	/** Internal array, holds contents of list. */
	private int[] array;
	/** Number of occupied cells in internal array. */
	private int size;
	/** Minimum length allowed for internal array. */
	private static final int MIN_CAPACITY = 2;
	
	/**
	 * Construct an empty list with an initial capacity of MIN_CAPACITY.
	 */
	public IntegerList() {
		array = new int[MIN_CAPACITY];
		size = 0;
	}
	
	/**
	 * Construct an empty list with the given capacity.
	 * 
	 * @param capacity  the initial length of the internal array
	 * @throws IllegalArgumentException  if capacity is less than MIN_CAPACITY
	 */
	public IntegerList(int capacity)
	
	{
		    //if given capacity is less than MIN_CAPACITY; throw an exception.
			if(capacity < MIN_CAPACITY) 
			{
				throw new IllegalArgumentException("The capacity cannot be less than 2.");
			}
			else
			{
				//If capacity is greater than the MIN_CAPACITY; make a new array with capacity = capacity.
				array = new int [capacity];
			}
		
	}
	
	/**
	 * Append the given integer to the end of the list.
	 * 
	 * @param integer  the integer to be appended
	 */
	public void add(int integer) {
		insert(size, integer);
		
		
	}
	
	/**
	 * Return true if the given integer is in the list; otherwise, return 
	 * false.
	 * 
	 * @param integer  the integer to search for
	 * @return true if integer is in list else false
	 */
	public boolean contains(int integer) {
	    /*
	     * Create a boolean variable to return this value according to
	     * if and else statement
	     */
		
		boolean output = false;
		
		for(int j =0; j < size; ++j)
		{
			if(array[j]== integer) 
			{
				output = true;
				//Returning true because the given integer is in the list.
				return output; 
			}
			
		}
		return output;
	}
	
	/**
	 * Return the integer at the given index in the list.
	 * 
	 * @param index  the index of the integer to return
	 * @return the integer at the given index
	 * @throws IndexOutOfBoundsException  if index is negative or greater than 
	 *         or equal to size
	 */
	public int get(int index) {
	   
		
		 
		//if returnInteger is the integer at the given index in the list then:
		//if index is less than 0; throw an exception of index outside of range.
		if(index < 0 ||index >= this.size()) 
		{
			throw new IndexOutOfBoundsException("The index is outside the range [0, " + (size-1) + "].");
			
		}
		else {
			int returnInteger = array[index];
			return returnInteger;
		}
		/*
		 * if the index is greater than or equal to the given integers in the list; 
		 * we know it is out of bounds as well. We call size() method to find out the number of elements in the list 
		 */
		
		
	}
	
	/**
	 * Insert the given integer at the given index in the list. Shift the 
	 * existing integers to the right to make room.
	 * 
	 * @param index  the index at which the given integer is to be inserted
	 * @param integer  the integer to be inserted
	 * @throws IndexOutOfBoundsException  if index is negative or greater than 
	 *                                    size
	 */
	public void insert(int index, int integer) {
		if (index < 0 || index > size) {
			String message = "The index is outside the range [0, " + size 
					+ "].";
			throw new IndexOutOfBoundsException(message);
		}
		
		// If the array is full, double its capacity.
		if (size == array.length) {
			array = Arrays.copyOf(array, 2*array.length);
		}
		
		// Shift the integers at and above the given index to make room.
		for (int idx = size - 1; idx >= index; --idx) {
			array[idx + 1] = array[idx];
		}
		
		array[index] = integer;
		++size;
	}
	
	/**
	 * Remove and return the integer at the given index. Shift the subsequent 
	 * integers in the list to the left to fill the gap.
	 * 
	 * @param index  the index of the integer to remove
	 * @return the removed integer
	 * @throws IndexOutOfBoundsException  if index is negative or greater than 
	 *                                    or equal to size
	 */
	public int remove(int index) {
		if (index < 0 || index >= size) {
			String message = "The index is outside the range [0, "
					+ (size - 1) + "].";
			throw new IndexOutOfBoundsException(message);
		}
		
		// Save the integer to be returned in a temporary variable.
		int removedInt = array[index];
		
		// Shift the integers above the given index to fill the gap.
		for (int idx = index + 1; idx < size; ++idx) {
			array[idx - 1] = array[idx];
		}
		
		// Reduce the size. (Note: This variable determines the range of valid 
		// indices, so there is no need to overwrite any array elements.)
		--size;
		
		// If the array is 1/4 or less full and the length is greater than the 
		// minimum capacity, halve the capacity.
		if (4*size <= array.length && array.length > MIN_CAPACITY) {
			
			// Don't allow the capacity to drop below the minimum.
			int newCapacity = Math.max(array.length / 2, MIN_CAPACITY);
			array = Arrays.copyOf(array, newCapacity);
		}
		
		return removedInt;
	}
	
	/**
	 * Return the number of integers in the list.
	 * 
	 * @return the number of integers in the list
	 */
	public int size() 
	{
		return size;
	}
	
	/**
	 * Return a String representation of the list with "[" as the prefix, "]" 
	 * as the suffix, and ", " as the delimiter between integers.
	 */
	@Override
	public String toString() {
		//We are using StringJoiner class to add the prefix and suffix and comma as a delimiter between the integers.
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		
		
		for(int y =0 ; y < size; ++y) 
		{
			String integer = String.valueOf(array[y]);
			//Storing each integer as a String 
			//Using .add to add the integers to the StringJoiner object
			joiner.add(integer);
		}
		return joiner.toString();
		
	}
}