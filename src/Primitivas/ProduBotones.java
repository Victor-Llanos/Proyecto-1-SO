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
    
    public ProduBotones(float produXDia, Semaphore mutex, Semaphore semCons, Semaphore semProd) {
        super(produXDia,mutex,semCons,semProd);
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) this.tiempoProdu);
                this.semProd.acquire();
                this.mutex.acquire();
                Main.buttons++;
                System.out.println("pins:" + Main.buttons);
                this.mutex.release();

                this.semCons.release();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecución del productor de botones.", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
    }
    
    
}
