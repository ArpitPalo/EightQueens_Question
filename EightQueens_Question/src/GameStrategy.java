public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		// WRITE YOUR LOGIC HERE...................................		
		int col = cellId%8;
		return col;	// just for the heck of it
	}
	
	private int getRow(int cellId) {
		// WRITE YOUR LOGIC HERE....................................
		
		return cellId/8;	// just for the heck of it
	}
	
	private boolean checkLeft(boolean placedQueens[][], int row, int col) {
		
		for(int i = 0; i < col; i++) {
			if(placedQueens[row][i] == true) {
				return false;
			}
		}
		return true;
		
	}
	
	private boolean checkRight(boolean placedQueens[][], int row, int col) {
		
		for(int i = col+1; i < 8; i++) {
			if(placedQueens[row][i] == true) {
				return false;
			}
		}
		return true;
		
	}
	
	private boolean checkUp(boolean placedQueens[][], int row, int col) {
		
		for(int i = 0; i < row; i++) {
			if(placedQueens[i][col] == true) {
				return false;
			}
		}
		return true;
		
	}
	
	private boolean checkUpperLeft(boolean placedQueens[][], int row, int col) {
		int i = row-1;
		int j = col-1;
		while (i >=0 && j >= 0) {
			if(placedQueens[i][j]) {
				return false;
			}
			i--;
			j--;
		}
		return true;
	}

	private boolean checkUpperRight(boolean placedQueens[][], int row, int col) {
		int i = row-1;
		int j = col+1;
		while (i >=0 && j < 8) {
			if(placedQueens[i][j]) {
				return false;
			}
			i--;
			j++;
		}
		return true;
	}
	
	private boolean checkDown(boolean placedQueens[][], int row, int col) {
		for(int i = row+1; i < 8; i++) {
			if(placedQueens[i][col]) {
				return false;
			}
		}
		return true;
	}

	private boolean checkLowerLeft(boolean placedQueens[][], int row, int col) {
		int i = row+1;
		int j = col-1;
		while(i < 8 && j >= 0) {
			if(placedQueens[i][j]) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	private boolean checklowerRight(boolean placedQueens[][], int row, int col) {
		int i = row+1;
		int j = col+1;
		while(i < 8 && j < 8) {
			if(placedQueens[i][j]) {
				return false;
			}
			i++;
			j++;
		}
		return true;
	}

	public boolean isValidPosition(int cellId) {
		boolean isValid = true;

		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		
		int row = getRow(cellId);
		if(placedQueens[row][col]) {
			return false;
		}
		boolean left = checkLeft(placedQueens, row, col);
		boolean right = checkRight(placedQueens, row, col);
		boolean up = checkUp(placedQueens, row, col);
		boolean upperLeft = checkUpperLeft(placedQueens, row, col);
		boolean upperRight = checkUpperRight(placedQueens, row, col);
		boolean down = checkDown(placedQueens, row, col);
		boolean lowerLeft = checkLowerLeft(placedQueens, row, col);
		boolean lowerRight = checklowerRight(placedQueens, row, col);
		if(left && right && up && upperLeft && upperRight && down && lowerLeft && lowerRight) {
			isValid = true;
			placedQueens[row][col] = true;
			numQueens++;
		} else {
			isValid = false;
		}
		
		return isValid;
	}
}














