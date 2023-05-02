package br.eduprivate.dswalgol.vector;

public class NodeList  implements  List {
    protected int numElts;
    protected DNode header, trailer;

    public NodeList() {
     numElts = 0;
     header = new DNode(null, null, null);
     trailer = new DNode(header, null, null);
     header.setNext(trailer);
    }

    protected DNode checkPosition(Position p) throws InvalidPositionException {
        if (p == null)
            throw new InvalidPositionException("Null Position passed to NodeList");

        if (p == header)
            throw new InvalidPositionException("The header node is not a valid position");

        if (p == trailer)
            throw new InvalidPositionException("The trailer node is not a valid position");

        try {
            DNode temp = (DNode) p;
            if((temp.getPrev()==null) || (temp.getNext() == null))
                throw new InvalidPositionException("Position does not belong to a valid NodeList");

            return temp;
        } catch (ClassCastException e) {
            throw new InvalidPositionException("Position is of wrong type for this container.");
        }
    }
    @Override
    public int size() {
        return numElts;
    }

    @Override
    public boolean isEmpty() {
        return numElts < 1;
    }

    @Override
    public boolean isFirst(Position p) throws InvalidPositionException {
        DNode v = checkPosition(p);
        return v.getNext() == header;
    }

    @Override
    public boolean isLast(Position p) throws InvalidPositionException {
        DNode v = checkPosition(p);
        return v.getNext() == null;
    }

    @Override
    public DNode first() throws EmptyContainerException {
        if (isEmpty())
            throw new EmptyContainerException("List is empty");
        return header.getNext();
    }

    @Override
    public DNode last() throws EmptyContainerException {
        return null;
    }

    @Override
    public Position before(Position p) throws InvalidPositionException, BoundaryViolationException {
        return null;
    }

    @Override
    public Position after(Position p) throws InvalidPositionException, BoundaryViolationException {
        return null;
    }

    @Override
    public Position insertBefore(Position p, Object element) throws InvalidPositionException {
        return null;
    }

    @Override
    public Position insertAfter(Position p, Object element) throws InvalidPositionException {
        return null;
    }

    @Override
    public Position insertFirst(Object element) {
        return null;
    }

    @Override
    public Position insertLast(Object element) {
        return null;
    }

    @Override
    public Object remove(Position p) throws InvalidPositionException {
        return null;
    }

    @Override
    public Object replaceElement(Position p, Object element) throws InvalidPositionException {
        return null;
    }

    @Override
    public void swapElements(Position a, Position b) throws InvalidPositionException {

    }
}
