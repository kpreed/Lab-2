package MainPackage;

import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
	ArrayList<Card> deck = new ArrayList<Card>(52);
	
	public Deck()
	{		
		String [] suits = {"Hearts","Diamonds","Spades","Clubs"};
		for (String i:suits)
		{
			for(int j = 1;j <= 13;j++)
			{
				Card card = new Card(j,i);
				this.deck.add(card);
			}
		}
		this.shuffle();
	}
	
	public void shuffle()
	{
		Collections.shuffle(deck);
	}
	
	public Card draw()
	{
		Card out = this.deck.get(0);
		this.deck.remove(0);
		return out;
	}
	
	public int numberRemaining()
	{
		return this.deck.size();
	}
}
