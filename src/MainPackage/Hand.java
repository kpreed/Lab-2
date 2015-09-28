package MainPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The Hand class stores a list of 5 cards and contains methods to judge the best hand out of a list of hands.
 */
public class Hand
{
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	/**
	 * Creates a hand that contains one special card to indicate that two hands are a complete tie
	 */
	Hand()
	{
		this.addEltToHand(new Card(-1,"SPLIT"));
	}
	
	/**
	 * Main Constructor for Hand. Takes a specified deck and draws 5 cards from it.
	 */
	public Hand(Deck deck)
	{
		for (int i = 1; i <= 5; i++)
		{
			if (deck.numberRemaining() == 0)
				deck = new Deck();
			this.addEltToHand(deck.draw());
		}
	}
	
	/**
	 * This constructor is for testing purposes only and should be removed in the final version
	 * @param hand The hand to be created
	 */
	public Hand(Card[] hand)
	{
		for(Card c:hand)
			this.addEltToHand(c);
	}
	
	/**
	 * @param card Card to be added to the hand
	 */
	public void addEltToHand(Card card)
	{
		this.hand.add(card);
	}

	/**
	 * @return The ArrayList of Cards
	 */
	public ArrayList<Card> getHand()
	{
		return this.hand;
	}
	
	/**
	 * Sorts the Hand
	 */
	public void sortHand()
	{
		Collections.sort(this.hand, new Comparator<Card>()
		{
			public int compare(Card c1, Card c2)
			{
				if(c1.getRank() == c2.getRank())
					return 0;
				return c1.getRank() < c2.getRank() ? -1 : 1;
			}
		});
	}
	
	/**
	 * @return the hand in string form
	 */
	@Override
	public String toString()
	{
		return hand.get(0).getSuit() + " " + hand.get(0).getRank() + "\t" + hand.get(1).getSuit() + " " + hand.get(1).getRank() + "\t"
				+ hand.get(2).getSuit() + " " + hand.get(2).getRank() + "\t" + hand.get(3).getSuit() + " " + hand.get(3).getRank() + "\t"
				+ hand.get(4).getSuit() + " " + hand.get(4).getRank();
	}

	/**
	 * @param hand The hand to be judged
	 * @return The rank of the hand (1-10)
	 */
	public static int judgeHand(Hand hand)
	{
		
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

	/**
	 * @param hands An ArrayList of hands to be judged
	 * @return The player(s) that won. hands.get(0) = player 1, etc.
	 */
	public static ArrayList<Integer> judgeHands(ArrayList<Hand> hands)
	{
		int highest = 0;
		int playerWithHighest = 0;
		Hand highHand = null;
		ArrayList<Integer> winners = new ArrayList<Integer>(); //ArrayList containing all the winners to be outputted
		
		for (int i = 0; i < hands.size(); i++)
		{
			//Sorts hand and then judges each hand to get its rank
			hands.get(i).sortHand();
			int judge = judgeHand(hands.get(i));
			System.out.println(judge);
			//System.out.println(judge);
			
			//If the hand being judged is the highest hand, that's the new winner
			if(judge > highest)
			{
				highest = judge;
				playerWithHighest = (i+1);
				highHand = hands.get(i);
				winners = new ArrayList<Integer>();
				winners.add(i+1);
			}
			//If they're equal, go into tie breakers
			else if (judge == highest)
			{
				if (highest == 1)
				{
					ArrayList<Hand> tieHands = new ArrayList<Hand>();
					tieHands.add(highHand);
					tieHands.add(hands.get(i));
					Hand judgedHand = Judgers.highCardTieBreak(tieHands);
					
					if (judgedHand.getHand().get(0).getRank() == -1)
					{
						if (winners.size() > 0)
							winners.add(i+1);
						else
						{
							winners.add(i+1);
							winners.add(playerWithHighest);
						}
					}
					else
					{
						highHand = judgedHand;
						playerWithHighest = i;
						winners.clear();
						winners.add(i);
					}
				}
				
				if (highest == 2)
				{
					ArrayList<Hand> tieHands = new ArrayList<Hand>();
					tieHands.add(highHand);
					tieHands.add(hands.get(i));
					Hand judgedHand = Judgers.pairTieBreak(tieHands);
					
					if (judgedHand.getHand().get(0).getRank() == -1)
					{
						if (winners.size() > 0)
							winners.add(i+1);
						else
						{
							winners.add(i+1);
							winners.add(playerWithHighest);
						}
					}
					else
					{
						highHand = judgedHand;
						playerWithHighest = i;
						winners = new ArrayList<Integer>();
						winners.add(i+1);
					}
				}
				
				if (highest == 3)
				{
					ArrayList<Hand> tieHands = new ArrayList<Hand>();
					tieHands.add(highHand);
					tieHands.add(hands.get(i));
					Hand judgedHand = Judgers.twoPairTieBreak(tieHands);
					
					if (judgedHand.getHand().get(0).getRank() == -1)
					{
						if (winners.size() > 0)
							winners.add(i+1);
						else
						{
							winners.add(i+1);
							winners.add(playerWithHighest);
						}
					}
					else
					{
						highHand = judgedHand;
						playerWithHighest = i;
						winners = new ArrayList<Integer>();
						winners.add(i+1);
					}
				}
				
				if (highest == 4)
				{
					ArrayList<Hand> tieHands = new ArrayList<Hand>();
					tieHands.add(highHand);
					tieHands.add(hands.get(i));
					Hand judgedHand = Judgers.threeOfAKindTieBreak(tieHands);
					
					if (judgedHand.getHand().get(0).getRank() == -1)
					{
						if (winners.size() > 0)
							winners.add(i+1);
						else
						{
							winners.add(i+1);
							winners.add(playerWithHighest);
						}
					}
					else
					{
						highHand = judgedHand;
						playerWithHighest = i;
						winners = new ArrayList<Integer>();
						winners.add(i+1);
					}
				}
				
				if (highest == 5)
				{
					ArrayList<Hand> tieHands = new ArrayList<Hand>();
					tieHands.add(highHand);
					tieHands.add(hands.get(i));
					Hand judgedHand = Judgers.straightTieBreak(tieHands);
					
					if (judgedHand.getHand().get(0).getRank() == -1)
					{
						if (winners.size() > 0)
							winners.add(i+1);
						else
						{
							winners.add(i+1);
							winners.add(playerWithHighest);
						}
					}
					else
					{
						highHand = judgedHand;
						playerWithHighest = i;
						winners = new ArrayList<Integer>();
						winners.add(i+1);
					}
				}
				if (highest == 6)
				{
					ArrayList<Hand> tieHands = new ArrayList<Hand>();
					tieHands.add(highHand);
					tieHands.add(hands.get(i));
					Hand judgedHand = Judgers.flushTieBreak(tieHands);
					
					if (judgedHand.getHand().get(0).getRank() == -1)
					{
						if (winners.size() > 0)
							winners.add(i+1);
						else
						{
							winners.add(i+1);
							winners.add(playerWithHighest);
						}
					}
					else
					{
						highHand = judgedHand;
						playerWithHighest = i;
						winners = new ArrayList<Integer>();
						winners.add(i+1);
					}
				}
				
				if (highest == 7)
				{
					ArrayList<Hand> tieHands = new ArrayList<Hand>();
					tieHands.add(highHand);
					tieHands.add(hands.get(i));
					Hand judgedHand = Judgers.fullHouseTieBreak(tieHands);
					
					if (judgedHand.getHand().get(0).getRank() == -1)
					{
						if (winners.size() > 0)
							winners.add(i+1);
						else
						{
							winners.add(i+1);
							winners.add(playerWithHighest);
						}
					}
					else
					{
						highHand = judgedHand;
						playerWithHighest = i;
						winners = new ArrayList<Integer>();
						winners.add(i+1);
					}
				}
				
				if (highest == 8)
				{
					ArrayList<Hand> tieHands = new ArrayList<Hand>();
					tieHands.add(highHand);
					tieHands.add(hands.get(i));
					Hand judgedHand = Judgers.fourOfAKindTieBreak(tieHands);
					
					if (judgedHand.getHand().get(0).getRank() == -1)
					{
						if (winners.size() > 0)
							winners.add(i+1);
						else
						{
							winners.add(i+1);
							winners.add(playerWithHighest);
						}
					}
					
					else
					{
						highHand = judgedHand;
						playerWithHighest = i;
						winners = new ArrayList<Integer>();
						winners.add(i+1);
					}
				}
				
				if (highest == 9)
				{
					ArrayList<Hand> tieHands = new ArrayList<Hand>();
					tieHands.add(highHand);
					tieHands.add(hands.get(i));
					Hand judgedHand = Judgers.straightFlushTieBreak(tieHands);
					
					if (judgedHand.getHand().get(0).getRank() == -1)
					{
						if (winners.size() > 0)
							winners.add(i+1);
						else
						{
							winners.add(i+1);
							winners.add(playerWithHighest);
						}
					}
					else
					{
						highHand = judgedHand;
						playerWithHighest = i;
						winners = new ArrayList<Integer>();
						winners.add(i+1);
					}
				}
			}
		}
		return winners;
	}

}
