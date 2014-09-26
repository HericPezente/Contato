/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MEUS DOCUMENTOS
 */
public class ConnectionFactory {
    
    /*public Connection getConnection(){
        try{
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Funcionario;create=true","admin","admin");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }*/
    
    public Connection getConnection(){
       try{
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           return DriverManager.getConnection("jdbc:derby://localhost:1527/contatos; create=true","admin","admin");
           
       }catch(SQLException e){
           throw  new RuntimeException(e);
       }catch(ClassNotFoundException ex){
           throw new RuntimeException(ex);
       }
    }
    
}
