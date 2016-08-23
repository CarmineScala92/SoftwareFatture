/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classi;

import com.itextpdf.text.log.SysoLogger;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
 
import javax.print.PrintException;
import javax.swing.JOptionPane;
 
public class StampaFile {
 private String path;
 
 public StampaFile(String path){
 this.path=path;
 }
    
    
    public void stampa() throws IOException{
    if(!java.awt.Desktop.isDesktopSupported()) {
      System.out.println("Funzione non supportata!");
      return;
    }
 
    System.out.println("wooo");
      Desktop desk = java.awt.Desktop.getDesktop();

      // mando in stampa il file
      System.out.println("wiiii");
      desk.print(new File(path));
        System.out.println("weeee");
    
    }
}

