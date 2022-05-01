package Instrucciones;

import java.io.File;
import Files.Drivers.HTMLFileDriver;
import Files.Drivers.InstructionFileDriver;
import Reportes.HTMLStructure.HTMLGenerator;

public class ListadoSolicitudes extends Instruccion implements HTMLGenerator<Solicitud>{
    String reporteHTML;
    @Override
    public void evaluarLinea(String line){
        InstructionFileDriver driver = new InstructionFileDriver();
        String htmlReport = this.getTableHeader();
        for (File file : driver.getFiles(".sol")) {
            Solicitud request = (Solicitud) driver.readInstruction(file.getName());
            htmlReport += this.getTableRows(request);
        }
        HTMLFileDriver htmlDriver = new HTMLFileDriver();
        htmlReport += "\n</table>";
        htmlDriver.edicionDeReporteHTML(htmlReport);
    }

    @Override
    public String getTableHeader() {
        return "<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Tarjetas<h3>" +
"	  <tr>\n" +
"	    <th style=\"border: 1px solid #000000;\">NUMERO DE SOLICITUD</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">FECHA DE SOLICITUD</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">SALARIO</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
"           <th style=\"border: 1px solid #000000;\">FECHA APROV/RECH</th>\n" +               
"	    <th style=\"border: 1px solid #000000;\">ESTADO SOLICITUD</th>\n" +
"	  </tr>";
    }

    @Override
    public String getTableRows(Solicitud instruction) {
        return "<tr>\n" +
"	    <td style=\"border: 1px solid #000000;\">"+instruction.getNumeroDeSolicitud()+"</td>\n" +
"	    <td style=\"border: 1px solid #000000;\">"+instruction.getFecha()+"</td>\n" +
"	    <td style=\"border: 1px solid #000000;\">"+instruction.getTipo()+"</td>\n" +
"	    <td style=\"border: 1px solid #000000;\">"+instruction.getNombre()+"</td>\n" +
"	    <td style=\"border: 1px solid #000000;\">"+instruction.getSalario()+"</td>\n" +
"	    <td style=\"border: 1px solid #000000;\">"+instruction.getSalario()+"</td>\n" +
"           <td style=\"border: 1px solid #000000;\">"+""+"</td>\n" +               
"	    <td style=\"border: 1px solid #000000;\">"+""+"</td>\n" +
"	  </tr>";
    }

    
}
