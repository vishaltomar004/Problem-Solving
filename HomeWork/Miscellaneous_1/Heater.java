package HomeWork.Miscellaneous_1;

import java.util.Arrays;

public class Heater {
      public int findRadius(int[] houses, int[] heaters) {
         int i = 0;
        int j = 0;
        
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int maxRadius = 0;
        while(i<houses.length) {
            while(heaters[j]<houses[i] && j<heaters.length-1) {
                j++;
            }
            int currRadius = Math.abs(heaters[j] - houses[i]);
            if(j>0) {
                currRadius = Math.min(currRadius,houses[i] - heaters[j-1]);
            }
            maxRadius = Math.max(maxRadius,currRadius);
            i++;
        }
        return maxRadius;
    }
}
