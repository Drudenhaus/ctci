package ctci_ch7_1;

public enum CardSuit
{
    // This ordering is only actually semi-canonical
    CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);

    private int value;

    private CardSuit(int suit)
    {
        this.value = suit;
    }

    public int getValue()
    {
        return this.value;
    }

    public String toString()
    {
        return this.name();
    }
}
