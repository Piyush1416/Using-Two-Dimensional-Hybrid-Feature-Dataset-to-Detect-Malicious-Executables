/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinggui;

//import gui.HybridFeatureCombination;
import TESTGUI.HybridFeatureCombination;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import javafx.stage.FileChooser;

/**
 *
 * @author piyush
 */
public class Hybrid {
    
    public void H(File w, File r)
    {
      //   File r = new File("E://implementation1/practise/Test/Sample0exe.txt");
      //  File w = new File("E://implementation1/practise/Test/n-Gram.txt");
        
         LineNumberReader br = null;
         PrintWriter bw = null;
try
{
    //br = new LineNumberReader(new FileReader(new File("E://implementation1/n-gramFiles/ComUpdatusPS.exe.hex-03-ngrams-Freq.txt")));
    br = new LineNumberReader(new FileReader(r));
    bw = new PrintWriter(new FileWriter(w, true));
 
    String line = br.readLine();
     
    while (line != null ) { 
        bw.println(line);
        line = br.readLine();
    }
     
    br.close();
    br = null;
    bw.flush();            
    bw.close();
    bw = null;
     
 
}
catch(Exception e) {
    System.out.println("Exception caught: "+e.getMessage());
} finally {
    // code of static close method omitted 
    //close(br);
    //close(bw);
   
}

    HybridFeatureCombination v = new HybridFeatureCombination();
    v.Pop();
    }
    
    public static void main(String args[])
    {
        
    }
    }
    

