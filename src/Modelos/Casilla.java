/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/***********************************************************************
 * Module:  Casilla.java
 * Author:  franco
 * Purpose: Defines the Class Casilla
 ***********************************************************************/

public class Casilla {
    
    private int altura;
    private int[][] coordenada;
    private int coordenadaX;
    private int coordenadaY;
    private Personaje personaje;
    private TipoDeCasilla tipoCasilla;
    private TipoDeEscenario tipoEscenario;

    
   public Casilla(TipoDeEscenario tipoEscenario, Personaje personaje){
       this.personaje = personaje;
       coordenadaX = 0;
       coordenadaY = 0;  
       coordenada = new int[25][25];
       this.altura = 0;
       this.tipoEscenario = tipoEscenario;
       
       
       //this.tipoCasilla = casilla;
   }

    Casilla() {
       
    }
   

    //Métodos get y set
     public Personaje getPersonaje() {
        return personaje;
    }
     public Personaje getPersonaje(String nombre) {
        return personaje;
    }
     

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
 
    }
    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    public TipoDeEscenario getTipoEscenario() {
        return tipoEscenario;
    }

    public void setTipoEscenario(TipoDeEscenario tipoEscenario) {
        this.tipoEscenario = tipoEscenario;
    }

    public int[][] getCoordenada(){
        return coordenada;
    }
    
    public void setCoordenada(int[][] coordenada) {
        this.coordenada = coordenada;
    }
    
    public int getAltura() {
        return altura;
    }
    
    public void setAltura(int altura) {
        this.altura = altura;
    }

       
    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }
   
   
       public boolean compararCoordenadas(int[] primeraCoordenada, int[] segundaCoordenada){
        int i = 0;
        boolean[] listaVerificacion = new boolean[primeraCoordenada.length];
        boolean valorFinal=true;
        while(i<primeraCoordenada.length){
            if (primeraCoordenada[i]==segundaCoordenada[i]) {
                listaVerificacion[i]=true;
            }
            else{
                listaVerificacion[i]=false;
            }
            i++;
        }
        for(Boolean b : listaVerificacion){
            if(b==true){
                valorFinal=true;
            }
            else{
                valorFinal=false;
                break;
            }
        }
        return valorFinal;
    }
    
    public ArrayList<int[]> obtenerCasillasAdyacentes(int[] casillaSeleccionada) {
	//Crear lista.
	ArrayList<int[]> listaFinal = new ArrayList<>();
	int[] coordenadaNueva = new int[2];
	//Obtener los valores de x e y pro separado.
	int coordenadaX = casillaSeleccionada[0];
	int coordenadaY = casillaSeleccionada[1];
	//Ir por casos e ir agregandolos a la lista.
	int i = -1;
	while(i<=1){
		int j=-1;
		while (j<=1){
			coordenadaNueva[0]=coordenadaX+i;
			coordenadaNueva[1]=coordenadaY+j;
			if(compararCoordenadas(casillaSeleccionada,coordenadaNueva)){
				j=j+1;
			}
			else{
				listaFinal.add(coordenadaNueva);
				j=j+1;
			}
		}
		i=i+1;
	}
	return listaFinal;
}
    
    public boolean buscarCoordenadasEnLista(int[] coordenadas, ArrayList<int[]> lista){
        for(int[] i : lista){
            if(compararCoordenadas(coordenadas,i)==true){
                return true;
            }
        }
        return false;
    }
    
    
    //La posicion es la casilla 0 de la que se agrego primero (verfuncion obtener camino).
    public ArrayList<int[]> encontrarCaminoRecorrido(int[] posicionInicial,int k ,ArrayList<int[]> listaMovimientos , ArrayList<ArrayList<int[]>> listaTransicional, int[] posicion){
        if (compararCoordenadas(posicionInicial,posicion)){
            if(listaMovimientos.size()!=2){
                listaMovimientos.add(posicionInicial);
                return listaMovimientos;
            }
        }
        
        else{
            for(ArrayList<int[]> e : listaTransicional){
                if(compararCoordenadas(e.get(1),posicion)){
                    listaMovimientos.add(e.get(1));
                    System.out.println("("+e.get(1)[0]+","+e.get(1)[1]+")");
                    encontrarCaminoRecorrido(posicionInicial,k,listaMovimientos,listaTransicional,e.get(0));
                }
            }
        }
        return listaMovimientos;
    }
    
    
     
   
   
   
  
  
   

  

}