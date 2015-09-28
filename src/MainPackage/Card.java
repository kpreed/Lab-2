package MainPackage;

public class Card
{
	private int rank;
	private String suit;
	
	public Card(int rank, String suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getRank()
	{
		return this.rank;
	}
	
	public String getSuit()
	{
		return this.suit;	
	}
	
	public int compareTo(Card otherCard)
	{
		if(this.rank == otherCard.getRank())
			return 0;
		return this.rank < otherCard.getRank() ? -1 : 1;
	}
	
	
}
