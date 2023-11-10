package br.eduprivate.dswalgol.tree.def;

import br.eduprivate.dswalgol.net.datastructures.Position;

public class InspectableTreeImpl implements InspectableTree {
    @Override
    public PositionIterator positions() {
        return null;
    }

    @Override
    public Position root() {
        return null;
    }

    @Override
    public Position parent(Position v) {
        return null;
    }

    @Override
    public PositionIterator children(Position v) {
        return null;
    }

    @Override
    public boolean isInternal(Position v) {
        return false;
    }

    @Override
    public boolean isExternal(Position v) {
        return false;
    }

    @Override
    public boolean isRoot(Position v) {
        return false;
    }

    public static int depth(InspectableTree T, Position v) {
        if (T.isRoot(v)){
            return 0;
        } else {
            return 1 + depth(T, T.parent(v));
        }
    }

    public static int height1(InspectableTree T) {
        int h = 0;
        PositionIterator positer = T.positions();
        while(positer.hasNext()){
            Position v = positer.nextPosition();
            if (T.isExternal(v)) {
                h = Math.max(h, depth(T, v));
            }
        }
        return h;
    }

    public static int height2(InspectableTree T, Position v) {
        if (T.isExternal(v)){
            return 0;
        } else {
            int h = 0;
            PositionIterator children = T.children(v);
            while(children.hasNext()) {
                h = Math.max(h, height2(T, children.nextPosition()));
            }
            return 1 + h;
        }
    }

    public static String preorderPrint(InspectableTree T, Position v) {
        String s = v.getElement().toString();
        PositionIterator children = T.children(v);
        while(children.hasNext()) {
            s += " " + preorderPrint(T, children.nextPosition());
        }
        return s;
    }

    public static String parentheticRepresentation(InspectableTree T, Position v) {
        String s = v.getElement().toString();
        if (T.isInternal(v)) {
            PositionIterator children = T.children(v);
            s += " { " + parentheticRepresentation(T, children.nextPosition());
            while (children.hasNext()) {
                s += ", " + parentheticRepresentation(T, children.nextPosition());

            }
            s += " }";
        }
        return s;
    }

    public static String postorderPrint(InspectableTree T, Position v) {
        String s = "";
        PositionIterator children = T.children(v);
        while (children.hasNext()){
            s += postorderPrint(T, children.nextPosition());
        }
        s += v.getElement();
        return s;
    }

    public static int diskSpace(InspectableTree T, Position v) {
        int s = size(v);
        PositionIterator children = T.children(v);
        while (children.hasNext()) {
            s += diskSpace(T, children.nextPosition());
        }
        if(T.isInternal(v)){
            System.out.print(name(v)+": " +s);
        }
        return s;
    }

    private static boolean name(Position v) {
        return false;
    }

    private static int size(Position v) {
        return 0;
    }
}
