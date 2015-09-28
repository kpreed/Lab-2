package MainPackage;

import java.util.ArrayList;
import java.util.Collections;

public class Hand
{
	private ArrayList<Card> hand = new ArrayList<Card>();

	public Hand(Deck deck)
	{
		for (int i = 1; i <= 5; i++)
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
		Collections.sort(hand, new Card());
		if (Judgers.isRoyalFlush(hand))
			return 10;
		else if (Judgers.isStraightFlush(hand))
			return 9;
		else if (Judgers.isFourOfAKind(hand))
			return 8;
		else if (Judgers.isFullHouse(hand))
			return 7;
		else if (Judgers.isFlush(hand))
			return 6;
		else if (Judgers.isStraight(hand))
			return 5;
		else if (Judgers.isThreeOfAKind(hand))
			return 4;
		else if (Judgers.isTwoPair(hand))
			return 3;
		else if (Judgers.isPair(hand))
			return 2;
		else
			return 1;
	}

	public static Hand judgeHands(ArrayList<Hand> hands)
	{
		int highest = 0;
		Hand highHand;
		for (int i = 0; i < hands.length; i++)
		{
			int judge = judgeHand(hands.get(i));
			if(judge > highest)
			{
				highest = judge;
				highHand = hands.get(i);
			}
			else if (judge == highest)
			{
				if (highest == 1)
				{
					ArrayList<Hand> tieHands = new ArrayList<Hand>(highHand,hands.get(i));
					highHand = Judgers.pairTieBreak(hands);
				}
			}
		}
	}

}
