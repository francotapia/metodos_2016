/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author franco
 */
public class BaseDatos {
    
    static final String SERVIDOR = "localhost";
    static final String PUERTO = "1527";
    static final String NOMBRE_BD = "metodo";
    static final String USUARIO = "metodo";
    static final String PASSWORD = "metodo";
    static final String URL_BD = "jdbc:derby://" + SERVIDOR + ":" + PUERTO + "/" + NOMBRE_BD + ";user=" + USUARIO + ";password=" + PASSWORD;
    Connection bd = null;
    
    public boolean conectar() throws SQLException {
        this.bd = DriverManager.getConnection(URL_BD);
        if(this.bd != null){
            System.out.println("Se ha conectado a la base de datos");
            return true;
        }
        else{
            return false;
        }
    }
    public void desconectar() throws SQLException{
        if(this.bd != null){
            this.bd.close();
        }
    }
    public Statement crearConsulta() throws SQLException{
        if(this.bd != null){
            Statement stmt = bd.createStatement();
            System.out.println("Se ha creado la consulta");
            return stmt;
        }
        else{
            return null;
        }
    }
        
    
}
