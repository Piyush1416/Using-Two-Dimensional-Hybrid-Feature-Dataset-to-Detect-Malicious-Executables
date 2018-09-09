package traininggui;

import TrainGUI.HexDumpGUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.JFileChooser;

public class HexDump {

  public static void hexDump(PrintStream out, File file) throws IOException {
      InputStream is = new FileInputStream(file);
      int i = 0;
 
      while (is.available() > 0) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("   ");
        out.printf("%04X  ", i * 16);
        for (int j = 0; j < 16; j++) {
           if (is.available() > 0) {
             int value = (int) is.read();
             sb1.append(String.format("%02X ", value));
             if (!Character.isISOControl(value)) {
               sb2.append((char)value);
             }
             else {
               sb2.append(".");
             }
           }
           else {
             for (;j < 16;j++) {
               sb1.append("   ");
             }
           }
        }
        out.print(sb1);
        out.println(sb2);
        i++;
      }
      is.close();
  }
  
public void HD(JFileChooser q) throws IOException
{
    File f = q.getSelectedFile();
    File v = new File(q.getCurrentDirectory()+"/HexDump/");
    v.mkdir();
    File[] files = f.listFiles();
    for (File file : files) {
        System.out.println(file.getName());
    
      String name=file.getName();
      // dump to the console
      HexDump.hexDump(System.out, new File(f.getPath()+"/"+name));  //       E://NonMaliciousSamples/ComUpdatusPS.exe
    // dump to a file
     // HexDump.hexDump(new java.io.PrintStream(v.getPath()+"/"+name+".hex"), new File(f.getPath()+"/"+name));
      HexDump.hexDump(new java.io.PrintStream(v.getPath()+"/"+name+".txt"), new File(f.getPath()+"/"+name));
    
      System.out.println("Done.");
     
    }
     HexDumpGUI h = new HexDumpGUI();
      h.Pop();
}
  
  public static void main(String args[]) throws Exception {
    
 /*     File f = new File("E://implementation1/practise/ALLHEX-NM-M-in-one");
    File[] files = f.listFiles();
    for (File file : files) {
        System.out.println(file.getName());
    
      String name=file.getName();
    // dump to the console
      HexDump.hexDump(System.out, new File("E://implementation1/practise/ALLHEX-NM-M-in-one/"+name));  //       E://NonMaliciousSamples/ComUpdatusPS.exe
    // dump to a file
     // HexDump.hexDump(new java.io.PrintStream("E://implementation1/samples/train/Hex/malacious/"+name+".hex"), new File("E://implementation1/samples/train/maliciousSamples/"+name));
    HexDump.hexDump(new java.io.PrintStream("E://implementation1/samples/train/Hex/allHex.hex"), new File("E://implementation1/practise/ALLHEX-NM-M-in-one/"+name));
    System.out.println("Done.");     // E://NonMaliciousSamples/ComUpdatusPS.hex    // E://NonMaliciousSamples/ComUpdatusPS.exe
    }
*/         
  }  
}
