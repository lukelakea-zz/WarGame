//Luke Lakea
//CS110
//Game that simulates war independent of a GUI

import java.util.ArrayList;

public class War
{
	
	public static void main(String [] args) 
   {
      //Declare and instantiate variables
		ArrayList <Card>userDeck=new ArrayList<Card>();
		ArrayList <Card>compDeck=new ArrayList<Card>();
		boolean isEmpty=true;
      int halfDeck=25,warCards=4;		
		Deck deck=new Deck();
		Card userCard=new Card();
      //Cards
		int c=0;

		//Shuffle the deck after it having been created
		deck.shuffle();
      
      //Splits the deck in half
		for(int i=0;i<=halfDeck;i++)
		{
         //Add one to user deck
			userCard=deck.dealCard();
			userDeck.add(userCard);
			
         //Add one to comp deck
			userCard=deck.dealCard();
			compDeck.add(userCard);
			
		}
		
		//While neither player has 0 cards
		while(userDeck.size()!=0&&compDeck.size()!=0){
         //Print the card each player draws
			System.out.println("User: "+userDeck.get(c));
			System.out.println("Comp: "+compDeck.get(c));
         //If card values are equal
			if(userDeck.get(c).getRank()==compDeck.get(c).getRank())
			{
            //If User doesn't have enough cards for war, they lose
				if(userDeck.size()<=warCards)
				{
					System.out.print("User doesn't have enough cards for war. Computer wins!");
					System.exit(0); 
				}
            //If Comp doesn't have neough cards for war, they lose
				else if(compDeck.size()<=warCards)
				{
					System.out.print("Computer doesn't have enough cards for war. User wins!");
					System.exit(0); 
				}
            //Otherwise call the war function
				warDeclared(c,userDeck,compDeck,warCards);
				
			}
			//If users card rank is of higher value
			else if(userDeck.get(c).getRank()>compDeck.get(c).getRank())
			{
				System.out.println("User wins the round");
            //Add the card from the computers deck to the users
				userDeck.add(userDeck.size()-1,compDeck.get(c));
            //Remove the card from the computer's deck
				compDeck.remove(c);
            //Display remaining amount of cards
				System.out.println("User has "+userDeck.size()+" cards");
				System.out.println("Computer has "+compDeck.size()+" cards");
			}
			//If computer card is of higher value
			else if(userDeck.get(c).getRank()<compDeck.get(c).getRank())
			{
				System.out.println("Computer wins the round");
				//Add card form users deck to comps
            compDeck.add(compDeck.size()-1,userDeck.get(c));
            //Remove card from users deck
				userDeck.remove(c);
            //Display remaining amount of cards
				System.out.println("User has "+userDeck.size()+" cards");
				System.out.println("Computer has "+compDeck.size()+" cards");
				
			}
         //If user or comp is out of cards, display winner text
         if(userDeck.size()==0)
         {
            System.out.println("User is out of cards. Computer wins the game!");
         }
         else if(compDeck.size()==0)
         {
            System.out.println("Computer is out of cards. User wins the game!");
         }
		}
			
   }
   //Function that simulates war
	public static void warDeclared(int c,ArrayList<Card> userDeck,ArrayList<Card> compDeck,int warCards)
	{
				System.out.println("WAR!");
            
            //If players enter double war
				if(userDeck.get(c+warCards).getRank()==compDeck.get(c+warCards).getRank())
				{
               //If user doesnt have enough cards
					if(userDeck.size()<=warCards)
					{
						System.out.print("User doesn't have enough cards for war. Computer wins!");
						System.exit(0); 
					}
               //If player doesn't have enough cards
					else if(compDeck.size()<=warCards)
					{
						System.out.print("Computer doesn't have enough cards for war. User wins!");
						System.exit(0); 
					}
               //Call war funciton again
					else
					{
						warDeclared(c+1,userDeck,compDeck,warCards);
					}
				}
            //If users final war card is higher than computers
				else if(userDeck.get(c+warCards).getRank()>compDeck.get(c+warCards).getRank())
				{
					System.out.println("User: "+userDeck.get(c+warCards));
					System.out.println("Comp: "+compDeck.get(c+warCards));
					System.out.println("User wins the war!");
               //Add and remove cards to the respective decks
					for(int i=0;i<=2;i++)
					{
						userDeck.add(compDeck.get(c));
						compDeck.remove(c);
					}
				}
				//If comps final war card is higher than users
				else if(userDeck.get(c+warCards).getRank()<compDeck.get(c+warCards).getRank())
				{
					System.out.println("User: "+userDeck.get(c+warCards));
					System.out.println("Comp: "+compDeck.get(c+warCards));
					System.out.println("Computer wins the war!");
               //Add and remove cards to the respective decks
					for(int i=0;i<=2;i++)
					{
						compDeck.add(userDeck.get(c));
						userDeck.remove(c);
					}
				}
	}
}