package es.urjccode.mastercloudapps.adcs.draughts.models;

class Movement {

    public Coordinate origin;

    public Coordinate target;

    public Movement(Coordinate origin, Coordinate target) {
        this.origin = origin;
        this.target = target;
    }

    public int getRowDifference() {
        return origin.getRow() - target.getRow();
    }

    public int diagonalDistance() {
        return origin.diagonalDistance(target);
    }

}
