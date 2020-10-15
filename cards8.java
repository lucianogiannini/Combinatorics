import java.util.*;
public class cards8
{
   public static CardBoolean[] used;
   public static CardCodes[] codes;
   public static int[] order;
   
   public static void main(String[]args)
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the number of cards");
      int numCards = input.nextInt();   //                              (*__*)
      //order = new int[] {12,13,23,21,31,32};//this one does not work (>--3 3)
      //order = new int[] {21,13,12,31,23,32};//this one does not work ( >___>)
      //order = new int[] {21,12,31,13,23,32}; //this one works YEAAA!!!
      order = new int[] {21,12,31,13,32,23}; //this one works YEAAA!!!
      Filltable(numCards);
      Boolean(numCards);
      findStrat(0);
   }
   
   public static void rummble()
   {
      Random r = new Random();
      for(int i = 0; i < codes.length;i++)
      {
         int temp = codes[i].xyz;
         int a = r.nextInt(codes.length);
         codes[i].xyz = codes[a].xyz;
         codes[a].xyz = temp;
      }
   }
   
   public static void printUsed()
   {
      for(int i=0; i< used.length;i++)
      {
         System.out.println(used[i].code+"   "+used[i].used);
      }
   }
   
   public static void printTable()
   {
      for(int i=0; i< codes.length;i++)
      {
         System.out.println(codes[i].xyz+"   "+codes[i].code);
      }
   }
   
   public static boolean findStrat(int f)
   {
   
      if(f == codes.length)
      {
         cards8.printTable();
         return true;
      }
      else
      {
         for(int i = 0; i< order.length;i++)
         {
            int xyz = codes[f].xyz;
            int a = xyz/100;
            int b = (xyz-a*100)/10;
            int c = xyz%10;
            switch(order[i])
            {
               case 12: 
                  {
                     if(used(a,b) == false)
                     {  codes[f].code = (a*10) + b;
                        change(a,b);
                        if(findStrat(f+1))
                           return true;
                        else
                        {
                           change(a,b);
                           codes[f].code = 0;
                        }
                     }
                     break;
                  }
               case 13: 
                  {
                     if(used(a,c) == false)
                     {  codes[f].code = (a*10) + c;
                        change(a,c);
                        if(findStrat(f+1))
                           return true;
                        else
                        {
                           change(a,c);
                           codes[f].code = 0;
                        }
                     }
                     break;
                  }
               case 23: 
                  {
                     if(used(b,c) == false)
                     {  codes[f].code = (b*10) + c;
                        change(b,c);
                        if(findStrat(f+1))
                           return true;
                        else
                        {
                           change(b,c);
                           codes[f].code = 0;
                        }
                     }
                     break;
                  }
               case 21: 
                  {
                     if(used(b,a) == false)
                     {  codes[f].code = (b*10) + a;
                        change(b,a);
                        if(findStrat(f+1))
                           return true;
                        else
                        {
                           change(b,a);
                           codes[f].code = 0;
                        }
                     }
                     break;
                  }
               case 31: 
                  {
                     if(used(c,a) == false)
                     {  codes[f].code = (c*10) + a;
                        change(c,a);
                        if(findStrat(f+1))
                           return true;
                        else
                        {
                           change(c,a);
                           codes[f].code = 0;
                        }
                     }
                     break;
                  }
               case 32: 
                  {
                     if(used(c,b) == false)
                     {  codes[f].code = (c*10) + b;
                        change(c,b);
                        if(findStrat(f+1))
                           return true;
                        else
                        {
                           change(c,b);
                           codes[f].code = 0;
                        }
                     }
                     break;
                  
                  }
            }
         }
         return false;
      }
   }
   
   public static boolean used(int a, int b)
   {
      int c = (a*10) + b;
      for(int i = 0; i < used.length;i++)
      {
         if(used[i].code == c)
            return used[i].used;
      }
      return true;
   }
   
   public static void change(int a, int b)
   {
      int c = (a*10) + b;
      for(int i = 0; i < used.length;i++)
      {
         if(used[i].code == c)
         {
            if(used[i].used == false)
               used[i].used = true;
            else
               used[i].used = false;
         }
      }
   }
   
   public static void Filltable(int n)
   {
      int size = (n*(n-1)*(n-2))/(3*2*1);
      codes = new CardCodes[size];
      int counter = 0;
      for(int i = 1; i <= n; i++)
      {
         for(int j = i+1; j<=n;j++)
         {
            for(int k = j+1; k<=n;k++)
            {
               int d = (i*100)+(j*10)+k;
               codes[counter] = new CardCodes(d);
               counter++;
            }
         }
      }
   }

   public static void Boolean(int n)
   {
      int size = (n*(n));
      used =  new CardBoolean[size];
      int counter = 0;
      for(int i = 1; i <= n;i++)
      {
         for(int j = 1; j <= n; j++)
         {
            int a  = ((i*10)+j);
            used[counter] = new CardBoolean(false,a);
            counter++;
         }
      }
   }
}