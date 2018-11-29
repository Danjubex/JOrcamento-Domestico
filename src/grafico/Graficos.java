/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Danillo Xavier
 */
public class Graficos {
    DefaultCategoryDataset dcd=new DefaultCategoryDataset();
   

JPanel painel;
    /**
     * 
     * @param valor
     * @param coluna
     * @param mes
     */
    public void setDataSet(double valor,String coluna,String mes)
    {
         
         dcd.addValue(valor, coluna, mes);
         
      
    }
    
    /**
     * 
     */
    public void limpar()
    {
        for(int i=0;i<dcd.getRowCount();i++)
        {
            for(int j=0;j<dcd.getColumnCount();i++)
            {
                dcd.removeRow(i);
                dcd.removeColumn(j);
            }
        }
    }
    /**
     * 
     * @param painel
     */
    public void gerarGrafico(JPanel painel)
    {
        
        JFreeChart grafico = ChartFactory.createLineChart(
                 "Data x Valor",
                 "Data",
                 "Valor R$", 
                  dcd, 
                  PlotOrientation.VERTICAL,
                  true,
                  true,
                  false);
    
       ChartPanel cp = new ChartPanel(grafico);
          
        
         painel.add(cp);
         painel.revalidate();
         painel.repaint(); 
         
    }
    
    public void zoomIn(double valor)
    {
       
    }
    
}
