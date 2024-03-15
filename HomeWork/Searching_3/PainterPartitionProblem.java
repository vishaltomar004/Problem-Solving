package HomeWork.Searching_3;

import java.util.ArrayList;

public class PainterPartitionProblem {
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
   //Find low mad high
   // for every number using BS we will check whether that number can be a feasible answer so that array can be divide in k parts
       int low = Integer.MIN_VALUE;
       int sum=0;
       for(int i =0; i<boards.size() ; i++){
           sum+=boards.get(i);
       low= Math.max(low, boards.get(i));
       }
    
    int high =sum;

       
        while (low <= high) {
            int mid = (low + high) / 2;
            int p = countP(boards, mid);
            if (p> k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countP(ArrayList<Integer> boards, int time) {
        int n = boards.size(); // size of array.
        int painters = 1;
        long boardsPainter = 0;
        for (int i = 0; i < n; i++) {
            if (boardsPainter + boards.get(i) <= time) {
                // allocate board to current painter
                boardsPainter += boards.get(i);
            } else {
                // allocate board to next painter
                painters++;
                boardsPainter = boards.get(i);
            }
        }
        return painters;
    }
}
