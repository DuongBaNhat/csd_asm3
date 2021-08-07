package service;

import java.util.ArrayList;

public class CityNode {
    public String name;
    private boolean isVisited;
    private ArrayList<CityNode> adjacentCityNodes = new ArrayList<>();
    private ArrayList<Integer> distance = new ArrayList<>();
    private CityNode nextNode;

    public CityNode() {}

    public CityNode(String name) {
        this.name = name;
    }

    public ArrayList<CityNode> getAdjacentCityNodes() {
        return adjacentCityNodes;
    }

    public void setAdjacentCityNodes(ArrayList<CityNode> adjacentCityNodes) {
        this.adjacentCityNodes = adjacentCityNodes;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public ArrayList<Integer> getDistance() {
        return distance;
    }

    public void setDistance(ArrayList<Integer> distance) {
        this.distance = distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNextNode(CityNode nextNode) {
        this.nextNode = nextNode;
    }

    public CityNode getNextNode() {
        return nextNode;
    }
}
