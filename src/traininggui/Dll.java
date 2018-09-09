/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traininggui;

/**
 *
 * @author piyush
 */



import TrainGUI.DllGUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JFileChooser;


        
        
public class Dll
{
 public  File g;
 public  File k;
     
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

	public static File Hex;
        public static File Dll;
    
        
	public boolean hasImportantFileReferenced(File executable)  throws Exception
	{
		List<String> impReferencedFiles = getImpReferencedFiles(executable);
		if (impReferencedFiles.size() > 3)
		{
			return true;
		}
		return false;
	}
	
	public  List<String> getImpReferencedFiles(File executable) throws Exception
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
                
                File  x = new File(k.getPath()+"/DLLcall/");
                                            x.mkdir();
                                            
		BufferedReader bufferedReader = new BufferedReader(new FileReader(executable));
		String line;
		java.util.List<String> fileContents = new ArrayList<>();
		while ((line = bufferedReader.readLine()) != null)
		{
			fileContents.add(line);
		}
		bufferedReader.close();
		Iterator<String> impFileIterator = dlls.iterator();
                File t = null;
                File z = null;
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
        //                                System.out.println(name);
                                    
                                        
                                        // my txt file printing code
                                        
                                     //   File t = new File(executable.getPath()+executable.getName()+".txt");
                                     //    File t = new File(executable.getPath()+"-DLL.txt");
                                        String nam = executable.getName();
                                      //    t = new File(executable.getPath()+"-DLL.txt");
                                          
                                           z = new File(x.getPath()+"/"+nam+".txt");
                                           
			// if file doesnt exists, then create it
			if (!z.exists()) {
				z.createNewFile();
			}

			FileWriter fw = new FileWriter(z,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(name+"\n");
                        //bw.write("\n");
                               bw.close();                           
                                        

				}
                                
                                else
                                {
                                   String f = executable.getName();
                                   z = new File(x.getPath()+"/"+f+".txt");      
                                    if (!z.exists()) {
				z.createNewFile();
                                }
                                         
			}
                       
                        }
                        
                      
                         

			//System.out.println("Done");
                         
                }
                Dll = t;
                  return impReferencedFiles;
               
        }



	public void HD(JFileChooser r) throws Exception
        {
            int counter=1;
            
             //File f = new File("E://NonMaliciousSamples/ComUpdatusPS.exe");
            
            File f = r.getSelectedFile();
            k = r.getCurrentDirectory();
            System.out.println("Current Directory is k:"+k.getPath());
    File[] files = f.listFiles();
    for (File file : files) {
        System.out.println(counter+"\t"+file.getName());
       counter++;
      String nam=file.getName();
            //System.out.println(nam);
            
           File n= new File(f.getPath()+"/"+nam);
            
           boolean a = hasImportantFileReferenced(n);
            System.out.println(a+"\n");
        }
        System.out.println("Done");
        DllGUI d = new DllGUI();
        d.Pop();
        }		
            
	
	
	public static void main(String[] args) throws Exception
	{
	     /*	for (String s : dlls)
		{
			System.out.println(s);
		}
             
            int counter=1;
             //File f = new File("E://NonMaliciousSamples/ComUpdatusPS.exe");
            
            File f = new File("E://implementation1/practise/NonMaliciousSamples");
    File[] files = f.listFiles();
    for (File file : files) {
        System.out.println(counter+"\t"+file.getName());
       counter++;
      String nam=file.getName();
            //System.out.println(nam);
            
           File n= new File("E://implementation1/practise/NonMaliciousSamples/"+nam);
            
           boolean a = hasImportantFileReferenced(n);
            System.out.println(a+"\n");
            
	}
       */ 
        }
}
    

