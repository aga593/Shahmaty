public class Bishop extends ChessPiece{

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn))) return false;
        if (toLine > line && toColumn > column) {
            for (int i = line ; i <= toLine ; i++) {
                for (int j = column ; j <= toColumn ; j++ ) {
                    if (chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j] != null) return false;
                }
            }
        }
        if (toLine < line && toColumn > column) {
            for (int i = line ; i >= toLine ; i--) {
                for (int j = column ; j <= toColumn ; j++ ) {
                    if (chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j] != null) return false;
                }
            }
        }
        if (toLine > line && toColumn < column) {
            for (int i = line ; i <= toLine ; i++) {
                for (int j = column ; j >= toColumn ; j-- ) {
                    if (chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j] != null) return false;
                }
            }
        }
        if (toLine < line && toColumn < column) {
            for (int i = line ; i >= toLine ; i--) {
                for (int j = column ; j >= toColumn ; j-- ) {
                    if (chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j] != null) return false;
                }
            }
        }
        if (Math.abs(toLine - line) != Math.abs(toColumn - column)) return false;
        if (toLine == line && toColumn == column) return false;
        else return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
