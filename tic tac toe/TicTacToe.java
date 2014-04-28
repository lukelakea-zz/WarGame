// the guts of the game 
// user interface independent

public class TicTacToe
{
   private Board board;
   private char player; // x or o
   private int moves; // to determine tie
   
   public TicTacToe()
   {
      board = new Board();
      player = 'o';
      moves = 0;
      
   }
   // update board
   // return true if successful
   public boolean move(int r, int c)
   {
      if ((r >=0 && r <3)&&(c >=0 && c <3)&&(board.get(r,c).getContents()== '_'))
      {
         board.set(r,c,player);
         if (player=='x')
            player = 'o';
         else
            player = 'x';
         moves++;
         return true;
      }

      return false;
   }
   // how many moves taken?
   public int getMoves()
   {
      return moves;
   }
   public Board getBoard()
   {
      // return a copy
      return new Board(board);
   }
   public char getPlayer()
   {
      return player;
   }
   public void setPlayer(char ch)
   {
      player = ch;
   }
   // returns x,o,_ 
   public char winner()
   {
      return board.winner();
   }



}