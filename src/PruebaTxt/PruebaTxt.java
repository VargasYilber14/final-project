package PruebaTxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PruebaTxt {
    private static final String DIRECTORIO = "C:\\Prueba\\";
    private String var_identifier;
   
    public static void main(String[] args) throws IOException {        
        PruebaTxt p = new  PruebaTxt();
        p.LeerComandosTxt();              
    }
    
    public void LeerComandosTxt (){
      
      File archivo;
      FileReader fr = null;
      BufferedReader br;

      try {
         archivo = new File (DIRECTORIO + "test.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         String linea;
      
         while((linea=br.readLine())!=null){
             
            if (linea.contains("create")){
                CreateFileTxt1();
                CreateFileTxt2();
                CreateFileTxt3();
                    
            }else if(linea.contains("assign")){
                ReadFileTxt(DIRECTORIO,"var_id2.txt");
                SobreEscribir(DIRECTORIO, "var_id1.txt");
                   
            }else if(linea.contains("file_in asc")){
                OrdenarFileTxt();
                
            }else if(linea.contains("rem_doubles")){
                QuitarDuplicadosFileTxt();
            }
         }
      }catch(IOException e){
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (IOException e2){ 
         }
      }
   }
    
    public void CreateFileTxt1 (){
    
        var_identifier = "var_id1.txt";
        FileWriter fichero = null;
        PrintWriter pw = null;
        try { 
            fichero = new FileWriter(DIRECTORIO + var_identifier);
            pw = new PrintWriter(fichero);
        } catch (IOException e) {
        } finally {
            try {
                
            if (null != fichero)
               fichero.close();
            } catch (IOException e2) {
            }
        }                   
    }   
    
    public void CreateFileTxt2 (){

        var_identifier = "var_id2.txt";        
        FileWriter fichero = null;
        PrintWriter pw;
        
        try {  
            fichero = new FileWriter(DIRECTORIO + var_identifier);
            pw = new PrintWriter(fichero);

            for (int i = 1; i <= 10; i++)
                pw.println(i);

        } catch (IOException e) {
        } finally {
            try {

            if (null != fichero)
               fichero.close();
            } catch (IOException e2) {
            }
        }                  
    }    
     
    public void CreateFileTxt3 (){

        var_identifier = "var_id3.txt";        
        FileWriter fichero = null;
        PrintWriter pw;
        
        try { 
            fichero = new FileWriter(DIRECTORIO + var_identifier);
            pw = new PrintWriter(fichero);

            for (int i = 6; i <= 10; i++)
                pw.println(i);

        } catch (IOException e) {
        } finally {
           try {
            if (null != fichero)
               fichero.close();
            } catch (IOException e2) {
           }
        }                  
    }
     
    public void ReadFileTxt (String Directorio, String FileName){
        
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        FileWriter fichero = null;
        PrintWriter pw;
        
        try {   
            archivo = new File (Directorio + FileName);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String linea;      
            var_identifier = "var_id1.txt";       
            fichero = new FileWriter(Directorio + var_identifier);
            pw = new PrintWriter(fichero);

            while((linea=br.readLine())!=null){
               System.out.println(linea);
               pw.println(linea);
            }         
        }catch(IOException e){
        }finally{
            try {
       
               if (null != fichero)
                  fichero.close();
               } catch (IOException e2) {
               }
            try{                    
               if( null != fr ){   
                  fr.close();     
               }                  
            }catch (IOException e2){ 
            }
         }       
    }

    public void SobreEscribir (String Directorio, String FileName) throws FileNotFoundException {
     
        File archivo;
        FileReader fr = null;
        BufferedReader br = null;
        
        
        BufferedWriter bw = null;
        FileWriter fw = null;

    try { 
        archivo = new File (Directorio + "var_id3.txt");
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        String linea; 
        
        File file = new File(Directorio + FileName);
    
        if (!file.exists()) {
            file.createNewFile();
        }
        
        fw = new FileWriter(file.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        while((linea=br.readLine())!=null){            
            System.out.println(linea);
            bw.write(linea);
            bw.newLine();
        }       
    } catch (IOException e) {
        } finally {
            try {
              
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
            }
            try {
            
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
            }
        }
    }
    
    
   
    public void OrdenarFileTxt (){
        
    }
    
    
    
    public void QuitarDuplicadosFileTxt (){
        
    }
    
}


