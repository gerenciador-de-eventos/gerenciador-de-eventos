/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;

/**
 *
 * @author Massallys
 */
public class CadastrarEvento extends javax.swing.JFrame {

    /**
     * Creates new form Cadastros
     */
    public CadastrarEvento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cevPrinc = new javax.swing.JPanel();
        cevEv = new javax.swing.JLabel();
        cevEqui = new javax.swing.JLabel();
        cevSala = new javax.swing.JLabel();
        cevLoc = new javax.swing.JLabel();
        cevCad = new javax.swing.JButton();
        cevVolt = new javax.swing.JButton();
        cevTEv = new javax.swing.JTextField();
        cevTEqui = new javax.swing.JTextField();
        cevTSala = new javax.swing.JTextField();
        cevTLoc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cevEv.setText("EVENTO");

        cevEqui.setText("EQUIPAMENTO");

        cevSala.setText("SALA");

        cevLoc.setText("LOCAL");

        cevCad.setText("CADASTRAR");
        cevCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cevCadActionPerformed(evt);
            }
        });

        cevVolt.setText("VOLTAR");
        cevVolt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cevVoltActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cevPrincLayout = new javax.swing.GroupLayout(cevPrinc);
        cevPrinc.setLayout(cevPrincLayout);
        cevPrincLayout.setHorizontalGroup(
            cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cevPrincLayout.createSequentialGroup()
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cevPrincLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cevVolt))
                    .addGroup(cevPrincLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(cevPrincLayout.createSequentialGroup()
                                .addComponent(cevEv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cevTEv, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cevPrincLayout.createSequentialGroup()
                                .addComponent(cevLoc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cevTLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cevPrincLayout.createSequentialGroup()
                                .addComponent(cevEqui)
                                .addGap(18, 18, 18)
                                .addComponent(cevTEqui, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cevPrincLayout.createSequentialGroup()
                                .addComponent(cevSala)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cevTSala, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 124, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cevPrincLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cevCad)
                .addGap(178, 178, 178))
        );
        cevPrincLayout.setVerticalGroup(
            cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cevPrincLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cevVolt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cevTEv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cevEv))
                .addGap(18, 18, 18)
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cevTEqui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cevEqui))
                .addGap(18, 18, 18)
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cevTSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cevSala))
                .addGap(18, 18, 18)
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cevTLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cevLoc))
                .addGap(38, 38, 38)
                .addComponent(cevCad)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cevPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cevPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cevVoltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cevVoltActionPerformed
        // TODO add your handling code here:
        Principal principal = new Principal();
        hide();
         principal.setVisible(true);
    }//GEN-LAST:event_cevVoltActionPerformed

    private void cevCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cevCadActionPerformed
        // TODO add your handling code here:
         if(cevTEv.getText().equals("")){
             JOptionPane.showMessageDialog(cevEv, "O campo Evento está vazio");
        }if(cevTEqui.getText().equals("")){
            JOptionPane.showMessageDialog(cevEv, "O campo Equipamento está vazio");
        }if(cevTLoc.getText().equals("")){
       JOptionPane.showMessageDialog(cevEv, "O campo Local está vazio");  
        }if(cevTSala.getText().equals("")){
            JOptionPane.showMessageDialog(cevEv, "O campo Sala está vazio");
              }
        
    }//GEN-LAST:event_cevCadActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cevCad;
    private javax.swing.JLabel cevEqui;
    private javax.swing.JLabel cevEv;
    private javax.swing.JLabel cevLoc;
    private javax.swing.JPanel cevPrinc;
    private javax.swing.JLabel cevSala;
    private javax.swing.JTextField cevTEqui;
    private javax.swing.JTextField cevTEv;
    private javax.swing.JTextField cevTLoc;
    private javax.swing.JTextField cevTSala;
    private javax.swing.JButton cevVolt;
    // End of variables declaration//GEN-END:variables
}