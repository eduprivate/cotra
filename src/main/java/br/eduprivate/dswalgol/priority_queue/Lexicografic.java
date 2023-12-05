package br.eduprivate.dswalgol.priority_queue;

import br.eduprivate.effective.c3.item8.Point;

public class Lexicografic<E extends Point2D> {
    public int compare(E a, E b) {
        if (a.getX() != b.getX()) {
            return b.getX() - a.getX();
        } else {
            return b.getY() - a.getY();
        }
    }
}
