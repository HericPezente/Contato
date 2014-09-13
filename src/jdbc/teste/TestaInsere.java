/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc.teste;

import jdbc.dao.ContatoDao;
import jdbc.modelo.Contato;

/**
 *
 * @author MEUS DOCUMENTOS
 */
public class TestaInsere {
    public static void main(String[] args){
        Contato contato=new Contato();
        contato.setId(4L);
        contato.setNome("Willy Wonka");
        contato.setEmail("willy@oompalompa.com");
        contato.setEndereco("R. Wonka");

        try{
        ContatoDao dao=new ContatoDao();
        dao.adiciona(contato);
        System.out.println("gravou!");
        }catch(RuntimeException e){
            
            e.printStackTrace();
            
        }
        

    }
}
