
     /**
	 * This class is a child class of IntegerList. 
	 * Objects of this subclass cannot be modified after they are created.
	 * To implement this behavior, this class will override each IntegerList mutator method so that it throws an UnsupportedOperationException.
	 * @author Kashaf Mujeeb
	 * @version 0.1
	 */

   public class ImmutableList extends IntegerList {
	
	/**
	 * This constructor is creating an immutable list. 
	 * @param integers  integers is representing the list
	 */
	public ImmutableList(int... integers) {

		for (int k = 0; k < integers.length; k++) {
			//Super. is calling the parent class method insert to add the elements from at the given index k in the list.
			super.insert(k, integers[k]);
		}
	}

	/**
	 * 
	 * This method is overriding the method from parent class. Since this class is creating immutable list, 
	 * This add method will throw an exception if somebody tries to add an element to the list 
	 * @param integer integer to be added in the list
	 */
	public void add(int integer) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method is overriding the insert method from the parent class. Since the list created in this class are unchangeable, hence
	 * an exception will be thrown to the user.
	 * @param index    index where the elements need to be inserted
	 * @param integer  integer that needs to be inserted
	 */
	public void insert(int index, int integer) {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method is overriding the remove method from the parent class. Since this class is focused around 
	 * immutable lists, the remove method will throw an exception in case if the user tries to reomve an element from the list
	 * 
	 * @param index index where the element needs to be removed from
	 */
	public int remove(int index) {
		throw new UnsupportedOperationException();
	}

	

}
