/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// 4/1/2015 - Checks if guesses are real words

package lingo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Daren
 */
public class LingoUI extends javax.swing.JFrame {

    /**
     * Creates new form LingoUI
     */
    public LingoUI() {
        initComponents();
        readWords();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();
        newGameButton = new javax.swing.JButton();
        rulesButton = new javax.swing.JButton();
        guessTextField = new javax.swing.JTextField();
        helpLabel = new javax.swing.JLabel();
        cluesTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        titleLabel.setText("Lingo");

        quitButton.setText("Quit");
        quitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitButtonMouseClicked(evt);
            }
        });

        newGameButton.setText("New Game");
        newGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newGameButtonMouseClicked(evt);
            }
        });

        rulesButton.setText("Rules");
        rulesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rulesButtonMouseClicked(evt);
            }
        });

        guessTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        guessTextField.setToolTipText(null);
        guessTextField.setEnabled(false);
        guessTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessTextFieldActionPerformed(evt);
            }
        });

        helpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cluesTextArea.setEditable(false);
        cluesTextArea.setColumns(20);
        cluesTextArea.setRows(5);
        cluesTextArea.setMaximumSize(new java.awt.Dimension(4, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(quitButton)
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(rulesButton)
                                .addGap(83, 83, 83)
                                .addComponent(newGameButton))
                            .addComponent(titleLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cluesTextArea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(guessTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(helpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(26, 26, 26)
                .addComponent(cluesTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guessTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(helpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quitButton)
                    .addComponent(newGameButton)
                    .addComponent(rulesButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_quitButtonMouseClicked

    private void newGameButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newGameButtonMouseClicked
        
        int wsize = words.size();
        
        Random rand = new Random();
        
        int randNum = rand.nextInt(wsize);
        
        word = words.get(randNum);
        
        clue = word.substring(0,1) + " _ _ _ _";
        
        this.cluesTextArea.setText(clue);
        
        this.cluesTextArea.setRequestFocusEnabled(false);
        
        this.guessTextField.setEnabled(true);
        
        this.helpLabel.setText("");
        
        this.guessLeft = 5;
        
        this.guessTextField.requestFocus();
        
    }//GEN-LAST:event_newGameButtonMouseClicked

    private void guessTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessTextFieldActionPerformed
        
        helpLabel.setText("");
        
        if(guessTextField.getText().equals(""))
        {
            helpLabel.setText("Please enter a guess");
            return;
        }
        
        guess = guessTextField.getText();
        
        guessTextField.setText("");
        
        guess = guess.trim();
        
        if(guess.length() != 5)
        {
            helpLabel.setText("Guess must be 5 letters long");
            return;
        }
        else if(!words.contains(guess))
        {
            helpLabel.setText("Guess must be a real word");
            return;
        }
        
        if(guess.equals(word))
        {
            helpLabel.setText("You won! The word was " + word);
            this.guessTextField.setEnabled(false);
            this.cluesTextArea.append("\n" +
                                      "[" + word.substring(0,1) + "]" +
                                      "[" + word.substring(1,2) + "]" +
                                      "[" + word.substring(2,3) + "]" +
                                      "[" + word.substring(3,4) + "]" +
                                      "[" + word.substring(4,5) + "]");
            return;
        }
        
        clue = "";
        
        for(int i = 0; i < word.length(); i++)
        {
            
            String wlet = word.substring(i,i+1);
            String glet = guess.substring(i,i+1);
            
            if(wlet.equals(glet))
            {
                clue = clue + "[" + glet + "] ";
            }
            else if(word.indexOf(glet, 1) >= 0)
            {
                clue = clue + "(" + glet + ") ";
            }
            else
            {
                clue = clue + glet + " ";
            }
            
        }
        
        this.cluesTextArea.append("\n" + clue);
        
        guessLeft--;
        
        if(guessLeft == 0)
        {
            this.helpLabel.setText("Sorry, You lost! The word was " + word);
            this.guessTextField.setEnabled(false);
        }
        
    }//GEN-LAST:event_guessTextFieldActionPerformed

    private void rulesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rulesButtonMouseClicked
        helpLabel.setText("You know the rules!");
    }//GEN-LAST:event_rulesButtonMouseClicked

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
            java.util.logging.Logger.getLogger(LingoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LingoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LingoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LingoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LingoUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea cluesTextArea;
    private javax.swing.JTextField guessTextField;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JButton newGameButton;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton rulesButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    
    ArrayList<String> words = null;
    String word = "";
    String guess = "";
    String clue = "";
    int guessLeft = 4;
    
    private void readWords()
    {
        BufferedReader br = null;
        
        words = new ArrayList<>();
        
        String tempWord = "";
        
        this.cluesTextArea.setText("");
        
        try{
            br = new BufferedReader(new FileReader("lingowords.txt"));
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.toString());
        }
        
        try
        {
            if(br != null)
            {
                while((tempWord = br.readLine()) != null)
                {
                    words.add(tempWord);
                }
            }
        }
        catch(java.io.IOException ex)
        {
            System.out.println(ex.toString());
        }
    }

}
