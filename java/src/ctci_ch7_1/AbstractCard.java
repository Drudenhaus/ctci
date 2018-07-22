package ctci_ch7_1;

/*
 * Assumption: represents a card from a standard 52-card deck (Ace through King, four standard suits)
 */

public abstract class AbstractCard
{
    protected CardSuit suit;
    protected int value;

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

    public void setSuit(CardSuit newSuit)
    {
        this.suit = newSuit;
    }
}
