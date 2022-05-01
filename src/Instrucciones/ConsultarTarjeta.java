package Instrucciones;

import CreditCard.TarjetaDeCredito;
import Files.Drivers.CreditCardFileDriver;
import Files.Drivers.HTMLFileDriver;
import Reportes.HTMLStructure.HTMLGenerator;

public class ConsultarTarjeta extends Instruccion implements HTMLGenerator<TarjetaDeCredito> {
    
    @Override
    public void evaluarLinea(String line){
        CreditCardFileDriver driver = new CreditCardFileDriver();
        String cardNumber = line
                .replaceAll("CONSULTAR_TARJETA", "")
                .replace("(", "")
                .replace(")", "");
        TarjetaDeCredito creditCard = (TarjetaDeCredito) driver.readInstruction("Tarjeta"+ cardNumber + ".tacre");
        String htmlReport = "<h3>Consulta de Tarjeta: " + creditCard.getNumeroDeTarjeta() + "</h3>\n";
        htmlReport += getTableHeader();
        htmlReport += getTableRows(creditCard);
        HTMLFileDriver htmlDriver = new HTMLFileDriver();
        htmlDriver.edicionDeReporteHTML(htmlReport);
    }

    @Override
    public String getTableHeader() {
        return  "	<table style=\"border-collapse: collapse;\">\n" +
            "	  <tr>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" +
            "	  </tr>\n" ;
    }

    @Override
    public String getTableRows(TarjetaDeCredito instruction) {
        return  "	  <tr>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+instruction.getNumeroDeTarjeta()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+instruction.getType()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+instruction.getCreditCardLimit()+".00"+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+instruction.getNombreDelCliente()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+instruction.getDireccionDelCliente()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+(instruction.isEstaActiva() ? "Activa" : "Inactiva")+"</td>\n" +
            "	  </tr>\n" +
            "	</table>";
    }

}
