/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitivas;

import Main.Main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Achicopalado
 */

public class dataRead {
    
    public static boolean isInt(String n){
        try {
            Integer.parseInt(n);
            return true;
        } catch (Exception e){
            return false;
        }       
    }
    
    public static void read(){
        String path = "test\\datos_iniciales.txt";
        String l;
        File f = new File(path);
        try {
            FileReader fReader = new FileReader(f);
            BufferedReader bReader = new BufferedReader(fReader);
            int i = 0;
            
            while ((l = bReader.readLine()) != null) {
                if (isInt(l)){
                    Main.dataTXT[i] = Integer.parseInt(l);
                    i++;
                    
                }
                
                    
            }
            bReader.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la lectura de los datos iniciales", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
    public static void write() {
        try{
            String newData = "dias en segundos:\n"
                    +Integer.toString(Main.dataTXT[0])
                    +"\ndias entre despacho:\n"
                    +Integer.toString(Main.dataTXT[1])
                    +"\ncapacidad max en almacen de pantallas:\n"
                    +Integer.toString(Main.dataTXT[2])
                    +"\ncapacidad max en almacen de botones:\n"
                    +Integer.toString(Main.dataTXT[3])
                    +"\ncapacidad max en almacen de pines de carga:\n"
                    +Integer.toString(Main.dataTXT[4])
                    +"\ncapacidad max en almacen de camaras:\n"
                    +Integer.toString(Main.dataTXT[5])
                    +"\nproductores de pantallas:\n"
                    +Integer.toString(Main.dataTXT[6])
                    +"\nproductores de botones:\n"
                    +Integer.toString(Main.dataTXT[7])
                    +"\nproductores de pines de carga:\n"
                    +Integer.toString(Main.dataTXT[8])
                    +"\nproductores de camaras:\n"
                    +Integer.toString(Main.dataTXT[9])
                    +"\nensambladores:\n"
                    +Integer.toString(Main.dataTXT[10]);
            PrintWriter pW = new PrintWriter("test\\datos_iniciales.txt");
            pW.print(newData);
            pW.close();
            JOptionPane.showMessageDialog(null, "La data se ha actualizado");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
