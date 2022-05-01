/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers;

import Instrucciones.Instruccion;

/**
 *
 * @author zofia-px
 */
public class InstructionDriver {
    private Instrucciones.Instruccion instruction;

    public Instruccion getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruccion instruction) {
        this.instruction = instruction;
    }
    
    public void execute(String line) throws NullPointerException {
         try{
            instruction.evaluarLinea(line);
        } catch(AssertionError err) {
            throw new AssertionError("Error al ejecutar la instruccion de tipo" + instruction.getClass(), err.getCause());
        }
    }
}
