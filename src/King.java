public class King extends ChessPiece{
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(chessBoard.checkPos(toColumn) && chessBoard.checkPos(toLine))) return false;
        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color)) return false;
        if (Math.abs(toLine - line) > 1 || Math.abs(toColumn - column) > 1) return false;
        if (toLine == line && toColumn == column) return false;
        else return true;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column){
        for (int i = 0 ; i < 8 ; i++) {
            for (int j = 0 ; j < 8 ; j++) {
                if (board.board[i][j] != null) {
                    if (!board.board[i][j].getColor().equals(color) && board.board[i][j].canMoveToPosition(board, i , j , line , column)) {
                        return true;
                    }
                }else return false;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
