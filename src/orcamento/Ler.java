package orcamento;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EveliRayane
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Ler {
FileReader fr;
BufferedReader br;

public String lerLinha( File arquivo) throws FileNotFoundException, IOException
 {
   fr=new FileReader(arquivo);
   br=new BufferedReader(fr);
   br.close();
  return br.readLine();
    
 }
public void lerAll(File arquivo,String linhas[]) throws FileNotFoundException, IOException
{
   String linha;   
   int i=0;
   fr=new FileReader(arquivo);
   br=new BufferedReader(fr);
  
   while((linha=br.readLine())!=null)
   {
       linhas[i]=linha;
       i++;
   }
   br.close();
}

public void lerAll(File arquivo,String linhas[][]) throws FileNotFoundException, IOException
{
   String linha;   
   int i=0;
   fr=new FileReader(arquivo);
   br=new BufferedReader(fr);
  
   while((linha=br.readLine())!=null)
   {
       linhas[i]=linha.split(" ");
       i++;
   }
   br.close();
}
    
}
