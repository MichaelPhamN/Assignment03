
public class PegCount {
	public static int pegCount(boolean[][] pegs){
		int startX = 0, startY = 0, count = 0;
		return pegCount(pegs, startX, startY, count);			
	}
	
	public static int pegCount(boolean[][] pegs, int newX, int newY, int count){
		
		// If board is solved
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] testStandard = { 
				{ false, false, true, true, true, false, false },
				{ false, false, true, true, true, false, false }, 
				{ true, true, true, true, true, true, true },
				{ true, true, true, false, true, true, true }, 
				{ true, true, true, true, true, true, true },
				{ false, false, true, true, true, false, false },
				{ false, false, true, true, true, false, false } };
		System.out.println(pegCount(testStandard));
		
	}

}
