package CreditCard;

public class Regional extends TarjetaDeCredito {
    private final static String NUMERO_REGIONAL="4256-3102-6590-";
    private final static String CARD_PATH = "numeroRegionalCorriente.txt";
    private static final int CREDIT_LIMIT = 5000;
//    static NumeroDeTarjetaDeCredito controlador = new NumeroDeTarjetaDeCredito();   
    
    public Regional() {
        super(NUMERO_REGIONAL, CARD_PATH);
    }
    
//    public static void actualizarArchivo(int numero){
//        try{
//            DataOutputStream fileOut;
//            fileOut =
//            new DataOutputStream(
//                    new FileOutputStream("numeroRegionalCorriente.txt", false));
//                    fileOut.writeInt(numero);
//        }catch(IOException e){
//                System.out.println("IO Error: "+e.getMessage());
//        }
//    }
//    public static String leerYAsingarNumeroEnArchivo(){
//        try{
//        DataInputStream fileIn;
//            fileIn =
//            new DataInputStream(
//                    new FileInputStream("numeroRegionalCorriente.txt"));
//                    numero = fileIn.readInt();
//                    noTarjeta=controlador.asingarNumeroTarjeta(NUMERO_REGIONAL,numero);
//                    numero=numero+1;
//                    actualizarArchivo(numero);
//        }catch(IOException e){
//                System.out.println("IO Error: "+e.getMessage());
//        }
//        return noTarjeta;
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

