/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;



import ec.edu.espe.arquitectura.dao.ClienteFacade;
import ec.edu.espe.arquitectura.dao.CuentaFacade;
import ec.edu.espe.arquitectura.model.Cliente;
import ec.edu.espe.arquitectura.model.Cuenta;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Jefferson
 */
@Stateless
@LocalBean
public class CuentaService {
    @EJB
    private CuentaFacade cuentaFacade;
    
    public List<Cuenta> obtenerTodos(){
        return this.cuentaFacade.findAll();
    }
    public List<Cuenta> obtenerPorCedulaCliente(String cedula) {
        return this.cuentaFacade.findByCedulaCliente(cedula);
    }
    
    public void crear(Cuenta cuenta){
        this.cuentaFacade.create(cuenta);
    }
    
    public void modificar(Cuenta cuenta){
        this.cuentaFacade.edit(cuenta);
    }
    
    public List<Cuenta> obtenerUltimaCuenta(){
        return this.cuentaFacade.findLastAccount();
    }
    
    public void eliminar(Integer codigo){
        Cuenta cuenta = this.cuentaFacade.find(codigo);
        if(cuenta!=null){
            this.cuentaFacade.remove(cuenta);
        }else{
            throw new RuntimeException("Cuenta no encontrada");
        }
    }
    
    public boolean validarUsuario (String cedula) throws MalformedURLException, ProtocolException, IOException{
        return this.cuentaFacade.obtenerUsuario(cedula);
    }
}
