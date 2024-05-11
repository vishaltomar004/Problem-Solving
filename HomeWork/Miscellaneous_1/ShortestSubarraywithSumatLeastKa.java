package HomeWork.Miscellaneous_1;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarraywithSumatLeastKa {
     public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] ps = new long[n+1];
        Deque<Integer> d = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i =0;i<n;i++){
            ps[i+1] = ps[i] + nums[i]; 
        }

        for(int i =0;i<n+1;i++){
            while(!d.isEmpty() && ps[i] - ps[d.peekFirst()] >= k){
                min = Math.min(min,i-d.pollFirst());
            }

            while(!d.isEmpty() && ps[i] <= ps[d.peekLast()]){
                d.pollLast();
            }
            d.add(i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
