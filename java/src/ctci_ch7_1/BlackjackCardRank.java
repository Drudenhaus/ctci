package ctci_ch7_1;

public enum BlackjackCardRank
{
	ACE (1),
	TWO (2),
	THREE (3),
	FOUR (4),
	FIVE (5),
	SIX (6),
	SEVEN (7),
	EIGHT (8),
	NINE (9),
	TEN (10),
	JACK (10),
	QUEEN (10),
	KING (10);

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
