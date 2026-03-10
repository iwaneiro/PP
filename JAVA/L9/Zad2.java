import java.util.Arrays;

public class Zad2 {
    public static int[] removeDuplicates(int[] arr, int elem) {
        if (arr == null || arr.length == 0) return new int[]{};

        int n = arr.length;
        int[] temp = new int[n];
        int uniqueCount = 0;
        
        boolean elemSeen = false;

        for (int i = 0; i < n; i++) {
            int current = arr[i];

            if (current == elem) {
                if (!elemSeen) {
                    temp[uniqueCount++] = current;
                    elemSeen = true;
                }
            } else {
                temp[uniqueCount++] = current;
            }
        }
        
        int[] result = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeDuplicates(new int[]{1, 2, 2, 2, 3, 1, 4, 2}, 2)));
        System.out.println(Arrays.toString(removeDuplicates(new int[]{}, 2)));
        System.out.println(Arrays.toString(removeDuplicates(new int[]{1, 1, 1, 1}, 1)));
        System.out.println(Arrays.toString(removeDuplicates(new int[]{1, 2, 3}, 2)));
        System.out.println(Arrays.toString(removeDuplicates(new int[]{5, 1, 5, 1, 5}, 1)));
    }
}
