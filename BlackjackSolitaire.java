import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackSolitaire {
	Board bd = new Board();
	//create the deck list to save card object
	ArrayList<Card> list = new ArrayList<Card>();
	// construct the decklist for card
	Deck dk = new Deck(list);
    
	//do i need a constructor?
	
	
	public void play() {
	//	(a) Display initial state of the game.
		bd.printBoard();
		int round = 0;
		Scanner userIn = new Scanner(System.in);
		while(true) {
		
	//		(b) Shuffle deck.
	//		(c) Deal a card.	
			
			
			dk.shuffleCard(list);
			Card nextCd = dk.getNextCard(list);
	
	//		(d) Allow user to make a move. How does the user make a move? We prompt the user to
	//		supply a position where they want to put the card and then we take that information
	//		and move the dealt card to the appropriate position. When we allow the user to make a
	//		move, we also want to error check the move. Hint: do the error checking in a separate
	//		function/functions.
	//		(e) Display current state of the game.
			
			
			int inputNum = 0;
			
			while(true) {
				//Scanner userIn = new Scanner(System.in);
				System.out.println("Where do you want to place your card? Input a number! ");
				inputNum = userIn.nextInt();
				if(bd.validCheck(inputNum)) {	
						
					break;
					
				}
				System.out.println("Whoops! Not a valid number, let's try again!");
				System.out.println("Make sure the input number stands for an empty spot and is in between 1 to 20");
				//userIn.close();
			}
			
			
			System.out.println("Sure. I'll place it on position No." + inputNum );
			
			
			
			bd.placeCard(inputNum, nextCd);
			round++;
			System.out.println();
			System.out.println("After " + round + " round, see below for the current board: ");
			bd.printBoard();
			if(bd.endCheck()) {
				System.out.println("Congrats! This is the end round of your game! I'm going to score the hands!");
				
				break;
			}
			else {
				System.out.println("keep up!!!");
				System.out.println();
			}
		}
		
//		(f) Repeat above three steps (deal card, place card, display game) over and over until the
//		game is complete.
		
//		(g) At the point where all 16 points of the table are filled, print a message telling the user
//		you are going to score the hands and then pass the state of the table to a scoring
//		function.
//		(h) The final message to display is just the score of your table.
//		(i) Print a message saying the game is done.

		
		System.out.println("---- You final score is: ----> " + bd.calculateScore());
		System.out.println("^_^ Good Job!!! Thank you, bye!");
		System.out.println("Jessica added a line, only for practice of conflict by anlan")

		userIn.close();
	}
	
	
	



	
	
	/*public static void main(String[] args) {
		BlackjackSolitaire  bjs = new BlackjackSolitaire ();
		bjs.play();
	}*/
}
