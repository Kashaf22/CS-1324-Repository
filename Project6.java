import java.util.Scanner;
public class Project6 { 
	public static void main(String[] args) {
		
		//construct a scanner and read input from keyboard
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Response Dial Simulator");
		System.out.println("-----------------------");
		System.out.println("Initial setting: 3");

		final int SENTINEL = -1; //store sentinel value in constant variable, and use it in loop condition
		int neutral = 3; 
		int change = 0;
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;
		int changePos = 0;
		int changeNeg = 0; 
		int noChange = 0;
		final String USER_PROMPT= "Enter the next setting (1-5) or -1 to stop.";	
		System.out.println(USER_PROMPT);
		int dial = keyboard.nextInt(); 
		change = dial - neutral; 
				
		//use sentinel controlled loop to read dial settings until user tells it to end 
		//use accumulators an conditional statements to update correct accumulator on correct setting
		while (dial != SENTINEL) {
				
			if (dial == 1) {
				count1++;                    //Count the number that was chosen 
			} else if (dial == 2) {
				count2++;
			} else if (dial == 3) {
				count3++;
			} else if (dial == 4) {
				count4++;
			} else if (dial == 5){
				count5++;
			} else {
				
			}
			
		//Count the amount of +, -, and neutral changes
			if (neutral < dial) {
				System.out.println("Positive change: " + neutral + " to " + dial);
				System.out.println("Current setting: " + dial);
				neutral = dial;
				changePos++;
				
			} else if (neutral > dial) {
				System.out.println("Negative change: " + neutral + " to " + dial);
				System.out.println("Current setting: " + dial);
				neutral = dial;
				changeNeg++;
				
			} else {
				System.out.println("No change: " + dial + " to " + dial);
				System.out.println("Current setting: " + dial);
				neutral = dial;
				noChange++;
			} 
			System.out.println("Enter the next setting (1-5) or -1 to stop.");
			dial = keyboard.nextInt(); 
		}
			
		//use print statements to output info about dial while user is entering settings
		System.out.println("Response Summary");
		System.out.println("----------------");
		System.out.println("1 was chosen " + count1 + " time(s).");
		System.out.println("2 was chosen " + count2 + " time(s).");
		System.out.println("3 was chosen " + count3 + " time(s).");
		System.out.println("4 was chosen " + count4 + " time(s).");
		System.out.println("5 was chosen " + count5 + " time(s)." + '\n');
		
		System.out.println("Positive changes: " + changePos);
		System.out.println("Negative changes: " + changeNeg);
		System.out.println("No changes: " + noChange);
		
		
		keyboard.close();
		
	}
	
}


