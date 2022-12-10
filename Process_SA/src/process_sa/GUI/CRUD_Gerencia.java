/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process_sa.GUI;

import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import process_sa.controller.Controlador;
import process_sa.controller.Md5hash;
import process_sa.models.Persona;
import process_sa.models.Usuario;
import process_sa.models.Departamento;
import process_sa.models.Gerencia;

/**
 *
 * @author cvale
 */
public class CRUD_Gerencia extends javax.swing.JFrame {
    DefaultTableModel model;
    /**
     * Creates new form CRUD_Usuario
     */
    public CRUD_Gerencia() {
        initComponents();
        
        setTitle("Process SA - CRUD Gerencia");
        setResizable(false);
        
        String[] titulos = {"id","departamento"};
        model = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblDepartamento.setModel(model);
        mostrarDatos();
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
        jPanel2 = new javax.swing.JPanel();
        txtIdDepartamento = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtGerencia = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        lblDepartamento = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepartamento = new javax.swing.JTable();
        lbldepartamentos = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();
        usuarioMenu = new javax.swing.JMenu();
        crudUsuario = new javax.swing.JMenuItem();
        rolMenu = new javax.swing.JMenu();
        crudRol = new javax.swing.JMenuItem();
        personaMenu = new javax.swing.JMenu();
        crudPersona = new javax.swing.JMenuItem();
        unidadInternaMenu = new javax.swing.JMenu();
        crudDepartamento = new javax.swing.JMenuItem();
        crudGerencia = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdDepartamento.setEditable(false);
        txtIdDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdDepartamentoActionPerformed(evt);
            }
        });
        txtIdDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdDepartamentoKeyTyped(evt);
            }
        });

        lblUsuario.setText("Gerencia:");

        lblId.setText("ID: ");

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lblDepartamento.setText("ID Departamento:");

        txtId.setEditable(false);
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblUsuario)
                                    .addComponent(lblId))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblDepartamento)
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGerencia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtGerencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepartamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnLimpiar))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 330, 190));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("CRUD Gerencia");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        tblDepartamento.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDepartamento);

        lbldepartamentos.setText("Departamentos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lbldepartamentos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbldepartamentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 330, 160));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 240));

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

        jMenuBar1.add(mainMenu);

        usuarioMenu.setText("Usuario");

        crudUsuario.setText("CRUD Usuario");
        crudUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudUsuarioActionPerformed(evt);
            }
        });
        usuarioMenu.add(crudUsuario);

        jMenuBar1.add(usuarioMenu);

        rolMenu.setText("Rol");

        crudRol.setText("CRUD Rol");
        crudRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudRolActionPerformed(evt);
            }
        });
        rolMenu.add(crudRol);

        jMenuBar1.add(rolMenu);

        personaMenu.setText("Persona");

        crudPersona.setText("CRUD Persona");
        crudPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudPersonaActionPerformed(evt);
            }
        });
        personaMenu.add(crudPersona);

        jMenuBar1.add(personaMenu);

        unidadInternaMenu.setText("Unidad interna");

        crudDepartamento.setText("CRUD Departamento");
        crudDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudDepartamentoActionPerformed(evt);
            }
        });
        unidadInternaMenu.add(crudDepartamento);

        crudGerencia.setText("CRUD Gerencia");
        crudGerencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudGerenciaActionPerformed(evt);
            }
        });
        unidadInternaMenu.add(crudGerencia);

        jMenuBar1.add(unidadInternaMenu);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Menu mn = new Menu();
        mn.setVisible(true);
    }//GEN-LAST:event_menuInicioActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        Controlador conn = new Controlador();
        
        try {
            Gerencia ger = recuperarDatosGUI();
            if (ger.getGerencia() == null || ger.getId_departamento() == null){
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos requeridos");
            }
            else{
                String sentencia = String.format("call PD_INSERT_GERENCIAV2('%s',%s)", ger.getGerencia(), ger.getId_departamento());
                System.out.println("Sentencia: "+sentencia);
                conn.ejecutarProcedimientoAlmacenado(sentencia);
                JOptionPane.showMessageDialog(this, "Gerencia creada correctamente!");
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        } finally {
            conn.desconectar();
            limpiarCampos();
        }
    }//GEN-LAST:event_btnCrearActionPerformed
  
    private void crudUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudUsuarioActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CRUD_Gerencia cu = new CRUD_Gerencia();
        cu.setVisible(true);
    }//GEN-LAST:event_crudUsuarioActionPerformed

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

    private void txtIdDepartamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdDepartamentoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
            evt.consume();
        }
        if((txtIdDepartamento.getText().length() >= 4)){
            evt.consume();
        }
    }//GEN-LAST:event_txtIdDepartamentoKeyTyped

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
            evt.consume();
        }
        if((txtId.getText().length() >= 4)){
            evt.consume();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtIdDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDepartamentoActionPerformed

    private void tblDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartamentoMouseClicked
        // TODO add your handling code here:
        JTable dt = (JTable)evt.getSource();
        int row  = dt.getSelectedRow();
        
        String valor = dt.getValueAt(row, 0).toString();
        
        txtIdDepartamento.setText(valor);
    }//GEN-LAST:event_tblDepartamentoMouseClicked

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Login lg = new Login();
        lg.setVisible(true);
        JOptionPane.showMessageDialog(this, "Has cerrado sesión");
    }//GEN-LAST:event_logoutActionPerformed

    private void crudDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudDepartamentoActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CRUD_Departamento dep = new CRUD_Departamento();
        dep.setVisible(true);
    }//GEN-LAST:event_crudDepartamentoActionPerformed

    private void crudGerenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudGerenciaActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CRUD_Gerencia ger = new CRUD_Gerencia();
        ger.setVisible(true);
    }//GEN-LAST:event_crudGerenciaActionPerformed

    public void mostrarDatos(){
        Controlador conn = new Controlador();
        
        try {
            final List<Departamento> listaDepartamento = conn.getDepartamento();
            if (listaDepartamento != null){
                for (Departamento listaDepartamentos : listaDepartamento) {
                    Object[] o = new Object[3];
                    o[0] = listaDepartamentos.getId_departamento();
                    o[1] = listaDepartamentos.getDepartamento();
                    o[2] = listaDepartamentos.getId_gerencia();
                    model.addRow(o);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        conn.desconectar();
    }
    
    public Gerencia recuperarDatosGUI(){
        Gerencia ger = new Gerencia();
        String gerencia_nombre = txtGerencia.getText();
        if (gerencia_nombre.length() > 0){
            ger.setGerencia(gerencia_nombre);
        }
        else {
            ger.setGerencia(null);
        }
        String departamento_id = txtIdDepartamento.getText();
        if (departamento_id.length() > 0) {
            ger.setId_departamento(departamento_id);
        }
        else {
            ger.setId_departamento(null);
        }
        return ger;
    }
    
    public void limpiarCampos(){
        txtIdDepartamento.setText(null);
        txtGerencia.setText(null);
        txtIdDepartamento.setText(null);
    }
    
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
                new CRUD_Gerencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JMenuItem crudDepartamento;
    private javax.swing.JMenuItem crudGerencia;
    private javax.swing.JMenuItem crudPersona;
    private javax.swing.JMenuItem crudRol;
    private javax.swing.JMenuItem crudUsuario;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lbldepartamentos;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenu personaMenu;
    private javax.swing.JMenu rolMenu;
    private javax.swing.JTable tblDepartamento;
    private javax.swing.JTextField txtGerencia;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdDepartamento;
    private javax.swing.JMenu unidadInternaMenu;
    private javax.swing.JMenu usuarioMenu;
    // End of variables declaration//GEN-END:variables
}