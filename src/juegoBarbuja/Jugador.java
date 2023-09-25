package juegoBarbuja;

import Excepciones.UsurioInavilitado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jugador {
    private String nombre;
    private String id;
    private int edad;
    private boolean bandera = true;
    Scanner sc = new Scanner(System.in);

    public Jugador() {
        System.out.println("------------------Bienvenido-----------------");
        System.out.print("Ingrese su nombre: ");
        this.nombre = sc.nextLine();
        System.out.print("Ingrese su numero de identificación: ");
        this.id = sc.nextLine();
        System.out.print("Ingrese su edad: ");

        try{
            this.edad = sc.nextInt();
            try{
                if(this.edad<18){
                    this.bandera = false;
                    throw new UsurioInavilitado("El usurio debe tener mas de 18 para jugar ");
                }
            }catch (UsurioInavilitado e){
                System.out.println(e.getMessage());
            }
        }catch (InputMismatchException e){
            System.out.println("Ingres su edad en numeros");
        }finally {
            sc.nextLine();
        }

    }

    public boolean isBandera() {
        return bandera;
    }

    public int lanzarDado(Dado dado){
        int numResultado = (int) (Math.random() * dado.getNumDado()) +1;
        return numResultado;
    }

    @Override
    public String toString() {
        return String.format("Jugador: %s%nIdentificacion: %s%n",this.nombre,this.id);
    }
}
