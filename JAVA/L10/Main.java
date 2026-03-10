import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Podaj wysokość choinki (liczba całkowita >= 2):");
            int height;
            try {
                height = scanner.nextInt();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Height must be an integer");
            }
            scanner.nextLine();

            ChristmasTree tree = new PineTree(height);
            System.out.println("Choinka przed dekoracją:");
            System.out.println(tree);

            System.out.println("Wybierz dekorację (BAUBLES, LIGHTS, ANGEL):");
            String decorationName = scanner.nextLine();

            IDecoration decoration = DecorationFactory.getDecoration(decorationName);
            tree.applyDecoration(decoration);

            System.out.println("Dodajemy dekorację: " + decoration);
            System.out.println("Choinka po dekoracji:");
            System.out.println(tree);

        } catch (UnknownDecrationException e) {
            System.out.println("BŁĄD: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("BŁĄD DANYCH: " + e.getMessage());
        }
    }
}