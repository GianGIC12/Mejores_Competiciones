/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import beans.CompeticionBean;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author user
 */
public class ExportarCSV {

    public ExportarCSV() {
    }
    
    
  public void exportarResultados(CompeticionBean[] competiciones) throws IOException {
    
  String outputFile = "C:/Users/user/Google Drive/Reporting_TB/mejores_competiciones.csv";
  
  boolean alreadyExists = new File(outputFile).exists();
  
   if (alreadyExists) {
            File bd_mejores_competiciones = new File(outputFile);
            bd_mejores_competiciones.delete();
        }
  
   CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');
  
   
   csvOutput.write("id_competicion");
        csvOutput.write("nombre_competicion");
        csvOutput.write("region_competicion");
        csvOutput.write("contador_apuestas");
        
   
   csvOutput.endRecord();
   
   int contador=0;
      for (int i = 0; i < 28000; i++) {
          
          if (competiciones[i] != null) {
              contador++;
              System.out.println(contador+"****"+competiciones[i].getId_competicion());
         csvOutput.write(competiciones[i].getId_competicion()+"");
        csvOutput.write(competiciones[i].getNombreCompeticion());
        csvOutput.write(competiciones[i].getNombreRegion());
        csvOutput.write(competiciones[i].getContadorApuestas()+"");
        
   
   csvOutput.endRecord();
              
              
              
              
              
              
          }
          
          
          
          
      }
   
   
   
  csvOutput.close(); 
  
  }  
    
    
    
    
}
