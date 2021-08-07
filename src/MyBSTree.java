package service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import model.Node;
import model.Person;

public class MyBSTree {
    private Node root;

    public MyBSTree() {
        root = null;
    }
    void clear() {
    }


    //return true if tree is empty otherwise return false
    public boolean isEmpty() {
        return (this != null)?false:true;
    }



    //count number of person
    public int lengthOfTree() {
        ArrayList<Node> newList = new ArrayList<>();
        this.inOrder(newList,root);
        return newList.size();
    }


    //breadth-first traverse a tree
    public ArrayList<Node> BFT() {
        if (root == null) return null;
        ArrayList<Node> nodesListBFT = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (!temp.getData().isDeleted())
                nodesListBFT.add(temp);

            if (temp.getLeftNode() != null) {
                queue.add(temp.getLeftNode());
            }

            if (temp.getRightNode() != null) {
                queue.add(temp.getRightNode());
            }
        }

        return nodesListBFT;
    }


    //insert a new Person to a tree
    public void insert(Person data) {
        Node currentNode = root;
        if (currentNode == null) {
            root = new Node(data);
            return;
        }
        while(true) {
            if (data.getID().compareTo(currentNode.getData().getID()) > 0) {
                if (currentNode.getRightNode() == null) {
                    Node newNode = new Node(data);
                    currentNode.setRightNode(newNode);
                    return;
                } else
                    currentNode = currentNode.getRightNode();
            } else {
                if (currentNode.getLeftNode() == null) {
                    Node newNode = new Node(data);
                    currentNode.setLeftNode(newNode);
                    return;
                } else
                    currentNode = currentNode.getLeftNode();
            }
        }
    }



     public void inOrder(ArrayList<Node> list, Node person){
        if (person == null)
            return;
        else {
            inOrder(list, person.getLeftNode());
            if (!person.getData().isDeleted()) {
                list.add(person);
            }
            inOrder(list, person.getRightNode());
        }
     }

    public void postOrder(ArrayList<Node> list, Node person){
        if (person != null) {
            postOrder(list, person.getLeftNode());
            postOrder(list, person.getRightNode());
            if (!person.getData().isDeleted()) {
                list.add(person);
            }
        }

    }

    public void preOrder(ArrayList<Node> list, Node person){
        if (person != null) {
            if (!person.getData().isDeleted()) {
                list.add(person);
            }
            preOrder(list, person.getLeftNode());
            preOrder(list, person.getRightNode());
        }

    }



    private void balance(ArrayList<Node> list, int first, int last) {

    }

    public Node balance(ArrayList<Node> list, Node root,
                                 int i)
    {
        if (i < list.size()) {
            Node temp = new Node(list.get(i).getData());
            root = temp;

            root.setLeftNode(balance(list, root.getLeftNode(),
                    2 * i + 1));
            root.setRightNode(balance(list, root.getRightNode(),
                    2 * i + 2));
        }
        return root;
    }


    public Node search(String code) {
        Node currentNode = root;
        if (root == null) return null;
        while(currentNode != null) {
            if (currentNode.getData().getID().compareTo(code) > 0) {
                currentNode = currentNode.getLeftNode();
            }else if (currentNode.getData().getID().compareTo(code) < 0) {
               currentNode = currentNode.getRightNode();
            } else{
                if (!currentNode.getData().isDeleted())
                    return currentNode;
                else
                    return null;
            }
        }
        return null;
    }

    public void delete(String code) {
        Node node = search(code);
        if (node != null)
            node.getData().setDeleted(true);
    }


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}

/*//delete a node by a given ID
    public void delete(String code) {
        Node parentNode = root;
        Node currentNode = root;
        boolean isLeftChild = false;

        if (currentNode == null) return;

        while(currentNode != null) {
            if (currentNode.getData().getID().compareTo(code) > 0) {
                parentNode = currentNode;
                currentNode = currentNode.getLeftNode();
                isLeftChild = true;
            } else if (currentNode.getData().getID().compareTo(code) < 0){
                parentNode = currentNode;
                currentNode = currentNode.getRightNode();
                isLeftChild = false;
            } else break;
        }

        if (currentNode == null) return;

        if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
            if (currentNode == root)
                root = null;
            else
                currentNode = null;
        } else if (currentNode.getRightNode() == null && currentNode.getLeftNode() != null) {
            if (currentNode == root) {
                root = currentNode.getLeftNode();
                currentNode = null;
            } else if (isLeftChild) {
                parentNode.setLeftNode(currentNode.getLeftNode());
                currentNode = null;
            } else {
                parentNode.setRightNode(currentNode.getLeftNode());
                currentNode = null;
            }
        } else if (currentNode.getRightNode() != null && currentNode.getLeftNode() == null) {
            if (currentNode == root) {
                root = currentNode.getRightNode();
                currentNode = null;
            } else if (isLeftChild) {
                parentNode.setLeftNode(currentNode.getRightNode());
                currentNode = null;
            } else {
                parentNode.setRightNode(currentNode.getRightNode());
                currentNode = null;
            }
        } else if (currentNode.getRightNode() != null && currentNode.getLeftNode() != null) {
            Node minNodeOfRightSide = currentNode.getRightNode();
            Node parentOfMinNode = null;
            while(minNodeOfRightSide.getLeftNode() != null) {
                parentOfMinNode = minNodeOfRightSide;
                minNodeOfRightSide = minNodeOfRightSide.getLeftNode();
            }
            if (currentNode == root) {
                if (parentOfMinNode != null) {
                    parentNode.setLeftNode(minNodeOfRightSide.getRightNode());
                    minNodeOfRightSide.setLeftNode(root.getLeftNode());
                    minNodeOfRightSide.setRightNode(root.getRightNode());
                    root = minNodeOfRightSide;
                } else {
                    minNodeOfRightSide.setLeftNode(root.getLeftNode());
                    minNodeOfRightSide.setRightNode(root.getRightNode());
                    root = minNodeOfRightSide;
                }
            } else if (isLeftChild) {
               if (parentOfMinNode != null) {
                   parentOfMinNode.setLeftNode(minNodeOfRightSide.getRightNode());
                   minNodeOfRightSide.setLeftNode(currentNode.getLeftNode());
                   minNodeOfRightSide.setRightNode(currentNode.getRightNode());
                   parentNode.setLeftNode(minNodeOfRightSide);
               } else {
                   minNodeOfRightSide.setLeftNode(currentNode.getLeftNode());
                   minNodeOfRightSide.setRightNode(currentNode.getRightNode());
                   parentNode.setLeftNode(minNodeOfRightSide);
                }
            } else {
                if (parentOfMinNode != null) {
                    parentOfMinNode.setLeftNode(minNodeOfRightSide.getRightNode());
                    minNodeOfRightSide.setLeftNode(currentNode.getLeftNode());
                    minNodeOfRightSide.setRightNode(currentNode.getRightNode());
                    parentNode.setRightNode(minNodeOfRightSide);
                } else {
                    minNodeOfRightSide.setLeftNode(currentNode.getLeftNode());
                    minNodeOfRightSide.setRightNode(currentNode.getRightNode());
                    parentNode.setRightNode(minNodeOfRightSide);
                }
            }
        }
    }*/

