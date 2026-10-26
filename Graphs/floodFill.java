package Graphs;
import java.util.*;
class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
public class floodFill {
    public static int[][] floodfill(int[][] image, int sr, int sc, int color) {
        int orgClr = image[sr][sc];
        bfs(image,sr,sc,color,orgClr);
        return image;
    }
    public static void bfs(int[][] image, int sr, int sc, int color,int orgClr){
        int m = image.length;
        int n = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];
        q.add(new Pair(sr,sc));
        vis[sr][sc]=true;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();
            image[r][c] = color;
            for(int i= -1;i<=1;i+=2){
                if(r+i>=0 && r+i<m && vis[r+i][c] == false && image[r+i][c]==orgClr){
                    q.add(new Pair(r+i,c));
                    vis[r+i][c]=true;
                }
            }
            for(int i=-1;i<=1;i+=2){
                if(c+i>=0 && c+i<n && vis[r][c+i] == false && image[r][c+i]==orgClr){
                    q.add(new Pair(r,c+i));
                    vis[r][c+i]=true;
                }
            }
            /*
            if(r-1>=0 && vis[r-1][c] == false && image[r-1][c]==orgClr)q.add(new Pair(r-1,c));
            if(r+1<m && vis[r+1][c] == false && image[r+1][c]==orgClr)q.add(new Pair(r+1,c));
            if(c-1>=0 && vis[r][c-1] == false && image[r][c-1]==orgClr)q.add(new Pair(r,c-1));
            if(c+1<n && vis[r][c+1] == false && image[r][c+1]==orgClr)q.add(new Pair(r,c+1));
            */
        }
    }
        public static void main(String[] args) {
            int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
            int sr = 1;
            int sc = 1;
            int color = 2;
            int[][] ans = floodfill(image,sr,sc,color);
            for(int i=0;i<ans.length;i++){
                for(int j=0;j<ans[0].length;j++){
                    System.out.print(ans[i][j]+" ");
                }
                System.out.println();
            }
        }

}
