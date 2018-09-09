/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traininggui;

import TrainGUI.HybridFeaturesGUI;
import java.io.*;
import javax.swing.JFileChooser;

/**
 *
 * @author piyush
 */
public class HybridFeatures {

    /*
     * @param args the command line arguments
     */
    
    public void HD(JFileChooser chooser, JFileChooser choose)
    {
        
      /*   for(int i=1; i<73;i++)
        {
        File r = new File("E://implementation1/dll/non-malacious/sam-nm-("+i+").txt");
        File w = new File("E://implementation1/Hybrid-features/4-gram/non-malacious/sample-nm("+i+").txt");
      */
        File f = chooser.getSelectedFile();
        File z = choose.getSelectedFile();
        
         File[] files = f.listFiles();
    for (File file : files) {
         String name = file.getName();
         System.out.println(name);
    
         LineNumberReader br = null;
         PrintWriter bw = null;
try
{
    File w = new File(z.getPath()+"/"+name);
    //br = new LineNumberReader(new FileReader(new File("E://implementation1/n-gramFiles/ComUpdatusPS.exe.hex-03-ngrams-Freq.txt")));
    br = new LineNumberReader(new FileReader(w));
    bw = new PrintWriter(new FileWriter(file, true));
 
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
    }
    System.out.println("Done");
    HybridFeaturesGUI h = new HybridFeaturesGUI();
    h.Pop();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
     /*   for(int i=1; i<73;i++)
        {
        File r = new File("E://implementation1/dll/non-malacious/sam-nm-("+i+").txt");
        File w = new File("E://implementation1/Hybrid-features/4-gram/non-malacious/sample-nm("+i+").txt");
        
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
    }
  */           
    }
    
}
