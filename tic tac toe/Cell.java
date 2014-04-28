// DISCLAIMER:  This file and all associated TTT files are
// meant for demonstration purposes.  The documentation is
// inadequate.  Input validation/error handling is incomplete.

// A single cell that contains
// a character and a Image representing
// the character 
import javax.swing.*;

public class Cell
{
   private char contents;  //'x','o' or '_'
   private ImageIcon image; // pic for x,o null otherwise
   // constructors
   public Cell(char c)
   {
      contents = c;
      image = null;
   
   }
   public Cell(char c, ImageIcon i)
   {
      contents = c;
      image = i;
   }
   public Cell(Cell c)
   {
      contents = c.contents;
      image = c.image;
   }
   // getters and setters
   public char getContents()
   {
      return contents;
   }
   public void setContents(char ch)
   {
      contents = ch;
   }
   public ImageIcon getImage()
   {
      return image;
   }
}


