/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author user
 */
public class CompeticionBean {
    
    int id_competicion;
    String nombreCompeticion, nombreRegion;
    int contadorApuestas;

    public CompeticionBean() {
        
        contadorApuestas=0;
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
    

    
}
