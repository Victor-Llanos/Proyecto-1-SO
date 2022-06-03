/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Primitivas.Assembler;
import Primitivas.ProduBotones;
import Primitivas.ProduCamaras;
import Primitivas.ProduPantallas;
import Primitivas.ProduPin;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 *
 * @author yunch
 */
public class Main {

    public static int[] dataTXT = new int[11];
    
    public static volatile int buttons = 0;
    public static volatile int cams = 0;
    public static volatile int screens = 0;
    public static volatile int pins = 0;

    public static volatile boolean bossPlaying = false;
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

    public static Semaphore playBoss;

    public static Semaphore semProdCams;
    public static Semaphore semConsCams;
    public static Semaphore semProdButt;
    public static Semaphore semConsButt;
    public static Semaphore semProdPins;
    public static Semaphore semConsPins;
    public static Semaphore semProdScreens;
    public static Semaphore semConsScreens;

    public static volatile ProduBotones amtProdbutt[];
    public static volatile ProduCamaras amtProdcam[];
    public static volatile ProduPantallas amtProdscreen[];
    public static volatile ProduPin amtProdpin[];
    public static volatile Assembler amtAssembler[];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, float[]> map = new HashMap<String, float[]>();

        float[] juan = new float[9];

        juan[0] = 1;
        juan[1] = 1;
        juan[2] = 4;
        juan[3] = (float) 0.5;
        juan[4] = (float) 0.5;
        juan[5] = 3;
        juan[6] = 1;
        juan[7] = 4;
        juan[8] = 900;

        float[] vic = new float[9];

        vic[0] = 4;
        vic[1] = 2;
        vic[2] = 2;
        vic[3] = (float) 0.33;
        vic[4] = (float) 0.5;
        vic[5] = 2;
        vic[6] = 1;
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

        // TODO code application logic here
        semProdScreens = new Semaphore(40);
        semConsScreens = new Semaphore(0);
        mutexScreens = new Semaphore(1);

        semProdButt = new Semaphore(45);
        semConsButt = new Semaphore(0);
        mutexButt = new Semaphore(1);

        semProdPins = new Semaphore(15);
        semConsPins = new Semaphore(0);
        mutexPins = new Semaphore(1);

        semProdCams = new Semaphore(20);
        semConsCams = new Semaphore(0);
        mutexCams = new Semaphore(1);

    }

}
