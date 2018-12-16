/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.FechaTrabajoFacade;
import ec.edu.espe.arquitectura.model.FechaTrabajo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author DAVID
 */
@Stateless
@LocalBean
public class FechaTrabajoService {
    
    @EJB
    private FechaTrabajoFacade fechaTrabajoFacade;
    
    public List<FechaTrabajo> obtenerTodos(){
        return this.fechaTrabajoFacade.findAll();
    }
     public FechaTrabajo obtenerActual(){
         List<FechaTrabajo>fechaTrabajos=this.fechaTrabajoFacade.findAll();
         FechaTrabajo fechaTrabajo=fechaTrabajos.get(0);
        return fechaTrabajo;
    }
    
    public void crear(FechaTrabajo fechaTrabajo){
        this.fechaTrabajoFacade.create(fechaTrabajo);
    }
    
    public void modificar(FechaTrabajo fechaTrabajo){
        this.fechaTrabajoFacade.edit(fechaTrabajo);
    }
    

}
