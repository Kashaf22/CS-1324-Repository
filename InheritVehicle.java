import java.text.DecimalFormat;
/**
 * This class is a child class of AbstractVehicle. It takes the given vehicleId and calculates it average, floor, and ceiling values. It also finds a character that corresponds with the average value of the vehicleiD on the ASCII table
 * @author Kashaf Mujeeb
 * @version 0.1
 */

public class InheritVehicle extends AbstractVehicle {

	private Vanet vanet;
/**
 * This constructor initializes the InheritVehicle objects with Vanet class object 
 * @param vanet Object of vanet class
 */
	public InheritVehicle(Vanet vanet) {
		this.vanet = vanet;
	}
	/**
	 * This method uses the calAverage() method to find the average of the given vehicleID. Then, it converts that average int value to a character value from ASCII table.
	 */
	public char letterAverage() {
		int[] veh = calAverage();
		//Average is stored at index 2 of the array.
		int letterAvg = veh[2];
		char letter = (char) letterAvg;
		return letter;

}

	/**
	 * This method takes a given VehicleID and finds its floor, ceiling , and asciiValue. It then returns these three values in an int array.
	 * @return  returns the integer array with ceiling, floor, and average values of the given vehicleIO
	 */

	public int[] calAverage() {
		String veh = vanet.getVehicleID();
		int [] averageVals = new int[3];
		double sum=0;
	    double average =0;
	    for(int i=0; i< veh.length(); i++)
	    {
	      int asciiValue = veh.charAt(i);
	      sum = sum+ asciiValue;
	    }
	    average = sum/veh.length();
	    //rounding off the average to 2 decimal places
	    double round_2D = change(average,2);
	    //Finding floor and ceiling values of the average
	    double ceil = Math.ceil(round_2D);
	    averageVals[0] = (int) ceil;
	    double floor = Math.floor(round_2D);
	    averageVals[1] = (int) floor;
	    
	    //Calculations to determine average
	  //Finding only the part before decimal place for subtraction later
	    int y = (int) change(average,0);
	    //Converting the var y to double 
	    double beforeDecPoint = (double) y;
	    double afterDecPoint = round_2D - beforeDecPoint;
	    //if the fraction is less than 0.50,the Average isfloorof the value. Otherwise, the Averageisthe ceiling.
	    if (afterDecPoint > 0.50) {
	      int averageFinal = (int) ceil;
	      averageVals[2] = averageFinal;
	}
	    else {
	      int averageFinal = (int) floor;
	      averageVals[2] = averageFinal;
	    }
	    		
		return averageVals;
	}
	
	/**
	 * This is the helper method created for the char letterAverage method to truncate a double value to required number of decimal points 
	 * @param value    The double value that needs to be modified
	 * @param decimalpoint   The number of decimal points we need in the double value.
	 * @return          returns the truncated double with required decimal value palces.
	 */
	
	static double change(double val, int dec_point)
    {
  
        val = val * Math.pow(10, dec_point);
        val = Math.floor(val);
        val = val / Math.pow(10, dec_point);
 
  
        return val;
    }

}
