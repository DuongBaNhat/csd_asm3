package service;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Graph {
    int[][] a = {{0,10,9999,9999,9999,9999,8},
                {9999,0,2,10,25,80,9999},
                {30,9999,0,8,3,20,9999},
                {20,9999,9999,0,9999,5,10},
                {9999,9999,9999,4,0,9999,9999},
                {8,9999,9999,9999,9999,0,5},
                {8,9999,9999,9999,9999,9999,0}};

    int n;


    public Graph() {}

    public ArrayList<CityNode>  importNodes() {
        ArrayList<CityNode> cityNodes = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            cityNodes.add(new CityNode(convertToCharacter(i)));
        }

        for (int i = 0; i < 7; i++) {
            ArrayList<CityNode> newNodeList = new ArrayList<>();
            ArrayList<Integer> newDistanceList = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                if (a[i][j] != 0 && a[i][j] != 9999) {
                    newNodeList.add(cityNodes.get(j));
                    newDistanceList.add(a[i][j]);
                }
            }
            cityNodes.get(i).setAdjacentCityNodes(newNodeList);
            cityNodes.get(i).setDistance(newDistanceList);
        }

        return cityNodes;
    }

    public String convertToCharacter(int num) {
        switch (num) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
        }
        return null;
    }

    public int convertToInt(String c) {
        switch (c) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
        }
        return -1;
    }

    public void DFS(ArrayList<String> nameList) {
        ArrayList<CityNode> cityNodes = this.importNodes();
        MyStack newStack = new MyStack();
        CityNode currentNode = cityNodes.get(0);
        currentNode.setVisited(true);
        nameList.add(currentNode.getName());
        newStack.push(currentNode);
        boolean is;
        while(!newStack.isEmpty()) {
            is = false;
            for (CityNode childNodesOfCurrentNode:currentNode.getAdjacentCityNodes()) {
                if (!childNodesOfCurrentNode.isVisited()) {
                    is = true;
                    break;
                }
            }
            if (is) {
                for (CityNode childNodesOfCurrentNode : currentNode.getAdjacentCityNodes()) {
                    if (!childNodesOfCurrentNode.isVisited()) {
                        currentNode = childNodesOfCurrentNode;
                        currentNode.setVisited(true);
                        nameList.add(currentNode.getName());
                        newStack.push(currentNode);
                        break;
                    }
                }
            } else {
                currentNode = newStack.pop();
            }
        }
    }

    public void BFS(ArrayList<String> nameList) {
        ArrayList<CityNode> cityNodes = this.importNodes();
        MyQueue newQueue = new MyQueue();
        CityNode currentNode = cityNodes.get(0);
        currentNode.setVisited(true);
        nameList.add(currentNode.getName());
        newQueue.enqueue(currentNode);
        boolean is;
        while (!newQueue.isEmpty()) {
            is = false;
            for (CityNode childNodesOfCurrentNode:currentNode.getAdjacentCityNodes()) {
                if (!childNodesOfCurrentNode.isVisited()) {
                    is = true;
                    break;
                }
            }
            if (is) {
                for (CityNode childNodesOfCurrentNode : currentNode.getAdjacentCityNodes()) {
                    if (!childNodesOfCurrentNode.isVisited()) {
                        currentNode = childNodesOfCurrentNode;
                        currentNode.setVisited(true);
                        nameList.add(currentNode.getName());
                        newQueue.enqueue(currentNode);
                    }
                }
            } else {
                currentNode = newQueue.dequeue();
            }
        }

    }

    int minDistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < 7; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // shortest path from vertex p to vertex q
    public void dijkstra(int src)
    {
        int dist[] = new int[7];
        Boolean sptSet[] = new Boolean[7];

        for (int i = 0; i < 7; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < 7 - 1; count++) {

            int u = minDistance(dist, sptSet);

            sptSet[u] = true;


            for (int v = 0; v < 7; v++)


                if (!sptSet[v] && a[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + a[u][v] < dist[v])
                    dist[v] = dist[u] + a[u][v];
        }

        // print the constructed distance array
        printSolution(dist);
    }




    public void printSolution(int dist[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < 7; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    public void printGraph() {

    }

    //hien thi duong di
    void pathDijkstra(int[] dist, int[] path, int p, int q) {}

    void dijkstra(int p, int q) {
    }

}
