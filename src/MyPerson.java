package service;

import model.Node;
import model.Person;

import java.util.ArrayList;

public class MyPerson {
    MyBSTree tree;


    // Constructor method
    public MyPerson() {
        tree = new MyBSTree();
    }


    public void insert(String id, String name, String birthplace, String dob) {
        Person newPerson = new Person(id, name, birthplace, dob);
        tree.insert(newPerson);
    }


    //1.2 inorder,postOrder,preOrder traversal
    public void inOrder(ArrayList<Node> listInOrder) {
        tree.inOrder(listInOrder,tree.getRoot());
    }
    public void postOrder(ArrayList<Node> listInOrder) {
        tree.postOrder(listInOrder,tree.getRoot());
    }
    public void preOrder(ArrayList<Node> listInOrder) {
        tree.preOrder(listInOrder,tree.getRoot());
    }


    //1.3 BFT a tree
    public ArrayList<Node> BFT() {
        return tree.BFT();
    }

    public boolean isDuplicated(String id){
        if (tree.isEmpty()) return true;
        boolean isDuplicated = false;
        Node currentNode = tree.getRoot();
        while(currentNode != null) {
            if (id.compareTo(currentNode.getData().getID()) > 1) {
                currentNode = currentNode.getRightNode();
            } else if (id.compareTo(currentNode.getData().getID()) < -1) {
                currentNode = currentNode.getLeftNode();
            } else {
                isDuplicated = true;
                break;
            }
        }
        return isDuplicated;
    }


    //1.4 search by ID
    public Node search(String code) {
        return tree.search(code);
    }


    //1.5 delete by ID
    public void delete(String code) {
        tree.delete(code);
    }


    //1.6 simply balancing a tree
    public void balance() {

        ArrayList<Node> nodeArrayList = new ArrayList<>();
        this.inOrder(nodeArrayList);
        tree.setRoot(null);
        tree.setRoot(tree.balance(nodeArrayList,tree.getRoot(),0));
    }


    public Node getRoot() {
        return tree.getRoot();
    }

}
