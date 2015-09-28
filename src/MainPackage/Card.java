package MainPackage;
import java.util.Comparator;

public class Card implements Comparator<Card>
{
	public Card()
	{
		
	}
	
	public Card(int rank, String suit)
	{
		
	}
	
	@Override
	public int compare(Card card1, Card card2)
	{
		if(card1.getRank() > card2.getRank())
			return 1;
		else if(card1.getRank() < card2.getRank())
			return -1;
		else
			return 0;
	}
	
}
