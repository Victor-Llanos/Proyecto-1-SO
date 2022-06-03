/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitivas;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author yunch
 */
public class Manager extends Thread {

    Semaphore mutex;
    Semaphore mutexPhone;
    float working;
    float clashTime;
    Semaphore mutexPlay;
    Semaphore mutexTotalDelivery;

    public Manager(Semaphore mutex, Semaphore mutexPhone, Semaphore mutexPlay, Semaphore mutexTotalDelivery) {
        this.mutex = mutex;
        this.mutexPhone = mutexPhone;
        this.mutexPlay = mutexPlay;
        this.mutexTotalDelivery = mutexTotalDelivery;
    }
    @Override
    public void run (){
        while(true) {
            try{
                this.mutex.acquire();
                int randomNum = ThreadLocalRandom.current().nextInt(12, 19);
                
            }catch (Exception e){
                //?
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecución del gerente.", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            
        }
    }
}
