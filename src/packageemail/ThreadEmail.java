/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageemail;

import packageemail.SendEmail;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Carmine
 */
public class ThreadEmail implements Runnable{

    private JTextField jTextField1;
    private JTextField jTextField2;
    private JLabel jLabel11;
    private JTextArea jTextArea1;
     private JTextField jTextField3;
      private JTextField jTextField4;
       private JTextField jTextField5;
        private JTextField jTextField6;
         private JTextField jTextField7;
       private String tipoEmail;
       private String email;
       private String password;
       private String pathFattura;

    public ThreadEmail(JTextField jTextField1, JTextField jTextField2, JLabel jLabel11, JTextArea jTextArea1, JTextField jTextField3, JTextField jTextField4, JTextField jTextField5, JTextField jTextField6, JTextField jTextField7, String tipoEmail, String email, String password, String pathFattura) {
        this.jTextField1 = jTextField1;
        this.jTextField2 = jTextField2;
        this.jLabel11 = jLabel11;
        this.jTextArea1 = jTextArea1;
        this.jTextField3 = jTextField3;
        this.jTextField4 = jTextField4;
        this.jTextField5 = jTextField5;
        this.jTextField6 = jTextField6;
        this.jTextField7 = jTextField7;
        this.tipoEmail = tipoEmail;
        this.email = email;
        this.password = password;
        this.pathFattura = pathFattura;
    }
       
       
    
    
    
    public void run() {
         ImageIcon image = new ImageIcon(getClass().getResource("/image/" + "logo8" + ".gif"));
           jLabel11.setText("Attendere l'invio dell'email");
           jLabel11.setBackground(Color.BLACK);
           this.jLabel11.setIcon(image);
           this.jLabel11.revalidate(); 
        
          SendEmail s= new SendEmail();
          String result=s.invioEmail( this.jTextField1.getText().trim(),this.jTextField2.getText().trim(),this.jTextArea1.getText().trim(), this.jTextField3.getText().trim(),tipoEmail,email,password, this.pathFattura,this.jTextField4.getText().trim(),this.jTextField5.getText().trim(),this.jTextField6.getText().trim(),this.jTextField7.getText().trim());  
    System.out.println(""+result);
           ImageIcon image1 = new ImageIcon(getClass().getResource("/image/" + "verde" + ".png"));
           this.jLabel11.setText("Email inviata con Successo");
           this.jLabel11.setIcon(image1);
           this.jLabel11.revalidate();
    }
    
}
