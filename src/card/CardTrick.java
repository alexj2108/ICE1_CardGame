/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1.
 * @author srinivas
 * @modifier James Leo Alex (991753795)
 */
public class CardTrick {

    public static void main(String[] args) {
        // Array to hold the magic hand (7 cards)
        Card[] magicHand = new Card[7];
        
        // Fill the magicHand array with random cards
        Random rand = new Random();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // Random value between 1 and 13
            c.setSuit(suits[rand.nextInt(suits.length)]); 
            magicHand[i] = c; // Add card to the magic hand
        }
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card (Enter a number between 1 and 13):");
        int userValue = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Pick a suit (Hearts, Diamonds, Clubs, Spades):");
        String userSuit = scanner.nextLine();
        
        // Check if the user's card is in the magic hand
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userValue && card.getSuit().equalsIgnoreCase(userSuit)) {
                found = true;
                break;
            }
        }
        
        // Report if the card was found or not
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
        
        // Hard-coded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(2); // Example value
        luckyCard.setSuit("Clubs"); // Example suit
        
        // Check if the lucky card is in the magic hand
        boolean luckyFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                luckyFound = true;
                break;
            }
        }
        
        // Report if the lucky card was found or not
        if (luckyFound) {
            System.out.println("The lucky card (2 of Clubs) was found in the magic hand!");
        } else {
            System.out.println("The lucky card (2 of Clubs) was not found in the magic hand.");
        }
    }
}
