package main.java.concurrency.synchronization;

public class Monitor {
    int activeReaders = 0;
    boolean activeWriters = false;

    //En esta parte nos encargamos de manejar el recurso compartido

    //Si hay algún escritor activo, espera hasta que termine de realizar su trabajo.
    public synchronized void  startRead() throws InterruptedException {
        while(activeWriters){
            wait();
        }
        activeReaders++;
    }
    //Si hay algún lector o escritor activo, espera hasta que alguno termine su trabaho.
    public synchronized void startWrite() throws InterruptedException {
        while(activeWriters || activeReaders > 0){
            wait();
        }
        activeWriters = true;
    }

    public synchronized void stopWrite() throws InterruptedException {
        activeWriters = false;
        notifyAll();
    }
    public synchronized void stopRead() throws InterruptedException {
        activeReaders--;
        if(activeReaders == 0){
            notifyAll();
        }
    }

}
