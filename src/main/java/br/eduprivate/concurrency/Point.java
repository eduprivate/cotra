package br.eduprivate.concurrency;


/**
 * Point
 * <p/>
 * Immutable Point class used by DelegatingVehicleTracker
 *
 */
@Immutable
public class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
