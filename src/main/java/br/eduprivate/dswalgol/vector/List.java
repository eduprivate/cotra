package br.eduprivate.dswalgol.vector;

public interface List {
    int size();
    boolean isEmpty();
    boolean isFirst(Position p) throws InvalidPositionException;
    boolean isLast(Position p) throws InvalidPositionException;
    Position first() throws EmptyContainerException;
    Position last() throws EmptyContainerException;
    Position before(Position p)
        throws InvalidPositionException, BoundaryViolationException;
    Position after(Position p)
            throws InvalidPositionException, BoundaryViolationException;
    Position insertBefore(Position p, Object element)
            throws InvalidPositionException;
    Position insertAfter(Position p, Object element)
            throws InvalidPositionException;
    Position insertFirst(Object element);
    Position insertLast(Object element);
    Object remove(Position p) throws InvalidPositionException;
    Object replaceElement(Position p, Object element) throws InvalidPositionException;
    void swapElements(Position a , Position b) throws InvalidPositionException;

}
