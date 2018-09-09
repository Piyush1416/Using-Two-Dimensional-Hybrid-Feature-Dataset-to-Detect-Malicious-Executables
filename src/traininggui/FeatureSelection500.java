/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traininggui;

import TrainGUI.TestDataSetgui;
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

/**
 *
 * @author piyush
 *
 */



public class FeatureSelection500 {

   public void HD(JFileChooser chooser,JFileChooser choose) throws FileNotFoundException
   {
               int counter=1;
        File b = chooser.getSelectedFile();
      //  File b =new File("E://implementation1/Hybrid-features/4-gram/malacious");
      //  File f2 =new File("E://implementation1/Hybrid-features/4-gram/bestFeatures.txt");
        File f2 = choose.getSelectedFile();
        
       // automation
        
         File[] files = b.listFiles();
    for (File file : files) {
        System.out.println(counter+"\t"+file.getName());
       counter++;
      String nam=file.getName();
       // File f1= new File("E://implementation1/Hybrid-features/4-gram/malacious/"+nam);
         File f1 = new File(b.getPath()+"/"+nam);   
        
        
      Scanner scan1 = new Scanner(f1);

    Scanner scan2 = new Scanner(f2);

    int i = 1;
    List<String> txtFileOne = new ArrayList<String>();

    List<String> txtFileTwo = new ArrayList<String>();
 
     
    while (scan1.hasNext())
    {
        txtFileOne.add(scan1.nextLine());         
    }

    while (scan2.hasNext())

    {

        txtFileTwo.add(scan2.nextLine());         
    }
   
  PrintWriter bw = null;
try
                             {
                            //  bw = new PrintWriter(new FileWriter(new File("E://implementation1/practise/dataset-check/dataset.txt"), true));
                                bw = new PrintWriter(new FileWriter(new File(choose.getCurrentDirectory()+"/dataset.txt"), true));
                                 bw.print("-1 ");
  
    for (int j = 0; j < txtFileTwo.size(); j++)
			{
                               
				String fsl = txtFileTwo.get(j);
                      
                             //  System.out.println(fileContentSingleLine);
                               
	for(int z=0; z < txtFileOne.size(); z++)                                 // z < txtFileOne.size()
        {
                                String s = txtFileOne.get(z);
                               
                           //  System.out.println(fsl+"\t \t"+ s);
                              
                                
                             if (fsl.equals(s))
                                {
                                       // System.out.println(fsl+"\t \t"+ s);
                                        // my line
                                   System.out.println(fsl+"\t\t"+s+"\t"+(++j));
                                        // System.out.println(fsl);
                                   
                                   //dataset Generation
                                   
                         
                              bw.print(j+":1 ");
                              
                        
                             }   
                                else 
                                    continue; 
                                  
               
        }
    
    }
    
            bw.println(" -1");
    bw.flush();            
    bw.close();
    bw = null;
    
                             }
catch(Exception e) {
    System.out.println("Exception caught: "+e.getMessage());
}
}
    TestDataSetgui t = new TestDataSetgui();
    t.Pop();
   }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        // TODO code application logic here
 /*       
        int counter=1;
        File b =new File("E://implementation1/Hybrid-features/4-gram/malacious");
        File f2 =new File("E://implementation1/Hybrid-features/4-gram/bestFeatures.txt");
     
       // automation
        
         File[] files = b.listFiles();
    for (File file : files) {
        System.out.println(counter+"\t"+file.getName());
       counter++;
      String nam=file.getName();
        File f1= new File("E://implementation1/Hybrid-features/4-gram/malacious/"+nam);
            
        
        
      Scanner scan1 = new Scanner(f1);

    Scanner scan2 = new Scanner(f2);

    int i = 1;
    List<String> txtFileOne = new ArrayList<String>();

    List<String> txtFileTwo = new ArrayList<String>();
 
     
    while (scan1.hasNext())
    {
        txtFileOne.add(scan1.nextLine());         
    }

    while (scan2.hasNext())

    {

        txtFileTwo.add(scan2.nextLine());         
    }
   
  PrintWriter bw = null;
try
                             {
                              bw = new PrintWriter(new FileWriter(new File("E://implementation1/practise/dataset-check/dataset.txt"), true));
                              bw.print("-1 ");
  
    for (int j = 0; j < txtFileTwo.size(); j++)
			{
                               
				String fsl = txtFileTwo.get(j);
                      
                             //  System.out.println(fileContentSingleLine);
                               
	for(int z=0; z < txtFileOne.size(); z++)                                 // z < txtFileOne.size()
        {
                                String s = txtFileOne.get(z);
                               
                           //  System.out.println(fsl+"\t \t"+ s);
                              
                                
                             if (fsl.equals(s))
                                {
                                       // System.out.println(fsl+"\t \t"+ s);
                                        // my line
                                   System.out.println(fsl+"\t\t"+s+"\t"+(++j));
                                        // System.out.println(fsl);
                                   
                                   //dataset Generation
                                   
                         
                              bw.print(j+":1 ");
                              
                        
                             }   
                                else 
                                    continue; 
                                  
               
        }
    
    }
    
            bw.println(" -1");
    bw.flush();            
    bw.close();
    bw = null;
    
                             }
catch(Exception e) {
    System.out.println("Exception caught: "+e.getMessage());
}
         
}
         */
    }
}
