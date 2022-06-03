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
public class ProduCamaras extends Productores {

    public ProduCamaras(float produXDia, Semaphore mutex, Semaphore semCons, Semaphore semProd) {
        super(produXDia,mutex,semCons,semProd);
    }

    @Override
    public void run() {
        while (hired) {
            try {
                Thread.sleep((long) this.tiempoProdu);
                this.semProd.acquire();
                this.mutex.acquire();
                Main.cams++;
                //System.out.println("Camaras:" + Main.cams);
                this.mutex.release();

                this.semCons.release();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecución del productor de camaras.", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
    }
}
