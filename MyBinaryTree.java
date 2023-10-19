package huffmanAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree {
    Node root;
    public static List<Integer> sortedData = new ArrayList<>();

    public void addNode(int key, String name){
        Node newNode = new Node(key, name);

        if(root == null){
            root = newNode;
            return;
        }
        Node parent = root;
        Node focusNode = parent;
        while(true){
            parent = focusNode;
            if(key < parent.key){
                if(parent.left != null)
                    focusNode = parent.left;
                else{
                    parent.left = newNode;
                    return;
                }
            }else {
                if(parent.right != null)
                    focusNode = parent.right;
                else {
                    parent.right = newNode;
                    return;
                }
            }
        }

    }

    public void showOrder(Node focusNode){
        if(focusNode != null) {
            showOrder(focusNode.left);
            System.out.println(focusNode);
            sortedData.add(focusNode.key);
            showOrder(focusNode.right);
        }

    }


    public static void main(String[] args) {
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.addNode(50,"A");
        myBinaryTree.addNode(30,"B");
        myBinaryTree.addNode(60, "C");
        myBinaryTree.addNode(100, "D");
        myBinaryTree.addNode(10, "F");
        myBinaryTree.addNode(10,"H");
        myBinaryTree.addNode(13,"");
        myBinaryTree.addNode(120,"T");
        myBinaryTree.addNode(1, "");
        myBinaryTree.addNode(10,"");
        myBinaryTree.showOrder(myBinaryTree.root);

        int[] array = new int[]{3,6,1,9,9,10,3,4};
        List<Integer> list = new ArrayList<>();
       // list.add(myBinaryTree.showOrder(myBinaryTree.root));

        for(Integer i : sortedData)System.out.println(i);

    }
    class Node{
        int key;
        String name;
        Node left;
        Node right;
        Node(int key, String name){
            this.key = key;
            this.name = name;
        }

        public String toString(){
            return key + " " + name;
        }
    }
}
