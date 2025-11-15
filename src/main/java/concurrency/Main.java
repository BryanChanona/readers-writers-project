package main.java.concurrency;

import main.java.concurrency.pattern.ReaderWriter;
import main.java.concurrency.synchronization.Monitor;
import main.java.concurrency.thread.ThreadReader;
import main.java.concurrency.thread.ThreadWriter;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        ReaderWriter readerWriter = new ReaderWriter(monitor);

        Thread r1 = new Thread(new ThreadReader("Lector 1", readerWriter));
        Thread r2 = new Thread(new ThreadReader("Lector 2", readerWriter));
        Thread r3 = new Thread(new ThreadReader("Lector 3", readerWriter));
        Thread r4 = new Thread(new ThreadReader("Lector 4", readerWriter));
        Thread r5 = new Thread(new ThreadReader("Lector 5", readerWriter));
        Thread r6 = new Thread(new ThreadReader("Lector 6", readerWriter));
        Thread r7 = new Thread(new ThreadReader("Lector 7", readerWriter));

        Thread w1 = new Thread(new ThreadWriter("Escritor 1",readerWriter));
        Thread w2 = new Thread(new ThreadWriter("Escritor 2",readerWriter));

        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();
        r6.start();
        r7.start();
        w1.start();
        w2.start();

    }
}
