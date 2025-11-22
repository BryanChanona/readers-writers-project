package main.java.concurrency;

import main.java.concurrency.pattern.ReaderWriter;
import main.java.concurrency.synchronization.Monitor;
import main.java.concurrency.thread.ThreadReader;
import main.java.concurrency.thread.ThreadWriter;

public class Main {
    private static final int NUM_READERS = 7;
    private static final int NUM_WRITERS = 2;

    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        ReaderWriter readerWriter = new ReaderWriter(monitor);

        // Crear e iniciar lectores
        for (int i = 1; i <= NUM_READERS; i++) {
            Thread reader = new Thread(
                    new ThreadReader("Lector " + i, readerWriter)
            );
            reader.start();
        }

        // Crear e iniciar escritores
        for (int i = 1; i <= NUM_WRITERS; i++) {
            Thread writer = new Thread(
                    new ThreadWriter("Escritor " + i, readerWriter)
            );
            writer.start();
        }
    }
}