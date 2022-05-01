/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files.Drivers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author zofia-px
 */
public class HTMLFileDriver {
        
    public void edicionDeReporteHTML(String textoEntrante){
        File archivo = new File("Reportes.html");
        FileOutputStream salida = null;
        try {
            salida = new FileOutputStream(archivo,true);
            salida.write(textoEntrante.getBytes());
            salida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage()+" no se pudo grabar el texto");
        }
    }
}
