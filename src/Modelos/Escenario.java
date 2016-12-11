/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Maribel
 */
public class Escenario {
    

    
    private int  posicionesLibres = 5;
    private Personaje[][] matrizPosiciones;
    private int[][] matrizConAlturas;
    private Casilla[][] matrizCoordenada;
    private Casilla casilla;
    private TipoDeEscenario tipoEscenario;
    private TipoDeCasilla tipoCasilla;
    private Personaje personaje;
 
    
    //Constructor de la clase
    
    public Escenario(){
        personaje = new Personaje(null);
        tipoEscenario = new TipoDeEscenario();
        this.crearEscenario();

    }
    
    //Métodos get y set.
   
 
    public Casilla getCasilla() {
        return casilla;
    }
    
    public Casilla[][] getMatrizCoordenada() {
        return matrizCoordenada;
    }

    //Atributos de la clase
    public void setMatrizCoordenada(Casilla[][] matrizCoordenada) {
        this.matrizCoordenada = matrizCoordenada;
    }
     

    public boolean crearEscenario() {
        matrizCoordenada = new Casilla[25][25];
        for(int i=0; i<25;i++){
            for(int j=0; j<25;j++){
                matrizCoordenada[i][j] = new Casilla(tipoEscenario,personaje);
            }
        }
        return true;
    }
    //Métodos propios de la clase
    public boolean posicionarPersonaje(ArrayList<String> listaPersonajes){
        int contador = 0;
        Random rand = new Random();
        for(int x = 0;x<listaPersonajes.size();){
            int i = rand.nextInt(25); //se obtiene una fila al azar
            int j = rand.nextInt(25); //se obtiene una colummna al azar
            if(tipoEscenario.getMatrizTerreno()[i][j] != "rio" && matrizCoordenada[i][j].getPersonaje().getNombrePersonaje() == null){
                matrizCoordenada[i][j].setPersonaje(listaPersonajes.get(x));
                System.out.println("los personajes agregados son : " + matrizCoordenada[i][j].getPersonaje().getNombrePersonaje());
                contador = 0;
                x++;
            }
            else{
                x = x;
                System.out.println("se debe reintear el posicionamiento//Método posicionarPersonaje_Escenario");
                contador++;
                
                
            }
                    
        }
        return true;
    }
     
  
  
    public boolean moverCasilla(int i, int j,int x,int y,String nombre){ 
      
            if(matrizCoordenada[x][y].getPersonaje().getNombrePersonaje() == nombre){
                int filaA = Math.abs(i - x);
                int columnaA = Math.abs(j - y);       
            if (filaA == 1 && columnaA  == 0){ //verificar si se ha movido una casilla
                    return true;
            }
            if(filaA == 0 && columnaA  == 1){

                return true;
            }
         }
        return false;
           
    }
    
    public boolean verificarPosicionLibre(int i, int j){
        if(matrizCoordenada[i][j].getPersonaje().getNombrePersonaje() == null){
 
            return true;
        }
        return false;
    }

    public boolean moverDiferenciaAltura(int i, int j,int x,int y){
        if(Math.abs(matrizCoordenada[x][y].getAltura() - matrizCoordenada[i][j].getAltura())<=2){
            System.out.println("la altura del personaje: " + x + "," + y+"," + matrizCoordenada[x][y].getAltura());
            System.out.println("la altura a mover es: "+ i+","+j+"," + matrizCoordenada[i][j].getAltura());
           return true; 
        }
        return false;
    }
    
  
    public void agregarPosicion(int i, int j,String personaje){
        matrizCoordenada[i][j].setPersonaje(personaje);
        
    
      }
    
//    public boolean quitarPosicion(){
//        for(int x=0; x<25; x++){
//            for(int y = 0; y<25; y++){
//                if(matrizCoordenada[x][y].getPersonaje() != null){
//                   matrizCoordenada[x][y] = new Casilla(x,y,matrizConAlturas[x][y],null,tipoEscenario);
//                }
//            }
//    
//        }
//        return false;
//    }
  

    
   
     
    
        /**
     * Metodo que asigna las alturas correspondientes segun las reglas generales y las especificas del modulo basico.
     * @return int[][] Retorna una lista de listas con todos los valores de las alturas en las posiciones correspondientes a sus casillas.
     */
    public boolean asignarAlturasModuloBasico(){
    	Random rnd = new Random();
	int numeroAleatorio; //Variable sobre el cual se aplicara el random.
	int sumando; //Valor obtenido de la listaValoresSumar que se le sumara a una altura anterior para obtener la altura de la casilla actual.
	int alturaPrevia; //Variable que almacena la altura de la casilla de la izquierda o la superior a la casilla actual.
	int[] listaAlturasPrevias = new int[2]; //Lista que almacena las alturas de las casillas superior y de la izquierda a la casilla actual, siempre que sea posible.
	int alturaActual; //Variable que almacena la altura que se le asignara a la casilla actual.
        int[] listaValoresSumar = new int[5]; //Lista con los valores de altura a sumar a la casilla actual, posee los valores [-2,-1,0,1,2] que se agregan en la siguiente iteracion.
        //La siguiente iteracion es unicamente para agregar los valores [-2,-1,0,1,2] a la lista de los valores que se sumaran.
        int k = 0;
        while (k<listaValoresSumar.length){
            listaValoresSumar[k]=k-2;
            k++;
        }
        //Se comienza a recorrer el tablero.
	int i = 0;
	while (i<matrizCoordenada.length){
		int j = 0;
		while (j<matrizCoordenada[i].length){
			if (j==0){
                                //El siguiente "if" le asigna un valor "fijo" a la primera casilla (0,0) del tablero, a partir de la cual se obtendra todo el resto.
				if (i==0){
					numeroAleatorio=(int)(rnd.nextDouble()*5); //Se obtiene un numero aleatorio entre 0 y 5.
					sumando=listaValoresSumar[numeroAleatorio]; //Se obtiene el valor de la lista de los valores a sumar que se encuentre en la posicion del numero obtenido aleatoriamente.
					alturaActual=3+sumando; //Se fija el numero 3 y se le suma el valor se la lista anterior.
					matrizCoordenada[i][j].setAltura(alturaActual); //Se asigna la altura en la posicion correspondiente.
				}
                                //El siguiente "else" funciona para todas las casillas de la primera fila sin contar la (0,0), toman en cuenta la altura de la casilla de la izquierda.
				else{
					numeroAleatorio=(int)(rnd.nextDouble()*5);
					sumando=listaValoresSumar[numeroAleatorio];
					alturaPrevia=matrizCoordenada[i-1][j].getAltura(); //Se obtiene la altura de la casilla de la izquierda.
					alturaActual=alturaPrevia+sumando; //A la altura anterior se le suma el valor obtenido entre -2 y 2 por lo que siempre se podra acceder desde la casilla anterior a esta casilla.
					//El siguiente "if" es para que no existan alturas sobre 5 (restriccion del modulo basico al tener solo terrenos de tierra) y no hayan alturas negativas.
                                        if (alturaActual>5 || alturaActual<0){
                                                //Lo que se hace es: si es que la altura final se excede de los valores se le resta dos veces el sumando obtenido, haciendo el efecto de negar la primera suma dejando 
                                                //el numero original para luego restarle el valor del sumando.
						alturaActual=alturaActual-2*sumando;
					}
					matrizCoordenada[i][j].setAltura(alturaActual); //Se asigna la altura en la posicion correspondiente.
				}
			}
                        //El siguiente "else if" funciona para todas las casillas de la primera columna sin contar la (0,0), toman en cuenta la altura de la casilla de arriba.
			else if (i==0){
				numeroAleatorio=(int)(rnd.nextDouble()*5);
				sumando=listaValoresSumar[numeroAleatorio];
				alturaPrevia=matrizCoordenada[i][j-1].getAltura();
				alturaActual=alturaPrevia+sumando;
				if (alturaActual>5 || alturaActual<0){
					alturaActual=alturaActual-2*sumando;
				}
				matrizCoordenada[i][j].setAltura(alturaActual);  //Se asigna la altura en la posicion correspondiente.
			}
                        //El siguiente "else" funciona para el resto de las casillas, toman en cuenta de forma aleatoria la altura de la casilla de arriba o la de la casilla de la izquierda.
			else{
				numeroAleatorio=(int)(rnd.nextDouble()*5);
				sumando=listaValoresSumar[numeroAleatorio];
				listaAlturasPrevias[0]=matrizCoordenada[i-1][j].getAltura(); //Almacena el valor de altura de la casilla de la izquierda en la lista de alturas previas.
				listaAlturasPrevias[1]=matrizCoordenada[i][j-1].getAltura(); //Almacena el valor de altura de la casilla superior en la lista de alturas previas.
				numeroAleatorio=(int)(rnd.nextDouble()*2); //Obtiene un valor aleatorio entre 0 y 1.
				alturaPrevia=listaAlturasPrevias[numeroAleatorio]; //Utiliza el valor anterior para tomar un valor de la lista de alturas previas en la posicion correspondiente.
				alturaActual=alturaPrevia+sumando;
				if (alturaActual>5 || alturaActual<0){
					alturaActual=alturaActual-2*sumando;
				}
				matrizCoordenada[i][j].setAltura(alturaActual); //Se asigna la altura en la posicion correspondiente.
                              
                                
				
			}
                    j++;
		}
	
	
            i++;
	}	
	return true;	        
    }
    
   
    
    
    
    
}
