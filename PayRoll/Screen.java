public class Screen
{
   public static void scrollscreen(int clearL)
   {
      for(int i = 1; i <= clearL; i++)
      {
         System.out.println(" ");
      }
   }
   
   public static void scrollscreen(char chr, int col, int row)
   {
      for(int i = 1; i <= row; i++)
      {
         for(int j = 1; j <= col; j++)
         {
            System.out.print(chr);
         }
         System.out.print("\n");
      }
   }
}