/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerformanceTask;

/**
 *
 * @author 1elmasriahm
 */
public class EndScreen extends javax.swing.JFrame {

    /**
     * Creates new form EndScreen
     */
    public EndScreen() {
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

        jLabelScore = new javax.swing.JLabel();
        jPanelMain = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jPanelInteractionArea = new javax.swing.JPanel();
        jButtonTryAgain = new javax.swing.JButton();
        jLabelMessageOfScore = new javax.swing.JLabel();
        jLabelScoreShower = new javax.swing.JLabel();
        jLabelAdvice1 = new javax.swing.JLabel();

        jLabelScore.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelScore.setForeground(new java.awt.Color(215, 210, 210));
        jLabelScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelScore.setText("Score: 0");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Results");

        jPanelMain.setBackground(new java.awt.Color(138, 38, 38));

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(198, 198, 198));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("The End!");

        jPanelInteractionArea.setBackground(new java.awt.Color(78, 78, 78));
        jPanelInteractionArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jButtonTryAgain.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonTryAgain.setText("Try Again?");
        jButtonTryAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTryAgainActionPerformed(evt);
            }
        });

        jLabelMessageOfScore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelMessageOfScore.setForeground(new java.awt.Color(205, 205, 205));
        jLabelMessageOfScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessageOfScore.setText("You Failed this test, See you in summer school");

        jLabelScoreShower.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelScoreShower.setForeground(new java.awt.Color(215, 210, 210));
        jLabelScoreShower.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelScoreShower.setText("Score: 0 /5");

        jLabelAdvice1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAdvice1.setForeground(new java.awt.Color(205, 205, 205));
        jLabelAdvice1.setText("Advisable/ Not Advisable");

        javax.swing.GroupLayout jPanelInteractionAreaLayout = new javax.swing.GroupLayout(jPanelInteractionArea);
        jPanelInteractionArea.setLayout(jPanelInteractionAreaLayout);
        jPanelInteractionAreaLayout.setHorizontalGroup(
            jPanelInteractionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMessageOfScore, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInteractionAreaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAdvice1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTryAgain)
                .addContainerGap())
            .addComponent(jLabelScoreShower, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelInteractionAreaLayout.setVerticalGroup(
            jPanelInteractionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInteractionAreaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelScoreShower, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMessageOfScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addGroup(jPanelInteractionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTryAgain)
                    .addComponent(jLabelAdvice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInteractionArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelInteractionArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTryAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTryAgainActionPerformed
        // TODO add your handling code here:
        new SplashScreen().setVisible( true );
        this.dispose();
    }//GEN-LAST:event_jButtonTryAgainActionPerformed

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
            java.util.logging.Logger.getLogger(EndScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EndScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EndScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EndScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EndScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonTryAgain;
    private javax.swing.JLabel jLabelAdvice1;
    private javax.swing.JLabel jLabelMessageOfScore;
    private javax.swing.JLabel jLabelScore;
    private javax.swing.JLabel jLabelScoreShower;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelInteractionArea;
    private javax.swing.JPanel jPanelMain;
    // End of variables declaration//GEN-END:variables
}
