package Instrucciones;
import java.util.*;
import Files.Drivers.InstructionFileDriver;

public class Solicitud extends Instruccion {
    private int numeroDeSolicitud;
    private String fecha;
    private int tipo;
    private String nombre;
    private int salario;
    private String direccion;
    
    public Solicitud(int numSolicitud,String fecha, int tipo, String nombre, int salario,String direccion){
        this.numeroDeSolicitud=numSolicitud;
        this.fecha=fecha;
        this.tipo=tipo;
        this.nombre=nombre;
        this.salario=salario;
        this.direccion=direccion;
    }
     //de esta manera se sobrecarga el constructor de la clase solicitud
    public Solicitud() {
    }

    public int getNumeroDeSolicitud() {
        return numeroDeSolicitud;
    }

    public void setNumeroDeSolicitud(int numeroDeSolicitud) {
        this.numeroDeSolicitud = numeroDeSolicitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void evaluarLinea(String line){
        InstructionFileDriver driver = new InstructionFileDriver();
        StringTokenizer token = new StringTokenizer(line,","); //se define un nuevo objeto StringTokenizer con la cadena line y el delmitador ","
        String temp; //la variable temp sirve para almacenar datos y poder operar con ellos antes de ingresarlos a sus datos fijos
        temp=token.nextToken().replace("(", ""); //aca se le quita el parentesis al primer token
        this.numeroDeSolicitud=Integer.parseInt(temp.replaceAll("SOLICITUD", ""));//Luego aca se le se quita la palabra solicitud a la variable numero de solicitud y se convierte a entero
        temp=token.nextToken(); //este token es de la fecha de la solicitud
        this.fecha=temp.replaceAll("\"",""); //mediante esta instruccion se quitan las comillas a la fecha 
        this.tipo=Integer.valueOf(token.nextToken().replace("\"", ""));
        this.nombre=String.valueOf(token.nextToken().replaceAll("\"", ""));
        this.salario=Integer.valueOf(token.nextToken());
        this.direccion=token.nextToken().replaceAll("\"", "").replace(")", "");
        driver.escribirEnArchivo("Solicitud"+this.getNumeroDeSolicitud()+".sol",this);
    }
}
