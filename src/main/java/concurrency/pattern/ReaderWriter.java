package main.java.concurrency.pattern;
import main.java.concurrency.synchronization.Monitor;

public class ReaderWriter{

    private final Monitor monitor;
    private int sharedData = 0;

    public ReaderWriter(Monitor monitor) {
        this.monitor = monitor;
    }

    public void read(String name){
        try {
            monitor.startRead();
            System.out.println(name+ " leyendo: "+ sharedData);
            Thread.sleep(1000);
            monitor.stopRead();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void write(String name){
        try {
            monitor.startWrite();
            sharedData++;
            System.out.println(name + " escribiendo: " + sharedData);
            Thread.sleep(800); //Simular escritura
            monitor.stopWrite();
            Thread.sleep(150); // Hace visible la intermitencia
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
