package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.ArrayList;
import java.util.List;

class Board implements PieceProvider {

    private static final int DIMENSION = 8;

    private Square[][] squares;

    Board() {
        this.squares = new Square[this.getDimension()][this.getDimension()];
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                this.squares[i][j] = new Square();
            }
        }
    }

    private Square getSquare(Coordinate coordinate){
        assert coordinate!=null && coordinate.isValid();
        return this.squares[coordinate.getRow()][coordinate.getColumn()];
    }

    void put(Coordinate coordinate, Piece piece){
        assert piece != null;
        this.getSquare(coordinate).put(piece);
    }

    Piece remove(Coordinate coordinate) {
        assert this.getPiece(coordinate) != null;
        return this.getSquare(coordinate).remove();
    }

    void move(Movement movement) {
        this.put(movement.getTarget(), this.remove(movement.getOrigin()));
    }

    public Piece getPiece(Coordinate coordinate) {
        return this.getSquare(coordinate).getPiece();
    }

    boolean isEmpty(Coordinate coordinate) {
        return this.getSquare(coordinate).isEmpty();
    }
    
    Color getColor(Coordinate coordinate) {
        return this.getSquare(coordinate).getColor();
    }

    List<Piece> getPieces(Color color) {
        List<Piece> pieces = new ArrayList<Piece>();
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                pieces.add(this.getPiece(new Coordinate(i, j)));
            }
        }
		return pieces;
	}
    
    int getDimension() {
		return Board.DIMENSION;
	}

}