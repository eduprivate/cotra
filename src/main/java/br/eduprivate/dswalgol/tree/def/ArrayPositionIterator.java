package br.eduprivate.dswalgol.tree.def;


import br.eduprivate.dswalgol.net.datastructures.Position;

public class ArrayPositionIterator extends PositionIterator {
    private Position[] position;

    public ArrayPositionIterator(Position[] positions) {
        this.position = position;
    }

}
