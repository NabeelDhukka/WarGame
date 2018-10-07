package game;

import java.util.ArrayList;
import java.util.List;

public class Deck {


	private List<Card> list = new ArrayList<>();
	
	public Deck() {
		
	}
	
//	public Deck(Card card) {
//		this.card = card;
//	}
	
	public void addCard(Card card) {

			list.add(card);
	}

	public List<Card> getList() {
		return list;
	}

	public void setList(List<Card> list) {
		this.list = list;
	}
	
	
	
	
}
