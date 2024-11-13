package jjraprendizajevirtual.modelo.pojo;

public class Documento {
    private int idDocumento;
    private String contenido;
    private int idFormato;
    private int idRecurso;

    public Documento() {
    }

    public Documento(int idDocumento, String contenido, int idFormato, int idRecurso) {
        this.idDocumento = idDocumento;
        this.contenido = contenido;
        this.idFormato = idFormato;
        this.idRecurso = idRecurso;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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
