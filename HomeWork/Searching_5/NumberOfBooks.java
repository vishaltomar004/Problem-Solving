package HomeWork.Searching_5;

public class NumberOfBooks {
    
}

public class MaxBooksRead {
    public static int maxBooksRead(int[] A, int[] B, int K) {
        int totalBooksRead = 0;
        int totalTime = 0;
        int indexA = 0;
        int indexB = 0;

        while (totalTime <= K && (indexA < A.length || indexB < B.length)) {
            if (indexA < A.length && indexB < B.length) {
                if (A[indexA] <= B[indexB]) {
                    totalTime += A[indexA];
                    indexA++;
                } else {
                    totalTime += B[indexB];
                    indexB++;
                }
            } else if (indexA < A.length) {
                totalTime += A[indexA];
                indexA++;
            } else if (indexB < B.length) {
                totalTime += B[indexB];
                indexB++;
            }

            if (totalTime <= K) {
                totalBooksRead++;
            }
        }

        return totalBooksRead;
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 3};
        int[] B = {5, 2, 1, 3};
        int K = 10;
        System.out.println(maxBooksRead(A, B, K)); // Output: 3
    }
}