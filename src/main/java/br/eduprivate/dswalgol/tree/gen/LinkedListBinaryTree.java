package br.eduprivate.dswalgol.tree.gen;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListBinaryTree {

    private ListNode head;
    private BinaryTreeNode root;

    public void push(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public BinaryTreeNode convertListToBinary(BinaryTreeNode node){
        Queue<BinaryTreeNode> q = new LinkedList<>();

        if (head == null) {
            node = null;
            return null;
        }

        node = new BinaryTreeNode(head.data);
        q.add(node);

        head = head.next;

        while(head != null) {
            BinaryTreeNode parent = q.peek();

            BinaryTreeNode leftChild = null, rightChild = null;
            leftChild = new BinaryTreeNode(head.data);
            q.add(leftChild);
            head = head.next;
            if (head != null)
            {
                rightChild = new BinaryTreeNode(head.data);
                q.add(rightChild);
                head = head.next;
            }

            parent.left = leftChild;
            parent.right = rightChild;

            //remove current level node
            q.poll();
        }

        return node;
    }

    public void inorderTraversal(BinaryTreeNode node){
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public void draw(BinaryTreeNode node){
        if (node != null) {
            System.out.print("(" );
            inorderTraversal(node.left);
            System.out.print(")\n" );
            System.out.print("(" + node.data + ")\n");
            System.out.print("(" );
            inorderTraversal(node.right);
            System.out.print(")\n" );
        }
    }

    public static void main(String[] args)
    {
        LinkedListBinaryTree tree = new LinkedListBinaryTree();
        tree.push(36);
        tree.push(30);
        tree.push(25);
        tree.push(15);
        tree.push(12);
        tree.push(10);
        BinaryTreeNode node = tree.convertListToBinary(tree.root);

        System.out.println("Inorder Traversal of the"+
                " constructed Binary Tree is:");
        tree.inorderTraversal(node);
        System.out.println();
        tree.draw(node);
    }

}

class ListNode{
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right = null;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

