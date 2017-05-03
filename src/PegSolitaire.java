
public class PegSolitaire {
	public static boolean solve(boolean[][] pegs){
		if(solve(pegs,3,3,0,0,0,0,1)){
			return true;
		}
		return false;
	}
	
	public static boolean solve(boolean[][] pegs, int startX, int startY, int jumpX, int jumpY, int endX, int endY, int move){
		if (pegs.length*pegs[0].length == move) {
			return true; // We have solved it!
		}
		
		move++; // Next move
		
		// Jump(x - 1 , y), check End(x - 2, y)
		if (tryMove(pegs, startX, startY, startX - 1, startY, startX - 2, startY, move)) {
			return true;
		}
		
		// Jump(x - 1 , y), check End(x + 2, y)
		if (tryMove(pegs, startX, startY, startX - 1, startY, startX + 2, startY, move)) {
			return true;
		}
		
		// Jump(x - 1 , y), check End(x, y - 2)
		if (tryMove(pegs, startX, startY, startX - 1, startY, startX, startY - 2, move)) {
			return true;
		}

		// Jump(x - 1 , y), check End(x, y + 2)
		if (tryMove(pegs, startX, startY, startX - 1, startY, startX, startY + 2, move)) {
			return true;
		}
		
		// Jump(x + 1 , y), check End(x - 2, y)
		if (tryMove(pegs, startX, startY, startX + 1, startY, startX - 2, startY, move)) {
			return true;
		}
		
		// Jump(x + 1 , y), check End(x + 2, y)
		if (tryMove(pegs, startX, startY, startX + 1, startY, startX + 2, startY, move)) {
			return true;
		}
		
		// Jump(x + 1 , y), check End(x, y - 2)
		if (tryMove(pegs, startX, startY, startX + 1, startY, startX, startY - 2, move)) {
			return true;
		}

		// Jump(x + 1 , y), check End(x, y + 2)
		if (tryMove(pegs, startX, startY, startX + 1, startY, startX, startY + 2, move)) {
			return true;
		}
		
		// Jump(x, y - 1), check End(x - 2, y)
		if (tryMove(pegs, startX, startY, startX, startY - 1, startX - 2, startY, move)) {
			return true;
		}
		
		// Jump(x, y - 1), check End(x + 2, y)
		if (tryMove(pegs, startX, startY, startX, startY - 1, startX + 2, startY, move)) {
			return true;
		}
		
		// Jump(x, y - 1), check End(x, y - 2)
		if (tryMove(pegs, startX, startY, startX, startY - 1, startX, startY - 2, move)) {
			return true;
		}

		// Jump(x, y - 1), check End(x, y + 2)
		if (tryMove(pegs, startX, startY, startX, startY - 1, startX, startY + 2, move)) {
			return true;
		}
		
		// Jump(x, y + 1), check End(x - 2, y)
		if (tryMove(pegs, startX, startY, startX, startY + 1, startX - 2, startY, move)) {
			return true;
		}
		
		// Jump(x, y + 1), check End(x + 2, y)
		if (tryMove(pegs, startX, startY, startX, startY + 1, startX + 2, startY, move)) {
			return true;
		}
		
		// Jump(x, y + 1), check End(x, y - 2)
		if (tryMove(pegs, startX, startY, startX, startY +  1, startX, startY - 2, move)) {
			return true;
		}

		// Jump(x, y + 1), check End(x, y + 2)
		if (tryMove(pegs, startX, startY, startX, startY + 1, startX, startY + 2, move)) {
			return true;
		}
		
		return false;
	}
	
	private static boolean tryMove(boolean[][] pegs, int startX, int startY, int jumpX, int jumpY, int endX, int endY, int move)
	{	
		if (jumpX < 0 || jumpX >= pegs.length ||
				jumpY < 0 || jumpY >= pegs[jumpX].length){
				return false;
		}
		
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
		
		if(jumpX == startX && jumpY == startY){
			return false;
		}

		if (endX >= 0 && endX < pegs.length &&
				endY >= 0 && endY < pegs[endX].length){			
			if(pegs[endX][endY] == false && pegs[(startX + endX) / 2][(startY + endY) / 2] == true
		            && pegs[startX][startY] == true)
			{					
				System.exit(0);
					pegs[endX][endY] = true;
					pegs[startX][startY] = false;
					pegs[(startX + endX) / 2][(startY + endY) / 2] = false;					
			}
		}
		
		startX = jumpX;
		startY = jumpY;
		
		if (solve(pegs, startX, startY, 0, 0, 0, 0, move)) {
			return true;
		}
		
		if (endX < 0 || endX >= pegs.length ||
				 endY < 0 || endY >= pegs[endX].length){
					return false;
		}
		
		jumpX = startX;
		jumpY = startY;
		
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] testSimple = { { false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false },
				{ false, true, true, false, false, false, false },
				{ false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false } };
		solve(testSimple,3,3,0,0,0,0,1);
	}

}
