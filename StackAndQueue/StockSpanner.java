package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class StockSpanner {
    ArrayDeque<int[]> dq;

    public StockSpanner() {
        dq = new ArrayDeque<>();
    }

    public int next(int price) {
        int val = 1;
        while (!dq.isEmpty() && dq.getLast()[0] <= price) {
            val += dq.getLast()[1];
            dq.removeLast();
        }
        dq.addLast(new int[] { price, val });
        return val;
    }
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        Integer[] prices = { null, 100, 80, 60, 70, 60, 75, 85 };
        Integer[] spans = new Integer[prices.length];
        spans[0] = null;
        for (int i = 1; i < prices.length; i++) {
            spans[i] = stockSpanner.next(prices[i]);
        }
        System.out.println(Arrays.toString(prices));
        System.out.println(Arrays.toString(spans));
         
    }
}
