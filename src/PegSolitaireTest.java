import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Test of CS 143 Assignment 3 by Martin Hock (Version of 7:55 AM 4/25/2017)
 * 
 * You may only use this code as a student of Martin Hock, CS 143 Spring 2017.
 */

public class PegSolitaireTest {

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

	public static void main(String[] args) throws NoSuchAlgorithmException {
		int points = 0;
		try {
			try {
				String source = new String(Files.readAllBytes(Paths.get("src" + File.separator + "PegSolitaire.java")));
				boolean ec = true;
				if (source.matches("(?s).*\\sfor[\\s\\(].*")) {
					System.out.println(
							"Detected 'for' statement in your program! This is OK but remove all 'for's and 'while's for extra credit.");
					ec = false;
				}
				if (source.matches("(?s).*\\swhile[\\s\\(].*")) {
					System.out.println(
							"Detected 'while' statement in your program! This is OK but remove all 'for's and 'while's for extra credit.");
					ec = false;
				}
				if (ec) {
					System.out.println("Detected no 'for' or 'while'! 2 points of extra credit.");
					points += 2;
				}
			} catch (Exception e) {
				System.out.println(
						"Couldn't find PegSolitaire.java! Run this from the same Eclipse project as PegSolitaire with no package.");
			}

			boolean[][] testSimple = { 
					{ false, false, false, false, false, false, false },
					{ false, false, false, false, false, false, false },
					{ false, false, false, false, false, false, false },
					{ false, true, true, false, false, false, false },
					{ false, false, false, false, false, false, false },
					{ false, false, false, false, false, false, false },
					{ false, false, false, false, false, false, false } };
			String simpleSolution = getSolution(testSimple);
			if ("(1, 3) -> (3, 3)".equals(simpleSolution) || "(3, 1) -> (3, 3)".equals(simpleSolution)) {
				System.out.println("Your code correctly found the solution to a simple board! 10/10");
				points += 10;
			} else {
				System.out.println(
						"Your code couldn't find a solution to a simple board requiring one move, so I'm exiting now with 0 points.");
				System.out.println("Solution seen: "+simpleSolution);
				return;
			}
			boolean[][] testUnsolvable = { 
					{ false, false, false, false, false, false, false },
					{ false, false, true, true, false, false, false },
					{ false, true, false, false, false, false, false },
					{ false, false, true, false, false, false, false },
					{ false, false, false, false, false, false, false },
					{ false, false, false, false, false, false, false },
					{ false, false, false, false, false, false, false } };
			String unsolvableSolution = getSolution(testUnsolvable);
			if (unsolvableSolution != null) {
				System.out.println(
						"You found a solution to an unsolvable board! You are either allowing moves into the corners or have some other bugs. 0/10");
			} else {
				System.out.println("You didn't find a solution to a simple unsolvable board! 10/10");
				points += 10;
			}
			System.out.println("Attempting to solve 'plus' board:");
			boolean[][] testPlus = { { false, false, false, false, false, false, false },
					{ false, false, false, true, false, false, false },
					{ false, false, false, true, false, false, false }, { false, true, true, true, true, true, false },
					{ false, false, false, true, false, false, false },
					{ false, false, false, true, false, false, false },
					{ false, false, false, false, false, false, false } };
			String plusSolution = getSolution(testPlus);
			if (plusSolution != null) {
				String plusSolution1 = "(3, 2) -> (3, 0), (3, 4) -> (3, 2), (1, 3) -> (3, 3), (3, 3) -> (3, 1), (3, 0) -> (3, 2), (5, 3) -> (3, 3), (3, 2) -> (3, 4), (3, 5) -> (3, 3)";
				String plusSolution2 = "(2, 3) -> (0, 3), (4, 3) -> (2, 3), (3, 1) -> (3, 3), (3, 3) -> (1, 3), (0, 3) -> (2, 3), (3, 5) -> (3, 3), (2, 3) -> (4, 3), (5, 3) -> (3, 3)";
				if (plusSolution1.equals(plusSolution)) {
					System.out.println("Correct solution to the plus board! 30/30");
					points += 30;
				} else if (plusSolution2.equals(plusSolution)) {
					System.out.println("It looks like you're scanning column by column instead of row by row! 25/30");
					points += 25;
				} else {
					System.out.println("Unexpected solution! 0/30");
					System.out.println(plusSolution);
				}
			} else {
				System.out.println("Your code didn't find a solution! 0/30");
			}
			System.out.println("Attempting to solve 'standard' board:");
			boolean[][] testStandard = { { false, false, true, true, true, false, false },
					{ false, false, true, true, true, false, false }, { true, true, true, true, true, true, true },
					{ true, true, true, false, true, true, true }, { true, true, true, true, true, true, true },
					{ false, false, true, true, true, false, false },
					{ false, false, true, true, true, false, false } };
			String standardSolution = getSolution(testStandard);
			byte[] standardSolution1 = { -78, 17, -12, 124, -65, 94, -9, 38, -123, 104, -68, 64, 98, 0, -57, 24 };
			byte[] standardSolution2 = { 87, -106, -18, 77, 33, 116, -74, -108, 85, 66, -15, -124, 101, 10, -2, 92 };
			byte[] standardSolution3 = { 125, 111, -98, -4, -124, -61, -44, -65, -80, -124, -96, -1, 61, 79, -124, 21 };
			byte[] standardSolution4 = { 74, -39, -96, 8, -84, -123, 39, 104, -28, 46, -24, 48, -37, 20, -37, 90 };
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] standardBytes = md5.digest(standardSolution.getBytes());
			if (Arrays.equals(standardBytes, standardSolution1)) {
				System.out.println("Correct solution to the standard board! 25/25");
				points += 25;
			} else if (Arrays.equals(standardBytes, standardSolution2)) {
				System.out.println("It looks like you're scanning column by column instead of row by row! 20/25");
				points += 20;
			} else if (Arrays.equals(standardBytes, standardSolution3)) {
				System.out.println("It looks like you're not using the up-down-left-right order! 20/25");
				points += 20;
			} else if (Arrays.equals(standardBytes, standardSolution4)) {
				System.out.println(
						"It looks like you're scanning column by column instead of row by row and not using the up-down-left-right order!");
				points += 15;
			} else {
				System.out.println("Unexpected solution! 0/25");
				System.out.println(standardSolution);
				System.out.println(Arrays.toString(standardBytes));
			}
			System.out.println("Attempting to solve 'rhombus' board:");
			boolean[][] testRhombus = { { false, false, false, true, false, false, false },
					{ false, false, true, true, true, false, false }, { false, true, true, true, true, true, false },
					{ true, true, true, false, true, true, true }, { false, true, true, true, true, true, false },
					{ false, false, true, true, true, false, false },
					{ false, false, false, true, false, false, false } };
			String rhombusSolution = getSolution(testRhombus);
			byte[] rhombusBytes = md5.digest(rhombusSolution.getBytes());
			byte[] rhombusSolution1 = { 27, 122, -43, -15, 42, -15, -124, -17, 58, 91, -50, -126, 44, -124, -64, 97 };
			if (Arrays.equals(rhombusBytes, rhombusSolution1)) {
				System.out.println("Correct solution to the rhombus board! 25/25");
				points += 25;
			} else {
				System.out.println(
						"Unexpected solution! (Note, this one is very picky - if you got partial credit above, fix your solution!) 0/25");
				System.out.println(rhombusSolution);
				System.out.println(Arrays.toString(rhombusBytes));
			}
		} finally {
			System.out.println("Currently does not check for the 'difficult' extra credit!");
			System.out.println("Please note the academic dishonesty policy can affect your score!");
			System.out.println("Tentative total: " + points + "/100");
		}
	}

}
