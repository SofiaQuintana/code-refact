package CreditCard;

import java.io.*;

public class Nacional extends TarjetaDeCredito {
    private static final String NUMERO_NACIONAL="4256-3102-6585-";
    private static final String CARD_PATH = "numeroNacionalCorriente.txt";
    private static final int CREDIT_LIMIT = 2000;
//    static NumeroDeTarjetaDeCredito controlador = new NumeroDeTarjetaDeCredito();

    public Nacional() {
        super(NUMERO_NACIONAL, CARD_PATH);
    }
 
//    public static void actualizarArchivo(int numero){
//        try{
//            DataOutputStream fileOut;
//            fileOut =
//            new DataOutputStream(
//                    new FileOutputStream("numeroNacionalCorriente.txt", false));
//                    fileOut.writeInt(numero);
//        }catch(IOException e){
//                System.out.println("IO Error: "+e.getMessage());
//        }
//    }
//    
//    public static String leerYAsingarNumeroEnArchivo(){
//        try{
//        DataInputStream fileIn;
//            fileIn =
//            new DataInputStream(
//                    new FileInputStream("numeroNacionalCorriente.txt"));
//                    numero = (Integer) fileIn.readInt();  //este comando lee el valor que tiene nuestro archivo numeroNacionalCorriente.txt
//                    noTarjeta=(controlador.asingarNumeroTarjeta(NUMERO_NACIONAL,numero)); //aca Obtenemos el numero de nuestra siguiente tarjeta a instanciar
//                    numero=numero+1;
//                    actualizarArchivo(numero);  //Mediante este comando se invoca al metodo actualizarArchivo el cual sobreescribe el siguiente numero.
//        }catch(IOException e){
//                System.out.println("IO Error: "+e.getMessage());
//        }
//        return noTarjeta; //este retorno me regresa un valor con el formato de un numero como xxxx-xxxx-xxxx-xxxx
//    }

    @Override
    public double getCreditCardLimit() {
        return CREDIT_LIMIT;
    }
    
    @Override
    public String getType() {
        return getClass().getName();
    }
}
