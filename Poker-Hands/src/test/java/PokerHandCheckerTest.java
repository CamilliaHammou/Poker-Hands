import org.PokerProject.Card;
import org.PokerProject.Hand;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokerHandCheckerTest {

    @Test
    void testHasHighCard() {
        List<Card> isHighCard = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "3"),
                new Card("S", "4"),
                new Card("C", "5"),
                new Card("H", "7")
        );

        List<Card> notHighCard = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "2"),
                new Card("S", "3"),
                new Card("C", "3"),
                new Card("H", "4")
        );

        assertTrue(Hand.hasHighCard(isHighCard));
        assertFalse(Hand.hasHighCard(notHighCard));
    }
    @Test
    void testHasPair() {
        List<Card> WithPair = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "2"),
                new Card("S", "4"),
                new Card("C", "5"),
                new Card("H", "7")
        );

        List<Card> WithoutPair = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "3"),
                new Card("S", "4"),
                new Card("C", "5"),
                new Card("H", "7")
        );

        assertTrue(Hand.hasPair(WithPair));
        assertFalse(Hand.hasPair(WithoutPair));
    }

    @Test
    void testHasTwoPairs() {
        List<Card> WithTwoPairs = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "2"),
                new Card("S", "4"),
                new Card("C", "4"),
                new Card("H", "7")
        );

        List<Card> WithoutTwoPairs = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "3"),
                new Card("S", "4"),
                new Card("C", "5"),
                new Card("H", "7")
        );

        assertTrue(Hand.hasTwoPairs(WithTwoPairs));
        assertFalse(Hand.hasTwoPairs(WithoutTwoPairs));
    }
    @Test
    void testHasThreeOfAKind() {
        List<Card> cardsWithThreeOfAKind = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "2"),
                new Card("S", "2"),
                new Card("C", "3"),
                new Card("H", "4")
        );

        List<Card> cardsWithoutThreeOfAKind = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "3"),
                new Card("S", "4"),
                new Card("C", "5"),
                new Card("H", "6")
        );

        assertTrue(Hand.hasThreeOfAKind(cardsWithThreeOfAKind));
        assertFalse(Hand.hasThreeOfAKind(cardsWithoutThreeOfAKind));
    }

    @Test
    void testHasStraight() {
        List<Card> cardsWithStraight = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "3"),
                new Card("S", "4"),
                new Card("C", "5"),
                new Card("H", "6")
        );

        List<Card> cardsWithoutStraight = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "3"),
                new Card("S", "4"),
                new Card("C", "5"),
                new Card("H", "7")
        );

        assertTrue(Hand.hasStraight(cardsWithStraight));
        assertFalse(Hand.hasStraight(cardsWithoutStraight));
    }

    @Test
    void testHasFlush() {
        List<Card> cardsWithFlush = Arrays.asList(
                new Card("H", "2"),
                new Card("H", "3"),
                new Card("H", "4"),
                new Card("H", "5"),
                new Card("H", "6")
        );

        List<Card> cardsWithoutFlush = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "3"),
                new Card("S", "4"),
                new Card("C", "5"),
                new Card("H", "6")
        );

        assertTrue(Hand.hasFlush(cardsWithFlush));
        assertFalse(Hand.hasFlush(cardsWithoutFlush));
    }

    @Test
    void testHasFullHouse() {
        List<Card> cardsWithFullHouse = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "2"),
                new Card("S", "2"),
                new Card("C", "3"),
                new Card("H", "3")
        );

        List<Card> cardsWithoutFullHouse = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "4"),
                new Card("S", "5"),
                new Card("C", "6"),
                new Card("H", "7")
        );
        assertTrue(Hand.hasFullHouse(cardsWithFullHouse));
        assertFalse(Hand.hasFullHouse(cardsWithoutFullHouse));
    }

    @Test
    void testHasStraightFlush() {
        List<Card> cardsWithStraightFlush = Arrays.asList(
                new Card("H", "2"),
                new Card("H", "3"),
                new Card("H", "4"),
                new Card("H", "5"),
                new Card("H", "6")
        );

        List<Card> cardsWithoutStraightFlush = Arrays.asList(
                new Card("H", "2"),
                new Card("H", "3"),
                new Card("H", "4"),
                new Card("H", "5"),
                new Card("D", "6")
        );
        assertTrue(Hand.hasStraightFlush(cardsWithStraightFlush));
        assertFalse(Hand.hasStraightFlush(cardsWithoutStraightFlush));
    }

    @Test
    void testHasFourOfAKind() {
        List<Card> cardsWithFourOfAKind = Arrays.asList(
                new Card("H", "9"),
                new Card("D", "9"),
                new Card("S", "9"),
                new Card("C", "9"),
                new Card("H", "3")
        );

        List<Card> cardsWithoutFourOfAKind = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "2"),
                new Card("S", "3"),
                new Card("C", "3"),
                new Card("H", "4")
        );
        assertTrue(Hand.hasFourOfAKind(cardsWithFourOfAKind));
        assertFalse(Hand.hasFourOfAKind(cardsWithoutFourOfAKind));
    }
}