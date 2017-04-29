import java.util.Arrays;

public class KnightsTour {

	private static boolean tryMove(int[][] board, int newX, int newY, int move) {
		if (newX < 0 || newX >= board.length || 
			newY < 0 || newY >= board[newX].length) {
			return false; // Move would be out of bounds
		}
		if (board[newX][newY] != 0) {
			// Already moved there, not allowed
			return false;
		}
		// Make the move (since we can)
		board[newX][newY] = move;
		// Recursively try to solve from here
		if (solve(board, newX, newY, move)) {
			return true;
		}
		// Solve didn't succeed
		board[newX][newY] = 0; // Undo the move
		return false; // Unsuccessful
	}
	
	public static boolean solve(int[][] board, int x, int y, int move) {
		if (board.length*board[0].length == move) {
			return true; // We have solved it!
		}
		move++; // Next move
		// x - 2, y - 1
		if (tryMove(board, x - 2, y - 1, move)) {
			return true;
		}
		// x - 2, y + 1
		if (tryMove(board, x - 2, y + 1, move)) {
			return true;
		}
		// x - 1, y - 2
		if (tryMove(board, x - 1, y - 2, move)) {
			return true;
		}
		// x - 1, y + 2
		if (tryMove(board, x - 1, y + 2, move)) {
			return true;
		}

		// x + 2, y - 1
		if (tryMove(board, x + 2, y - 1, move)) {
			return true;
		}
		// x + 2, y + 1
		if (tryMove(board, x + 2, y + 1, move)) {
			return true;
		}
		// x + 1, y - 2
		if (tryMove(board, x + 1, y - 2, move)) {
			return true;
		}
		// x + 1, y + 2
		if (tryMove(board, x + 1, y + 2, move)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] board = new int[n][n];
		board[0][0] = 1;
		solve(board, 0, 0, 1);
//		for(int i = 0; i< board.length; i++){
//			for(int j = 0; j < board[i].length; j++){				
//				System.out.print(board[i][j] + " ");								
//			}
//			System.out.println();
//		}
//		System.exit(0);
//		for (int x = 0; x < n; x++) {
//			for (int y = 0; y < n; y++) {
//				// Start the knight at (x, y)
//				board[x][y] = 1;
//				if (solve(board, x, y, 1)) {
//					for (int i = 0; i < board.length; i++) {
//						System.out.println(Arrays.toString(board[i]));
//					}
//					return;
//				} else {
//					board[x][y] = 0;
//				}
//			}
//		}
		

	}

}
