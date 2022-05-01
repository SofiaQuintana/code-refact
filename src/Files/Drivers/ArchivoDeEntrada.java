package Files.Drivers;

import Drivers.InstructionDriver;
import Instrucciones.InstructionFactory;
import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;

public class ArchivoDeEntrada implements Serializable{
    private InstructionDriver instructionDriver = new InstructionDriver();
    private InstructionFactory factory = new InstructionFactory();
/*
    Este procedimiento sirve para leer el archivo de entrada 
    que contiene todas las instrucciones a ingresar al sistema.
    */
    public LinkedList<String> readFile(String path){ 
        InstructionFileDriver driver = new InstructionFileDriver();
        Scanner archivoDeEntrada;
        String line = "";
        LinkedList<String> instructions = new LinkedList<>();
        try{
           archivoDeEntrada = new Scanner(new FileReader(path));
           driver.crearArchivo("numeroNacionalCorriente.txt");
           driver.crearArchivo("numeroRegionalCorriente.txt");
           driver.crearArchivo("numeroInternacionalCorriente.txt");

           while (archivoDeEntrada.hasNextLine()){
               line = archivoDeEntrada.nextLine();
               System.out.println(line);
               instructions.add(line);
               instructionDriver.setInstruction(factory.getInstruccion(line));
               instructionDriver.execute(line);
           }
           archivoDeEntrada.close(); //luego de haber abierto el archivo de entrada tambien hay que cerrarlo para 
           //que se liberen desbloquerlo y que se liberen recursos. 
           return instructions;
        } catch (FileNotFoundException e){ // si el archivo no existe captura la excepcion y lanza un mensaje
           System.out.println("Error: " + e.getMessage());
        } 
        return null;
    }//cerramos el procedimiento asignarArchivo
    
    
}//cerramos la clase ArchivoDeEntrada. 
