/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import dao.DisciplinaDAO;
import dto.Disciplina;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.AceitaNumeros;
import utils.AceitaStrings;
import utils.LimitarLetras;
import utils.LimitarNumeros;

/**
 *
 * @author Anderson
 */
public class frmDisciplina extends javax.swing.JFrame {

  private String operacao;
  
  private static frmDisciplina instance;
    
    public static frmDisciplina getInstance()
    {
        if(instance == null)
      {
        instance = new frmDisciplina();
        
      }
       
      return instance;
        
    }

  /**
   * Creates new form frmDisciplina
   */
  frmDisciplina() 
  {
    initComponents();
    inicio();
    
        txtID.setDocument(new LimitarNumeros(11));
        txtNome.setDocument(new AceitaStrings());
        txtNome.setDocument(new LimitarLetras(45));
        txtCargaHoraria.setDocument(new AceitaNumeros());
        txtCargaHoraria.setDocument(new LimitarNumeros(6));
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    grupoOrdenar = new javax.swing.ButtonGroup();
    pnlIdioma = new javax.swing.JPanel();
    lblID = new javax.swing.JLabel();
    txtID = new javax.swing.JTextField();
    lblIdioma = new javax.swing.JLabel();
    txtNome = new javax.swing.JTextField();
    jPanel3 = new javax.swing.JPanel();
    rbID = new javax.swing.JRadioButton();
    rbNome = new javax.swing.JRadioButton();
    lblCargaHoraria = new javax.swing.JLabel();
    txtCargaHoraria = new javax.swing.JTextField();
    btnExcluir = new javax.swing.JButton();
    btnAlterar = new javax.swing.JButton();
    btnCancelar = new javax.swing.JButton();
    btnSalvar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tbDisciplina = new javax.swing.JTable();
    btnInserir = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setResizable(false);

    pnlIdioma.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Disciplinas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 18), java.awt.Color.blue)); // NOI18N

    lblID.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
    lblID.setText("ID:");

    txtID.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
    txtID.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        txtIDFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        txtIDFocusLost(evt);
      }
    });

    lblIdioma.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
    lblIdioma.setText("Nome:");

    txtNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
    txtNome.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        txtNomeFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        txtNomeFocusLost(evt);
      }
    });

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenar por:"));

    grupoOrdenar.add(rbID);
    rbID.setSelected(true);
    rbID.setText("ID");
    rbID.addItemListener(new java.awt.event.ItemListener()
    {
      public void itemStateChanged(java.awt.event.ItemEvent evt)
      {
        rbNomeItemStateChanged(evt);
      }
    });

    grupoOrdenar.add(rbNome);
    rbNome.setText("Nome");
    rbNome.addItemListener(new java.awt.event.ItemListener()
    {
      public void itemStateChanged(java.awt.event.ItemEvent evt)
      {
        rbNomeItemStateChanged(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(rbID)
          .addComponent(rbNome))
        .addContainerGap(25, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(rbID)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
        .addComponent(rbNome))
    );

    lblCargaHoraria.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
    lblCargaHoraria.setText("Carga Horária:");

    txtCargaHoraria.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

    javax.swing.GroupLayout pnlIdiomaLayout = new javax.swing.GroupLayout(pnlIdioma);
    pnlIdioma.setLayout(pnlIdiomaLayout);
    pnlIdiomaLayout.setHorizontalGroup(
      pnlIdiomaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pnlIdiomaLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnlIdiomaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lblIdioma, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(lblCargaHoraria, javax.swing.GroupLayout.Alignment.TRAILING))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(pnlIdiomaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    pnlIdiomaLayout.setVerticalGroup(
      pnlIdiomaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pnlIdiomaLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnlIdiomaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblID)
          .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(pnlIdiomaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblIdioma)
          .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(pnlIdiomaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblCargaHoraria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(18, Short.MAX_VALUE))
      .addGroup(pnlIdiomaLayout.createSequentialGroup()
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );

    btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus.png"))); // NOI18N
    btnExcluir.setText("Excluir");
    btnExcluir.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        btnExcluirActionPerformed(evt);
      }
    });

    btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/korganizer.png"))); // NOI18N
    btnAlterar.setText("Alterar");
    btnAlterar.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        btnAlterarActionPerformed(evt);
      }
    });

    btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_cancel.png"))); // NOI18N
    btnCancelar.setText("Cancelar");
    btnCancelar.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        btnCancelarActionPerformed(evt);
      }
    });

    btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.png"))); // NOI18N
    btnSalvar.setText("Salvar");
    btnSalvar.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        btnSalvarActionPerformed(evt);
      }
    });

    tbDisciplina.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][]
      {

      },
      new String []
      {
        "ID", "Nome", "Carga Horária"
      }
    )
    {
      boolean[] canEdit = new boolean []
      {
        false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return canEdit [columnIndex];
      }
    });
    tbDisciplina.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        tbDisciplinaMouseClicked(evt);
      }
    });
    tbDisciplina.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        tbDisciplinaFocusGained(evt);
      }
    });
    jScrollPane1.setViewportView(tbDisciplina);
    if (tbDisciplina.getColumnModel().getColumnCount() > 0)
    {
      tbDisciplina.getColumnModel().getColumn(0).setResizable(false);
      tbDisciplina.getColumnModel().getColumn(0).setPreferredWidth(5);
      tbDisciplina.getColumnModel().getColumn(1).setResizable(false);
      tbDisciplina.getColumnModel().getColumn(1).setPreferredWidth(200);
      tbDisciplina.getColumnModel().getColumn(2).setResizable(false);
      tbDisciplina.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    btnInserir.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
    btnInserir.setText("Inserir");
    btnInserir.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        btnInserirActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addComponent(btnInserir)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExcluir)
            .addGap(7, 7, 7)
            .addComponent(btnAlterar)
            .addGap(3, 3, 3)
            .addComponent(btnCancelar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jScrollPane1)
          .addComponent(pnlIdioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(pnlIdioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void limpar() {
    txtID.setText("");
    txtCargaHoraria.setText("");
    txtNome.setText("");
    rbID.setSelected(true);
  }

  private void inicio() {
    limpar();
    rbID.setEnabled(true);
    rbNome.setEnabled(true);
    rbID.requestFocus();
    btnAlterar.setEnabled(false);
    btnInserir.setEnabled(true);
    btnSalvar.setEnabled(false);
    btnCancelar.setEnabled(false);
    btnExcluir.setEnabled(false);
    txtCargaHoraria.setEnabled(false);
    txtNome.setEnabled(false);
    txtID.setEnabled(false);

    if (rbID.isSelected()) {
      loadTable(1);
    } else if (rbNome.isSelected()) {
      loadTable(2);
    }
    tbDisciplina.setEnabled(true);

  }

  /**
   * define o estado em que está inserindo um registro
   *
   * também usado após pesquisar, por que habilita os mesmos componentes.
   */
  private void inserir() {
    btnAlterar.setEnabled(false);
    btnInserir.setEnabled(false);
    btnCancelar.setEnabled(true);
    btnSalvar.setEnabled(true);
    btnExcluir.setEnabled(false);
    txtNome.setEnabled(true);
    txtCargaHoraria.setEnabled(true);
    txtID.setEnabled(false);
    rbID.setEnabled(false);
    rbNome.setEnabled(false);
    tbDisciplina.setEnabled(false);
  }

  /**
   * usado para editar. habilita os componentes para buscar o registro
   */
  private void editar() {
    btnAlterar.setEnabled(false);
    btnInserir.setEnabled(false);
    btnCancelar.setEnabled(true);
    btnSalvar.setEnabled(true);
    btnExcluir.setEnabled(false);
    txtNome.setEnabled(true);
    txtCargaHoraria.setEnabled(true);
    txtID.setEnabled(false);
    rbID.setEnabled(false);
    rbNome.setEnabled(false);
    tbDisciplina.setEnabled(false);
  }

  private void txtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusGained
    // TODO add your handling code here:
    txtID.setBackground(java.awt.Color.yellow);
  }//GEN-LAST:event_txtIDFocusGained

  private void txtIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusLost
    // TODO add your handling code here:
    txtID.setBackground(java.awt.Color.white);
  }//GEN-LAST:event_txtIDFocusLost

  private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
    // TODO add your handling code here:
    txtNome.setBackground(java.awt.Color.yellow);
  }//GEN-LAST:event_txtNomeFocusGained

  private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost
    // TODO add your handling code here:
    txtNome.setBackground(java.awt.Color.white);
  }//GEN-LAST:event_txtNomeFocusLost

  private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
    // TODO add your handling code here:
    Disciplina disciplina = new Disciplina();
    DisciplinaDAO dDAO = new DisciplinaDAO();
    int linhaselecionada = tbDisciplina.getSelectedRow(); //pega a linha selecionada

    int id = Integer.parseInt(tbDisciplina.getValueAt(linhaselecionada, 0).toString());
    String nome = tbDisciplina.getValueAt(linhaselecionada, 1).toString();
    disciplina.setIdDisciplina(id);

    int dialogButton = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir a Disciplina selecionado ?", "Warning", 0);// 0 = botão Sim e Não

    if (dialogButton == JOptionPane.YES_OPTION) {
      if (dDAO.delete(disciplina) == true) {
        JOptionPane.showMessageDialog(null, "Disciplina '" + nome + "' excluido com sucesso!");
      } else {
        JOptionPane.showMessageDialog(null, "Não é possível excluir o disciplina, pois há alunos ou professores vinculados!");
      }
      if (rbID.isSelected()) {
        loadTable(1);
      } else {
        loadTable(2);
      }
    }
  }//GEN-LAST:event_btnExcluirActionPerformed

  private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
    operacao = "UPDATE";

    int linhaselecionada = tbDisciplina.getSelectedRow(); //pega a linha selecionada

    txtID.setText(tbDisciplina.getValueAt(linhaselecionada, 0).toString());
    txtNome.setText(tbDisciplina.getValueAt(linhaselecionada, 1).toString());
    txtCargaHoraria.setText(tbDisciplina.getValueAt(linhaselecionada, 2).toString());

    editar();

  }//GEN-LAST:event_btnAlterarActionPerformed

  private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    inicio();
  }//GEN-LAST:event_btnCancelarActionPerformed

  private boolean checkNome() {
    return !txtNome.getText().isEmpty();
  }

  private boolean checkCargaHoraria() {
    return !txtCargaHoraria.getText().isEmpty();
  }

  private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    if (!checkNome()) {
      JOptionPane.showMessageDialog(null, "Nome inválido");
      txtNome.requestFocus();
      return;
    }

    if (!checkCargaHoraria()) {
      JOptionPane.showMessageDialog(null, "Carga Horária inválida");
      txtCargaHoraria.requestFocus();
      return;
    }

    Disciplina disciplina = new Disciplina();
    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

    disciplina.setCargaHorario(txtCargaHoraria.getText());
    disciplina.setNomeDisciplina(txtNome.getText().toUpperCase());
    
    if (operacao.equals("UPDATE")) {
      disciplina.setIdDisciplina(Integer.parseInt(txtID.getText()));
      if (disciplinaDAO.update(disciplina)) {
        JOptionPane.showMessageDialog(null, "Registro atualizado");
      } else {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar registro");
      }
    } else {
      if (disciplinaDAO.insert(disciplina)) {
        JOptionPane.showMessageDialog(null, "Registro inserido com sucesso !");
      } else {
        JOptionPane.showMessageDialog(null, "Disciplina '" + txtNome.getText().toUpperCase() + "' já existe cadastrada !");
      }
    }
    inicio();
  }//GEN-LAST:event_btnSalvarActionPerformed

  private void tbDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDisciplinaMouseClicked
    // TODO add your handling code here:

  }//GEN-LAST:event_tbDisciplinaMouseClicked

  private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
    txtNome.requestFocus();
    operacao = "INSERT";
    inserir();
  }//GEN-LAST:event_btnInserirActionPerformed

  private void tbDisciplinaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbDisciplinaFocusGained
    btnInserir.setEnabled(false);
    btnExcluir.setEnabled(true);
    btnAlterar.setEnabled(true);
    btnCancelar.setEnabled(true);
    btnSalvar.setEnabled(false);
  }//GEN-LAST:event_tbDisciplinaFocusGained

  private void rbNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbNomeItemStateChanged
    if (rbID.isSelected()) {
      loadTable(1);
    }

    if (rbNome.isSelected()) {
      loadTable(2);
    }
  }//GEN-LAST:event_rbNomeItemStateChanged

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
      java.util.logging.Logger.getLogger(frmDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(frmDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(frmDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(frmDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new frmDisciplina().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAlterar;
  private javax.swing.JButton btnCancelar;
  private javax.swing.JButton btnExcluir;
  private javax.swing.JButton btnInserir;
  private javax.swing.JButton btnSalvar;
  private javax.swing.ButtonGroup grupoOrdenar;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lblCargaHoraria;
  private javax.swing.JLabel lblID;
  private javax.swing.JLabel lblIdioma;
  private javax.swing.JPanel pnlIdioma;
  private javax.swing.JRadioButton rbID;
  private javax.swing.JRadioButton rbNome;
  private javax.swing.JTable tbDisciplina;
  private javax.swing.JTextField txtCargaHoraria;
  private javax.swing.JTextField txtID;
  private javax.swing.JTextField txtNome;
  // End of variables declaration//GEN-END:variables

  private void loadTable(int ord) {
    btnInserir.setEnabled(true);
    btnExcluir.setEnabled(false);
    btnAlterar.setEnabled(false);
    btnExcluir.setEnabled(false);
    btnCancelar.setEnabled(false);
    btnSalvar.setEnabled(false);

    ArrayList<Disciplina> disciplina = new ArrayList<Disciplina>();
    DisciplinaDAO dDao = new DisciplinaDAO();

    disciplina = dDao.getDisciplinas(ord);

    DefaultTableModel tabela = (DefaultTableModel) tbDisciplina.getModel();
    tabela.setNumRows(0);

    if (disciplina == null || disciplina.size() == 0) {
      return;
    }

    for (Disciplina d : disciplina) {
      if (d != null) {
        Object[] obj = new Object[]{
          d.getIdDisciplina(),
          d.getNomeDisciplina(),
          d.getCargaHorario()
        };
        tabela.addRow(obj);
      }
    }
  }
}