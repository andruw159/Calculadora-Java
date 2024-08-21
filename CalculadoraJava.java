/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.andruw.calculadorajava;
import java.util.Scanner;
/**
 * 1. Entrar los datos int o string
 * 2. Determinar que sistema se desea utilizar.
 * 3. Operar los datos
 *  3.1 Determinar cuantas notas
 *  3.2 Llamar al metodo entrar datos tantas veces como se quiera
 *  3.3 Entrar porcentajes por cada nota
 *  3.4 Multiplicar la nota por su porcentaje
 *  3.5 Sumar el prodcuto de cada nota.
 * 4. Mostrar el resultado de la suma.
 * 5.Determinar si el estudiante aprobó o reporbró.
 * @author andre
 */
public class CalculadoraJava {
    
    public static Scanner teclado = new Scanner (System.in);
    public static String materia = "";
    public static float notaFinal = 0;
    public static boolean verify = false;
    
    public static int opciones(){ // Lee las 
        int opcion;
        opcion = teclado.nextInt();
        return opcion;
        
    }
    public static int leerNumero(String mensaje){ //Lee números enteros
       int dato;
       System.out.println(mensaje);
       dato = teclado.nextInt();
       return dato;
    }
    
    public static float leerFloat(String mensaje){ //Lee números flotantes
        float dato;
        System.out.println(mensaje);
        dato = teclado.nextFloat();
        return dato;
    }
    
    public static String leerLinea(String mensaje){ //Lee Strings de linea
        String dato; 
        System.out.println(mensaje);
        dato = teclado.nextLine();
        return dato;
    }
    public static String leer(String mensaje){ //Lee Strings cortos
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
    public static boolean letraValida(String letra) {
        return letra.matches("[a-f]");                     // Verifica que la letra esté entre 'a' y 'f'
    }
    
    public static void calculoNotaParcial() { //Calcula la nota final, verifica el sitema que se desee usar (Numerico o Alfanumerico) 
        System.out.println("Bienvenido a tu calculador de promedio");
        materia=leerLinea("Ingrese el nombre de la materia: ");
        while (verify == false){
        System.out.println("Que Sistema utilizas?");
        System.out.println("1. Numerico");
        System.out.println("2. Alfanumerico");
        int respuesta = opciones();
        if (respuesta != 1 || respuesta != 2){
            verify = false;            
        }else{
            verify = true;
        }
       
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
                verify = true;
            }
            case 2 -> {
                int cantNotas = leerNumero("Ingrese la cantidad de notas a procesar");
                float suma=0;
                for(int i=1; i<=cantNotas;i++){
                    String letra =leer("Ingrese la nota "+i+" en letra mayuscula: ");       //Captura la letra proporcionada por el usuario.
                    if (letra.length() != 1 || !Character.isLetter(letra.charAt(0))||letraValida(letra) == false) {   //Verifica la información proporcionada por el usuario y reinicia el contador de ser necesario.
                       System.out.println("Error. Por favor ingrese una letra valida.");
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
                imprimir("Su nota final en la materia "+materia+" es "+notaLetra);
                if (notaFinal>=3){
                    imprimir("Aprobaste la materia "+materia+".");
                }else{
                    imprimir ("Reprobaste la materia "+materia+".");
                } 
                verify = true;
            }

            default -> System.out.println("Opcion no valida ");

        } 
        } 
     
    
    }

    public static void main(String[] args) {
        calculoNotaParcial();
    }
}