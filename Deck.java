import java.util.ArrayList;
import java.util.Collections;
//Jessica add a line here for github practice

public class Deck {
	ArrayList<Card> deckList = new ArrayList<Card>();
	//construct 13 x 4 =52 cards 
	public Deck(ArrayList<Card> myList) {
		this.deckList = myList;
		String st = null;
		
		for(int j = 0; j<4; j++) {
			if(j==0) {
				st = "D";
				constructOneSuite(st);
			} 
			
			if(j==1) {
				st = "C";
				constructOneSuite(st);
			} 
			
			if(j==0) {
				st = "H";
				constructOneSuite(st);
			} 
			
			if(j==0) {
				st = "S";
				constructOneSuite(st);
			} 

		}

	}
	
	//construct 13 cards for one single suite
	private ArrayList<Card> constructOneSuite(String suite){

		for(int i = 1; i<=13; i++) {
			if(i == 1) {
				Card myCard= new Card("A"+ suite, 1); 
				deckList.add(myCard);
			}
			else if(i == 11) {
				Card myCard= new Card("J"+suite, 10); 
				deckList.add(myCard);
			}
			else if(i == 12) {
				Card myCard= new Card("Q"+suite, 10); 
				deckList.add(myCard);
			}
			else if(i == 13) {
				Card myCard= new Card("K"+suite, 10); 
				deckList.add(myCard);
			}
			else {
				Card myCard= new Card(i+suite, i); 
				deckList.add(myCard);
			}
		}
		return deckList;
		
		
	}
	
	public void printCardinDeck() {
		 System.out.println("Cards in the Deck now:  -----> ");
			for(int i =0; i<deckList.size(); i++) {
				 System.out.print(deckList.get(i).getName() + ",  ");
			 }
			System.out.println();

		
	}
	
	public void shuffleCard(ArrayList<Card> deckList){
	//print the original list
		 //printCardinDeck();
		
		 Collections.shuffle(deckList);
		
	//print the list after shuffle
		 //printCardinDeck();

		
	}
	

	
	public Card getNextCard(ArrayList<Card> list) {
		list = deckList;
		Card nextCard = list.get(0);
		list.remove(0);
		System.out.println("You next card is ---> " + nextCard.getName());
		return nextCard;
		
		
	}
	
	//test------
	/*public static void main(String[] args) {
		ArrayList<Card> list = new ArrayList<Card>();
		Deck dk = new Deck(list);
		dk.printCardinDeck();
		dk.shuffleCard(list);
		System.out.println("number of card: " + list.size());
		System.out.println(dk.getNextCard(list));
		dk.printCardinDeck();
		System.out.println("number of card: " + list.size());
	}*/
}
