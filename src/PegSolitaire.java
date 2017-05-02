public class PegSolitaire {
	public static boolean solve(boolean[][] pegs, StringStack solution){		
		if(run(pegs, solution)){
			return true;			
		}else{
			return false;
		}
	}
	
	public static boolean run(boolean[][] pegs, StringStack solution){
		int startX = 0, startY = 0, jumpX = 0, jumpY = 0, endX = 0, endY = 0;
		if(run(pegs, startX, startY, jumpX, jumpY, endX, endY, solution)){
			return true;		
		}else{
			return false;
		}
	}
	
	public static boolean run(boolean[][] pegs, int startX, int startY, int jumpX, int jumpY ,int endX, int endY, StringStack solution){		
		if(checkMove(pegs, endX, endY,solution)){
			run(pegs, solution);
		}else{	
			if((endX == pegs.length - 1) && (endY == pegs.length - 1) && pegs[3][3] == true){
				return true;
			}
			
			startX = endX;
			startY = endY;
			endX = endX + jumpX;
			endY = endY + jumpY;
			
			if (tryJump(pegs, startX, startY, -1, 0, endX, endY, solution)) {
				return true;
			}
			
			if (tryJump(pegs, startX, startY, 0, 1, endX, endY, solution)) {
				return true;
			}
			
			if (tryJump(pegs, startX, startY, 1, 0, endX, endY, solution)) {
				return true;
			}
			
			if (tryJump(pegs, startX, startY, 0, -1, endX, endY, solution)) {
				return true;
			}		
		}
		return false;
	}
	
	public static boolean tryJump(boolean[][] pegs, int startX, int startY, int jumpX, int jumpY, int endX, int endY, StringStack solution){
		if (endX < 0 || endX >= pegs.length || 
				endY < 0 || endY >= pegs[endX].length) {
			return false;
		}
		
		if(startX == endX + jumpX && startY == endY + jumpY){
			return false;
		}
		
		if(run(pegs, startX, startY, jumpX, jumpY, endX, endY, solution)){
			return true;
		}
		
		return false;
	}
	
	public static boolean checkMove(boolean[][] pegs, int startX, int startY, StringStack solution){
		if(startX < 0 || startX >= pegs.length || startX < 0 || startY > pegs.length){
			return false;
		}
		
		if (tryMove(pegs, startX, startY, startX - 2, startY, startX  - 2, startY, solution)) {
			return true;
		}
		
		if (tryMove(pegs, startX, startY, startX + 2, startY, startX + 2, startY, solution)) {
			return true;
		}
		
		if (tryMove(pegs, startX, startY, startX, startY  - 2, startX, startY - 2, solution)) {
			return true;
		}
		
		if (tryMove(pegs, startX, startY, startX, startY + 2, startX, startY + 2, solution)) {
			return true;
		}		
		
		return false;
			
	}
	
	private static boolean tryMove(boolean[][] pegs, int startX, int startY, int jumpX, int jumpY, int endX, int endY, StringStack solution) {
		if(endX < 0 || endX >= pegs.length || endY < 0 || endY >= pegs.length){
			return false;
		}		
		
		if(startX == endX && startY == endY){
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
                && pegs[(startX + endX) / 2][(startY + endY) / 2] == true
                && pegs[startX][startY] == true){
			pegs[endX][endY] = true;
			pegs[startX][startY] = false;
			pegs[(startX + endX) / 2][(startY + endY) / 2] = false;			
			String str = "(" + startX + ", " + startY + ") -> (" + endX + ", " + endY +")";
			solution.push(str);
			return true;
		}				
		
		return false;
	}	
	
	
	
	public static void main(String[] args){
//		StringStack stack = new StringStack(); // Empty stack
		boolean[][] testPlus = { 
				{ false, false, false, false, false, false, false },
				{ false, false, false, true,  false, false, false },
				{ false, false, false, true,  false, false, false }, 
				{ false, true,  true,  true,  true,  true,  false },
				{ false, false, false, true,  false, false, false },
				{ false, false, false, true,  false, false, false },
				{ false, false, false, false, false, false, false } };
		String plusSolution = getSolution(testPlus);
		System.out.println(plusSolution);
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

}
