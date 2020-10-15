public class CardBoolean
{
   boolean used;
   int code;
   public CardBoolean()
   {
      used = false;
      code = 0;
   }
   public CardBoolean(boolean used, int code)
   {
      this.used = used;
      this.code = code;
   }
   public CardBoolean(int code)
   {
      this.code = code;
   }
   public boolean getUsed()
   {
      return this.used;
   }
   public void setCode(int c)
   {
      this.code = c;
   }
}



