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
public class TestaRemove {
    
    public static void main(String[] args){
    Contato contato=new Contato();
    contato.setId(4L);
    
        ContatoDao dao=new ContatoDao();
        dao.remove(contato);
    }
    
    
}
