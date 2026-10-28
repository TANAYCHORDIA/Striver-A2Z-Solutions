package Graphs;
public class noOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(visited[i]!=true){
                dfs(isConnected,visited,i);
                cnt++;
            }
        }
        return cnt;
    }
    public static void dfs(int[][] isConnected,boolean visited[],int city){
        visited[city] = true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[city][i]==1 && visited[i]==false){
                dfs(isConnected,visited,i);
            }
        }
        return;
    }
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
}