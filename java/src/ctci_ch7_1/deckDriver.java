package ctci_ch7_1;

public class deckDriver
{

	public static void main(String[] args)
	{
		BlackjackCard newCard = new BlackjackCard(CardSuit.CLUBS, BlackjackCardRank.ACE);
		System.out.println(newCard);
	}
}
