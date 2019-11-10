package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Movement {

    private Coordinate origin;

    private Coordinate target;

    public Movement(int originRow, int originColumn, int targetRow, int targetColumn) {
        this(
            new Coordinate(originRow, originColumn),
            new Coordinate(targetRow, targetColumn)
        );
    }

    public Movement(Coordinate origin, Coordinate target) {
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
        assert origin != null && target != null;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movement other = (Movement) obj;
        if (!origin.equals(other.origin))
            return false;
        if (!target.equals(other.target))
            return false;
        return true;
    }

}
