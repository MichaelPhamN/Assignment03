
public class PegSolitaire_v2 {
	public static boolean solve(boolean[][] pegs, StringStack solution){
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < pegs.length; j++) {
				if(countPegs(pegs) == 1 && pegs[3][3] == true){
					return true;
				}
				if(tryMove(pegs, j, i, j, i - 1, j, i - 2,solution)){
					return true;
				}
				
				if(tryMove(pegs, j, i, j, i + 1, j, i + 2,solution)){
					return true;
				}
				
				if(tryMove(pegs, j, i, j - 1, i, j - 2,i,solution)){
					return true;
				}
				
				if(tryMove(pegs, j, i, j + 1, i, j + 2,i,solution)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean tryMove(boolean[][] pegs, int startX, int startY, int jumpX, int jumpY, int endX, int endY, StringStack solution){
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
		if(endX == 1 && endY == 5){
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
		
		if (pegs[endX][endY] == false && pegs[jumpX][jumpY] == true && pegs[startX][startY] == true) {
			pegs[endX][endY] = true;
			pegs[startX][startY] = false;
			pegs[jumpX][jumpY] = false;	
			String str = "(" + startX + ", " + startY + ") -> (" + endX + ", " + endY +")";			
			solution.push(str);
			// Recursively try to solve from here
			if(solve(pegs, solution)){
			return true;
			}
			// Undo the move
			pegs[endX][endY] = false;
			pegs[startX][startY] = true;
			pegs[jumpX][jumpY] = true;	
			solution.pop();
		}
		
		return false;
	}
	
	public static int countPegs(boolean[][] pegs){
		int count = 0;
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < pegs.length; j++) {
				if(pegs[i][j] == true){
					count = count + 1;
				}
			}
		}
		return count;
	}
}
