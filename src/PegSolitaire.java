
public class PegSolitaire {
	public static boolean solve(boolean[][] pegs){
		
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
		if (endX < 0 || endX >= pegs.length ||
			 endY < 0 || endY >= pegs[endX].length){
				return false;
		}
		
		if(jumpX == startX && jumpY == startY){
			return false;
		}
		
		startX = jumpX;
		startY = jumpY;
		
		if (solve(board, newX, newY, move)) {
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
