/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.dao;

import br.com.empresa.entidade.Estado;
import br.com.empresa.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author leonix
 */
public class EstadoDAO {
    
    public void salvar(Estado estado){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.persist(estado);
        
        sessao.getTransaction().commit();
        sessao.close();
    }
    
    public List<Estado> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Estado> lista = sessao.getNamedQuery("Estado.findAll").list();
        sessao.close();
        
        return lista;
    }
}
