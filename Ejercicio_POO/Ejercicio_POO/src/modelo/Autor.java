package modelo;

public class Autor {
    private String nombre;
    private String apellidos;
    private boolean premioPlaneta;

    // Constructor
    public Autor(String nombre, String apellidos, boolean premioPlaneta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.premioPlaneta = premioPlaneta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isPremioPlaneta() {
        return premioPlaneta;
    }

    public void setPremioPlaneta(boolean premioPlaneta) {
        this.premioPlaneta = premioPlaneta;
    }
}
