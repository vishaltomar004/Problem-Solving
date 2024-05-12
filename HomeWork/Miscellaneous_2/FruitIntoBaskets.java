package HomeWork.Miscellaneous_2;

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        if (fruits.length < 3) return fruits.length;
        int count = 1;
        for (int i = 1; i < fruits.length; i++) {
            if (fruits[i - 1] == fruits[i]) count++;
            else break;
        }
        if (count == fruits.length) return fruits.length;
        int countMax = count;
        int[] arr = new int[]{fruits[count - 1], fruits[count++]};
        for (int i = count; i < fruits.length; i++) {
            int curr = fruits[i];
            if (arr[0] == curr) {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
                count++;
            } else if (arr[1] == curr) {
                count++;
            } else {
                if (countMax < count) countMax = count;
                count = 1;
                putIntoStackOfTwo(arr, curr);
                for (int j = i - 1; j > 0; j--) {
                    if (fruits[j] == arr[0]) count++;
                    else break;
                }
            }
        }
        return Math.max(count, countMax);
    }

    private int[] putIntoStackOfTwo(int[] arr, int n) {
        arr[0] = arr[1];
        arr[1] = n;
        return arr;
    }
}
