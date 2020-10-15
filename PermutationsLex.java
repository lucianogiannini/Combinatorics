import java.util.*;
public class PermutationsLex {

   public static void show(int[] a) {
      for (int i = 0; i < a.length; i++)
         System.out.printf("%d", a[i]);
      System.out.printf("\n");
   } 

   public static void swap(int[] a, int i, int j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   public static boolean hasNext(int[] a) {
      int n = a.length;
   
      // find rightmost element a[k] that is smaller than element to its right
      int k; 
      for (k = n-2; k >= 0; k--)
         if (a[k] < a[k+1]) 
            break;
      if (k == -1) 
         return false;
   
      // find rightmost element a[j] that is larger than a[k]
      int j = n-1;
      while (a[k] > a[j])
         j--;
      swap(a, j, k);
   
      for (int r = n-1, s = k+1; r > s; r--, s++)
         swap(a, r, s);
   
      return true;
   }

   public static void perm(int n) {
   
      // initialize permutation
      int[] a = new int[n];
      for (int i = 0; i < n; i++)
         a[i] = i+1;
   
      // print permutations
      show(a);
      while (hasNext(a))
         show(a);
   }


   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      perm(n);
   }
}