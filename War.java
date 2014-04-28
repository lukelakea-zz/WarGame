import java.util.ArrayList;
// the guts of the game 
// user interface independent

public class War
{
	
		
	public static void main(String [] args) 
   {
		ArrayList <Card>userDeck=new ArrayList<Card>();
		ArrayList <Card>compDeck=new ArrayList<Card>();
		boolean isEmpty=true;
		
		Deck deck=new Deck();
		//Card userDeck=new Deck(true);
		
		Card userCard=new Card();
		int c=0;

		
		deck.shuffle();
		for(int i=0;i<=25;i++)
		{
			userCard=deck.dealCard();
			//System.out.println(userCard);
			userDeck.add(userCard);
			
			userCard=deck.dealCard();
			compDeck.add(userCard);
			//System.out.println(i+1);
			
			
			
		}
		//userDeck.isEmpty()==false&&compDeck.isEmpty()==false
		
		
		while(userDeck.size()!=0&&compDeck.size()!=0){
			System.out.println("User: "+userDeck.get(c));
			System.out.println("Comp: "+compDeck.get(c));
			//System.out.println(userDeck.get(0).getRank());
			if(userDeck.get(c).getRank()==compDeck.get(c).getRank())
			{
				if(userDeck.size()<=4)
				{
					System.out.print("User doesn't have enough cards for war. Computer wins!");
					System.exit(0); 
				}
				else if(compDeck.size()<=4)
				{
					System.out.print("Computer doesn't have enough cards for war. User wins!");
					System.exit(0); 
				}
				warDeclared(c,userDeck,compDeck);
				
			}
			//User Wins
			else if(userDeck.get(c).getRank()>compDeck.get(c).getRank())
			{
				System.out.println("user wins");
				userDeck.add(userDeck.size()-1,compDeck.get(c));
				compDeck.remove(c);
				System.out.println(userDeck.size());
				System.out.println(compDeck.size());

				
				
			}
			//Computer Wins
			else if(userDeck.get(c).getRank()<compDeck.get(c).getRank())
			{
				System.out.println("comp wins");
				compDeck.add(compDeck.size()-1,userDeck.get(c));
				userDeck.remove(c);
				System.out.println(userDeck.size());
				System.out.println(compDeck.size());
				
			}
			System.out.println(c);
			
			//c++;
			//System.out.println(userDeck.isEmpty()==false);
		}
		
		
   }
	public static void warDeclared(int c,ArrayList<Card> userDeck,ArrayList<Card> compDeck)
	{
				System.out.println("WAR!");

				if(userDeck.get(c+4).getRank()==compDeck.get(c+4).getRank())
				{
						if(userDeck.size()<=4)
					{
						System.out.print("User doesn't have enough cards for war. Computer wins!");
						System.exit(0); 
					}
					else if(compDeck.size()<=4)
					{
						System.out.print("Computer doesn't have enough cards for war. User wins!");
						System.exit(0); 
					}
					else
					{
						warDeclared(c+1,userDeck,compDeck);
					}
				}
				else if(userDeck.get(c+4).getRank()>compDeck.get(c+4).getRank())
				{
					System.out.println("User: "+userDeck.get(c+4));
					System.out.println("Comp: "+compDeck.get(c+4));
					System.out.println("user wins the war");
					for(int i=0;i<=2;i++)
					{
						userDeck.add(compDeck.get(c));
						compDeck.remove(c);
					}
				}
				
				else if(userDeck.get(c+4).getRank()<compDeck.get(c+4).getRank())
				{
					System.out.println("User: "+userDeck.get(c+4));
					System.out.println("Comp: "+compDeck.get(c+4));
					System.out.println("comp wins the war");
					for(int i=0;i<=2;i++)
					{
						compDeck.add(userDeck.get(c));
						userDeck.remove(c);
					}
				}



	}

}