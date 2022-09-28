/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process_sa.GUI;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import process_sa.controller.Controlador;
import process_sa.models.Usuario;

/**
 *
 * @author cvale
 */
public class Menu extends javax.swing.JFrame {
    DefaultTableModel model;
    /**
     * Creates new form CrearUsuario
     */
    public Menu() {
        initComponents();
        
        setTitle("Process SA - Menú");
        setResizable(false);
        
        String[] titulos = {"id","usuario","contraseña","rol"};
        model = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblUsuarioRol.setModel(model);
        
        mostrarDatos();
    }
    
    public void mostrarDatos(){
        Controlador conn = new Controlador();
        
        try {
            final List<Usuario> listaUsuario = conn.getUsuarios();
            for (Usuario listaUsuarios : listaUsuario) {
                Object[] o = new Object[4];
                o[0] = listaUsuarios.getId();
                o[1] = listaUsuarios.getNombre_usuario();
                o[2] = listaUsuarios.getContraseña();
                o[3] = conn.getRolUsuario(listaUsuarios.getId_rol());
                //o[3] = listaUsuarios.getRol();
                model.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        conn.desconectar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarioRol = new javax.swing.JTable();
        MenuBar = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();
        usuarioMenu = new javax.swing.JMenu();
        crudUsuario = new javax.swing.JMenuItem();
        rolMenu = new javax.swing.JMenu();
        crudRol = new javax.swing.JMenuItem();
        personaMenu = new javax.swing.JMenu();
        crudPersona = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUsuarioRol.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUsuarioRol);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 370, 190));

        getContentPane().add(panelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 280));

        mainMenu.setText("Menú");

        menuInicio.setText("Inicio");
        menuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInicioActionPerformed(evt);
            }
        });
        mainMenu.add(menuInicio);

        logout.setText("Finalizar sesión");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        mainMenu.add(logout);

        MenuBar.add(mainMenu);

        usuarioMenu.setText("Usuario");

        crudUsuario.setText("CRUD Usuario");
        crudUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudUsuarioActionPerformed(evt);
            }
        });
        usuarioMenu.add(crudUsuario);

        MenuBar.add(usuarioMenu);

        rolMenu.setText("Rol");

        crudRol.setText("CRUD Rol");
        crudRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudRolActionPerformed(evt);
            }
        });
        rolMenu.add(crudRol);

        MenuBar.add(rolMenu);

        personaMenu.setText("Persona");

        crudPersona.setText("CRUD Persona");
        crudPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudPersonaActionPerformed(evt);
            }
        });
        personaMenu.add(crudPersona);

        MenuBar.add(personaMenu);

        setJMenuBar(MenuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void crudUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudUsuarioActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CRUD_Usuario cu = new CRUD_Usuario();
        cu.setVisible(true);
    }//GEN-LAST:event_crudUsuarioActionPerformed

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Menu mn = new Menu();
        mn.setVisible(true);
    }//GEN-LAST:event_menuInicioActionPerformed

    private void crudRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudRolActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CRUD_Rol cr = new CRUD_Rol();
        cr.setVisible(true);
    }//GEN-LAST:event_crudRolActionPerformed

    private void crudPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudPersonaActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CRUD_Persona cp = new CRUD_Persona();
        cp.setVisible(true);
    }//GEN-LAST:event_crudPersonaActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Login lg = new Login();
        lg.setVisible(true);
        JOptionPane.showMessageDialog(this, "Has cerrado sesión");
    }//GEN-LAST:event_logoutActionPerformed
    
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
                new Menu().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem crudPersona;
    private javax.swing.JMenuItem crudRol;
    private javax.swing.JMenuItem crudUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JMenu personaMenu;
    private javax.swing.JMenu rolMenu;
    private javax.swing.JTable tblUsuarioRol;
    private javax.swing.JMenu usuarioMenu;
    // End of variables declaration//GEN-END:variables
}
