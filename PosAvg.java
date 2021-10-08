import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is a child class of Vanet class. This class is focused around reading the vehicleIds from the data file and finding their index.
 * @author Kashaf Mujeeb
 * @version 0.1
 *
 */
public class PosAvg extends Vanet {

	/**
	 * This constructor uses the constructor of parent class Vanet to initialize the objects of this class.
	 * @param vehicleID      The vehicleID that will be initialized
	 */
	
	public PosAvg(String vehicleID) {
		super(vehicleID);
	}
	
	/**
	 * This method finds the index of VehicleID by taking average of (VehicleID +1) and (VehicleID+2).
	 * @return return the index of the vehicleID
	 */

	public int indexOfVehicle() {
	   String id = getVehicleID();
       String idNum_Only = id.substring(3);
		int id_inInt = Integer.parseInt(idNum_Only);
		int idx =0;
        for(int i =1; i < 3; i++) {
		    int before = id_inInt-i; 
		    int after = id_inInt+ i; 
		    idx = (before + after)/2;
		   }
	   
		return idx;
	}
/**
 * This method returns the two distance ids up and two distance id down from the given vehicle Id.
 * @return  returns the string array with the two ids up and two ids down
 * @throws FileNotFoundException
 */
	
	public String[] twoDisId() throws FileNotFoundException {
		String id = getVehicleID();
		String [] twoDis = new String[4];
		String before1 = null; 
		String before2=null;
		String after1 = null;
		String after2 = null; 
		int index =0;
		ArrayList<String> ID = readFile("VANETdata.txt");
		for( int j =0; j < ID.size(); j++) {
			if(ID.get(j).equals(id)) {
				before1 = ID.get(j-1);
				twoDis[0] =before1;
				before2 = ID.get(j-2);
				twoDis[2] = before2;
				after1 =  ID.get(j+1);
				twoDis[1] = after1;
				after2 =  ID.get(j+2);
				twoDis[3] = after2;
			}
	}
		return twoDis;
	}
	
	/**
	 * This method overrides the toString method for postAvg objects
	 * @return it returns a string statement.
	 */
	
	public String toString() {
		try {
			String [] get2dis = twoDisId();
			String result = "This index is average of " + get2dis[0] + " and " + get2dis[1] + ", " + get2dis[2] + " and " + get2dis[3]+ ", and so on.";
			return result;
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * This method reads the given string filename to create an arrayList of all vehicle Ids.
	 * @param filename  this is the filename that will be used to extract the vehicle ids.
	 */
	public ArrayList<String> readFile(String filename) throws FileNotFoundException {
		File f = new File(filename); //opens the passed file
		Scanner scan = new Scanner(f); //scans file
		ArrayList<String> vehid = new ArrayList<String>();
		String[] trimarr = new String[1000];
		
		//reading first three lines.
		scan.nextLine();
		scan.nextLine();
		scan.nextLine();
	    
		String line = scan.nextLine();
		while(scan.hasNext()) {
			trimarr = line.trim().split("\\s++");
			vehid.add(trimarr[1]);
			line = scan.nextLine();
		}
		scan.close();
		return vehid;
		
		
	}
	
	
}
