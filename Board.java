import java.util.ArrayList;

public class Board {
	//22, leave the last as null
	String[] boardPos = new String[22];
	Card[] cardOnBoard = new Card[22];
	
	//construct the board 
	public Board() {
	
		for(int i =1; i<boardPos.length-1; i++) {
			boardPos[i] = i + "";
			
		}
		
	}
	
	//placeCard,save in card list, update the board
	public void placeCard(int Pos, Card deltCard) {
		for(int i = 0; i<boardPos.length; i++) {
			if (i == Pos) {
				
				cardOnBoard[i] = deltCard;
				boardPos[i] = deltCard.getName();

			}
			
		}
		
	}
	//check if the #position on board is empty (no card was placed). REVISED: actually check if the input is valid!
	public boolean validCheck(int i) {
		if(i>=1 && i<= 20 && boardPos[i].equals(i + "")){
			return true;
		}
		return false;
		
		
	}
	
	//end check
	public boolean endCheck() {
		for(int i = 1; i<= 16; i++) {
			if(boardPos[i].equals(i + "")) {
				return false;
			}
		}
		return true;
	}
	
	
	//calculate score
	public int calculateScore() {
		int finalScore = 0;
		
		//calculate row1: 1,2,3,4,5
		ArrayList<Integer> row1 = new ArrayList<Integer>();

		for(int i = 1; i<=5; i++) {
			row1.add(i);
		}
		int row1Sc = calHelper(row1);
		System.out.println("* row1 score:----> " + row1Sc );
		/*finalScore = finalScore + calHelper(row1);
		System.out.println("finalScore--------------> " + finalScore);*/
		
		
		//calculate row2: 6,7,8,9,10
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		for(int i = 6; i<=10; i++) {
			row2.add(i);
		}
		int row2Sc = calHelper(row2);
		System.out.println("* row2 score:----> " + row2Sc);
		/*finalScore = finalScore + calHelper(row2);
		System.out.println("finalScore--------------> " + finalScore);
		*/
		//calculate row3: 11,12,13
		ArrayList<Integer> row3 = new ArrayList<Integer>();
		for(int i = 11; i<=13; i++) {
			row3.add(i);
		}
		int row3Sc = calHelper(row3);
		System.out.println("* row3 score:----> " +row3Sc);
		/*finalScore = finalScore + calHelper(row3);
		System.out.println("finalScore--------------> " + finalScore);
		*/
		//calculate row4: 14,15,16
		
		ArrayList<Integer> row4 = new ArrayList<Integer>();
		for(int i = 14; i<=16; i++) {
			row4.add(i);
		}
		int row4Sc = calHelper(row4);
		System.out.println("* row4 score:----> " + row4Sc);
		/*finalScore = finalScore + calHelper(row4);
		System.out.println("finalScore--------------> " + finalScore);*/
		
		//calculate col1: 1,6
		ArrayList<Integer> col1 = new ArrayList<Integer>();
		col1.add(1);
		col1.add(6);
		int col1Sc = calHelper(col1);
		System.out.println("# col1 score:----> " + col1Sc);		
		/*finalScore = finalScore + calHelper(col1);
		System.out.println("finalScore--------------> " + finalScore);*/
		
		//calculate col2: 2,7,11,14
		ArrayList<Integer> col2 = new ArrayList<Integer>();
		col2.add(2);
		col2.add(7);
		col2.add(11);
		col2.add(14);
		int col2Sc = calHelper(col2);
		System.out.println("# col2 score:----> " + col2Sc);
		/*finalScore = finalScore + calHelper(col2);
		System.out.println("finalScore--------------> " + finalScore);*/
		
		//calculate col3: 3,8,12,15
		
		ArrayList<Integer> col3 = new ArrayList<Integer>();
		col3.add(3);
		col3.add(8);
		col3.add(12);
		col3.add(15);
		int col3Sc = calHelper(col3);
		System.out.println("# col3 score:----> " + col3Sc);
		/*finalScore = finalScore + calHelper(col3);
		System.out.println("finalScore--------------> " + finalScore);*/
		
		
		
		//calculate col4: 4,9,13,16
		ArrayList<Integer> col4 = new ArrayList<Integer>();
		col4.add(4);
		col4.add(9);
		col4.add(13);
		col4.add(16);
		int col4Sc = calHelper(col4);
		System.out.println("# col4 score:----> " + col4Sc);
		/*finalScore = finalScore + calHelper(col4);
		System.out.println("finalScore--------------> " + finalScore);*/
		
		
		
		//calculate col5: 5,10
		ArrayList<Integer> col5 = new ArrayList<Integer>();
		col5.add(5);
		col5.add(10);
		int col5Sc = calHelper(col5);
		System.out.println("# col5 score:----> " + col5Sc);
		/*finalScore = finalScore + calHelper(col5);
		System.out.println("finalScore--------------> " + finalScore);*/
		//add up all
		
		finalScore = row1Sc + row2Sc + row3Sc + row4Sc + col1Sc + col2Sc + col3Sc + col4Sc + col5Sc;
		

		return finalScore;
	}
	
	//helper method: calculate sum and apply score rule for totalScore of one row or one column, Ace counts 11 or 1 considered
	private int calHelper(ArrayList<Integer> poslist) {
		int sum = 0;
		int sumAlter = 0;
		int countAce =0;
		int scoreOneRoworCol = 0;
		for(int i: poslist) {
			
			if(cardOnBoard[i].getValue() != 1) {
				sum = sum + cardOnBoard[i].getValue();
				
			}
			else {
				countAce++;
				sum = sum +1;
			}
			
		}
		
		//System.out.println("How many Ace: "+ countAce);
		
		if(countAce++ != 0) {
			sumAlter = sum+10;
			
		}
		//test inside the class, don't print in the final
		/*System.out.println("This row/col, sumAlter--->  "+ sumAlter );
		System.out.println("his row/col,sum--->  "+ sum );*/
		
		if( scoreRule(sumAlter, poslist.size()) > scoreRule(sum, poslist.size()) ){
			
			scoreOneRoworCol = scoreRule(sumAlter, poslist.size());
			
			
		}
		else {
			scoreOneRoworCol = scoreRule(sum, poslist.size());
		}
		
		
	

		return scoreOneRoworCol;
	}  
	
	
	//construct the score rules
	private int scoreRule(int inputsum, int cardCont) {
		int scoreReturn = 0;
		
		if(inputsum == 21 && cardCont ==2) {
			scoreReturn = 10;
		}
		if(inputsum == 21 && cardCont != 2) {
			scoreReturn = 7;
		}
		
		if(inputsum == 20) {
			scoreReturn = 5;
		} 
		
		if(inputsum == 19) {
			scoreReturn = 4;
		} 
		
		if(inputsum == 18) {
			scoreReturn = 3;
		} 
		
		if(inputsum == 17) {
			scoreReturn = 2;
		} 
		
		if(inputsum >= 22) {
			scoreReturn = 0;
		} 
		
		if(inputsum >0 && inputsum <= 16) {
			scoreReturn = 1;
		} 
		//System.out.println(scoreReturn);
		return scoreReturn;

	}
	
	
	//printBoard with certain format
	//develop the method to align the grid by maintain the print string s at length 5 
	private String getPostionString(int i) {
		String s ="";
		//boardPos[21] is null, use it later print the blank position
		if(i<boardPos.length-1) {
			 s = boardPos[i];
		}

		while(s.length()<5) {
			s = s +" ";
		}
		return s;
	}
	//printBoard with certain format
	public void printBoard() {
		for (int i = 1; i <=5; i++) {
			System.out.print(getPostionString(i) ); 
		}
		System.out.println();
		
		for (int i = 6; i <=10; i++) {
			System.out.print(getPostionString(i) ); 
		}
		
		System.out.println();
		System.out.print (getPostionString(21));
		
		for (int i = 11; i <=13; i++) {
			System.out.print(getPostionString(i));
		}
		
		System.out.println();
		System.out.print( getPostionString(21));

		for (int i = 14; i <=16; i++) {
			System.out.print(getPostionString(i));
		}
		
		System.out.println();
		//System.out.println(getPostionString(21));
		System.out.print("Discard Cards:  ");
		for (int i = 17; i <= 20; i++) {
			System.out.print(getPostionString(i));
		}
		System.out.println();
	}
	
	
	
	//test-------------
	/*public static void main(String[] args) {
		Board bd = new Board();
		bd.printBoard();
		Card cd = new Card("AS", 11);
		for(int i = 1; i<= 16; i++) {
			bd.placeCard(i,cd);
			
		}
		
		if(bd.endCheck()) {
			System.out.println("game end!!!");
			
		}
		else {
			System.out.println("no end");
		}
		
		bd.printBoard();
		bd.scoreRule(15, 2);
		
		
	}*/
}
