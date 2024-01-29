import org.PokerProject.Card;
import org.PokerProject.Hand;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokerHandTieChecker {


    @Test
    void testHighCardHandWhiteWins() {
        List<Card> highCards1 = Arrays.asList(
                new Card("D", "7"),
                new Card("S", "6"),
                new Card("C", "A"),
                new Card("D", "Q"),
                new Card("D", "2")
        );
        List<Card> highCards2 = Arrays.asList(
                new Card("S", "5"),
                new Card("C", "3"),
                new Card("H", "9"),
                new Card("S", "7"),
                new Card("H", "8")
        );

        Hand highCardHand1 = new Hand();
        Hand highCardHand2 = new Hand();
        highCardHand1.setHand(highCards1);
        highCardHand2.setHand(highCards2);

        highCardHand2.displayHand(); highCardHand1.displayHand();
        System.out.println(Hand.compareHands(highCardHand2, highCardHand1));
        assertTrue(Hand.compareHands(highCardHand2, highCardHand1).contains("White wins with High Card" ));
    }

    @Test
    void testHighCardHandTie() {
        List<Card> highCards1 = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "3"),
                new Card("S", "4"),
                new Card("C", "6"),
                new Card("H", "7")
        );
        List<Card> highCards2 = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "3"),
                new Card("S", "4"),
                new Card("C", "6"),
                new Card("H", "7")
        );
        Hand highCardHand1 = new Hand();
        Hand highCardHand2 = new Hand();
        highCardHand1.setHand(highCards1);
        highCardHand2.setHand(highCards2);

        highCardHand1.displayHand(); highCardHand2.displayHand();
        System.out.println(Hand.compareHands(highCardHand1, highCardHand2));
        assertTrue(Hand.compareHands(highCardHand1, highCardHand2).contains("It's a tie !"));
    }

    @Test
    void testPairHandBlackWins() {
        List<Card> threeOfAKind1 = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "J"),
                new Card("S", "4"),
                new Card("C", "5"),
                new Card("H", "J")
        );
        List<Card> threeOfAKind2 = Arrays.asList(
                new Card("H", "A"),
                new Card("D", "3"),
                new Card("S", "7"),
                new Card("C", "6"),
                new Card("H", "7")
        );

        Hand pairCardHand1 = new Hand();
        Hand pairCardHand2 = new Hand();
        pairCardHand1.setHand(threeOfAKind1);
        pairCardHand2.setHand(threeOfAKind2);

        pairCardHand1.displayHand(); pairCardHand2.displayHand();
        System.out.println(Hand.compareHands(pairCardHand1, pairCardHand2));
        assertTrue(Hand.compareHands(pairCardHand1, pairCardHand2).contains("Black wins with Pair"));
    }

    @Test
    void testPairHandTie() {
        List<Card> highCards1 = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "3"),
                new Card("S", "4"),
                new Card("C", "K"),
                new Card("H", "K")
        );
        List<Card> highCards2 = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "3"),
                new Card("S", "4"),
                new Card("C", "K"),
                new Card("H", "K")
        );
        Hand highCardHand1 = new Hand();
        Hand highCardHand2 = new Hand();
        highCardHand1.setHand(highCards1);
        highCardHand2.setHand(highCards2);

        highCardHand1.displayHand(); highCardHand2.displayHand();
        System.out.println(Hand.compareHands(highCardHand1, highCardHand2));
        assertTrue(Hand.compareHands(highCardHand1, highCardHand2).contains("It's a tie !"));
    }

    @Test
    void testThreeOfAKindHandBlackWins() {
        List<Card> threeOfAKind1 = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "J"),
                new Card("S", "J"),
                new Card("C", "K"),
                new Card("H", "J")
        );
        List<Card> threeOfAKind2 = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "J"),
                new Card("S", "J"),
                new Card("C", "5"),
                new Card("H", "J")
        );

        Hand threeOfAKindHand1 = new Hand();
        Hand threeOfAKindHand2 = new Hand();
        threeOfAKindHand1.setHand(threeOfAKind1);
        threeOfAKindHand2.setHand(threeOfAKind2);

        threeOfAKindHand1.displayHand(); threeOfAKindHand2.displayHand();
        System.out.println(Hand.compareHands(threeOfAKindHand1, threeOfAKindHand2));
        assertTrue(Hand.compareHands(threeOfAKindHand1, threeOfAKindHand2).contains("Black wins with Three of a Kind"));
    }

    @Test
    void testThreeOfAKindHandTie() {
        List<Card> threeOfAKind1 = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "J"),
                new Card("S", "J"),
                new Card("C", "5"),
                new Card("H", "J")
        );
        List<Card> threeOfAKind2 = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "J"),
                new Card("S", "J"),
                new Card("C", "5"),
                new Card("H", "J")
        );

        Hand threeOfAKindHand1 = new Hand();
        Hand threeOfAKindHand2 = new Hand();
        threeOfAKindHand1.setHand(threeOfAKind1);
        threeOfAKindHand2.setHand(threeOfAKind2);

        threeOfAKindHand1.displayHand(); threeOfAKindHand2.displayHand();
        System.out.println(Hand.compareHands(threeOfAKindHand1, threeOfAKindHand2));
        assertTrue(Hand.compareHands(threeOfAKindHand1, threeOfAKindHand2).contains("It's a tie !"));
    }

    @Test
    void testStraightHandWhiteWins() {
        List<Card> straight1 = Arrays.asList(
                new Card("H", "A"),
                new Card("D", "2"),
                new Card("S", "3"),
                new Card("C", "4"),
                new Card("H", "5")
        );
        List<Card> straight2 = Arrays.asList(
                new Card("H", "9"),
                new Card("D", "10"),
                new Card("S", "J"),
                new Card("C", "Q"),
                new Card("H", "K")
        );

        Hand straightHand1 = new Hand();
        Hand straightHand2 = new Hand();
        straightHand1.setHand(straight1);
        straightHand2.setHand(straight2);

        straightHand1.displayHand(); straightHand2.displayHand();
        System.out.println(Hand.compareHands(straightHand1, straightHand2));
        assertTrue(Hand.compareHands(straightHand1, straightHand2).contains("White wins with Straight"));
    }

    @Test
    void testStraightHandTie() {
        List<Card> straight1 = Arrays.asList(
                new Card("H", "A"),
                new Card("D", "2"),
                new Card("S", "3"),
                new Card("C", "4"),
                new Card("C", "5")
        );
        List<Card> straight2 = Arrays.asList(
                new Card("D", "A"),
                new Card("D", "2"),
                new Card("S", "3"),
                new Card("C", "4"),
                new Card("H", "5")
        );

        Hand straightHand1 = new Hand();
        Hand straightHand2 = new Hand();
        straightHand1.setHand(straight1);
        straightHand2.setHand(straight2);

        straightHand1.displayHand(); straightHand2.displayHand();
        System.out.println(Hand.compareHands(straightHand1, straightHand2));
        assertTrue(Hand.compareHands(straightHand1, straightHand2).contains("It's a tie !"));
    }

    @Test
    void testFlushHandBlackWins() {
        List<Card> flush1 = Arrays.asList(
                new Card("H", "A"),
                new Card("H", "8"),
                new Card("H", "J"),
                new Card("H", "4"),
                new Card("H", "A")
        );
        List<Card> flush2 = Arrays.asList(
                new Card("C", "2"),
                new Card("C", "5"),
                new Card("C", "3"),
                new Card("C", "K"),
                new Card("C", "A")
        );

        Hand flushHand1 = new Hand();
        Hand flushHand2 = new Hand();
        flushHand1.setHand(flush1);
        flushHand2.setHand(flush2);

        flushHand2.displayHand(); flushHand1.displayHand();
        System.out.println(Hand.compareHands(flushHand2, flushHand1));
        assertTrue(Hand.compareHands(flushHand2, flushHand1).contains("Black wins with Flush"));
    }

    @Test
    void testFlushHandTie() {
        List<Card> flush1 = Arrays.asList(
                new Card("H", "2"),
                new Card("H", "5"),
                new Card("H", "3"),
                new Card("H", "K"),
                new Card("H", "A")
        );
        List<Card> flush2 = Arrays.asList(
                new Card("C", "2"),
                new Card("C", "5"),
                new Card("C", "3"),
                new Card("C", "K"),
                new Card("C", "A")
        );

        Hand flushHand1 = new Hand();
        Hand flushHand2 = new Hand();
        flushHand1.setHand(flush1);
        flushHand2.setHand(flush2);

        flushHand1.displayHand(); flushHand2.displayHand();
        System.out.println(Hand.compareHands(flushHand1, flushHand2));
        assertTrue(Hand.compareHands(flushHand1, flushHand2).contains("It's a tie !"));
    }

    @Test
    void testFullHouseHandBlackWins() {
        List<Card> fullHouse1 = Arrays.asList(
                new Card("H", "10"),
                new Card("H", "J"),
                new Card("H", "J"),
                new Card("H", "10"),
                new Card("H", "10")
        );
        List<Card> fullHouse2 = Arrays.asList(
                new Card("C", "J"),
                new Card("C", "5"),
                new Card("C", "5"),
                new Card("C", "J"),
                new Card("C", "5")
        );

        Hand fullHouseHand1 = new Hand();
        Hand fullHouseHand2 = new Hand();
        fullHouseHand1.setHand(fullHouse1);
        fullHouseHand2.setHand(fullHouse2);

        fullHouseHand1.displayHand(); fullHouseHand2.displayHand();
        System.out.println(Hand.compareHands(fullHouseHand1, fullHouseHand2));
        assertTrue(Hand.compareHands(fullHouseHand1, fullHouseHand2).contains("Black wins with Full House"));
    }

    @Test
    void testFullHouseHandTie() {
        List<Card> fullHouse1 = Arrays.asList(
                new Card("C", "J"),
                new Card("C", "5"),
                new Card("C", "5"),
                new Card("C", "J"),
                new Card("C", "5")
        );
        List<Card> fullHouse2 = Arrays.asList(
                new Card("D", "J"),
                new Card("D", "5"),
                new Card("D", "5"),
                new Card("D", "J"),
                new Card("D", "5")
        );

        Hand fullHouseHand1 = new Hand();
        Hand fullHouseHand2 = new Hand();
        fullHouseHand1.setHand(fullHouse1);
        fullHouseHand2.setHand(fullHouse2);

        fullHouseHand1.displayHand(); fullHouseHand2.displayHand();
        System.out.println(Hand.compareHands(fullHouseHand1, fullHouseHand2));
        assertTrue(Hand.compareHands(fullHouseHand1, fullHouseHand2).contains("It's a tie !"));
    }

    @Test
    void testFourOfAKindHandWhiteWins() {
        List<Card> fourOfAKind1 = Arrays.asList(
                new Card("H", "9"),
                new Card("D", "9"),
                new Card("S", "9"),
                new Card("C", "K"),
                new Card("H", "9")
        );
        List<Card> fourOfAKind2 = Arrays.asList(
                new Card("H", "A"),
                new Card("D", "Q"),
                new Card("S", "Q"),
                new Card("C", "Q"),
                new Card("H", "Q")
        );

        Hand fourOfAKindHand1 = new Hand();
        Hand fourOfAKindHand2 = new Hand();
        fourOfAKindHand1.setHand(fourOfAKind1);
        fourOfAKindHand2.setHand(fourOfAKind2);

        fourOfAKindHand1.displayHand(); fourOfAKindHand2.displayHand();
        System.out.println(Hand.compareHands(fourOfAKindHand1, fourOfAKindHand2));
        assertTrue(Hand.compareHands(fourOfAKindHand1, fourOfAKindHand2).contains("White wins with Four of a Kind"));
    }

    @Test
    void testFourOfAKindHandTie() {
        List<Card> fourOfAKind1 = Arrays.asList(
                new Card("H", "Q"),
                new Card("D", "Q"),
                new Card("S", "Q"),
                new Card("C", "K"),
                new Card("H", "Q")
        );
        List<Card> fourOfAKind2 = Arrays.asList(
                new Card("H", "K"),
                new Card("D", "Q"),
                new Card("S", "Q"),
                new Card("C", "Q"),
                new Card("H", "Q")
        );

        Hand fourOfAKindHand1 = new Hand();
        Hand fourOfAKindHand2 = new Hand();
        fourOfAKindHand1.setHand(fourOfAKind1);
        fourOfAKindHand2.setHand(fourOfAKind2);

        fourOfAKindHand1.displayHand(); fourOfAKindHand2.displayHand();
        System.out.println(Hand.compareHands(fourOfAKindHand1, fourOfAKindHand2));
        assertTrue(Hand.compareHands(fourOfAKindHand1, fourOfAKindHand2).contains("It's a tie !"));
    }

    @Test
    void testStraightFlushHandBlackWins() {
        List<Card> straightFlush1 = Arrays.asList(
                new Card("H", "9"),
                new Card("H", "J"),
                new Card("H", "Q"),
                new Card("H", "K"),
                new Card("H", "10")
        );
        List<Card> straightFlush2 = Arrays.asList(
                new Card("C", "9"),
                new Card("C", "J"),
                new Card("C", "Q"),
                new Card("C", "10"),
                new Card("C", "8")
        );

        Hand straightFlushHand1 = new Hand();
        Hand straightFlushHand2 = new Hand();
        straightFlushHand1.setHand(straightFlush1);
        straightFlushHand2.setHand(straightFlush2);

        straightFlushHand1.displayHand(); straightFlushHand2.displayHand();
        System.out.println(Hand.compareHands(straightFlushHand1, straightFlushHand2));
        assertTrue(Hand.compareHands(straightFlushHand1, straightFlushHand2).contains("Black wins with Straight Flush"));
    }

    @Test
    void testStraightFlushHandTie() {
        List<Card> straightFlush1 = Arrays.asList(
                new Card("H", "9"),
                new Card("H", "J"),
                new Card("H", "Q"),
                new Card("H", "K"),
                new Card("H", "10")
        );
        List<Card> straightFlush2 = Arrays.asList(
                new Card("C", "9"),
                new Card("C", "J"),
                new Card("C", "K"),
                new Card("C", "10"),
                new Card("C", "Q")
        );

        Hand straightFlushHand1 = new Hand();
        Hand straightFlushHand2 = new Hand();
        straightFlushHand1.setHand(straightFlush1);
        straightFlushHand2.setHand(straightFlush2);

        straightFlushHand1.displayHand(); straightFlushHand2.displayHand();
        System.out.println(Hand.compareHands(straightFlushHand1, straightFlushHand2));
        assertTrue(Hand.compareHands(straightFlushHand1, straightFlushHand2).contains("It's a tie !"));
    }

}

