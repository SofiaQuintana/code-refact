package CreditCard;

public class Internacional extends TarjetaDeCredito {
    private static final String NUMERO_INTERNACIONAL=   "4256-3102-6595-";
    private static final String CARD_PATH = "numeroInternacionalCorriente.txt";
    private static final int CREDIT_LIMIT = 12000;
//    static NumeroDeTarjetaDeCredito controlador = new NumeroDeTarjetaDeCredito();    

    public Internacional() {
        super(NUMERO_INTERNACIONAL, CARD_PATH);
    }
  
//    public static void actualizarArchivo(int numero){
//        try{
//            DataOutputStream fileOut;
//            fileOut =
//            new DataOutputStream(
//                    new FileOutputStream("numeroInternacionalCorriente.txt", false));
//                    fileOut.writeInt(numero);
//        }catch(IOException e){
//                System.out.println("IO Error: "+e.getMessage());
//        }
//    }
//    static int numero=0;
//    public static String leerYAsingarNumeroEnArchivo(){
//        try{
//        DataInputStream fileIn;
//            fileIn =
//            new DataInputStream(
//                    new FileInputStream("numeroInternacionalCorriente.txt"));
//                    numero=fileIn.readInt();
//                    noTarjeta=controlador.asingarNumeroTarjeta(NUMERO_INTERNACIONAL,numero);
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
