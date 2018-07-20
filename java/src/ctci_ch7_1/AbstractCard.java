package ctci_ch7_1;

public abstract class AbstractCard
{
	CardSuit suit;
	int value;

	public int getValue()
	{
		return this.value;
	}

	public void setValue(int newValue)
	{
		this.value = newValue;
	}

	public CardSuit getSuit()
	{
		return this.suit;
	}

	public void setValue(CardSuit newSuit)
	{
		this.suit = newSuit;
	}

	public String toString()
	{
		StringBuilder name = new StringBuilder();
		name.append(this.value);
		name.append(" of ");
		name.append(this.suit.toString());
		return name.toString();
	}
}
