package CreditCard;

import java.io.Serializable;

public abstract class TarjetaDeCredito implements Serializable {
    
    private String NumeroDeTarjeta;
    private int tipo;
    private int limite;
    private String nombreDelCliente;
    private String direccionDelCliente;
    private double credito;
    private boolean estaActiva;
    private final String path;
    private final String typeValue;

    public TarjetaDeCredito(String typeValue, String path) {
        this.path = path;
        this.typeValue = typeValue;
    }

    public String getNumeroDeTarjeta() {
        return NumeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(String NumeroDeTarjeta) {
        this.NumeroDeTarjeta = NumeroDeTarjeta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public String getNombreDelCliente() {
        return nombreDelCliente;
    }

    public void setNombreDelCliente(String nombreDelCliente) {
        this.nombreDelCliente = nombreDelCliente;
    }

    public String getDireccionDelCliente() {
        return direccionDelCliente;
    }

    public void setDireccionDelCliente(String direccionDelCliente) {
        this.direccionDelCliente = direccionDelCliente;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    public String getPath() {
        return path;
    }

    public String getTypeValue() {
        return typeValue;
    }
    
    public abstract String getType();
    
    public abstract double getCreditCardLimit();
}
