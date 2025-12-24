package StackAndQueue;

class celebrityProblem{
    public static int celebrity(int mat[][]) {
        int n = mat.length;
        int top = 0;
        int down = n-1;
        while(top<down){
            if(mat[top][down] == 0)down--;
            else if(top!=down && mat[top][down] == 1)top++;
        }
        for(int i=0;i<n;i++){
            if(i == down)continue;
            else if(mat[down][i] == 1 || mat[i][down]==0)return -1;
        }
        return down;
    }
    public static void main(String[] args) {
        int mat[][] = {{1, 0, 1, 0},
                       {0, 1, 1, 0},
                       {0, 0, 1, 0},
                       {0, 0, 1, 1}};
        System.out.println(celebrity(mat));
    }
}