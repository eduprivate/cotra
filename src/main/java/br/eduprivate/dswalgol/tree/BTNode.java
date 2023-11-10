package br.eduprivate.dswalgol.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTNode<T> {
    private T data;
    private BTNode left;
    private BTNode right;

    public BTNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public int getDataHash() {
        return data.hashCode();
    }

    public void setData(T data) {
        this.data = data;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public BTNode insert(BTNode node, T data) {
        if (node == null) {
            node = new BTNode(data);
        } else {
            int dataHash = data.hashCode();
            if (dataHash < node.getDataHash()) {
                node.setLeft(insert(node.getLeft(), data));
            } else if (dataHash > node.getDataHash()) {
                node.setRight(insert(node.getRight(), data));
            }
        }
        return node;
    }

    public BTNode search(BTNode root, T data) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            int dataHash = data.hashCode();

            if (data == root.getData()) {
                return root;
            } else if (dataHash > root.getDataHash()) {
                root = root.getRight();
            } else {
                root = root.getLeft();
            }
        }
        return null;
    }

    public BTNode findMin(BTNode root) {
        if (root == null) {
            return null;
        }
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }

    public BTNode findMax(BTNode root) {
        if (root == null) {
            return null;
        }
        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root;
    }

    public void preOrder(BTNode root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public List<T> preOrderNonRecursive(BTNode root) {
        List<T> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<BTNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            BTNode node = s.pop();
            result.add((T) node.getData());
            if (node.getRight() != null) {
                s.push(node.getRight());
            }
            if (node.getLeft() != null) {
                s.push(node.getLeft());
            }
        }
        return result;
    }

    public void inOrder(BTNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData());
            inOrder(root.getRight());
        }
    }

    public void postOrder(BTNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData());
        }
    }

    public static void main(String[] args) {
        BTNode node = new BTNode(1);
        final BTNode insert = node.insert(null, 2);
        System.out.println(insert == node);
        final List<Integer> list = node.preOrderNonRecursive(node);
        System.out.println(list);
    }

}
