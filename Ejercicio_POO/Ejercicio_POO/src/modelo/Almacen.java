package modelo;

public class Almacen {
    private Libro[] libros;
    private int contadorLibros;
    private int paginasPorMinuto;

    public Almacen(int tamañoMaximo) {
        this.libros = new Libro[tamañoMaximo];
        this.contadorLibros = 0;
        this.paginasPorMinuto = 1;
    }

    // Método para añadir un libro al almacén
    public boolean añadirLibro(Libro libro) {
        if (contadorLibros < libros.length) {
            libros[contadorLibros] = libro;
            contadorLibros++;
            return true;  // Libro añadido correctamente
        } else {
            return false;  // Almacén lleno
        }
    }

    // Método para cambiar el ritmo de lectura
    public void establecerRitmoLectura(int paginasPorMinuto) {
        this.paginasPorMinuto = paginasPorMinuto;
    }

    // Método para mostrar todos los libros almacenados en formato tabla
    public void mostrarLibros() {
        if (contadorLibros == 0) {
            System.out.println("No hay libros en el almacén.");
            return;
        }

        double valorTotal = 0;
        int tiempoTotalLectura = 0;

        System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                          LIBROS EN EL ALMACÉN                                                         |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| Título          | Año Publicación | Autor               | Premio | Páginas | Tiempo lectura minutos     | Precio      |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");

        for (int i = 0; i < contadorLibros; i++) {
            Libro libro = libros[i];
            System.out.println(libro.formatoTabla(paginasPorMinuto));

            // Acumular valores para las estadísticas
            valorTotal += libro.getPrecio();
            tiempoTotalLectura += libro.calcularTiempoLectura(paginasPorMinuto);
        }

        System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("| Tiempo de lectura total del almacén:                                                                           %d min |\n", tiempoTotalLectura);
        System.out.printf("| Valor total del almacén:                                                                                         %.2f |\n", valorTotal);
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
    }

    // Método que indica si el almacén está lleno
    public boolean estaLleno() {
        return contadorLibros >= libros.length;
    }

    // Método para obtener el número de libros actuales en el almacén
    public int getNumLibros() {
        return contadorLibros;
    }
}
