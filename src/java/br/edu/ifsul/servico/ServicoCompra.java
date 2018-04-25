/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.servico;

import br.edu.ifsul.ejb.CompraDAO;
import br.edu.ifsul.modelo.Compra;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author ROBSON
 */
@WebService
public class ServicoCompra {
    @EJB
    private CompraDAO dao;

    public ServicoCompra() {
    }
    
    @WebMethod
    public List<Compra> listaCompras(){
        return dao.getLista();
    }
    
    @WebMethod
    public Compra inserir(@WebParam (name = "compra")
            @XmlElement(required = true) Compra obj){
        return dao.inserir(obj);
    }
    
    @WebMethod
    public Compra alterar(@WebParam (name = "compra")
            @XmlElement(required = true) Compra obj){
        return dao.alterar(obj);
    }
    
    @WebMethod
    public boolean remover(@WebParam (name = "id")
            @XmlElement(required = true) Integer id){
        return dao.remover(id);
    }
}
