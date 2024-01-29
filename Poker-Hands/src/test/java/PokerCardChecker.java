import org.PokerProject.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokerCardChecker {

    @Test
    public void testCardCreate() {
        Card card = new Card("H", "A");

        assertEquals("H", card.getColor());
        assertEquals("A", card.getValue());
    }

    @Test
    public void testEqualsCardsNull() {
        Card card = new Card("H", "K");

        assertFalse(card.equalsCards(null));
    }

    @Test
    public void testEqualsCardsTrue() {
        Card cardOne = new Card("D", "10");
        Card cardTwo = new Card("D", "10");

        assertTrue(cardOne.equalsCards(cardTwo));
    }

    @Test
    public void testEqualsCardsFalse() {
        Card cardOne = new Card("C", "2");
        Card cardTwo = new Card("S", "2");

        assertFalse(cardOne.equalsCards(cardTwo));
    }
}
