
public class PegSolitaire {	
	public static boolean solve(boolean[][] pegs, StringStack solution){
		for(int i = 0; i < pegs.length; i++){
			for(int j = 0; j < pegs[i].length; j++){
				int newX = 0, newY = 0;
				// Jump Up
				if(tryMove(pegs, i, j, 0, 2, newX, newY, solution)){
					return true;
				}
				
				// Jump Down
				if(tryMove(pegs, i, j, 0, -2, newX, newY, solution)){
					return true;
				}
				
				// Jump Left
				if(tryMove(pegs, i, j, -2, 0, newX, newY, solution)){
					return true;
				}
				
				// Jump Right
				if(tryMove(pegs, i, j, 2, 0, newX, newY, solution)){
					return true;
				}
			}
		}
		
		
		
		
		return false;
		
	}
	private static boolean tryMove(boolean[][] pegs, int startX, int startY, int jumpX, int jumpY, int endX, int endY, StringStack solution){
		if(endX < 0 || endX >= pegs.length 
				|| endY < 0 || endY >= pegs.length)
		{
			return false;
		}
		
		
		
		// (0,0)
		if(endX == 0 && endY == 0){
			return false;
		}
		
		// (0, 1)
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
		
		// (0,0)
		if(endX == 7 && endY == 7){
			return false;
		}
		
		// (0, 1)
		if(endX == 7 && endY == 6){
			return false;
		}
		
		// (1,0)
		if(endX == 6 && endY == 7){
			return false;
		}
		
		// (1, 1)
		if(endX == 6 && endY == 6){
			return false;
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
