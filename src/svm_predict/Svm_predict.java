/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svm_predict;

/**
 *
 * @author piyush
 */

//import TESTGUI.Malacious;
//import TESTGUI.NonMalacious;
//import TESTGUI.SvmPredict;
import TESTGUI.Malacious;
import libsvm.*;
import java.io.*;
import java.nio.file.Path;
import java.util.*;
import javax.swing.JFileChooser;

public class Svm_predict {
    
    public static File m;
    public static File te;
    public static JFileChooser c;
        
    public void Name(File i,File l,JFileChooser ch)
    {
        m=i;
        te=l;
        c=ch;
       
       // System.out.println(in.toPath());
      //  System.out.println(mo.getName());
    }
   
    
    
	private static svm_print_interface svm_print_null = new svm_print_interface()
	{
		public void print(String s) {}
	};

	private static svm_print_interface svm_print_stdout = new svm_print_interface()
	{
		public void print(String s)
		{
			System.out.print(s);
		}
	};

	private static svm_print_interface svm_print_string = svm_print_stdout;

	static void info(String s) 
	{
		svm_print_string.print(s);
	}

	private static double atof(String s)
	{
		return Double.valueOf(s).doubleValue();
	}

	private static int atoi(String s)
	{
		return Integer.parseInt(s);
	}

	private static void predict(BufferedReader input, DataOutputStream output, svm_model model, int predict_probability) throws IOException
	{
		int correct = 0;
		int total = 0;
		double error = 0;
		double sumv = 0, sumy = 0, sumvv = 0, sumyy = 0, sumvy = 0;

		int svm_type=svm.svm_get_svm_type(model);
		int nr_class=svm.svm_get_nr_class(model);
		double[] prob_estimates=null;

		if(predict_probability == 1)
		{
			if(svm_type == svm_parameter.EPSILON_SVR ||
			   svm_type == svm_parameter.NU_SVR)
			{
				Svm_predict.info("Prob. model for test data: target value = predicted value + z,\nz: Laplace distribution e^(-|z|/sigma)/(2sigma),sigma="+svm.svm_get_svr_probability(model)+"\n");
			}
			else
			{
				int[] labels=new int[nr_class];
				svm.svm_get_labels(model,labels);
				prob_estimates = new double[nr_class];
				output.writeBytes("labels");
				for(int j=0;j<nr_class;j++)
					output.writeBytes(" "+labels[j]);
				output.writeBytes("\n");
			}
		}
		while(true)
		{
			String line = input.readLine();
			if(line == null) break;

			StringTokenizer st = new StringTokenizer(line," \t\n\r\f:");

			double target = atof(st.nextToken());
			int m = st.countTokens()/2;
			svm_node[] x = new svm_node[m];
			for(int j=0;j<m;j++)
			{
				x[j] = new svm_node();
				x[j].index = atoi(st.nextToken());
				x[j].value = atof(st.nextToken());
			}

			double v;
			if (predict_probability==1 && (svm_type==svm_parameter.C_SVC || svm_type==svm_parameter.NU_SVC))
			{
				v = svm.svm_predict_probability(model,x,prob_estimates);
				output.writeBytes(v+" ");
				for(int j=0;j<nr_class;j++)
					output.writeBytes(prob_estimates[j]+" ");
				output.writeBytes("\n");
			}
			else
			{
				v = svm.svm_predict(model,x);
				output.writeBytes(v+"\n");
			}

			if(v == target)
				++correct;
			error += (v-target)*(v-target);
			sumv += v;
			sumy += target;
			sumvv += v*v;
			sumyy += target*target;
			sumvy += v*target;
			++total;
		}
		if(svm_type == svm_parameter.EPSILON_SVR ||
		   svm_type == svm_parameter.NU_SVR)
		{
			Svm_predict.info("Mean squared error = "+error/total+" (regression)\n");
			Svm_predict.info("Squared correlation coefficient = "+
				 ((total*sumvy-sumv*sumy)*(total*sumvy-sumv*sumy))/
				 ((total*sumvv-sumv*sumv)*(total*sumyy-sumy*sumy))+
				 " (regression)\n");
		}
		else
			Svm_predict.info("Accuracy = "+(double)correct/total*100+
				 "% ("+correct+"/"+total+") (classification)\n");
	}

	private static void exit_with_help()
	{
		System.err.print("usage: svm_predict [options] test_file model_file output_file\n"
		+"options:\n"
		+"-b probability_estimates: whether to predict probability estimates, 0 or 1 (default 0); one-class SVM not supported yet\n"
		+"-q : quiet mode (no outputs)\n");
		System.exit(1);
	}
        
        public int GuiOutput(JFileChooser chooser) throws FileNotFoundException, IOException
        {
            System.out.println(chooser.getCurrentDirectory());
            
//            File s = new File("E://implementation1/practise/GUI/try1.output");
             File s = new File(c.getCurrentDirectory()+"/try1.output");
       BufferedReader brTest = new BufferedReader(new FileReader(s));
     String s1 = brTest.readLine();
   System.out.println("Firstline is : " + s1);
       String k = "-1.0";
       System.out.println(s1);
       if(s1.equals(k))
       {
           System.out.println("malacious file");
        //  new Malacious().setVisible(true);
         return 0;
       }    
       else
       {
           System.out.println("non-malacious file");
           // new NonMalacious().setVisible(true);
           return 1; 
       }
        
        }

        public void delete()
        {
               File f = new File(c.getCurrentDirectory()+"/");
    File[] files = f.listFiles();
    for (File file : files) {
        file.delete();
        }
                   //File o = new File(c.getCurrentDirectory()+"/try1.output");
                   //o.delete();

    Malacious m = new Malacious();
    m.Pop();
        }
        
	public static void main(String argv[]) throws IOException
	{
		int i, predict_probability=0;
        	svm_print_string = svm_print_stdout;

		
		try 
		{
		//BufferedReader input = new BufferedReader(new FileReader("E://implementation1/practise/GUI/Sample1.exeSample1.exe.hex-nGram.txt.test"));
		BufferedReader input = new BufferedReader(new FileReader(te.getPath()));
             //       DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("E://implementation1/practise/GUI/try1.output")));
                   DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(c.getCurrentDirectory()+"/try1.output")));
                //  svm_model model = svm.svm_load_model("E://implementation1/practise/GUI/try1.model");
		       svm_model model = svm.svm_load_model(m.getPath());

                    if (model == null)
			{
				System.err.print("can't open model file \n");
				System.exit(1);
			}
			if(predict_probability == 1)
			{
				if(svm.svm_check_probability_model(model)==0)
				{
					System.err.print("Model does not support probabiliy estimates\n");
					System.exit(1);
				}
			}
			else
			{
				if(svm.svm_check_probability_model(model)!=0)
				{
					Svm_predict.info("Model supports probability estimates, but disabled in prediction.\n");
				}
			}
			predict(input,output,model,predict_probability);
			input.close();
			output.close();
		} 
		catch(FileNotFoundException e) 
		{
			exit_with_help();
		}
		catch(ArrayIndexOutOfBoundsException e) 
		{
			exit_with_help();
		}
                
             //   GuiOutput();
                
	}
}
