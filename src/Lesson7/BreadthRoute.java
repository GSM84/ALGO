package Lesson7;

import java.util.LinkedList;

public class BreadthRoute {
    private boolean[] marked;
    private int[]     edgeTo;
    private int[]     distTo;
    private int       startVertex;

    private final int INFINITY = Integer.MAX_VALUE;

    public BreadthRoute(Graph _graph, int _startVertex){
        this.startVertex = _startVertex;
        this.edgeTo      = new int[_graph.getVertexCount()];
        this.distTo      = new int[_graph.getVertexCount()];
        this.marked      = new boolean[_graph.getVertexCount()];

        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = INFINITY;
        }
        bRoute(_graph, _startVertex);
    }

    private void bRoute(Graph _graph, int _vertex){
        LinkedList<Integer> queue = new LinkedList<>();

        queue.addLast(_vertex);
        marked[_vertex] = true;
        //distTo[_vertex] = 0;

        while(!queue.isEmpty()){
            int vertext = queue.removeFirst();
            for (int adjVertex:_graph.getAdjList(vertext)) {
                if(!marked[adjVertex]){
                    marked[adjVertex] = true;
                    edgeTo[adjVertex] = vertext;
                    //distTo[adjVertex] = distTo[vertext] + 1;
                    queue.addLast(adjVertex);

                }
            }
        }
    }

    public boolean hasPathTo(int _vertex){
        return marked[_vertex];
    }

    public LinkedList<Integer> getPathTo(int _vertex){
        if(!hasPathTo(_vertex)){
            return null;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int vertext = _vertex;

        while (vertext != startVertex){
            stack.push(vertext);
            vertext = edgeTo[vertext];
        }

        return stack;
    }
}
