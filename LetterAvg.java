import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class finds out the total number of vehicle that start with the same character.
 * @author Kashaf Mujeeb
 * @version 0.1
 */
public class LetterAvg {
    
	private char x;
	
/**
 * This constructor initializes the Letteravg object with the letterAvergae()method of the inheritVehicle class
 * @param x initializing the char with letterAverage method
 */
	public LetterAvg(char x) {
     this.x = x;
	}
/**
 * This method calculates the number of vehicles in the vanet data file that start with the same character.
 * @return     returns the number of vehicles that start with the same specific character
 * @throws FileNotFoundException 
 */
	public int numberOfVehicleWithLetterAvg() throws FileNotFoundException {
		char common = x;
		ArrayList<String> ids = readFile("VANETdata.txt");
		int count =0;
		for(int i =0; i < ids.size(); i++) {
			 if (ids.get(i).charAt(0) == common) {
				 count++;
			 }
		}
		return count;
	}
/**
 * This method makes an arrayList of all ids that start with the same character.
 * @return returns the arrayList of all ids starting with the same character.
 * @throws FileNotFoundException
 */
	public ArrayList<String> ID() throws FileNotFoundException {
		ArrayList<String> Id =  readFile("VANETdata.txt");
		ArrayList<String> all_ID = new ArrayList<String>();
		char common = x;
		for(int i =0; i < Id.size(); i++) {
			 if (Id.get(i).charAt(0) == common) {
				 all_ID.add((Id.get(i)));
			 }
		}
		return  all_ID;
	}
/**
 * This read file method finds all the vehicle ids from the given data file.
 * @param filename  the file that has the vehicleids.
 * @return returns the vehicle id as an arraylist
 * @throws FileNotFoundException
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
/**
 * This method overrides the default toString method for the LetterAvg objects.
 */
	public String toString() {
		ArrayList<String> parameter;
		try {
			parameter = ID();
			String result = "These vehicles are:";
			for(int z =0; z < parameter.size(); z++) {
				result += " "+parameter.get(z);
			}
			return result;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
