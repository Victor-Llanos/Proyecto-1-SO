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
 * @author yunch
 */
public class Assembler extends Thread {

    float assTime;
    Semaphore mutexScreens;
    Semaphore mutexButts;
    Semaphore mutexPins;
    Semaphore mutexCams;
    volatile boolean estado;

    Semaphore mutexPhones;

    Semaphore semConsScreens;
    Semaphore semConsButts;
    Semaphore semConsPins;
    Semaphore semConsCams;

    Semaphore semProdScreens;
    Semaphore semProdButts;
    Semaphore semProdPins;
    Semaphore semProdCams;

    boolean hired;

    public Assembler(Semaphore mutexScreens,
            Semaphore mutexButts,
            Semaphore mutexPins,
            Semaphore mutexCams,
            Semaphore mutexPhones,
            Semaphore semConsScreens,
            Semaphore semConsButts,
            Semaphore semConsPins,
            Semaphore semConsCams,
            Semaphore semProdScreens,
            Semaphore semProdButts,
            Semaphore semProdPins,
            Semaphore semProdCams) {
        this.assTime = (float) Main.dataTXT[0] * 1000 * 2;
        this.mutexScreens = mutexScreens;
        this.mutexButts = mutexButts;
        this.mutexPins = mutexPins;
        this.mutexCams = mutexCams;
        this.mutexPhones = mutexPhones;
        this.semConsScreens = semConsScreens;
        this.semConsButts = semConsButts;
        this.semConsPins = semConsPins;
        this.semConsCams = semConsCams;
        this.semProdScreens = semProdScreens;
        this.semProdButts = semProdButts;
        this.semProdPins = semProdPins;
        this.semProdCams = semProdCams;
        this.hired = true;
    }

    public void setHired(boolean hired) {
        this.hired = hired;
    }

    @Override
    public void run() {
        while (hired) {
            System.out.println(Main.salAss);
            try {
                estado = (((int) Main.needPantalla > this.semConsScreens.availablePermits())
                        && (int) Main.needPines > this.semConsButts.availablePermits()
                        && ((int) Main.needCamaras > this.semConsCams.availablePermits())
                        && (1 > this.semConsPins.availablePermits()));
                while ((((int) Main.needPantalla > this.semConsScreens.availablePermits())
                        && (int) Main.needPines > this.semConsButts.availablePermits()
                        && ((int) Main.needCamaras > this.semConsCams.availablePermits())
                        && (1 > this.semConsPins.availablePermits()))) {
                    Thread.sleep((long) (Main.dataTXT[0] * 1000 / 24));
                    Main.semSalAss.acquire();
                    Main.salAss += 6;
                    System.out.println(Main.salAss);
                    Main.semSalAss.release();
                    estado = (((int) Main.needPantalla >= this.semConsScreens.availablePermits())
                            && (int) Main.needPines >= this.semConsButts.availablePermits()
                            && ((int) Main.needCamaras >= this.semConsCams.availablePermits())
                            && (1 >= this.semConsPins.availablePermits()));
                }
                System.out.println("armando");
                Thread.sleep((long) this.assTime);
                //System.out.println("pedir pantalla" + semConsScreens.availablePermits());
                this.semConsScreens.acquire((int) Main.needPantalla); // Nos aseguramos de que el consumidor (ensamblador) tenga las piezas necesarias
                //System.out.println("pedido pantalla" + semConsScreens.availablePermits());
                //System.out.println("pedir Botones" + semConsButts.availablePermits());
                this.semConsButts.acquire((int) Main.needPines);
                //System.out.println("pedido Botones" + semConsButts.availablePermits());
                //System.out.println("pedir Pines" + semConsPins.availablePermits());
                this.semConsPins.acquire(1);
                //System.out.println("pedido Pines" + semConsPins.availablePermits());
                //System.out.println("pedir Camaras" + semConsCams.availablePermits());
                this.semConsCams.acquire((int) Main.needCamaras);
                //System.out.println("pedido Camaras" + semConsCams.availablePermits());

                this.mutexPhones.acquire();
                this.mutexScreens.acquire();
                this.mutexButts.acquire();
                this.mutexPins.acquire();
                this.mutexCams.acquire();
                Main.semSalAss.acquire();
                Main.totalPhones++;
                Main.screens = Main.screens - (int) Main.needPantalla;
                Main.buttons = Main.buttons - (int) Main.needPines;
                Main.pins--;
                Main.cams = Main.cams - (int) Main.needCamaras; // Eliminamos de los almacenes las piezas consumidas

                Main.salAss += ((this.assTime / 1000 * 24)*6);

                Main.semSalAss.release();
                this.mutexButts.release();
                this.mutexPins.release();
                this.mutexScreens.release();
                this.mutexPins.release();
                this.mutexCams.release();
                this.mutexPhones.release();

                this.semProdScreens.release((int) Main.needPantalla); // Se "sueltan" los permisos de semáforos de esas piezas
                this.semProdButts.release((int) Main.needPines);
                this.semProdPins.release(1);
                this.semProdCams.release((int) Main.needCamaras);
                //System.out.println("AAAAAAAAAA" + Main.totalPhones);
                System.out.println(Main.salAss);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecución del Ass-embler.", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }

        }
    }
}
