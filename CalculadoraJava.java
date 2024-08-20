/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadorajava;
import java.util.Scanner;

/**
 *
 * @author juanh
 */
public class CalculadoraJava {
    
    public static Scanner teclado = new Scanner (System.in);
    public static String materia = "";
    public static float notaFinal = 0;
    
    public static int opciones(){
        int opcion;
        opcion = teclado.nextInt();
        return opcion;
        
    }
    public static int leerNumero(String mensaje){
       int dato;
       System.out.println(mensaje);
       dato = teclado.nextInt();
       return dato;
    }
    
    public static float leerFloat(String mensaje){
        float dato;
        System.out.println(mensaje);
        dato = teclado.nextFloat();
        return dato;
    }
    
    public static String leerLinea(String mensaje){
        String dato; 
        System.out.println(mensaje);
        dato = teclado.nextLine();
        return dato;
    }
    public static String leer(String mensaje){
        String dato; 
        System.out.println(mensaje);
        dato = teclado.next();
        return dato;
    }
    
    public static float multiplicar(float nota, float porcentaje ){
        return (nota*(porcentaje/100));
    }
    
    public static void imprimir(String resultado){
        System.out.println(""+resultado);
    }
    
    public static int convertLetraANumero(char letra) {     //Función que nos permite convertir una letra a numero
         int num = 0;
        switch (letra){
            case 'A' ->{
               num = (letra - 'A') + 5; 
            }
            case 'B' ->{
               num = (letra - 'B') + 4;  
            }
            case 'C' ->{
               num = (letra - 'C') + 3;  
            }
            case 'D' ->{
               num = (letra - 'D') + 2;  
            }
            case 'E' ->{
               num = (letra - 'E') + 1;  
            }
            case 'F' ->{
               num = (letra - 'F') + 0;  
            }
        }
         return num;
    }
    public static String convertNumeroALetra(int numero) {      //Función que nos permite convertir un numero a letra
         String letra="";
        switch (numero){
            case 5 ->{
               letra = String.valueOf((char) (numero - 5 + 'A')); 
            }
            case 4 ->{
               letra = String.valueOf((char) (numero - 4 + 'B'));  
            }
            case 3 ->{
               letra = String.valueOf((char) (numero - 3 + 'C'));  
            }
            case 2 ->{
               letra = String.valueOf((char) (numero - 2 + 'D'));  
            }
            case 1 ->{
               letra = String.valueOf((char) (numero - 1 + 'E'));  
            }
            case 0 ->{
               letra = String.valueOf((char) (numero - 0 + 'F')); 
            }
        }
         return letra;
    }
    

    public static void calculoNotaParcial() {
        System.out.println("Bienvenido a tu calculador de promedio");
        materia=leerLinea("Ingrese el nombre de la materia: ");
        
        System.out.println("Que Sistema utilizas?");
        System.out.println("1. Numerico");
        System.out.println("2. Alfanumerico");
        int respuesta = opciones();
        switch (respuesta) {
            case 1 -> {
                int cantNotas = leerNumero("Ingrese la cantidad de notas a procesar");
                float suma=0;
                for(int i=1; i<=cantNotas;i++){
                    float nota1 = leerFloat("Ingrese la nota "+i+" :");
                    float porcentaje = leerFloat("Ingrese el porcentaje de la nota "+i+":");
                    suma = suma+multiplicar(nota1,porcentaje);
                }      notaFinal=suma;
                imprimir("En la materia "+materia+" la nota final es: "+notaFinal);
                if (notaFinal>=3){
                    imprimir("Aprobaste la materia "+materia);
                }else{
                    imprimir ("Reprobaste la materia "+materia);
                }
            }
            case 2 -> {
                int cantNotas = leerNumero("Ingrese la cantidad de notas a procesar");
                float suma=0;
                for(int i=1; i<=cantNotas;i++){
                    String letra =leer("Ingrese la nota en letra mayuscula: ");       //Captura la letra proporcionada por el usuario
                    if (letra.length() != 1 || !Character.isLetter(letra.charAt(0))) {   //Verifica la información proporcionada por el usuario y reinicia el contador de ser necesario
                       System.out.println("Error. Por favor ingrese una sola letra.");
                       i=0;
                       } else {
                        char letra1 = letra.toUpperCase().charAt(0);      //Convierte la letra en mayuscula en caso de necesitarlo
                        int var1 = convertLetraANumero(letra1);             //llama a la funcion para convertir la letra en un numero
                        float porcentaje = leerFloat("Ingrese el porcentaje de la nota "+i+":");
                        suma = suma+multiplicar(var1,porcentaje);
                    }
                } notaFinal =suma;
                int notaInt=(int) Math.floor(notaFinal);                    //Convierte la nota final si esta en decimal a entera
                String notaLetra = convertNumeroALetra(notaInt);            //Convierte el numero obtenido a letra
                imprimir("Su nota final en la materia "+materia+" es"+notaLetra);
                if (notaFinal>=3){
                    imprimir("Aprobaste la materia "+materia);
                }else{
                    imprimir ("Reprobaste la materia "+materia);
                }
                
            }
              
            default -> System.out.println("Opcion no valida ");
        }
     }
    
    
    public static void main(String[] args) {
        calculoNotaParcial();
    }

    
}
