/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.poo.codigo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisangelcuriel
 */
public class LecturaDeArchivo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fi = null;
        try {
            File f = new File(System.getProperty("user.dir") + "/archivo");
            fi = new FileInputStream(f);
            ObjectInputStream oi = new ObjectInputStream(fi);
            Persona ob = null;
            
            do {                
                ob = (Persona)oi.readObject();
                System.out.println(ob.toString());
            } while (true);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Fin del archivo");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fi.close();
            } catch (IOException ex) {
                Logger.getLogger(LecturaDeArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
