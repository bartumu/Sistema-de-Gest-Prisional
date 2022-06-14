/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import CONTROLLER.UsuarioController;
import MODEL.Bloco;
import MODEL.Funcao;
import MODEL.Funcionario;
import MODEL.Turno;
import MODEL.Usuario;
import java.awt.CardLayout;
import java.awt.Color;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Melhor De Mim
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    Usuario user = new Usuario();
    Funcionario f = new Funcionario();
    Funcao func = new Funcao();
    UsuarioController uController = new UsuarioController();
    Color defaultColor, ClickedColor, white;
    CardLayout cardLayout;

    public Login() {
        initComponents();
//        lblimg.setIcon(new javax.swing.ImageIcon(""));
        cardLayout = (CardLayout) (pnlCards.getLayout());
        cardLayout.show(pnlCards, "SenhaPanel");
        defaultColor = new Color(204, 255, 204);
        ClickedColor = new Color(60, 179, 113);
        white = new Color(255, 255, 255);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginConf = new javax.swing.JFrame();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        lblimg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlCards = new javax.swing.JPanel();
        NovaSenhaPanel = new javax.swing.JPanel();
        txtNovaSenha = new javax.swing.JPasswordField();
        txtUsuarioNovaSenha = new javax.swing.JTextField();
        txtConfNovaSenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        SenhaPanel = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnFechar = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();

        LoginConf.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        LoginConf.setUndecorated(true);

        javax.swing.GroupLayout LoginConfLayout = new javax.swing.GroupLayout(LoginConf.getContentPane());
        LoginConf.getContentPane().setLayout(LoginConfLayout);
        LoginConfLayout.setHorizontalGroup(
            LoginConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );
        LoginConfLayout.setVerticalGroup(
            LoginConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema De Gestão Prisional");
        setMinimumSize(new java.awt.Dimension(519, 332));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(519, 332));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(60, 179, 113));

        lblimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Icons-Bencao-04.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        jLabel3.setText("S I S T G P");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lblimg))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lblimg, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(300, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        pnlCards.setLayout(new java.awt.CardLayout());

        NovaSenhaPanel.setBackground(new java.awt.Color(204, 255, 204));
        NovaSenhaPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNovaSenha.setBackground(new java.awt.Color(204, 255, 204));
        txtNovaSenha.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtNovaSenha.setText("jPasswordField1");
        txtNovaSenha.setBorder(null);
        NovaSenhaPanel.add(txtNovaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 160, -1));

        txtUsuarioNovaSenha.setBackground(new java.awt.Color(204, 255, 204));
        txtUsuarioNovaSenha.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtUsuarioNovaSenha.setText("Usuario");
        txtUsuarioNovaSenha.setBorder(null);
        NovaSenhaPanel.add(txtUsuarioNovaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 160, -1));

        txtConfNovaSenha.setBackground(new java.awt.Color(204, 255, 204));
        txtConfNovaSenha.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtConfNovaSenha.setText("jPasswordField1");
        txtConfNovaSenha.setBorder(null);
        NovaSenhaPanel.add(txtConfNovaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 160, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel7.setText("Criar Senha");
        NovaSenhaPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 110, 60));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        NovaSenhaPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 170, 10));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        NovaSenhaPanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 170, 10));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        NovaSenhaPanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 170, 10));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        NovaSenhaPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 30, 30));

        jButton9.setBackground(new java.awt.Color(204, 255, 204));
        jButton9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton9.setText("Entrar");
        jButton9.setBorder(new com.formdev.flatlaf.ui.FlatRoundBorder());
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        NovaSenhaPanel.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 100, 30));

        pnlCards.add(NovaSenhaPanel, "NovaSenhaPanel");

        SenhaPanel.setBackground(new java.awt.Color(204, 255, 204));

        txtUsuario.setBackground(new java.awt.Color(204, 255, 204));
        txtUsuario.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtUsuario.setText("Usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
        });

        txtSenha.setBackground(new java.awt.Color(204, 255, 204));
        txtSenha.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtSenha.setText("Senha");
        txtSenha.setBorder(null);
        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenhaFocusGained(evt);
            }
        });
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));

        btnFechar.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnFechar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFechar.setText("X");
        btnFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFecharMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFecharMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnFecharMouseReleased(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(204, 255, 204));
        jButton10.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton10.setText("Entrar");
        jButton10.setBorder(new com.formdev.flatlaf.ui.FlatEmptyBorder());
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout SenhaPanelLayout = new javax.swing.GroupLayout(SenhaPanel);
        SenhaPanel.setLayout(SenhaPanelLayout);
        SenhaPanelLayout.setHorizontalGroup(
            SenhaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SenhaPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(SenhaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSenha)
                    .addComponent(jSeparator1)
                    .addComponent(txtUsuario)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SenhaPanelLayout.createSequentialGroup()
                .addContainerGap(256, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(254, 254, 254))
            .addGroup(SenhaPanelLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SenhaPanelLayout.setVerticalGroup(
            SenhaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SenhaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFechar)
                .addGap(75, 75, 75)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        pnlCards.add(SenhaPanel, "SenhaPanel");

        jSplitPane1.setRightComponent(pnlCards);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed

    }//GEN-LAST:event_txtSenhaActionPerformed

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnFecharMouseClicked

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        txtUsuario.setText("");
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusGained
        txtSenha.setText("");
    }//GEN-LAST:event_txtSenhaFocusGained

    private void btnFecharMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMousePressed
        btnFechar.setBackground(ClickedColor);
    }//GEN-LAST:event_btnFecharMousePressed

    private void btnFecharMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseReleased
        btnFechar.setBackground(defaultColor);
    }//GEN-LAST:event_btnFecharMouseReleased

    private void GuardarDataAcesso(Usuario u, String nome, String senha) {
        u.setAcesso(LocalDateTime.now().toLocalDate().toString());
        u.setNome(nome);
        u.setSenha(senha);
        uController.Actualizar(u);
    }

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
        String numBI = uController.find(user).get(0).getNumBI().getNumBI();
        String Acesso = uController.find(user).get(0).getAcesso();

//        Usuario recebe os novos valores, Mas primeiro Verifica se as novas senhas estão Corretas
        if (txtNovaSenha.getText().equals(txtConfNovaSenha.getText())) {
            user.setNome(txtUsuarioNovaSenha.getText());
            user.setSenha(txtNovaSenha.getText());
            f.setNumBI(numBI);
            user.setNumBI(f);

//        Atualizar a Nova Senha
            if (Acesso == null) {
                uController.Actualizar(user);
            }
//        Verificar o tipo de usuario a logar
            switch (uController.Logar(user)) {
                case 0 -> {
                    uController.GuardarAcessoAdm(user);
                    dispose();
                    new AdminHome().setVisible(true);
                }
                case 1 -> {
                    GuardarDataAcesso(user, txtUsuario.getText(), txtSenha.getText());
                    dispose();
                    var f = new Funcionario();
                    uController.findEspecificFuncionario(user, f);
                    new Home(f).setVisible(true);
                }
                case 2 -> {
                    GuardarDataAcesso(user, txtUsuario.getText(), txtSenha.getText());
                    dispose();
                    var f = new Funcionario();
                    var t = new Turno();
                    uController.findEspecificFuncionario(user, f, t);
                    if (uController.findEspecificFuncionario(user, f, t) != null) {
                        new GHome(f).setVisible(true);
                    }else{ 
                        JOptionPane.showMessageDialog(null, "Ainda Não Foi Escalado"); 
                        new Login().setVisible(true);
                    }
                }
                default ->
                    JOptionPane.showMessageDialog(null, "Senha Ou Usuario Errado");
            }

        } else {
            JOptionPane.showMessageDialog(null, "As Senhas são Diferentes");
        }
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:

        user.setNome(txtUsuario.getText());
        user.setSenha(txtSenha.getText());

        switch (uController.Logar(user)) {
            case 0 -> {
                //            Carregar o Criar Nova Senha
                txtUsuarioNovaSenha.setText(user.getNome());
                txtNovaSenha.setText(user.getSenha());
                txtConfNovaSenha.setText(user.getSenha());
//            Verificar pela BD se é o primeiro acesso ao sistema

                if (uController.find(user).get(0).getAcesso() == null) {
                    cardLayout.show(pnlCards, "NovaSenhaPanel");
                } else {
                    uController.GuardarAcessoAdm(user);
                    dispose();
                    new AdminHome().setVisible(true);
                }
            }
            case 1 -> {
                //            Carregar o Criar Nova Senha
                txtUsuarioNovaSenha.setText(user.getNome());
                txtNovaSenha.setText(user.getSenha());
                txtConfNovaSenha.setText(user.getSenha());
//            Verificar pela BD se é o primeiro acesso ao sistema

                if (uController.find(user).get(0).getAcesso() == null) {
                    cardLayout.show(pnlCards, "NovaSenhaPanel");
                } else {
                    String numBI = uController.find(user).get(0).getNumBI().getNumBI();
                    f.setNumBI(numBI);
                    user.setNumBI(f);
                    GuardarDataAcesso(user, txtUsuario.getText(), txtSenha.getText());
                    dispose();
                    var f = new Funcionario();
                    uController.findEspecificFuncionario(user, f);
                    new Home(f).setVisible(true);
                }
            }
            case 2 -> {
                //            Carregar o Criar Nova Senha
                txtUsuarioNovaSenha.setText(user.getNome());
                txtNovaSenha.setText(user.getSenha());
                txtConfNovaSenha.setText(user.getSenha());
//            Verificar pela BD se é o primeiro acesso ao sistema

                if (uController.find(user).get(0).getAcesso() == null) {
                    cardLayout.show(pnlCards, "NovaSenhaPanel");
                } else {
                    String numBI = uController.find(user).get(0).getNumBI().getNumBI();
                    f.setNumBI(numBI);
                    user.setNumBI(f);
                    GuardarDataAcesso(user, txtUsuario.getText(), txtSenha.getText());
                    dispose();
                    var f = new Funcionario();
                    var t = new Turno();
                    uController.findEspecificFuncionario(user, f, t);
                    if (uController.findEspecificFuncionario(user, f, t) != null) {
                        new GHome(f).setVisible(true);
                    }else{ 
                        JOptionPane.showMessageDialog(null, "Ainda Não Foi Escalado"); 
                        new Login().setVisible(true);
                    }
                }
            }
            default ->
                JOptionPane.showMessageDialog(null, "Senha Ou Usuario Errado");
        }
        /*
//        Verificar o tipo de usuario a logar
        if (uController.Logar(user) == 0) {

//            Carregar o Criar Nova Senha
            txtUsuarioNovaSenha.setText(user.getNome());
            txtNovaSenha.setText(user.getSenha());
            txtConfNovaSenha.setText(user.getSenha());
//            Verificar pela BD se é o primeiro acesso ao sistema

            if (uController.find(user).get(0).getAcesso() == null) {
                cardLayout.show(pnlCards, "NovaSenhaPanel");
            } else {
                GuardarDataAcesso(user, txtUsuario.getText(), txtSenha.getText());
                dispose();
                new AdminHome().setVisible(true);
            }
        } else if (uController.Logar(user) == 1) {

//            Carregar o Criar Nova Senha
            txtUsuarioNovaSenha.setText(user.getNome());
            txtNovaSenha.setText(user.getSenha());
            txtConfNovaSenha.setText(user.getSenha());
//            Verificar pela BD se é o primeiro acesso ao sistema

            if (uController.find(user).get(0).getAcesso() == null) {
                cardLayout.show(pnlCards, "NovaSenhaPanel");
            } else {
                GuardarDataAcesso(user, txtUsuario.getText(), txtSenha.getText());
                dispose();
                var f = new Funcionario();
                uController.findEspecificFuncionario(user, f);
                new Home(f).setVisible(true);
            }
        }
        if (uController.Logar(user) == 2) {

//            Carregar o Criar Nova Senha
            txtUsuarioNovaSenha.setText(user.getNome());
            txtNovaSenha.setText(user.getSenha());
            txtConfNovaSenha.setText(user.getSenha());
//            Verificar pela BD se é o primeiro acesso ao sistema

            if (uController.find(user).get(0).getAcesso() == null) {
                cardLayout.show(pnlCards, "NovaSenhaPanel");
            } else {
                GuardarDataAcesso(user, txtUsuario.getText(), txtSenha.getText());
                dispose();
                var f = new Funcionario();
                uController.findEspecificFuncionario(user, f);
                new GHome(f).setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senha Ou Usuario Errado");
        } */

    }//GEN-LAST:event_jButton10MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame LoginConf;
    private javax.swing.JPanel NovaSenhaPanel;
    private javax.swing.JPanel SenhaPanel;
    private javax.swing.JLabel btnFechar;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblimg;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JPasswordField txtConfNovaSenha;
    private javax.swing.JPasswordField txtNovaSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuarioNovaSenha;
    // End of variables declaration//GEN-END:variables
}
