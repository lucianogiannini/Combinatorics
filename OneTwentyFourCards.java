
import java.util.*;

public class OneTwentyFourCards
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Hide a card or Find a card? Enter h/f");
    char hOrF = 'a';
    while(hOrF != 'h' && hOrF != 'f')
      hOrF = input.nextLine().charAt(0);
    //input.close();
    if(hOrF == 'h')
      hide();
    else
      System.out.println(find());
  }
  
  public static void hide()
  {
    Scanner input1 = new Scanner(System.in);
    System.out.println("Enter the 5 cards in any order");
    
    int c1 = input1.nextInt();
    int c2 = input1.nextInt();
    int c3 = input1.nextInt();
    int c4 = input1.nextInt();
    int c5 = input1.nextInt();
    //input.close();
    
    int[] cards = {c1, c2, c3, c4, c5};
    Arrays.sort(cards);
    c1 = cards[0];
    c2 = cards[1];
    c3 = cards[2];
    c4 = cards[3];
    c5 = cards[4];
    
    int hidden = makeCand(c1, c2, c3, c4, c5);
    System.out.println(hidden);
    int[] newCards = new int[4];
    int temp = 0;
    for(int i = 0; i < 5; i ++)
    {
      if(cards[i] != hidden)
      {
        newCards[temp] = cards[i];
        temp ++;
      }
    }
    
    temp = 0;
    int[] candidates = new int[24];
    int place = 0;
    for(int i = 1; i <= 124; i ++){
      if(i == newCards[0] || i == newCards[1] || i == newCards[2] || i == newCards[3])
        temp ++;
      else if((newCards[0] + newCards[1] + newCards[2] + newCards[3] + i) % 5 == temp){
        candidates[place] = i;
        place ++;
      }
    }
    
    int choice = 0;
    for(int i = 0; i < 24; i ++){
      if(candidates[i] == hidden)
        choice = i + 1;
    }
    
    int[] perm = LexicographicPermutation.perm(4, choice);
    int[] result = new int[4];
    Arrays.sort(newCards);
    for(int i = 0; i < 4; i ++){
      if(perm[i] == 1)
        result[i] = newCards[0];
      else if(perm[i] == 2)
        result[i] = newCards[1];
      else if(perm[i] == 3)
        result[i] = newCards[2];
      else if(perm[i] == 4)
        result[i] = newCards[3];
    }
    LexicographicPermutation.print(result);
  }

  public static int makeCand(int c1, int c2, int c3, int c4, int c5){
    int[] cards = {c1, c2, c3, c4, c5};
    return cards[(c1 + c2 + c3 + c4 + c5) % 5];
  }
  
  public static int find(){
    System.out.println("Enter the 4 cards");
    Scanner input = new Scanner(System.in);
    int c1 = input.nextInt();
    int c2 = input.nextInt();
    int c3 = input.nextInt();
    int c4 = input.nextInt();
    input.close();
    
    int[] cards = {c1, c2, c3, c4};
    int[] sorts = new int[4];
    for(int i = 0; i < 4; i ++)
      sorts[i] = cards[i];
    Arrays.sort(sorts);
    
    int p = makePerm(c1, c2, c3, c4);
    System.out.println(p);
    int temp = 0;
    int[] candidates = new int[24];
    int place = 0;
    for(int i = 1; i <= 124; i ++)
    {
      if(i == sorts[0] || i == sorts[1] || i == sorts[2] || i == sorts[3])
        temp ++;
      else if((sorts[0] + sorts[1] + sorts[2] + sorts[3] + i) % 5 == temp)//this is the 1 mod 5 , 2 mod 5, 3 mod 5, 4 mod 5, 5 mod 5.
      {
        candidates[place] = i;
        place ++;
      }
    }
    
    return candidates[p - 1];
  }
  public static int makePerm(int c1, int c2, int c3, int c4){
    int[] cards = {c1, c2, c3, c4};
    int[] sorts = {c1, c2, c3, c4};
    Arrays.sort(sorts);
    int[] perm = new int[4];
    
    for(int i = 0; i < 4; i ++)
    {
      for(int j = 0; j < 4; j ++)
      {
        if(sorts[j] == cards[i])
          perm[i] = j + 1;
      }
    }
    return LexicographicPermutation.calculate(perm, 4);
  }
}