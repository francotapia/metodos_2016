/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
/***********************************************************************
 * Module:  Cpu.java
 * Author:  franco
 * Purpose: Defines the Class Cpu
 ***********************************************************************/

import java.util.*;

/** @pdOid 8ceb881c-ab5c-4caf-b535-1a50bdcdccdb */
public class Cpu extends Jugador {

   
     private ArrayList<Personaje> equipo;
     private Escenario escenario;
     private Casilla casilla;
 
   public Cpu(){
       casilla = new Casilla();
       equipo = new ArrayList<>();
       Personaje personaje1 = new Personaje("canito","cpu","compañero","arquero","alumno",100,100,100,100,5,1,1,3,3,3,0,4);
       Personaje personaje2 = new Personaje("pablo","cpu","ayudante","guerrero","alumno",100,100,100,100,5,1,1,3,3,3,50,8);
       Personaje personaje3 = new Personaje("wendy","cpu","compañero","arquero","alumno",80,50,120,100,5,1,1,3,3,3,0,9);
       Personaje personaje4 = new Personaje("pinky","cpu","profesor","arquero","alumno",400,400,400,100,5,1,1,3,3,3,0,11);
       Personaje personaje5 = new Personaje("mr_satan","cpu","ayudante","guerrero","alumno",150,110,110,110,6,1,1,3,3,3,0,1);
       equipo.add(personaje1);
       equipo.add(personaje2);
       equipo.add(personaje3);
       equipo.add(personaje4);
       equipo.add(personaje5);
   }
   /** @pdOid d93300a0-30a5-4dd9-9725-8823914992fc */
   public int buscarPersonajeAtacar() {
      // TODO: implement
      return 0;
   }
    public ArrayList<Personaje> getEquipo() {
        return equipo;
    }
    
   public ArrayList<int[]> obtenerCamino(int[] posicion, int[] posicionEnemigo,Escenario escenario){
    ArrayList<int[]> listaMovimientos = new ArrayList<>(); //Lista final a la que se le agregaran los movimientos correctos.
    ArrayList<ArrayList<int[]>> listaTransicional = new ArrayList<>(); //Lista que contiene las posiciones obtenidas alrededor de cualquier casilla analizada.
	//Al final se hace un ciclo para tomar el camino correcto de todos los pares de coordenadas que se encuentren en esta lista y se agregaran a la lista movimientos.
	ArrayList<int[]> coordenadasTransicionales = new ArrayList<>(); //Se utilizara para ir agregando cada par de coordenadas, se hace un clear al inicio de
	//cada ciclo para ir agregando solo de a pares de coordenadas a la lista de movimientos. El formato es (coordenada anterior, coordenada actual).
	int[] posicionActual = new int[2];
	int[] posicionAnterior = new int[2];
	//Se copian las coordenadas iniciales tanto en la posicion actual y la anterior.
	posicionActual[0]=posicion[0];
	posicionAnterior[0]=posicion[0];
	posicionActual[1]=posicion[1];
	posicionAnterior[1]=posicion[1];
	//Se procede a agregar a las coordenadas transicionales.
	coordenadasTransicionales.add(posicionAnterior);
	coordenadasTransicionales.add(posicionActual);
	//Se agregan ambas coordenadas iniciales a la lista transicional.
	listaTransicional.add(coordenadasTransicionales);
	//Para cada elemento en la lista transicional.
	//Si la posicion actual es distinta de la posicion de las adyacentes al jugador.
	int i = 0;
	while(i<listaTransicional.size()){
		posicionActual[0]=listaTransicional.get(i).get(1)[0];
		posicionActual[1]=listaTransicional.get(i).get(1)[1];		
		if(!casilla.buscarCoordenadasEnLista(posicionActual,casilla.obtenerCasillasAdyacentes(posicionEnemigo))){
			coordenadasTransicionales = new ArrayList<>(); //Se crea de nuevo el objeto porque si no al modificarlo como se hace en el ciclo
			//se modifica tambien el que previamente se agrego a la lista. Si no se crea de nuevo antes de cada modificacion la lista final 
			//tendria los mismos valores repetidos muchas veces.
			posicionAnterior[0]=listaTransicional.get(i).get(1)[0];
			posicionAnterior[1]=listaTransicional.get(i).get(1)[1];
			//Primer caso para la casilla de arriba.
			posicionActual[0]=posicionAnterior[0];
			posicionActual[1]=posicionAnterior[1]-1;
			////REVISAR SI SE PUEDE DE ACUERDO A ALTURA O TERRENO, lo siguiente ocurre solo si la posicion es valida.
			//Se agregan las coordenadas en el orden establecido a las coordenadasTransicionales que se vacio previamente.
			if ((escenario.getMatrizCoordenada()[posicionActual[0]][posicionActual[1]].getAltura()-escenario.getMatrizCoordenada()[posicionAnterior[0]][posicionAnterior[1]].getAltura())<=2 && escenario.getMatrizCoordenada()[posicionActual[0]][posicionActual[1]].getTipoEscenario().getMatrizTerreno()[posicionActual[0]][posicionActual[1]]!="rio"){
				coordenadasTransicionales.add(posicionAnterior);
				coordenadasTransicionales.add(posicionActual);
				//Se agrega el par de coordenadas a la lista transicional.
				listaTransicional.add(coordenadasTransicionales);
			}

			//Segundo caso para la casilla de la derecha.
			coordenadasTransicionales = new ArrayList<>();
 			//Se suman los valores para hacer que la casilla corresponda a la de la derecha de la original.
			//No se modifica el valor de casilla anterior, solo el de casilla actual.
			posicionActual[0]=posicionAnterior[0]+1;
			posicionActual[1]=posicionAnterior[1];			
			////REVISAR SI SE PUEDE DE ACUERDO A ALTURA O TERRENO, lo siguiente ocurre solo si la posicion es valida.
			if ((escenario.getMatrizCoordenada()[posicionActual[0]][posicionActual[1]].getAltura()-escenario.getMatrizCoordenada()[posicionAnterior[0]][posicionAnterior[1]].getAltura())<=2 && escenario.getMatrizCoordenada()[posicionActual[0]][posicionActual[1]].getTipoEscenario().getMatrizTerreno()[posicionActual[0]][posicionActual[1]]!="rio"){
				coordenadasTransicionales.add(posicionAnterior);
				coordenadasTransicionales.add(posicionActual);
				listaTransicional.add(coordenadasTransicionales);
			}
			
			
			//Tercer caso para la casilla de abajo.
			coordenadasTransicionales = new ArrayList<>();
 			//Se suman los valores para hacer que la casilla corresponda a la de la que esta abajo de la original.
			posicionActual[0]=posicionAnterior[0];
			posicionActual[1]=posicionAnterior[1]+1;
			////REVISAR SI SE PUEDE DE ACUERDO A ALTURA O TERRENO, lo siguiente ocurre solo si la posicion es valida.
			if ((escenario.getMatrizCoordenada()[posicionActual[0]][posicionActual[1]].getAltura()-escenario.getMatrizCoordenada()[posicionAnterior[0]][posicionAnterior[1]].getAltura())<=2 && escenario.getMatrizCoordenada()[posicionActual[0]][posicionActual[1]].getTipoEscenario().getMatrizTerreno()[posicionActual[0]][posicionActual[1]]!="rio"){
				coordenadasTransicionales.add(posicionAnterior);
				coordenadasTransicionales.add(posicionActual);
				listaTransicional.add(coordenadasTransicionales);
			}
			
			
			//Cuarto caso para la casilla de la izquierda.
			coordenadasTransicionales = new ArrayList<>();			
 			//Se suman los valores para hacer que la casilla corresponda a la de la izquierda de la original.
			posicionActual[0]=posicionAnterior[0]-1;
			posicionActual[1]=posicionAnterior[1];
			////REVISAR SI SE PUEDE DE ACUERDO A ALTURA O TERRENO, lo siguiente ocurre solo si la posicion es valida.
			if ((escenario.getMatrizCoordenada()[posicionActual[0]][posicionActual[1]].getAltura()-escenario.getMatrizCoordenada()[posicionAnterior[0]][posicionAnterior[1]].getAltura())<=2 && escenario.getMatrizCoordenada()[posicionActual[0]][posicionActual[1]].getTipoEscenario().getMatrizTerreno()[posicionActual[0]][posicionActual[1]]!="rio"){
				coordenadasTransicionales.add(posicionAnterior);
				coordenadasTransicionales.add(posicionActual);
				listaTransicional.add(coordenadasTransicionales);
			}
		}
		i++;
	}

	//Ahora se debe filtrar unicamente el camino optimo.
	//Por cada elemento en lista transicional: revisa si alguno pertenece a las cercanias del personaje enemigo.
	int k = 0;
	for(ArrayList<int[]> e: listaTransicional){
		//Si alguna casilla de la lista esta alrededor del enemigo se guarda la posicion en la lista.
		if(casilla.buscarCoordenadasEnLista(e.get(1),casilla.obtenerCasillasAdyacentes(posicionEnemigo))){
			break;
		}
		k++;
	}
	
	listaMovimientos.add(listaTransicional.get(k).get(1));

	casilla.encontrarCaminoRecorrido(posicion,k,listaMovimientos,listaTransicional,listaTransicional.get(k).get(0));
        Collections.reverse(listaMovimientos);
    return listaMovimientos; 
}



}