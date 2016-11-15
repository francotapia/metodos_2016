/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;

/**
 *
 * @author franco
 */
public class BaseDatos {
    
    static final String SERVIDOR = "localhost";
    static final String PUERTO = "1527";
    static final String NOMBRE_BD = "baseDatos";
    static final String USUARIO = "Grupo2";
    static final String PASSWORD = "metodos";
    static final String URL_BD = "jdbc:derby://" + SERVIDOR + ":" + PUERTO + "/" + NOMBRE_BD + ";user=" + USUARIO + ";password=" + PASSWORD;
    Connection bd = null;
    
    
}
