/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitivas;

import Main.Main;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

/**
 *
 * @author Achicopalado
 */
public class Jefazo extends Thread {

    public static volatile int endDay;
    Semaphore mutex;
    Semaphore mutexWork;
    float time;
    float counter;

    public Jefazo(int endDay, Semaphore mutex, Semaphore mutexWork) {
        this.endDay = endDay;
        this.mutex = mutex;
        this.mutexWork = mutexWork;
        this.time = (float) (15 + Main.cdi) * Main.dataTXT[0]*1000 / 1440; //colocar horas x cdi
        this.counter = 0;
    }

    public void run() {
        try {
            Thread.sleep(Main.dataTXT[0] * 1000);
            while (true) {
                while (counter <= (float) (Main.dataTXT[0])) {
                    this.mutexWork.acquire();
                    Main.bossWorking = true;
                    this.mutexWork.release();
                    Thread.sleep((long)(time));
                    counter += (time/1000);
                    
                    this.mutexWork.acquire();
                    Main.bossWorking = false;
                    this.mutexWork.release();
                    Thread.sleep((long)(time));
                    counter += (time/1000);
                }
                this.mutex.acquire();
                this.endDay--;
                counter = 0;
                this.mutex.release();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error del jefazo", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }

}
