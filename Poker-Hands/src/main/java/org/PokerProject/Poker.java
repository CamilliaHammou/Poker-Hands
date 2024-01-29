package org.PokerProject;

import java.util.Scanner;

import static org.PokerProject.Hand.compareHands;

public class Poker {
    public static void printLogo() {
        String reset = "\u001B[0m";
        String black = "\u001B[30m";
        String red = "\u001B[31m";
        String bold = "\u001B[1m";
        String italic = "\u001B[3m";
        String cyan = "\u001B[36m";

        System.out.println(red + bold + "            _____      _               _    _                 _" + reset);
        System.out.println(red + bold + " _____     |  __ \\    | |             | |  | |               | |         _____" + reset);
        System.out.println(red + bold + "|A    |    | |__) |__ | | _____ _ __  | |__| | __ _ _ __   __| |___     |A    |" + reset);
        System.out.println(red + bold + "|  ♠  |    |  ___/ _ \\| |/ / _ \\ '__| |  __  |/ _` | '_ \\ / _` / __|    |  ♦  |" + reset);
        System.out.println(red + bold + "|____V|    | |  | (_) |   <  __/ |    | |  | | (_| | | | | (_| \\__ \\    |____V|" + reset);
        System.out.println(black + bold + "           |_|   \\___/|_|\\_\\___|_|    |_|  |_|\\__,_|_| |_|\\__,_|___/" + reset);
        System.out.println(black + italic + "        Made by Camillia Hammou, Denisa Dudas, Wissem Derghal (Group AL1)\n\n" + reset);
    }

    public static void Rules() {
        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String purple = "\u001B[35m";
        System.out.println(red + "Welcome to Poker Hands rules !\n" + reset);
        System.out.println("Cards are represented by a combination of rank and suit..");
        System.out.println("Poker hands are ranked by the following partial order from lowest to highest.\n");
        System.out.println(purple + "High Card"+ reset +": Hands which do not fit any higher category are ranked by the value of their highest card.");
        System.out.println(purple + "Pair"+ reset +": 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. ");
        System.out.println(purple + "Two Pairs"+ reset +": The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. ");
        System.out.println(purple + "Three of a Kind"+ reset +": Three of the cards in the hand have the same value.");
        System.out.println(purple + "Straight"+ reset +": Hand contains 5 cards with consecutive values.");
        System.out.println(purple + "Flush"+ reset +": Hand contains 5 cards of the same suit. ");
        System.out.println(purple + "Full House"+ reset +": 3 cards of the same value, with the remaining 2 cards forming a pair. ");
        System.out.println(purple + "Four of a kind"+ reset +": 4 cards with the same value. ");
        System.out.println(purple + "Straight flush"+ reset +": 5 cards of the same suit with consecutive values.");
    }

    public static void PokerHandsGame() {

        String choix, quit;
        Scanner sc = new Scanner(System.in);

        do {
            Hand black = new Hand();
            black.fillHand();
            System.out.print("Black : ");
            black.displayHand();
            System.out.println(" - " + black.getHandValue(black.getCards()));

            Hand white = new Hand();
            white.fillHand();
            System.out.print("\nWhite : ");
            white.displayHand();
            System.out.println(" - " + white.getHandValue(white.getCards()));

            PokerHand blackHandValue = black.getHandValue(black.getCards());
            PokerHand whiteHandValue = white.getHandValue(white.getCards());

            String result;

            if (blackHandValue.compareTo(whiteHandValue) > 0) {
                result = "Black wins with " + blackHandValue;
            } else if (blackHandValue.compareTo(whiteHandValue) < 0) {
                result = "White wins with " + whiteHandValue;
            } else {
                result = compareHands(black, white);
            }

            System.out.println("\n - " + result + "\n");

            System.out.print("Would you like to start again [y] ? N : ");
            quit = sc.nextLine();
        } while ("y".equals(quit));
    }

    public static void Menu() {

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String black = "\u001B[30m";
        String bold = "\u001B[1m";
        String cardEmoji = "\uD83C\uDCA1";

        printLogo();
        String choix, quit;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(red + bold + "╔══════════════════════════╗" + reset);
            System.out.println(red + bold + "║     " + cardEmoji + "   PokerHand Menu   ║" + reset);
            System.out.println(red + bold + "╟──────────────────────────╢" + reset);
            System.out.println(black + bold + "║   " + cardEmoji + " 1 - Play" + cardEmoji + "            ║" + reset);
            System.out.println(black + bold + "║   " + cardEmoji + " 2 - Rules" + cardEmoji + "           ║" + reset);
            System.out.println(black + bold + "║   " + cardEmoji + " 0 - Quit" + cardEmoji + "            ║" + reset);
            System.out.println(black + bold + "╚══════════════════════════" + cardEmoji + reset);
            System.out.print(black + "Enter your choice: " + reset);
            choix = sc.nextLine();
            switch (choix) {
                case "1":
                    PokerHandsGame();
                    System.out.println();
                    break;
                case "2":
                    Rules();
                    System.out.println();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Error : invalid choice !");
                    break;
            }
            System.out.print("QUIT game [y] ? N : ");
            quit = sc.nextLine();
        } while ("N".equals(quit));
        System.out.println("Good bye !");
        sc.close();
    }
}
