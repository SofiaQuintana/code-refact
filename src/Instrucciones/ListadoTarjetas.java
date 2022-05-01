package Instrucciones;

import java.io.File;
import CreditCard.TarjetaDeCredito;
import Files.Drivers.CreditCardFileDriver;
import Files.Drivers.HTMLFileDriver;
import Reportes.HTMLStructure.HTMLGenerator;

public class ListadoTarjetas extends Instruccion implements HTMLGenerator<TarjetaDeCredito> {
    
    @Override
    public void evaluarLinea(String line){
        CreditCardFileDriver driver = new CreditCardFileDriver();
        String htmlReport = this.getTableHeader();
        for (File file : driver.getFiles(".tacre")) {
            TarjetaDeCredito creditCard = driver.readInstruction(file.getName());
            htmlReport += this.getTableRows(creditCard);
        }
        HTMLFileDriver htmlDriver = new HTMLFileDriver();
        htmlReport += "\n</table>";
        htmlDriver.edicionDeReporteHTML(htmlReport);
    }

    @Override
    public String getTableHeader() {
        return "<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Tarjetas<h3>" 
                + "<th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" 
                + "<th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" 
                + "<th style=\"border: 1px solid #000000;\">LIMITE</th>\n" 
                + "<th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" 
                + "<th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" 
                + "<th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" 
                + "</tr>";
    }

    @Override
    public String getTableRows(TarjetaDeCredito instruction) {
        return "<tr>\n" 
                + "<td style=\"border: 1px solid #000000;\">"+instruction.getNumeroDeTarjeta()+"</th>\n" 
                + "<td style=\"border: 1px solid #000000;\">"+instruction.getType()+"</th>\n" 
                + "<td style=\"border: 1px solid #000000;\">"+instruction.getCreditCardLimit()+"</th>\n" 
                + "<td style=\"border: 1px solid #000000;\">"+instruction.getNombreDelCliente()+"</th>\n" 
                + "<td style=\"border: 1px solid #000000;\">"+instruction.getDireccionDelCliente()+"</th>\n" 
                + "<td style=\"border: 1px solid #000000;\">"+ (instruction.isEstaActiva() ? "Activa" : "Inactiva") +"</th>\n" 
                + "</tr>";
    }

}
