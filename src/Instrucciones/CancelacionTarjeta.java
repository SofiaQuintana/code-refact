package Instrucciones;

import CreditCard.TarjetaDeCredito;
import Files.Drivers.CreditCardFileDriver;

public class CancelacionTarjeta extends Instruccion {
    @Override
    public void evaluarLinea(String line){
        try{
            String numeroDeTarjeta=line
                .replaceAll("CANCELACION_TARJETA","")
                .replace("(", "")
                .replace(")", "");
            String nombreDelArchivo="Tarjeta"+numeroDeTarjeta+".tacre";
            CreditCardFileDriver driver = new CreditCardFileDriver();
            TarjetaDeCredito tarjeta= (TarjetaDeCredito) driver.readInstruction(nombreDelArchivo);
            if(tarjeta.getCredito()< 0){
                tarjeta.setEstaActiva(false);
            }else{
                System.out.println("No se puede cancelar la tarjeta ya que tiene credito pendiente. ");
            }
        } catch(NullPointerException e){
            throw new AssertionError("No puede autorizar solicitudes que no existan ", e);
        }
    }
    
}
