
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
			return solve(pegs, newX + 1, newY, solution);
		}else{
			return solve(pegs, 0, newY + 1, solution);
						
		}
		
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
	
	public static int pegCount(boolean[][] pegs){
		int startX = 0, startY = 0, count = 0;
		return pegCount(pegs, startX, startY, count);			
	}
	
	public static int pegCount(boolean[][] pegs, int newX, int newY, int count){		
		if (pegs[newX][newY] == true){
			count = count + 1;
		}
		
		if (newX < 6){
			return pegCount(pegs, newX + 1, newY, count);
		}
		if(newX >= 6 && newY <6){			
			return pegCount(pegs, 0, newY + 1, count);						
		}
		return count;		
	}
}
