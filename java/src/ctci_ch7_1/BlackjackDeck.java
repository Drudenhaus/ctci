package ctci_ch7_1;

import java.util.ArrayList;
import java.util.Random;

public class BlackjackDeck extends AbstractCardCollection<BlackjackCard>
{
    /*
     * The actual deck should be partitioned to represent the undealt cards, the discard/played cards, and the cards dealt but not played.
     * Deck:
     * | undealt cards | discarded cards | dealt cards |
     */

    private int nextUndealtCardIndex = 0;
    private int discardPileStartIndex; // end index is dealtCardStartIndex - 1
    private int dealtCardStartIndex; // end index is end of deck

    public BlackjackDeck()
    {
        this.cardCollection = new ArrayList<BlackjackCard>();
        for (CardSuit suit : CardSuit.values())
        {
            for (BlackjackCardRank rank : BlackjackCardRank.values())
            {
                this.getDeck().add(new BlackjackCard(suit, rank));
            }
        }
        this.discardPileStartIndex = this.getSize() - 1;
        this.dealtCardStartIndex = this.getSize() - 1;
    }

    public ArrayList<BlackjackCard> getDeck()
    {
        return this.cardCollection;
    }

    public BlackjackCard dealNextCard()
    {
        /*
         * Move card from undealt section to the dealt section
         *
         *        Undealt |Discard|Dealt
         * Index: 0 1 2 3 | 4 5 6 | 7
         * Card:  1 2 3 4 | 5 6 7 | 8
         *
         * to
         *
         *       Undealt|Discard|Dealt
         * Index: 0 1 2 | 3 4 5 | 6 7
         * Card:  2 3 4 | 5 6 7 | 8 1
         */
        BlackjackCard cardToDeal = this.getDeck().remove(nextUndealtCardIndex);
        this.getDeck().add(cardToDeal);
        this.discardPileStartIndex--;
        this.dealtCardStartIndex--;
        return cardToDeal;
    }

    public void discardCard(BlackjackCard theCard)
    {
        /*
         * Move card from dealt section to discarded section
         *
         *        Undealt |Discard|Dealt
         * Index: 0 1 2 3 | 4 5 6 | 7
         * Card:  1 2 3 4 | 5 6 7 | 8
         *
         * to
         *
         *        Undealt |Discard  |Dealt
         * Index: 0 1 2 3 | 4 5 6 7 |
         * Card:  1 2 3 4 | 8 5 6 7 |
         */
        this.getDeck().remove(theCard);
        this.getDeck().add(discardPileStartIndex, theCard);
        this.dealtCardStartIndex++;
    }

    public int getNumDealtCards()
    {
        return this.getSize() - dealtCardStartIndex;
    }

    public int getNumDiscardedCards()
    {
        return dealtCardStartIndex - discardPileStartIndex;
    }

    public int getNumUndealtCards()
    {
        return discardPileStartIndex;
    }

    @Override
    public void shuffle()
    {
        Random rand = new Random();
        int end = this.getSize();
        for (int start = 0; start < end; end--)
        {
            this.getDeck().add(this.getDeck().remove(rand.nextInt(end)));
        }
    }

    @Override
    public String toString()
    {
        StringBuilder stringRepr = new StringBuilder();
        for (AbstractCard card : this.getDeck())
        {
            stringRepr.append(card.toString());
            stringRepr.append(System.getProperty("line.separator"));
        }
        // Chop off the extra newline
        stringRepr.trimToSize();
        stringRepr.deleteCharAt(stringRepr.length() - 1);
        return stringRepr.toString();
    }
}
