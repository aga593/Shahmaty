public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn))) return false;
        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color)) return false;
        if (color.equals("White") && line == 1 && toLine - line > 2) return false;
        if (color.equals("Black") && line == 6 && toLine - line < -2) return false;
        if (color.equals("Black") && toLine - line > 0) return false;
        if (color.equals("White") && toLine - line < 0) return false;
        if (toColumn != column) return false;
        else return true;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
