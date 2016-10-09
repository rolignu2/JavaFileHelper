# JavaFileHelper
      Java File Helper (recursive class) 
      Version 1.0.1
      Author Rolando Arriaza
      
## How to use it 

Import package 
 
```Java
      import com.filehelper.filenodes;
```

Instance a class 

```Java
      filenodes files = new filenodes("your directory ");
```

Get all nodes of files 


```Java
     
      LinkedList<File> l = files.Get().GetAllFiles(); // get all files to recursive 
       
       for(File f : l) // print all name of file 
       {
           System.out.println(f.getName());
       }
     
```

Count files 

```Java
     files.CountFiles()
```

Find a file 

```Java
     File f = files.Find("name-of-file.php");
```





      
