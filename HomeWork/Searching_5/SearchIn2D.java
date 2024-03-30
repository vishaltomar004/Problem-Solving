package HomeWork.Searching_5;

public class SearchIn2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n =matrix[0].length;
        int i =0;
        if(target>matrix[m-1][n-1]){
            return false;
        }
        while(matrix[i][n-1]< target){
                i++;
        }
       int j=0;
       boolean found =false;
        while(j<n){
            if(matrix[i][j]==target){
                found= true;
                break;
            }
            j++;
        }

        return found;
    }
}
