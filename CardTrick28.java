import java.util.*;
public class CardTrick28
{
  
  public static void main(String[]args)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("(C)onstruct or (R)ecover?");
    String command = input.next();
    if (command.equals("C"))
      construct();
    else if (command.equals("R"))
      recover();
  }
  
  public static void recover()
  {
    Scanner input = new Scanner(System.in);
    int [] perm = new int [4];
    System.out.println("Enter four cards to find the hidden card!");
    perm[0] = input.nextInt();
    perm[1] = input.nextInt();
    perm[2] = input.nextInt();
    perm[3] = input.nextInt();
    int [] order = permOrder(perm);
    LexicographicPermutation1 trick = new LexicographicPermutation1();
    int permutation = trick.decode(4,order);
    System.out.println(permutation);
  }
  
    public static void construct()
    {
    Scanner input = new Scanner(System.in);
    int [] a = new int [5];
    for (int i = 0;i<a.length;i++)
      a[i] = input.nextInt();
    Arrays.sort(a);
    int[]newA = new int [4];
    for (int i = 0;i<newA.length;i++)
    {
    newA[i] = a[i+1];
    
    }
    for(int i = 0; i<newA.length;i++)
    {
    System.out.println(newA[i]);
    }
    
    int [] permutation = {1,2,3,4};
    LexicographicPermutation trick = new LexicographicPermutation();
    int lvl = a[0];
    for(int i= 1; i < lvl; i++)
    {
    trick.nextPerm(permutation);
    trick.nextPerm(newA);
    }
    
    for(int i =0 ; i < newA.length; i++)
    System.out.print(newA[i]+" ");
    System.out.println();
    System.out.print("This is permutation: ");
    for(int i =0 ; i < newA.length; i++)
    System.out.print(permutation[i]+" ");
    System.out.println();
    
    //int [] left = reorder(hand,lo);
    //LexicographicPermutation1 trick = new LexicographicPermutation1();
    //int [] key = trick.encode(lo);
    //int [] order = order(key,left);
    //for (int i = 0;i<order.length;i++)
      //System.out.print(order[i]+" ");
    }
  
  public static int [] permOrder(int [] a)
  {
    int [] count = new int [4];
    for (int i = 0;i<count.length;i++)
    {
      count[i] = 1;
      for (int j = 0;j<a.length;j++)
      {
        if (a[i]>a[j])
          count[i]++;
      }
    }
    return count;
  }
  
  public static int[] order(int [] key, int [] left)
  {
    int [] max = new int[4];
    int [] order = new int[4];
    for (int k = 3;k>=0;k--)
    {
      int m = 0;
    for (int i = 0;i<4;i++)
    {
      if (left[i]>max[k])
      {
        max[k] = left[i];
        m = i;
      }
    }
    left[m]=-1;
    }
    
    for (int i = 0;i<order.length;i++)
    {
        order[i] = max[key[i]-1];
    }
    return order;
  }
  
  public static int [] hand(int [] a, int length)
  {
    int [] h = new int [length];
    for (int i = 0;i<length;i++)
    {
      int rand = (int)(Math.random()*28)+1;
      boolean check = false;
      for (int j = 0;j<h.length;j++)
      {
        if (rand==h[j])
          check = true;
      }
      if (check == false)
        h[i] = rand;
      else
        h[i] = (rand/2);
    } 
    return h;
  }       
  
  public static int getCard(int [] a)
  {
    int lo = 28;
    for (int i=0;i<a.length;i++)
    {
      if (a[i]<lo)
        lo = a[i];
    }
    return lo;
  }
  
  public static int [] reorder(int [] a, int lo)
  {
    int [] b = new int [5];
    for (int i = 0;i<5;i++)
    {
      if (a[i]!=lo)
        b[i] = a[i];
    }
    for (int i = 0;i<4;i++)
    {
      if (b[i] == 0)
        b[i] = b[4];
    }
    return b;
  }
}