
public class PegSolitaire {
	public static boolean solve(boolean[][] pegs, StringStack solution){
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 7; j++){
				if(pegs[i][j] == true){					
					for(int k = 0; k < 4; k++){						
						if(tryMove(pegs,i,j,k,solution)){
							solve(pegs,solution);							
						}
					}

				}
			}
		}	
		if(isSolve(pegs)){
			return true;
		}
		return false;
	}

	private static boolean tryMove(boolean[][] pegs, int x, int y, int k, StringStack solution) {
		int newX = getNewX(x,k);
		int newY = getNewY(y,k);	
		if(newX == x && newY == y)
			return false;
		if(checkMove(pegs, x, y, newX, newY )){
			pegs[newX][newY] = true;
			pegs[x][y] = false;
			pegs[(x + newX) / 2][(y + newY) / 2] = false;			
			String str = "(" + x +", " +y +") -> (" + newX + ", " + newY +")";
			solution.push(str);
			return true;
		}
		return false;
	}
	
	public static boolean isSolve(boolean[][] pegs){
		int count = 0;
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 7; j++){
				if(pegs[i][j] == true){
					count++;
				}
			}
		}
		
		if(count == 1 && pegs[3][3] == true){
			return true;
		}
		return false;
	}
	
	private static boolean checkMove(boolean[][] pegs, int x, int y, int newX, int newY){
		if(newX < 0 || newX >= pegs.length || newY < 0 || newY >= pegs.length){
			return false;
		}
		
		if(newX == 0 && newY == 0){
			return false;
		}
		
		// Jump to point (0,1)
		if(newX == 0 && newY == 1){
			return false;
		}
		
		// Jump to point (1,0)
		if(newX == 1 && newY == 0){
			return false;
		}
		
		// Jump to point (1, 1)
		if(newX == 1 && newY == 1){
			return false;
		}
		
		// Jump to point (7,7)
		if(newX == 7 && newY == 7){
			return false;
		}
		
		// Jump to point (7, 6)
		if(newX == 7 && newY == 6){
			return false;
		}
		
		// Jump to point (6,7)
		if(newX == 6 && newY == 7){
			return false;
		}
		
		// Jump to point (6, 6)
		if(newX == 6 && newY == 6){
			return false;
		}
		
		
		// Jump to point (7,0)
		if(newX == 7 && newY == 0){
			return false;
		}
		
		// Jump to point (7, 1)
		if(newX == 7 && newY == 1){
			return false;
		}
		
		// Jump to point (6,0)
		if(newX == 6 && newY == 0){
			return false;
		}
		
		// Jump to point (6, 1)
		if(newX == 6 && newY == 1){
			return false;
		}
		
		// Jump to point (0,7)
		if(newX == 0 && newY == 7){
			return false;
		}
		
		// Jump to point (0, 6)
		if(newX == 0 && newY == 6){
			return false;
		}
		
		// Jump to point (1,7)
		if(newX == 1 && newY == 7){
			return false;
		}
		
		// Jump to point (1, 6)
		if(newX == 1 && newY == 6){
			return false;
		}
		
		return  pegs[newX][newY] == false
                && pegs[(x + newX) / 2][(y + newY) / 2] == true
                && pegs[x][y] == true;
	}

	private static int getNewX(int x, int k) {
		int newX = x;
		if(k == 1){        	 
			newX =  newX + 2;
		}else if(k == 0){
			newX =  newX - 2;
		}
		return newX;
	}

	private static int getNewY(int y, int k) {
		int newY = y;
		if(k == 2){        	 
			newY =  newY - 2;
		}else if(k == 3){
			newY =  newY + 2;
		}		

		return newY;
	}

	public static void main(String[] args) {
		boolean[][] testPlus = { 
				{ false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false },
				{ false, false, false, true, false, false, false }, 
				{ false, true, true, true, true, true, false },
				{ false, false, false, true, false, false, false },
				{ false, false, false, true, false, false, false },
				{ false, false, false, false, false, false, false } };
		String simpleSolution = getSolution(testPlus);
		System.out.println(simpleSolution);
		if ("(1, 3) -> (3, 3)".equals(simpleSolution) || "(3, 1) -> (3, 3)".equals(simpleSolution)) {
			System.out.println("Your code correctly found the solution to a simple board! 10/10");			
		}
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
