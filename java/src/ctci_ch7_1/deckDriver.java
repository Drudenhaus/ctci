package ctci_ch7_1;

public class deckDriver
{

    public static void main(String[] args)
    {
        BlackjackDeck newDeck = new BlackjackDeck();
        newDeck.shuffle();
        System.out.println(newDeck.toString());
        System.out.println(newDeck.getSize());

    }
}
