package org.PokerProject;

import java.util.*;
import org.PokerProject.PokerHand;

public class Hand {
    private List<Card> hand = new ArrayList<>();
    private String[] values_possible;

    public void fillHand() {
        for (int i = 0; i < 5; ) {
            Card newCard = generateCard();
            if (!isInList(newCard, hand)) {
                hand.add(newCard);
                i++;
            }
        }
    }

    public List<Card> getCards() {
        return new ArrayList<>(hand);
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    private boolean isInList(Card card, List<Card> listCards) {
        for (Card existingCard : listCards) {
            if (existingCard != null && existingCard.equalsCards(card)) {
                return true;
            }
        }
        return false;
    }

    private Card generateCard() {
        String[] valueCard = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};
        String[] colorCard = {"H", "D", "S", "C"};

        Random random = new Random();
        int randIndex = random.nextInt(valueCard.length);
        String randValue = valueCard[randIndex];

        randIndex = random.nextInt(colorCard.length);
        String randColor = colorCard[randIndex];

        Card randCard = new Card(randColor, randValue);

        return randCard;
    }


    public void displayHand() {
        for (Card card : hand) {
            System.out.printf(card.getValue() + card.getColor() + " ");
        }
        System.out.println("");
    }

    public static boolean hasHighCard(List<Card> cards) {
        return !hasPair(cards) && !hasTwoPairs(cards) && !hasThreeOfAKind(cards) &&
                !hasStraight(cards) && !hasFlush(cards) && !hasFullHouse(cards) &&
                !hasFourOfAKind(cards) && !hasStraightFlush(cards);
    }

    public static boolean hasPair(List<Card> cards) {
        Map<String, Integer> valueCount = new HashMap<>();

        for (Card card : cards) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }

        for (int count : valueCount.values()) {
            if (count == 2) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasTwoPairs(List<Card> cards) {
        Map<String, Integer> valueCount = new HashMap<>();

        for (Card card : cards) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }

        int pair = 0;
        for (int pairCount : valueCount.values()) {
            if (pairCount == 2) {
                pair++;
            }
        }

        return pair == 2;
    }

    public static boolean hasThreeOfAKind(List<Card> cards) {
        Map<String, Integer> valueCount = new HashMap<>();
        for (Card card : cards) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }

        for (int count : valueCount.values()) {
            if (count == 3) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasStraight(List<Card> cards) {
        Set<String> uniqCardValues = new HashSet<>();
        for (Card card : cards) {
            uniqCardValues.add(card.getValue());
        }

        // Check for straight using values as integers
        List<Integer> valuesAsIntegers = new ArrayList<>();
        for (String value : uniqCardValues) {
            valuesAsIntegers.add(getValueAsInteger(value));
        }

        Collections.sort(valuesAsIntegers);

        for (int i = 0; i < valuesAsIntegers.size() - 1; i++) {
            if (valuesAsIntegers.get(i + 1) - valuesAsIntegers.get(i) != 1) {
                return false;
            }
        }

        return true;
    }
    public static boolean hasFlush(List<Card> cards) {
        Set<String> uniqueColors = new HashSet<>();
        for (Card card : cards) {
            uniqueColors.add(card.getColor());
        }

        return uniqueColors.size() == 1;
    }

    public static boolean hasFullHouse(List<Card> cards) {

        int[] countsValues = new int[14];

        boolean havePair = false;
        boolean haveThree = false;

        for (Card card : cards) {
            countsValues[getValueAsInteger(card.getValue())]++;
        }

        for (int count : countsValues) {
            if (count == 2) {
                havePair = true;
            } else if (count == 3) {
                haveThree = true;
            }
        }
        return havePair && haveThree;
    }

    public static boolean hasStraightFlush(List<Card> cards) {

        List<Integer> values = new ArrayList<>();

        if (!hasFlush(cards)) {
            return false;
        }

        for (Card card : cards) {
            values.add(getValueAsInteger(card.getValue()));
        }

        Collections.sort(values);

        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) != values.get(i - 1) + 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasFourOfAKind(List<Card> cards) {

        int[] valueCounts = new int[14];

        for (Card card : cards) {
            valueCounts[getValueAsInteger(card.getValue())]++;
        }
        for (int count : valueCounts) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    private static int getValueAsInteger(String value) {

        if (value.equals("A")) {
            return 1;
        }
        else if (value.equals("J")) {
            return 11;
        }
        else if (value.equals("Q")) {
            return 12;
        }
        else if (value.equals("K")) {
            return 13;
        }
        else if (Integer.parseInt(value) >= 2 && Integer.parseInt(value) <= 10){
            return Integer.parseInt(value);
        }
        else {
            throw new IllegalArgumentException("La valeur de carte : " + value + " n'existe pas !");
        }
    }

    /**
     * Méthode qui renvoie le type de règle d'une main
     * @param cards
     * @return
     */
    public PokerHand getHandValue(List<Card> cards) {

        if (hasStraightFlush(cards)) {
            return PokerHand.STRAIGHT_FLUSH;
        } else if (hasFourOfAKind(cards)) {
            return PokerHand.FOUR_OF_A_KIND;
        } else if (hasFullHouse(cards)) {
            return PokerHand.FULL_HOUSE;
        } else if (hasFlush(cards)) {
            return PokerHand.FLUSH;
        } else if (hasStraight(cards)) {
            return PokerHand.STRAIGHT;
        } else if (hasThreeOfAKind(cards)) {
            return PokerHand.THREE_OF_A_KIND;
        } else if (hasTwoPairs(cards)) {
            return PokerHand.TWO_PAIRS;
        } else if (hasPair(cards)) {
            return PokerHand.PAIR;
        } else {
            return PokerHand.HIGH_CARD;
        }
    }

    /**
     * Comparaison des deux mains en fonction des règles qu'ils ont
     * @param black
     * @param white
     * @return
     */
    public static String compareHands(Hand black, Hand white) {
        // valeurs des mains
        PokerHand blackHandValue = black.getHandValue(black.getCards());
        PokerHand whiteHandValue = white.getHandValue(white.getCards());

        if (blackHandValue.compareTo(whiteHandValue) > 0) {
            return "Black wins";
        } else if (blackHandValue.compareTo(whiteHandValue) < 0) {
            return "White wins";
        } else {
            // comparaison des cartes individuellement si meme pattern
            List<Card> blackCards = black.getCards();
            List<Card> whiteCards = white.getCards();

            if (blackHandValue == PokerHand.HIGH_CARD) {
                int res = compareHighCard(blackCards, whiteCards);
                if (res == 1) {
                    return "Black wins with High Card";
                } else if (res == 2) {
                    return "White wins with High Card";
                } else {
                    return "It's a tie !";
                }
            } else if (blackHandValue == PokerHand.PAIR) {
                return comparePair(blackCards, whiteCards);
            } else if (blackHandValue == PokerHand.TWO_PAIRS) {
                return compareTwoPairs(blackCards, whiteCards);
            } else if (blackHandValue == PokerHand.THREE_OF_A_KIND) {
                return compareThreeOfAKind(blackCards, whiteCards);
            } else if (blackHandValue == PokerHand.STRAIGHT) {
                return compareStraight(blackCards, whiteCards);
            } else if (blackHandValue == PokerHand.FLUSH) {
                return compareFlush(blackCards, whiteCards);
            } else if (blackHandValue == PokerHand.FULL_HOUSE) {
                return compareFullHouse(blackCards, whiteCards);
            } else if (blackHandValue == PokerHand.FOUR_OF_A_KIND) {
                return compareFourOfAKind(blackCards, whiteCards);
            } else if (blackHandValue == PokerHand.STRAIGHT_FLUSH) {
                return compareStraightFlush(blackCards, whiteCards);
            }

            return "It's a tie !";
        }
    }

    /**
     * Comparer les mains en se basant sur la carte la plus élevée (en excluanr certains valeurs si nécessaire)
     * @param blackCards
     * @param whiteCards
     * @param excludedValues
     * @return
     */
    private static int compareHighCardExcept(List<Card> blackCards, List<Card> whiteCards, int... excludedValues) {
        // tri des cartes par ordre croissant
        List<Card> sortedBlack = sortAscCards(blackCards);
        List<Card> sortedWhite = sortAscCards(whiteCards);

        // parcours des cartes
        for (int i = sortedBlack.size() - 1; i >= 0; i--) {
            Card card1 = sortedBlack.get(i);
            Card card2 = sortedWhite.get(i);

            int value1 = getValueAsInteger(card1.getValue());
            int value2 = getValueAsInteger(card2.getValue());

            if (value1 != value2 && !Arrays.stream(excludedValues).anyMatch(value -> value == value1)) {
                int comparisonResult = compareCards(card1, card2);

                if (comparisonResult > 0) {
                    return 1; // Black gagne
                } else if (comparisonResult < 0) {
                    return 2; // White gagne
                }
            }
        }

        return 0; // Egalité
    }

    private static int compareHighCard(List<Card> blackCards, List<Card> whiteCards) {
        return compareHighCardExcept(blackCards, whiteCards);
    }

    private static String comparePair(List<Card> blackCards, List<Card> whiteCards) {
        int blackPairValue = findPairValue(blackCards);
        int whitePairValue = findPairValue(whiteCards);

        if (blackPairValue != whitePairValue) {
            return blackPairValue > whitePairValue ? "Black wins with Pair" : "White wins with Pair";
        }

        int res = compareHighCardExcept(blackCards, whiteCards, blackPairValue);
        if (res == 1) {
            return "Black wins with Pair (high card outside the pair)";
        } else if (res == 2) {
            return "White wins with Pair (high card outside the pair)";
        } else {
            return "It's a tie !";
        }
    }

    private static String compareTwoPairs(List<Card> blackCards, List<Card> whiteCards) {
        int[] blackPairValues = findTwoPairValues(blackCards);
        int[] whitePairValues = findTwoPairValues(whiteCards);

        if (blackPairValues[0] != whitePairValues[0]) {
            return blackPairValues[0] > whitePairValues[0] ? "Black wins with Two Pairs" : "White wins with Two Pairs";
        } else if (blackPairValues[1] != whitePairValues[1]) {
            return blackPairValues[1] > whitePairValues[1] ? "Black wins with Two Pairs" : "White wins with Two Pairs";
        }

        int res = compareHighCardExcept(blackCards, whiteCards, blackPairValues[0], blackPairValues[1]);
        if (res == 1) {
            return "Black wins with Two Pairs (high card outside the pairs)";
        } else if (res == 2) {
            return "White wins with Two Pairs (high card outside the pairs)";
        } else {
            return "It's a tie !";
        }
    }

    private static String compareThreeOfAKind(List<Card> blackCards, List<Card> whiteCards) {
        int blackThreeValue = findThreeOfAKindValue(blackCards);
        int whiteThreeValue = findThreeOfAKindValue(whiteCards);

        if (blackThreeValue != whiteThreeValue) {
            return blackThreeValue > whiteThreeValue ? "Black wins with Three of a Kind" : "White wins with Three of a Kind";
        }

        int res = compareHighCardExcept(blackCards, whiteCards, blackThreeValue);
        if (res == 1) {
            return "Black wins with Three of a Kind (high card outside the three)";
        } else if (res == 2) {
            return "White wins with Three of a Kind (high card outside the three)";
        } else {
            return "It's a tie !";
        }
    }

    private static String compareStraight(List<Card> blackCards, List<Card> whiteCards) {
        int blackMaxValue = findMaxCardValue(blackCards);
        int whiteMaxValue = findMaxCardValue(whiteCards);

        if (blackMaxValue != whiteMaxValue) {
            return blackMaxValue > whiteMaxValue ? "Black wins with Straight" : "White wins with Straight";
        }

        return "It's a tie !";
    }

    private static String compareFlush(List<Card> blackCards, List<Card> whiteCards) {
        int blackMaxValue = findMaxCardValue(blackCards);
        int whiteMaxValue = findMaxCardValue(whiteCards);

        if (blackMaxValue != whiteMaxValue) {
            return blackMaxValue > whiteMaxValue ? "Black wins with Flush" : "White wins with Flush";
        }

        return "It's a tie !";
    }

    private static String compareFullHouse(List<Card> blackCards, List<Card> whiteCards) {
        int blackThreeValue = findThreeOfAKindValue(blackCards);
        int whiteThreeValue = findThreeOfAKindValue(whiteCards);

        if (blackThreeValue != whiteThreeValue) {
            return blackThreeValue > whiteThreeValue ? "Black wins with Full House" : "White wins with Full House";
        }

        int blackPairValue = findPairValue(blackCards);
        int whitePairValue = findPairValue(whiteCards);

        if (blackPairValue != whitePairValue) {
            return blackPairValue > whitePairValue ? "Black wins with Full House" : "White wins with Full House";
        }

        return "It's a tie !";
    }

    private static String compareFourOfAKind(List<Card> blackCards, List<Card> whiteCards) {
        int blackFourValue = findFourOfAKindValue(blackCards);
        int whiteFourValue = findFourOfAKindValue(whiteCards);

        if (blackFourValue != whiteFourValue) {
            return blackFourValue > whiteFourValue ? "Black wins with Four of a Kind" : "White wins with Four of a Kind";
        }

        int res = compareHighCardExcept(blackCards, whiteCards, blackFourValue);
        if (res == 1) {
            return "Black wins with Four of a Kind (high card outside the four)";
        } else if (res == 2) {
            return "White wins with Four of a Kind (high card outside the four)";
        } else {
            return "It's a tie !";
        }
    }

    private static String compareStraightFlush(List<Card> blackCards, List<Card> whiteCards) {
        int blackMaxValue = findMaxCardValue(blackCards);
        int whiteMaxValue = findMaxCardValue(whiteCards);

        if (blackMaxValue != whiteMaxValue) {
            return blackMaxValue > whiteMaxValue ? "Black wins with Straight Flush" : "White wins with Straight Flush";
        }

        return "It's a tie !";
    }

    private static int findPairValue(List<Card> cards) {
        Map<String, Integer> valueCount = new HashMap<>();

        for (Card card : cards) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : valueCount.entrySet()) {
            if (entry.getValue() == 2) {
                return getValueAsInteger(entry.getKey());
            }
        }

        return 0; // Aucune paire trouvée
    }

    private static int[] findTwoPairValues(List<Card> cards) {
        int[] pairValues = new int[2];
        int pairCount = 0;

        Map<String, Integer> valueCount = new HashMap<>();

        for (Card card : cards) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : valueCount.entrySet()) {
            if (entry.getValue() == 2) {
                pairValues[pairCount] = getValueAsInteger(entry.getKey());
                pairCount++;
            }
        }

        Arrays.sort(pairValues);

        return pairValues;
    }

    private static int findThreeOfAKindValue(List<Card> cards) {
        Map<String, Integer> valueCount = new HashMap<>();

        for (Card card : cards) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : valueCount.entrySet()) {
            if (entry.getValue() == 3) {
                return getValueAsInteger(entry.getKey());
            }
        }

        return 0;
    }

    private static int findMaxCardValue(List<Card> cards) {
        int maxValue = 0;

        for (Card card : cards) {
            int cardValue = getValueAsInteger(card.getValue());
            if (cardValue > maxValue) {
                maxValue = cardValue;
            }
        }

        return maxValue;
    }

    private static int findFourOfAKindValue(List<Card> cards) {
        Map<String, Integer> valueCount = new HashMap<>();

        for (Card card : cards) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : valueCount.entrySet()) {
            if (entry.getValue() == 4) {
                return getValueAsInteger(entry.getKey());
            }
        }

        return 0; // Aucun carré trouvé
    }

    private static List<Card> sortAscCards(List<Card> cards) {
        List<Card> sortedCards = new ArrayList<>(cards);
        sortedCards.sort(Comparator.comparingInt(card -> getValueAsInteger(card.getValue())));
        return sortedCards;
    }

    private static int compareCards(Card card1, Card card2) {
        int value1 = getValueAsInteger(card1.getValue());
        int value2 = getValueAsInteger(card2.getValue());

        return Integer.compare(value1, value2);
    }

}
