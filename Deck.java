//Written by Jackie Horton adapted by Luke Lakea
//CS110
//Class that simulates a deck

import java.util.Random;
public class Deck 
{
   final int CARDS_IN_DECK = 52;
	final int EMPTY_DECK = 0;

   Card [] deck;
   int ct;
	
	/**
      Default constructor that creates a new deck with 52 card objects
   */
   public Deck()
   {
      freshDeck();
   }
	/**
      Method for checking if the deck is empty 
   */
	public Deck(boolean isEmpty)
	{
		deck = new Card[EMPTY_DECK];
	}
	/**
      Method that creates 52 card objects in an array list
   */
   public void freshDeck()
   {
      deck = new Card[CARDS_IN_DECK];
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
            deck[ct]=new Card(r,s);
            ct = ct + 1;
         }
      }
   }
   /**
      Method that deals one card
   */
   public Card dealCard()
   {
      ct--;
      return deck[ct];
   }
	/**
      Gives an integer value of the number of cards remaining
   */
   public int cardsRemaining()
   {  
      return ct;
   }
   /**
      Randomizes the cards in an existing deck
   */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < ct; i++)
      {
         randNum = r.nextInt(ct);
         temp = deck[i];
         deck[i]=deck[randNum];
         deck[randNum]=temp;
      }
   }
   /**
      Checks if there are no cards remaining
   */
   public boolean isEmpty()
   {
      return (cardsRemaining() == 0);
   }
   /**
      Demonstration of the deck
   */
   public static void main(String [] args) 
   {
      Deck deck = new Deck();
      deck.shuffle();
      int i = 0;
      while (!(deck.isEmpty()))
         System.out.println((i++)+1 + " : " + deck.dealCard().toString());
      deck.freshDeck();

   }
}

