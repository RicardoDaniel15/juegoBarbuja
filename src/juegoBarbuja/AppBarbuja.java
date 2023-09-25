package juegoBarbuja;

import java.util.Scanner;

public class AppBarbuja {
    public static void main(String[] args) {

        // Creamos un Scanner
        Scanner sc = new Scanner(System.in);

        // Creamos un jugador
        Jugador jugador1 = new Jugador();

        // Creamos un dado
        Dado d1 = new Dado(6);
        Dado d2 = new Dado(6);

        // Inicio de partida

        if(jugador1.isBandera()){
            int puntosOptenidos = 0;
            int puntosTotales = 0;
            int rondas;
            System.out.println("Digite el numero de rondas que desea jugar: ");
            rondas = sc.nextInt();
            sc.nextLine();

            for(int i = 0; i<rondas;i++){
                int dado1, dado2;
                dado1 = jugador1.lanzarDado(d1);
                dado2 = jugador1.lanzarDado(d2);
                puntosOptenidos = 0;

                if(dado1==1 && dado2==1){
                    puntosOptenidos = 0;
                    puntosTotales = 0;
                    mostrarResultados(i,dado1,dado2,puntosOptenidos);
                    System.out.println("Usted pierde todo lo contabilizado hasta el momento");
                    System.out.println();
                }else if(dado1==1 || dado2==1){
                    puntosOptenidos = puntosOptenidos + 0;
                    mostrarResultados(i,dado1,dado2,puntosOptenidos);
                    System.out.println("Usted no suma en esta ronda");
                    System.out.println();
                } else if((dado2+dado1)==6){
                    puntosOptenidos = puntosOptenidos*2;
                    mostrarResultados(i,dado1,dado2,puntosOptenidos);
                    System.out.println("Duplica los puntos obtenidos por el lanzamiento");
                    System.out.println();
                }else if((dado2+dado1)==12){
                    puntosOptenidos = dado1+dado2+1;
                    mostrarResultados(i,dado1,dado2,puntosOptenidos);
                    System.out.println("Suma un punto adicional");
                    System.out.println();
                }else {
                    puntosOptenidos = dado1+dado2;
                    mostrarResultados(i,dado1,dado2,puntosOptenidos);
                    System.out.println();
                }
                puntosTotales = puntosOptenidos + puntosTotales;
            }

            System.out.println("El resultado total es de: " + puntosTotales);
            System.out.println(jugador1.toString());
        }
        }



    private static void mostrarResultados(int i, int dado1, int dado2, int puntosOptenidos) {
        System.out.println("En la ronda #"+ (++i));
        System.out.println("Dado 1: " + dado1);
        System.out.println("Dado 2: " + dado2);
        System.out.println("Numero de puntos obtenidos en la ronda: " + puntosOptenidos);
    }
}
