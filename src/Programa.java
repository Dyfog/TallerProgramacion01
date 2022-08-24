import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

    }
    public static void iniciar(){
        String[][] biblioteca = crearBiblioteca();
        ingresarPrimerosLibros(biblioteca);

    }

    public static String[][] crearBiblioteca(){
        String[][] bibliotecaFuncion = new String[100][3]; //creacion de una biblioteca limitada
        return bibliotecaFuncion;
    }

    public static String[][] ingresarPrimerosLibros(String[][] biblioteca){
        Scanner in = new Scanner(System.in);
        System.out.println("cuantos libros desea ingresar?");
        System.out.println("considerar un minimo de 3 para comenzar");
        int cantidad= validNum(eleccion(),1,100); // entrada de la cantidad de libros a ingresar validada
        System.out.println("ingrese los libros en este orden");
        System.out.println("1.-Autor    2.-Titulo    3.-Editorial");
        for (int i=0;i<cantidad;i++){ //for para agregar los libros
            for (int j=0;j<3;j++){
                biblioteca[i][j] = in.next();
            }
        }
        return biblioteca;
    }

    public static String[][] ingresarLibros(int cantEspaciosRestantes, int cantLibros, String[][] biblioteca){
        Scanner in = new Scanner(System.in);
        System.out.println("cuantos libros desea añadir");
        System.out.println("conside que no puede añadir mas de "+cantEspaciosRestantes);
        int cantidad= validNum(eleccion(),1,cantEspaciosRestantes);
        System.out.println("ingrese los libros en este orden");
        System.out.println("1.-Autor    2.-Titulo    3.-Editorial");
        for (int i=cantLibros;i<100;i++){
            for (int j=0;j<3;j++){
                biblioteca[i][j]= in.next();
            }
        }
        return biblioteca;
    }

    public static void leerLibros(String[][] biblioteca){
        for (int i=0;i<cantLibros(biblioteca);i++){
            System.out.println("autor: "+biblioteca[i][0]);
            System.out.println("titulo: "+biblioteca[i][1]);
            System.out.println("editorial: "+biblioteca[i][2]);
        }
    }

    public static void buscarLibro(String[][] biblioteca){
        Scanner in = new Scanner(System.in);
        System.out.println("por que medio quiere hacer su busqueda?");
        System.out.println("1.-Autor    2.-Titulo    3.-Editorial");
        int eleccion = validNum(eleccion(),1,3);
        System.out.println("Ingrese el autor/titulo/editorial que busca");
        String comparador = in.next();
        int coincidencias = buscarGeneral(eleccion,comparador, biblioteca);
        System.out.println("hay un total de: "+coincidencias+" coincidencias con su busqueda");
    }

    public static int cantLibros(String[][] biblioteca){
        int cantidad=0;
        for(int i=0;i<100;i++){
            if (!biblioteca[i][0].isEmpty()){
                cantidad++;
            }
        }
        return cantidad;
    }

    public static void leerCantidadLibros(String[][] biblioteca){
        System.out.println("Actualmente hay "+cantLibros(biblioteca)+" libros");
    }

    public static int cantEspaciosRestantes(String[][] biblioteca){
        int EspaciosRestantesFunc=100-cantLibros(biblioteca);
        return EspaciosRestantesFunc;
    }

    public static void leerCantEspaciosRestantes(String[][] biblioteca){
        System.out.println("Actualmente hay "+cantEspaciosRestantes(biblioteca)+" espacios restantes");
    }

    public static int buscarGeneral(int buscarSegun, String comparador, String[][] biblioteca){
        int coincidencias=0;
        for (int i=0;i<100;i++){
            if (biblioteca[i][buscarSegun].equals(comparador)){
                coincidencias++;
            }
        }
        return coincidencias;
    }

    public static int eleccion() {
        Scanner in = new Scanner(System.in);
        int eleccion = in.nextInt();
        return eleccion;
    }

    public static int validNum(int num, int min, int max) {
        Scanner in = new Scanner(System.in);
        while (num > min || num < max) {
            System.out.println("numero invalido, ingrese nuevamente");
            num = in.nextInt();
        }
        return num;
    }

    public static void menu(){
        System.out.println("que desea hacer ahora?");
        System.out.println("1.- Agregar libros");
        System.out.println("2.- Buscar libros");
        System.out.println("3.- Mostrar cantidad de libros actuales");
        System.out.println("4.- Mostrar cantidad de espacios disponibles");
        System.out.println("5.- Mostrar todos los libros");
        System.out.println("6.- Terminar programa");
    }
}
