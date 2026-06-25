package com.oops.java;



import java.util.Random;

// A standalone Card representation with structural ranking values for sorting
class Card {
    String suit;
    String rank;
    int rankValue; // numeric value assigned to help sort correctly (2=2 ... Ace=14)

    public Card(String rank, String suit, int rankValue) {
        this.rank = rank;
        this.suit = suit;
        this.rankValue = rankValue;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

// Custom Singly Linked List Node representing individual elements inside the Queue
class Node {
    Object data; // Can hold a Card object or a Player object
    Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

// Custom Queue implemented using Linked List structures without using collections API libraries
class CustomQueue {
    private Node front;
    private Node rear;
    private int size;

    public CustomQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(Object data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public Object dequeue() {
        if (front == null) return null;
        Object data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public int getSize() {
        return size;
    }

    // Helper to extract structural data sequentially for print routines
    public Object get(int index) {
        if (index < 0 || index >= size) return null;
        Node current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
}

// Player Object holding their hand layout structured inside a Custom Queue workflow
class Player {
    String name;
    CustomQueue handQueue;

    public Player(String name) {
        this.name = name;
        this.handQueue = new CustomQueue();
    }

    public void receiveCard(Card card) {
        handQueue.enqueue(card);
    }

    // Sorts the player's cards by rank using an implementation of Bubble Sort tailored for our Custom Queue
    public void sortByRank() {
        int n = handQueue.getSize();
        // Convert to array temporarily to simplify sort mechanics without relying on external collections APIs
        Card[] cardArray = new Card[n];
        for (int i = 0; i < n; i++) {
            cardArray[i] = (Card) handQueue.dequeue();
        }

        // Perform Bubble Sort based on structural Rank Value metric
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (cardArray[j].rankValue > cardArray[j + 1].rankValue) {
                    Card temp = cardArray[j];
                    cardArray[j] = cardArray[j + 1];
                    cardArray[j + 1] = temp;
                }
            }
        }

        // Re-enqueue the sorted array elements back into the Custom Queue structure
        for (Card card : cardArray) {
            handQueue.enqueue(card);
        }
    }

    public void printPlayerHand() {
        System.out.println("\n" + name + "'s Sorted Hand (Maintained in Linked List Queue):");
        System.out.print(" -> ");
        for (int i = 0; i < handQueue.getSize(); i++) {
            System.out.print("[" + handQueue.get(i) + "]");
            if (i < handQueue.getSize() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

// Master implementation program running the Extended Queue specifications
public class ExtendedDeckOfCards {
    public static void main(String[] args) {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Populate standard cards deck arrays with proper analytical value weights
        Card[] deck = new Card[52];
        int index = 0;
        for (String suit : suits) {
            for (int r = 0; r < ranks.length; r++) {
                deck[index++] = new Card(ranks[r], suit, r + 2); // Rank weights scale from 2 up to 14
            }
        }

        // Shuffle deck logic
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = random.nextInt(deck.length);
            Card temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }

        // Instantiate players array lists inside a Player custom queue structure
        CustomQueue playerQueue = new CustomQueue();
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        Player p3 = new Player("Player 3");
        Player p4 = new Player("Player 4");

        playerQueue.enqueue(p1);
        playerQueue.enqueue(p2);
        playerQueue.enqueue(p3);
        playerQueue.enqueue(p4);

        // Distribute 9 cards each to all 4 players sequentially via shifting routines
        int deckIndex = 0;
        for (int cardCount = 0; cardCount < 9; cardCount++) {
            for (int pNum = 0; pNum < playerQueue.getSize(); pNum++) {
                Player currentPlayer = (Player) playerQueue.dequeue();
                currentPlayer.receiveCard(deck[deckIndex++]);
                playerQueue.enqueue(currentPlayer); // Put back to back of queue to distribute evenly
            }
        }

        System.out.println("===== EXTENDED DECK REPORT (Custom Queues & Sort) =====");

        // Sort each individual player's hand by rank metric and print the final sequence
        for (int i = 0; i < playerQueue.getSize(); i++) {
            Player activePlayer = (Player) playerQueue.get(i);
            activePlayer.sortByRank();
            activePlayer.printPlayerHand();
        }
    }
}
