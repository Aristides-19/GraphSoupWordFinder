package view;

import java.awt.Frame;

/**
 * A help guide GUI for the user (?)
 *
 * @author Arístides Pérez
 */
public class Help extends javax.swing.JFrame {
    private final Menu menuGUI;
    /**
     * Creates new form Help
     * @param menuGUI menu user interface
     */
    public Help(Menu menuGUI) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.menuGUI = menuGUI;
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

        Main = new javax.swing.JPanel();
        titleBar = new javax.swing.JPanel();
        exitButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        icon = new javax.swing.JLabel();
        scrollText = new javax.swing.JScrollPane();
        textInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Main.setBackground(new java.awt.Color(255, 255, 255));
        Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleBar.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout titleBarLayout = new javax.swing.GroupLayout(titleBar);
        titleBar.setLayout(titleBarLayout);
        titleBarLayout.setHorizontalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleBarLayout.createSequentialGroup()
                .addContainerGap(356, Short.MAX_VALUE)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        titleBarLayout.setVerticalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addGroup(titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Main.add(titleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 40));

        backButton.setBackground(new java.awt.Color(255, 110, 66));
        backButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Volver al Menú");
        backButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        Main.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 180, 30));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/scrabble.png"))); // NOI18N
        Main.add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        scrollText.setBorder(null);
        scrollText.setFocusable(false);

        textInfo.setEditable(false);
        textInfo.setBackground(new java.awt.Color(255, 255, 255));
        textInfo.setColumns(20);
        textInfo.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        textInfo.setForeground(new java.awt.Color(51, 51, 51));
        textInfo.setLineWrap(true);
        textInfo.setRows(5);
        textInfo.setText("El programa está diseñado para resolver una sopa de letras utilizando algoritmos de recorrido de grafos, Depth y Breath First Search. Esta ventana sirve como guía de usuario para utilizar la interfaz.\n\n1. Buscar Palabras: para buscar un sola palabra debes seleccionar una palabra del diccionario y elegir un algoritmo, luego se mostrarán los recorridos para encontrar la palabra. Para encontrar todas las palabras, no se muestra el recorrido.\n\n2. Agregar Palabras al Diccionario: la palabra debe tener al menos 3 letras, sin caracter especial y no estar en el diccionario actual.\n\n3. Actualizar Archivo: permite actualizar el archivo texto cargado por el usuario con el diccionario actual.\n\n- Arístides Pérez y Jesús Duarte.");
        textInfo.setWrapStyleWord(true);
        textInfo.setBorder(null);
        scrollText.setViewportView(textInfo);

        Main.add(scrollText, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 340, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        this.setVisible(false);
        this.dispose();
        menuGUI.setVisible(true);
    }//GEN-LAST:event_exitButtonMouseClicked

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);
        this.dispose();
        menuGUI.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Main;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JScrollPane scrollText;
    private javax.swing.JTextArea textInfo;
    private javax.swing.JPanel titleBar;
    // End of variables declaration//GEN-END:variables
}
