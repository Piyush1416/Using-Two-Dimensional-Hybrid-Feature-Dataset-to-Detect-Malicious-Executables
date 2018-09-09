/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinggui;

/**
 *
 * @author piyush
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import gui.HexDll;
import TESTGUI.HexDll;
import TESTGUI.Malacious;
import svm_train.java.Svm_trainJava;
import svm_predict.Svm_predict;
/**
 *
 * @author piyush
 */

import java.io.*;
import java.util.*;
import static libsvm.svm.svm_train;


 public class TestingGUI
{
   public static  File d;
     
	public static Set<String>	dlls	= new HashSet<>();
	static
	{
		// Extremely imp direct linking libraries for windows.
		// List is to check if executable file has referenced to one of these
		// files.
		dlls.add("USER32.DLL");
		dlls.add("kernel32.dll");
		dlls.add("ADVAPI32.DLL");
		dlls.add("WSOCK32.DLL");
		dlls.add("AVICAP32..DLL");
		dlls.add("WINNM.DLL");
		dlls.add("cmiadapter.dll");
		dlls.add("cmitrust.dll");
		dlls.add("cmiv2.dll");
		dlls.add("CntrtextInstaller.DLL");
		dlls.add("locdrv.dll");
		dlls.add("Ntdll.dll");
		dlls.add("ntoskrnl.dll");
		dlls.add("system32.dll");
		dlls.add("hal.dll");
		dlls.add("shell32.dll");
		dlls.add("msvbvm.dll");
		dlls.add("ADVAPI32.DLL:AdjustTokenPrivileges()");
		dlls.add("advapi32:AdjustTokenPrivileges()");
		dlls.add("advapi32:GetFileSecurityA()");
		dlls.add("wsock32:recv()");
		dlls.add("wsock32:send()");
		dlls.add("user32:EndDialog()");
		dlls.add("kernel32:EnumCalendarInfoA()");
		dlls.add("user32:LoadIconA()");
		dlls.add("kernel32:GetTempPathA()");
		dlls.add("advapi32");
		dlls.add("shell32:ExtractAssociatedIconA()");
	}

	
	public static boolean hasImportantFileReferenced(File executable)  throws Exception
	{
		List<String> impReferencedFiles = getImpReferencedFiles(executable);
		if (impReferencedFiles.size() > 3)
		{
			return true;
		}
		return false;
	}
	
	public static List<String> getImpReferencedFiles(File executable) throws Exception
	{
		List<String> impReferencedFiles = new ArrayList<>();
		if (!executable.exists())
		{
			throw new Exception("File does not exists");
		}
		else if (executable.isHidden())
		{
			throw new Exception("Can not read hidden files.");
		}
		else if (!executable.canRead())
		{
			throw new Exception("Do not have permission to read file.");
		}
		else if (executable.isDirectory())
		{
			throw new Exception("Please provide file. It's a directory.");
		}
		BufferedReader bufferedReader = new BufferedReader(new FileReader(executable));
		String line;
		java.util.List<String> fileContents = new ArrayList<>();
		while ((line = bufferedReader.readLine()) != null)
		{
			fileContents.add(line);
		}
		bufferedReader.close();
		Iterator<String> impFileIterator = dlls.iterator();
                
                File t= null;
                
		while (impFileIterator.hasNext())
		{
			String name = impFileIterator.next();
			for (int i = 0; i < fileContents.size(); i++)
			{
				String fileContentSingleLine = fileContents.get(i);
				if (fileContentSingleLine.contains(name))
				{
					impReferencedFiles.add(name);
                                        
                                        //my line
                                        System.out.println(name);
                                    
                                        
                                        // my txt file printing code
                                        
                                     //   File t = new File(executable.getPath()+executable.getName()+".txt");
                                          t = new File(executable.getPath()+"-DLL.txt");

			// if file doesnt exists, then create it
			if (!t.exists()) {
				t.createNewFile();
			}

			FileWriter fw = new FileWriter(t,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(name+"\n");
                        //bw.write("\n");
                               bw.close();                           
                            }
                                
                                   else
                                {
                                    t = new File(executable.getPath()+"-DLL.txt");
                                    if (!t.exists()) {
				t.createNewFile();
                                }
                                }  
                                    
                                       
			}
                        
                        
		

			//System.out.println("Done");
                         
                }
                  return impReferencedFiles;
        }
	

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
  
    public static void HD(File a) throws IOException, Exception
    {
       String t= a.getPath();
       String f = a.getName();
       d = a;
        // dump to the console
     TestingGUI.hexDump(System.out,a);  //       E://NonMaliciousSamples/ComUpdatusPS.exe
    // dump to a file
      TestingGUI.hexDump(new java.io.PrintStream(a.getPath()+"-HexDump.hex"),a);
       
       ///////////////////////////////////// DLL  /////////////////////////////////////////////////////////////////
    
         boolean l = hasImportantFileReferenced(a);
         System.out.println(l+"\n");
         
     
       /////////////////////////////////// pop up call////////////////////////////////////////////////////////////
          System.out.println(f);
          HexDll h = new HexDll();
          h.Pop();
    }

    public void Delete()
    {
        d.delete();
        Malacious m = new Malacious();
        m.Pop();
    }


    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
   /* 
        System.out.println("PLEASE SELECT A STAGE IN SEQUENCE");
        System.out.println(" 1. hex and dll feature extraction \n 2. N-Gram from Hex \n 3. Hybrid feature combination \n 4. Create TEST file \n 5. SVM TEST \n 6. SVM PREDICT \n");
       
        Scanner in =new Scanner(System.in);
        int  l = in.nextInt();
        
       
        switch(l)
        {
        
     case(1):   
	 File n= new File("E://implementation1/practise/Test/MBppld32.exe");

	// dump to the console
      TestingGUI.hexDump(System.out,n);  //       E://NonMaliciousSamples/ComUpdatusPS.exe
    // dump to a file
       TestingGUI.hexDump(new java.io.PrintStream("E://implementation1/practise/Test/MBppld32.hex"),n);
       
       
	///////////////////////////////////// DLL  /////////////////////////////////////////////////////////////////

           
          boolean a = hasImportantFileReferenced(n);
            System.out.println(a+"\n");
            break;
        //////////////////////////////////// N-Gram from Hex//////////////////////////////////////////////////////
            
          case(2):  
                NGram b= new NGram();
                b.gram();
        
                break;
       
        ///////////////////////////////////// HYBRID FEATURES /////////////////////////////////////////////////////
           case(3):
                Hybrid d= new Hybrid();
                d.H();
                
                break;
  
        //////////////////////////////////// TEST ////////////////////////////////////////////////////////////////
            case(4):
                
        TestDataSet t = new TestDataSet();
        t.Test();
    
        break;
        //////////////////////////////////// SVM TRAIN //////////////////////////////////////////////////////////
         
        case(5) :
        String[] argv = {};
        Svm_trainJava.main(argv);
        break;
     
     
    
     
     ///////////////////////////////////// SVM PREDICT //////////////////////////////////////////////////////////
     
      case(6):  
        String[] argc = {};
        Svm_predict.main(argc);
       File s = new File("E://implementation1/practise/try1.output");
       Scanner s1 = new Scanner(s);
       String k = "-1";
       if(s1.equals(k))
           System.out.println("malacious file");
       else 
           System.out.println("non-malacious file");
       break;
       
      default:  
        System.out.println("Done.");
          break;
    }
 */          
    }
  }       
