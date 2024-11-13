package jjraprendizajevirtual.modelo.pojo;

public class Formato {
    private int idFormato;
    private String nombre;

    public Formato() {
    }

    public Formato(int idFormato, String nombre) {
        this.idFormato = idFormato;
        this.nombre = nombre;
    }

    public int getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(int idFormato) {
        this.idFormato = idFormato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
