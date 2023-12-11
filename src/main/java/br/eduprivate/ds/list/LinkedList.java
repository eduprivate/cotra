package br.eduprivate.ds.list;

import br.eduprivate.ds.Node;

import java.util.HashSet;
import java.util.Iterator;

public class LinkedList<E>  {

    private Node<E> head;
    public void push(E new_data)
    {
        Node<E> newNode = new Node<E>(new_data, null);

        newNode.setNext(head);

        head = newNode;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    static boolean detectLoop(Node h)
    {
        HashSet<Node> s = new HashSet<Node>();
        while (h != null) {
            if (s.contains(h))
                return true;
            s.add(h);
            h = h.getNext();
        }

        return false;
    }
    Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }


    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();

        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        /*Create loop for testing */
        llist.getHead().getNext().getNext().getNext().setNext(llist.head);

        if (detectLoop(llist.getHead()))
            System.out.println("Loop Found");
        else
            System.out.println("No Loop");
    }


}
