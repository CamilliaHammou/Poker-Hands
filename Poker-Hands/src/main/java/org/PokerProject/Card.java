package org.PokerProject;

public class Card {
    private String color;
    private String value;

    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public boolean equalsCards(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Card otherCard = (Card) obj;

        boolean isValueEqual = this.value.equals(otherCard.value);
        boolean isColorEqual = this.color.equals(otherCard.color);

        return isValueEqual && isColorEqual;
    }

}
