package jjraprendizajevirtual.modelo.pojo;

public class TipoRecurso {
    private int idTipoRecurso;
    private String nombreTipo;

    public TipoRecurso() {
    }

    public TipoRecurso(int idTipoRecurso, String nombreTipo) {
        this.idTipoRecurso = idTipoRecurso;
        this.nombreTipo = nombreTipo;
    }

    public int getIdTipoRecurso() {
        return idTipoRecurso;
    }

    public void setIdTipoRecurso(int idTipoRecurso) {
        this.idTipoRecurso = idTipoRecurso;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
    
    
}
