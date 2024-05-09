public class Horse extends ChessPiece{

    public Horse(String color) {
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
        if (line == toLine || column == toColumn) return false;
        if (Math.abs(toLine - line) == Math.abs(toColumn - column)) return false;
        if (Math.abs(toLine - line) > 2 && Math.abs(toColumn - column) > 2) return false;
        else return true;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
