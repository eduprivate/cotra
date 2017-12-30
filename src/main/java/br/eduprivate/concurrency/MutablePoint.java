package br.eduprivate.concurrency;


/**
 * MutablePoint
 * <p/>
 * Mutable Point class similar to java.awt.Point
 *
 */
@NotThreadSafe
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
