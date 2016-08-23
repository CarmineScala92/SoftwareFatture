/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classi;

import java.io.File;
import java.util.Arrays;

public class ListaFile

{
    public File[]  listaf() 

    {
        String  workingDir= System.getProperty("user.home");
        File file = new File(workingDir+"/Desktop/Fatture/");

            File[] filesInDir = file.listFiles();
            Arrays.sort(filesInDir);
           
            /*for(File f : filesInDir)
            {
               System.out.println(f.getAbsolutePath());
            }*/
         return filesInDir;
    }
}

