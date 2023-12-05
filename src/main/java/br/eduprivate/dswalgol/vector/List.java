package br.eduprivate.dswalgol.vector;

public interface List<E> {
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
    Position insertBefore(Position p, E element)
            throws InvalidPositionException;
    Position insertAfter(Position p, E element)
            throws InvalidPositionException;
    Position insertFirst(E element);
    Position insertLast(E element);
    Object remove(Position p) throws InvalidPositionException;
    Object replaceElement(Position p, E element) throws InvalidPositionException;
    void swapElements(Position a , Position b) throws InvalidPositionException;

}
