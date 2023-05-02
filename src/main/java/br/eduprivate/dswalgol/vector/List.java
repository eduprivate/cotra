package br.eduprivate.dswalgol.vector;

public interface List {
    public int size();
    public boolean isEmpty();
    public boolean isFirst(Position p) throws InvalidPositionException;
    public boolean isLast(Position p) throws InvalidPositionException;
    public DNode first() throws EmptyContainerException;
    public DNode last() throws EmptyContainerException;
    public Position before(Position p)
        throws InvalidPositionException, BoundaryViolationException;
    public Position after(Position p)
            throws InvalidPositionException, BoundaryViolationException;
    public Position insertBefore(Position p, Object element)
            throws InvalidPositionException;
    public Position insertAfter(Position p, Object element)
            throws InvalidPositionException;
    public Position insertFirst(Object element);
    public Position insertLast(Object element);
    public Object remove(Position p) throws InvalidPositionException;
    public Object replaceElement(Position p, Object element) throws InvalidPositionException;
    public void swapElements(Position a , Position b) throws InvalidPositionException;

}
