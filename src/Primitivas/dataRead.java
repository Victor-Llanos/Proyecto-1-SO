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
import javax.swing.JOptionPane;

/**
 *
 * @author Achicopalado
 */
public class dataRead {
    
    public static void read(){
        String path = "test\\datos_iniciales.txt";
        String l;
        File f = new File(path);
        try {
            FileReader fReader = new FileReader(f);
            BufferedReader bReader = new BufferedReader(fReader);
            int i = 0;
            while ((l = bReader.readLine()) != null) {
                    Main.dataTXT[i] = Integer.parseInt(l);
                    i++;
            }
            bReader.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la lectura de los datos iniciales", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
