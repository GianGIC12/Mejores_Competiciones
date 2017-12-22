/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import beans.CompeticionBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Consultas {

    String sql;

    CompeticionBean[] competiciones;
    int contCompeticiones;

    public Consultas() {

        competiciones = new CompeticionBean[28000];

        contCompeticiones = 0;
    }

    public void completarIDCompeticiones() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        for (int i = 0; i < 28000; i++) {

            if (competiciones[i] != null) {

                sql = "select competition_id,name,region_name from db_apuestatotal_prod.betconstruct_competition where competition_id= " + competiciones[i].getId_competicion();

                PreparedStatement stm = objCon.getCon().prepareStatement(sql);
                ResultSet rs = stm.executeQuery();

                while (rs.next()) {

                    CompeticionBean compet = new CompeticionBean();

                    int id_competicion = rs.getInt("competition_id");
                    String nombre_competicion = rs.getString("name");
                    String nombre_region = rs.getString("region_name");
                    
                    
                    
                    competiciones[i].setNombreCompeticion(nombre_competicion);
                    competiciones[i].setNombreRegion(nombre_region);

                    

                }

            }

        }

        objCon.desconectar();

    }

    public void completarCompeticiones() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        int cont1, cont2, cont3, cont4, cont5;

        cont1 = 0;
        cont2 = 0;
        cont3 = 0;
        cont4 = 0;
        cont5 = 0;

        sql = "select id,events from db_apuestatotal_prod.user_bet where created_at>='2017-08-15' order by id" + " limit 200000";

        PreparedStatement stm = objCon.getCon().prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        cont4 = 0;

        while (rs.next()) {

            if (rs.getString("events") == null) {

                System.out.println("No se encontro evento");

                cont1++;

            } else if (rs.getString("events").equalsIgnoreCase("{}")) {

                System.out.println("Events JSON vacios");

                cont2++;
            } else if (rs.getString("events").equalsIgnoreCase("")) {

                System.out.println("Events  vacios");

                cont3++;

            } else {

                String evento = "";
                evento = rs.getString("events");

                int id = rs.getInt("id");

                String buscar = "selection";
                boolean resultado = evento.contains(buscar);

                if (resultado) {

                    System.out.println("Encontrado *****" + evento);
                    cont5++;

                } else {

                    int inicio = evento.indexOf(",");
                    int fin = evento.indexOf(",", inicio + 1);
                    evento = evento.substring(inicio + 1, fin);
                    evento = evento.substring(17);
                    int longitud = evento.length();

                    evento = evento.substring(1, longitud - 1);

                    int id_comp = Integer.parseInt(evento);

                    CompeticionBean compet = new CompeticionBean();
                    compet.setId_competicion(id_comp);

                    int cont;
                    if (competiciones[id_comp] == null) {

                        cont = compet.getContadorApuestas();

                    } else {

                        cont = competiciones[id_comp].getContadorApuestas();

                    }

                    cont++;

                    compet.setContadorApuestas(cont);

                    competiciones[id_comp] = compet;

                    cont4++;

                }

            }

        }

        System.out.println("nulos: " + cont1);
        System.out.println("JSON vacios: " + cont2);
        System.out.println(" vacios: " + cont3);
        System.out.println("selection_id: " + cont5);
        System.out.println("validos:**************" + cont4);

        objCon.desconectar();

    }

    public void recorrerCompeticiones() {

        for (int i = 0; i < 28000; i++) {

            if (competiciones[i] != null) {

                System.out.println("id_competicion: " + competiciones[i].getId_competicion()
                               +" Nombre competicion: "+competiciones[i].getNombreCompeticion()
                               + " Nombre Region: "+competiciones[i].getNombreRegion()
                        + " Cantidad de Apuestas: " + competiciones[i].getContadorApuestas()
                );

            }

        }

    }

}
