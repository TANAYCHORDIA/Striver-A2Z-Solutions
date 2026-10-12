package Graphs;
import java.util.*;
public class dfs {
    public static void dfsOfGraph(int node,boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){
        vis[node]=true;
        ans.add(node);
        for(Integer i:adj.get(node)){
            if(vis[i]==false){
                dfsOfGraph(i,vis,adj,ans);
            }
        }
    }
    public static ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[v];
        dfsOfGraph(0,vis,adj,ans);
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
        ArrayList<Integer> ans = dfs.dfsOfGraph(v,adj);
        System.out.println(ans);
    }
}
