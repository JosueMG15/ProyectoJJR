package jjraprendizajevirtual.utilidades;

import jjraprendizajevirtual.modelo.pojo.Usuario;

public class SingletonUsuario {
    private static SingletonUsuario instanciaUsuario;
    private Usuario usuario;
    
    private SingletonUsuario() 
    {
        
    }
    
    public static SingletonUsuario getInstaniaUsuario() {
        if (instanciaUsuario == null) {
            instanciaUsuario = new SingletonUsuario();
        }
        return instanciaUsuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
