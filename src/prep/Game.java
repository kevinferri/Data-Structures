package prep;

import java.util.Arrays;

public class Game {
	public static void main(String[] args) {
		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");
		
		playGame(p1, p2);
		
		System.out.println("Player 1 cards: " + Arrays.toString(p1.cards));
		System.out.println("Player 2 cards: " + Arrays.toString(p2.cards));
		
		System.out.println("Player 1 score: " + p1.score);
		System.out.println("Player 2 score: " + p2.score);
		
		if (winner != null) {
			System.out.println("Winner: " + winner.name);
		} else {
			System.out.println("Tie!");
		}
	}
	
	static int totalTurns = 5;
	static int turn = 0;
	static int[] deck = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	static Player winner;
	
	static void playGame(Player p, Player p2) {
		for (int i = 0; i < 5; i++) {
			int p1RandomIndex = (int)(Math.random() * deck.length);
			int p2RandomIndex = (int)(Math.random() * deck.length);
		
			p.cards[turn] = deck[p1RandomIndex];
			p2.cards[turn] = deck[p2RandomIndex];
		
			turn++;
		}
		
		p.score = getRange(p.cards);
		p2.score = getRange(p2.cards);
		
		if (p.score > p2.score) {
			winner = p;
		} else if (p2.score > p.score)  {
			winner = p2;
		} else {
			winner = null;
		}
	}
	
	static int getMax(int[] cards) {
		int max = cards[0];
		
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] > max) {
				max = cards[i];
			}
		}
		
		return max;
	}
	
	static int getMin(int[] cards) {
		int min = cards[0];
		
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] < min) {
				min = cards[i];
			}
		}
		
		return min;
	}
	
	static int getRange(int[] cards) {
		int max = getMax(cards);
		int min = getMin(cards);
		return max - min;
	}
}

class Player {
	String name;
	int score;
	int[] cards;
	
	Player(String name) {
		this.name = name;
		this.score = 0;
		this.cards = new int[5];
	}
}