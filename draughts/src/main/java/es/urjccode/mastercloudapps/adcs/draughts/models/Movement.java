package es.urjccode.mastercloudapps.adcs.draughts.models;

class Movement {

    public Coordinate origin;

    public Coordinate target;

    Movement(Coordinate origin, Coordinate target) {
        this.origin = origin;
        this.target = target;
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
