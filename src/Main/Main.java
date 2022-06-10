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
import Primitivas.Jefazo;
import Primitivas.Gerente;
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

    public static volatile boolean bossWorking = true;
    public static volatile boolean managerWorking = true;
    public static volatile int totalPhones = 0;
    public static volatile int phones = 0;
    public static volatile int totalDelivery = 0;

    public static volatile float cdi;
    public static volatile float pantallas;
    public static volatile float botones;
    public static volatile float pines;
    public static volatile float camaras;
    public static volatile float needPantalla;
    public static volatile float needPines;
    public static volatile float needCamaras;
    public static volatile float price;
    public static volatile float maxProd;
    public static volatile Map<String, float[]> map;
    public static Semaphore mutexButt;
    public static Semaphore mutexCams;
    public static Semaphore mutexScreens;
    public static Semaphore mutexPins;
    public static Semaphore mutexDays;
    public static Semaphore mutexChange;

    public static Semaphore mutexPhones;
    public static Semaphore mutexTotalDelivery;

    public static Semaphore mutexWorkJefazo;
    public static Semaphore mutexWorkManager;

    public static Semaphore semSalCams;
    public static Semaphore semSalButts;
    public static Semaphore semSalPins;
    public static Semaphore semSalScreens;
    public static Semaphore semSalAss;
    public static Semaphore semSalBoss;
    public static Semaphore semSalManager;

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
    public static volatile String telefono;

    public static volatile ProduPantallas amtProdscreen[];
    public static volatile ProduBotones amtProdbutt[];
    public static volatile ProduPin amtProdpin[];
    public static volatile ProduCamaras amtProdcam[];
    public static volatile Assembler amtAssembler[];

    public static volatile float salButts = 0;
    public static volatile float salCams = 0;
    public static volatile float salScreens = 0;
    public static volatile float salPins = 0;
    public static volatile float salAss = 0;
    public static volatile float salBoss = 0;
    public static volatile float salManager = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dataTXT = new int[11];
        dataRead.read();
        map = new HashMap<String, float[]>();

        mutexChange = new Semaphore(1);
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
        vic[5] = 2;
        vic[6] = 3;
        vic[7] = 4;
        vic[8] = 1050;

        map.put("Xperia 10 IV", juan);
        map.put("Xperia Pro-I", vic);

        telefono = "Xperia Pro-I";
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
        semSalCams = new Semaphore(1);
        semSalButts = new Semaphore(1);
        semSalPins = new Semaphore(1);
        semSalScreens = new Semaphore(1);
        semSalAss = new Semaphore(1);
        semSalBoss = new Semaphore(1);
        semSalManager = new Semaphore(1);

        semProdScreens = new Semaphore(40);
        semConsScreens = new Semaphore(0);
        mutexScreens = new Semaphore(1);

        for (int i = 0; i < countProdScreens; i++) {
            amtProdscreen[i] = new ProduPantallas(pantallas, mutexScreens, semConsScreens, semProdScreens,semSalScreens, salScreens);
            amtProdscreen[i].start();
        }

        semProdButt = new Semaphore(45);
        semConsButt = new Semaphore(0);
        mutexButt = new Semaphore(1);

        for (int i = 0; i < countProdButts; i++) {
            amtProdbutt[i] = new ProduBotones(botones, mutexButt, semConsButt, semProdButt,semSalButts,salButts);
            amtProdbutt[i].start();
        }

        semProdPins = new Semaphore(15);
        semConsPins = new Semaphore(0);
        mutexPins = new Semaphore(1);
        for (int i = 0; i < countProdPins; i++) {
            amtProdpin[i] = new ProduPin(pines, mutexPins, semConsPins, semProdPins, semSalPins, salPins);
            amtProdpin[i].start();
        }

        semProdCams = new Semaphore(20);
        semConsCams = new Semaphore(0);
        mutexCams = new Semaphore(1);
        for (int i = 0; i < countProdCams; i++) {
            amtProdcam[i] = new ProduCamaras(camaras, mutexCams, semConsCams, semProdCams, semSalCams, salCams);
            amtProdcam[i].start();
        }

        mutexPhones = new Semaphore(1);
        mutexDays = new Semaphore(1);
        mutexWorkJefazo = new Semaphore(1);
        mutexWorkManager = new Semaphore(1);
        mutexTotalDelivery = new Semaphore(1);

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

        Jefazo j = new Jefazo(dataTXT[1], mutexDays, mutexWorkJefazo);
        Gerente g = new Gerente(mutexDays, mutexPhones, mutexWorkManager, mutexTotalDelivery);
        g.start();
        j.start();
        Menu_principal m = new Menu_principal();

    }

}
