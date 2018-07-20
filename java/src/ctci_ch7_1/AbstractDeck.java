package ctci_ch7_1;

import java.util.ArrayList;

public abstract class AbstractDeck
{
	ArrayList<AbstractCard> deck;

	public ArrayList<AbstractCard> getDeck()
	{
		return this.deck;
	}

	public int getSize()
	{
		return this.deck.size();
	}
}
