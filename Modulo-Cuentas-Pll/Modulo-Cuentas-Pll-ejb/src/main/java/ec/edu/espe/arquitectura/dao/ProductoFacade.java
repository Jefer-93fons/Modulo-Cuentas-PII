/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jefferson
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_Modulo-Cuentas-Pll-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
    public List<Producto> findByCodigo(Integer codigo) {
        Query qry = this.em.createQuery("SELECT obj FROM Producto obj WHERE obj.idProducto=?1");
        qry.setParameter(1, codigo);
        return qry.getResultList();
    }
    
     public List<Producto> findByTipo(Integer tipo){
        Query qry=this.em.createQuery("SELECT obj FROM Producto obj WHERE obj.idTipoProducto.idTipoProducto=?1");
        qry.setParameter(1, tipo);
        return qry.getResultList();
    } 
    
}
