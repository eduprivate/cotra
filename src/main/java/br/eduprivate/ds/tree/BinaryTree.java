package br.eduprivate.ds.tree;

public class BinaryTree {

    private int data;
    private BinaryTree right, left;

    public BinaryTree(int data, BinaryTree right, BinaryTree left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    public BinaryTree() {
        this.data = 0;
        this.right = null;
        this.left = null;
    }

    public BinaryTree newNode(int item)
    {
        BinaryTree temp = new BinaryTree();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }

    void printInorder(BinaryTree node)
    {
        if (node == null)
            return;

        // First recur on left child
        printInorder(node.left);

        // Then print the data of node
        System.out.print(node.data + " ");

        // Now recur on right child
        printInorder(node.right);
    }

    void printPreorder(BinaryTree node)
    {
        if (node == null)
            return;

        // First print data of node
        System.out.print(node.data + " ");

        // Then recur on left subtree
        printPreorder(node.left);

        // Now recur on right subtree
        printPreorder(node.right);
    }

    // "bottom-up" postorder traversal.
    void printPostorder(BinaryTree node)
    {
        if (node == null)
            return;

        // First recur on left subtree
        printPostorder(node.left);

        // Then recur on right subtree
        printPostorder(node.right);

        // Now deal with the node
        System.out.print(node.data + " ");
    }

    static boolean iterativeSearch(BinaryTree root, int key)
    {
        // Traverse until root reaches to dead end
        while (root != null) {
            // pass right subtree as new tree
            if (key > root.data)
                root = root.right;

                // pass left subtree as new tree
            else if (key < root.data)
                root = root.left;
            else
                return true; // if the key is found return 1
        }
        return false;
    }

    public BinaryTree insert(BinaryTree Node, int data)
    {
        /* If the tree is empty, return a new Node */
        if (Node == null)
            return newNode(data);

        /* Otherwise, recur down the tree */
        if (data < Node.data)
            Node.left = insert(Node.left, data);
        else if (data > Node.data)
            Node.right = insert(Node.right, data);

        /* return the (unchanged) Node pointer */
        return Node;
    }

    public static void main(String args[])
    {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree root = binaryTree.insert(null, 50);
        binaryTree.insert(root, 30);
        binaryTree.insert(root, 20);
        binaryTree.insert(root, 40);
        binaryTree.insert(root, 70);
        binaryTree.insert(root, 60);
        binaryTree.insert(root, 80);
        if (iterativeSearch(root, 70))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}