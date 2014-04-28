// tic tac toe board
// 3x3 array of characters
// each contains an 'x', an 'o'
// or a '_' if not taken

public class Board 
{
   private Cell [][] board;
   
   // initialize board to '_'
   public Board()
   {
      board = new Cell[3][3];
      for (int r = 0; r < 3; r++)
         for (int c = 0 ; c < 3; c++)
      board[r][c]=new Cell('_');
   }
   // deep copy constructor
   public Board(Board b)
   {
      board = new Cell[3][3];
      for (int r = 0; r < 3; r++)
         for (int c = 0 ; c < 3; c++)
      this.board[r][c]=new Cell(b.board[r][c]);
   }
   
   // get character at row r, column c
   public Cell get(int r, int c)
   {
      return board[r][c];
   }
   // set character at row r, column c
   public void set(int r, int c, char ch)
   {
      board[r][c].setContents(ch);
   }
   // return 'x' or 'o' if there is a win,
   // or '_' otherwise
   public char winner()
   {
      char win = '_';
      int r = 0;
      // check rows
      while (r < 3 && win=='_')
      {
         if (board[r][0].getContents()==board[r][1].getContents() && 
               board[r][1].getContents()==board[r][2].getContents() && 
               board[r][0].getContents() !='_')
            win = board[r][0].getContents();
         r++;
      }
      // check columns
      int c = 0;
      while (c < 3 &&  win=='_')
      {
         if (board[0][c].getContents()==board[1][c].getContents() && 
               board[1][c].getContents()==board[2][c].getContents() && 
               board[0][c].getContents() !='_')
            win = board[0][c].getContents();
         c++;
      }  
      // check diagonals
      // short circuit
      if ( win=='_' &&  board[0][0].getContents()==board[1][1].getContents() && 
               board[1][1].getContents()==board[2][2].getContents() && 
               board[1][1].getContents() != '_')
         win = board[0][0].getContents();
      if (win=='_' &&  board[0][2].getContents()==board[1][1].getContents() && 
               board[1][1].getContents()==board[2][0].getContents() && 
               board[0][2].getContents() != '_')
         win = board[0][2].getContents();
         
      return win;
   }
   public String toString()
   {
      String s="";;
      for (int r = 0; r < 3; r++)
      {
         for (int c = 0 ; c < 3; c++)
         {
            s+=board[r][c].getContents()+" ";
         }
         s+="\n";
      }
      return s;   
          
   
   }
   
   public static void main(String [] args)
   {
      Board b = new Board();
      b.set(0,0,'x');
      b.set(0,1,'x');
      b.set(0,2,'x');
      b.set(1,0,'x');
      b.set(1,1,'x');
      b.set(2,2,'x');
      System.out.println(b);
         
   
   }
}