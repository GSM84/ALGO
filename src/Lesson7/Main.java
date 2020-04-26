package Lesson7;

public class Main {
    public static void main(String[] args) {
        Graph gr = new Graph(10);

//        gr.addEdge(1,2);
//        gr.addEdge(0,4);
//        gr.addEdge(1,4);
//
//        gr.addEdge(3,4);
//        gr.addEdge(7,8);
//        gr.addEdge(2,3);



        gr.addEdge(0,5);
        gr.addEdge(5,4);

        gr.addEdge(0,1);
        gr.addEdge(1,2);
        gr.addEdge(2,3);
        gr.addEdge(3,4);

        gr.addEdge(0,4);

        //System.out.println(gr.getAdjList(3));

//        DepthRoute dr = new DepthRoute(gr, 2);
        //System.out.println(dr.hasPathTo(3));
        //System.out.println(dr.pathTo(3));

        BreadthRoute br = new BreadthRoute(gr, 0);
        //System.out.println(br.hasPathTo(8));
        //System.out.println(br.hasPathTo(3));
        System.out.println(br.getPathTo(4));
    }
}
