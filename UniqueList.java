     /**
	 * This class is a child class of IntegerList and it does not allow duplicate integers to be added to the list.
	 * @author Kashaf Mujeeb
	 * @version 0.1
	 */

   public class UniqueList extends IntegerList {
	   /**
		 * This constructor is calling the constructor from the parent class to make an empty list 
		 * with an initial capacity of MIN_CAPACITY.
		 * 
		 */
		public UniqueList() {
			super();
		}
	   
	/**
	 * This constructor is calling the constructor from the parent class to make an empty list 
	 * with the given capacity.
	 * @param capacity The capacity that will be used to create the list
	 */
	public UniqueList(int capacity) {
		super(capacity);
	}
/**
 * This method checks whether the given integer is already in the list before appending it. If so, throw an IllegalArgumentException
 * @param integer  integer to be appended in the list.
 */
	public void add(int integer) {
		//Using contain method to check if the integer is already in the list.
		if (super.contains(integer) == true) {
			throw new IllegalArgumentException("The integer " + integer + " is already in the list.");
		} 
		//if not appending the integer to the list using the add method from parent class.
		else {
			super.add(integer);
		}
	}


	/**
	 * This method checks whether the given integer is already in the list before inserting it.
	 * If so, throw an IllegalArgumentException with the message shown in the unit tests.
	 * @param index   index where the integer needs to be inserted
	 * @param integer  integer that needs to be inserted
	 */
	public void insert(int index, int integer) {
		/*Using contain method from the parent class to check if the integer is already in the 
		 * list
		 */
		if (super.contains(integer) == true) {
			throw new IllegalArgumentException("The integer " + integer + " is already in the list.");
		} 
		// else if is not in the list we are using insert method from the parent class to insert it in the list at the given index.
		else {
			super.insert(index, integer);
		}
	}
}
