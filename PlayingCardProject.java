import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections; 
import java.util.Comparator;

enum SuitEnum
{
	// 4 constants with parameters
	SPADE("S"),
	HEART("H"),
	DIAMOND("D"),
	CLUB("C");
	
	private final String suit_constant;
	
	SuitEnum (String suit_constant)
	{
		this.suit_constant = suit_constant;
	}
	
	// Accessor methods
	public String getSuitConstant ()
	{
		return suit_constant;
	}
}

enum RankEnum
{
	// 13 constants with parameters
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("T"),
	JACK("J"),
	QUEEN("Q"),
	KING("K"),
	ACE("A");
	
	private final String rank_constant;
	
	RankEnum (String rank_constant)
	{
		this.rank_constant = rank_constant;
	}
	
	// Accessor methods
	public String getRankConstant ()
	{
		return rank_constant;
	}
}

class PlayingCard
{
	// Playing Card has-a relationship with SuitEnum & RankEnum
	// 2 boys in the brain 
	private SuitEnum suit;
	private RankEnum rank;
	
	// Constructors
	public PlayingCard(SuitEnum suit, RankEnum rank)
	{
		setCard(suit, rank);
	}
	
	public PlayingCard(PlayingCard pc)
	{
		this(pc.suit, pc.rank);
	}
	
	// Accessor Methods
	public SuitEnum getSuit()
	{
		return suit;
	}
	
	public RankEnum getRank()
	{
		return rank;
	}
	
	// Mutator Methods
	public void setCard(SuitEnum suit, RankEnum rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
		
	public String toString()
	{
		return String.format("%s%s ", suit.getSuitConstant(), rank.getRankConstant());
	}
	
}	

class MyInt
{
	private int n;
	
	public void setInt(int n)
	{
		this.n = n;
	}
	
	public int getInt()
	{
		return n;
	}
}
	

class PlayingCardProject
{
	private static final int MAXC = 13;
	private static final int MAXD = 52;
	
	// Populate an arraylist of cards
	private static void deckOfCards(ArrayList<PlayingCard> cardList)
	{
		
		for(SuitEnum suit: SuitEnum.values())
		{
			for(RankEnum rank : RankEnum.values())
			{
				cardList.add(new PlayingCard(suit, rank));
			}
		}
	}
	
	private static void printDeck(ArrayList<PlayingCard> values)
	{
		int counter = 1;
		
		for(PlayingCard card : values) 
		{
			if(counter < MAXC)
			{
				counter++;
				System.out.print(card);
			}

			
			else
			{
				counter = 1;
				System.out.println(card);
			}
			
		}
	}
	
	private static void listToArray(ArrayList<PlayingCard> cardList, PlayingCard[] cardArray)
	{
		for(int i = 0; i < MAXD; i++)
		{
			cardArray[i] = new PlayingCard(cardList.get(i));
		}
	}
	
	private static void printDeck(PlayingCard[] cardArray)
	{
		int counter = 1;
		
		for (PlayingCard card : cardArray) 
		{
			if(counter < MAXC)
			{
				System.out.print(card);
				counter++;
			}

			
			else
			{
				System.out.println(card);
				counter = 1;
			}
		}
	}
	
	private static void transfer(PlayingCard[] cardArray, String[] strArray)
	{
		for(int i = 0; i < MAXD; i++)
		{
			strArray[i] = String.valueOf(cardArray[i]);
		}
	}
	
	private static void shuffle(String [] strArray)
	{		
		// Then input the values i, j & strArray into swap
		// Use swap in shuffle 
		
		Random rand = new Random();
		
		int k = rand.nextInt(10);
		
		for(int count = 0; count < k; count++)
		{
			for(int i = 0; i < MAXD; i++)
			{
				int j = rand.nextInt(MAXD);
				
				swap(strArray, i, j);
			}
		}
	}
	
	private static void swap(String[] str, int i, int j)
	{		
		String temp = str[i];
		str[i] = str[j];
		str[j] = temp;	
	}
	
	// Own input -> called in shuffle 
	private static void displayStringArray(String[] strArray)
	{
		int counter = 1;
		
		for (String card : strArray) 
		{
			if(counter < MAXC)
			{
				System.out.print(card);
				counter++;
			}

			
			else
			{
				System.out.println(card);
				counter = 1;
			}
		}
	}
		
	private static void transfer2D(String[][] twoD, String[] strArray)
	{
		int counter = 0;
		
		for(int row = 0; row < 4; row++)
		{
			for(int col = 0; col < 13; col++)
			{
				twoD[row][col] = strArray[counter];
				
				counter++;	
			}
		}
	}
	
	
	private static int transformIntoInt(String cardRank)
	{
		int card_int;
		
		switch(cardRank){
			
			case "2":
				card_int = 2;
				break;
				
			case "3":
				card_int = 3;
				break;
				
			case "4":
				card_int = 4;
				break;
				
			case "5":
				card_int = 5;
				break;
				
			case "6":
				card_int = 6;
				break;	
				
			case "7":
				card_int = 7;
				break;
				
			case "8":
				card_int = 8;
				break;
				
			case "9":
				card_int = 9;
				break;
				
			case "T":
				card_int = 10;
				break;
				
			case "J":
				card_int = 11;
				break;
				
			case "Q":
				card_int = 12;
				break;
				
			case "K":
				card_int = 13;
				break;
				
			case "A":
				card_int = 14;
				break;
				
			default:
				card_int = 0;
		}
				
		return card_int;
	}
	

	private static void sort2D(String[][] twoD)
	{
		Comparator<String> suitComparator = new Comparator<String>() 
		{
			public int compare(String a, String b) 
			{
					// Compare by Suit
					String a0 = a.substring(0,1);
					String b0 = b.substring(0,1);
					
					int suitCompare = b0.compareTo(a0);
					
					return suitCompare;
			}						
		};
		
		Comparator<String> rankComparator = new Comparator<String>() 
		{
			public int compare(String a, String b) 
			{	
				// Compare by Rank
				String a1 = a.substring(1,2);
				String b1 = b.substring(1,2);
								
				int a_int = transformIntoInt(a1);
				int b_int = transformIntoInt(b1);
								
				int	rankCompare = b_int - a_int;
				
				return rankCompare;
			}						
		};
		
		Comparator<String> cardComparator = new Comparator<String>() 
		{
			public int compare(String a, String b) 
			{	
				// Compare by Suit
				String a0 = a.substring(0,1);
				String b0 = b.substring(0,1);
					
				int suitCompare = b0.compareTo(a0);
				
				if(suitCompare == 0)
				{
					// Compare by Rank
					String a1 = a.substring(1,2);
					String b1 = b.substring(1,2);
									
					int a_int = transformIntoInt(a1);
					int b_int = transformIntoInt(b1);
									
					int	rankCompare = b_int - a_int;
					
					return rankCompare;
				}
				
				return suitCompare;
			}						
		};
		

		for(String[] row : twoD)
		{
			// Arrays.sort(row, suitComparator);
			// Arrays.sort(row, rankComparator);
			
			Arrays.sort(row, cardComparator);
		}
	
	}
	
	
	
	private static void print2D(String[][] strArray)
	{
		for(String [] row : strArray)
		{
			for(String card : row)
			{
				System.out.print(card);
			}
			
			System.out.println();
			
			MyInt s = new MyInt();
			MyInt h = new MyInt();
			MyInt d = new MyInt();
			MyInt c = new MyInt();
		
			getHandInfo(row, s, h, d, c);
			
			String handInfo = String.format("%d - %d - %d - %d", s.getInt(), h.getInt(), d.getInt(), c.getInt());
			
			System.out.println(handInfo);
		}
	}
	
	
	private static void getHandInfo(String[] anHand, MyInt s, MyInt h, MyInt d, MyInt c)
	{
		for(String i : anHand)
		{
			if(i.contains("S"))
			{
				s.setInt(s.getInt() + 1); 
			}
			
			else if (i.contains("H"))
			{
				h.setInt(h.getInt() + 1);
			}
			
			else if (i.contains("D"))
			{
				d.setInt(d.getInt() + 1);
			}
			
			else
			{
				c.setInt(c.getInt() + 1);
			}
		}
	}
	
	public static void main(String[] args)
	{
		// *** In the shuffle method, I used the parameter : String [] strArray instead of PlayingCard[] cardArray
		// *** I also added in a new method : displayStringArray()
		
		System.out.println();
		System.out.println("Printing from ArrayList / array");
		System.out.println("--------------------------------------");
		
		// Create an arraylist of objects
		ArrayList<PlayingCard> cardList = new ArrayList<PlayingCard>();
		deckOfCards(cardList);
		
		// Create an array of objects
		PlayingCard[] cardArray = new PlayingCard[MAXD];
		listToArray(cardList, cardArray);
		
		// Print deck can take in cardArray / cardList as parameter
		printDeck(cardArray);
		
		System.out.println();
		System.out.println("Shuffle the cards - Array Version");
		System.out.println("Printing from array");
		System.out.println("--------------------------------------");
		
		// Create an array of String objects
		String[] strArray = new String[MAXD];
		transfer(cardArray, strArray);
		
		// Shuffle the array of String objects
		shuffle(strArray);	
		displayStringArray(strArray);
		
		System.out.println();
		System.out.println("Re-arrange the cards");
		System.out.println("--------------------------------------");
		
		// Create a 2D Array from the String objects | Sort 2D Array | Print 2D Array with handInfo
		String[][] twoD = new String[4][13];
		transfer2D(twoD, strArray);
		sort2D(twoD);
		print2D(twoD);
	}
}


