import modelo.Almacen;
import modelo.Autor;
import modelo.Libro;
import com.coti.tools.Esdia;

// IRL a Github
// https://github.com/nicolasjml01/Ejercicio_Introduccion_POO.git

public class App {
    public static void main(String[] args) throws Exception {
        boolean continuar = true;

        Almacen almacen = null;
        while(continuar)
        {
            int opcion = mostrar_Menu();
            switch (opcion) {
                case 1: // Creamos el array de numLibros en almacen
                    int numLibros = Esdia.readInt("Introduce el número de libros que vas a añadir: ");
                    almacen = new Almacen(numLibros);
                    System.out.println("Nuevo almacén creado con espacio para " + numLibros + " libros.");         
                    break;
                case 2:  // Establecer ritmo de lectura (páginas por minuto)
                    if (almacen != null) {
                        int ritmoLectura = Esdia.readInt("Introduce el ritmo de lectura (páginas por minuto): ");
                        almacen.establecerRitmoLectura(ritmoLectura);
                        System.out.println("Ritmo de lectura establecido a " + ritmoLectura + " páginas por minuto.");
                    } else {
                        System.out.println("El almacén no ha sido creado. Por favor, selecciona la opción 1 primero.");
                    }
                    break;
                case 3: // Añadir libros al almacen
                    if (almacen == null) {
                        System.out.println("El almacén no ha sido creado. Por favor, selecciona la opción 1 primero.");
                    } else if (almacen.estaLleno()) {
                        System.out.println("El almacén está lleno. No se pueden añadir más libros.");
                    } else {
                        // Pedir la información del autor
                        System.out.println("Añadiendo un nuevo libro:");
                        String nombre = Esdia.readString("Introduce el nombre del autor: ");
                        String apellidos = Esdia.readString("Introduce los apellidos del autor: ");
                        boolean premioPlaneta = Esdia.yesOrNo("¿El autor ha ganado el Premio Planeta? (y/n): ");
                        Autor autor = new Autor(nombre, apellidos, premioPlaneta);
                        
                        // Pedir la información del libro
                        String titulo = Esdia.readString("Introduce el título del libro: ");
                        int añoPublicacion = Esdia.readInt("Introduce el año de publicación: ");
                        int numPaginas = Esdia.readInt("Introduce el número de páginas: ");
                        double precio = Esdia.readDouble("Introduce el precio del libro: ");
                        
                        // Crear el libro y añadirlo al almacén
                        Libro libro = new Libro(autor, titulo, añoPublicacion, numPaginas, precio);
                        boolean añadido = almacen.añadirLibro(libro);
                        
                        if (añadido) {
                            System.out.println("El libro ha sido añadido correctamente.");
                        } else {
                            System.out.println("No se pudo añadir el libro.");
                        }
                    }
                    break;
                case 4: // Mostrar información actual de libros en formato tabla
                    if (almacen != null) {
                        almacen.mostrarLibros();
                    } else {
                        System.out.println("El almacén no ha sido creado. Por favor, selecciona la opción 1 primero.");
                    }
                    break;
                case 5:
                    System.out.println("Has seleccionado 'Salir'. Se borrará toda la información.");
                    continuar = false;
                    break;
                default:
                    break;
            }
        }
    }
    // Metodo para mostrar menu
    private static int mostrar_Menu() {
        int opcion = 0;

        // Bucle que continuará hasta que el usuario elija una opción válida
        while (opcion < 1 || opcion > 5) {
            System.out.println("|----------------------------------------------|");
            System.out.println("|                  MIS LIBROS                  |");
            System.out.println("|----------------------------------------------|");
            System.out.println("1) Nuevo almacén de libros");
            System.out.println("2) Establecer ritmo de lectura (páginas por minuto)");
            System.out.println("3) Añadir un nuevo libro al almacén");
            System.out.println("4) Mostrar información actual de libros");
            System.out.println("5) Salir (se borrará toda la información)");
            System.out.println("|----------------------------------------------|");
            opcion = Esdia.readInt("Seleccione una opción (1-5): ");

            // Mensaje de error si la opción no es válida
            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 5.");
            }
        }
        return opcion;
    }
}
