/**
 * This class is a child class of Abstract Vanet. It overrides the mailproceCheck method of parent class.
 * @author Kashaf Mujeeb
 * @version 0.1
 *
 */
public class InheritVANET extends AbstractVANET {
     
    private int classVar; 
   /**
    * This constructor initializes the objects of InheritVANET class.
    * @param vehicleName   vehicle name that needs to be initialized 
    * @param vehicleNumber  number of the given vehicle
    * @param vehicleAddress  address of the given vehicle
    * @param i               price of the given vehicle
    */
	public InheritVANET(String vehicleName, int vehicleNumber, String vehicleAddress, int i) {
		super(vehicleName, vehicleNumber, vehicleAddress);
		classVar = i;
		
	}
   
	@Override
	public void mailPriceCheck() {
		//System.out.println("Mailing a check to " + super.getName() + " from " + super.getAddress());
		System.out.println("Sending check from InheritVANET.");
		System.out.println("Mailing check to " + super.getName() + " company for price " + this.classVar+ ".");
	}
	

}
