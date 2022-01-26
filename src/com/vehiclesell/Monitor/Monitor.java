package com.vehiclesell.Monitor;

public class Monitor {

    private int top = 0;
    private String buff[];
    private boolean full = false;
    private boolean empty = true;

    // Constructor
    public Monitor(int vehicles) {
        this.buff = new String[vehicles];
    }


    //Métodos sincronizados para producir y comprar...
    public synchronized void Producir(String productos) throws InterruptedException{
        while (full) {
            wait();
        }
        buff[top] = productos;
        top = top + 1;
        empty = false;
        full = top >= buff.length;
        notifyAll();
    }

    public synchronized String Comprar() throws InterruptedException{
        while (empty) {
            wait();
        }
        top = top - 1;
        String buyedProduct = buff[top];
        full = false;
        empty = top <= 0;
        notifyAll();
        return buyedProduct;

    }
}
