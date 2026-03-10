import java.util.Random;
import java.util.concurrent.Semaphore;

class BufferFIFO{
    private final int[] buffer;
    private final int size;
    private int putIndex = 0;
    private int takeIndex = 0;

    private final Semaphore semSpace; // Liczy wolne miejsca
    private final Semaphore semItems; // Liczy gotowe towary
    private final Semaphore mutex; // Klucz dostępu do indeksów tablicy

    public BufferFIFO(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.buffer = new int[size];
        this.size = size;
        this.semSpace = new Semaphore(size);
        this.semItems = new Semaphore(0);
        this.mutex = new Semaphore(1); // Tylko jeden wątek na raz
    }

    public void put(int x, int producerID) {
        try {
            semSpace.acquire(); // Czeka na wolne miejsca
            mutex.acquire(); // Początek sekcji krytycznej (Jeden wątek na raz)

            buffer[putIndex] = x;
            putIndex = (putIndex + 1) % size;
            System.out.println("Producent " + producerID + " wyprodukował " + x);

            mutex.release(); // Koniec sekcji krytycznej
            semItems.release(); // Powiadomienie ze jest towar
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int take() {
        int x = -1;
        try {
            semItems.acquire(); // Czeka na twoar
            mutex.acquire(); // Początek sekcji krytycznej

            x = buffer[takeIndex];
            takeIndex = (takeIndex + 1) % size;

            mutex.release(); // koneic sekcji krytycznej
            semSpace.release(); // Powiadomienie ze zwolniono miejsce
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return x;
    }
}

class Producer2 extends Thread {
    private final BufferFIFO buffer;
    private final int id;
    private final Random random = new Random();
    public static final int randomMin = 500;
    public static final int randomRangeMax = 4501;

    public Producer2(BufferFIFO buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                int x = randomMin + random.nextInt(randomRangeMax);
                buffer.put(x, id);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class Consumer2 extends Thread {
    private final BufferFIFO buffer;
    private final int id;

    public Consumer2(BufferFIFO buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                int x = buffer.take();
                System.out.println("Konsument " + id + " rozpoczął " + x);
                Thread.sleep(x);
                System.out.println("Konsument " + id + " zakończył " + x);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

public class Zad2 {
    public static void main(String[] args) {
        BufferFIFO buffer = new BufferFIFO(5);

        for (int i = 1; i <= 3; i++) {
            new Producer2(buffer, i).start();
        }

        for (int i = 1; i <= 3; i++) {
            new Consumer2(buffer, i).start();
        }
    }
}
