package progettoalgoritmi;


import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author salvatorecalanna
 */
public class ChooseDir extends javax.swing.JInternalFrame {
 public String dir="";
ProgettoAlgoritmi qwe = ProgettoAlgoritmi.getSingle();
    public ChooseDir() {
        initComponents();



    }
    
    
    public String getDir(){
        return dir;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        org.jdesktop.layout.GroupLayout jFrame1Layout = new org.jdesktop.layout.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Seleziona last path");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Seleziona path");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click(evt);
            }
        });

        jLabel1.setText("Scegli un opzione");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(44, 44, 44)
                        .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(74, 74, 74)
                        .add(jButton1))
                    .add(layout.createSequentialGroup()
                        .add(181, 181, 181)
                        .add(jLabel1)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click
        // TODO add your handling code here:
        
        
        JFileChooser fc;
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);         
        fc.setAcceptAllFileFilterUsed(false);
         
        
       while (!(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)) 
            { 
                dir=""+fc.getSelectedFile();
            }
       

       qwe.setPath(""+fc.getSelectedFile());
       PrintWriter writer = null;
     try {
         writer = new PrintWriter("user.txt", "UTF-8");
         writer.println("lastPath="+fc.getSelectedFile());
         writer.close();
     } catch (FileNotFoundException ex) {
         Logger.getLogger(ChooseDir.class.getName()).log(Level.SEVERE, null, ex);
     } catch (UnsupportedEncodingException ex) {
         Logger.getLogger(ChooseDir.class.getName()).log(Level.SEVERE, null, ex);
     }

       this.dispose();

    }//GEN-LAST:event_click

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        	try (BufferedReader br = new BufferedReader(new FileReader("user.txt")))
		{

			String sCurrentLine;
			if ((sCurrentLine = br.readLine()) != null) {
				qwe.setPath(""+sCurrentLine.replace("lastPath=", ""));
                                this.dispose();
			}
                        else{
                        JOptionPane.showMessageDialog(null, "asdasd", "Yay, java", JOptionPane.PLAIN_MESSAGE);

                        }

		} catch (IOException e) {
			e.printStackTrace();
		} 
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
