package HomeWork.Tree_4_and_5;
class Tree {
    
}
public class BSTOneChild {
    boolean hasOnlyOneChild(int pre[], int size) {
        int nextDiff, lastDiff;
 
        for (int i = 0; i < size - 1; i++) {
            nextDiff = pre[i] - pre[i + 1];
            lastDiff = pre[i] - pre[size - 1];
            if (nextDiff * lastDiff < 0) {
                return false;
            };
        }
        return true;

        public static void main(String[] args) {
            Tree tree = new Tree();
            int pre[] = new int[]{8, 3, 5, 7, 6};
            int size = pre.length;
            if (tree.hasOnlyOneChild(pre, size) == true) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
}
