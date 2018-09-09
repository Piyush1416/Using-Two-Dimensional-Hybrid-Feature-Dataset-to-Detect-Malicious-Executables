package traininggui;

import TrainGUI.nGramGUI;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.JFileChooser;

public class NGram {

    public static List<String> ngrams(int n, String str) {
        List<String> ngrams = new ArrayList<String>();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length - n + 1; i++)
            ngrams.add(concat(words, i, i+n));
        return ngrams;
    }

    public static String concat(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++)
            sb.append((i > start ? " " : "") + words[i]);
        return sb.toString();
    }

    public void HD(JFileChooser r) throws FileNotFoundException, IOException
    {
      //  File f = new File("E://implementation1/practise/Test/Sample0.hex");
      //  File w = new File("E://implementation1/practise/Test/n-Gram.txt");
        
            
    File d = r.getSelectedFile();
    File v = new File(r.getCurrentDirectory()+"/nGram/");
    v.mkdir();
    File[] files = d.listFiles();
    for (File file : files) {
        System.out.println(file.getName());
    
      String name=file.getName();
       File w= new File(v.getPath()+"/"+name);
    //  File w= new File(r.getParent()+"/nGram/"+name+".txt");
      // dump to the console
     // HexDump.hexDump(System.out, new File(d.getPath()+"/"+name));
        
        Set<String> set = new HashSet<String>();

        
        PrintWriter bw = null;
     
              Scanner scan1 = new Scanner(file);
               List<String> txtFileOne = new ArrayList<String>();
               
               while (scan1.hasNext())
    {
        txtFileOne.add(scan1.nextLine());         
    }
      bw = new PrintWriter(new FileWriter(w, true));           
        for(int z=0; z < txtFileOne.size(); z++)                                 // z < txtFileOne.size()
        {
                                String s = txtFileOne.get(z);
                               
            for(String ngram : ngrams(4,s))
            { 
                
                if(ngram.length()==11)
                {
            //    System.out.println(ngram+"\t "+ngram.length());
               // bw.println(ngram);
                set.add(ngram);
                
                }
              
   
            }
      //   }
    }
       Iterator iterator = set.iterator();
while(iterator.hasNext()){
  String element = (String) iterator.next();
  System.out.println(element);
  bw.println(element);
}
        
         bw.flush();            
    bw.close();
    bw = null;

    }
    System.out.println("Done !!!");
    nGramGUI n = new nGramGUI();
    n.Pop();
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
       // for (int n = 1; n <= 3; n++) {
    /*    File f = new File("E://implementation1/practise/Test/Sample0.hex");
        File w = new File("E://implementation1/practise/Test/n-Gram.txt");
             Set<String> set = new HashSet<String>();

        
        PrintWriter bw = null;
     
              Scanner scan1 = new Scanner(f);
               List<String> txtFileOne = new ArrayList<String>();
               
               while (scan1.hasNext())
    {
        txtFileOne.add(scan1.nextLine());         
    }
      bw = new PrintWriter(new FileWriter(w, true));           
        for(int z=0; z < txtFileOne.size(); z++)                                 // z < txtFileOne.size()
        {
                                String s = txtFileOne.get(z);
                               
            for(String ngram : ngrams(4,s))
            { 
                
                if(ngram.length()==11)
                {
            //    System.out.println(ngram+"\t "+ngram.length());
               // bw.println(ngram);
                set.add(ngram);
                
                }
              
   
            }
      //   }
    }
       Iterator iterator = set.iterator();
while(iterator.hasNext()){
  String element = (String) iterator.next();
  System.out.println(element);
  bw.println(element);
}
        
         bw.flush();            
    bw.close();
    bw = null;
*/
        
}
}
