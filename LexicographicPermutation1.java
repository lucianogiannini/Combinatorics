import java.util.*;
public class LexicographicPermutation1
{
   public LexicographicPermutation1()
   {
   
   }
//   public static void main(String[]args)
//   { 
//      Scanner input = new Scanner(System.in);
//      System.out.println("Do you want to (D)ecode or (E)ncode?");
//      String s = input.nextLine();
//      LexicographicPermutation Permu = new LexicographicPermutation();
//      if(s.equals("D"))
//      {
//         Permu.decode();
//      }
//      else
//         Permu.encode();
//   // do you want to encode or decode?
//   }//end main
   public int [] perm(int n, int p, int [] a) 
   {
   int [] card = new int [p];
      // initialize permutation
      for (int i = 0; i < n; i++)
         a[i] = i+1;
   
      if (p == 1)
        return a;
      for(int i = 1; i < p; i++)
      { 
         card = nextPerm(a);
         //print(a);
      }
      return card;
   }
   public static void print(int[] a) {
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i]+" ");
      System.out.println();
   }
   public int [] encode(int lo)
   {
      int n = 4;
      int [] b = new int [n];
      
      //System.out.println(n);
      int [] p = perm(n,lo,b);
      // int [] permutation = new int[n];
   //       for(int i = 0; i <n; i++)
   //          permutation[i] = i+1;
   //       for(int j = 0; j < permutation.length; j++)
   //          System.out.print(permutation[j] + " ");
   //       System.out.println("");
   //       for(int i = 1; i < p; i++)
   //       {
   //         
   //          permutation = nextPerm(permutation);
   //          for(int j = 0; j < permutation.length; j++)
   //             System.out.print(permutation[j] + " ");
   //          System.out.println("");
   //          //System.out.println("Hi");
   //       }
   //       System.out.println("Permutation: " + m + " ");
   //       for(int j = 0; j < permutation.length; j++)
      //System.out.print(permutation[j] + " ");
      //System.out.println("");
   return p;
   }//end encode method
  
  
   public int[] nextPerm(int[] permPassed)
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
   
      //return true;
      //swap
      //swap(permPassed,b,k);
      // int tempK = permPassed[k];
      // int tempB = permPassed[b];
      // permPassed[k] = tempB;
      // permPassed[b] = tempK;
      
      //reverse all values
      // int temp = -1;
      // int start = k+1;
      // int swap = 0;
      // int numSwaps =  (permPassed.length-2)/2;
      // for(int i = start; i < permPassed.length; i++)
      // {
         // if(swap <= numSwaps)
         // {
            // temp = permPassed[i];
            // permPassed[i] = permPassed[permPassed.length-1-swap];
            // permPassed[permPassed.length-1-swap] = temp;
            // swap++;
      //for (int r = length-1, s = k+1; r > s; r--, s++)
         //swap(permPassed, r, s);
         
         
         
      
      return permPassed;
   }//end method
   public static void swap(int[] a, int i, int j) 
   {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
   public int decode(int size, int [] a)
   {
      int n = size;

      int [] permutation = a;
      int [] permutationdemo = new int[n];
//      for(int i = 0; i <n; i++)
//         permutation[i] = Character.getNumericValue(permu.charAt(i));
      for(int i = 0; i <n; i++)
         permutationdemo[i] = i+1;
      int count = 1;
      while(!isEqual(permutation,permutationdemo))
      {
         permutationdemo = nextPerm(permutationdemo);
         
         count++;
      }
      //System.out.println("Permutation: " + permu + " is the "+ count+ "th permutation of "+n+" elements");     
    return count;
   
   }
   public boolean isEqual(int[] array1, int[]array2)
   {
      for(int i = 0; i < array1.length;i++)
      {
         if(array1[i]!=array2[i])
            return false;
      
      
      }
      return true;
   
   
   }
}// end class