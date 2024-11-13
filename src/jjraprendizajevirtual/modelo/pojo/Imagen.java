package jjraprendizajevirtual.modelo.pojo;

public class Imagen {
    private int idImagen;
    private String resolucion;
    private String tamañoArchivo;
    private int idFormato;
    private int idRecurso;

    public Imagen() {
    }

    public Imagen(int idImagen, String resolucion, String tamañoArchivo, int idFormato, int idRecurso) {
        this.idImagen = idImagen;
        this.resolucion = resolucion;
        this.tamañoArchivo = tamañoArchivo;
        this.idFormato = idFormato;
        this.idRecurso = idRecurso;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getTamañoArchivo() {
        return tamañoArchivo;
    }

    public void setTamañoArchivo(String tamañoArchivo) {
        this.tamañoArchivo = tamañoArchivo;
    }

    public int getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(int idFormato) {
        this.idFormato = idFormato;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }
    
    
}
