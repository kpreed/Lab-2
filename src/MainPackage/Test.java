package MainPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;

public class Test
{
	public static Hand highCard1;
	public static Hand highCard2;
	public static Hand onePair1;
	public static Hand onePair2;
	public static Hand twoPair1;
	public static Hand twoPair2;
	public static Hand threeOfAKind1;
	public static Hand threeOfAKind2;
	public static Hand straight1;
	public static Hand straight2;
	public static Hand flush1;
	public static Hand flush2;
	public static Hand fullHouse1;
	public static Hand fullHouse2;
	public static Hand fourOfAKind1;
	public static Hand fourOfAKind2;
	public static Hand straightFlush1;
	public static Hand straightFlush2;
	public static Hand RoyalFlush1;
	public static Hand RoyalFlush2;
	
	//Royal Flush 1
	public static Card Spade14;
	public static Card Spade13;
	public static Card Spade12;
	public static Card Spade11;
	public static Card Spade10;
	
	//Royal Flush 2
	public static Card Heart14;
	public static Card Heart13;
	public static Card Heart12;
	public static Card Heart11;
	public static Card Heart10;
	
	//Straight Flush 1
	public static Card Spade9;
	
	//Straight Flush 2
	public static Card Heart9;
	public static Card Heart8;
	
	//Flush 1
	public static Card Diamond2;
	public static Card Diamond5;
	public static Card Diamond6;
	public static Card Diamond9;
	public static Card Diamond11;
	
	//Flush 2
	public static Card Diamond13;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		//Create first royal flush (presorted)
		Spade14 = new Card(14,"Spades");
		Spade13 = new Card(13,"Spades");
		Spade12 = new Card(12,"Spades");
		Spade11 = new Card(11,"Spades");
		Spade10 = new Card(10,"Spades");
		Card[] hand = {Spade10,Spade11,Spade12,Spade13,Spade14};
		RoyalFlush1 = new Hand(hand);
		
		//Create second royal flush and sort
		Heart14 = new Card(14,"Hearts");
		Heart13 = new Card(13,"Hearts");
		Heart12 = new Card(12,"Hearts");
		Heart11 = new Card(11,"Hearts");
		Heart10 = new Card(10,"Hearts");
		Card[] hand1 = {Heart12,Heart14,Heart10,Heart11,Heart13};
		RoyalFlush2 = new Hand(hand1);
		RoyalFlush2.sortHand();
		
		//Create Straight flush 1
		Spade9 = new Card(9,"Spades");
		Card[] hand2 = {Spade9,Spade10,Spade11,Spade12,Spade13};
		straightFlush1 = new Hand(hand2);
		
		//Create Straight flush 2
		Heart9 = new Card(9,"Hearts");
		Heart8 = new Card(8,"Hearts");
		Card[] hand3 = {Heart8,Heart9,Heart10,Heart11,Heart12};
		straightFlush2 = new Hand(hand3);
		
		//Create four of a kind 1
		Card[] hand4 = {Spade10,Heart14,Heart14,Heart14,Heart14};
		fourOfAKind1 = new Hand(hand4);
		
		//Create four of a kind 2
		Card[] hand5 = {Heart8,Spade14,Spade14,Spade14,Spade14};
		fourOfAKind2 = new Hand(hand5);
		
		//Create full house 1
		Card[] hand6 = {Heart8,Heart8,Heart8,Spade14,Spade14};
		fullHouse1 = new Hand(hand6);
		
		//Create full house 2
		Card[] hand7 = {Heart8,Heart8,Spade12,Spade12,Spade12};
		fullHouse2 = new Hand(hand7);
		
		//Create flush 1
		Diamond2 = new Card(2,"Diamonds");
		Diamond5 = new Card(5,"Diamonds");
		Diamond6 = new Card(6,"Diamonds");
		Diamond9 = new Card(9,"Diamonds");
		Diamond11 = new Card(11,"Diamonds");
		Card[] hand8 = {Diamond2,Diamond5,Diamond6,Diamond9,Diamond11};
		flush1 = new Hand(hand8);
		
		//Create flush 2
		Diamond13 = new Card(13,"Diamonds");
		Card[] hand9 = {Diamond2, Diamond5, Diamond6, Diamond9, Diamond13};
		flush2 = new Hand(hand9);
		
		//Create straight 1
		Card[] hand18 = {Heart9,Heart10,Heart11,Spade12,Spade13};
		straight1 = new Hand(hand18);
		
		//Create Straight 2
		Card[] hand19 = {Heart8,Heart9,Heart10,Spade11,Spade12};
		straight2 = new Hand(hand19);
		
		//Create 3 of a kind 1
		Card[] hand10 = {Diamond5,Diamond5,Diamond5,Heart10,Heart11};
		threeOfAKind1 = new Hand(hand10);
		
		//Create 3 of a kind 2
		Card[] hand11 = {Diamond5,Diamond5,Diamond5,Heart10,Heart12};
		threeOfAKind2 = new Hand(hand11);
		
		//Create two pair 1
		Card[] hand12 = {Diamond5,Diamond5,Heart9,Heart10,Heart10};
		twoPair1 = new Hand(hand12);
		
		//Create two pair 2
		Card[] hand13 = {Diamond5,Diamond5,Heart10,Heart10,Heart13};
		twoPair2 = new Hand(hand13);
		
		//Create one pair 1
		Card[] hand14 = {Diamond5,Diamond5,Heart10,Heart11,Heart12};
		onePair1 = new Hand(hand14);
		
		//Create one pair 2
		Card[] hand15 = {Diamond5,Diamond5,Heart10,Heart11,Heart13};
		onePair2 = new Hand(hand15);
		
		//Create high card 1
		Card[] hand16 = {Diamond5,Diamond6,Spade10,Heart11,Heart14};
		highCard1 = new Hand(hand16);
		
		//Create high card 2
		Card[] hand17 = {Diamond6,Diamond6,Spade10,Heart11,Heart14};
		highCard2 = new Hand(hand17);
	}

	@org.junit.Test
	public void test()
	{
		assertTrue(Hand.judgeHand(RoyalFlush1) == 10);
		assertTrue(Hand.judgeHand(straightFlush1) == 9);
		assertTrue(Hand.judgeHand(fourOfAKind1) == 8);
		assertTrue(Hand.judgeHand(fullHouse1) == 7);
		assertTrue(Hand.judgeHand(flush1) == 6);
		assertTrue(Hand.judgeHand(straight1) == 5);
		assertTrue(Hand.judgeHand(threeOfAKind1) == 4);
		assertTrue(Hand.judgeHand(twoPair1) == 3);
		assertTrue(Hand.judgeHand(onePair1) == 2);
		assertTrue(Hand.judgeHand(highCard1) == 1);
		
		ArrayList<Hand> testJudge = new ArrayList<Hand>();
		testJudge.add(highCard1);
		testJudge.add(RoyalFlush1);
		testJudge.add(straightFlush1);
		assertTrue(Hand.judgeHands(testJudge).get(0) == 2);
		
		testJudge.clear();
		testJudge.add(highCard1);
		testJudge.add(highCard1);
		System.out.println(Hand.judgeHands(testJudge).toString());
		
		testJudge.add(RoyalFlush1);
		assertTrue(Hand.judgeHands(testJudge).get(0) == 3);
	}

}
