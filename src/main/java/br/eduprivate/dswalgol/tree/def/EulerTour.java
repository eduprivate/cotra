package br.eduprivate.dswalgol.tree.def;

import br.eduprivate.dswalgol.net.datastructures.Position;

public abstract class EulerTour {
    protected InspectableBinaryTree tree;

    public Object execute(IBinaryTree T) {
        tree = T;
        return null;
    }

    protected Object eulerTour(Position p) {
        TraversalResult r = initResult();
        if (tree.isExternal(p)){
            visitExternal(p, r);
        } else {
            visitLeft(p, r);
            r.leftResult = eulerTour(tree.leftChild(p));
            visitBelow(p, r);
            r.rightResult = eulerTour(tree.rightChild(p));
            visitRight(p, r);
        }
        return result(r);
    }

    protected void visitExternal(Position p, TraversalResult r){}
    protected void visitLeft(Position p, TraversalResult r){}

    protected void visitBelow(Position p, TraversalResult r){}

    protected void visitRight(Position p, TraversalResult r){}

    protected TraversalResult initResult(){return new TraversalResult();}

    protected Object result(TraversalResult r){return r.finalResult;}
}
