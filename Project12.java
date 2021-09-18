
		import java.io.File;
		import java.io.FileNotFoundException;
		import java.io.PrintWriter;
		import java.util.Scanner;

		/** This program keeps track of a group of recipes. Each recipe has a name and a chef who created the recipe. Chefs can create may recipes and recipes
		 * can be created by different chefs. The program stores the data in two files: one for the recipes and another for the chefs. You may find chefs by
		 * recipe name, find recipe name by chef, and add chef and recipe pairings. At the end of the program the possibly modified data is written to a file.
		 * 
		 * @author Deborah 
		 * @versio 1.0
		 *Kashaf Mujeeb- To write Read file and write file method I took help from previous projects
		 **/
		 
		public class Project12 
		{
			/** Run the main program.
			 * 
			 * @param args There are no command line arguments.
			 * @throws FileNotFoundException If there is not a Recipes.txt and Chefs.txt file stored in the main project directory.
			 **/
			 
		
	        public static void main(String[] args)  throws FileNotFoundException 
			{
				//TODO Construct the arrays, using a constant
				// 100 elements will be sufficient in all three arrays
				final int SIZE = 100; 
				String[] recipe = new String [SIZE];
				int size=0;
				String[] chef= new String[SIZE];
				String[] result = new String[SIZE];
				int resultSize=0;
				
				
				
				
				final String RECIPE_FILE = "Recipes.txt";
				final String CHEF_FILE = "Chefs.txt";
				Scanner input = new Scanner(System.in);
						
				//TODO Call the readFile method twice
				size=readFile(recipe, RECIPE_FILE);
				size=readFile(chef, CHEF_FILE);
				

				
				System.out.println("Choose from the following options:");
				System.out.println("1. Get recipe by chef");
				System.out.println("2. Get recipe by dish");
				System.out.println("3. Add recipes");
				System.out.println("4. Quit");
				int response = input.nextInt();
				input.nextLine(); // get rid of extra newline
				while (response != 4)
				{
					if (response == 1) // Recipe by chef
					{
						System.out.println("Enter the name of the chef");
						String name = input.nextLine();
						
						//TODO Call the retrieveRecipes method, and print out the results
						resultSize = retrieveRecipes(chef, recipe, size, name, result);
						printResult(result, resultSize);
						
						
						

					}
					else if (response == 2) // Recipe by dish
					{
						System.out.println("Enter the name of the recipe");
						String name = input.nextLine();
						// TODO Call the retrieveRecipes method and print out the results
						resultSize= retrieveRecipes(recipe, chef, size, name, result);  
						printResult(result, resultSize);
						

					}
					else if (response == 3) // Add recipe
					{
						System.out.println("Enter the name of the recipe");
						String name = input.nextLine();
						System.out.println("Enter the chef");
						String author = input.nextLine();
						//TODO Call the addToRecipes method
						addToRecipes(recipe,chef, size, name, name); 
						

					}
					
					System.out.println("Choose from the following options:");
					System.out.println("1. Get recipe by chef");
					System.out.println("2. Get recipe by dish");
					System.out.println("3. Add recipes");
					System.out.println("4. Quit");
					response = input.nextInt();
					input.nextLine(); // get rid of extra newline
				}
				
				//TODO Call the write file 
				
				writeFile(chef,size,CHEF_FILE);
				writeFile(recipe, size ,RECIPE_FILE); 
				
				

				input.close();
			}
			
			/** Print the contents of an oversize array of the given size to the 
			 * command line.
			 * @param data An oversize array.
			 * @param dataSize The number of elements in the oversize array that are active.
			 */
			public static void printResult(String[] data, int dataSize)
			{
				for (int k=0; k < dataSize; k++) { 
					System.out.println(data[k]); 
				}
			}
			/** This method searches the key array for any indices that contain the String findMe. It then
			 * transfers the elements at those indices from the value  array to the result array. The result array
			 * has been constructed but is initially empty. The number of elements transfered is returned.
			 *  
			 * @param key The array that contains the elements being searched.
			 * @param value The array whose contents are transferred to value.
			 * @param size The number of elements in the key and value arrays that are active.
			 * @param findMe The element being sought in the key array.
			 * @param result The array that contains the results of the search (elements form the value array).
			 * @return The number of elements in the result array that have been set.
			 */
			public static int retrieveRecipes(String[] key, String[] value, int size, String findMe, String[] result)
			{
				
			    int count =0;
				for (int i=0; i < size;i++) {
					if (key[i].equals(findMe)) {
						  result[count] = value[i];
						 count++;
					}
				}
				return count;
			}
			/** Add a given food and author to the recipe and chef arrays, if that pairing is not already
			 * in the array.
			 * @param recipe An array that contains recipes that are written by chefs. 
			 * @param chef An array that contains the names of chefs that wrote recipes. The chef and recipe
			 * occur at the same indices in these arrays.
			 * @param size The number of elements in the recipe and chef arrays that have been used.
			 * @param food The name of the recipe being inserted.
			 * @param author The name of the author of the recipe being inserted.
			 * @return If author and food were already in recipe and chef at the same index, the arrays are not
			 * modified and size is returned. If author and food were not in the recipe and chef arrays at the 
			 * same index, the author is added to chef, food is added to recipe and size+1 is returned.
			 */
			public static int addToRecipes(String[] recipe, String[] chef, int size, String food, String author)
			{
				
				for ( int index =0; index < size; index++) 
				{
						if (recipe[index].equals(food) && chef[index].equals(author))
						{
								 return size; 
						 } 
			
							    
				}
				recipe[size]= food; 
				 chef[size]= author; 
				 size = size +1;
				 return size; 
			            
			}
				
			
			/** Write the contents of the array with the given arraySize out to a file with the
			 * given fileName. The file will be put in the main project directory.
			 * @param array The name of the array whose contents are written.
			 * @param arraySize The number of elements in the array that were used.
			 * @param fileName The name of the file.
			 * @throws FileNotFoundException Will be thrown if the file cannot be opened for any reason.
			 */
			public static void writeFile(String[] array, int arraySize, String fileName) throws FileNotFoundException
			{
				PrintWriter pw = new PrintWriter(fileName);
				
				
				for (int k = 0; k < arraySize; ++k)
				{
					pw.println(array[k]);
					
				}
				
				pw.close();
			}
			
			/** Read in the contents of an array from a given fileName. The file will be read one line at a time
			 * and inserted into the array. The file should be stored in the
			 * main project directory.
			 * @param array The array that the file contents should be stored in.
			 * @param fileName The name of the file.
			 * @return The number of lines that were in the file.
			 * @throws FileNotFoundException If the file cannot be found for any reason.
			 */
			public static int readFile(String[] array, String fileName) throws FileNotFoundException
			{
				Scanner file = new Scanner(new File(fileName));
				
				int index;
				for (index=0; file.hasNextLine() && index < array.length; ++index)
				{
			
					array[index] = file.nextLine();
				}
				
				file.close();
				return index;
			
			
			
			}

}


