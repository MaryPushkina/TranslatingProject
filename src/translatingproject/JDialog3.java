/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translatingproject;

import atom.names.ATOMStringResource;
import atom.names.ELanguages;
import atom.names.LanguageManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Мария
 */
public class JDialog3 extends javax.swing.JDialog {

    /**
     * Creates new form JDialog3
     */
    static ATOMStringResource Test1StrToTranslate1 = new ATOMStringResource("asdasd", " тест 1 привет change");
     static ATOMStringResource Test1StrToTranslate2 = new ATOMStringResource("asdasd", " тест 1 привет1");
     static ATOMStringResource Test1StrToTranslate3 = new ATOMStringResource("asdasd", " тест 1 привет2");
     static ATOMStringResource Test1StrToTranslate4 = new ATOMStringResource("asdasd", " тест 1 привет3");
     static ATOMStringResource Test1StrToTranslate5 = new ATOMStringResource("asdasd", " тест 1 привет4");
     static ATOMStringResource Test1StrToTranslate6 = new ATOMStringResource("asdasd", " тест 1 привет5");
     static ATOMStringResource Test1StrToTranslate7 = new ATOMStringResource("asdasd", " тест 1 привет6");
     static ATOMStringResource Test1StrToTranslate8 = new ATOMStringResource("asdasd", " тест 1 привет7");
     static ATOMStringResource Test1StrToTranslate9 = new ATOMStringResource("asdasd", " тест 1 привет8");
     static ATOMStringResource Test1StrToTranslate10 = new ATOMStringResource("asdasd", " тест 1 привет9");
     
     static
     {
        try {
            LanguageManager.getManagerXML().ConvertResourceStringToAtomString(JDialog3.class);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(JDialog3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(JDialog3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JDialog3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDialog3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JDialog3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JDialog3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(JDialog3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JDialog3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JDialog3.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public JDialog3(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        System.out.println(Test1StrToTranslate1.Str(ELanguages.English));
    }
    public void execute()
    {
        this.setVisible(true);
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dialog 3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialog3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialog3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialog3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialog3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog3 dialog = new JDialog3(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
