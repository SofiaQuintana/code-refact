/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instrucciones;

/**
 *
 * @author zofia-px
 */
public class InstructionFactory {
    
    public Instruccion getInstruccion(String line) {
        if (line.startsWith("SOLICITUD")) {
            return new Solicitud();
        } else if (line.startsWith("MOVIMIENTO")) {
            return new Movimiento();
        } else if (line.startsWith("AUTORIZACION_TARJETA")) {
            return new AutorizacionTarjeta();
        } else if (line.startsWith("CANCELACION_TARJETA")) {
            return new CancelacionTarjeta();
        } else if (line.startsWith("CONSULTAR_TARJETA")) {
            return new ConsultarTarjeta();
        } else if (line.startsWith("LISTADO_TARJETAS")) {
            return new ListadoTarjetas();
        } else if (line.startsWith("LISTADO_SOLICITUDES")) {
            return new ListadoSolicitudes();
        } else {
            throw new AssertionError(line);
        }
    }
    
}
