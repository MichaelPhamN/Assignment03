  
   
    import java.util.Arrays;
   
  
    public class Board {
           
            private static final int OCCUPIED = 1;
           
            private static final int EMPTY = 2;
   
            private static final int RIGHT = 0;
            private static final int UP = 1;
            private static final int LEFT = 2;
            private static final int DOWN = 3;
           
           
            private static int [] directions = {RIGHT, UP, LEFT, DOWN};
           
           
           int [] [] board = {
                            {0, 0, 1, 1, 1, 0, 0},
                            {0, 0, 1, 1, 1, 0, 0},
                            {1, 1, 1, 1, 1, 1, 1},
                            {1, 1, 1, 2, 1, 1, 1},
                            {1, 1, 1, 1, 1, 1, 1},
                            {0, 0, 1, 1, 1, 0, 0},
                            {0, 0, 1, 1, 1, 0, 0}
//                            {0, 0, 2, 2, 2, 0, 0},
//                            {0, 0, 2, 1, 2, 0, 0},
//                            {2, 2, 1, 1, 1, 2, 2},
//                            {2, 2, 2, 1, 2, 2, 2},
//                            {2, 2, 2, 1, 2, 2, 2},
//                            {0, 0, 2, 2, 2, 0, 0},
//                            {0, 0, 2, 2, 2, 0, 0}
            };
           int [] [] numberBoard = {
                   {0, 0, 0, 1, 2, 0, 0},
                   {0, 0, 3, 4, 5, 0, 0},
                   {6, 7, 8, 9, 10, 11, 12},
                   {13, 14, 15, 16, 17, 18, 19},
                   {20, 21, 22, 23, 24, 25, 26},
                   {0, 0, 27, 28, 29, 0, 0},
                   {0, 0, 30, 31, 32, 0, 0}
           };
   
          
           
            public void clearField(int x, int y) {
                    board[x][y] = EMPTY;
            }
   
            public void setPeg(int x, int y) {
                    board[x][y] = OCCUPIED;
            }
   
           
            public void copy(Board source, Board target) {
                    for (int x = 0; x < 7; x++) {
                   for (int y = 0; y < 7; y++) {
                               target.board[x][y] = source.board[x][y];
                       }
                    }
            }
           
           
            private boolean isValidMove(int x, int y, int newX, int newY) {
                    return 0 <= x && x < board.length
                            && 0 <= y && y < board[x].length
                            && 0 <= newX && newX < board.length
                            && 0 <= newY && newY < board[newX].length
                            && board[newX][newY] == EMPTY
                            && board[(x + newX) / 2][(y + newY) / 2] == OCCUPIED
                            && board[x][y] == OCCUPIED;
                          
            }
           
           
           public boolean jump(int x, int y, int direction) {
                    int newX = getNewX(x, direction);
                    int newY = getNewY(y, direction);
   
                    if ( isValidMove(x, y, newX, newY)) {
                            setPeg(newX, newY);
                           clearField(x, y);
                           clearField((x + newX) / 2, (y + newY) / 2);
                           
                            return true;
                    }
                   
                    return false;
           }
           
   
           
           public void goBack(int x, int y, int direction) {
                    int newX = getNewX(x, direction);
                   int newY = getNewY(y, direction);
                   
                    clearField(newX, newY);
                    setPeg(x, y);
                    setPeg((x + newX) / 2, (y + newY) / 2);
            }
           
           private int getNewX(int x, int direction) {
                   int newX = x;
                   switch (direction) {
                    case RIGHT: newX += 2;
                                break;
                   case LEFT: newX -= 2;
                    }
                    return newX;
            }
           
            private int getNewY(int y, int direction) {
                    int newY = y;
                   
                    switch (direction) {
                    case UP: newY -= 2;
                                    break;
                    case DOWN: newY += 2;
                    }
                  
                   return newY;
           }
           
            public void print() {
                    for (int x = 0; x < board.length; x++) {
                            for (int y = 0; y < board[x].length; y++) {
                                   System.out.print(board[x][y]);
                            }
                            System.out.println();
                    }
                    System.out.println();
            }
           
           
            public boolean isOccupied(int x, int y) {
                    return board[x][y] == OCCUPIED;
            }
   
            public int [] getDirections() {
                    return Arrays.copyOf(directions, directions.length); // JDK 1.6 nötig
            }
    }