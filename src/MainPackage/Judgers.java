package MainPackage;

import java.util.ArrayList;

/**
 * Helper class for Hand. Contains methods for ranking a hand as well as
 * breaking ties. ALL HANDS MUST BE SORTED IN ASCENDING ORDER BASED ON RANK
 */
public class Judgers
{
	public static boolean isPair(Hand hand)
	{
		for (int i = 0; i < (hand.getHand().size() - 1); i++)
		{
			if (hand.getHand().get(i).getRank() == hand.getHand().get(i + 1).getRank())
				return true;
		}
		return false;
	}

	public static boolean isTwoPair(Hand hand)
	{
		if (hand.getHand().get(0).getRank() == hand.getHand().get(1).getRank())
		{
			if (hand.getHand().get(2).getRank() == hand.getHand().get(3).getRank())
				return true;
			else if (hand.getHand().get(3).getRank() == hand.getHand().get(4).getRank())
				return true;
			else
				return false;
		} else if (hand.getHand().get(1).getRank() == hand.getHand().get(2).getRank())
		{
			if (hand.getHand().get(3).getRank() == hand.getHand().get(4).getRank())
				return true;
			else
				return false;
		}
		return false;
	}

	public static boolean isThreeOfAKind(Hand hand)
	{
		for (int i = 0; i < (hand.getHand().size() - 2); i++)
		{
			if (hand.getHand().get(i).getRank() == hand.getHand().get(i + 1).getRank()
					&& hand.getHand().get(i + 1).getRank() == hand.getHand().get(i + 2).getRank())
				return true;
		}
		return false;
	}

	public static boolean isStraight(Hand hand)
	{
		// Check for straight with Ace low card
		if (hand.getHand().get(4).getRank() == 14 && hand.getHand().get(0).getRank() == 2
				&& hand.getHand().get(1).getRank() == 3 && hand.getHand().get(2).getRank() == 4
				&& hand.getHand().get(3).getRank() == 5)
			return true;
		else
		{
			for (int i = 0; i < (hand.getHand().size() - 1); i++)
			{
				if (hand.getHand().get(i).getRank() + 1 != hand.getHand().get(i + 1).getRank())
					return false;
			}
		}
		return true;
	}

	public static boolean isFlush(Hand hand)
	{
		if (hand.getHand().get(0).getSuit() == hand.getHand().get(1).getSuit())
		{
			if (hand.getHand().get(1).getSuit() == hand.getHand().get(2).getSuit())
			{
				if (hand.getHand().get(2).getSuit() == hand.getHand().get(3).getSuit())
				{
					if (hand.getHand().get(3).getSuit() == hand.getHand().get(4).getSuit())
						return true;
					else
						return false;
				} else
					return false;
			} else
				return false;
		} else
			return false;
	}

	public static boolean isFullHouse(Hand hand)
	{
		if (hand.getHand().get(0).getRank() == hand.getHand().get(1).getRank())
		{
			if (hand.getHand().get(1).getRank() == hand.getHand().get(2).getRank())
			{
				if (hand.getHand().get(3).getRank() == hand.getHand().get(4).getRank())
					return true;
				else
					return false;
			} else if (hand.getHand().get(2).getRank() == hand.getHand().get(3).getRank())
			{
				if (hand.getHand().get(3).getRank() == hand.getHand().get(4).getRank())
					return true;
				else
					return false;
			} else
				return false;
		} else
			return false;
	}

	public static boolean isFourOfAKind(Hand hand)
	{
		if (hand.getHand().get(0).getRank() == hand.getHand().get(1).getRank())
		{
			if (hand.getHand().get(1).getRank() == hand.getHand().get(2).getRank())
			{
				if (hand.getHand().get(2).getRank() == hand.getHand().get(3).getRank())
					return true;
				else
					return false;
			} else
				return false;
		} else if (hand.getHand().get(1).getRank() == hand.getHand().get(2).getRank())
		{
			if (hand.getHand().get(2).getRank() == hand.getHand().get(3).getRank())
			{
				if (hand.getHand().get(3).getRank() == hand.getHand().get(4).getRank())
					return true;
				else
					return false;
			} else
				return false;
		}

		return false;
	}

	public static boolean isStraightFlush(Hand hand)
	{
		if (isStraight(hand))
		{
			if (isFlush(hand))
				return true;
		}
		return false;
	}

	public static boolean isRoyalFlush(Hand hand)
	{
		if (isFlush(hand) && hand.getHand().get(0).getRank() == 10)
			return true;
		return false;
	}
	
	/**
	 * This tie breaker doesn't work correctly
	 */
	public static Hand highCardTieBreak(ArrayList<Hand> hands)
	{
		if (hands.get(0).getHand().get(4).getRank() == hands.get(1).getHand().get(4).getRank())
		{
			if (hands.get(0).getHand().get(3).getRank() == hands.get(1).getHand().get(3).getRank())
			{
				if (hands.get(0).getHand().get(2).getRank() == hands.get(1).getHand().get(2).getRank())
				{
					if (hands.get(0).getHand().get(1).getRank() == hands.get(1).getHand().get(1).getRank())
					{
						if (hands.get(0).getHand().get(0).getRank() == hands.get(1).getHand().get(0).getRank())
							return new Hand();
						else if (hands.get(0).getHand().get(0).getRank() > hands.get(1).getHand().get(0).getRank())
							return hands.get(0);
						else
							return hands.get(1);
					}
					else if (hands.get(0).getHand().get(1).getRank() > hands.get(1).getHand().get(1).getRank())
						return hands.get(0);
					else
						return hands.get(1);
				}
				else if (hands.get(0).getHand().get(2).getRank() > hands.get(1).getHand().get(2).getRank())
					return hands.get(0);
				else
					return hands.get(1);
			}
			else if (hands.get(0).getHand().get(3).getRank() > hands.get(1).getHand().get(3).getRank())
				return hands.get(0);
			else
				return hands.get(1);
		}
		else if (hands.get(0).getHand().get(4).getRank() > hands.get(1).getHand().get(4).getRank())
			return hands.get(0);
		else
			return hands.get(1);
	}
	/**
	 * This tie breaker doesn't work.
	 */
	public static Hand pairTieBreak(ArrayList<Hand> hands)
	{
		ArrayList<Card> hand1 = hands.get(0).getHand();
		ArrayList<Card> hand2 = hands.get(1).getHand();
		Card hand1pair = null;
		Card hand2pair = null;
		int[] pair1index = {0,0};
		int[] pair2index = {0,0};

		for (int i = 0; i < (hand1.size() - 2); i++)
		{
			if (hand1.get(i).getRank() == hand1.get(i + 1).getRank())
			{
				pair1index[0] = i;
				pair1index[1] = i+1;
				break;
			}
		}

		for (int i = 0; i < (hand2.size() - 2); i++)
		{
			if (hand2.get(i).getRank() == hand2.get(i + 1).getRank())
			{
				pair2index[0] = i;
				pair2index[1] = i+1;
				break;
			}
		}

		if (hand1.get(pair1index[0]).getRank() == hand2.get(pair2index[0]).getRank())
		{
			if (hand1.get(2).getRank() == hand2.get(2).getRank())
			{
				if (hand1.get(1).getRank() == hand2.get(1).getRank())
				{
					if (hand1.get(0).getRank() == hand2.get(0).getRank())
						return new Hand();
					else if (hand1.get(0).getRank() > hand2.get(0).getRank())
						return hands.get(0);
					else
						return hands.get(1);
				}
				else if (hand1.get(1).getRank() > hand2.get(1).getRank())
					return hands.get(0);
				else
					return hands.get(1);
			}
			else if (hand1.get(2).getRank() > hand2.get(2).getRank())
				return hands.get(0);
			else
				return hands.get(1);
		}
		else if (hand1.get(pair1index[0]).getRank() > hand2.get(pair2index[0]).getRank())
			return hands.get(0);
		else
			return hands.get(1);
	}

	public static Hand twoPairTieBreak(ArrayList<Hand> hands)
	{
		Card hand1LowPair;
		Card hand2LowPair;
		Card hand1HighPair;
		Card hand2HighPair;
		Card hand1Kicker;
		Card hand2Kicker;

		if (hands.get(0).getHand().get(0).getRank() == hands.get(0).getHand().get(1).getRank())
		{
			hand1LowPair = hands.get(0).getHand().get(0);
			if (hands.get(0).getHand().get(2).getRank() == hands.get(0).getHand().get(3).getRank())
			{
				hand1HighPair = hands.get(0).getHand().get(2);
				hand1Kicker = hands.get(0).getHand().get(4);
			} else
			{
				hand1HighPair = hands.get(0).getHand().get(3);
				hand1Kicker = hands.get(0).getHand().get(2);
			}
		} else
		{
			hand1LowPair = hands.get(0).getHand().get(1);
			hand1HighPair = hands.get(0).getHand().get(3);
			hand1Kicker = hands.get(0).getHand().get(0);
		}

		if (hands.get(1).getHand().get(0).getRank() == hands.get(1).getHand().get(1).getRank())
		{
			hand2LowPair = hands.get(1).getHand().get(0);
			if (hands.get(1).getHand().get(2).getRank() == hands.get(1).getHand().get(3).getRank())
			{
				hand2HighPair = hands.get(1).getHand().get(2);
				hand2Kicker = hands.get(1).getHand().get(4);
			} else
			{
				hand2HighPair = hands.get(1).getHand().get(3);
				hand2Kicker = hands.get(1).getHand().get(2);
			}
		} else
		{
			hand2LowPair = hands.get(1).getHand().get(1);
			hand2HighPair = hands.get(1).getHand().get(3);
			hand2Kicker = hands.get(1).getHand().get(0);
		}

		if (hand1HighPair.getRank() == hand2HighPair.getRank())
			if (hand1LowPair.getRank() == hand2LowPair.getRank())
				if (hand1Kicker.getRank() == hand2Kicker.getRank())
					return new Hand();
				else if (hand1Kicker.getRank() > hand2Kicker.getRank())
					return hands.get(0);
				else
					return hands.get(1);
			else if (hand1LowPair.getRank() > hand2LowPair.getRank())
				return hands.get(0);
			else
				return hands.get(1);
		else if (hand1HighPair.getRank() > hand2HighPair.getRank())
			return hands.get(0);
		else
			return hands.get(1);
	}

	public static Hand threeOfAKindTieBreak(ArrayList<Hand> hands)
	{
		ArrayList<Card> hand1 = hands.get(0).getHand();
		ArrayList<Card> hand2 = hands.get(1).getHand();
		Card hand1ThreeOfAKind = null;
		Card hand2ThreeOfAKind = null;

		for (int i = 0; i < (hand1.size() - 3); i++)
		{
			if (hand1.get(i) == hand1.get(i + 1) && hand1.get(i + 1) == hand1.get(i + 2))
			{
				hand1ThreeOfAKind = hand1.get(i);
				hand1.remove(i);
				hand1.remove(i);
				hand1.remove(i);
				break;
			}
		}

		for (int i = 0; i < (hand2.size() - 2); i++)
		{
			if (hand2.get(i) == hand2.get(i + 1) && hand2.get(i + 1) == hand2.get(i + 2))
			{
				hand2ThreeOfAKind = hand2.get(i);
				hand2.remove(i);
				hand2.remove(i);
				hand2.remove(i);
				break;
			}
		}

		if (hand1ThreeOfAKind.getRank() == hand2ThreeOfAKind.getRank())
			if (hand1.get(1) == hand2.get(1))
				if (hand1.get(0) == hand2.get(0))
					return new Hand();
				else if (hand1.get(0).getRank() > hand2.get(0).getRank())
					return hands.get(0);
				else
					return hands.get(1);
			else if (hand1.get(1).getRank() > hand2.get(1).getRank())
				return hands.get(0);
			else
				return hands.get(1);
		else if (hand1ThreeOfAKind.getRank() > hand2ThreeOfAKind.getRank())
			return hands.get(0);
		else
			return hands.get(1);

	}

	public static Hand straightTieBreak(ArrayList<Hand> hands)
	{
		if (hands.get(0).getHand().get(4).getRank() == hands.get(1).getHand().get(4).getRank())
			return new Hand();
		else if (hands.get(0).getHand().get(4).getRank() > hands.get(1).getHand().get(4).getRank())
			return hands.get(0);
		else
			return hands.get(1);
	}
	
	public static Hand flushTieBreak(ArrayList<Hand> hands)
	{
		if (hands.get(0).getHand().get(4).getRank() == hands.get(1).getHand().get(4).getRank())
			return new Hand();
		else if (hands.get(0).getHand().get(4).getRank() == hands.get(1).getHand().get(4).getRank())
			return hands.get(0);
		else
			return hands.get(1);
	}
	
	public static Hand fullHouseTieBreak(ArrayList<Hand> hands)
	{
		if (hands.get(0).getHand().get(4).getRank() == hands.get(1).getHand().get(4).getRank())
			return new Hand();
		else if (hands.get(0).getHand().get(4).getRank() == hands.get(1).getHand().get(4).getRank())
			return hands.get(0);
		else
			return hands.get(1);
	}
	
	public static Hand fourOfAKindTieBreak(ArrayList<Hand> hands)
	{
		if (hands.get(0).getHand().get(4).getRank() == hands.get(1).getHand().get(4).getRank())
			return new Hand();
		else if (hands.get(0).getHand().get(4).getRank() == hands.get(1).getHand().get(4).getRank())
			return hands.get(0);
		else
			return hands.get(1);
	}
	
	public static Hand straightFlushTieBreak(ArrayList<Hand> hands)
	{
		if (hands.get(0).getHand().get(4).getRank() == hands.get(1).getHand().get(4).getRank())
			return new Hand();
		else if (hands.get(0).getHand().get(4).getRank() == hands.get(1).getHand().get(4).getRank())
			return hands.get(0);
		else
			return hands.get(1);
	}
	public static Hand royalFlushTieBreak(ArrayList<Hand> hands)
	{
		return new Hand();
	}
}
