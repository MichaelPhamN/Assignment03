
public class PegSolitaire_v1 {
	public static Boolean solve(boolean[][] pegs, StringStack solution){
		int startX = 0, startY = 0, numPeg = 0;
		if(solve(pegs, startX, startY, numPeg, solution)){
			return true;
		}
		return false;
	}

	public static boolean solve(boolean[][] pegs, int startX, int startY, int numPeg, StringStack solution){
		
	}

	public static boolean tryMove(boolean[][] pegs, int startX, int startY, int jumpX, int jumpY, int endX, int endY, int numPeg, StringStack solution)
	{
		if(endX < 0 || endX >= pegs.length || endY < 0 || endY >= pegs.length){
			return false;
		}
		
		if(endX == 0 && endY == 0){
			return false;
		}
		
		if(endX == 0 && endY == 1){
			return false;
		}
		
		if(endX == 1 && endY == 0){
			return false;
		}
		
		if(endX == 1 && endY == 1){
			return false;
		}
		
		if(endX == 5 && endY == 0){
			return false;
		}
		
		if(endX == 5 && endY == 1){
			return false;
		}
		
		if(endX == 6 && endY == 0){
			return false;
		}
		
		if(endX == 6 && endY == 1){
			return false;
		}		
		
		if(endX == 0 && endY == 5){
			return false;
		}
		
		if(endX == 1 && endY == 5){
			return false;
		}
		
		if(endX == 0 && endY == 6){
			return false;
		}
		
		if(endX == 1 && endY == 6){
			return false;
		}
		
		if(endX == 5 && endY == 5){
			return false;
		}
		
		if(endX == 5 && endY == 6){
			return false;
		}
				
		if(endX == 6 && endY == 5){
			return false;
		}

		if(endX == 6 && endY == 6){
			return false;
		}
		
		if (pegs[endX][endY] == false && pegs[jumpX][jumpY] == true && pegs[startX][startY] == true) {
			pegs[endX][endY] = true;
			pegs[startX][startY] = false;
			pegs[jumpX][jumpY] = false;	
			String str = "(" + startX + ", " + startY + ") -> (" + endX + ", " + endY +")";			
			solution.push(str);

			if(solve(pegs, solution)){
			return true;
			}

			pegs[endX][endY] = false;
			pegs[startX][startY] = true;
			pegs[jumpX][jumpY] = true;	
			solution.pop();
		}		
		return false;
	}

	public static boolean increment(boolean[][] pegs, int numPegs,StringStack solution){
	}
}
