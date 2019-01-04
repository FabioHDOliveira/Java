class Assign3W2018PT1
{
      
/**
 * merge computerTerms[] and terms[] arrays into a third String array called merged[] .
 * @param computerTerms
 * @param terms
 * @return
 */
   public String[] merged(String[] computerTerms,String[] terms)
   {
      String[] merged = new String[anySize(computerTerms,terms)];
      int index = 0;
      
      for(int i = 0; i < terms.length; i++)
      {
         if(binSrch(computerTerms, terms[i]) == -1)
         {
            merged[index] = terms[i];
            index++;
         }

      }
      for(int j = 0; j < computerTerms.length; j++)
      {
         merged[index] = computerTerms[j];
         index++;
      }
      
      return merged;
   }
   
   /**
    * perform a binary search to indicate if the string items in the terms[] already exists or not in the computerTerms[] array
    * @param computerTerms
    * @param terms
    * @return
    */
   public int binSrch(String[] computerTerms, String terms)
   {
      int first = 0;
      int end = computerTerms.length - 1;
      int mid = -1;
      boolean found = false;
      
      while(first <= end)
      {
         mid = (first + end) / 2;
         
         if(computerTerms[mid].compareToIgnoreCase(terms) == 0)
         {
            found = true;
            break;
         }
         else 
            if(computerTerms[mid].compareToIgnoreCase(terms) < 0)
            {
            first = mid + 1;
            }
         else
         {
            end = mid - 1;
         }

      }
      if(!found)
         mid = -1;
         
      return mid;
   }
   
   
   /**
    * this method sorts the new  "merged []" array in ascending order.
    * @param arrMerged
    */
   public void sortArrayAsc(String[] arrMerged)
   {
      
      String sortAr = "";
      
      for(int count = 1; count < arrMerged.length; count++)
      {
         for(int i = 0; i < (arrMerged.length - count); i++)
         {
            if(arrMerged[i].compareToIgnoreCase(arrMerged[i+1]) > 0)
            {
               sortAr = arrMerged[i];
               arrMerged[i] = arrMerged[i+1];
               arrMerged[i+1] = sortAr;
            }
         }
      }

   }
   
   /**
    * the arrays work for any sized arrays.
    * @param computerTerms
    * @param terms
    * @return
    */
   public int anySize(String[] computerTerms, String[] terms)
   {
      int size = 0;
      
      for(int i = 0; i < terms.length; i++)
      {
         if(binSrch(computerTerms, terms[i]) != -1) 
         {
            size++;
         }
      }
      
      return computerTerms.length + terms.length - size;
   }
   
   /**
    * take a String array as a parameter, and display the content of the array.
    * @param computerTerms
    * @param terms
    */
   public void displayArray(String[] computerTerms, String[] terms)
   {
	   
      for(int i = 0; i < computerTerms.length && i < terms.length; i++)
      {
         computerTerms[i] = computerTerms[i].replaceAll("\\s","");
         terms[i] = terms[i].replaceAll("\\s","");
      }

	  String[] arrMerged = merged(computerTerms,terms);      
      
	  System.out.println("\nMerged - BEFORE sort:\n=====================");

      for(int i = 0; i < arrMerged.length; i++)
      {
         System.out.println(arrMerged[i]);
      }

      System.out.println("\nMerged - AFTER sort:\n=====================");

      sortArrayAsc(arrMerged);
      
      for(int i = 0; i < arrMerged.length; i++)
      {
         System.out.println(arrMerged[i]);
      }

   }
   

   /**
    * invoke the method to display the arrays.
    * @param args
    */
   public static void main(String args[])
   {
     String computerTerms[] = {"algorithm","byTe","Heuristic","instantiate","whetstone"};
     String terms[] = {"InliNe  ","instAntiate  ","   STrinG","  BYte"};
     
     Assign3W2018PT1 disp = new Assign3W2018PT1();     
     disp.displayArray(computerTerms,terms);
   }

   
}