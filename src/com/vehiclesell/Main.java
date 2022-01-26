package com.vehiclesell;

import com.vehiclesell.Comercial.Comercial;
import com.vehiclesell.Factory.Factory;
import com.vehiclesell.Monitor.Monitor;

public class Main {

    public static void main(String[] args) {

        Monitor monitor = new Monitor(10);

        Factory factory = new Factory(2,20,5,monitor);
        Comercial comercial = new Comercial(5, monitor);

        factory.start();
        comercial.start();

    }
}
