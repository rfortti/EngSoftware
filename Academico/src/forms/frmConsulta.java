package forms;

import dao.RelacionamentoDAO;
import dao.UsuarioDAO;
import dto.Consulta;
import dto.Usuario;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import utils.AceitaNumeros;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Janaina & Roberto
 */
public class frmConsulta extends javax.swing.JFrame
{           
    
    private static frmConsulta instance;
  
    public static frmConsulta getInstance()
    {
        if(instance == null)
      {
        instance = new frmConsulta();
        
      }
       
      return instance;
        
    }
    
  frmConsulta()
  {
    initComponents();
    
    //txtProntuario.setDocument(new AceitaNumeros());
  }
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        grupoConsulta = new javax.swing.ButtonGroup();
        pnlConsulta = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIdiomas = new javax.swing.JTable();
        btnLocalizar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtProntuario = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rbProntuario = new javax.swing.JRadioButton();
        rbNome = new javax.swing.JRadioButton();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".: Consulta Disciplinas cursadas por Aluno :.");
        setName("frmConsulta"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta Disciplinas X Aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 18), java.awt.Color.blue)); // NOI18N

        lblNome.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNome.setText("Prontuário:");

        tblIdiomas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CursaDisciplinas", "CargaHorária"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblIdiomas);
        if (tblIdiomas.getColumnModel().getColumnCount() > 0) {
            tblIdiomas.getColumnModel().getColumn(0).setResizable(false);
            tblIdiomas.getColumnModel().getColumn(1).setResizable(false);
            tblIdiomas.getColumnModel().getColumn(2).setResizable(false);
        }

        btnLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });
        btnLocalizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLocalizarKeyPressed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Clear.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        btnLimpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLimparKeyPressed(evt);
            }
        });

        txtProntuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProntuarioKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar por:"));

        rbProntuario.setText("Prontuário");
        rbProntuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbProntuarioMouseClicked(evt);
            }
        });

        rbNome.setText("Nome");
        rbNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbNomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbProntuario)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbNome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbProntuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbNome)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlConsultaLayout = new javax.swing.GroupLayout(pnlConsulta);
        pnlConsulta.setLayout(pnlConsultaLayout);
        pnlConsultaLayout.setHorizontalGroup(
            pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlConsultaLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNome)
                            .addGroup(pnlConsultaLayout.createSequentialGroup()
                                .addComponent(btnLocalizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpar))
                            .addComponent(txtProntuario))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlConsultaLayout.setVerticalGroup(
            pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlConsultaLayout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
  {//GEN-HEADEREND:event_jButton1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        // TODO add your handling code here:
        
        //if (txtProntuario.getText() != "")
    if (rbProntuario.isSelected())
    {
        if (txtProntuario.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Informe um Prontuário !");
            txtProntuario.requestFocus();
        }
        else
        {
            Consulta consulta = new Consulta();
            ArrayList<Consulta> user = new ArrayList<Consulta>();
            user = consulta.getDisciplinaByAluno(txtProntuario.getText());
             
            if (user == null) 
            {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado !");
            }
            else
            {
             DefaultTableModel tabela = (DefaultTableModel) tblIdiomas.getModel();
             tabela.setNumRows(0);
                                                        
                for (Consulta c : user) 
                {
                    if (c != null)
                    {                
                        Object[] obj = new Object[]{
                        c.getNome(),
                        c.getDisciplina(),
                        c.getCargaHoraria()
                        };
                        tabela.addRow(obj);
                    }
                }
            }
        }
    }
    else if (rbNome.isSelected())
    {
        if (txtProntuario.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Informe o nome do aluno !");
            txtProntuario.requestFocus();
        }
        else
        {
            Consulta consulta = new Consulta();
            ArrayList<Consulta> user = new ArrayList<Consulta>();
            user = consulta.getDisciplinaByAluno2(txtProntuario.getText());
             
            if (user == null) 
            {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado !");
            }
            else
            {
             DefaultTableModel tabela = (DefaultTableModel) tblIdiomas.getModel();
             tabela.setNumRows(0);
                                                        
                for (Consulta c : user) 
                {
                    if (c != null)
                    {                
                        Object[] obj = new Object[]{
                        c.getNome(),
                        c.getDisciplina(),
                        c.getCargaHoraria()
                        };
                        tabela.addRow(obj);
                    }
                }
            }
        }
    }
    }//GEN-LAST:event_btnLocalizarActionPerformed

  private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
  {//GEN-HEADEREND:event_formWindowOpened
      // TODO add your handling code here:
      grupoConsulta.add(rbProntuario);
      grupoConsulta.add(rbNome);
      
      rbProntuario.setSelected(true);
      txtProntuario.requestFocus();
  }//GEN-LAST:event_formWindowOpened

    private void btnLocalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLocalizarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLocalizarKeyPressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        Limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnLimparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLimparKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparKeyPressed

    private void cmbNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNomeItemStateChanged
        
    }//GEN-LAST:event_cmbNomeItemStateChanged

    private void cmbUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUsuarioItemStateChanged
        
    }//GEN-LAST:event_cmbUsuarioItemStateChanged

    private void txtProntuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProntuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) //verifica se pressionou ENTER
        {  
            btnLocalizar.doClick(); //clicou no botão Localizar 
        }
    }//GEN-LAST:event_txtProntuarioKeyPressed

    private void rbProntuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbProntuarioMouseClicked
        // TODO add your handling code here:
        Limpar();
        txtProntuario.requestFocus();
        lblNome.setText("Prontuário:");
    }//GEN-LAST:event_rbProntuarioMouseClicked

    private void rbNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbNomeMouseClicked
        // TODO add your handling code here:
        Limpar();
        txtProntuario.requestFocus();
        lblNome.setText("Nome:");
    }//GEN-LAST:event_rbNomeMouseClicked

  /**
   * @param args the command line arguments
   */
  public static void main(String args[])
  {
    /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch (ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(frmProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(frmProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(frmProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(frmProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new frmConsulta().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.ButtonGroup grupoConsulta;
    private javax.swing.JButton jButton1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNome;
    private javax.swing.JPanel pnlConsulta;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JRadioButton rbProntuario;
    private javax.swing.JTable tblIdiomas;
    private javax.swing.JTextField txtProntuario;
    // End of variables declaration//GEN-END:variables

    public void Limpar()
    {
        txtProntuario.setText("");
        txtProntuario.requestFocus();
        DefaultTableModel tabelaProdutos = (DefaultTableModel)tblIdiomas.getModel();
        tabelaProdutos.setNumRows(0);
    }
}