package model;

public class Node {
    private Person data;
    private Node leftNode;
    private Node rightNode;

    //Constructor
    public Node(){
    }

    public Node(Person data) {
        this.data = data;
    }



    @Override
    public String toString() {
        return String.format("%-20s", data);
    }


    //Get and set method


    public Person getData() {
        return data;
    }

    public void setData(Person data) {
        this.data = data;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }
}
