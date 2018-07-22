package ctci_ch7_1;

public class BlackjackCard extends AbstractCard
{
    public BlackjackCard(CardSuit suit, BlackjackCardRank rank)
    {
        this.setSuit(suit);
        this.setValue(rank.getValue());
    }

    public int getValue()
    {
        return this.value;
    }

    public int getPlayValue()
    {
        // Hand value will need to accommodate aces as having an alternate value of 11
        return Math.min(this.value, 10);
    }

    public String toString()
    {
        StringBuilder name = new StringBuilder();
        name.append(BlackjackCardRank.toStringFromValue(this.value));
        name.append(" of ");
        name.append(this.getSuit().toString());
        return name.toString();
    }
}
