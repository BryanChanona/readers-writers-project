package main.java.concurrency.thread;

import main.java.concurrency.pattern.ReaderWriter;

public class ThreadReader implements Runnable {
    private final String name;
    private final ReaderWriter reader;

    public ThreadReader(String name, ReaderWriter reader) {
        this.name = name;
        this.reader = reader;
    }

    @Override
    public void run() {
        while (true) {
            reader.read(name);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
