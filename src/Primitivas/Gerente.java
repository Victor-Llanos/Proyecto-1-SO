/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitivas;

import Main.Main;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author yunch
 */
public class Gerente extends Thread{
    Semaphore mutex;
    Semaphore mutexPhone;

    float clashTime;
    float working;

    Semaphore mutexWork;
    Semaphore mutexTotalDelivery;

    public Gerente(Semaphore mutex, Semaphore mutexPhone, Semaphore mutexWork, Semaphore mutexTotalDelivery) {
        this.mutex = mutex;
        this.mutexPhone = mutexPhone;
        this.mutexWork = mutexWork;
        this.mutexTotalDelivery = mutexTotalDelivery;

    }

    @Override
    public void run() {
        while (true) {
            try {

                working = ThreadLocalRandom.current().nextInt(12, 19);
                working = working * Main.dataTXT[0] / 24;
                Thread.sleep((long) working * 1000); //Trabaja
                this.mutex.acquire();
                if (Jefazo.endDay <= 0){
                    Jefazo.endDay = Main.dataTXT[1];
                    this.mutex.release();
                    this.mutexPhone.acquire();
                    
                }
            } catch (Exception e) {
                //?
                javax.swing.JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecución del gerente.", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }

        }
    }
}
