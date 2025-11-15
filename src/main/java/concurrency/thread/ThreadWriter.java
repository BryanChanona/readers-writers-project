package main.java.concurrency.thread;

import main.java.concurrency.pattern.ReaderWriter;

public class ThreadWriter implements Runnable {
    private final ReaderWriter writer;
    private final String name;

    public ThreadWriter(String name,ReaderWriter writer) {
        this.writer = writer;
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            writer.write(name);
        }
    }
}
