/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape2D;

import Materials.Tree;

/**
 *
 * @author HUYENKUTE
 */
public class ThuPhongCaiCay2D extends javax.swing.JFrame {

    /**
     * Creates new form DoiXungConRan2D
     */
    static Tree tree = new Tree();;
    public ThuPhongCaiCay2D() {
        initComponents();
        Tree tree = new Tree();;
        jPanel2D_DrawPallet.setSize(1102, 672);
        tree.setLocation(5, 5);
        tree.setSize(1102, 672);
        jPanel2D_DrawPallet.add(tree);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton_Phong = new javax.swing.JButton();
        jButton_Phong1 = new javax.swing.JButton();
        jPanel2D_DrawPallet = new javax.swing.JPanel();

        setTitle("Thu Phóng cái cây");
        setPreferredSize(new java.awt.Dimension(1303, 670));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(150, 600));

        jButton_Phong.setBackground(new java.awt.Color(102, 102, 255));
        jButton_Phong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_Phong.setText("+");
        jButton_Phong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PhongActionPerformed(evt);
            }
        });

        jButton_Phong1.setBackground(new java.awt.Color(204, 102, 255));
        jButton_Phong1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_Phong1.setText("-");
        jButton_Phong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Phong1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton_Phong1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Phong1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(441, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2D_DrawPalletLayout = new javax.swing.GroupLayout(jPanel2D_DrawPallet);
        jPanel2D_DrawPallet.setLayout(jPanel2D_DrawPalletLayout);
        jPanel2D_DrawPalletLayout.setHorizontalGroup(
            jPanel2D_DrawPalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1097, Short.MAX_VALUE)
        );
        jPanel2D_DrawPalletLayout.setVerticalGroup(
            jPanel2D_DrawPalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2D_DrawPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2D_DrawPallet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_PhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PhongActionPerformed
        // TODO add your handling code here:
        tree.tilePhong.x ++;
        tree.tilePhong.y ++;
        tree.repaint();
        repaint();
    }//GEN-LAST:event_jButton_PhongActionPerformed

    private void jButton_Phong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Phong1ActionPerformed
        // TODO add your handling code here:
        tree.tilePhong.x --;
        tree.tilePhong.y --;
        tree.repaint();
        repaint();
    }//GEN-LAST:event_jButton_Phong1ActionPerformed

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
            java.util.logging.Logger.getLogger(ThuPhongCaiCay2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThuPhongCaiCay2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThuPhongCaiCay2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThuPhongCaiCay2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThuPhongCaiCay2D().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Phong;
    private javax.swing.JButton jButton_Phong1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2D_DrawPallet;
    // End of variables declaration//GEN-END:variables
}
