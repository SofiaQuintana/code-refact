/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files.Drivers;

import CreditCard.TarjetaDeCredito;

/**
 *
 * @author zofia-px
 */
public class CreditCardFileDriver extends ControladorDeArchivos<TarjetaDeCredito> {

    @Override
    public void executeSpecialOperation(String path, Object value) {
        TarjetaDeCredito tarjeta = super.readInstruction(path);
        if(tarjeta.getCredito() >= (Double) value) {
            tarjeta.setCredito(tarjeta.getCredito() + (Double) value);
            super.escribirEnArchivo(tarjeta.getPath(), tarjeta);
        }
    } 
    
}
