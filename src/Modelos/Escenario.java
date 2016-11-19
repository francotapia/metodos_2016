/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Random;

/**
 *
 * @author Maribel
 */
public class Escenario {
    private int Ancho;
    private int Largo;
    private static int  espaciosLibres = 5;
    private int posicionesLibres;
    private static int[][] disponibilidadPosicion;
    private Personaje personaje;
    private int[][] tableroConAlturas;
    private Casilla[][] coordenada;
    private Casilla casilla;
    private TipoDeEscenario tipoEscenario;
    private TipoDeCasilla tipoCasilla;
    
    public Escenario(){
        casilla = new Casilla();
        this.mostrarCoordenadas();
        this.asignarAlturasModuloBasico();
        posicionarPersonaje();
    }
 
    public Casilla[][] mostrarCoordenadas() {
        coordenada = new Casilla[25][25];
        tableroConAlturas = new int[25][25];
        Random rnd = new Random();
        for(int i=0; i<25;i++){
            for(int j=0; j<25;j++){
                coordenada[i][j] = new Casilla(i,j,tableroConAlturas[i][j]);
            }
            
        }
        return coordenada;
    }
    public static int[][] posicionarPersonaje(){ //borrar static
        disponibilidadPosicion = new int[25][25];
        int[][] numero = new int[25][25];
        Random rand = new Random();
        for(int i=0; i<25;i++){
           for(int j= 0; j<25;j++){
               
               i = rand.nextInt(25);
               j = rand.nextInt(25);
               numero[i][j] = rand.nextInt(2);
               if(espaciosLibres > 0 && numero[i][j]== 1){
                   System.out.println(i+","+j +","+numero[i][j]);
                   disponibilidadPosicion[i][j] = 1;
                   espaciosLibres=espaciosLibres-1;
               }
               else if(espaciosLibres == 0){
                  disponibilidadPosicion[i][j] =  0;
                  espaciosLibres = 0;
               }
            }
                
       }
   
       return disponibilidadPosicion ;
   }
    /*public static void main(String[] args){
        posicionarPersonaje();
    }*/
   
    
  
    
    public int[][] getDisponibilidadPosicion() {
        return disponibilidadPosicion;
    }
    
    
   
    public Personaje getPersonaje() {
        return personaje;
    }
    public Casilla getCasilla() {
        return casilla;
    }
     
     public int[][] getAltura() {
        return tableroConAlturas;
    }
     
    
        /**
     * Metodo que asigna las alturas correspondientes segun las reglas generales y las especificas del modulo basico.
     * @return int[][] Retorna una lista de listas con todos los valores de las alturas en las posiciones correspondientes a sus casillas.
     */
    public int[][] asignarAlturasModuloBasico(){
    	Random rnd = new Random();
	tableroConAlturas=new int[25][25]; //Es la matriz que posee los valores de alturas.
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
	while (i<tableroConAlturas.length){
		int j = 0;
		while (j<tableroConAlturas[i].length){
			if (j==0){
                                //El siguiente "if" le asigna un valor "fijo" a la primera casilla (0,0) del tablero, a partir de la cual se obtendra todo el resto.
				if (i==0){
					numeroAleatorio=(int)(rnd.nextDouble()*5); //Se obtiene un numero aleatorio entre 0 y 5.
					sumando=listaValoresSumar[numeroAleatorio]; //Se obtiene el valor de la lista de los valores a sumar que se encuentre en la posicion del numero obtenido aleatoriamente.
					alturaActual=3+sumando; //Se fija el numero 3 y se le suma el valor se la lista anterior.
					tableroConAlturas[i][j]=alturaActual; //Se asigna la altura en la posicion correspondiente.
				}
                                //El siguiente "else" funciona para todas las casillas de la primera fila sin contar la (0,0), toman en cuenta la altura de la casilla de la izquierda.
				else{
					numeroAleatorio=(int)(rnd.nextDouble()*5);
					sumando=listaValoresSumar[numeroAleatorio];
					alturaPrevia=tableroConAlturas[i-1][j]; //Se obtiene la altura de la casilla de la izquierda.
					alturaActual=alturaPrevia+sumando; //A la altura anterior se le suma el valor obtenido entre -2 y 2 por lo que siempre se podra acceder desde la casilla anterior a esta casilla.
					//El siguiente "if" es para que no existan alturas sobre 5 (restriccion del modulo basico al tener solo terrenos de tierra) y no hayan alturas negativas.
                                        if (alturaActual>5 || alturaActual<0){
                                                //Lo que se hace es: si es que la altura final se excede de los valores se le resta dos veces el sumando obtenido, haciendo el efecto de negar la primera suma dejando 
                                                //el numero original para luego restarle el valor del sumando.
						alturaActual=alturaActual-2*sumando;
					}
					tableroConAlturas[i][j]=alturaActual; //Se asigna la altura en la posicion correspondiente.
				}
			}
                        //El siguiente "else if" funciona para todas las casillas de la primera columna sin contar la (0,0), toman en cuenta la altura de la casilla de arriba.
			else if (i==0){
				numeroAleatorio=(int)(rnd.nextDouble()*5);
				sumando=listaValoresSumar[numeroAleatorio];
				alturaPrevia=tableroConAlturas[i][j-1];
				alturaActual=alturaPrevia+sumando;
				if (alturaActual>5 || alturaActual<0){
					alturaActual=alturaActual-2*sumando;
				}
				tableroConAlturas[i][j]=alturaActual; //Se asigna la altura en la posicion correspondiente.
			}
                        //El siguiente "else" funciona para el resto de las casillas, toman en cuenta de forma aleatoria la altura de la casilla de arriba o la de la casilla de la izquierda.
			else{
				numeroAleatorio=(int)(rnd.nextDouble()*5);
				sumando=listaValoresSumar[numeroAleatorio];
				listaAlturasPrevias[0]=tableroConAlturas[i-1][j]; //Almacena el valor de altura de la casilla de la izquierda en la lista de alturas previas.
				listaAlturasPrevias[1]=tableroConAlturas[i][j-1]; //Almacena el valor de altura de la casilla superior en la lista de alturas previas.
				numeroAleatorio=(int)(rnd.nextDouble()*2); //Obtiene un valor aleatorio entre 0 y 1.
				alturaPrevia=listaAlturasPrevias[numeroAleatorio]; //Utiliza el valor anterior para tomar un valor de la lista de alturas previas en la posicion correspondiente.
				alturaActual=alturaPrevia+sumando;
				if (alturaActual>5 || alturaActual<0){
					alturaActual=alturaActual-2*sumando;
				}
				tableroConAlturas[i][j]=alturaActual; //Se asigna la altura en la posicion correspondiente.
				
			}
                    j++;
		}
	
	
            i++;
	}	
	return tableroConAlturas;	        
    }
    
}
