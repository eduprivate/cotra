package br.eduprivate.dswalgol.tree.def;

import br.eduprivate.dswalgol.net.datastructures.Position;

public interface InspectableBinaryTree extends InspectableTree {
    public Position leftChild(Position v);

    public Position rightChild(Position v);

    public Position sibling(Position v);
}
