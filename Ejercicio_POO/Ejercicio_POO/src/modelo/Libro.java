package modelo;

public class Libro {
    private Autor autor;
    private String titulo;
    private int añoPublicacion;
    private int numPaginas;
    private double precio;

    // Constructor
    public Libro(Autor autor, String titulo, int añoPublicacion, int numPaginas, double precio) {
        this.autor = autor;
        this.titulo = titulo;
        this.añoPublicacion = añoPublicacion;
        this.numPaginas = numPaginas;
        this.precio = precio;
    }


    // Método para calcular el tiempo de lectura, dado el ritmo en páginas por minuto
    public int calcularTiempoLectura(int paginasPorMinuto) {
        return numPaginas / paginasPorMinuto;
    }

    // Método para representar el libro en formato tabla
    public String formatoTabla(int paginasPorMinuto) {
        String premioPlaneta = autor.isPremioPlaneta() ? "Sí" : "No";
        int tiempoLectura = calcularTiempoLectura(paginasPorMinuto);

        // Ajustar ancho de cada columna para alineación correcta
        return String.format("| %-15s | %-15d | %-20s | %-6s | %-7d | %-23d | %-8.2f |",
                titulo, añoPublicacion, autor.getNombre() + " " + autor.getApellidos(), premioPlaneta, numPaginas, tiempoLectura, precio);
    }

    // Getters y Setters
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
