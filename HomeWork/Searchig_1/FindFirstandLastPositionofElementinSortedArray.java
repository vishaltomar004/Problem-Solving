package HomeWork.Searchig_1;

/**
 * FindFirstandLastPositionofElementinSortedArray
 */
public class FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        // using binary seacrh found one element that equala target and broke the loop
        // and stored it in index named variable
        // Using two functions found the right index and left index using binary search
        // again
        // like to find left or the min value we are using a function which is taking
        // index as length of array
        // similarly for the max index , function is taking index af lowest value
        int left = 0;
        int right = nums.length - 1;
        int min = 0;
        int max = 0;
        int index = 0;
        boolean f = false;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                f = true;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int a[] = new int[2];
        if (nums.length == 1 && nums[0] == target) {
            a[0] = 0;
            a[1] = 0;
            return a;
        }
        int l = -1;
        int r = -1;
        a[0] = l;
        a[1] = r;
        if (f) {
            l = bsLeft(nums, index, target);
            r = bsRight(nums, index, target);
            a[0] = l;
            a[1] = r;
        }
        System.out.println(l + "  " + r);

        return a;

    }

    public int bsLeft(int a[], int index, int target) {
        int left = 0;
        int right = index;
        int min = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] == target) {
                if (mid < index) {
                    index = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return index;
    }

    public int bsRight(int a[], int index, int target) {
        int left = index;
        int right = a.length - 1;
        int min = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] == target) {
                if (mid > index) {
                    index = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return index;
    }
}