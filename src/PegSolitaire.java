
public class PegSolitaire {	
	public static boolean solve(boolean[][] pegs, StringStack solution){	
		for(int i = 0; i< pegs.length; i++){
			for(int j = 0; j < pegs[i].length; j++){
				if(pegs[i][j] == true){
					System.out.print(" . ");
				}else{
					System.out.print(" X ");
				}				
			}
			System.out.println();
		}
		System.exit(0);
		
		int startX = 0;
		int startY = 0;
		int endX = 3;
		int endY = 3;		

		if(solve(pegs, startX, startY, endX, endY, solution)){
			return true;
		}
		return false;
	}
	
	public static boolean solve(boolean[][] pegs, int startX, int startY, int endX, int endY, StringStack solution){
		if(tryMove(pegs, startX, startY, startX, startY + 2, endX, endY, solution)){
			return true;
		}
		
		// Jump Down
		if(tryMove(pegs, startX, startY, startX, startY - 2, endX, endY, solution)){
			return true;
		}
		
		// Jump Left
		if(tryMove(pegs, startX, startY, startX - 2, startY, endX, endY, solution)){
			return true;
		}
		
		// Jump Right
		if(tryMove(pegs, startX, startY, startX + 2, startY, endX, endY,solution)){
			return true;
		}
		return false;
	}
	private static boolean tryMove(boolean[][] pegs, int startX, int startY, int jumpX, int jumpY, int endX, int endY, StringStack solution){
		// Check can not move
		
		// Move out of bound
		if(jumpX < 0 || jumpX >= pegs.length 
				|| jumpY < 0 || jumpY >= pegs.length)
		{
			return false;
		}
		
		// Jump to point (0,0)		 
		if(jumpX == 0 && jumpY == 0){
			return false;
		}
		
		// Jump to point (0,1)
		if(jumpX == 0 && jumpY == 1){
			return false;
		}
		
		// Jump to point (1,0)
		if(jumpX == 1 && jumpY == 0){
			return false;
		}
		
		// Jump to point (1, 1)
		if(jumpX == 1 && jumpY == 1){
			return false;
		}
		
		// Jump to point (7,7)
		if(jumpX == 7 && jumpY == 7){
			return false;
		}
		
		// Jump to point (7, 6)
		if(jumpX == 7 && jumpY == 6){
			return false;
		}
		
		// Jump to point (6,7)
		if(jumpX == 6 && jumpY == 7){
			return false;
		}
		
		// Jump to point (6, 6)
		if(jumpX == 6 && jumpY == 6){
			return false;
		}
		
		
		// Jump to point (7,0)
		if(jumpX == 7 && jumpY == 0){
			return false;
		}
		
		// Jump to point (7, 1)
		if(jumpX == 7 && jumpY == 1){
			return false;
		}
		
		// Jump to point (6,0)
		if(jumpX == 6 && jumpY == 0){
			return false;
		}
		
		// Jump to point (6, 1)
		if(jumpX == 6 && jumpY == 1){
			return false;
		}
		
		// Jump to point (0,7)
		if(jumpX == 0 && jumpY == 7){
			return false;
		}
		
		// Jump to point (0, 6)
		if(jumpX == 0 && jumpY == 6){
			return false;
		}
		
		// Jump to point (1,7)
		if(jumpX == 1 && jumpY == 7){
			return false;
		}
		
		// Jump to point (1, 6)
		if(jumpX == 1 && jumpY == 6){
			return false;
		}
		
		// check can move
		
		
		
		return false;
		
	}
	
	public static String getSolution(boolean[][] board) {
		StringStack stack = new StringStack();
		if (solve(board, stack)) {
			String cat = stack.pop();
			String s;
			while ((s = stack.pop()) != null) {
				cat = s + ", " + cat;
			}
			return cat;
		}
		return null;
	}
	
	public static void main(String[] args) {
		boolean[][] testSimple = { { false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false },
				{ false, true, true, false, false, false, false },
				{ false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false } };
		
		String simpleSolution = getSolution(testSimple);		
		
		
	}

}
