package HomeWork.Tries_2;

public class Count ThatCanFormTwoArraysofEqualXOR {
    public int countTriplets(int[] arr) {
        int count=0;
for(int i=0;i<arr.length-1;i++)
{
int val=arr[i];
for(int k=i+1;k<arr.length;k++)
{
val^=arr[k];
if(val==0)
count+=(k-i);
}
}

    return count;
    }
}
