/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author MEUS DOCUMENTOS
 */
public class TestaConnection {
    
    public static void main(String[] args) throws SQLException{
        
        Connection connection=null;
        try{
            connection= new ConnectionFactory().getConnection();
            System.out.println("Conexao aberta!");
        }catch(RuntimeException e){
            
            e.printStackTrace();
        }finally{
            connection.close();
        }
        
    }
    
}
