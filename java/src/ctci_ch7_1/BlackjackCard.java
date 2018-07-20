package ctci_ch7_1;

public class BlackjackCard extends AbstractCard
{
	public BlackjackCard(CardSuit suit, BlackjackCardRank rank)
	{
		this.suit = suit;
		this.value = rank.getValue();
	}

	public String toString()
	{
		StringBuilder name = new StringBuilder();
		name.append(BlackjackCardRank.toStringFromValue(this.value));
		name.append(" of ");
		name.append(this.suit.toString());
		return name.toString();
	}
}
