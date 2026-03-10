import java.lang.reflect.Array;
import java.util.Arrays;

public class Zad1 {
    private static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> T[] insert(T[] arr, T elem) {
        if (arr == null) {
            throw new NullPointerException("Array is null");
        }
        if (elem == null) {
            throw new NullPointerException("Element to insert cannot be null");
        }
        if (!isSorted(arr)) {
            throw new IllegalArgumentException("Array is not sorted!");
        }

        int n = arr.length;
        
        T[] result = (T[]) Array.newInstance(arr.getClass().getComponentType(), n + 1);

        int i = 0, j = 0;
        boolean inserted = false;

        while (i < n) {
            if (!inserted && elem.compareTo(arr[i]) <= 0) {
                result[j++] = elem;
                inserted = true;
            }
            result[j++] = arr[i++];
        }

        if (!inserted) {
            result[j] = elem;
        }

        return result;
    }
    
    public static void main(String[] args) {
        Integer[] liczby = {1, 3, 5, 7};
        Integer[] noweLiczby = insert(liczby, 4);
        System.out.println("Integer: " + Arrays.toString(noweLiczby));

        Character[] slowa = {'a', 'c'};
        Character[] noweSlowa = insert(slowa, 'b');
        System.out.println("Character: " + Arrays.toString(noweSlowa));
        
        liczby = new Integer[]{1, 2, 3};
        noweLiczby = insert(liczby, 0);
        System.out.println("Integer: " + Arrays.toString(noweLiczby));
        
        noweLiczby = insert(noweLiczby, 5);
        System.out.println("Integer: " + Arrays.toString(noweLiczby));
        
        liczby = new Integer[]{2, 1, 3};
        noweLiczby = insert(liczby, 4);
        System.out.println("Integer: " + Arrays.toString(noweLiczby));
    }
}
