
public class zad1 {
    
    public static void printAll(Object... args) {
        printRecursive(args, 0);
    }

    private static void printRecursive(Object[] args, int index) {
        if (index >= args.length) {
            return;
        }
        Object current = args[index];

        if (current != null) {
            String typeName = current.getClass().getSimpleName();
            System.out.println(typeName + ": " + current);
        } else {
            System.out.println("Null: null");
        }
        printRecursive(args, index + 1);
    }

    public static void main(String[] args) {
        printAll(1, "hello", 3.14);
        System.out.println();
        printAll(new java.util.Date(), false);
        System.out.println();
        printAll(42);
        System.out.println();
        printAll();
        printAll("Hello", null, 999);
    }
}