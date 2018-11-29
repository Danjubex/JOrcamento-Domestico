/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SplashScreen;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

//import com.sun.awt.AWTUtilities;

/**
 *
 * @author Braz
 */
public class SplashScreen extends JWindow {
    JLabel label;
    ImageIcon imagem;//imagem png
    AbsoluteLayout absoluto;//layout necessário
    AbsoluteConstraints ab;//necessário tb
  
    
    public SplashScreen()
    {
     label=new JLabel();
     imagem=new ImageIcon(this.getClass().getResource("visual.png"));// informa o local da imagem
     
     absoluto=new AbsoluteLayout();
     ab= new AbsoluteConstraints(0,0);
     
     label.setIcon(imagem);
     
 
     
     
    
     
    //AWTUtilities.setWindowOpaque(this,false);
    this.setLayout(absoluto);
    this.getContentPane().add(label,ab);//coloca a imagem e o layout dela
    this.pack();
    this.setVisible(true);//aparecer
    this.setLocationRelativeTo(null);//colocar no centro
       
    try {
            Thread.sleep(20000);//trava por 10 segundos
            dispose();
        } catch (InterruptedException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    
    }
    
    
    
 public static void main(String[] args)
 {
    new SplashScreen();
    
     
 }
  
}
