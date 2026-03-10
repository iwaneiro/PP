import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;

public class Debug {
    public void fields(Object o) {
        if (o == null) {
            System.out.println("\n" + "Przekazano obiekt null");
            return;
        }
        Class<?> objectClass = o.getClass();
        System.out.println("\n"+"Klasa: " + objectClass.getSimpleName());

        Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            try{
                field.setAccessible(true);

                String name = field.getName();
                String type = field.getType().getSimpleName();
                Object value = field.get(o);

                System.out.println("Pole: " + name + ", " + type + ", " + value);
            } catch (IllegalAccessException e) {
                System.out.println("Nie udało się odczytać pola: " + field.getName());            
            } catch (InaccessibleObjectException e){
                System.out.println("Brak dostepu do pola: " + field.getName());
            }
        }
    }
    public static void main(String[] args) {
        Debug debugger = new Debug();
        
        Point p = new Point(3, 4);
        debugger.fields(p);
        
        Student s = new Student("Adam", 21, true);
        debugger.fields(s);
        
        debugger.fields(new Empty());
        debugger.fields(null);

        debugger.fields("Test wbudowanego Stringa");
    }
}

class Point {
    private int xv;
    private int yv;
    private String a;
    
    public Point(int xv, int yv) {
        this.xv = xv;
        this.yv = yv;
        this.a = "test";
    }
}

class Student {
    private String name;
    private int age;
    private boolean passed;
    private double avg;

    public Student(String name, int age, boolean passed) {
        this.name = name;
        this.passed = passed;
        this.age = age;
        this.avg = 4.5;
    }
}

class Empty {}
