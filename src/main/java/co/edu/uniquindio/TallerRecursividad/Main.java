package co.edu.uniquindio.TallerRecursividad;

import co.edu.uniquindio.TallerRecursividad.model.Producto;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Prueba de esCodigoPrimoRecursivo
        int codigo = 2;
        boolean esPrimo = esCodigoPrimoRecursivo(codigo, 1, 0);
        System.out.println("\n¿El código " + codigo + " es primo? " + esPrimo);

        // Prueba de calcularIngesos
        ArrayList<Float> ingresos = new ArrayList<>(Arrays.asList(100.5f, 200.75f, 50.25f));
        Float sumaIngresos = calcularIngesos(ingresos, 0, 0f);
        System.out.println("\nSuma de ingresos: " + sumaIngresos);

        // Prueba de obtenerPrecioMasBajo
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, 150.0f, "jabon", "limpieza"));
        productos.add(new Producto(2, 75.0f, "crema", "cuidado personal"));
        productos.add(new Producto(3, 200.0f, "jugo", "bebidas"));
        Float precioMasBajo = obtenerPrecioMasBajo(productos, 0, productos.getFirst().getPrecio());
        System.out.println("\nPrecio más bajo: " + precioMasBajo);

        // Prueba de imprimirAsteriscos
        int cantidadAsteriscos = 5;
        System.out.println("\nAsteriscos:");
        imprimirAsteriscos(cantidadAsteriscos, 1);


        // Prueba de calcularTotalPedido
        System.out.println("\nTotal del pedido: " + calcularTotalPedido(productos,0,0));

        // Prueba de la sucesion de numeros catalanes
        System.out.println("\n5to numero catalan: ");
        System.out.println(catalanRecursivo(8, 0));


        //Prueba de calcularCapital
        System.out.println("\nCapital de 2 años, con un monto de 5000 e interes del 10%: " + calcularCapital(5000, 10, 2));

        //Prueba de calcularFibonnaci
        System.out.println("\nSucesion de fibonnacci en la posicion 10: " + calcularFibonacci(10));


        System.out.println("En el ejercicio 9, lo que imprime es: \n 2 \n 2 \n 3" );
        System.out.println("Un mejor nombre para la funcion es extraerFactoresPrimos ");
    }

    public static boolean esCodigoPrimoRecursivo(int codigo, int numero, int rep) {
        if (numero == codigo && rep == 1) {
            return true;
        } else if (rep > 2) {
            return false;
        } else {
            if (codigo % numero == 0) {
                rep+=1;
            }
            return esCodigoPrimoRecursivo(codigo, numero + 1, rep);
        }
    }

    public static Float calcularIngesos(ArrayList<Float> ingresos, int pos, Float suma) {
        if (pos == ingresos.size()) {
            return suma;
        } else {
            suma += ingresos.get(pos);
            pos++;
            return calcularIngesos(ingresos, pos, suma);
        }
    }

    public static Float obtenerPrecioMasBajo(ArrayList<Producto> productos, int pos, Float precioMasBajo) {
        if (pos == productos.size()) {
            return precioMasBajo;
        } else {
            Float precioProducto = productos.get(pos).getPrecio();
            precioMasBajo = precioProducto < precioMasBajo ? precioProducto : precioMasBajo;
            return obtenerPrecioMasBajo(productos, pos + 1, precioMasBajo);
        }
    }

    public static void imprimirAsteriscos(int cantidad, int inicio) {
        if (cantidad == inicio) {
            imprimirElemento("*", inicio);
        } else {
            imprimirElemento("*", inicio);
            inicio++;
            imprimirAsteriscos(cantidad, inicio);
        }
    }

    public static void imprimirElemento(String elemento, int veces) {
        if (veces <= 0) {
            System.out.println();
            return;
        } else {
            System.out.print(elemento);
            imprimirElemento(elemento, veces - 1);
        }
    }


    public static float calcularTotalPedido(ArrayList<Producto> pedido, int producto, float suma){
        if (producto >= pedido.size()){
            return suma;
        }else if (producto == 0){
            suma += pedido.getFirst().getPrecio();
            return calcularTotalPedido(pedido, producto+1, suma);
        }else{
            float precioProducto = pedido.get(producto).getPrecio();
            suma += precioProducto-(precioProducto*0.05);
            return calcularTotalPedido(pedido, producto+1, suma);
        }
    }

    public static float calcularCapital(float capitalInicial, float tasaInteres, int años) {
        if (años == 0) {
            return capitalInicial;
        } else {
            float nuevoCapital = capitalInicial + (capitalInicial * tasaInteres / 100);
            return calcularCapital(nuevoCapital, tasaInteres, años - 1);
        }
    }


    public static int calcularFibonacci(int numero){
        if(numero == 1 || numero == 2){
            return 1;
        }else{
            return calcularFibonacci(numero-1)+calcularFibonacci(numero-2);
        }
    }

    public static int catalan(int n) {
        // Caso base: C0 = 1
        if (n == 0) {
            return 1;
        }
        // suma
        return catalanRecursivo(n, 0);
    }
    // segunda recursiva
    private static int catalanRecursivo(int n, int i) {
        // si lleg se para
        if (i == n) {
            return 0;
        }
        // Suma el producto de los numeros
        return catalan(i) * catalan(n - 1 - i) + catalanRecursivo(n, i + 1);

    }

}
