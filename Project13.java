import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/* Written by Kashaf Mujeeb 
 * I worked with Moez Ullah Khan on some methods
 * 
 */

public class Project13 {

	public static void main(String[] args) throws FileNotFoundException, IOException {

			final String FILENAME_COMMON = "common-dictionary.txt";
			final String FILENAME_PERSONAL = "personal-dictionary.txt";
			String prompt = "Enter a word or 'quit' to stop: ";
			
			//Changing Arrays to ArryList 
			
			ArrayList<String> common = new ArrayList<String>();
			ArrayList<String> personal = new ArrayList<String>();
			
		
            //Storing new words into the newly constructed arraylist 
			common = readFile(FILENAME_COMMON);
			personal = readFile(FILENAME_PERSONAL);
			
			// Construct a Scanner to read user input from the keyboard.
			Scanner keyboard = new Scanner(System.in);
			
			System.out.println("Spell Checker");
			System.out.println("-------------");
			
			// Perform a priming read to get the first word.
			System.out.print(prompt);
			String word = keyboard.nextLine().toLowerCase();
			
			// Enter the user input loop.
			while (!word.equals("quit")) {
				
				// Check if the word is in either dictionary.
				if (checkSpelling(word, common, personal)) {
					System.out.println("The word is spelled correctly.");
				} 
				else {
					System.out.println("The word was not found in the "
						+ "dictionary.");			
					System.out.println("Would you like to add it to your personal "
						+ "dictionary (yes/no)?");
					String response = keyboard.nextLine().toLowerCase();
					
					// If the user responds "yes" and there is room in the oversize
					// array, add the word to the end of the array and sort it.
					if (response.equals("yes")) {
						
						personal.add(word);
						Collections.sort(personal); 
					}
				}
				
				// Get the next word from the user.
				System.out.println();
				System.out.print(prompt);
				word = keyboard.nextLine().toLowerCase();
			}
			
			keyboard.close();
			writeFile(FILENAME_PERSONAL, personal);
			System.out.println("Goodbye!");
		}
		
		// Read each line of a file and store them in a perfect size array.
	    
		public static ArrayList<String> readFile(String filename) 
			throws FileNotFoundException,  IOException {
			
			File file1 = new File(filename);
			
			file1.createNewFile();
				
			Scanner file = new Scanner(file1);
			ArrayList<String> arr = new ArrayList<String>();
			
			while (file.hasNextLine()) {
				arr.add(file.nextLine());
				
			}
			file.close();

			// Return the lines of the file.
			return arr;
		}
		
	
		
		// Return true if word is in either array; otherwise, return false. Note 
		// that the arrays are sorted, so binary search can be used.
		public static boolean checkSpelling(String word, ArrayList <String>common, 
			ArrayList<String> personal) {
				
			if (Collections.binarySearch(common, word) >= 0) {
				return true;
			}
			
			if (Collections.binarySearch(personal, word) >= 0) {
				return true;
			}
			
			return false;
		}
		
		
		public static void writeFile(String filename, ArrayList<String> array)
				throws FileNotFoundException {

			PrintWriter writer = new PrintWriter(filename);

			for (int idx = 0; idx < array.size(); idx++) {
				
				writer.println(array.get(idx));
			}

			// Close the file; otherwise, the contents will be lost.
			writer.close();
		}
	}

