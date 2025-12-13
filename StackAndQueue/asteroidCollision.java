package StackAndQueue;
import java.util.Stack;
class asteroidCollision{
    public static int[] asteroidcollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            int c = asteroids[i];
                if(c<0){
                    if(!st.isEmpty() && st.peek()> (-1*c))continue;
                    else{
                        while(!st.isEmpty() && st.peek()>0 && st.peek()<-1*c){
                            st.pop();
                        }
                        if(st.isEmpty()) st.push(c);
                        else if(st.peek() == -1*c)st.pop();
                        else if((st.peek()<0 && c<0) || (st.peek()>0 && c>0)) st.push(c);
                        else continue;
                    }
                }
                else{
                    st.push(c);
                }
            }
        int arr[] = new int[st.size()];
        for(int i =st.size()-1;i>=0;i--){
            arr[i] = st.pop();
        }
        return arr;
    }
    public static void main(String[] args) {
        int asteroids[] = {5,10,-5};
        int res[] = asteroidcollision(asteroids);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}