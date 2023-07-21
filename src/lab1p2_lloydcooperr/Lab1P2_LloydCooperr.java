package lab1p2_lloydcooperr;

import java.util.*;

public class Lab1P2_LloydCooperr {

    static Scanner read = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion = 0;
            do {
                System.out.println("-------------------MENU-------------------");
                System.out.println("1. Aproximacion de ceros (Newton Raphson)");
                System.out.println("2. Serie de Taylor");
                System.out.println("3. Salida");
                System.out.println("------------------------------------------");
                System.out.println("Seleccione una opcion: ");
  
                opcion = read.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("Ingrese el coeficiente 'a' ");
                        int a = read.nextInt();
                        while (a == 0){
                            System.out.println("El coeficiente debe ser diferente de 0");
                            a = read.nextInt();
                        }
                        
                        System.out.println("Ingrese el coeficiente 'b' ");
                        int b = read.nextInt();
                        
                        System.out.println("Ingrese el coeficiente 'c' ");
                        int c = read.nextInt();
                        
                        int desplazamiento = 200;
                        int iteraciones = 100;
                        
                        int x0Izquierda = -desplazamiento;
                        int x0Derecha = desplazamiento;
                        
                        double raizIzquierda = newtonRaphson(a, b, c,x0Izquierda, iteraciones);
                        double raizDerecha = newtonRaphson(a,b,c, x0Derecha, iteraciones);
                        
                        System.out.println("Ejecución 1: x0 = " + x0Izquierda + ", raíz encontrada: " + raizIzquierda);
                        System.out.println("Ejecución 2: x0 = " + x0Derecha + ", raíz encontrada: " + raizDerecha);
                        System.out.println("Iteraciones: " + iteraciones);
                        break;
                    case 2:
                        System.out.println("Ingrese el valor de 'x' ");
                        double x = read.nextDouble();

                        double senoAproximado = senoTaylor(x);
                        double cosenoAproximado = cosenoTaylor(x);
                        double tangenteAproximada = tangenteTaylor(x);

                        System.out.println("sen(" + x + ") = " + senoAproximado);
                        System.out.println("cos(" + x + ") = " + cosenoAproximado);
                        System.out.println("tan(" + x + ") = " + tangenteAproximada);
                        break;
                    case 3:
                        System.out.println("Adios");
                        break;
                    default:
                }
            } while (opcion != 3);
    }
    
    public static double f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    public static double fPrima(int x, int a, int b) {
        return 2 * a * x + b;
    }

    public static int newtonRaphson(int a, int b, int c, int x, int iteraciones) {
        if (iteraciones == 0) {
            return x;
        } else {
            double fx = f(x, a, b, c);
            double fpx = fPrima(x, a, b);
            double newX = x - fx / fpx;
            return newtonRaphson(a, b, c, (int) newX, iteraciones - 1);
        }
    }
    
    
     public static double senoTaylor(double x) {
        double result = 0;
        double term = x;
        int n = 1;

        while (Math.abs(term) >= 1e-8) {
            result += term;
            term = -term * x * x / ((2 * n) * (2 * n + 1));
            n++;
        }

        return result;
    }

    public static double cosenoTaylor(double x) {
        double result = 1;
        double term = 1;
        int n = 1;

        while (Math.abs(term) >= 1e-8) {
            result += term;
            term = -term * x * x / ((2 * n - 1) * (2 * n));
            n++;
        }

        return result;
    }

    public static double tangenteTaylor(double x) {
        double sen_x = senoTaylor(x);
        double cos_x = cosenoTaylor(x);
        return sen_x / cos_x;
    }
    
    public static double factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
