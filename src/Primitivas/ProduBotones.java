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
public class ProduBotones extends Productores{
    
    public ProduBotones(float produXDia, Semaphore mutex, Semaphore semCons, Semaphore semProd,Semaphore semSal, float sal) {
        super(produXDia,mutex,semCons,semProd,semSal,sal);
    }
    @Override
    public void run() {
        while (hired) {
            try {
                while (this.semProd.availablePermits() == 0) {
                    Thread.sleep((long) (Main.dataTXT[0] * 1000 / 24));
                    this.semSal.acquire();
                    sal += 4;
                    this.semSal.release();
                }
                Thread.sleep((long) this.tiempoProdu);
                this.semProd.acquire();
                this.mutex.acquire();
                this.semSal.acquire();
                sal += ((tiempoProdu/1000)*4);
                Main.buttons++;
                //System.out.println("Botones:" + Main.buttons);
                this.mutex.release();
                this.semSal.release();
                this.semCons.release();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecución del productor de botones.", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
    }
    
    
}
