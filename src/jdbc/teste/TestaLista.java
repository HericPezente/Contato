/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc.teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.dao.ContatoDao;
import jdbc.modelo.Contato;

/**
 *
 * @author MEUS DOCUMENTOS
 */
public class TestaLista {
    
    public static void main(String[] args){
        try{
            ContatoDao dao=new ContatoDao();
            List<Contato> contatos=new ArrayList<>();
            contatos= dao.getLista();
            for(Contato c:contatos){
                System.out.println("Id:"+c.getId()+" Nome:"+c.getNome()+" Endereço:"+c.getEndereco());
            }
        }catch(RuntimeException e){
            e.printStackTrace();
        };
    }
    
}
