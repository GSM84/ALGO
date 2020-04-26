package Lesson7;

import java.util.LinkedList;

public class DepthRoute {
    private boolean[] marked;
    private int[]     edgeTo;
    private int       startVertex;

    public DepthRoute(Graph _graph, int _startVertex){
        this.startVertex = _startVertex;
        this.edgeTo      = new int[_graph.getVertexCount()];
        this.marked      = new boolean[_graph.getVertexCount()];
        dRoute(_graph, _startVertex);
    }

    public void dRoute(Graph _graph, int _vertex){
        marked[_vertex] = true;
        for (int adjVertex:_graph.getAdjList(_vertex)) {
            if (!marked[adjVertex]){
                edgeTo[adjVertex] = _vertex;
                dRoute(_graph, adjVertex);
            }
        }
    }

    public boolean hasPathTo(int _vertex){
        return marked[_vertex];
    }

    public LinkedList<Integer> pathTo(int _vertex){
        if(!hasPathTo(_vertex)){
            return null;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = _vertex;

        while (vertex != startVertex){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
