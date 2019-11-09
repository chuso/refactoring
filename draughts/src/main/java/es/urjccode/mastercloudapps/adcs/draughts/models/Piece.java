package es.urjccode.mastercloudapps.adcs.draughts.models;

import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class Piece {

	private Color color;

	Piece(Color color){
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	boolean isAdvanced(Coordinate origin, Coordinate target) {
		int difference = origin.getRow() - target.getRow();
		if (color == Color.WHITE){
			return difference>0;
		}
		return difference<0;
	}

	Error validate(Coordinate origin, Coordinate target, PieceProvider pieceProvider) {
		if (!origin.isDiagonal(target)) {
			return Error.NOT_DIAGONAL;
		}
		if (!this.isAdvanced(origin, target)) {
			return Error.NOT_ADVANCED;
		}
		if (origin.diagonalDistance(target) >= 3) {
			return Error.BAD_DISTANCE;
		}
		if (origin.diagonalDistance(target) == 2) {
			Coordinate between = origin.betweenDiagonal(target);
			if (pieceProvider.getPiece(between) == null) {
				return Error.EATING_EMPTY;
			}
		}
		return null;
	}

	Coordinate getCoordinateToRemove(Coordinate origin, Coordinate target, PieceProvider pieceProvider) {
		assert this.validate(origin, target, pieceProvider) == null;
		if (origin.diagonalDistance(target) == 2) {
			return origin.betweenDiagonal(target);
		}
		return null;
	}

}