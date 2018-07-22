package ctci_ch7_1;

import java.util.ArrayList;
import java.util.Random;

public class BlackjackHand extends AbstractCardCollection<BlackjackCard>
{
    public ArrayList<BlackjackCard> getHand()
    {
        return this.cardCollection;
    }

    public int getValue()
    {
        // TODO handle variable value of aces
        int handValue = 0;
        for (BlackjackCard currentCard : this.getHand())
        {
            handValue += currentCard.getPlayValue();
        }
        return handValue;
    }

    @Override
    public void shuffle()
    {
        Random rand = new Random();
        int end = this.getSize();
        for (int start = 0; start < end; end--)
        {
            this.getHand().add(this.getHand().remove(rand.nextInt(end)));
        }
    }
}
