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
import java.util.concurrent.Semaphore;

/**
 *
 * @author yunch
 */
public class Main {

    public static volatile int buttons = 0;
    public static volatile int cams = 0;
    public static volatile int screens = 0;
    public static volatile int pins = 0;
    
    public static volatile int totalPhones = 0;
    public static volatile int totalDelivery = 0;
    
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
