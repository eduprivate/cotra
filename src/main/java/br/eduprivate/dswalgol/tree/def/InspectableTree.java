package br.eduprivate.dswalgol.tree.def;

import br.eduprivate.dswalgol.net.datastructures.Position;

public interface InspectableTree extends InspectablePositionalContainer {
    public Position root();

    public Position parent(Position v);

    public PositionIterator children(Position v);

    public boolean isInternal(Position v);

    public boolean isExternal(Position v);

    public boolean isRoot(Position v);
}
