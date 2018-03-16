/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.bean;

import br.com.empresa.dao.EstadoDAO;
import br.com.empresa.entidade.Estado;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author leonix
 */
@ManagedBean
public class EstadoMB {
    
    private Estado estado;
    private List<Estado> lista;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getLista() {
        return lista;
    }

    public void setLista(List<Estado> lista) {
        this.lista = lista;
    }
    
    //Salva os dados passando os parâmetros obtidos na página
    public void salvar(){
        EstadoDAO dao = new EstadoDAO();
        dao.salvar(estado);
        
        inicializar();
    }
    
    //Reinicializa a lista
    @PostConstruct
    public void inicializar(){
        EstadoDAO dao = new EstadoDAO();
        
        lista = dao.listar();
        
        this.estado = new Estado();
    }
    
}
