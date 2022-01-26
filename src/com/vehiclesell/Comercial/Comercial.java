package com.vehiclesell.Comercial;

import com.vehiclesell.Factory.Factory;
import com.vehiclesell.Monitor.Monitor;

import static java.lang.Thread.sleep;

public class Comercial extends Thread {

    private final int comercial;
    private Monitor buffer;

    public Comercial(int comercial, Monitor buffer) {
        this.comercial = comercial;
        this.buffer = buffer;
    }

    @Override
    public void run(){
        try{
            for(int i = 0; i < Factory.getVehiculosProduciendo(); i++){
                sleep(5000);
                String comprarCoche = buffer.Comprar();
                int randomComercial = (int) (Math.random() * comercial);
                System.out.println("El comercial nº " + randomComercial + " ha vendido el vehículo: " + comprarCoche );
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
