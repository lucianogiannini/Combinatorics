public class CardCodes
{
   public int xyz;
   public int code;
   public CardCodes()
   {
      xyz = 0;
      code = 0;
   }
   public CardCodes(int xyz)
   {
      this.xyz = xyz;
   }
   public CardCodes(int xyz, int code)
   {
      this.xyz = xyz;
      this.code = code;
   }
   public int getCode()
   {
      return this.code;
   }
   public void setXYZ(int x)
   {
      xyz = x;
   }
}



