
package com.filehelper;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Rolando Arriaza <rolignu90@gmail.com>
 * @version 1.0.1
 * @since 1.0.0 
 * @date sept-2016
 */
public class filenodes
{
    
    /**
     * @serial 1230099955-4
     * @see 2016 
     * 
     * @todo  Reserve vars 
     **/
    
    private File file;
    
    private LinkedList<File> list;
    
    private List<String> error_list;
    
    private boolean error = false;
    
    
    /**
     * @param dir, direcotory to start
     **/
    public filenodes(String dir)
    {
        this.file = new File(dir);
        this.list = new LinkedList<File>();
        this.error_list = new ArrayList();
    }
    
    /**
     * @todo , basico constructor use Set_new_dir to start 
     **/
    public filenodes()
    {
        this.list = new LinkedList<File>();
        this.error_list = new ArrayList();
    }
    
    
    /**
     * @param dir , set or change a new dir to start
     **/
    public filenodes Set_new_dir(String dir)
    {
        
        this.file = new File(dir);
        
        if(!this.Exist()){
            this.error = true ;
        }
        
        return this;
    }
    
    /**
     * @param dir , set or change new directory 
     * @param erase , delete all tad list class
     * @return this
     **/
    public filenodes Set_new_dir(String dir , boolean erase )
    {
        this.list = new LinkedList<File>();
        this.error_list = new ArrayList();
        this.Set_new_dir(dir);
        return this;
    }
    
    
    /**
     * @param (optional) boolean hidden , true if show hidden files
     * @return this pointer
     **/
    public filenodes Get(boolean ... hidden)
    {
        if(!this.file.exists())
        {
            this.error = true;
            return this;
        }
        
        this.Getfile(file , hidden);
        return this;
    }
    
    
    /**
     * @param nodefile , get a node to start
     * @param hidden (optional) , true if add a hidden files
     **/
    private void Getfile(File nodefile , boolean ... hidden)
    {
        File[] root =  nodefile.listFiles();
        
        boolean show = false;
        
        if(hidden.length == 1)
        {
            show = hidden[0];
        }
        
        try{
            for(File f : root)
            {
                if(f.isDirectory())
                {
                    this.Getfile(f);
                }
                else if(f.isFile())
                {
                    if(f.isHidden() && show)
                        list.add(f);
                    else if(!f.isHidden())
                        list.add(f);
                }
        }
        }catch(Exception ex)
        {
            /**
             * catch error some files whit problems in linux 
             ***/
            this.error_list.add("Error N: " 
                    + ex.getLocalizedMessage() 
                    + " ---> MESSAGE : " 
                    + ex.getMessage());
        }
        
    }
    
    /**
     * @param filenode , get a node to start
     * @param data , set a data (string)
     * @param hidden , true if count a hidden files 
     **/
    private void GetFind(File filenode , String data , boolean ... hidden )
    {
         
        File[] root =  filenode.listFiles();
        boolean show = false;
        
        if(hidden.length == 1)
        {
            show = hidden[0];
        }
        
        try{
            for(File f : root)
            {
                if(f.isDirectory())
                {
                    this.GetFind(f, data, hidden);
                }
                else if(f.isFile())
                {
                    if(data.compareTo(f.getName()) == 0)
                    {
                        if(f.isHidden() && show)
                        {
                            this.list.add(f);
                            return ;
                        }
                        else if(!f.isHidden())
                        {
                           this.list.add(f);
                           return ;
                        }
                    }
                }
        }
        }catch(Exception ex)
        {
            /**
             * catch error some files whit problems in linux 
             ***/
            this.error_list.add("Error N: " 
                    + ex.getLocalizedMessage() 
                    + " ---> MESSAGE : " 
                    + ex.getMessage());
        }
        
        
    }
    
     /**
      * @param String data , data to find 
      * @param int[] params
      **/
     public File Find(String data  , boolean ... hidden)
    {
        this.GetFind(this.file, data, hidden);
        
        try{
              File f = this.list.get(0);
              if(!f.exists()) return null;
              return f;
        }
        catch(Exception ex)
        {
            this.error_list.add("FInd error :" + ex.getMessage() );
        }
        
        return null;
    }
     
     
    
    
    /**
     * @return LinkedList<File> , get all file into a list
     ***/
    public LinkedList<File> GetAllFiles()
    {
        return this.list;
    }
    
    /**
     * @return boolean , true if exist a file.
     **/
    public boolean Exist()
    {
        return this.file.exists();
    }
    
    /**
     * @return int , return number a file to finder
     **/
    public int CountFiles()
    {
        return this.list.size();
    }
    
    /**
     * @return boolean , if exist an error return true 
     **/
    public boolean error()
    {
        return this.error;
    }
    
    /**
     * @return List<String> , return a tad list of catch exceptions
     **/
    public List<String> error_list()
    {
        return this.error_list;
    }
    
   
    
}