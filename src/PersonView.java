package view;

import model.Node;
import model.Person;
import service.Graph;
import service.MyPerson;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonView {
    MyPerson myPerson = new MyPerson();
    Graph myGraph = new Graph();

    public PersonView(){}

    public void inputNewPerson() {
        Scanner inputKeyboard = new Scanner(System.in);
        System.out.print("     ID: ");
        String id = inputKeyboard.nextLine();
        System.out.print("     Name: ");
        String name = inputKeyboard.nextLine();
        System.out.print("     Birthplace: ");
        String birthplace = inputKeyboard.nextLine();
        System.out.print("     DOB: ");
        String dob = inputKeyboard.nextLine();

        myPerson.insert(id, name, birthplace, dob);
    }

    public void inOrderView() {
        System.out.println("IN-ORDER TRAVERSE");
        ArrayList<Node> listInOrder = new ArrayList<>();
        myPerson.inOrder(listInOrder);
        System.out.println(Person.dataPersonFrame());
        for (Node currentNode : listInOrder) {
            System.out.println(currentNode.toString());
        }
    }

    public void postOrderView() {
        System.out.println("POST-ORDER TRAVERSE");
        ArrayList<Node> listInOrder = new ArrayList<>();
        myPerson.postOrder(listInOrder);
        System.out.println(Person.dataPersonFrame());
        for (Node currentNode : listInOrder) {
            System.out.println(currentNode.toString());
        }
    }

    public void preOrderView() {
        System.out.println("PRE-ORDER TRAVERSE");
        ArrayList<Node> listInOrder = new ArrayList<>();
        myPerson.preOrder(listInOrder);
        System.out.println(Person.dataPersonFrame());
        for (Node currentNode : listInOrder) {
            System.out.println(currentNode.toString());
        }
    }

    public void searchView() {
        Scanner keyboardInput = new Scanner(System.in);
        System.out.print("     Enter ID: ");
        String code = keyboardInput.nextLine();
        System.out.println(Person.dataPersonFrame());
        Node nodeSearched = myPerson.search(code);
        if (nodeSearched != null) {
            System.out.print(nodeSearched.toString());
        } else {
            System.out.println("No element is found");
        }

    }

    public void deleteView() {
        Scanner input = new Scanner(System.in);
        System.out.print("     Enter ID to delete: ");
        String code = input.nextLine();
        myPerson.delete(code);
        System.out.println("     The element is deleted successfully!");
    }

    public void DFSOfGraphView() {
        ArrayList<String> nameListOfCity = new ArrayList<>();
        myGraph.DFS(nameListOfCity);
        System.out.println(nameListOfCity.toString());
    }

    public void BFSOfGraphView() {
        ArrayList<String> nameListOfCity = new ArrayList<>();
        myGraph.BFS(nameListOfCity);
        System.out.println(nameListOfCity.toString());
    }

    public void BFTView() {
        System.out.println("BFT Of Binary Tree");
        System.out.println(Person.dataPersonFrame());
        ArrayList<Node> nodesListBFT = new ArrayList<>();
        nodesListBFT = myPerson.BFT();
        for(Node currentNode:nodesListBFT) {
            System.out.println(currentNode.toString());
        }
    }

    public void balanceView() {
        myPerson.balance();
        System.out.println("The tree is balanced");
    }

    public void dijkstraView() {
        myGraph.printGraph();
        myGraph.dijkstra(0);
    }

    public static void showMenu(){
        System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=\nCHOOSE YOUR OPTION:");
        System.out.println("Person Tree:");
        System.out.println("1.  Insert a new Person."); //Done
        System.out.println("2.  Inorder traverse"); //Done
        System.out.println("3.  Breadth-First Traversal traverse");
        System.out.println("4.  Search by Person ID"); //Done
        System.out.println("5.  Delete by Person ID"); //Done
        System.out.println("6.  Balancing Binary Search Tree "); //Done
        System.out.println("7.  DFS_Graph"); //Done
        System.out.println("8.  Dijkstra"); // Done
        System.out.println("9.  Postorder traverse"); //Done
        System.out.println("10. Preorder traverse"); //Done
        System.out.println("11. BFS_Graph"); //Done
        System.out.println("0. Exit");
    }

}
