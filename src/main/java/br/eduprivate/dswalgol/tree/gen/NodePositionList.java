package br.eduprivate.dswalgol.tree.gen;

import br.eduprivate.dswalgol.net.datastructures.Position;
import br.eduprivate.dswalgol.vector.BoundaryViolationException;
import br.eduprivate.dswalgol.vector.DNode;
import br.eduprivate.dswalgol.vector.InvalidPositionException;

import javax.swing.text.ElementIterator;
import java.util.Iterator;

public class NodePositionList<E> implements PositionList<E> {

    protected int numElts;            	// Number of elements in the list
    protected DNode<E> header, trailer;	// Special sentinels

    public NodePositionList() {
        numElts = 0;
        header = new DNode<E>(null, null, null);	// create header
        trailer = new DNode<E>(header, null, null);	// create trailer
        header.setNext(trailer);	// make header and trailer point to each other
    }

    protected DNode<E> checkPosition(Position<E> p)
            throws InvalidPositionException {
        if (p == null)
            throw new InvalidPositionException
                    ("Null position passed to NodeList");
        if (p == header)
            throw new InvalidPositionException
                    ("The header node is not a valid position");
        if (p == trailer)
            throw new InvalidPositionException
                    ("The trailer node is not a valid position");
        try {
            DNode<E> temp = (DNode<E>) p;
            if ((temp.getPrev() == null) || (temp.getNext() == null))
                throw new InvalidPositionException
                        ("Position does not belong to a valid NodeList");
            return temp;
        } catch (ClassCastException e) {
            throw new InvalidPositionException
                    ("Position is of wrong type for this list");
        }
    }

    public int size() { return numElts; }
    public boolean isEmpty() { return (numElts == 0); }
    public Position<E> first()
            throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException("List is empty");
        return (Position)header.getNext();
    }
    public Position<E> last()
            throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException("List is empty");
        return (Position<E>) trailer.getPrev();
    }
    public Position<E> prev(Position<E> p)
            throws InvalidPositionException, BoundaryViolationException {
        DNode<E> v = checkPosition(p);
        DNode<E> prev = v.getPrev();
        if (prev == header)
            throw new BoundaryViolationException
                    ("Cannot advance past the beginning of the list");
        return (Position)prev;
    }
    public Position<E> next(Position<E> p)
            throws InvalidPositionException, BoundaryViolationException {
        DNode<E> v = checkPosition(p);
        DNode<E> next = v.getNext();
        if (next == trailer)
            throw new BoundaryViolationException
                    ("Cannot advance past the end of the list");
        return (Position)next;
    }
    public void addBefore(Position<E> p, E element)
            throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        numElts++;
        DNode<E> newNode = new DNode<E>(v.getPrev(), v, element);
        v.getPrev().setNext(newNode);
        v.setPrev(newNode);
    }
    public void addAfter(Position<E> p, E element)
            throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        numElts++;
        DNode<E> newNode = new DNode<E>(v, v.getNext(), element);
        v.getNext().setPrev(newNode);
        v.setNext(newNode);
    }
    public void addFirst(E element) {
        numElts++;
        DNode<E> newNode = new DNode<E>(header, header.getNext(), element);
        header.getNext().setPrev(newNode);
        header.setNext(newNode);
    }
    public void addLast(E element) {
        numElts++;
        DNode<E> oldLast = trailer.getPrev();
        DNode<E> newNode = new DNode<E>(oldLast, trailer, element);
        oldLast.setNext(newNode);
        trailer.setPrev(newNode);
    }
    public E remove(Position<E> p)
            throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        numElts--;
        DNode<E> vPrev = v.getPrev();
        DNode<E> vNext = v.getNext();
        vPrev.setNext(vNext);
        vNext.setPrev(vPrev);
        E vElem = v.element();
        // unlink the position from the list and make it invalid
        v.setNext(null);
        v.setPrev(null);
        return vElem;
    }
    public E set(Position<E> p, E element)
            throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        E oldElt = v.element();
        v.setElement(element);
        return oldElt;
    }

    public Iterator<E> iterator() { return new NodePositionIterator<E>(this); }

    public Iterable<Position<E>> positions() throws EmptyListException {     // create a list of posiitons
        PositionList<Position<E>> P = new NodePositionList<Position<E>>();
        if (!isEmpty()) {
            Position<E> p = first();
            while (true) {
                P.addLast(p); // add position p as the last element of list P
                if (p == last())
                    break;
                p = next(p);
            }
        }
        return P; // return P as our Iterable object
    }

    public boolean isFirst(Position<E> p)
            throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        return v.getPrev() == header;
    }

    public boolean isLast(Position<E> p)
            throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        return v.getNext() == trailer;
    }
    public void swapElements(Position<E> a, Position<E> b)
            throws InvalidPositionException {
        DNode<E> pA = checkPosition(a);
        DNode<E> pB = checkPosition(b);
        E temp = pA.element();
        pA.setElement(pB.element());
        pB.setElement(temp);
    }

    public static <E> String forEachToString(PositionList<E> L) {
        String s = "[";
        int i = L.size();
        for (E elem: L) {
            s += elem; // implicit cast of the element to String
            i--;
            if (i > 0)
                s += ", "; // separate elements with a comma
        }
        s += "]";
        return s;
    }
    public static <E> String toString(PositionList<E> l) {
        Iterator<E> it = l.iterator();
        String s = "[";
        while (it.hasNext()) {
            s += it.next();	// implicit cast of the next element to String
            if (it.hasNext())
                s += ", ";
        }
        s += "]";
        return s;
    }
    public String toString() {
        return toString(this);
    }
}