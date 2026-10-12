package Graphs;
import java.util.*;
public class bfs {
    public static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            ans.add(node);
            for(Integer i:adj.get(node)){
                if(vis[i]==false){
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 5;
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(0);
        adj.get(3).add(1);
        adj.get(4).add(1);
        ArrayList<Integer> ans = bfs.bfsOfGraph(v,adj);
        System.out.println(ans);
    }
}
