import java.util.Arrays;
import java.util.Scanner;
 
public class Assign3W2018PT2 {
 
	private static Scanner stdin;
	
	/**
	 * take a String array as a parameter, and display the content of the array
	 * @param computerTerms
	 */
	public static void displayArray(String[] computerTerms)
	{

		stdin = new Scanner(System.in);
		String ans;
		 
		do {
			  
			 stdin = new Scanner(System.in);
			 char[] first;
			 char[] word;
			 int correct;
			 int index;
			 char input;
		
			 System.out.println("\n\nFabio Dias: Guessing Game" + "\n" + "===========================");   
			   
			 index = intRandom(0, computerTerms.length - 1);
			 word = computerTerms[index].toCharArray();
		     
			 first = new char[word.length];
			 Arrays.fill(first,'*');
			 first[0] = word[0];
		     
			 correct = 0;
		         
		         
		       for(int i = 1; i < word.length; i++)
		       {
		    	   	if(word[0] == word[i])
		    	   	{
		            first[i] = word[i];
		        		}
		       }
		       
		       int num = correctGuessed(first);	   
		       while(correct != (word.length - num))
			   {
		    	   		
				   	System.out.println(first);
				   	System.out.print("Enter a letter: ");
				   	System.out.println("");
		
					input = stdin.next().charAt(0);
				   	for (int j = 1; j < word.length; j++) 
				   	{
					 
		               if(input == word[j])
		               {
		                  if(first[j] == '*')
		                  {
		                     first[j] = word[j];
		                     correct++;
		                  }
		                  else
		                  {
							System.out.println("You have already tried " + '"' +  input + '"' + " before!\n");
		                  }
		               }
				   	}
			   }
		       		
		       	   System.out.println("\nThe word is " + computerTerms[index] + "!");
				   System.out.println("You've guessed " + correct + " correct letters.\n");
				   System.out.print("Guess another word? (y/n)");
				   ans = stdin.next();
			  } 
			  while (ans.charAt(0) != 'n');

	}
	
	/**
	 * determine how many letters have been guessed correctly
	 */
	public static int correctGuessed(char[] first)
	{
		int count = 0;
		for(int i = 0; i < first.length; i++)
		{
			if(first[i] != '*')
         {
            count++;
         }
		}
		return count;
	}

	/**
	 * invoke the method to display the array
	 * @param args
	 */
	public static void main(String[] args) 
	{
		  
		String[] computerTerms = { "algorithm", "byTe", "Heuristic","instantiate","whetstone" };
		displayArray(computerTerms); 
	 
	}
 
	/**
	 * randomly return an integer that indicates the index of the word to guess for the user
	 * @param lowerLetter
	 * @param upperLetter
	 * @return
	 */
 	public static int intRandom(int lowerLetter, int upperLetter) 
 	{
 		return (int) (lowerLetter + Math.random() * (upperLetter - lowerLetter + 1));
 	}

}

