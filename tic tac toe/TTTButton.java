import javax.swing.*;
// Represents a button specialized for TICTACTOE
// Each button know's it r,c coordinates
public class TTTButton extends JButton
{  
   private int r;
   private int c;
   // constructor
   public TTTButton(int r, int c,String s)
   {
      super(s);
      this.r=r;
      this.c=c;
   }
   //getters
   public int getRow()
   {
      return r;
   }
   public int getCol()
   {
      return c;
   }
}