package HomeWork.Searching_3;

public class MinimumNumberofDaystoMakemBouquets {

    //We know by observation that our answer will lie between minimum and maximum element of the array

    // If a flower is blommed on Xth day then all of the flower before xth day also had already bloomed
    // so checking for that Xth day , whether is this the possible answer or not
    // if this is not the feasible answer then no element can less than X can be our answer , so we will update ith pointer working as low value to next value else high jth pointer to mid-1;
    
    public int minDays(int[] bloomDay, int m, int k) {
    
        if(m*k > bloomDay.length)
        return -1;
            // Find minimum and maximum of the arra
            int min =Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int i =0; i<bloomDay.length; i++){
                min=Math.min(min , bloomDay[i]);
                max=Math.max(max, bloomDay[i]);
            }
        //  System.out.println("min = "+ min +" max = "+max);
            // for(int i=min ; i<=max; i++){ 
                   
            //     if(thisIsTheOne(bloomDay,i,m,k)){
            //         return i;
            //     }
            // }
        
            int i=min;
            int j=max;
        // int ans=-1;
            while(i<=j){
                int mid= i +((j-i)/2);
        
                if(thisIsTheOne(bloomDay , mid,m,k)){
                    
                     j=mid-1;
                }
                else {
                    i=mid+1;
                }
            }
            return i;
        
            }
        
        
            boolean thisIsTheOne(int a[] , int day ,int bou , int size){
                int count=0;
                int nb=0;
                // System.out.println("day = "+day + "bou = "+ bou + " size = "+size);
        
                for(int i =0; i<a.length;  i++)
                {
                //    System.out.println("a[i] "+a[i] +" day= "+day) ;
                   if(a[i]<= day){
                  
                    count++; 
        // if(i== a.length-1){
        //             nb=nb+ count/size;
        //             count=0;
        //            }
                   }
                   else {
                    nb=nb+ (count/size);
                    count=0;
                   }
                   }
                   
            //  System.out.println("nb = "+nb);
             nb=nb+ (count/size);
                   if(nb>=bou){
                
                    return true;
                   }
                
                return false;
            }
}
