/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActividadUsuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author franco
 */
public class ActividadUsuario {
    
    //metodo ActividadUsuario, que registra cada accion del usuario en un txt
 
    
    public static void actividadUsuario(String actividadUser){
        Date fecha = new Date(); //se crea objeto fecha
        DateFormat fechaTiempo = new SimpleDateFormat("yyyy/MM/dd :: HH:mm:ss ="); //Se se crea un objeto de la clase hija, a través de la clase padre, con parametros temporales.
        String actividad = fechaTiempo.format(fecha) + actividadUser; //Se obtiene el momento que el usuario realizó una acción y su accion.
        File ActividadUsuario = new File("log.txt");// Se crea un txt con la actividad del usuario
        
            try{
                if(ActividadUsuario.exists()==false){ //si no existe txt se crea.
                    System.out.println("Log creado");
                    ActividadUsuario.createNewFile(); //Se crea archivo.
                }
                FileWriter escribir = new FileWriter(ActividadUsuario, true); //Se crea objeto que permite acceder a fichero en modo escritura.
                PrintWriter archivo = new PrintWriter(escribir); //Se eescribe en fichero la actividad de usuario.
                archivo.append(actividad); //se agrega a archivo la actividad
                archivo.append(System.lineSeparator()); //se separa una linea, para la siguiente actividad.
                archivo.close();
                
            //en caso de no poder escribir 
            }catch(IOException e){
                System.out.println("No es posible escribir en el archivo");
            }
    }
}
