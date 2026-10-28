package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    } 
}
public class noOfIslands {
    public void bfs(int ro, int co, boolean[][] vis,char[][] grid){
        vis[ro][co]=true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro,co));
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for(int delRow=-1;delRow<=1;delRow++){
                int nrow = row + delRow;
                int ncol = col;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]!=true){
                        vis[nrow][ncol]=true;
                        q.add(new Pair(nrow,ncol));
                }
            }
            for(int delCol = -1;delCol<=1;delCol+=2){
                int nrow = row;
                int ncol = delCol+col;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]!=true){
                        vis[nrow][ncol]=true;
                        q.add(new Pair(nrow,ncol));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int cnt =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]!=true){
                    cnt++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'0','0','1','0','0'},
                         {'0','0','0','1','1'}};
        noOfIslands obj = new noOfIslands();
        System.out.println(obj.numIslands(grid));
    }
}
