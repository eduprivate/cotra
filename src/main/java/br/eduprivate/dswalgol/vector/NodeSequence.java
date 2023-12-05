package br.eduprivate.dswalgol.vector;

public class NodeSequence extends NodeList implements Sequence {
    protected void checkRank(int rank) throws BoundaryViolationException {
        if (rank < 0 || rank >= numElts)
            throw new BoundaryViolationException("Rank " + rank +
                    " is invalid for this sequence of " + numElts + " elements.");
    }

    @Override
    public Position atRank(int rank) throws BoundaryViolationException {
        DNode<E> node;
        checkRank(rank);

        if(rank <= size()/2) {
            node = header.getNext();
            for (int i = 0; i < rank; i++)
                node = node.getNext();
        } else {
            node = trailer.getPrev();
            for (int i = 1; i < size()-rank;i++)
                node = node.getPrev();
        }

        return node;
    }

    @Override
    public int rankOf(Position position) throws InvalidPositionException {
        return 0;
    }

    public void insertAtRank(int rank, Object element) throws BoundaryViolationException {
        if (rank == size())
            insertLast(element);
        else {
            checkRank(rank);
            insertBefore(atRank(rank), element);
        }
    }

    public Object removeAtRank(int rank, Object element) throws BoundaryViolationException {
        checkRank(rank);
        return replaceElement(atRank(rank), element);
    }
}
