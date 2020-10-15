import java.util.*;

public class cards124
{

   public static void main(String[]args)
   {
      Scanner input = new Scanner(System.in);
      String choice  = "";
      System.out.println("Do you want to (H)ide or (F)ind a card?");
      while((!choice.equals("H")) && (!choice.equals("F")))
      {
         choice = input.nextLine();
      
      }
   
      if(choice.equals("H"))
      {
         HideCard();
      }
      else
      {
         System.out.println(FindCard());
      }
   }
   
   public static int FindCard()
   {
      Scanner input = new Scanner(System.in);
      int[] cards = new int[4];
      int[] sortedCards = new int[4];
      int[]permutation = new int[4];
      int permutation1;
      System.out.println("Please enter the 4 cards in the same order seen");
      for(int i = 0; i < 4;i++)
      {
         cards[i] = input.nextInt();
         sortedCards[i] = cards[i];
      }
      Arrays.sort(sortedCards);
      for(int i = 0 ; i < 4; i++)
      {
         for(int j =0;j<4;j++)
         {
            if(sortedCards[j] == cards[i])
            {
               permutation[i] = j+1;
            }
         }
      }
      permutation1 = LexicographicPermutation.calculate(permutation, 4);
      System.out.println(permutation1);
      int temp = 0;
      int[] available = new int[24];
      int index = 0;
      for(int i = 1; i <= 124; i ++)
      {
         if(i == sortedCards[0] || i == sortedCards[1] || i == sortedCards[2] || i == sortedCards[3])
         {
            temp ++;
         }
         else if((sortedCards[0] + sortedCards[1] + sortedCards[2] + sortedCards[3] + i) % 5 == temp)
         {
            available[index] = i;
            index ++;
         }
      }
      return available[permutation1-1];
   }
   public static void HideCard()
   {
      Scanner input  = new Scanner(System.in);
      int[] cards = new int[5];
      int HiddenCard;
      System.out.println("Please enter the 5 cards in any order");
      for(int i = 0; i < 5; i++)
      {
         cards[i] = input.nextInt();
      
      }
      Arrays.sort(cards);
      //System.out.println(cards[0]);
      int a = cards[0];
      int b = cards[1];
      int c = cards[2];
      int d = cards[3];
      int e = cards[4];
      //System.out.println(a +" "+b );
      int f = a+b+c+d+e;
      int position = (f%5);
      HiddenCard = cards[position];
      //System.out.println(HiddenCard);
      int[] cardss = new int[4];
      int counter = 0;
      for(int i = 0; i < 5; i++)
      {
         if(cards[i] != HiddenCard)
         {
            cardss[counter] = cards[i];
            counter++;
            //System.out.println(counter);
         }
      }
      counter = 0;
      int temp = 0;
      int[] available = new int[24];
      int index = 0;
      for(int i = 1; i <= 124; i ++)
      {
         if(i == cardss[0] || i == cardss[1] || i == cardss[2] || i == cardss[3])
         {
            temp ++;
         }
         else if((cardss[0] + cardss[1] + cardss[2] + cardss[3] + i) % 5 == temp)
         {
            available[index] = i;
            index ++;
         }
      }
      for(int i = 1; i <=24; i++)
      {
         if(available[i-1]==HiddenCard)
         {
            index = i;
         }
      
      }
   
      int[] perm = LexicographicPermutation.perm(4, index);
      int[] result = new int[4];
      correctPermutation(perm,cardss,result);
      LexicographicPermutation.print(result);
   }
   
   
   public static void correctPermutation(int[] per, int[] card, int[] resu)
   {
      for(int i = 0; i < 4; i ++){
         if(per[i] == 1)
            resu[i] = card[0];
         else if(per[i] == 2)
            resu[i] = card[1];
         else if(per[i] == 3)
            resu[i] = card[2];
         else if(per[i] == 4)
            resu[i] = card[3];
      }
   
   
   }













}//end class
