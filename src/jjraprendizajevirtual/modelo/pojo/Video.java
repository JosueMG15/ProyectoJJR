package jjraprendizajevirtual.modelo.pojo;

import java.sql.Time;

public class Video {
    private int idVideo;
    private Time duracion;
    private int idFormato;
    private int idRecurso;

    public Video() {
    }

    public Video(int idVideo, Time duracion, int idFormato, int idRecurso) {
        this.idVideo = idVideo;
        this.duracion = duracion;
        this.idFormato = idFormato;
        this.idRecurso = idRecurso;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
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
