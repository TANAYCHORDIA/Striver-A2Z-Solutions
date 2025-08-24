package array;

import java.util.*;

public class mergeOverlapping {
    public static void main(String[] args) {
        int intervals[][] = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(mergeListReturn(intervals));
    }
    public static List<List<Integer>> mergeListReturn(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ans.isEmpty() || ans.get(ans.size()-1).get(1)<intervals[i][0]){
                ans.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            }
            else{
                ans.get(ans.size()-1).set(1,Math.max(intervals[i][1],ans.get(ans.size()-1).get(1)));
            }
        }
        return ans;
    }

    public static int[][] mergeArrayReturn(int[][] intervals) {
        int n = intervals.length;
         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ans.isEmpty() || ans.get(ans.size()-1)[1]<intervals[i][0]){
                ans.add(intervals[i]);
            }
            else{
                ans.get(ans.size()-1)[1]=Math.max(intervals[i][1],ans.get(ans.size()-1)[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
