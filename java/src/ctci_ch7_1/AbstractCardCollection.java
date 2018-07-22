package ctci_ch7_1;

import java.util.ArrayList;

public abstract class AbstractCardCollection<T extends AbstractCard>
{
    protected ArrayList<T> cardCollection;

    public int getSize()
    {
        return this.cardCollection.size();
    }

    public abstract void shuffle();
}
