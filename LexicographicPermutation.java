import java.util.*;
public class LexicographicPermutation
{
   public LexicographicPermutation()
   {
   
   }
   public static void main(String[]args)
   { 
      Scanner input = new Scanner(System.in);
      System.out.println("Do you want to (D)ecode or (E)ncode?");
      String s = input.nextLine();
      LexicographicPermutation Permu = new LexicographicPermutation();
      if(s.equals("D"))
      {
         Permu.decode();
      }
      else
         Permu.encode();
   // do you want to encode or decode?
   }//end main
   
   
   public static int[] perm(int n, int p) 
   {
   
      // initialize permutation
      int[] a = new int[n];
      for (int i = 0; i < n; i++)
         a[i] = i+1;
   
      // print permutations
      for(int i = 1; i < p; i++)
      { 
         nextPerm(a);
      }
      print(a); 
      return a;
   }
   
   public static void print(int[] a) 
   {
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i]+" ");
      System.out.println();
   }
   public void encode()
   {
      Scanner input = new Scanner(System.in);
      System.out.println("How many elements do you want?");
      int n = input.nextInt();
      System.out.println("Which permutation?");
      int m = input.nextInt();
      int p = m;
      perm(n,m);
    
   }//end encode method
  
  
   public static int[] nextPerm(int[] permPassed)
   {
      int k = 0;
      int length = permPassed.length;
       
      for (k = length-2; k >= 0; k--)
         if (permPassed[k] < permPassed[k+1]) 
            break;
      if (k == -1) 
         return null;
   
      int j = length-1;
      while (permPassed[k] >permPassed[j])
         j--;
      swap(permPassed, j, k);
   
      for (int r = length-1, s = k+1; r > s; r--, s++)
         swap(permPassed, r, s);
   
      return permPassed;
   }//end method
   
   
   public static void swap(int[] a, int i, int j) 
   {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
   public void decode()
   {
      Scanner input = new Scanner(System.in);
      System.out.println("How many elements are there?");
      int n = input.nextInt();
      System.out.println("Enter the permutation:");
      String permu = input.nextLine();
      permu = input.nextLine();
      int [] permutation = new int[n];
      int [] permutationdemo = new int[n];
      for(int i = 0; i <n; i++)
         permutation[i] = Character.getNumericValue(permu.charAt(i));
      for(int i = 0; i <n; i++)
         permutationdemo[i] = i+1;
      int count = 1;
      while(!isEqual(permutation,permutationdemo))
      {
         permutationdemo = nextPerm(permutationdemo);
         
         count++;
      }
      System.out.println("Permutation: " + permu + " is the "+ count+ "th permutation of "+n+" elements");     
    
   
   }
   public static boolean isEqual(int[] array1, int[]array2)
   {
      for(int i = 0; i < array1.length;i++)
      {
         if(array1[i]!=array2[i])
            return false;
      
      
      }
      return true;
   
   
   }
   public static int calculate(int[] a, int n)
   {
    for(int i = 1; i <= factorial(n); i ++)
    {
      if(isEqual(perm(n, i), a))
        return i;
    }
    return -1;
  }
  public static int factorial(int b)
  {
    if(b == 1)
      return 1;
    else
      return b * factorial(b - 1);
  }
}// end class