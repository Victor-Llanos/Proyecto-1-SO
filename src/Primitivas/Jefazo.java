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
public class Jefazo extends Thread{
    
    public static volatile int endTime;
    Semaphore mutex;
    Semaphore mutexPlay;
    float working;
    float clashTime;

    public Jefazo(int endTime, Semaphore mutex, Semaphore mutexPlay) {
        this.mutex = mutex;
        this.mutexPlay = mutexPlay;
        this.working = (float)Main.dataTXT[0]; //colocar horas x cdi
        this.clashTime = (float)Main.dataTXT[0]; //colocar minutos x cdi
    }
    
    public void run() {
        try {
            Thread.sleep(Main.dataTXT[0]*1000);
            while(true) {
                this.mutexPlay.acquire();
                    Main.bossPlaying = false;
                
                Thread.sleep((long)working); 
                this.mutex.acquire();
                    this.endTime--;
                this.mutex.release();
                
                this.mutexPlay.acquire();
                    Main.bossPlaying = true;
                this.mutexPlay.release();
                
                Thread.sleep((long)clashTime);
                
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error del jefazo", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }
    
}
