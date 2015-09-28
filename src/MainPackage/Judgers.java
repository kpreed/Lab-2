package MainPackage;

public class Judgers
{
	public static boolean isPair(Hand hand)
	{
		for (int i = 0; i < (hand.getHand().length - 1); i++)
		{
			if (hand.getHand().get(i).getRank() == hand.getHand().get(i + 1).getRank())
				return true;
		}
		return false;
	}

	public static boolean isTwoPair(Hand hand)
	{
		if (hand.getHand().get(1).getRank() == hand.getHand().get(2).getRank())
			if (hand.getHand().get(3).getRank() == hand.getHand().get(4).getRank())
				return true;
			else if (hand.getHand().get(4).getRank() == hand.getHand().get(5).getRank())
				return true;
			else
				return false;
		else if (hand.getHand().get(2).getRank() == hand.getHand().get(3).getRank())
			if (hand.getHand().get(4).getRank() == hand.getHand().get(5).getRank())
				return true;
			else
				return false;
		return false;
	}

	public static boolean isThreeOfAKind(Hand hand)
	{
		for (int i = 0; i < (hand.getHand().length - 2); i++)
		{
			if (hand.getHand().get(i).getRank() == hand.getHand().get(i + 1).getRank()
					&& hand.getHand().get(i + 1).getRank() == hand.getHand().get(i + 2).getRank())
				return true;
		}
		return false;
	}

	public static boolean isStraight(Hand hand)
	{
		for (int i = 0; i < (hand.getHand().length - 1); i++)
		{
			if (hand.getHand().get(i).getRank() + 1 != hand.getHand().get(i + 1).get(i + 1).getRank())
				return false;
		}

		return true;
	}

	public static boolean isFlush(Hand hand)
	{
		if (hand.getHand().get(1).getSuit() == hand.getHand().get(2).getSuit())
			if (hand.getHand().get(2).getSuit() == hand.getHand().get(3).getSuit())
				if (hand.getHand().get(4).getSuit() == hand.getHand().get(5).getSuit())
					return true;
				else
					return false;
			else
				return false;
		else
			return false;
	}

	public static boolean isFullHouse(Hand hand)
	{
		if (hand.getHand().get(1) == hand.getHand().get(2))
			if (hand.getHand().get(2) == hand.getHand().get(3))
				if (hand.getHand().get(4) == hand.getHand().get(5))
					return true;
				else
					return false;
			else if (hand.getHand(3) == hand.getHand(4))
				if (hand.getHand(4) == hand.getHand(5))
					return true;
				else
					return false;
			else
				return false;
		else
			return false;
	}

	public static boolean isFourOfAKind(Hand hand)
	{
		if (hand.getHand().get(1) == hand.getHand().get(2))
			if (hand.getHand().get(2) == hand.getHand().get(3))
				if (hand.getHand().get(3) == hand.getHand().get(4))
					return true;
				else
					return false;
			else
				return false;
		else if (hand.getHand().get(2) == hand.getHand().get(3))
			if (hand.getHand().get(3) == hand.getHand().get(4))
				if (hand.getHand().get(4) == hand.getHand().get(5))
					return true;
				else
					return false;
			else
				return false;
		return false;
	}

	public static boolean isStraightFlush(Hand hand)
	{
		if (isStraight(hand))
			if (isFlush(hand))
				return true;
		return false;
	}

	public static boolean isRoyalFlush(Hand hand)
	{
		if (isFlush(hand) && hand.getHand().get(1).getRank() == 10)
			return true;
		return false;
	}
	
	public static Hand pairTieBreak(ArrayList<Hand> hands)
	{
		
	}
}
