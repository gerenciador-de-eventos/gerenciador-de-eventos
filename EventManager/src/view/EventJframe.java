/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.EventController;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Campus;
import model.DAO.CampusDAO;
import model.DAO.EquipamentDAO;
import model.DAO.PlaceDAO;
import model.Equipaments;
import model.Place;

/**
 *
 * @author felipe
 */
public class EventJframe extends javax.swing.JInternalFrame {

    /**
     * Creates new form PersonJframe
     */
    private static final long serialVersionUID = 1L;
 
    private EventController controller;
    private EventManager viewPrincipal;

    public EventJframe() {
        initComponents();

       
        jDateChooserDateEvent.setCalendar(Calendar.getInstance());
    }

    EventJframe(EventManager aThis) {
        //Esconde barra de título padrão do JInternalFrama.
        setRootPaneCheckingEnabled(false);

        //Inicialização dos componentes padrões do JFrame.
        this.viewPrincipal = viewPrincipal;

        //Carrega todas os modelos de tabelas.
        initComponents();

        
        jDateChooserDateEvent.setCalendar(Calendar.getInstance());
        
        CampusDAO campusdao = new CampusDAO();
        
        for(Campus c: campusdao.getAllCampus()){            
            jComboBoxCampus.addItem(c);            
        } 
        
        PlaceDAO placedao = new PlaceDAO();
        
        for(Place p: placedao.getAllCampus()){
            jComboBoxPlace.addItem(p);
        }
        
        /*EquipamentDAO equipdao = new EquipamentDAO();
        
        for(Equipaments e: equipdao.getAllEquipaments()){
            if(e.getEquipamentsType().equals("microfone"){
                jComboBox.addItem(e);
            }
            
        }*/
        
        
        
    }

    public JTable getTableEvent() {
        return tableEvent;
    }

    public JFormattedTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtResponsible() {
        return txtResponsible;
    }

    public JComboBox getJComboBoxCampus() {
        return jComboBoxCampus;
    }

    public JComboBox getJComboBoxPlace() {
        return jComboBoxPlace;
    }

    public JComboBox getJComboBoxMicrophone() {
        return jComboBoxMicrophone;
    }

    public JComboBox getJComboBoxNotebook() {
        return jComboBoxNotebook;
    }

    public JComboBox getJComboBoxProjector() {
        return jComboBoxProjector;
    }

    public JComboBox getJComboBoxTrainee() {
        return jComboBoxTrainee;
    }

    public JDateChooser getJDataChooserDateEvent() {
        return jDateChooserDateEvent;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        jDateChooserDateEvent = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxCampus = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        txtId = new javax.swing.JFormattedTextField();
        btnRemove = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEvent = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtResponsible = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxPlace = new javax.swing.JComboBox<>();
        jComboBoxMicrophone = new javax.swing.JComboBox<>();
        jComboBoxNotebook = new javax.swing.JComboBox<>();
        jComboBoxProjector = new javax.swing.JComboBox<>();
        jComboBoxTrainee = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("Place:");

        jComboBoxCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCampusActionPerformed(evt);
            }
        });

        btnAdd.setText("add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        btnRemove.setText("remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel5.setText("Campus:");

        btnEdit.setText("edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnClean.setText("Clean");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        tableEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEventMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEvent);

        jLabel6.setText("Amount:");

        jLabel1.setText("id");

        jLabel7.setText("Date of event:");

        jLabel2.setText("Name:");

        jLabel9.setText("Responsible:");

        jComboBoxPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPlaceActionPerformed(evt);
            }
        });

        jComboBoxMicrophone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMicrophoneActionPerformed(evt);
            }
        });

        jComboBoxNotebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNotebookActionPerformed(evt);
            }
        });

        jComboBoxProjector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProjectorActionPerformed(evt);
            }
        });

        jComboBoxTrainee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTraineeActionPerformed(evt);
            }
        });

        jLabel8.setText("----------------------------------------- Itens -----------------------------------------");

        jLabel10.setText("Amount:");

        jLabel13.setText("Microphone:");

        jLabel14.setText("Projector:");

        jLabel15.setText("Notebook:");

        jLabel16.setText("Trainee:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtName))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtResponsible)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooserDateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jComboBoxNotebook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jComboBoxMicrophone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel14)
                                                            .addComponent(jLabel16))))))
                                        .addGap(48, 48, 48)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBoxCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBoxPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jComboBoxProjector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxTrainee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)))))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(63, 63, 63)
                                .addComponent(btnRemove)
                                .addGap(43, 43, 43)
                                .addComponent(btnEdit)
                                .addGap(38, 38, 38)
                                .addComponent(btnClean)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtResponsible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jDateChooserDateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jComboBoxCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBoxPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProjector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMicrophone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxNotebook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTrainee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove)
                    .addComponent(btnEdit)
                    .addComponent(btnClean))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCampusActionPerformed

    }//GEN-LAST:event_jComboBoxCampusActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        controller.insert();
        controller.setTable();
        controller.reset();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        controller.delete();
        controller.setTable();
        controller.reset();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        controller.update();
        controller.setTable();
        controller.reset();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        controller.reset();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void tableEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEventMouseClicked
        controller.getDataField();
    }//GEN-LAST:event_tableEventMouseClicked

    private void jComboBoxPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPlaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPlaceActionPerformed

    private void jComboBoxMicrophoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMicrophoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMicrophoneActionPerformed

    private void jComboBoxNotebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNotebookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNotebookActionPerformed

    private void jComboBoxProjectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProjectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProjectorActionPerformed

    private void jComboBoxTraineeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTraineeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTraineeActionPerformed

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
            java.util.logging.Logger.getLogger(EventJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<Object> jComboBoxCampus;
    private javax.swing.JComboBox<String> jComboBoxMicrophone;
    private javax.swing.JComboBox<String> jComboBoxNotebook;
    private javax.swing.JComboBox<Object> jComboBoxPlace;
    private javax.swing.JComboBox<String> jComboBoxProjector;
    private javax.swing.JComboBox<String> jComboBoxTrainee;
    private com.toedter.calendar.JDateChooser jDateChooserDateEvent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEvent;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtResponsible;
    // End of variables declaration//GEN-END:variables
}
