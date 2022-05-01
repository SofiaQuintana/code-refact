/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files.Drivers;

import CreditCard.TarjetaDeCredito;
import Instrucciones.Instruccion;

/**
 *
 * @author zofia-px
 */
public class InstructionFileDriver extends ControladorDeArchivos<Instrucciones.Instruccion>{

    private Instruccion instruction;
    
    @Override
    public void executeSpecialOperation(String path, Object value) {
        System.out.println("no special operation");
    }

    public Instruccion getInstruction() {
        return instruction;
    }

    
}
