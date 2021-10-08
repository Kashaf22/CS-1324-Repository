import java.time.YearMonth;
/**
 * 
 * @author Kashaf Mujeeb
 * @version 0.1
 */
public class InheritDateTime extends AbstractDateTime{
	//In child class we must define all abstract methods.
	//We must also define additional methods.
	
    @Override
    /*the first parameter is the month and the second parameter is the year.
     * print first day and last day of any month in a year 
    **/
    /**
     * This an abstract method inherited from the parent class AbstractDateTime. This method outputs the first and last day of a given month in a given year.
     * @param i   int i is the given month 
     * @param j   int j is the given year
     */
	public void daysOfAnyMonth(int i, int j) {
    	//calculating first and last day of the given month in a given year. 
    	YearMonth ym = YearMonth.of(j, i);

		String firstDay = ym.atDay(1).getDayOfWeek().name();
		String lastDay = ym.atEndOfMonth().getDayOfWeek().name();
    	String output = "In the year 2021, for the " + convertToOrdinal(i) + " month: the first day is " + firstDay +  " and the last day is " + lastDay; 
    	System.out.println(output);
	   	
	}
   /**
    * This is a helper method created in this child class to convert the int month to its ordinal type.
    * @param y  y represents the given month that needs to be converted to its ordinal type
    * @return   returns String representation of int month with its suffix in its ordinal form.
    */
    
    public static String convertToOrdinal(int y) {
	    String[] ordinalSuffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
	    switch (y % 100) {
	    case 11:
	    case 12:
	    case 13:
	        return y + "th";
	    default:
	        return y + ordinalSuffixes[y % 10];

	    }
	 
	    
	    


}
}
