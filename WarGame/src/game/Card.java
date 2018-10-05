package game;

public class Card {
	private String suit;
	private int value; 
	
	public Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
		
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
//	String suit[] = {spades, diamonds, hearts, clubs};
//	for(i=1; i<=13 ; i++) {
//		for(j=0; j<4 ; j++) {
//			card.setsuit(suit[j]);
//			card.value(i);
//		}
//		deck.add(Card);
//	}
	
	
}
