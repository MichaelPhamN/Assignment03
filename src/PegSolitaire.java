
public class PegSolitaire {
	public static boolean solve(boolean[][] pegs, StringStack solution){
		int startX = 0, startY = 0;
		if(solve(pegs, startX, startY, solution)){
			return true;
		}
		return false;
	}
	
	public static boolean solve(boolean[][] pegs, int newX, int newY, StringStack solution){		
		if(newX < 0 || newX >= pegs.length || newY < 0 || newY >= pegs.length)
			return false;
		
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
			solve(pegs, newX + 1, newY, solution);
		}else{
			solve(pegs, 0, newY + 1, solution);
		}		
		return false;
		
	}
	
	private static boolean tryMove(boolean[][] pegs, int startX, int startY, int jumpX, int jumpY, int endX, int endY, StringStack solution){
//		System.out.println("Try move " + startX + " " + startY + " " + jumpX + " " + jumpY + " " + endX + " " + endY);
		if(endX < 0 || endX >= pegs.length || endY < 0 || endY >= pegs.length){
			return false;
		}
		
		// (0,0)
		if(endX == 0 && endY == 0){
			return false;
		}
		
		// (0,1)
		if(endX == 0 && endY == 1){
			return false;
		}
		
		// (1,0)
		if(endX == 1 && endY == 0){
			return false;
		}
		
		// (1, 1)
		if(endX == 1 && endY == 1){
			return false;
		}
		
		// (5,0)
		if(endX == 5 && endY == 0){
			return false;
		}
		
		// (5,1)
		if(endX == 5 && endY == 1){
			return false;
		}
		
		// (6,0)
		if(endX == 6 && endY == 0){
			return false;
		}
		
		// (6, 1)
		if(endX == 6 && endY == 1){
			return false;
		}		
		
		// (0,5)
		if(endX == 0 && endY == 5){
			return false;
		}
		
		// (1,5)
		if(endX == 5 && endY == 1){
			return false;
		}
		
		// (0,6)
		if(endX == 0 && endY == 6){
			return false;
		}
		
		// (1, 6)
		if(endX == 1 && endY == 6){
			return false;
		}
		
		// (5,5)
		if(endX == 5 && endY == 5){
			return false;
		}
		
		// (5,6)
		if(endX == 5 && endY == 6){
			return false;
		}
				
		// (6, 5)
		if(endX == 6 && endY == 5){
			return false;
		}
		
		// (6, 6)
		if(endX == 6 && endY == 6){
			return false;
		}
		
		// Dung
		if(pegs[endX][endY] == false
                && pegs[jumpX][jumpY] == true
                && pegs[startX][startY] == true){
			pegs[endX][endY] = true;
			pegs[startX][startY] = false;
			pegs[jumpX][jumpY] = false;		
			String str = "(" + startX + ", " + startY + ") -> (" + endX + ", " + endY +")";
			System.out.println("jump " + str);
			solution.push(str);		
			for (int i = 0; i < pegs.length; i++) {
				for (int j = 0; j < pegs.length; j++) {
					if(pegs[i][j]  == false)
						System.out.print("false ");
					else
						System.out.print("true ");
				}
				System.out.println();
			}
		}
		
		
		
//		 Undo the move		
//		pegs[endX][endY] = false;
//		pegs[startX][startY] = true;
//		pegs[jumpX][jumpY] = true;			
//		solution.pop();
		
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
		boolean[][] testPlus = { 
				{ false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false },
				{ false, false, false, true, false, false, false }, 
				{ false, true, true, true, true, true, false },
				{ false, false, false, true, false, false, false },
				{ false, false, false, true, false, false, false },
				{ false, false, false, false, false, false, false } };
		String plusSolution = getSolution(testPlus);
		if (plusSolution != null) {
			String plusSolution1 = "(3, 2) -> (3, 0), (3, 4) -> (3, 2), (1, 3) -> (3, 3), (3, 3) -> (3, 1), (3, 0) -> (3, 2), (5, 3) -> (3, 3), (3, 2) -> (3, 4), (3, 5) -> (3, 3)";
			String plusSolution2 = "(2, 3) -> (0, 3), (4, 3) -> (2, 3), (3, 1) -> (3, 3), (3, 3) -> (1, 3), (0, 3) -> (2, 3), (3, 5) -> (3, 3), (2, 3) -> (4, 3), (5, 3) -> (3, 3)";
			if (plusSolution1.equals(plusSolution)) {
				System.out.println("Correct solution to the plus board! 30/30");				
			} else if (plusSolution2.equals(plusSolution)) {
				System.out.println("It looks like you're scanning column by column instead of row by row! 25/30");				
			} else {
				System.out.println("Unexpected solution! 0/30");
				System.out.println(plusSolution);
			}
		} else {
			System.out.println("Your code didn't find a solution! 0/30");
		}
	}

}
