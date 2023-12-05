package br.eduprivate.dswalgol.priority_queue;

public class Point2D {
    protected int xc, yc;
    public Point2D(int x, int y) {
        xc = x;
        yc = y;
    }

    public int getX() {
        return xc;
    }

    public void setX(int xc) {
        this.xc = xc;
    }

    public int getY() {
        return yc;
    }

    public void setY(int yc) {
        this.yc = yc;
    }
}
