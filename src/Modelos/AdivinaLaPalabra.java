/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Random;

/**
 *
 * @author franco
 */
public class AdivinaLaPalabra {
    private String[] listaAnimales = {"perro","gato","caballo","elefante","leon","vaca","hormiga"};
    private String[] listaPeliculas = {"titanic","avatar","boyhood"};
    private String[] listaCursos = {"calculo","algebra","metodos de programacion"};
    private  int intentos = 5;
    private String palabra;


    private String pista1;
    private String pista2;
    private String pista3;
    
    
   public int getIntentos() {
        return intentos; //valor de cantidad de intentos base
    }
   
    public String getPista1() {
        return pista1;
    }

    public void setPista1(String pista1) {
        this.pista1 = pista1;
    }

    public String getPista2() {
        return pista2;
    }

    public void setPista2(String pista2) {
        this.pista2 = pista2;
    }

    public String getPista3() {
        return pista3;
    }

    public void setPista3(String pista3) {
        this.pista3 = pista3;
    }
   
    ///Método que compara palabras, para evaluar igualdad entre ellas////
    //Entrada: String
    //Salida: boolean
    
    public boolean comparar(String palabra){
        
        if(this.palabra.equals(palabra)){  //Si el atributo palabra es igual a la palabra ingresada, se retorna true.
            System.out.println(this.palabra);
            return true;
        }
        return false;
       }
    
    ////Método que disminuye la cantidad de intentos////
    //Entrada: -----------------------------
    //Salida: entero con intentos reducidos
    
    public int disminuirIntentos(){ 
           intentos = intentos - 1 ;   //Los intentos iniciales son iguales a los intentos disponibles menos una unidad.
           System.out.println(intentos); 
           return intentos; //Cantidad de intentos con una unidad menos
   }

  
    ////Método que busca una palabra al azar para poder jugar////
    //Entrada: -----------------------------
    //Salida: -----------------------------
    public void obtenerPalabra(int i){
        int largoLista = 0;
        String[] nombreLista = null;
        if(i == 1){
            nombreLista = listaAnimales;
            largoLista = listaAnimales.length; 
        }
        
        if(i == 2){
            nombreLista = listaPeliculas;
            largoLista = listaPeliculas.length;
        }
        
        if(i == 3){
            nombreLista = listaCursos;
            largoLista = listaCursos.length;
        }
         //tamaño de la lista de palabras
        Random random = new Random(); //se instancia la clase Random
        int posicionAzar =random.nextInt(largoLista -1); //se obtiene una posición al azar
        this.palabra = nombreLista[posicionAzar]; //se muestra palabra al azar
        System.out.println(palabra);

     }
    
    public void mostrarPista(){
        if(palabra.equals("perro")){
            pista1 = "Es un animal domestico";
            pista2 = "Pertenece a la familia de los cánidos";
            pista3 = "Su sonido es el ladrido";
        }
        
        if(palabra.equals("gato")){
            pista1 = "Es un animal domestico";
            pista2 = "Pertenece a la familia de los felinos";
            pista3 = "Su sonido es el maullido";
        }
        
        if(palabra.equals("caballo")){
            pista1 = "Es un animal domestico";
            pista2 = "Pertenece a la familia de los équidos";
            pista3 = "Su sonido es el relincho";
        }
        
        if(palabra.equals("elefante")){
            pista1 = "Es un animal salvaje";
            pista2 = "Pertenece a la familia de los Elefántidos";
            pista3 = "Su sonido es el barrito";
        }
        
        if(palabra.equals("leon")){
            pista1 = "Es un animal salvaje";
            pista2 = "Pertenece a la familia de los félidos";
            pista3 = "Su sonido es el rugido";
        }
        
        if(palabra.equals("vaca")){
            pista1 = "Es un animal domestico";
            pista2 = "Pertenece a la familia de los bóvidos";
            pista3 = "Su sonido es el mugido";
        }
        
        if(palabra.equals("titanic")){
            pista1 = "El director es James Cameron";
            pista2 = "Su genero es el drama";
            pista3 = "Su protagonista es  Leonardo DiCaprio y Kate Winsle";
        }
        
        if(palabra.equals("avatar")){
            pista1 = "El director es James Cameron";
            pista2 = "Su genero es la Ciencia Ficción";
            pista3 = "Su protagonista es  Sam Worthington";   
        }
        if(palabra.equals("boyhood")){
            pista1 = "El director es Richard Linklater";
            pista2 = "Su genero es el Drama";
            pista3 = "Su protagonista es Ellar Coltrane";   
        }
        if(palabra.equals("calculo")){
            pista1 = "Pertenece al departamento de matemáticas";
            pista2 = "Se cursa en el primer,segundo y tercer semestre";
            pista3 = "Una de sus unidades se enfoca en derivar funciones";   
        }
        if(palabra.equals("algebra")){
            pista1 = "Pertenece al departamento de Lingüística y Literatura";
            pista2 = "Se cursa en el primer y segundo semestre";
            pista3 = "Una de sus unidades se enfoca en los espacios vectoriales";   
        }
        if(palabra.equals("metodos de programacion")){
            pista1 = "Pertenece al departamento de Informática";
            pista2 = "Se cursa en el tercer semestre";
            pista3 = "Una de sus unidades se enfoca en los metodos de solución de problemas";   
        }
        
        
    }
    
    
    
 
   

       
    }
