/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SplashScreen;

import propriedades.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Danillo
 */
public class Propriedades2 {
    File file;
    Properties prop;
    FileInputStream fis;
    FileOutputStream fos;
    
    public Boolean criarPropriedade(String login)
    {
        file = new File("src/propriedades/"+login+".properties");
        if(file.exists()==true)
        {
            JOptionPane.showMessageDialog(null,"Usuário já esxiste, escolha outro login");
            return false;
        }
        else
        {
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
            Logger.getLogger(Propriedades2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Arquivo não encontrado");
        }
        try {
            prop.store(fos,"Dados de configurações");
            JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso");
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Propriedades2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao tentar salvar as configurações");
        }
        
        
        
    } 
    public void registrar()
    {
    try {
            fos=new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Propriedades2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Arquivo não encontrado");
        }
        try {
            prop.store(fos,"Dados de configurações");
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Propriedades2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao tentar abrir");
        }
    }
    
    public Boolean logar(String login , String senha)
    {
        file=new File("src/propriedades/"+login+".properties");
        
        try {
            fis=new FileInputStream(file);
            prop=new Properties();
            
            try {
                prop.load(fis);
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Propriedades2.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro ao tentar carregar as propriedades do login: "+ login);
            }
                        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Propriedades2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Usuário não cadastrado");
            return false;
        }
        //após configurar o login e verificar se este existe, valida-se a senha
        if(prop.getProperty("senha").equals(senha)==true)
        {
            return true;//logado
        }
        else
        {
            JOptionPane.showMessageDialog(null,"login ou senha inválidos");
            return false;//não ta logado
        }
    }
}
