/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package propriedades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Danillo
 */
public class Propriedades {
    
    //InputStream file;
    File file;
    Properties prop;
    FileInputStream fis;
    FileOutputStream fos;
    OutputStream os;
    String login="";
    
    public Boolean criarPropriedade(String login)
    {
      file = new File("propriedades/"+login+".properties");
                  
        if(file.exists()==true)
        {
            JOptionPane.showMessageDialog(null,"Usuário já existe, escolha outro login");
            return false;
        }
        else
        {
            try {
            file.createNewFile();
             } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"O sistema está impedindo o programa de criar um novo arquivo");
             }
            prop=new Properties();
            return true;
        }    
    }
    
    public void setPropriedade(String chave,String valor)
    {
        prop.setProperty(chave, valor);
        
    }
    public String getPropriedade(String chave)
    {
       return prop.getProperty(chave);
        
    }
    
    public Properties getArquivo()
    {
        return prop;
    }
    
    public void salvar()
    {   
       try {
           fos=new FileOutputStream(file);
       }
       catch (FileNotFoundException ex) {
           Logger.getLogger(Propriedades.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Arquivo não encontrado");
       }
       try {
           prop.store(fos,"Dados de configurações");
           JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso");
           fos.close();
       } catch (IOException ex) {
           Logger.getLogger(Propriedades.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao tentar salvar as configurações");
       }
      
      
        
        
    } 
    public void registrar()
    {
       
   try {
          
        fos=new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Propriedades.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Arquivo não encontrado");
        }
        try {
            prop.store(fos,"Dados de configurações");
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Propriedades.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao tentar abrir");
        }
    }
    
    public Boolean logar(String login , String senha)
    {
        file=new File("propriedades/"+login+".properties");
      
       try {
            fis=new FileInputStream(file);
            prop=new Properties();
            
            try {
                prop.load(fis);
                fis.close();
               
            } catch (IOException ex) {
                Logger.getLogger(Propriedades.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro ao tentar carregar as propriedades do login: "+ login);
            }
                        
       } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Usuário não cadastrado");
            return false;
        }
        //após configurar o login e verificar se este existe, valida-se a senha
        if(prop.getProperty("senha").equals(senha)==true)
        {
            return true;//logado
        }
        else if(prop.getProperty("senha").equals(senha)==false)
        {
            JOptionPane.showMessageDialog(null,"Senha Incorreta");
            return false;//não ta logado
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Usuário ainda não cadastrado");
            return false;
        }
    }
}
