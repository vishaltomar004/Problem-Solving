package HomeWork.Miscellaneous_2;

import java.util.Deque;
import java.util.LinkedList;

public class NumberofVisiblePeopleinaQueue {
     public int[] canSeePersonsCount(int[] heights) {
        final Deque<Integer> stack = new LinkedList<>();
        final int[] numVisible = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
          
            while (!stack.isEmpty() && heights[stack.getFirst()] <= heights[i]) {
                numVisible[stack.removeFirst()]++;
            }

        
            if (!stack.isEmpty()) {
                numVisible[stack.getFirst()]++;
            }

            stack.addFirst(i);
        }

        return numVisible;
    }
}
