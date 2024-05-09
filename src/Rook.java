public class Rook extends ChessPiece{

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn))) return false;
        if (toLine == line && toColumn > column) {
            for (int i = column ; i <= toColumn ; i++) {
                if (chessBoard.board[line][i] != null && chessBoard.board[line][i].getColor().equals(color)) return false;
            }
        }
        if (toLine == line && toColumn < column) {
            for (int i = column ; i >= toColumn ; i--) {
                if (chessBoard.board[line][i] != null && chessBoard.board[line][i].getColor().equals(color)) return false;
            }
        }
        if (toColumn == column && toLine > line) {
            for (int i = line ; i <= toLine ; i++) {
                if (chessBoard.board[i][column] != null && chessBoard.board[i][column].getColor().equals(color)) return false;
            }
        }
        if (toColumn == column && toLine < line) {
            for (int i = line ; i >= toLine ; i--) {
                if (chessBoard.board[i][column] != null && chessBoard.board[i][column].getColor().equals(color)) return false;
            }
        }
        if (Math.abs(toLine - line) > 0 && Math.abs(toColumn - column) > 0) return false;
        if (toLine == line && toColumn == column) return false;
        else return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
