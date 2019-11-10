package es.urjccode.mastercloudapps.adcs.draughts.models;

class Movement {

    private Coordinate origin;

    private Coordinate target;

    Movement(int originRow, int originColumn, int targetRow, int targetColumn) {
        this(
            new Coordinate(originRow, originColumn),
            new Coordinate(targetRow, targetColumn)
        );
    }

    Movement(Coordinate origin, Coordinate target) {
        this.origin = origin;
        this.target = target;
    }

    Coordinate getOrigin() {
        return origin;
    }

    Coordinate getTarget() {
        return target;
    }

    boolean isValid() {
        return origin.isValid() && target.isValid();
    }

    boolean isDiagonal() {
        return origin.isDiagonal(target);
    }

    int getRowDifference() {
        return origin.getRow() - target.getRow();
    }

    int diagonalDistance() {
        return origin.diagonalDistance(target);
    }

    Coordinate betweenDiagonal() {
        return origin.betweenDiagonal(target);
    }

}
