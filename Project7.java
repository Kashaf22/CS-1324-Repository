//Kashaf Mujeeb CS 1324-12 3/16/2021
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
public class Project7 {
	// Note: Any method that opens a file must be able to throw the file not 
	// found exception.
	public static void main(String[] args) throws FileNotFoundException
	{
		// Construct a Scanner object to read guesses from the keyboard.
		Scanner keyboard = new Scanner(System.in);
		
		// The game loop runs until this variable is no longer "yes".
		String continuePlaying = "yes";
		
		// Initialize variables to store the user's score and the total 
		// possible points from all the words guessed so far.
		int score = 0;
		int pointsPossible = 0;
		
		System.out.println("Welcome to Java Word Scramble!");
		System.out.println("------------------------------");
		
		// The game loop begins here.
		while (continuePlaying.equalsIgnoreCase("yes"))
		{
			// Print a newline character to separate the output from the 
			// previous game.
			System.out.println();
			
			//Method 1
			String word = chooseRandomWord();
			
			//Method 2
			String scrambledWord = scrambleWord(word);
			
			//Method 3
			int numGuesses = numberGuess(word, keyboard, scrambledWord);
			
			// Calculate the number of points the word is worth and the number 
			// earned by the user.
			int wordPoints = word.length() - 1;
			int pointsEarned = word.length() - numGuesses;
			
			//Method 4
			resultOfGame(pointsEarned);
			
			// Update and report the current score and total possible points.
			score += pointsEarned;
			pointsPossible += wordPoints;
			System.out.println("Score: " + score);
			System.out.println("Max possible points: " + pointsPossible);
		
			// Ask the player if they want to continue playing.
			System.out.println("Do you want to play again (yes/no)?");
			continuePlaying = keyboard.nextLine();
		}
		
		System.out.println("Thanks for playing!");
		
		keyboard.close();
	}
		
		public static String chooseRandomWord() throws FileNotFoundException {
			Scanner dictionary = new Scanner(new File("dictionary.txt"));

			// The first line of the text file contains an integer that 
			// specifies the number of words in the file. Read this number and 
			// skip the following newline character.
			int numWords = dictionary.nextInt();
			dictionary.nextLine();
			
			// The remaining lines of the file each contain a single word. 
			// Choose a random number of lines to skip.
			int numSkip = (int) (Math.random() * numWords);

			// Skip the lines and read the randomly chosen word.
			for (int i = 0; i < numSkip; ++i)
			{
				dictionary.nextLine();
			}
			String word = dictionary.nextLine();
			
			// Close the file now that the word has been chosen.
			dictionary.close(); 
			return word;
		}
		
		public static String scrambleWord(String word){ 
		// Construct StringBuilder objects used to scramble the word. The 
		// StringBuilder class is like String, but it has different methods 
		// like delete and append that are useful here.
			StringBuilder tempWord = new StringBuilder(word);
			StringBuilder scrambledTempWord = new StringBuilder();
					
			// Repeatedly choose a random letter to remove from tempWord.
			// Append these letters to scrambledTempWord to form the scrambled 
			// word.
			while (tempWord.length() > 0)
			{
			int letterIndex = (int) (Math.random() * tempWord.length());
			char letter = tempWord.charAt(letterIndex);
			tempWord.deleteCharAt(letterIndex);
			scrambledTempWord.append(letter);
			}
			// Create a regular String copy of the scrambled word.
			String scrambledWord = scrambledTempWord.toString();
			return scrambledWord;
		}
		
		public static int numberGuess(String word, Scanner keyboard, String scrambledWord) {
		// Let the user guess the word. The number of allowed guesses is 
		// one less than the number of letters. 
	
			int numGuesses; //FIX ME 
			for (numGuesses = 1; numGuesses <= word.length() - 1; ++numGuesses)
				{
				System.out.println("Scrambled word: " + scrambledWord);
						
				// Print a hint after the first guess.
				if (numGuesses > 1) {
					System.out.println("          Hint: " 
					+ word.substring(0, numGuesses - 1));
				}
				// Prompt the user and print the number of remaining guesses.
				System.out.println("What is your guess? (" 
				+ (word.length() - numGuesses) + " guesses left)");
						
				// Get the guess and exit the loop if it is correct.
				String guess = keyboard.nextLine();
				if (guess.equalsIgnoreCase(word)) {
					break;
					}
				} 
			return numGuesses; 
		}
		
		public static int resultOfGame(int pointsEarned) throws FileNotFoundException {
		// If the user earned 0 points, show them the correct word. 
		// Otherwise, tell them how many points they won.
			String word = chooseRandomWord();
			int wordPoints = word.length() - 1;
			
			if (pointsEarned == 0) {
				System.out.println("Sorry, the scrambled word was \"" + word 
				+ "\".");
			}
			else {
				System.out.println("Congratulations! You earned " 
				+ pointsEarned + " out of " + wordPoints 
				+ " possible points.");
			}
			return pointsEarned;
		}
					
		
}
