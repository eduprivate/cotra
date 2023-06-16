package br.eduprivate.dswalgol.vector;

public interface Sequence extends List, Vector {
    public Position atRank(int rank) throws BoundaryViolationException;
    public int rankOf(Position position) throws InvalidPositionException;
}
