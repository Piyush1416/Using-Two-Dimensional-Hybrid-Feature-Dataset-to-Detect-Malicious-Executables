package testinggui;
//import gui.Ngram;
import TESTGUI.Ngram;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

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

    public void gram(File f) throws FileNotFoundException, IOException {
       // for (int n = 1; n <= 3; n++) {
        String p = f.getPath();
        String n = f.getName();
        File w = new File(f.getPath()+"-nGram.txt");
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
    
   Ngram d = new Ngram();
    d.Pop();
}
    public static void main(String args[])
    {
        
    }
}
