package lab1p2_lloydcooperr;

import java.util.*;

public class Lab1P2_LloydCooperr {

    static Scanner read = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion = 0;
            do {
                System.out.println("----MENU----");
                System.out.println("1. Aproximacion de ceros");
                System.out.println("2. Serie de Taylor");
                System.out.println("Seleccione una opcion: ");
                
                opcion = read.nextInt();
                switch (opcion){
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        System.out.println("Adios");
                        break;
                    default:
                }
            } while (opcion != 4);
    }
    
}
