/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/***********************************************************************
 * Module:  Batalla.java
 * Author:  franco
 * Purpose: Defines the Class Batalla
 ***********************************************************************/

import java.util.*;

/** @pdOid f9b0b4a4-39d7-4807-8436-508c8faaab7f */
public class Batalla {

   
    
    private Escenario escenario;
    private int numeroPersonajesJugador;
    private Personaje personaje;
    private ArrayList<Personaje> equipoUsuario = new ArrayList<>();
    private Cpu cpu;
    private ArrayList<Personaje> equipoCPU = new ArrayList<>();
    private ArrayList<String> personajesVivosJugador;
    private Personaje[] personajesInicial;
    private int rango;
    private ArrayList<String> secuenciaCPU;
    private ArrayList<String> secuenciaAtaques;
    private ArrayList<Personaje> listaTotal;
    private ArrayList<Personaje> listaOrdenada;
    
     public Batalla(ArrayList<Personaje> equipoUsuario){
        cpu = new Cpu();
        escenario = new Escenario();
        this.equipoUsuario = equipoUsuario;
        solicitarPersonajesCPU();
        listaOrdenada = new ArrayList<>();
        listaTotal = new ArrayList<>();
    
 
////       

   }

    public Batalla() {
        
    }
     
    public ArrayList<Personaje> getEquipoCPU() {
        return equipoCPU;
    }
    public ArrayList<Personaje> getEquipoUsuario() {
        return equipoUsuario;
    }
   public ArrayList<String> getPersonajesVivosJugador() {
        return personajesVivosJugador;
    }

    public ArrayList<String> getSecuenciaAtaques() {
        return secuenciaAtaques;
    }
   
    
    public Escenario getEscenario() {
        return escenario;
    }
    
    public boolean pasarTurno(int turnos){
        for (int i = 0; i < listaOrdenada.size(); i++) {
            if(turnos < listaOrdenada.size()){
                return true;
            }
        }
        return false;
    }
    
    public boolean solicitarPersonajesCPU(){
        int contador = 0;
        for (int i = 0; i < cpu.getEquipo().size(); i++) {
            if(contador < 8){
                equipoCPU.add(cpu.getEquipo().get(i));
                        contador++;
                        
            }
        }
        return true;
    }
    
     public ArrayList<Personaje> getListaOrdenada() {
        return listaOrdenada;
    }
     
    public boolean solicitarPersonajesBatalla(ArrayList<Personaje> equipoUsuario, ArrayList<Personaje> listaPersonajesSeleccionados, Personaje personajeSeleccionado){
	ArrayList<Personaje> listaEquipoUsuario = new ArrayList<>();
	int i = 0;
	while (i<equipoUsuario.size()) {
		listaEquipoUsuario.add(equipoUsuario.get(i));
		i++;
	}
	i=0;
	int j;
	while (i<listaPersonajesSeleccionados.size()) {
		j=0;
		while (j<listaEquipoUsuario.size()){
			if (listaPersonajesSeleccionados.get(i).equals(listaEquipoUsuario.get(j)) || personajeSeleccionado.equals(listaEquipoUsuario.get(j))) {
				listaEquipoUsuario.remove(j);
			}
			j++;
		}
		i++;
	}
        //Hasta aca solo se actualiza la lista para tener los vigentes.^^^^
	listaPersonajesSeleccionados.add(personajeSeleccionado);
	this.equipoUsuario=listaPersonajesSeleccionados;
	return true;
	//Maximo seis personajes, esto lo regulara el controlador.
    }
    
    public boolean quitarPersonajesBatalla(ArrayList<Personaje> equipoUsuario, ArrayList<Personaje> listaPersonajesSeleccionados, Personaje personajeSeleccionado){
        ArrayList<Personaje> listaEquipoUsuario = new ArrayList<>();
        for(Personaje p : equipoUsuario){
            listaEquipoUsuario.add(p);
        }
        listaEquipoUsuario.add(personajeSeleccionado);
        this.equipoUsuario=listaEquipoUsuario;
        return true;
    }
   

  
   
  
   
   public int calcularAtaquesVisibles(Personaje primerPersonaje, Personaje segundoPersonaje){
	int nivelPrimerPersonaje = primerPersonaje.getNivel();
	int nivelSegundoPersonaje = segundoPersonaje.getNivel();
	int diferencia = nivelPrimerPersonaje-nivelSegundoPersonaje;
	int ataquesVisibles=0;
	
	if (diferencia==-9 || diferencia==-8 || diferencia==-7 || diferencia==-6 || diferencia==-5) {
		ataquesVisibles=0;
	}
	else if (diferencia==-4 || diferencia==-3 || diferencia==-2 ) {
		ataquesVisibles=1;
	}
	else if (diferencia==-1 || diferencia==0 || diferencia==1) {
		ataquesVisibles=2;		
	}
	else if (diferencia==2 || diferencia==3) {
		ataquesVisibles=3;
	}
	else if (diferencia==4 || diferencia==5) {
		ataquesVisibles=4;
	}
	else if (diferencia==6 || diferencia==7) {
		ataquesVisibles=5;
	}
	else if (diferencia==8 || diferencia==9) {
		ataquesVisibles=6;
	}
	
	return ataquesVisibles;
}
   
   
    public ArrayList<Integer> modificarVida(Personaje personaje, Personaje personajeEnemigo , int[]ataquesEfectivos){
            int daño = personajeEnemigo.getPuntosAtaqueCortos();
            int vidaRestante = personaje.getPuntosVida();
            String tipo= personaje.getClase();
            int defensa=personaje.getPuntoDefensa();
            int dañoRealizado=0;
            ArrayList<Integer> ArregloDeDaños = new ArrayList<>();
            //siempre el largo de ataques efectivos sera 7, ejemplo [0,1,0,0,0,1,1]
            for (int i = 0; i <7; i++) {
                    if (ataquesEfectivos[i]==1){
                            if ("guerrero".equals(tipo)){
                                    dañoRealizado=(int) (daño/4-defensa);
                                    if (dañoRealizado<0){
                                        dañoRealizado=0;
                                    }
                            ArregloDeDaños.add((int)dañoRealizado);
                            vidaRestante=vidaRestante-dañoRealizado;
                            }
                            if ("ninja".equals(tipo)){
                                    dañoRealizado=(int) (daño/3-defensa);
                                    if (dañoRealizado<0){
                                            dañoRealizado=0;
                                    }
                                    ArregloDeDaños.add((int)dañoRealizado);
                                    vidaRestante=vidaRestante-dañoRealizado;
                            }
                            if ("arquero".equals(tipo)){
                                    dañoRealizado=(int) (daño/2-defensa);
                                    if (dañoRealizado<0){
                                            dañoRealizado=0;
                                    }
                                    ArregloDeDaños.add((int)dañoRealizado);
                                    vidaRestante=vidaRestante-dañoRealizado;
                            }
                            if ("mago".equals(tipo)){
                                    dañoRealizado=(int) (daño-defensa);
                                    if (dañoRealizado<0){
                                            dañoRealizado=0;
                                    }
                                    ArregloDeDaños.add((int)dañoRealizado);
                                    vidaRestante=vidaRestante-dañoRealizado;
                            }
                    }
                    else {
                            ArregloDeDaños.add((int)0);  //si el personaje gano el capichun... (no se le hace daño)
                            dañoRealizado=0;
                    }

            }
            if(vidaRestante<0){vidaRestante=0;}  
            ArregloDeDaños.add(vidaRestante);
            return ArregloDeDaños;
    }
    
    public ArrayList<Integer> modificarVidaCPU(Personaje personajeCPU, Personaje personajeJugador, int[]ataquesEfectivos){
            int daño = personajeJugador.getPuntosAtaqueCortos();
            int vidaRestante = personajeCPU.getPuntosVida();
            String tipo= personajeCPU.getClase();
            int defensa=personajeCPU.getPuntoDefensa();
            int dañoRealizado=0;
            ArrayList<Integer> ArregloDeDaños = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                if (ataquesEfectivos[i]==0){ // si el ataque del usuario gano, entonces
                    if ("guerrero".equals(tipo)){
                        dañoRealizado=(int) (daño/4-defensa);
                        if (dañoRealizado<0){ // si es que el daño realizado es menor que 0..
                                dañoRealizado=0; // entonces es 0
                        }
                        ArregloDeDaños.add((int)dañoRealizado);
                        vidaRestante=vidaRestante-dañoRealizado;
                    }
                    if ("ninja".equals(tipo)){
                        dañoRealizado=(int) (daño/3-defensa);
                        if (dañoRealizado<0){
                                dañoRealizado=0;
                        }
                        ArregloDeDaños.add((int)dañoRealizado);
                        vidaRestante=vidaRestante-dañoRealizado;
                    }
                    if ("arquero".equals(tipo)){
                        dañoRealizado=(int) (daño/2-defensa);
                        if (dañoRealizado<0){
                                dañoRealizado=0;
                        }
                        ArregloDeDaños.add((int)dañoRealizado);
                        vidaRestante=vidaRestante-dañoRealizado;
                    }
                    if ("mago".equals(tipo)){
                        dañoRealizado=(int) (daño-defensa);
                        if (dañoRealizado<0){
                                dañoRealizado=0;
                        }
                        ArregloDeDaños.add((int)dañoRealizado);
                        vidaRestante=vidaRestante-dañoRealizado;
                    }
                }
                else {
                        ArregloDeDaños.add((int)0);  //si el personaje gano el capichun... (no se le hace daño)
                        dañoRealizado=0;
                }
            }
            //si es que la vida es menor que cero
            if (vidaRestante<0){
                    vidaRestante=0;
            } //entonces es 0
            ArregloDeDaños.add(vidaRestante);
            return ArregloDeDaños;
    }
    
    public String obtenerDañosDeListaModificaciones(ArrayList<Integer> lista){
        int i = 0;
        String mensaje = "";
        while (i<7){
            if(i==6){
                mensaje=mensaje+String.valueOf(lista.get(i))+".";
            }
            else{
                mensaje=mensaje+String.valueOf(lista.get(i))+", ";
            }
            i++;
        }
        return mensaje;
    }
    
    public String obtenerStringVidaFinalListaModificaciones(ArrayList<Integer> lista){
        String mensaje=String.valueOf(lista.get(7));
        return mensaje;
    }
    
    
   //
   public boolean aplicarDaño(int daño, int vida){
       int nuevaVida=vida-daño;
       if(nuevaVida<0){
       nuevaVida=0;
       }
       return true;
   }

   public Boolean equiparObjeto(Objeto objeto) {

      return null;
   }
   

   public Boolean quitarObjeto(String objetoEquipado) {

      return null;
   }
   
   /** @param ataqueAtacante 
    * @param defensaDefensor 
    * @param vidaDefensor
 */
   public int calcularDanoRecibido(int ataqueAtacante, int defensaDefensor, int vidaDefensor) {
 
      return 0;
   }
   
   /** @param personajeObjetivo
  */
   public Boolean seleccionarObjetivoAtaque(String personajeObjetivo) {
      // TODO: implement
      return null;
   }
   
   /** @param traicionActual 
    * @param tipo
 */
   public Boolean verificarTraicion(int traicionActual, Tipo tipo) {
      // TODO: implement
      return null;
   }
   
   /** @param dano
*/
   public Boolean generarDano(int dano) {
      // TODO: implement
      return null;
   }



   public int[] compararSecuenciaAtaques(ArrayList<String> primeraSecuencia, ArrayList<String> segundaSecuencia) {
	//0 gana usuario, 1 gana CPU, 2 empate.
        this.secuenciaAtaques = primeraSecuencia;
	int i;
	String ataqueJugador;
	String ataqueCPU;
	int[] listaComparaciones = new int[7];
	
	i=0;
	while (i<7){
		ataqueJugador=primeraSecuencia.get(i);
		ataqueCPU=segundaSecuencia.get(i);
		
		if (ataqueCPU.equals(ataqueJugador)) {
			listaComparaciones[i]=2;
		}
		else if (ataqueCPU.equals("especial")) {
			listaComparaciones[i]=1;
		}
		else if (ataqueJugador.equals("especial")) {
			listaComparaciones[i]=0;
		}
		else if (ataqueJugador.equals("alto")) {
			if (ataqueCPU.equals("medio")) {
				listaComparaciones[i]=0;
			}
			else if (ataqueCPU.equals("bajo")) {
				listaComparaciones[i]=1;
			}
		}
		else if (ataqueJugador.equals("medio")) {
			if (ataqueCPU.equals("alto")) {
				listaComparaciones[i]=1;
			}
			else if (ataqueCPU.equals("bajo")) {
				listaComparaciones[i]=0;
			}
		}
		else if (ataqueJugador.equals("bajo")) {
			if (ataqueCPU.equals("alto")) {
				listaComparaciones[i]=0;
			}
			else if (ataqueCPU.equals("medio")) {
				listaComparaciones[i]=1;
			}
		}
		
		i++;
	}
	
	return listaComparaciones;
}
   
   
    public boolean casillaDesocupada(int i, int j){
        if(escenario.getMatrizCoordenada()[i][j].getPersonaje() != null){
            if(escenario.getMatrizCoordenada()[i][j].getPersonaje().getDueñoPersonaje() == "cpu")
                return true;
        }
        return false;
    }
    
    /*Calcula la distancia entre dos coordenadas especificas.[Esta distancia es especificamente para el ataque 
    ya que no forma un "circulo" alrededor de el personaje sino que funciona como un cuadrado */
    public boolean calcularDistanciaAtaque(int i, int j, int x, int y){
        int fila = Math.abs(i - x);
        int columna = Math.abs(j - y);
        if (fila >= 5 && fila <= 8 && columna  == 0){ 
            return true;
        }
        else if(columna >= 5 && columna <= 8 && fila  == 0){

            return true;
        }
        else if(fila >=2  && columna >= 2 && fila>= 4 && columna >= 4){
            return true;
        }
        return false;
    }

    public int obtenerRango() {
        return rango;
    }
    
    //velocidad
    
    public boolean agregarListasVelocidades(){
        crearListaVelocidades(equipoUsuario,equipoCPU);
        return true;
    }
    public boolean crearListaVelocidades(ArrayList<Personaje> equipoUsuario, ArrayList<Personaje> equipoCPU){
	listaTotal.addAll(equipoUsuario);
	listaTotal.addAll(equipoCPU);
	int i;
	int velocidadMayor;
	while(listaTotal.size()!=0){
		i=0;
		velocidadMayor=0;
		for(Personaje personaje : listaTotal){
			if(personaje.getVelocidad()>velocidadMayor){
				velocidadMayor=personaje.getVelocidad();
				break;
			}
		}
		for(Personaje personaje : listaTotal){
			if(personaje.getVelocidad()==velocidadMayor){
				listaOrdenada.add(personaje);
			}
			else{
				i++;
			}
		}
		listaTotal.remove(i);
	}
	return true;
}
    
   
    public boolean atacarOponente(int i, int j, int x,int y){
        //si la defensa del oponente es menor al ataque del atacante
        if(escenario.getMatrizCoordenada()[x][y].getPersonaje().getPuntosAtaqueLargo() >  escenario.getMatrizCoordenada()[i][j].getPersonaje().getPuntoDefensa()){
           int vida = escenario.getMatrizCoordenada()[i][j].getPersonaje().getPuntosVida() - 10; //se descuenta vida al oponente
           escenario.getMatrizCoordenada()[i][j].getPersonaje().setPuntosVida(vida);
           return true;
        }
        //si la defensa del oponente es mayor al ataque del atacante
        if(escenario.getMatrizCoordenada()[x][y].getPersonaje().getPuntosAtaqueLargo() <  escenario.getMatrizCoordenada()[i][j].getPersonaje().getPuntoDefensa()){
           int vida = escenario.getMatrizCoordenada()[x][y].getPersonaje().getPuntosVida() - 10; // se descuenta vida al atacante
           escenario.getMatrizCoordenada()[x][y].getPersonaje().setPuntosVida(vida);
           return true;
        }
        return false;
    }

      /*public int primerTurno (Personaje ListaVelocidadUsuario,Personaje ListaVelocidadCpu){
         inicioBatalla = false;
       int usuario = 0;
       public int maquina = 1; 
       int asignacionTurno =0 ; 
       if(inicioBatalla==true){
        double maximoUsuario = 0;
        double maximoCPU = 0;
            for(i=0;i<this.velocidadUsuario.size(); i++ ) {//suponiendo que hay una lista velocidad para el usuario y para la cpu
               if(velocidadUsuario.get(i)>maximoUsuario){
                   maximoUsuario= velocidad.get(i);
               } 
            }
            for(j=0; j<this.velocidadCpu.size();j++){
                if(velocidadCpu.get(j)> maximoCPU){
                    maximoCPU= velocidadCpu.get(i);
                }
            }
            
        if( maximoCPU > maximoUsuario){
          asignacionTurno= asignacionTurno+1;
         }
       if (maximoCPU < maximoUsuario){
           asignacionTurno=asignacionTurno;
       }   
      }
      return asignacionTurno;
}
// lo que hace la funcion es analizar la lista de velocidades entre la cpu y el usuario, los compara y a por medio de un auxiliar
//"asignacionTurno" si asignacionTurno=1 comienza la cpu a en el primer turno y si asignacionTurno=0 comienza el usuario 
   
   
   /** @param puntoInicio */
   public int calcularDistanciaAtaque(int puntoInicio) {
      // TODO: implement
      return 0;
   }
   
   /** @param puntoInicio
    * @pdOid 0613186e-b15c-4af6-a729-63b399f29d57 */
   public int calcularDistanciaMovimiento(int puntoInicio) {
      // TODO: implement
      return 0;
   }
   
   /** @param bool
    * @pdOid dc7c8334-66a0-4b28-b44a-d847c17a2321 */
   public Boolean sumarTraicion(java.lang.Boolean bool) {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 1adbfd9c-b921-4515-abae-25febb2c2294 */
   public Boolean asignarTurnos() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 72bf33a0-fdb6-4299-95f5-6a46ad5414a7 */
   public Boolean alternarTurnos() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 6447d48a-51ae-4200-8a99-39390283bda3 */
   public Personaje crearListaPersonajesVivos() {
      // TODO: implement
      return null;
   }
   
   /** @param listaPersonajes
    * @pdOid 865fdf33-3746-40e5-93ca-603ef2e80b1c */
   public Personaje modificarListaPersonajesVivos(Personaje listaPersonajes) {
      // TODO: implement
      return null;
   }
   
   /** @param listaPersonajeVivo
    * @pdOid eefe6fd7-44c0-4b3b-a222-6fd629e94eb5 */
   public Boolean determinarGanador(Personaje listaPersonajeVivo) {
      // TODO: implement
      return null;
   }
   
   /** @param personaje
    * @pdOid 2d193403-5c84-484a-af36-1f4df2602ed5 */
   public int solicitarMovimientos(Personaje personaje) {
      // TODO: implement
      return 0;
   }
   
   /** @param personaje
    * @pdOid f3a852ef-a9d7-40d8-a867-502c17a524c7 */
   public int solicitarNivel(Personaje personaje) {
      // TODO: implement
      return 0;
   }
   
   /** @param movmoentoMaquina 
    * @param nivelMaquina 
    * @param nivelUsuario
  */
   public Boolean generarAtaquesVisibles(int movmoentoMaquina, int nivelMaquina, int nivelUsuario) {
      // TODO: implement
      return null;
   }
   
   /** @param personaje 
    * @param ataque
    * @pdOid c92e09b0-36f8-4fb3-a9f8-a11dba0cba30 */
   public Boolean atacar(Personaje personaje, int ataque) {
      // TODO: implement
      return null;
   }
   
   public void ataqueCortoRango(Personaje primerPersonaje, Personaje segundoPersonaje){
        //Cada ataque ganado le quita vida al oponente.
        //Cada rol de personaje quita cierto porcentaje pero el nivel y los objetos no alteran los valores.
        int primeraBarraVida;
        int segundaBarraVida;
       
        /*
        solicitarSecuenciaAtaques(Personaje); Esta retorna una arraylist con los ataques. 
        calcularSecuenciaAtaquesCPU(Personaje); Esta retorna una arraylist con los ataques.
       
        calcularAtaquesVisibles();
        compararSecuanciaAtaques(ArrayList, ArrayList) //Va a tener un ciclo dentro que recorra ambas listas de secuencias. 
        //Este metodo tiene una lista de booleanos y por cada comparacion agrega un valor a la lista, devuelve esa lista y 
        //y luego la vista los muestra de a uno. 
        
        modificarVida(Personaje (rol)); k= guerrero 4, arquero 3, ninja 2, mago 1. Cada ataque quita k*x%. 
        Devuelve una lista con ints.
        
        recibirDañoTotal(daño de la vista)
        
       
       
      
        
        */     } 
   
   
	public boolean solicitarSecuenciaAtaques (Personaje personaje, ArrayList<String> secuenciaAtaques, String ataqueEntrada){
		//Cambie los tipos de datos de los stock de ataques 
//                this.secuenciaAtaques = secuenciaAtaques;
		int stockAlto=personaje.getStockAtaqueAlto();
		int stockMedio=personaje.getStockAtaqueMedio();
		int stockBajo=personaje.getStockAtaqueBajo();
		int stockEspecial=personaje.getStockAtaqueEspecial();
		int i = 0;
		
		//Se "actualizan" los stocks de acuerdo a los ataques anteriormente seleccionados.
		while (i<secuenciaAtaques.size()) {
			if ("alto".equals(secuenciaAtaques.get(i))) {
				stockAlto=stockAlto-1;
                                i++;
			}
			else if ("medio".equals(secuenciaAtaques.get(i))) {
				stockMedio=stockMedio-1;
                                i++;
			}
			else if ("bajo".equals(secuenciaAtaques.get(i))) {
				stockBajo=stockBajo-1;
                                i++;
			}
			else if ("especial".equals(secuenciaAtaques.get(i))) {
				stockEspecial=stockEspecial-1;
                                i++;
			}
		}
		
		
		if ("alto".equals(ataqueEntrada)) {
			if (stockAlto>0) {
                            secuenciaAtaques.add("alto");
                            stockAlto=stockAlto-1;
                            this.secuenciaAtaques = secuenciaAtaques;
                            System.out.println("La secuencia de ataques actual es:"+secuenciaAtaques);
                            return true;
			}
			else{
                            System.out.println("No hay suficiente ataque alto");
                            return false;
			}
		}
		else if ("medio".equals(ataqueEntrada)) {
			if (stockMedio>0) {
                            secuenciaAtaques.add("medio");
                            stockMedio=stockMedio-1;
                            this.secuenciaAtaques = secuenciaAtaques;
                            System.out.println("La secuencia de ataques actual es:"+secuenciaAtaques);
                            return true;
                                
			}
			else {
                            System.out.println("No hay suficiente ataque medio");
                            return false;
			}
		}
		else if ("bajo".equals(ataqueEntrada)) {
			if (stockBajo>0) {
                            secuenciaAtaques.add("bajo");
                            stockBajo=stockBajo-1;
                            this.secuenciaAtaques = secuenciaAtaques;
                            System.out.println("La secuencia de ataques actual es:"+secuenciaAtaques);
                            return true;
			}
			else {
                            System.out.println("No hay suficiente ataque bajo");
                            return false;
			}
		}
		else if ("especial".equals(ataqueEntrada)) {
			if (stockEspecial>0){
                            secuenciaAtaques.add("especial");
                            stockBajo=stockBajo-1;
                            this.secuenciaAtaques = secuenciaAtaques;
                            System.out.println("La secuencia de ataques actual es:"+secuenciaAtaques);
                            return true;
			}
			else {
                            System.out.println("No hay suficiente ataque especial");
                            return false;
			}
		}
                else {
                    System.out.println("Ultimo else");
                    return false;
                }
                
        }


        
        public String obtenerListaAtaquesString(){
            ArrayList<String> lista = this.getSecuenciaAtaques();
            int i = 0;
            String listaString="";
            while (i<lista.size()){
                if(i==lista.size()-1){
                    listaString=listaString+lista.get(i)+".";
                }
                else{
                    listaString=listaString+(lista.get(i))+", ";
                }
                i++;
                        
            }
            return listaString;
        }   

    public ArrayList<String> solicitarSecuenciaAtaquesCPU(Personaje personaje){
		int stockAlto=personaje.getStockAtaqueAlto();
		int stockMedio=personaje.getStockAtaqueMedio();
		int stockBajo=personaje.getStockAtaqueBajo();
		int stockEspecial=personaje.getStockAtaqueEspecial();
		ArrayList<String> secuenciaAtaque = new ArrayList<>();
		Random rnd = new Random();
		int numeroAleatorio;
		
		while (secuenciaAtaque.size()<7){
			numeroAleatorio=(int)(rnd.nextDouble()*4); //Obtiene un numero int aleatorio entre [0,4[.
			if (numeroAleatorio==0 && stockEspecial>0) {
				secuenciaAtaque.add("especial");
				stockEspecial=stockEspecial-1;
			}
			else if (numeroAleatorio==1 && stockAlto>0) {
				secuenciaAtaque.add("alto");
				stockAlto=stockAlto-1;
			}
			else if (numeroAleatorio==2){
				secuenciaAtaque.add("medio");
				stockMedio=stockMedio-1;
			}
			else if (numeroAleatorio==3){
				secuenciaAtaque.add("bajo");
				stockBajo=stockBajo-1;
			}
		}
		
		return secuenciaAtaque;	
}

    public String obtenerListaAtaquesStringCPU(ArrayList<String> secuenciaCPU, int j) {
        String lista="";
        int i = 0;
            while (i<secuenciaCPU.size()){
                if (i<j) {
                    if(i==secuenciaCPU.size()-1){
                        lista=lista+secuenciaCPU.get(i)+".";
                    }
                    else{
                        lista=lista+(secuenciaCPU.get(i))+", ";
                    }
                }
                else{
                    if (i+1==secuenciaCPU.size()) {
                        lista=lista+"OCULTO"+".";
                    }
                    else{
                        lista=lista+"OCULTO"+", ";
                    }
                }
                i++;
                        
            }
            return lista;
    }

    public ArrayList<String> getSecuenciaCPU() {
        return secuenciaCPU;
    }

    public void setSecuenciaCPU(ArrayList<String> secuenciaCPU) {
        this.secuenciaCPU = secuenciaCPU;
    }
   
    
    
    
   }
   
   
   


