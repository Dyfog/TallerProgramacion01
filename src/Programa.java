import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

    }
    public static void iniciar(){
        String[][] biblioteca = crearBiblioteca();
        ingresarPrimerosLibros(biblioteca);

    }

    public static String[][] crearBiblioteca(){
        String[][] bibliotecaFuncion = new String[100][3];
        return bibliotecaFuncion;
    }

    public static String[][] ingresarPrimerosLibros(String[][] biblioteca){
        Scanner in = new Scanner(System.in);
        System.out.println("cuantos libros desea ingresar?");
        System.out.println("considerar un minimo de 3 para comenzar");
        int cantidad= validNum(eleccion(),1,100);
        System.out.println("ingrese los libros en este orden");
        System.out.println("1.-Autor    2.-Titulo    3.-Editorial");
        for (int i=0;i<cantidad;i++){
            for (int j=0;j<3;j++){
                biblioteca[i][j] = in.next();
            }
        }
        return biblioteca;
    }

    public static void ingresarLibros(int cantLibros){
        System.out.println("cuantos libros desea añadir");
        System.out.println("conside que no puede añadir mas de "+cantLibros);
        Scanner in = new Scanner(System.in);


    }

    public static int contarLibros(String[][] biblioteca){
        int cantidad=0;
        for(int i=0;i<100;i++){
            if (!biblioteca[i][0].isEmpty()){
                cantidad++;
            }
        }
        return cantidad;
    }

    public static void leerCantidadLibros(String[][] biblioteca){
        System.out.println("Actualmente hay "+contarLibros(biblioteca)+" libros");
    }

    public static int cantEspaciosRestantes(String[][] biblioteca){
        int EspaciosRestantesFunc=100-contarLibros(biblioteca);
        return EspaciosRestantesFunc;
    }

    public static void leerCantEspaciosRestantes(String[][] biblioteca){
        System.out.println("Actualmente hay "+cantEspaciosRestantes(biblioteca)+" espacios restantes");
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
}
