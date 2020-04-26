package Lesson7;

import java.util.LinkedList;

public class Graph {

    private int vertexCount;
    private int edgeCount   = 0;

    private LinkedList<Integer>[] adjList;

    public Graph(int _vertexCount){
        if (_vertexCount <= 0){
            throw new IllegalArgumentException("Incorrect vertex count.");
        }
        this.vertexCount = _vertexCount;
        this.adjList     = new LinkedList[_vertexCount];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public LinkedList<Integer> getAdjList(int _vertex){
        return (LinkedList<Integer>) adjList[_vertex].clone();
    }

    public void addEdge(int _firstVertex, int _secondVertex){
        if (_firstVertex     < 0
            || _secondVertex < 0
            || _firstVertex  >= vertexCount
            || _secondVertex >= vertexCount){
            throw  new IllegalArgumentException("Incorrect vertex.");
        }

        adjList[_firstVertex].add(_secondVertex);
        adjList[_secondVertex].add(_firstVertex);
    }
}
