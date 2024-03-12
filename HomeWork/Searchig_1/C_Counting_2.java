package HomeWork.Searchig_1;

import java.util.Scanner;

public class C_Counting_2 {
    public static void main(String[] args) {

        // applying linear search 
        // Will check every element in array a to the given input is greater or equal the counter else do nothing
        // print the count
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int std=sc.nextInt();

        int a[] = new int[n];
        for(int i =0; i<n; i++){
            a[i]=sc.nextInt();
        }


        for(int i =0; i<std; i++){
            int x= sc.nextInt();

             int count=0;
             for(int e:a){
                if(e>=x){
                    count++;
                }
             }
             System.out.println(count);
        }
    }
}
