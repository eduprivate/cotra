package br.eduprivate.dswalgol.tree.def;

import br.eduprivate.dswalgol.net.datastructures.Position;

public class EvaluateExpressionTour extends EulerTour {
    @Override
    public Object execute(IBinaryTree T) {
        super.execute(T);
        System.out.print("The value is: ");
        System.out.println(eulerTour(tree.root()));
        return null;
    }

    protected void visitExternal(Position p, TraversalResult r) {
        r.finalResult = (Integer) p.getElement();
    }

    protected void visitRight(Position p, TraversalResult r) {
        OperationInfo op = (OperationInfo) p.getElement();
        r.finalResult = op.operation((Integer)r.leftResult, (r.rightResult));
    }
}
