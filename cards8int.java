import java.util.*; 
public class cards8int
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      int[] array = FillTable.createTable(8);
      for(int i = 0; i < array.length;i++)
      {
         int xyz = array[i];
         int a = xyz/100;
         int b = (xyz-a*100)/10;
         int c = xyz%10;
         HideCard(a,b,c);
      }
   }

   public static void HideCard(int z, int z1, int z2)
   {
      Scanner input = new Scanner(System.in);
      int[] cards = new int[3];
      int HiddenCard;
      cards[0] = z;
      cards[1] = z1;
      cards[2] = z2;
      Arrays.sort(cards);
      int a = cards[0];
      int b = cards[1];
      int c = cards[2];
      int f = a+b+c;
      int position = (f%3);
      HiddenCard = cards[position];
      int[] cardss = new int[2];
      int counter = 0;
      for(int i = 0; i < 3; i++)
      {
         if(cards[i] != HiddenCard)
         {
            cardss[counter] = cards[i];
            counter++; 
         }
      }
      counter = 0;
      int temp = 0;
      int[] available = new int[2];
      int index = 0;
      for(int i = 1; i <= 8; i ++)
      {
         if(i == cardss[0] || i == cardss[1])
         {
            temp ++;
         }
         else if((cardss[0] + cardss[1] + i) % 3 == temp)
         {
            available[index] = i;
            index ++;
         }
      }
      for(int i = 1; i <=2; i++)
      {
         if(available[i-1]==HiddenCard)
         {
            index = i;
         }
      
      }
   
      int[] perm = LexicographicPermutation.perm(2, index);
      int[] result = new int[2];
      correctPermutation(perm,cardss,result);
      System.out.print(a+""+b+""+c+"\t");
      LexicographicPermutation.print(result);
   }
   public static void correctPermutation(int[] per, int[] card, int[] resu)
   {
      for(int i = 0; i < 2; i ++){
         if(per[i] == 1)
            resu[i] = card[0];
         else if(per[i] == 2)
            resu[i] = card[1];
      
      }
   
   
   }
}





