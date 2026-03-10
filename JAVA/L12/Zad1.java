import java.util.Random;
import java.util.concurrent.Semaphore;

class BufferOne {
    private int value;
    private final Semaphore semEmpty = new Semaphore(1); // Kontorluje czy jest pusty (Producent moze pisać)
    private final Semaphore semFull = new Semaphore(0); // Kontorulje czy bufor jes pełny (Konsument może czytać)

    public void put(int x) {
        try {
            semEmpty.acquire(); // Czeka az bufor bedzie pusty
            this.value = x;
            semFull.release();  // Sygnal ze towar jest gotowy (zwiekszenie licznika)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int get() {
        int x = 0;
        try {
            semFull.acquire(); // Czeka na towar
            x = this.value;
            semEmpty.release(); // Zwieksza licznik wolnych miejsc
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return x;
    }
}

class Producer1 extends Thread {
    private final BufferOne buffer;
    private final Random random = new Random();
    public static final int randomMin = 500;
    public static final int randomRangeMax = 4501;

    public Producer1(BufferOne buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                int x = randomMin + random.nextInt(randomRangeMax); // [500;5000]
                buffer.put(x);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class Consumer1 extends Thread {
    private final BufferOne buffer;
    private final int id;

    public Consumer1(BufferOne buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                int x = buffer.get();
                System.out.println("Konsument " + id + " rozpoczął " + x);
                Thread.sleep(x);
                System.out.println("Konsument " + id + " zakończył " + x);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}



public class Zad1 {
    public static void main(String[] args) {
        BufferOne buffer = new BufferOne();

        new Producer1(buffer).start();

        for (int i = 1; i <= 3; i++) {
            new Consumer1(buffer, i).start();
        }
    }
}
