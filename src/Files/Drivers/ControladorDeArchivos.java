/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files.Drivers;
import java.io.*;
import java.util.LinkedList;
/**
 *
 * @author kevin
 * @param <T>
 */
public abstract class ControladorDeArchivos<T>  {
    /*
    El siguiente codigo funciona para escribir archivos binarios en el disco duro
    */
    public void escribirEnArchivo(String filePath, T instruction){
        ObjectOutputStream fileOut;
        try{
            fileOut = new ObjectOutputStream(                                   //Este comando inizializa un nuevo flujo de salida
            new FileOutputStream(filePath));                            //en otras palabras abre el archivo, como no existe, lo crea.
            fileOut.writeObject(instruction);                               //Escribe el objeto solicitud en el archivo
            fileOut.close();                                                    //Cierra el archivo
        } 
        catch (IOException e){                                              //Captura todas las excepciones posibles de entrada y salida de datos
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    public void crearArchivo(String nombre){
        DataOutputStream fileOut;
        try{
            fileOut = new DataOutputStream(                                   //Este comando inizializa un nuevo flujo de salida
                      new FileOutputStream(nombre));                                      //en otras palabras abre el archivo, como no existe, lo crea.
            fileOut.writeInt(1);
            fileOut.close();                                                    //Cierra el archivo
        } 
        catch (IOException e){                                                  //Captura todas las excepciones posibles de entrada y salida de datos
            System.out.println("Error: " + e.getMessage());
        }
    }

    public T readInstruction(String filePath) {
        ObjectInputStream fileIn;
        try{
            fileIn = new ObjectInputStream(new FileInputStream(filePath));
            T value = (T) fileIn.readObject();
            fileIn.close();
            return value;
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        return null;
    }
    
    public LinkedList<File> getFiles(String fileExtension) {
        LinkedList<File> files = new LinkedList<>();
        File folder = new File(new File(".").getAbsolutePath());
        for (File file : folder.listFiles()) {
            if(file.getPath().endsWith(fileExtension)) {
                files.add(file);
            }
        }
        return files;
    }
    
    public abstract void executeSpecialOperation(String path, Object value);
}



