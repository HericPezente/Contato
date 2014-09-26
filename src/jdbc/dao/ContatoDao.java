/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import jdbc.modelo.Contato;

/**
 *
 * @author MEUS DOCUMENTOS
 */
public class ContatoDao {
    
    private Connection connection;
    
    public ContatoDao(){
        this.connection= new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Contato contato){
        String sql="insert into agenda.contatos(id,nome,email,endereco,dataNascimento) values(?,?,?,?,?)";
        try{
            PreparedStatement pstm=this.connection.prepareStatement(sql);
            pstm.setLong(1,getProximoId());
            pstm.setString(2,contato.getNome());
            pstm.setString(3,contato.getEmail());
            pstm.setString(4,contato.getEndereco());
            pstm.setDate(5,new Date(contato.getDtNascimento().getTimeInMillis()));
            pstm.execute();
            pstm.close();
            
        }catch(SQLException e){
            throw  new RuntimeException(e);
        }
        
    }
    
    public List<Contato> getLista(){
        String sql="select * from agenda.contatos";
        List<Contato> contatos= new ArrayList<Contato>();
        try{
        PreparedStatement pstm=this.connection.prepareStatement(sql);
        ResultSet rs=pstm.executeQuery();
        while(rs.next()){
            Contato contato=new Contato();
            contato.setId(rs.getLong("id"));
            contato.setNome(rs.getString("nome"));
            contato.setEmail(rs.getString("email"));
            contato.setEndereco(rs.getString("endereco"));
            Calendar data= Calendar.getInstance();
            data.setTime(rs.getDate("dataNascimento"));
            contato.setDtNascimento(data);
            contatos.add(contato);
        }
        rs.close();
        pstm.close();
        }catch(SQLException e){
            throw  new RuntimeException(e);
        }
        
        return contatos;
    }
    
    public void altera(Contato contato){
        try{
        String sql="update agenda.contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
        PreparedStatement pstm=this.connection.prepareStatement(sql);
        pstm.setString(1,contato.getNome());
        pstm.setString(2,contato.getEmail());
        pstm.setString(3,contato.getEndereco());
        pstm.setLong(4,contato.getId());
        pstm.setDate(5,new Date(contato.getDtNascimento().getTimeInMillis()));
        pstm.execute();
        pstm.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void remove(Contato contato){
        try{
        String sql="delete from agenda.contatos where id=?";
        PreparedStatement pstmt=this.connection.prepareStatement(sql);
        pstmt.setLong(1,contato.getId());
        pstmt.execute();
        pstmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public Long getProximoId(){
        String sql="select max(id) from agenda.contatos ";
        Long proximoId=null;
        try{;
           
        PreparedStatement pstm= this.connection.prepareStatement(sql);
        ResultSet rs=pstm.executeQuery();
        
        while(rs.next()){
             proximoId=rs.getLong(1)+1;
        }
        rs.close();
        pstm.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return proximoId;
     }
}
