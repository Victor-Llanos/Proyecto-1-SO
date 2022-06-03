/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitivas;
import Main.Main;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Achicopalado
 */
public abstract class Productores extends Thread {

    //Pseudo valores de la herencia posibles cambios a futuro (semaforos)
    //dependera de si existe o no la clase "planta"
    float tiempoProdu;
    float produXDia;
    Semaphore mutex;
    Semaphore semProd;
    Semaphore semCons;

    public Productores(float produXDia, Semaphore mutex, Semaphore semCons, Semaphore semProd) {
        
        this.produXDia = produXDia;
        this.tiempoProdu = (float)Main.dataTXT[0]/this.produXDia*1000;
        this.mutex = mutex;
        this.semCons = semCons;
        this.semProd = semProd;
    }

    @Override
    public void run() {
        //para override
    }

}
