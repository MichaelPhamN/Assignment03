
public class PegSolitaire {
	public static boolean solve(boolean[][] pegs, StringStack solution){
		int startX = 0, startY = 0;
		if(solve(pegs, startX, startY, solution)){
			return true;
		}
		return false;
	}
	
	public static int pegCount(boolean[][] pegs) {
		int count = 0; 
		for(int i = 0; i < pegs.length; i++){
			for(int j = 0; j < pegs[0].length; j++){
				if(pegs[i][j] == true){
					count = count + 1;
				} 
			}
		}
		return count;
	}
	
	public static boolean solve(boolean[][] pegs, int newX, int newY, StringStack solution){		
		// If board is solved
		if (pegCount(pegs) == 1 && pegs[3][3] == true){
			return true;
		}
		
		// For each board position. Try moving up, down, left, right 
		if(tryMove(pegs, newX, newY, newX, newY - 1, newX, newY - 2,solution)){
			return true;
		}
		
		if(tryMove(pegs, newX, newY, newX, newY + 1, newX, newY + 2,solution)){
			return true;
		}
		
		if(tryMove(pegs, newX, newY, newX - 1, newY, newX - 2,newY,solution)){
			return true;
		}
		
		if(tryMove(pegs, newX, newY, newX + 1, newY, newX + 2,newY,solution)){
			return true;
		}
		
		if (newX < 6){
			return solve(pegs, newX + 1, newY, solution);
		}else{
			return solve(pegs, 0, newY + 1, solution);
		}		
	
	}
	
	private static boolean tryMove(boolean[][] pegs, int startX, int startY, int jumpX, int jumpY, int endX, int endY, StringStack solution){	
		System.out.println("tryMove " + startX + " " + startY + " " + jumpX + " " + jumpY + " " + endX + " " + endY);
		if(endX < 0 || endX >= pegs.length || endY < 0 || endY >= pegs.length){
			return false;
		}
		
		if(endX == 0 && endY == 0){
			return false;
		}
		
		// Jump to point (0,1)
		if(endX == 0 && endY == 1){
			return false;
		}
		
		// Jump to point (1,0)
		if(endX == 1 && endY == 0){
			return false;
		}
		
		// Jump to point (1, 1)
		if(endX == 1 && endY == 1){
			return false;
		}
		
		// Jump to point (7,7)
		if(endX == 7 && endY == 7){
			return false;
		}
		
		// Jump to point (7, 6)
		if(endX == 7 && endY == 6){
			return false;
		}
		
		// Jump to point (6,7)
		if(endX == 6 && endY == 7){
			return false;
		}
		
		// Jump to point (6, 6)
		if(endX == 6 && endY == 6){
			return false;
		}		
		
		// Jump to point (7,0)
		if(endX == 7 && endY == 0){
			return false;
		}
		
		// Jump to point (7, 1)
		if(endX == 7 && endY == 1){
			return false;
		}
		
		// Jump to point (6,0)
		if(endX == 6 && endY == 0){
			return false;
		}
		
		// Jump to point (6, 1)
		if(endX == 6 && endY == 1){
			return false;
		}
		
		// Jump to point (0,7)
		if(endX == 0 && endY == 7){
			return false;
		}
		
		// Jump to point (0, 6)
		if(endX == 0 && endY == 6){
			return false;
		}
		
		// Jump to point (1,7)
		if(endX == 1 && endY == 7){
			return false;
		}
		
		// Jump to point (1, 6)
		if(endX == 1 && endY == 6){
			return false;
		}		
		if(pegs[endX][endY] == false
                && pegs[jumpX][jumpY] == true
                && pegs[startX][startY] == true){
			pegs[endX][endY] = true;
			pegs[startX][startY] = false;
			pegs[jumpX][jumpY] = false;			
			String str = "(" + startX + ", " + startY + ") -> (" + endX + ", " + endY +")";
			solution.push(str);
			return solve(pegs, solution);
		}
		
		// Recursively try to solve from here
//		if(solve(pegs, endX, endY, solution)){
//			return true;
//		}
		// Undo the move
//		pegs[endX][endY] = false;
//		pegs[startX][startY] = true;
//		pegs[jumpX][jumpY] = true;			
//		solution.pop();
		
		return false;
	}
	
	
	public static String getSolution(boolean[][] board) {
		StringStack stack = new StringStack();
		if (PegSolitaire.solve(board, stack)) {
			String cat = stack.pop();
			String s;
			while ((s = stack.pop()) != null) {
				cat = s + ", " + cat;
			}
			return cat;
		}
		return null;
	}
	
	public static void main(String[] args){
		System.out.println("Attempting to solve 'plus' board:");
		boolean[][] testPlus = { { false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false },
				{ false, false, false, true, false, false, false }, { false, true, true, true, true, true, false },
				{ false, false, false, true, false, false, false },
				{ false, false, false, true, false, false, false },
				{ false, false, false, false, false, false, false } };
		String plusSolution = getSolution(testPlus);
		if (plusSolution != null) {
			String plusSolution1 = "(3, 2) -> (3, 0), (3, 4) -> (3, 2), (1, 3) -> (3, 3), (3, 3) -> (3, 1), (3, 0) -> (3, 2), (5, 3) -> (3, 3), (3, 2) -> (3, 4), (3, 5) -> (3, 3)";
			String plusSolution2 = "(2, 3) -> (0, 3), (4, 3) -> (2, 3), (3, 1) -> (3, 3), (3, 3) -> (1, 3), (0, 3) -> (2, 3), (3, 5) -> (3, 3), (2, 3) -> (4, 3), (5, 3) -> (3, 3)";
			if (plusSolution1.equals(plusSolution)) {
				System.out.println("Correct solution to the plus board! 30/30");
//				points += 30;
			} else if (plusSolution2.equals(plusSolution)) {
				System.out.println("It looks like you're scanning column by column instead of row by row! 25/30");
//				points += 25;
			} else {
				System.out.println("Unexpected solution! 0/30");
				System.out.println(plusSolution);
			}
		} else {
			System.out.println("Your code didn't find a solution! 0/30");
		}
	}

}
