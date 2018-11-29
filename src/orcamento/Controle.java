/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package orcamento;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Braz
 */
public class Controle {
    
    public static void criarLinha(JTable tabela)
    {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();  
      
        Object[] linha = null;//alguma linha  
      
        modelo.addRow(linha);
        
    }
    public static void removerLinha(JTable tabela)
    {
    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();  
      
        Object[] linha = null;//alguma linha 
        modelo.removeRow(tabela.getRowCount()-1);
    }
    
    public static void removerAll(JTable tabela)
    {
    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();  
      
        Object[] linha = null;//alguma linha 
        int linhas=tabela.getRowCount()-1;
        
        for(int i=linhas;i>0;i--)
        {
            modelo.removeRow(i);
        }
        modelo.removeRow(tabela.getRowCount()-1);
    }
}
