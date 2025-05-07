import java.util.*;

public class ClassroomAI{

   static class Edge{
    int src,dest;
    
    public Edge(int s , int d){
        this.src=s;
        this.dest=d;
     }
   }
public static void createGraph(ArrayList<Edge> graph[]){
 // first the array of arraylist is null , WE HAVE TO INITALIZE IT WITH ARRAYLIST 
    for(int i=0; i<graph.length;i++){
        graph[i]=new ArrayList<Edge>();
    }
    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 3));

    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 4));

    graph[3].add(new Edge(3, 1));
    graph[3].add(new Edge(3, 4));
    graph[3].add(new Edge(3, 5));

    graph[4].add(new Edge(4, 2));
    graph[4].add(new Edge(3, 3));
    graph[4].add(new Edge(4, 5));

    graph[5].add(new Edge(5, 3));
    graph[3].add(new Edge(3, 4));
    graph[5].add(new Edge(5, 6));

    graph[6].add(new Edge(6, 5));
  }

public static void bfs(ArrayList<Edge> graph[] , int V){ // TIME COMPLEXITY : O(V+E)
  Queue<Integer> q = new LinkedList<>();
  boolean vis[]= new boolean[V];
  q.add(0);
  
  while(!q.isEmpty()){
    
    int curr=q.remove();
    if(vis[curr]==false){
          //3 steps 
        System.out.print(curr+"");
        vis[curr]=true;
        //add curr neighbours in queue
        for(int i=0; i<graph[curr].size();i++){
          Edge e = graph[curr].get(i);
          q.add(e.dest);
        }
    }
  }
}

//REcursive fn
public static void dfs(ArrayList<Edge>graph[], int curr, boolean vis[]){//TC : O(V+E)
  System.out.print(curr+" ");
  vis[curr]=true;

  for(int i=0 ; i< graph[curr].size();i++){
    Edge e = graph[curr].get(i);
    if(vis[e.dest]==false){
    dfs(graph, e.dest, vis);
  }
} 
}


  public static void main(String[] args) {
    int V=7;
// WE USE adjacency list for no EXTRA SPACE USE and BETTER TC 
// adjacnecy Matrix stores extra space of UNVISITED Neighbours
    ArrayList<Edge> graph[]= new ArrayList[V];
    createGraph(graph);
 
    // //print 2's neighbours 
    // for(int i=0; i<graph[2].size();i++){
    //     Edge e = graph[2].get(i);
    //     System.out.print(e.dest+" ");// e.src is the source vertex here its2 
    bfs(graph, V);
    System.out.println(" ");
    boolean vis[]= new boolean[V];
    dfs(graph, 0, vis);
    }
  }


                                                                                                                                              