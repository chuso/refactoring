package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Game {

	private Board board;

	private Turn turn;

	public Game() {
		this.turn = new Turn();
		this.board = new Board();
		for (int i = 0; i < this.board.getDimension(); i++) {
			for (int j = 0; j < this.board.getDimension(); j++) {
				Coordinate coordinate = new Coordinate(i, j);
				Piece piece = this.getInitialPiece(coordinate);
				if (piece != null) {
					this.board.put(coordinate, piece);
				}
			}
		}
	}

	private Piece getInitialPiece(Coordinate coordinate) {
		if (coordinate.isBlack()) {
			final int row = coordinate.getRow();
			Color color = null;
			if (row <= 2) {
				color = Color.BLACK;
			} else if (row >= 5) {
				color = Color.WHITE;
			}
			if (color != null) {
				return new Piece(color);
			}
		}
		return null;
	}

	Error move(Movement movement) {
		if (!movement.isValid()) {
			return Error.OUT_COORDINATE;
		}
		if (board.isEmpty(movement.getOrigin())) {
			return Error.EMPTY_ORIGIN;
		}
		Color color = this.board.getColor(movement.getOrigin());
		if (this.turn.getColor() != color) {
			return Error.OPPOSITE_PIECE;
		}
		if (!this.board.isEmpty(movement.getTarget())) {
			return Error.NOT_EMPTY_TARGET;
		}
		Piece piece = this.board.getPiece(movement.getOrigin());
		Error pieceError = piece.validate(movement, this.board);
		if (pieceError != null) {
			return pieceError;
		}
		Coordinate coordinateToRemove = piece.getCoordinateToRemove(movement, this.board);
		if (coordinateToRemove != null) {
			this.board.remove(coordinateToRemove);
		}
		this.board.move(movement);
		this.turn.change();
		return null;
	}

	Color getColor(Coordinate coordinate) {
		return this.board.getColor(coordinate);
	}

	@Override
	public String toString() {
		return this.board + "\n" + this.turn;
	}

	Color getColor() {
		return this.turn.getColor();
	}

	Piece getPiece(Coordinate coordinate) {
		return this.board.getPiece(coordinate);
	}

	boolean isBlocked() {
		return this.board.getPieces(this.turn.getColor()).isEmpty();
	}

	int getDimension() {
		return this.board.getDimension();
	}

}