import java.util.Scanner;

public class Project2Engr {

	public static void main(String[] args) {
		//Phase 4 Conditionals Statements 
		
		Scanner keyboard = new Scanner(System.in); 
		String phase4 = "Are you in Phase 4 of COVID vaccination?"; 
		System.out.println(phase4);
	    String phase4_input= keyboard.nextLine();
		String PROMPT = "Are you Oklahoma resident ? Please anwser with a yes or no only.";
       
		
        if(phase4_input.equalsIgnoreCase("yes")) {
        
        System.out.println(PROMPT); 
        String input = keyboard.nextLine(); 
        
        
             if (input.equalsIgnoreCase("yes")) {
              System.out.println("Please Schedule your appointment"); 
              
           } else if(input.equalsIgnoreCase("no")) {
        	  System.out.println("Sorry, you can not get the vaccine");
        	  
           }  else {
        	  
        	   System.out.println("Sorry, we can not determine your vaccine eligibility");
           }
        	  
             
            
             
        } else if (phase4_input.equalsIgnoreCase("no")) {
        	System.out.println("Unfortunately, you are not in phase 4 of vaccination and hence you can not get the vaccine.");
        	
        } else {
        	System.out.println("Please anwser with a yes or a no only.");
        	
        	}
        	   
        	   
           
          keyboard.close();    
        
        
	
	}

}
