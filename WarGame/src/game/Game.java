package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

	private String version;
	List<Card> fullDeck;
	public Game(String version) {
		
		this.version = version;
		
	}
	
	public void constructDeck() {
		
		Deck deck = new Deck();
		int i,j;
		
		//create 52 cards, each value having four suits,  and put them into a deck 
		String suit[] = {"spades", "diamonds", "hearts", "clubs"};
		for(i=1; i<=13 ; i++) {
			for(j=0; j<4 ; j++) {
				Card card = new Card();
				card.setSuit(suit[j]);
				card.setValue(i);
				//System.out.println(card.getSuit()+ " AND "+card.getValue());
				deck.addCard(card);
			}
			
		}
		
		fullDeck = deck.getList();
//		System.out.println("Deck has "+fullDeck.size()+" cards");
		
		splitDeck();
		
	}
	
	public void splitDeck(){
		
		Collections.shuffle(fullDeck);
		int cardsPerDeck = fullDeck.size()/2;
		List<Card>p1 = new ArrayList<>();
		List<Card>p2 = new ArrayList<>();
		for(int i = 0; i<fullDeck.size(); i++) {
			if(i<cardsPerDeck) {
				p1.add(fullDeck.get(i));
				
			}
			else {
				p2.add(fullDeck.get(i));
				
			}
			
		}
//		System.out.println("Player1 has this many cards: "+p1.size());
//		System.out.println("Player2 has this many cards: "+p2.size());
		
		playGame(p1,p2);
	}
	
	public void playGame(List<Card> one, List<Card> two) {
		
		int cardsLost;
		List<Card> warPile = new ArrayList<>();
		while(true) {
			
			if(one.size() == 0 || two.size()==0) {
				System.out.println("Player1 has this many cards: "+one.size());
				System.out.println("Player2 has this many cards: "+two.size());
				break;
			}
			//if p1 card is bigger
			if(one.get(0).getValue() > two.get(0).getValue()) {
				System.out.println("Player1 has played: "+one.get(0).getValue());
				System.out.println("Player2 has played: "+two.get(0).getValue());
					one.add(two.get(0));
					two.remove(0);
					one.add(one.get(0));
					one.remove(0);
				System.out.println("WINNER PLAYER ONE");
				
			}
			//if p1 card is smaller
			else if(one.get(0).getValue() < two.get(0).getValue()) {
				System.out.println("Player1 has played: "+one.get(0).getValue());
				System.out.println("Player2 has played: "+two.get(0).getValue());
					two.add(one.get(0));
					one.remove(0);
					two.add(one.get(0));
					two.remove(0);
					System.out.println("WINNER PLAYER TWO");
				
			}
			//if p1 card is bigger
			else if(one.get(0).getValue() == two.get(0).getValue()) {
					int i=0;
					//WE HAVE A WAR
					System.out.println("WARRRR");
					//remove war cards
					warPile.add(one.get(0));
					one.remove(0);
					warPile.add(two.get(0));
					two.remove(0);
					
						//System.out.println("entered war while");
						i++;
						//add one card to war pile from each player deck 
						
						warPile.add(one.get(i));
						one.remove(i);
						warPile.add(two.get(i));
						two.remove(i);
						
						
						
						
						//check who wins next card comparison 
						//if p1 card is bigger
						if(one.get(0).getValue() > two.get(0).getValue()) {
							System.out.println("Before p2 wins war");
							System.out.println("Player1 has played: "+one.get(0).getValue());
							System.out.println("Player2 has played: "+two.get(0).getValue());
							System.out.println("After p1 wins war");
								one.add(two.get(0));
								two.remove(0);
								//int j =0;
								while(warPile.size() != 0) {
									
									one.add(warPile.get(0));
									warPile.remove(0);
									
								}
								System.out.println("WINNER PLAYER ONE");
							
						}
						//if p1 card is smaller
						else if(one.get(0).getValue() < two.get(0).getValue()) {
							System.out.println("before p2 wins war");
							System.out.println("Player1 has played: "+one.get(0).getValue());
							System.out.println("Player2 has played: "+two.get(0).getValue());
							System.out.println("After p2 wins war");
								two.add(one.get(0));
								one.remove(0);
								//int j = 0;
								while(warPile.size() != 0) {
									two.add(warPile.get(0));
									warPile.remove(0);
									
								}
								System.out.println("WINNER PLAYER ONE");
							
						}
						
					
				
			}
			
			
		}
		
	}
	
	
	
	
}
