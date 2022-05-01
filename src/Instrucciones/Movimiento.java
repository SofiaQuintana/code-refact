package Instrucciones;

import java.util.Calendar;
import java.util.StringTokenizer;
import Files.Drivers.ControladorDeArchivos;
import Files.Drivers.CreditCardFileDriver;
import Files.Drivers.InstructionFileDriver;

public class Movimiento extends Instruccion {
    private String numeroDeTarjeta;
    private String fecha;
    private String tipoDeMovimiento;
    private String descripcion;
    private String establecimiento;
    private double monto;
    
    public Movimiento(String numero, String fecha, String tipo, String descripcion, String establecimiento, double monto){
        this.numeroDeTarjeta=numero;
        this.fecha=fecha;
        this.tipoDeMovimiento=tipo;
        this.descripcion=descripcion;
        this.establecimiento=establecimiento;
        this.monto=monto;
    }
    
    public Movimiento(){ }

    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTipoDeMovimiento() {
        return tipoDeMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public void evaluarLinea(String line){
        CreditCardFileDriver driver = new CreditCardFileDriver();
        InstructionFileDriver instruction = new InstructionFileDriver();
        StringTokenizer token = new StringTokenizer(line,","); //se define un nuevo objeto StringTokenizer con la cadena line y el delmitador ","
        String temp; //la variable temp sirve para almacenar datos y poder operar con ellos antes de ingresarlos a sus datos fijos
        temp=token.nextToken().replace("(", ""); //aca se le quita el parentesis al primer token que en este caso es Movimiento(
        this.numeroDeTarjeta=temp.replaceAll("MOVIMIENTO", "");//Luego aca se le se quita la palabra movimiento a la variable numero de tarjeta y se convierte a entero
        this.fecha=token.nextToken().replaceAll("\"",""); //mediante esta instruccion se quitan las comillas a la fecha 
        this.tipoDeMovimiento=(token.nextToken().replace("\"", ""));
        this.descripcion=(token.nextToken().replace("\"", ""));
        this.establecimiento=(token.nextToken().replace("\"", ""));
        this.monto=Double.parseDouble(token.nextToken().replaceAll("\"", "").replace(")", ""));
        driver.executeSpecialOperation("Tarjeta"+this.numeroDeTarjeta+".tacre", (Double)( this.tipoDeMovimiento.equalsIgnoreCase("CARGO")? this.monto*-1 : this.monto));
        Calendar tiempo=Calendar.getInstance();
        instruction.escribirEnArchivo("Movimiento"+String.valueOf(tiempo.getTimeInMillis())+".mvito",this);
    }
}
