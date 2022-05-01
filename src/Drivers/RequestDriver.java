/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers;

import CreditCard.CreditCardFactory;
import CreditCard.TarjetaDeCredito;
import Instrucciones.Solicitud;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author zofia-px
 */
public class RequestDriver {
    private Solicitud request;

    public RequestDriver(Solicitud solicitud) {
        this.request = solicitud;
    }

    public String isAccepted(TarjetaDeCredito tarjeta) {
        System.out.println(request.getSalario()* 0.6 >= tarjeta.getCreditCardLimit());
        if (request.getSalario()* 0.6 >= tarjeta.getCreditCardLimit()) {
            return this.leerYAsingarNumeroEnArchivo(tarjeta);
        } else {
            return null;
        }
    }

    public TarjetaDeCredito processRequest() {
        CreditCardFactory factory = new CreditCardFactory();
        try {
            TarjetaDeCredito tarjeta = factory.getCreditCardType(request.getTipo());
            tarjeta.setNumeroDeTarjeta(this.isAccepted(tarjeta));
            tarjeta.setTipo(request.getTipo());
            tarjeta.setLimite((int) (request.getSalario()* 0.6));
            tarjeta.setNombreDelCliente(request.getNombre());
            tarjeta.setDireccionDelCliente(request.getDireccion());
            tarjeta.setCredito(0);
            tarjeta.setEstaActiva(true);
            System.out.println("numero de tarjeta " + tarjeta.getNumeroDeTarjeta());
            return tarjeta;
        } catch (AssertionError e) {
            throw e;
        }
    }

    private String assignCardNumber(String base, int valor) {
        String numeroDeTarjeta = null;
        if (valor >= 1 & valor < 10) {
            numeroDeTarjeta = base + "000" + valor;
        }
        if (valor >= 10 & valor < 100) {
            numeroDeTarjeta = base + "00" + valor;
        }
        if (valor >= 100 & valor < 10000) {
            numeroDeTarjeta = base + "0" + valor;
        }
        return numeroDeTarjeta; //ESTE RETORNO ES DEL FORMATO XXXX-XXXX-XXXX-XXXX
    }

    public String leerYAsingarNumeroEnArchivo(TarjetaDeCredito tarjeta) {
        try {
            DataInputStream fileIn = new DataInputStream(new FileInputStream(tarjeta.getPath()));
            int numero = (Integer) fileIn.readInt();  //este comando lee el valor que tiene nuestro archivo numeroNacionalCorriente.txt
            String noTarjeta = (this.assignCardNumber(tarjeta.getTypeValue(), numero)); //aca Obtenemos el numero de nuestra siguiente tarjeta a instanciar
            numero++;
            actualizarArchivo(numero,tarjeta.getPath());  //Mediante este comando se invoca al metodo actualizarArchivo el cual sobreescribe el siguiente numero.
           
            fileIn.close();
            return noTarjeta;
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
        return null; //este retorno me regresa un valor con el formato de un numero como xxxx-xxxx-xxxx-xxxx
    }

    public void actualizarArchivo(int numero, String path) {
        try {
            DataOutputStream fileOut;
            fileOut = new DataOutputStream(new FileOutputStream(path, false));
            fileOut.writeInt(numero);
            System.out.println("llegue aqui");
            fileOut.close();
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
