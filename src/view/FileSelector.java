package view;

import java.awt.Frame;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import controller.App;
import javax.swing.JOptionPane;

/**
 *
 * @author Arístides Pérez
 */
public class FileSelector extends javax.swing.JFrame {

    private File chosenFile;
    private int result;

    /**
     * Creates new form NewJFrame
     */
    public FileSelector() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        wordIcon = new javax.swing.JLabel();
        path = new javax.swing.JTextField();
        pathSep = new javax.swing.JSeparator();
        fileChoose = new javax.swing.JButton();
        continueButton = new javax.swing.JButton();
        titleBar = new javax.swing.JPanel();
        exitButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Main.setBackground(new java.awt.Color(255, 252, 255));
        Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Montserrat Medium", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("¡Sube tu Archivo!");
        Main.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 220, 70));

        wordIcon.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        wordIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/scrabble.png"))); // NOI18N
        Main.add(wordIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 80, -1));

        path.setText("Ruta del Archivo");
        path.setBorder(null);
        path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathActionPerformed(evt);
            }
        });
        path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pathKeyTyped(evt);
            }
        });
        Main.add(path, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 170, 20));

        pathSep.setBackground(new java.awt.Color(255, 255, 255));
        pathSep.setForeground(new java.awt.Color(0, 0, 0));
        Main.add(pathSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 200, 20));

        fileChoose.setBackground(new java.awt.Color(255, 110, 66));
        fileChoose.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        fileChoose.setForeground(new java.awt.Color(255, 255, 255));
        fileChoose.setText("...");
        fileChoose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fileChoose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fileChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooseActionPerformed(evt);
            }
        });
        Main.add(fileChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 20, 20));

        continueButton.setBackground(new java.awt.Color(255, 110, 66));
        continueButton.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        continueButton.setForeground(new java.awt.Color(255, 255, 255));
        continueButton.setText("Continuar");
        continueButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        continueButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });
        Main.add(continueButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 200, 30));

        titleBar.setBackground(new java.awt.Color(255, 255, 255));
        titleBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitButton.setFont(new java.awt.Font("sansserif", 0, 22)); // NOI18N
        exitButton.setForeground(new java.awt.Color(51, 51, 51));
        exitButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitButton.setText("X");
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });
        titleBar.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 40, 40));

        minimizeButton.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        minimizeButton.setForeground(new java.awt.Color(51, 51, 51));
        minimizeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizeButton.setText("-");
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });
        titleBar.add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 30, 40));

        Main.add(titleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed

        boolean success = App.sendFileData(path.getText());

        if (success) {
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Error: verifica que tu archivo no está vacío o la ruta es correcta, además de contener la estructura correcta");
        }
    }//GEN-LAST:event_continueButtonActionPerformed

    private void pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathActionPerformed
        continueButtonActionPerformed(evt);
    }//GEN-LAST:event_pathActionPerformed

    private void fileChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooseActionPerformed
        JFileChooser jf = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Texto (.txt)", "txt");
        jf.setAcceptAllFileFilterUsed(false);
        jf.addChoosableFileFilter(filter);

        result = jf.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            chosenFile = jf.getSelectedFile();
            path.setText(chosenFile.getAbsolutePath());
        }
    }//GEN-LAST:event_fileChooseActionPerformed

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_exitButtonMouseClicked

    private void pathKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pathKeyTyped
        if (path.getText().equals("Ruta del Archivo")) {
            path.setText("");
        }
    }//GEN-LAST:event_pathKeyTyped

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Main;
    private javax.swing.JButton continueButton;
    private javax.swing.JLabel exitButton;
    private javax.swing.JButton fileChoose;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JTextField path;
    private javax.swing.JSeparator pathSep;
    private javax.swing.JLabel title;
    private javax.swing.JPanel titleBar;
    private javax.swing.JLabel wordIcon;
    // End of variables declaration//GEN-END:variables
}
