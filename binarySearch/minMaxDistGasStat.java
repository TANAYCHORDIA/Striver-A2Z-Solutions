package binarySearch;

import java.util.PriorityQueue;
class Pair{
    double dist;
    int index;
    Pair(double dist,int index){
        this.dist=dist;
        this.index=index;
    }
}

public class minMaxDistGasStat{
    public static double minMaxDist(int[] stations, int k) {
        int n = stations.length;
        if(n==1)return 0;
        int[] howMany = new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.dist,a.dist));
        for(int i=0;i<n-1;i++){
            pq.add(new Pair(stations[i+1]-stations[i],i));
        }
        for(int i=0;i<k;i++){
            Pair top = pq.poll();
            int idx = top.index;
            howMany[idx]++;
            double totalDist = stations[idx+1]-stations[idx];
            double newDist = totalDist/(howMany[idx]+1);
            pq.add(new Pair(newDist,idx));
        }
        return pq.peek().dist;
        
    }
    public static void main(String[] args) {
        int[] stations = {1,2,3,4,5,6,7,8,9};
        int k = 3;
        System.out.println(minMaxDist(stations,k));
    }       
}