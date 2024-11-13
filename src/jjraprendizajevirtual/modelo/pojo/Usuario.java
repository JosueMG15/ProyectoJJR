package jjraprendizajevirtual.modelo.pojo;

public class Usuario {
    private int idUsuario;
    private String apellidos;
    private String contraseña;
    private String correoElectronico;
    private String nombre;
    private String telefono;

    public Usuario() {
    }

    public Usuario(int idUsuario, String apellidos, String contraseña, String correoElectronico, String nombre, String telefono) {
        this.idUsuario = idUsuario;
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
