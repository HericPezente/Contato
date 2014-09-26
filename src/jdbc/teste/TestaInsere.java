/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc.teste;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import jdbc.dao.ContatoDao;
import jdbc.modelo.Contato;

/**
 *
 * @author MEUS DOCUMENTOS
 */
public class TestaInsere {
    public static void main(String[] args){
        
        Contato contato=new Contato();
        contato.setId(5L);
        contato.setNome("Willy Wonka");
        contato.setEmail("willy@oompalompa.com");
        contato.setEndereco("R. Wonka");
        DateFormat df=DateFormat.getDateInstance();
        
         Date data = null;
        try{
           data=df.parse("01/12/2014");
        }catch(ParseException e){
         e.printStackTrace();
         System.out.println("tetse");
        }
        
        
        
        Calendar c= Calendar.getInstance();
        c.setTime(data);
        contato.setDtNascimento(c);

        try{
        ContatoDao dao=new ContatoDao();
        dao.adiciona(contato);
        System.out.println("gravou!");
        }catch(RuntimeException e){
            
            e.printStackTrace();
            
        }
        

    }
}
