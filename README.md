# Using-Two-Dimensional-Hybrid-Feature-Dataset-to-Detect-Malicious-Executables
A optimum technique where we could easily detect malicious virus files by extracting two features (Hexadecimal + DLL calls) from an executable file

1] Under Main Folder you can access MainPage.java which takes you to Welcome Page

2] You can decide whether you wish to select Malware Training or Testing Phase. 
   But for first run its ideal to train the system.

3] Store the files seperately in (sample folder) into 3 parts 
		- training   (60%)
    - validation (20%)
		- testing    (20%)

 ########### For Training ##########
 
4] Run hexdump and dll codes on malacious and non-malacious executables present in folder
	.hex and dll files willbe extracted from each executable

5] store extracted files in seperate folders 

6] Now Run Hexdump algo again and this time store all hexdump in one file only named (AllHex.hex) 
	
7] Run Ngram pass all hexfiles and create ngram based on n selected to create n-gram(filename).txt 

8] Store them seperately in n-gram folder

9] pass AlHex.hex to Ngram and get ngram file for same n with frequencies

10] add dll calls to top ALLHex file which will have 500 features + dll now so top500+.txt features

11] Run FeatureSelection algo with input  ( top500+.txt + ngram file[malacious/non-malacious alternately] ) to create dataset file with extension ( .test)

12] svm-training and svm-predict  

13] For indepth understand of the working kindly refer the below Research paper
     http://www.ijircce.com/upload/2016/july/158_Using.pdf
