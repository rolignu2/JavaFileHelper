/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.filehelper.filenodes;
import java.io.File;

/**
 *
 * @author rolando
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       
       filenodes files = new filenodes("/opt/");
       //LinkedList<File> l = files.Get().GetAllFiles();
       //System.out.println("Total count files: " + files.CountFiles());
       
       /*for(File f : l)
       {
           System.out.println(f.getName());
       }*/
       
       //owl-logo.png
       File f = files.Find("owl-logo.png");
       if(f == null) return ;
       System.out.println(f.getName());
       System.out.println(f.getPath());
    }
    
}


