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
public class ProduPin extends Productores {

    public ProduPin(float produXDia, Semaphore mutex, Semaphore semCons, Semaphore semProd) {
        super(produXDia,mutex,semCons,semProd);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) this.tiempoProdu);
                this.semProd.acquire();
                this.mutex.acquire();
                Main.pins++;
                System.out.println("pins:" + Main.pins);
                this.mutex.release();

                this.semCons.release();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecución del productor de pins.", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
    }

}
