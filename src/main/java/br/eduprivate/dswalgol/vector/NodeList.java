package br.eduprivate.dswalgol.vector;

public class NodeList implements List {
    protected int numElts;
    protected DNode<E> header, trailer;

    public NodeList() {
        numElts = 0;
        header = new DNode<E>(null, null, null);
        trailer = new DNode<E>(header, null, null);
        header.setNext(trailer);
    }

    protected DNode<E> checkPosition(Position p) throws InvalidPositionException {
        if (p == null)
            throw new InvalidPositionException("Null Position passed to NodeList");

        if (p == header)
            throw new InvalidPositionException("The header node is not a valid position");

        if (p == trailer)
            throw new InvalidPositionException("The trailer node is not a valid position");

        try {
            DNode<E> temp = (DNode<E>) p;
            if ((temp.getPrev() == null) || (temp.getNext() == null))
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
        DNode<E> v = checkPosition(p);
        return v.getNext() == header;
    }

    @Override
    public boolean isLast(Position p) throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        return v.getNext() == null;
    }

    @Override
    public Position first() throws EmptyContainerException {
        if (isEmpty())
            throw new EmptyContainerException("List is empty");
        return header.getNext();
    }

    @Override
    public Position last() throws EmptyContainerException {
        if (isEmpty())
            throw new EmptyContainerException("List is empty");
        return trailer.getPrev();
    }

    @Override
    public Position before(Position p) throws InvalidPositionException, BoundaryViolationException {
        DNode<E> v = checkPosition(p);
        DNode<E> prev = v.getPrev();
        if (prev == header)
            throw new BoundaryViolationException(
                    "Cannot advance past the beginning of the list");
        return prev;
    }

    @Override
    public Position after(Position p) throws InvalidPositionException, BoundaryViolationException {
        DNode<E> v = checkPosition(p);
        DNode<E> prev = v.getNext();
        if (prev == trailer)
            throw new BoundaryViolationException(
                    "Cannot advance past the beginning of the list");
        return prev;
    }

    @Override
    public Position insertBefore(Position p, Object element) throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        numElts++;
        DNode<E> newNode = new DNode<E>(v.getPrev(), v, element);
        v.getPrev().setNext(newNode);
        v.setPrev(newNode);
        return newNode;
    }

    @Override
    public Position insertAfter(Position p, Object element) throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        numElts++;
        DNode<E> newNode = new DNode<E>(v.getNext(), v, element);
        v.getNext().setNext(newNode);
        v.setNext(newNode);
        return newNode;
    }

    @Override
    public Position insertFirst(Object element) {
        numElts++;
        DNode<E> newNode = new DNode<E>(header, header.getNext(), element);
        header.getNext().setPrev(newNode);
        header.setNext(newNode);
        return newNode;
    }

    @Override
    public DNode<E> insertLast(Object element) {
        return null;
    }

    @Override
    public Object remove(Position p) throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        numElts--;
        DNode<E> vPrev = v.getPrev();
        DNode<E> vNext = v.getNext();
        vPrev.setNext(vNext);
        vNext.setPrev(vPrev);
        Object vElem = v.element();
        v.setNext(null);
        v.setPrev(null);
        return vElem;
    }

    @Override
    public Object replaceElement(Position p, Object element) throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        Object oldElt  =v.element();
        v.setElement(element);
        return oldElt;
    }

    @Override
    public void swapElements(Position a, Position b) throws InvalidPositionException {
        DNode<E> pA = checkPosition(a);
        DNode<E> pB = checkPosition(b);
        Object temp = pA.element();
        pA.setElement(pB.element());
        pB.setElement(temp);
    }

    public static void main(String[] args) throws EmptyContainerException {
        NodeList nodeList = new NodeList();
        String first = new String("first");
        String second = new String("second");
        Position position = new DNode<E>(null, null,first);

        nodeList.insertFirst(first);
        nodeList.insertFirst(second);
        System.out.println(nodeList.isEmpty());
        System.out.println(nodeList.first().element());
        System.out.println(nodeList.size());
    }
}
