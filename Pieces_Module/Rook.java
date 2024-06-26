package Pieces_Module;

public class Rook extends Piece{
    public Rook(int x, int y, boolean isWhite, String name){
        super(x, y, isWhite, name);
    }

    @Override
    public boolean canMove(int destX, int destY, Piece[][] board) {
        if(!validMove(destX, destY, board)) {
            return false;
        }

        //Queen specific movement validation
        /*int xDiff = Math.abs(destX - x);
        int yDiff = Math.abs(destY - y);*/

        //Check if the move is along a column, row, or diagonal
        if(x == destX || y == destY) {
            //Check is the path destination is clear
            return isPathClear(x, y, destX, destY, board);
        }

        return false;
    }

    private boolean isPathClear(int startX, int startY, int destX, int destY, Piece[][] board) {
        int xStep = Integer.compare(destX, startX); // Determine the step direction for x
        int yStep = Integer.compare(destY, startY); // Determine the step direction for y
    
        int currentX = startX + xStep;
        int currentY = startY + yStep;
    
        while (currentX != destX || currentY != destY) {
            if (board[currentX][currentY] != null) {
                return false; // Path is blocked
            }
            currentX += xStep;
            currentY += yStep;
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return name;
    }
}
