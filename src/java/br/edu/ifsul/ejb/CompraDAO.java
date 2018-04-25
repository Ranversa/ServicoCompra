/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.ejb;

import br.edu.ifsul.modelo.Compra;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ROBSON
 */
@Stateless
public class CompraDAO implements Serializable{
     private List<Compra> lista;
    @PersistenceContext(unitName = "ServicoCompraPU")
    private EntityManager em;

    public CompraDAO() {
    }
    
    public Compra inserir(Compra obj){
        obj.setId(null);
        em.persist(obj);
        return obj;
    }
    
    public Compra alterar(Compra obj){
        em.merge(obj);
        return obj;
    }
    
     public boolean remover(Integer id) {
        try {
            Compra obj = em.find(Compra.class, id);
            em.remove(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Compra> getLista() {
        return em.createQuery("from Compra").getResultList();
    }

    public void setLista(List<Compra> lista) {
        this.lista = lista;
    }
    
     
}
