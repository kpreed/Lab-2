package MainPackage;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Plays a hand of poker until the user stops the game
 */
public class Play
{
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner check = new Scanner(System.in);
		String exit = "Y";
		Deck deck = new Deck();
		
		while (!exit.equals("N"))
		{
			Hand hand1 = new Hand(deck);
			Hand hand2 = new Hand(deck);
			Hand hand3 = new Hand(deck);
			Hand hand4 = new Hand(deck);
			hand1.sortHand();
			hand2.sortHand();
			hand3.sortHand();
			hand4.sortHand();
			ArrayList<Hand> hands = new ArrayList<Hand>();
			hands.add(hand1);
			hands.add(hand2);
			hands.add(hand3);
			hands.add(hand4);
			System.out.println("Player 1's hand is:\n" + hand1.toString());
			System.out.println("Player 2's hand is:\n" + hand2.toString());
			System.out.println("Player 3's hand is:\n" + hand3.toString());
			System.out.println("Player 4's hand is:\n" + hand4.toString());
			
			ArrayList<Integer> winners = Hand.judgeHands(hands);			

			
			@SuppressWarnings("unused")
			String printWin = "";
			int i = 0;
			
			for (int a:winners)
			{
				if (winners.size() > 1 && i == 0)
				{
					printWin += "Players " + a + ", ";
					i++;
				} 
				else if (winners.size() > 1 && a != winners.get(winners.size() - 1))
					printWin += a + ", ";
				else if (winners.size() > 1)
					printWin += a + " win!";
				else
					printWin = "Player " + a + " wins!";
			}
			System.out.println(printWin + "\n");
			System.out.println("Play another hand? (Y/N)");
			exit = check.nextLine().toUpperCase();
		}

	}

}
