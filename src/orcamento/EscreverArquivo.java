package orcamento;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EveliRayane
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscreverArquivo {


FileWriter fl;
PrintWriter pw;

public EscreverArquivo()
{
}




 /** Esse método escreve um String em um arquivo e depois da um espaço.
 @param arquivo receberá a String.
 * 
 @param mensagem String que guardará no arquivo.
 */
public void escrever(File arquivo,String mensagem) throws IOException
{
fl=new FileWriter(arquivo,true);//Prepara o arquivo para ser escrito.False indica que substituirá o arquivo

pw=new PrintWriter(fl);


pw.append(mensagem+" ");

pw.flush();
pw.close();
    
}
/** Esse método escreve um object em um arquivo e depois da um espaço.
 @param arquivo receberá o object.
 * 
 @param mensagem object que guardará no arquivo.
 */
public void escrever(File arquivo,Object mensagem) throws IOException
{

fl=new FileWriter(arquivo,true);//Prepara o arquivo para ser escrito.
pw=new PrintWriter(fl);

pw.write(mensagem+" ");
pw.flush();
pw.close();    
}


/** Esse método escreve um String em um arquivo e depois pula uma linha.
 @param arquivo receberá a String.
 * 
 @param mensagem String que guardará no arquivo.
 */
public void escreverLn(File arquivo,String mensagem)throws IOException
{
    fl=new FileWriter(arquivo,true);//Prepara o arquivo para ser escrito.
    pw=new PrintWriter(fl, true);
    pw.append(mensagem+"\n");
    pw.flush();
    pw.close();

}
/** Esse método escreve pula uma linha em um arquivo.
 @param arquivo quebra de linha nesse arquivo.
 
 */
public void pularLinha(File arquivo)throws IOException
{
    fl=new FileWriter(arquivo,true);//Prepara o arquivo para ser escrito.
    pw=new PrintWriter(fl, true);
    pw.append("\n");
    pw.flush();
    pw.close();
    

}


    
    
}
