/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Benxamin
 */
public class Ahorcado {
    
    private ArrayList<ArrayList> listaCategorias=new ArrayList<>();
    private ArrayList<String> alimentos = new ArrayList<>();
    private ArrayList<String> animales = new ArrayList<>();
    private ArrayList<String> objetos = new ArrayList<>();
    
    //Agrega palabras predeterminadas a las litas de categorias.
    public void agregarPalabras(){
        animales.add("perro");
        animales.add("gato");
        animales.add("tortuga");
        alimentos.add("zanahoria");
        alimentos.add("melon");
        alimentos.add("pan");
        objetos.add("libro");
        objetos.add("cuaderno");
        objetos.add("computador");
    }
    
    //Agrega las listas a la lista de categorias.
    public void agregarCategorias(){
        listaCategorias.add(animales);
        listaCategorias.add(alimentos);
        listaCategorias.add(objetos);
        
    }
    
    //Constructor de la clase.
    public Ahorcado(){
        agregarPalabras();
        agregarCategorias();
        
    }
    
    //Elige una palabra aleatoria de una lista.
    public String elegirPalabra(){
        Random rnd = new Random();
        int numeroAleatorio =  (int)(rnd.nextDouble()*3); //Cantidad de listas
        ArrayList<String> categoria = listaCategorias.get(numeroAleatorio);
        System.out.println(categoria);
        int otroNumeroAleatorio =  (int)(rnd.nextDouble()*3);
        String palabra = categoria.get(otroNumeroAleatorio);
        System.out.println(palabra);
        return palabra;
    }
    
    //Verifica que la letra ingresada sea parte de la palabra.
    public boolean verificarLetra(String letra, String palabra){
        boolean verificacion;
        letra=letra.toLowerCase();
        verificacion=palabra.contains(letra);
        return verificacion;
    }
    
    //Pide una letra al usuario, se cambiara al usar KeyListeners o pedir directamente desde la vista.
    public String pedirLetra(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----->Ingresa una letra:");
        String letra= sc.next();
        System.out.println("La letra ingresada es: "+letra);
        return letra;}
    
    //Comprueba si la letra ingresada es valida en su formato.
    public boolean validarLetra(String letra){
        ArrayList<String> listaLetras = new ArrayList<>( Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        if(letra.length()==1){
            if(listaLetras.contains(letra)){
                return true;}
            else{
                return false;}}
        else{ 
            return false;}
    }    
    
    //Crea los espacios que se le muestran al usuario para que adivine la palabra.
    public String crearEspacios(String palabra){
        int largo = palabra.length();
        int i=0;
        String espacios="";
        while (i<largo){
            espacios=espacios+"_";
            i=i+1;
            }
        return espacios;
    }
    
    //Actualiza dichos espacios (ver funcion anterior) cuando la letra ingresada esta dentro de la palabra.
    public String actualizarEspacios(String letra, String palabra, String espacios){
        String espaciosNuevos = "";
        String[] espaciosSeparados = espacios.split("");
        String[] palabraSeparada = palabra.split("");
        int i = 0;
        int largo = palabra.length();
        while (i<largo){
            String elemento = palabraSeparada[i];
            String otroElemento = espaciosSeparados[i];
            if(elemento.equals(letra)){
                espaciosNuevos=espaciosNuevos+elemento;
            }
            else if(elemento.equals(otroElemento)){
                espaciosNuevos=espaciosNuevos+elemento;
            }
            else {espaciosNuevos=espaciosNuevos+"_";}
            i=i+1;
        }
        return espaciosNuevos;
    }
}
