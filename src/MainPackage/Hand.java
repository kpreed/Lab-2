package MainPackage;

import java.util.ArrayList;
import java.util.Collections;

public class Hand 
{
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public Hand(Deck deck)
	{
		for (int i =1;i <= 5;i++)
		{
			if (deck.numberRemaining() == 0)
				deck = new Deck();
			this.addEltToHand(deck.draw());
		}
	}
	
	public void addEltToHand(Card card)
	{
		this.hand.add(card);
	}
	
	public ArrayList<Card> getHand()
	{
		return this.hand;
	}
	
	public static int judgeHand(Hand hand)
	{
		Collections.sort(hand);
		
	}
}
