     /**
     * This class is a child class of IntegerList and it adds integers to the list in ascending sorted order.
	 * @author Kashaf Mujeeb
	 * @version 0.1
	 */

   public class SortedList extends IntegerList {
	   
	     /**
		 * This constructor is calling the constructor from the parent class to make an empty list 
		 * with an initial capacity of MIN_CAPACITY.
		 */
		public SortedList() {
			super();
		}

	 /**
	 * This constructor is calling the constructor from the parent class to make an empty list 
	 * with the given capacity.
	 * @param capacity  the capacity that will be used to create the list
	 */
	  public SortedList(int capacity) {
		super(capacity);
		
	}

	/**
	 * Throw an UnsupportedOperationException to disable this method. 
	 * Users of the class cannot insert integers at arbitrary positions in the list.
	 * @param index  index where the integer needs to be inserted
	 * @param integer  integer that needs to be inserted
	 */
	public void insert(int index, int integer) {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method inserts the integer in the list at the position that maintains the sorted order.
	 * 
	 * @param integer integer that needs to be inserted in the list
	 */
	public void add(int integer) {
		//if there are no elements in the list, insert the integer at index 0.
		if (size() == 0) {
			//this super insert method is called from the parent class.
			super.insert(0, integer);
		}
		// If the size is not zero then :
		else {
			for(int j = 0; j < size(); j++) {
				/*
				 * if the integer is less than the integer found through the get method at the given index j
				 * then we put that integer in place of j and move the whole list to the right because 
				 * we want to maintain the ascending order
				 */
				if (integer < super.get(j)) {
					super.insert((j), integer);
					break;
				} 
				/*
				 * if the integer is greater than the last element of the list, then insert the 
				 * integer at the index = size().
				 * Note this size() index did not exist in the list before because last index is always size()-1
				 */
				else if (integer > super.get(size() - 1)) {
					super.insert(size(), integer);
					break;
				}
			}
		}
	}

}
