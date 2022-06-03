/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Interfaz.Menu_principal;
import Primitivas.Assembler;
import Primitivas.ProduBotones;
import Primitivas.ProduCamaras;
import Primitivas.ProduPantallas;
import Primitivas.ProduPin;
import Primitivas.dataRead;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 *
 * @author yunch
 */
public class Main {

    public static int[] dataTXT;

    public static volatile int buttons = 0;
    public static volatile int cams = 0;
    public static volatile int screens = 0;
    public static volatile int pins = 0;

    public static volatile boolean bossWorking = false;
    public static volatile int totalPhones = 0;
    public static volatile int totalDelivery = 0;

    public static float cdi;
    public static float pantallas;
    public static float botones;
    public static float pines;
    public static float camaras;
    public static float needPantalla;
    public static float needPines;
    public static float needCamaras;
    public static float price;
    public static float maxProd;

    public static Semaphore mutexButt;
    public static Semaphore mutexCams;
    public static Semaphore mutexScreens;
    public static Semaphore mutexPins;
    public static Semaphore mutexDays;

    public static Semaphore mutexPhones;
    public static Semaphore mutexTotalDelivery;

    public static Semaphore mutexWorkJefazo;
    //public static Semaphore mutexWorkManager;

    public static Semaphore semProdCams;
    public static Semaphore semConsCams;
    public static Semaphore semProdButt;
    public static Semaphore semConsButt;
    public static Semaphore semProdPins;
    public static Semaphore semConsPins;
    public static Semaphore semProdScreens;
    public static Semaphore semConsScreens;

    public static volatile int countProdScreens;
    public static volatile int countProdButts;
    public static volatile int countProdPins;
    public static volatile int countProdCams;
    public static volatile int countAssembler;

    public static volatile ProduPantallas amtProdscreen[];
    public static volatile ProduBotones amtProdbutt[];
    public static volatile ProduPin amtProdpin[];
    public static volatile ProduCamaras amtProdcam[];
    public static volatile Assembler amtAssembler[];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dataTXT = new int[11];
        dataRead.read();
        Map<String, float[]> map = new HashMap<String, float[]>();

        float[] juan = new float[9];

        juan[0] = 1;
        juan[1] = 1;
        juan[2] = 4;
        juan[3] = (float) 0.5;
        juan[4] = (float) 0.5;
        juan[5] = 1;
        juan[6] = 4;
        juan[7] = 3;
        juan[8] = 900;

        float[] vic = new float[9];

        vic[0] = 4;
        vic[1] = 2;
        vic[2] = 2;
        vic[3] = (float) 0.33;
        vic[4] = (float) 0.5;
        vic[5] = 1;
        vic[6] = 2;
        vic[7] = 2;
        vic[8] = 600;

        map.put("Xperia 10 IV", juan);
        map.put("Xperia 10 III", vic);

        String telefono = "Xperia 10 III";
        cdi = map.get(telefono)[0];
        pantallas = map.get(telefono)[1];
        botones = map.get(telefono)[2];
        pines = map.get(telefono)[3];
        camaras = map.get(telefono)[4];
        needPantalla = map.get(telefono)[5];
        needPines = map.get(telefono)[6];
        needCamaras = map.get(telefono)[7];
        price = map.get(telefono)[8];
        maxProd = 10 + cdi;

        countProdScreens = dataTXT[6];
        countProdButts = dataTXT[7];
        countProdPins = dataTXT[8];
        countProdCams = dataTXT[9];
        countAssembler = dataTXT[10];

        amtProdscreen = new ProduPantallas[dataTXT[6]];
        amtProdbutt = new ProduBotones[dataTXT[7]];
        amtProdpin = new ProduPin[dataTXT[8]];
        amtProdcam = new ProduCamaras[dataTXT[9]];
        amtAssembler = new Assembler[dataTXT[10]];

        // TODO code application logic here       
        semProdScreens = new Semaphore(40);
        semConsScreens = new Semaphore(0);
        mutexScreens = new Semaphore(1);

        for (int i = 0; i < countProdScreens; i++) {
            amtProdscreen[i] = new ProduPantallas(pantallas, mutexScreens, semConsScreens, semProdScreens);
            amtProdscreen[i].start();
        }

        semProdButt = new Semaphore(45);
        semConsButt = new Semaphore(0);
        mutexButt = new Semaphore(1);

        for (int i = 0; i < countProdButts; i++) {
            amtProdbutt[i] = new ProduBotones(botones, mutexButt, semConsButt, semProdButt);
            amtProdbutt[i].start();
        }

        semProdPins = new Semaphore(15);
        semConsPins = new Semaphore(0);
        mutexPins = new Semaphore(1);
        for (int i = 0; i < countProdPins; i++) {
            amtProdpin[i] = new ProduPin(pines, mutexPins, semConsPins, semProdPins);
            amtProdpin[i].start();
        }

        semProdCams = new Semaphore(20);
        semConsCams = new Semaphore(0);
        mutexCams = new Semaphore(1);
        for (int i = 0; i < countProdCams; i++) {
            amtProdcam[i] = new ProduCamaras(camaras, mutexCams, semConsCams, semProdCams);
            amtProdcam[i].start();
        }

        mutexPhones = new Semaphore(1);   
        mutexDays = new Semaphore(1);
        mutexWorkJefazo = new Semaphore(1);
        
        for (int i = 0; i < countAssembler; i++) {
            amtAssembler[i] = new Assembler(mutexScreens,
                    mutexButt,
                    mutexPins,
                    mutexCams,
                    mutexPhones,
                    semConsScreens,
                    semConsButt,
                    semConsPins,
                    semConsCams,
                    semProdScreens,
                    semProdButt,
                    semProdPins,
                    semProdCams);
            amtAssembler[i].start();
        }
        
        Menu_principal m = new Menu_principal();

    }

}
