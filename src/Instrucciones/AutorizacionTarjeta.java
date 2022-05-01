package Instrucciones;

import CreditCard.TarjetaDeCredito;
import Drivers.RequestDriver;
import Files.Drivers.CreditCardFileDriver;
import Files.Drivers.InstructionFileDriver;


public class AutorizacionTarjeta extends Instruccion {
    @Override
    public void evaluarLinea(String line){
        try{
            InstructionFileDriver instructionDriver = new InstructionFileDriver();
            CreditCardFileDriver controlador = new CreditCardFileDriver();
            int numeroDeSolicitud=Integer.valueOf(line
                    .replaceAll("AUTORIZACION_TARJETA", "")
                    .replace("(", "")
                    .replace(")", ""));
            //Se crea una variable con el nombre del archivo que contiene a nuestra solicitud
            System.out.println("numero de solicitud: " + numeroDeSolicitud);
            String nombreDelArchivo="Solicitud"+numeroDeSolicitud+".sol";
            //Se instancia un objeto controlador para acceder a un metodo que no es estatico
            //De esta manera se captura el objeto del tipo Solicitud y se asigna a la variable Solicitud Actual
            Solicitud solicitudActual= (Solicitud) instructionDriver.readInstruction(nombreDelArchivo);
            RequestDriver requestDriver = new RequestDriver(solicitudActual);
            //Se capturan los atributos de nuestra solicitud
           TarjetaDeCredito card = requestDriver.processRequest();
           if(card.getNumeroDeTarjeta() == null) {
               return;
           } else {
               controlador.escribirEnArchivo("Tarjeta"+card.getNumeroDeTarjeta()+".tacre", card);
           }
        } catch(NullPointerException e){
            throw new AssertionError("No puede autorizar una solicitud que no exista", e);
        }
    }
}
