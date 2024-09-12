import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class timeScanner
{

   public static void main (String[] args)
   {
      BufferedReader objReader = null;
      File f = new File("randInts.txt");
      
      int sumScan = 0;
      int countScan = 0;
        try {
      Scanner scan = new Scanner(f);
      String strCurrentLine;
      int sum = 0;
      int count = 0;
      objReader = new BufferedReader(new FileReader("randInts.txt"));
      double billion = 1000000000.0;
      long t1 = System.nanoTime();
      while ((strCurrentLine = objReader.readLine()) != null) 
      {
         sum = sum + Integer.parseInt(strCurrentLine);
         count++;
      }
      long t2 = System.nanoTime();
      long diff = t2 - t1;
      double seconds = diff / billion;
      long t3 = System.nanoTime();
      while (scan.hasNextInt())      
      {
      int x = scan.nextInt();
      sumScan = sumScan + x;
      countScan++;
      }
      scan.close();
      long t4 = System.nanoTime();
      long difference = t4 - t3;
      double scannerSeconds = difference / billion;
      System.out.println("The scanner took " + scannerSeconds + " seconds.");
      System.out.println("The buffered reader took " + seconds + " seconds.");
      System.out.println("There are " + count + " numbers in the file.");
      System.out.println("The sum of the numbers is " + sum);
      try 
      {
    if (objReader != null)
         objReader.close();
   } 
   catch (IOException ex) 
   {
         ex.printStackTrace();
   }
      
      
  } catch (IOException e) {
      System.out.println("IO Exception");
      e.printStackTrace();
  } finally 
  {
   
   
  }
}
}