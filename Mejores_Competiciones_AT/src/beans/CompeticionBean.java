/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class CompeticionBean {
    
    int id_competicion;
    String nombreCompeticion, nombreRegion;
    int contadorApuestas;
    List<String> emails;
    
    List<UsuarioBean> usuarios;

    public CompeticionBean() {
        
        contadorApuestas=0;
        
        emails= new ArrayList<String>();
        
        usuarios=new ArrayList<UsuarioBean>();
        
    }

    public int getId_competicion() {
        return id_competicion;
    }

    public void setId_competicion(int id_competicion) {
        this.id_competicion = id_competicion;
    }

    public String getNombreCompeticion() {
        return nombreCompeticion;
    }

    public void setNombreCompeticion(String nombreCompeticion) {
        this.nombreCompeticion = nombreCompeticion;
    }

   
   
    public int getContadorApuestas() {
        return contadorApuestas;
    }

    public void setContadorApuestas(int contadorApuestas) {
        this.contadorApuestas = contadorApuestas;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<UsuarioBean> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioBean> usuarios) {
        this.usuarios = usuarios;
    }
    

    
}
