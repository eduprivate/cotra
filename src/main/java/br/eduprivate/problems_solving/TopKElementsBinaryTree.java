package br.eduprivate.problems_solving;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class BinaryTree {
    private int count;
    private String name;
    private BinaryTree right, left;

    public BinaryTree() {
        this.count = 0;
        this.name = null;
        this.right = null;
        this.left = null;
    }

    public BinaryTree newNode(int count, String name)
    {
        BinaryTree temp = new BinaryTree();
        temp.count = count;
        temp.name = name;
        temp.left = temp.right = null;
        return temp;
    }

    public BinaryTree insert(BinaryTree Node, int count, String name)
    {
        if (Node == null)
            return newNode(count, name);

        if (name.equals(Node.name)) {
            count = count + Node.count;
        }

        if (count > Node.count){

            Node.left = insert(Node.left, count, name);
        }
        else if (count < Node.count){
            Node.right = insert(Node.right, count, name);
        }

        return Node;
    }

    void addByOrderFromTree(BinaryTree node, List<String> resultList) {
        if (node == null)
            return;

        addByOrderFromTree(node.left, resultList);

        if (node.name != null && node.count > 0 ) {
            resultList.add("name: " + node.name + ", count " + node.count);
        }

        addByOrderFromTree(node.right, resultList);
    }

}


public class TopKElementsBinaryTree {

    public BinaryTree parseFile(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));

        BinaryTree binaryTree = new BinaryTree();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String name = line.substring(0, line.indexOf(">") + 1);
            String text = line.substring(line.indexOf(">") + 1);
            String[] arrayText = text.split(" ");

            binaryTree.insert(binaryTree, arrayText.length, name);

        }

        scanner.close();

        return binaryTree;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String file = "logs";
        int n = 2;
        TopKElementsBinaryTree topKElements = new TopKElementsBinaryTree();
        BinaryTree binaryTree = topKElements.parseFile(file);

        List<String> list = new ArrayList<>();
        binaryTree.addByOrderFromTree(binaryTree, list);

        for (int i = 0; i < n && i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // O(nlogn) is better than O(n^3) my last soluction
    }

}
