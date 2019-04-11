/* Created by: Elevens Lab Guide
*  Modified by: Corbin Tanchip
*  Created on: Unknown
*  Modified on: June 7, 2017
*
*  This class provides the board for the game elevens, it holds methods that check card plays
*/ 

import java.util.List;
import java.util.ArrayList;


public class ElevensBoard extends Board {

	
	// The size of cards on board
	private static final int BOARD_SIZE = 9;


	// The ranks of cards in the deck
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
	
	// The suits of cards in the deck
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	// The values of cards in the deck
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	// A flag to control debugging in print statements.
	private static final boolean I_AM_DEBUGGING = false;

	 // This constructor creates a new board for the game
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }


	/* This method checks if the selected cards are valid to be removed.
	*  It takes the parameter selectedCards which is the indices of the
	*  cards selected. It checks if the selected cards have a sum of 11,
	*  or a trio of Jack, Queen, and King. It uses the helper methods
	*  containsPairSum11 and containsJQK for checking. It returns true
	*  if the cards can be removed, false otherwise.
	*/ 

	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		
		
		if (selectedCards.size() == 2)
			return containsPairSum11(selectedCards);
		
		else if (selectedCards.size() == 3)
			return containsJQK(selectedCards);
		
		
		return false;
		
		
			
	}


	/* This method determines if there are legal plays on the board.
	*  It uses the helper methods containsPairSum11 and containsJQK
	*  to see if any cards on the board have potential plays. It returns
	*  true if there are, false otherwise
	*/

	@Override
	public boolean anotherPlayIsPossible() {
	
		
		List<Integer> values = cardIndexes();
		
		if (containsPairSum11(values) == true || containsJQK(values) == true)
			return true;
		
		return false;
			
		
	}


	/* This method checks for a pair of cards whose values have a sum of 11.
	*  It takes the parameter selectedCards which are the indexes on the board.
	*  This method also utilizes accessor methods from the superclass Board.
	*  It searches through every combination of the cards on board to determine
	*  if the values add up to 11
	*
	*  This method used accessor methods
	*  cardAt to get the card at the index
	*  pointValue which returns the card's point value
	*
	*  Returns true if the card values add up to 11, false otherwise
	*/ 

	private boolean containsPairSum11(List<Integer> selectedCards) {
		
	
		for (int i = 0; i < selectedCards.size(); i++) {
			
			for (int j = (i + 1); j < selectedCards.size() - 1; j++) {
				
				int test = cardAt(selectedCards.get(i)).pointValue();
				int test2 = cardAt(selectedCards.get(j)).pointValue();
				
				if (test + test2 == 11) 
					return true;
			
			}
			
		}
		
		return false;
		
		
		
		
	}
	

	/* This method checks for a trio of cards of Jack, Queen, and King.
	*  It takes the parameter selectedCards which are the indexes on the board.
	*  This method also utilizes accessor methods from the superclass Board.
	*  The method searches if the board contains at least one Jack, Queen, and King
	*  
	*  This method used accessor methods
	*  cardAt to get the card at the index
	*  rank which returns the card's rank
	*
	*  Returns true if there is a trio of JQK, false otherwise
	*/ 

	private boolean containsJQK(List<Integer> selectedCards) {
		
		
		boolean jack = false;
		boolean queen = false;
		boolean king = false;
		
	
		for (int i = 0; i < selectedCards.size(); i++) {
			
			if (cardAt(i).rank().equals("jack"))
				jack = true;
			else if (cardAt(i).rank().equals("queen"))
				queen = true;
			else if (cardAt(i).rank().equals("king"))
				king = true;
		
		}
		
		if (jack == true && queen == true && king == true)
			return true;
		
		return false;
		
	
	}
}
