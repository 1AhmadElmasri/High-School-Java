/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerformanceTask;

import ca.hdsb.gwss.ahmad.ics3u.u6.ArrayUtil;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

/**
 *
 * @author 1elmasriahm
 */
public class QuestionScreen extends javax.swing.JFrame {

    /**
     * Creates new form QuestionScreenRadioButton
     */
    File file;
    Document doc;
    Builder builder;
    Element root;
    Elements answerList;
    Element question;
    Element answerHolder;
    int randomChoiceQuestion;
    int randomChoiceAnswer;
    String holderOfValue;
    int[] answerChoices;
    int[] questionChoices;
    int position = 0;

    public void questionSetter(Element root) {
        if (position < 5) {
            position++;
            Element correctAnswer, answer1, answer2, answer3;
            int positionHolder;
            int positionInArray = 0;

            randomChoiceQuestion = (int) (Math.random() * root.getChildElements().size());
            question = root.getChildElements().get(randomChoiceQuestion);

            holderOfValue = question.getFirstChildElement("name").getValue();
            jLabelQuestion.setText(holderOfValue);

            randomChoiceAnswer = (int) (Math.random() * 3);
            switch (randomChoiceAnswer) {
                case 0:
                    jToggleButtonAnswer1.setText(question.getFirstChildElement("answerList").getChildElements().get(0).getValue());
                    jToggleButtonAnswer2.setText(question.getFirstChildElement("answerList").getChildElements().get(1).getValue());
                    jToggleButtonAnswer3.setText(question.getFirstChildElement("answerList").getChildElements().get(3).getValue());
                    jToggleButtonAnswer4.setText(question.getFirstChildElement("answerList").getChildElements().get(2).getValue());
                    System.out.println(randomChoiceAnswer);
                    break;
                case 1:
                    jToggleButtonAnswer1.setText(question.getFirstChildElement("answerList").getChildElements().get(1).getValue());
                    jToggleButtonAnswer2.setText(question.getFirstChildElement("answerList").getChildElements().get(0).getValue());
                    jToggleButtonAnswer3.setText(question.getFirstChildElement("answerList").getChildElements().get(3).getValue());
                    jToggleButtonAnswer4.setText(question.getFirstChildElement("answerList").getChildElements().get(2).getValue());
                    System.out.println(randomChoiceAnswer);
                    break;
                case 2:
                    jToggleButtonAnswer1.setText(question.getFirstChildElement("answerList").getChildElements().get(3).getValue());
                    jToggleButtonAnswer2.setText(question.getFirstChildElement("answerList").getChildElements().get(1).getValue());
                    jToggleButtonAnswer3.setText(question.getFirstChildElement("answerList").getChildElements().get(0).getValue());
                    jToggleButtonAnswer4.setText(question.getFirstChildElement("answerList").getChildElements().get(2).getValue());
                    System.out.println(randomChoiceAnswer);
                    break;
                case 3:
                    jToggleButtonAnswer1.setText(question.getFirstChildElement("answerList").getChildElements().get(1).getValue());
                    jToggleButtonAnswer2.setText(question.getFirstChildElement("answerList").getChildElements().get(3).getValue());
                    jToggleButtonAnswer3.setText(question.getFirstChildElement("answerList").getChildElements().get(2).getValue());
                    jToggleButtonAnswer4.setText(question.getFirstChildElement("answerList").getChildElements().get(0).getValue());
                    System.out.println(randomChoiceAnswer);
                    break;
            }
        }else{
            System.out.println("limit");
        }

    }

    public QuestionScreen() throws ParsingException, ValidityException, IOException {
        initComponents();
        builder = new Builder();
        file = new File("Questions.xml");
        doc = builder.build(file);
        root = doc.getRootElement();

        questionSetter(root);
        jToggleButtonAnswer1.setPreferredSize(new Dimension(400, 10));

        int[] questionList = new int[5];
        ArrayUtil.generateRandomArrayNoDuplicates(questionList, 0, root.getChildElements().size());
        ArrayUtil.displayArray(questionList);

    }

    QuestionScreen(SplashScreen aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMainArea = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jPanelTestArea = new javax.swing.JPanel();
        jLabelQuestionNumber = new javax.swing.JLabel();
        jLabelQuestion = new javax.swing.JLabel();
        jToggleButtonAnswer2 = new javax.swing.JToggleButton();
        jToggleButtonAnswer1 = new javax.swing.JToggleButton();
        jToggleButtonAnswer3 = new javax.swing.JToggleButton();
        jToggleButtonAnswer4 = new javax.swing.JToggleButton();
        jLabelAnswer1 = new javax.swing.JLabel();
        jLabelAnswer2 = new javax.swing.JLabel();
        jLabelAnswer3 = new javax.swing.JLabel();
        jLabelAnswer4 = new javax.swing.JLabel();
        jLabelScoreCount = new javax.swing.JLabel();
        jLabelScoreLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelCorrecter = new javax.swing.JLabel();
        jLabelCorrectAnswerDisplayer = new javax.swing.JLabel();
        jLabelCorrecter1 = new javax.swing.JLabel();
        jButtonNextQuestion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Test Screen");

        jPanelMainArea.setBackground(new java.awt.Color(73, 71, 104));
        jPanelMainArea.setForeground(new java.awt.Color(53, 65, 108));

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(174, 174, 174));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Computer Science Test");

        jLabelQuestionNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelQuestionNumber.setText("Q 1:");

        jLabelQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelQuestion.setText("What do you use to get the value stored in the first child element in element \"storage\"");

        jToggleButtonAnswer2.setText("Ryan Gosling");
        jToggleButtonAnswer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonAnswer2ActionPerformed(evt);
            }
        });

        jToggleButtonAnswer1.setText("A representation of what the code will do without writing out any of the syntax");
        jToggleButtonAnswer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonAnswer1ActionPerformed(evt);
            }
        });

        jToggleButtonAnswer3.setText("Sun MicroSystems");
        jToggleButtonAnswer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonAnswer3ActionPerformed(evt);
            }
        });

        jToggleButtonAnswer4.setText("The Bermuda Triangle");
        jToggleButtonAnswer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonAnswer4ActionPerformed(evt);
            }
        });

        jLabelAnswer1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAnswer1.setText("1 :");

        jLabelAnswer2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAnswer2.setText("2 :");

        jLabelAnswer3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAnswer3.setText("3 :");

        jLabelAnswer4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAnswer4.setText("4 :");

        javax.swing.GroupLayout jPanelTestAreaLayout = new javax.swing.GroupLayout(jPanelTestArea);
        jPanelTestArea.setLayout(jPanelTestAreaLayout);
        jPanelTestAreaLayout.setHorizontalGroup(
            jPanelTestAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTestAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTestAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelQuestionNumber)
                    .addComponent(jLabelAnswer1)
                    .addComponent(jLabelAnswer2)
                    .addComponent(jLabelAnswer3)
                    .addComponent(jLabelAnswer4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTestAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelQuestion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButtonAnswer1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButtonAnswer2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButtonAnswer3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButtonAnswer4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelTestAreaLayout.setVerticalGroup(
            jPanelTestAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTestAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTestAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuestionNumber)
                    .addComponent(jLabelQuestion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTestAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAnswer1))
                .addGap(18, 18, 18)
                .addGroup(jPanelTestAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAnswer2))
                .addGap(18, 18, 18)
                .addGroup(jPanelTestAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAnswer3))
                .addGap(18, 18, 18)
                .addGroup(jPanelTestAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonAnswer4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAnswer4))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabelScoreCount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelScoreCount.setForeground(new java.awt.Color(176, 176, 176));
        jLabelScoreCount.setText("0");

        jLabelScoreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelScoreLabel.setForeground(new java.awt.Color(176, 176, 176));
        jLabelScoreLabel.setText("Score : ");

        jButton1.setText("End Test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelCorrecter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCorrecter.setForeground(new java.awt.Color(176, 176, 176));
        jLabelCorrecter.setText("Correct Answer: ");

        jLabelCorrectAnswerDisplayer.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabelCorrectAnswerDisplayer.setForeground(new java.awt.Color(176, 176, 176));
        jLabelCorrectAnswerDisplayer.setText("This is the Correct Answer");

        jLabelCorrecter1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCorrecter1.setForeground(new java.awt.Color(176, 176, 176));
        jLabelCorrecter1.setText("Correct / Wrong");

        jButtonNextQuestion.setText("Next Question");
        jButtonNextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextQuestionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainAreaLayout = new javax.swing.GroupLayout(jPanelMainArea);
        jPanelMainArea.setLayout(jPanelMainAreaLayout);
        jPanelMainAreaLayout.setHorizontalGroup(
            jPanelMainAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelMainAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTestArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelMainAreaLayout.createSequentialGroup()
                        .addComponent(jLabelScoreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelScoreCount)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCorrecter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCorrectAnswerDisplayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNextQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanelMainAreaLayout.createSequentialGroup()
                        .addComponent(jLabelCorrecter1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelMainAreaLayout.setVerticalGroup(
            jPanelMainAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainAreaLayout.createSequentialGroup()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCorrecter1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTestArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelScoreLabel)
                    .addComponent(jLabelScoreCount)
                    .addComponent(jButton1)
                    .addComponent(jLabelCorrecter)
                    .addComponent(jLabelCorrectAnswerDisplayer)
                    .addComponent(jButtonNextQuestion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMainArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMainArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonAnswer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonAnswer2ActionPerformed
        // TODO add your handling code here:
        jToggleButtonAnswer1.setSelected(false);
        jToggleButtonAnswer3.setSelected(false);
        jToggleButtonAnswer4.setSelected(false);
    }//GEN-LAST:event_jToggleButtonAnswer2ActionPerformed

    private void jToggleButtonAnswer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonAnswer1ActionPerformed
        // TODO add your handling code here:
        jToggleButtonAnswer2.setSelected(false);
        jToggleButtonAnswer3.setSelected(false);
        jToggleButtonAnswer4.setSelected(false);
    }//GEN-LAST:event_jToggleButtonAnswer1ActionPerformed

    private void jToggleButtonAnswer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonAnswer3ActionPerformed
        // TODO add your handling code here:
        jToggleButtonAnswer2.setSelected(false);
        jToggleButtonAnswer1.setSelected(false);
        jToggleButtonAnswer4.setSelected(false);
    }//GEN-LAST:event_jToggleButtonAnswer3ActionPerformed

    private void jToggleButtonAnswer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonAnswer4ActionPerformed
        // TODO add your handling code here:
        jToggleButtonAnswer2.setSelected(false);
        jToggleButtonAnswer3.setSelected(false);
        jToggleButtonAnswer1.setSelected(false);
    }//GEN-LAST:event_jToggleButtonAnswer4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new EndScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonNextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextQuestionActionPerformed
        // TODO add your handling code here:
        questionSetter(root);
    }//GEN-LAST:event_jButtonNextQuestionActionPerformed

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
            java.util.logging.Logger.getLogger(QuestionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QuestionScreen().setVisible(true);
                } catch (ParsingException ex) {
                    Logger.getLogger(QuestionScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(QuestionScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonNextQuestion;
    private javax.swing.JLabel jLabelAnswer1;
    private javax.swing.JLabel jLabelAnswer2;
    private javax.swing.JLabel jLabelAnswer3;
    private javax.swing.JLabel jLabelAnswer4;
    private javax.swing.JLabel jLabelCorrectAnswerDisplayer;
    private javax.swing.JLabel jLabelCorrecter;
    private javax.swing.JLabel jLabelCorrecter1;
    private javax.swing.JLabel jLabelQuestion;
    private javax.swing.JLabel jLabelQuestionNumber;
    private javax.swing.JLabel jLabelScoreCount;
    private javax.swing.JLabel jLabelScoreLabel;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelMainArea;
    private javax.swing.JPanel jPanelTestArea;
    private javax.swing.JToggleButton jToggleButtonAnswer1;
    private javax.swing.JToggleButton jToggleButtonAnswer2;
    private javax.swing.JToggleButton jToggleButtonAnswer3;
    private javax.swing.JToggleButton jToggleButtonAnswer4;
    // End of variables declaration//GEN-END:variables
}
