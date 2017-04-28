
public class PegSolitaire {	
	public static boolean solve(boolean[][] pegs, StringStack solution){
		int startX = 0;
		int startY = 0;
		
		if(solve(pegs, startX, startY,))
		
		return false;
		
	}
	
	public static boolean solve(boolean[][] pegs, int startX, int startY, int endX, int endY, StringStack solution){
		// Jump Up
		if(tryMove(pegs, startX, startY, 0, 2, endX, endY, solution)){
			return true;
		}
		
		// Jump Down
		if(tryMove(pegs, startX, startY, 0, -2, endX, endY, solution)){
			return true;
		}
		
		// Jump Left
		if(tryMove(pegs, startX, startY, -2, 0, endX, endY, solution)){
			return true;
		}
		
		// Jump Right
		if(tryMove(pegs, startX, startY, 2, 0, endX, endY,solution)){
			return true;
		}
	}
	private static boolean tryMove(boolean[][] pegs, int startX, int startY, int jumpX, int jumpY, int endX, int endY, StringStack solution){
		// Move out of bound
		if(endX < 0 || endX >= pegs.length 
				|| endY < 0 || endY >= pegs.length)
		{
			return false;
		}
		
		// Jump to point (0,0)		 
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
		
		// Check if Jump to point (3,3)
		/* If all points equal true except for (0,0),(0,1),(1,0),(1,1),(7,7),(7,6),(7,7)
		 * (6,6), (0,7), (0,6), (1,7), (1,6), (7,0), (6,0), (7,1), (6,1) => return true (finish)
		 * else // not succeed
		 *  run again from start X, startY with different direction
		 */
		
		if(endX == 3 && endY == 3){
			
		}
		
		return false;
		
	}
	public static void main(String[] args) {
		boolean[][] pegs = {
					{false, false, false, false, false, false, false},
					{false, false, false, false, false, false, false},
					{false, false, false, false, false, false, false},
					{false, false, false, true, false, false, false},
					{false, false, false, false, false, false, false},
					{false, false, false, false, false, false, false},
					{false, false, false, false, false, false, false},
				};
		
		StringStack stack = new StringStack();
		solve(pegs, stack);
		
	}

}
