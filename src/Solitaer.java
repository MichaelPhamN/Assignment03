public class Solitaer {
   
           
            private Board board = new Board();
           
          
            int sol=Heuristic(board);
           private Board [] solution= new Board[sol+1];
   
           private int [] directions = board.getDirections();
           
          
            public Solitaer() {
//            	sol=Heuristic();
//            	solution = new Board[sol+1];
                    for (int i = 0; i < solution.length; i++) {
                            solution[i] = new Board();
                    }
           }
      
            public static void main(String[] args) {
                   Solitaer solitaer = new Solitaer();
                  
                   long t1 = System.currentTimeMillis();
                    if (solitaer.finalSol(1)) {
                           System.out.println("Solution found in " + (System.currentTimeMillis() - t1) + " [ms]");
   
                            solitaer.solvePuzzle();
                    } else {
                            System.out.println("No solution found!?");
                    }
                    solitaer.printPath();
            }
   
          
            public boolean finalSol(int step) {
//            	System.out.println(sol);
                    for (int x = 0; step <= sol && x < 7; x++) {
                     for (int y = 0; y < 7; y++) {
                       for (int direction : directions) {
                        if (board.jump(x, y, direction)) {
                        	board.copy(board, solution[step]);
//                            if (! (step >= sol && board.isOccupied(3, 3))) {
                        	if (!((Heuristic(board)==0) && board.isOccupied(3, 3))) {
                              if ( finalSol(step + 1)) {
                                                            	
                                    return true;
                                     } else {
                                     board.goBack(x, y, direction);
                                           }
                                     } else {
                                         return true;
                                          }
                                     }
                                }
                         }                      
                  }
                   
                    return false;
            }
   
           
           
            public int Heuristic(Board board) {//calculate Heuistic Cost
//            	System.out.println("**************************");	
                int cost = 0;
                for (int x = 0; x < 7; x++) {
                    for (int y = 0; y < 7; y++) {
                    	if(board.board[x][y]==1)
                    	{
                    		cost++;
//                    		System.out.println(cost);
                    	}
                       
                    }
                }
                return cost-1;
            }
          
       
            int a, b, count;
            public void printPath()
            {
            	Board[] pathBoard=solution;
            	for(int i=0;i<pathBoard.length-1;i++)
            	{
            	
            		count=0;
            		b=-1;
            		a=0;
            	for (int x = 0; x < 7; x++) {
                    for (int y = 0; y < 7; y++) {
            	if(pathBoard[i].board[x][y]==1&&pathBoard[i+1].board[x][y]==2)
            	{
            		
            		if(x-2>=0)
            		{
//            			System.out.println("1----"+x+"-----");
            		if(pathBoard[i].board[x-2][y]!=pathBoard[i+1].board[x-2][y])
            				{
//            			System.out.println("1----!"+x+"-----");
            			b=board.numberBoard[x-2][y];
            				}
            		}
            		
            			if(x+2<=6)
            			{
//            				System.out.println("2----"+x+"-----");
            			if(pathBoard[i].board[x+2][y]!=pathBoard[i+1].board[x+2][y])
        				{
//            				System.out.println("1----!"+x+"-----");
        			b=board.numberBoard[x+2][y];
        				}
            			}
        		
        			if(y-2>=0)
        			{
//        				System.out.println("3----"+y+"-----");
        			if(pathBoard[i].board[x][y-2]!=pathBoard[i+1].board[x][y-2])
    				{
//        				System.out.println("1----!"+y+"-----");
    			b=board.numberBoard[x][y-2];
    				}
        			}
    		
    			if(y+2<=6)
    			{
//    				System.out.println("4----"+y+"-----");
    			if(pathBoard[i].board[x][y+2]!=pathBoard[i+1].board[x][y+2])
				{
//    				System.out.println("1----!"+y+"-----");
			b=board.numberBoard[x][y+2];
				}
    			}
            		
            		if(b!=-1)
            		{
            			a=board.numberBoard[x][y];
            	count=count+1;
            	break;
            		}
            		
            	}
            	if(count==1)
            		break;
                }  
                    if(count==1)
                		break;

            	}
            	
            	System.out.print("<"+a+","+b+">"+" ");
            	}
            	
            }
            private void solvePuzzle() {
                    for (int i = 0; i < solution.length; i++) {
                            solution[i].print();
                    }
                   
            }
    }