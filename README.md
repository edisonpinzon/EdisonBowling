1. Download ant install MAVEN http://maven.apache.org/  -- also you can find .zip attacheted 
	a. Download http://maven.apache.org/download.cgi
	b. File Version apache-maven-3.5.2-bin.zip
	c. unzip apache-maven-3.5.2-bin.zip
	d. Create a folder like Maven in C:\Program Files
	d. move the unzip folder to new folder  C:\Program Files\Maven
	e. Edit Variable PATH and add URL
		Example --> C:\Program Files\Maven\apache-maven-3.5.2\bin\
	f. open cmd command and execute mvn -v 
		if show this -- mean it was installed correctly
			***************************************************************************************
			Apache Maven 3.5.2 (138edd61fd100ec658bfa2d307c43b76940a5d7d; 2017-10-18T02:58:13-05:00)
			Maven home: C:\Program Files\Maven\apache-maven-3.5.2\bin\..
			Java version: 1.7.0_60, vendor: Oracle Corporation
			Java home: C:\Program Files\Java\jdk1.7.0_60\jre
			Default locale: es_CO, platform encoding: Cp1252
			OS name: "windows 8.1", version: "6.3", arch: "amd64", family: "windows"
			***************************************************************************************

After a correct installation Maven
2. Unzip the project Maven
3. Open cmd command prompt 
4. open URL project maven in cmd 
	--> Example : cd C:\Users\edison\Desktop\Maven\EdisonScoreBowling
5. into the URL project execute the command
	--> mvn clean
	--> mvn install
	--> mvn package
	
After all the step the output final the project maven look like this:

*******************************************************************************************************
[INFO]
[INFO] >>> exec-maven-plugin:1.1.1:java (default) > validate @ EdisonScoreBowling >>>
[INFO]
[INFO] <<< exec-maven-plugin:1.1.1:java (default) < validate @ EdisonScoreBowling <<<
[INFO]
[INFO]
[INFO] --- exec-maven-plugin:1.1.1:java (default) @ EdisonScoreBowling ---
Frame       1       2       3       4       5       6       7       8       9       10
Carl
PinFalls        X      X      X      X      X      X      X      X      X      X      X      X
Score       30      60      90      120     150     180     210     240     270     300     
Jeff
PinFalls        X   7   /   9   0      X   0   8   8   /   F   6      X      X      X   8   1
Score       20      39      48      66      74      84      90      120     148     167     
John
PinFalls     3   /   6   3      X   8   1      X      X   9   0   7   /   4   4      X   9   0
Score       16      25      44      53      82      101     110     124     132     151      
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ EdisonScoreBowling ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 4.050 s
[INFO] Finished at: 2017-11-28T22:17:03-05:00
[INFO] Final Memory: 11M/167M
[INFO] ------------------------------------------------------------------------

	
	
--
