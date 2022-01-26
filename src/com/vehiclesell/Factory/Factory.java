package com.vehiclesell.Factory;

import com.vehiclesell.Monitor.Monitor;

public class Factory extends Thread {


    // Atributos creados
    private int productores;
    private int espacioVehiculos;
    private static int vehiculosProduciendo;
    private final Monitor buffer;

    // Constructor
    private final String[] listCars = {
            "Seat León", "Audi accidentado", "Nissan Qashqai",
            "Citröen Berlingo", "Volkswagen Polo", "Opel Meriva",
            "Fiat Punto", "Tesla Roadster", "Hyundia Ioniq"
    };

    public static int getVehiculosProduciendo() {
        return vehiculosProduciendo;
    }

    public Factory(int productores, int espacioVehiculos, int vehiculosProduciendo, Monitor buffer) {
        this.productores = productores;
        this.espacioVehiculos = espacioVehiculos;
        Factory.vehiculosProduciendo = vehiculosProduciendo;
        this.buffer = buffer;
    }

    // Método run, para comprobar las plantas en crecimiento, si excede, devuelve un error
    // En caso de ser correcto, creamos una verdura con su tiempoo de crecimiento..
    @Override
    public void run() {

        try{
            if(Factory.vehiculosProduciendo > this.espacioVehiculos){
                throw new Error("Se ha excedido el límite de vehículos disponibles");
            }else{
                for(int i = 0; i < Factory.vehiculosProduciendo;i++){
                    sleep(2500);
                    int vehiculo = (int) (Math.random() * this.listCars.length);
                    String miVehiculo = listCars[vehiculo];
                    int tiempoProduccion = (int) (Math.random() * 1200);
                    int productorRandom = (int) (Math.random() * this.productores);
                    sleep(tiempoProduccion);
                    buffer.Producir(miVehiculo);
                    System.out.println("El vehículo " + miVehiculo + " ha sido producido por el productor nº " + productorRandom +
                            " en un tiempo de : " + tiempoProduccion + " minutos.");
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
