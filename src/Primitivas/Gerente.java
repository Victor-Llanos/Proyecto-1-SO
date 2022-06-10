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
public class Gerente extends Thread {

    Semaphore mutex;
    Semaphore mutexPhone;

    float watching;
    float working;
    float counter;
    Semaphore mutexWork;
    Semaphore mutexTotalDelivery;

    public Gerente(Semaphore mutex, Semaphore mutexPhone, Semaphore mutexWork, Semaphore mutexTotalDelivery) {
        this.mutex = mutex;
        this.mutexPhone = mutexPhone;
        this.mutexWork = mutexWork;
        this.mutexTotalDelivery = mutexTotalDelivery;
        this.working = (float) ((ThreadLocalRandom.current().nextInt(12, 19)) * Main.dataTXT[0] / 24);
        this.counter = 0;
        this.watching = (float) (((ThreadLocalRandom.current().nextInt(30, 91)) * (Main.dataTXT[0]) *1000/ 1440) ); //colocar horas x cdi

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (working * 1000)); //Trabaja
                this.mutex.acquire();
                if (Jefazo.endDay <= 0) {
                    Jefazo.endDay = Main.dataTXT[1];
                    this.mutex.release();

                    this.mutexPhone.acquire();

                    Main.phones = Main.phones + Main.totalPhones;
                    Main.totalPhones = 0;
                    this.mutexPhone.release();

                    this.mutexTotalDelivery.acquire();

                    Main.totalDelivery++;

                    this.mutexTotalDelivery.release();

                    this.mutexWork.acquire();
                    Main.managerWorking = false;
                    this.mutexWork.release();
                    Thread.sleep((long) (watching));

                } else {
                    this.mutex.release();
                    this.mutexWork.acquire();
                    Main.managerWorking = false;
                    this.mutexWork.release();
                    if(!Main.bossWorking){
                        //System.out.println("Ajá);
                    }

                    Thread.sleep((long) (watching));
                    
                    this.mutexWork.acquire();
                    Main.managerWorking = true;
                    this.mutexWork.release();


                }
            } catch (Exception e) {
                //?
                javax.swing.JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecución del gerente.", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }

        }
    }
}
