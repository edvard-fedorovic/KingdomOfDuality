package kingdomofduality;

import javax.swing.JOptionPane;

public class GameStartScreen extends javax.swing.JFrame {

    public GameStartScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        whitePlayerSelectButton = new javax.swing.JButton();
        BlackPlayerSelectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(600, 300));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 1, 24)); // NOI18N
        jLabel1.setText("Kingdom Of Duality");
        jLabel1.setToolTipText("");

        whitePlayerSelectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/SelectWhite.png"))); // NOI18N
        whitePlayerSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whitePlayerSelectButtonActionPerformed(evt);
            }
        });

        BlackPlayerSelectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/SelectBlack.png"))); // NOI18N
        BlackPlayerSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlackPlayerSelectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(whitePlayerSelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(BlackPlayerSelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(whitePlayerSelectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BlackPlayerSelectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel1.getAccessibleContext().setAccessibleName("KigdomOfDualityLabel");
        whitePlayerSelectButton.getAccessibleContext().setAccessibleName("ChooseBlackButton");
        BlackPlayerSelectButton.getAccessibleContext().setAccessibleName("ChooseWhiteButton");
        BlackPlayerSelectButton.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void whitePlayerSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whitePlayerSelectButtonActionPerformed
        GameBoard GB = new GameBoard();
        GB.gameStart(false);
        GB.show();
        GB.changePlayerName(false);
        this.hide();
    }//GEN-LAST:event_whitePlayerSelectButtonActionPerformed

    private void BlackPlayerSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlackPlayerSelectButtonActionPerformed
        GameBoard GB = new GameBoard();
        GB.gameStart(true);
        GB.show();
        GB.changePlayerName(true);
        this.hide();
    }//GEN-LAST:event_BlackPlayerSelectButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GameStartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameStartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameStartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameStartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameStartScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BlackPlayerSelectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton whitePlayerSelectButton;
    // End of variables declaration//GEN-END:variables
}
