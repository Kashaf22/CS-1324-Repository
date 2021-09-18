import java.util.Scanner;

public class Project4 
{
	public static void main(String[] args)
	{
		//Declaring variables for score, user input, and the questions
		int score = 0;
		String input;
		String USER_PROMPT = "If you feel the following statements apply to you, answer yes, otherwise answer no.";
		String questionOne = "I try to get away from people as soon as I can.";
		String questionTwo = "I feel trapped.";
		String questionThree = "I feel tired most of the time.";
		
		//Initializing scanner object
		Scanner keyboard = new Scanner (System.in);

		//Prompt user
		System.out.println(USER_PROMPT);
		System.out.println(questionOne);
		
		//collect user input
		input = keyboard.nextLine();
		
		//if statements
		if(input.equalsIgnoreCase("yes"))
		{
			score = score + 1;
		}
		
		System.out.println(questionTwo);
		input = keyboard.nextLine();
		if(input.equalsIgnoreCase("yes"))
		{
			score = score + 1;
		}
		
		System.out.println(questionThree);
		input = keyboard.nextLine();
		if(input.equalsIgnoreCase("yes"))
		{
			score = score + 1;
		}

		//Calculate score statement
		if(score ==0 )
		{
			System.out.println("You're more exhausted than stressed out");
		}
		else if(score == 1)
		{
			System.out.println("You're beginning to stress out");
		}
		else if(score == 2)
		{
			System.out.println("You're possibly stressed out");
		}
		else
		{
			System.out.println("You're probably stressed out");
		}

		
		//Display Score
		System.out.println(score);
		
		keyboard.close();
	}
}
