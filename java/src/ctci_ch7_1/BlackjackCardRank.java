package ctci_ch7_1;

public enum BlackjackCardRank
{
    // Face cards are really a value of 10 but must be assigned sequential values to
    // support iteration
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int value;

    private BlackjackCardRank(int rank)
    {
        this.value = rank;
    }

    public int getValue()
    {
        return this.value;
    }

    public String toString()
    {
        return this.name();
    }

    public static String toStringFromValue(int inputValue)
    {
        for (BlackjackCardRank rank : BlackjackCardRank.values())
        {
            if (rank.value == inputValue)
            {
                return rank.toString();
            }
        }
        return null;
    }
}
