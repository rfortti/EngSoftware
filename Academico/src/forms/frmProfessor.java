package forms;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.AceitaNumeros;
import utils.AceitaStrings;
import utils.LimitarLetras;
import utils.LimitarNumeros;
import dto.Professor;
import dao.ProfessorDAO;
import dao.IdiomaDAO;
import dao.RelacionamentoDAO;
import dto.Idioma;
import java.sql.SQLException;
import java.util.ArrayList;
import utilitarios.AceitaNumerosPonto;

/**
 *
 * @author Jonatas Bueno/Luis Henrique Campaci/Tainá Fernanda Ramos
 */
public class frmProfessor extends javax.swing.JFrame {

    private DefaultTableModel tabelaIdioma;
    private ArrayList<Idioma> list;
    private int tipoOperacao;

    public frmProfessor() {
        initComponents();

        txtProntuario.setDocument(new AceitaNumeros());
        txtNome.setDocument(new AceitaStrings());
        txtIdade.setDocument(new AceitaNumeros());
        txtProntuario.setDocument(new LimitarNumeros(10));
        txtNome.setDocument(new LimitarLetras(45));
        txtIdade.setDocument(new LimitarNumeros(2));
        txtSalario.setDocument(new AceitaNumerosPonto());
        CarregandoCmbox();
        inicial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        pnlProfessor = new javax.swing.JPanel();
        lblProntuario = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        lblIdioma = new javax.swing.JLabel();
        txtProntuario = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        cmbIdioma = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIdioma = new javax.swing.JTable();
        btnLocalizar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        lblIdioma1 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".: Cadastro de Professores :.");
        setResizable(false);

        pnlProfessor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro Professor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 18), java.awt.Color.blue)); // NOI18N

        lblProntuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblProntuario.setText("Prontuário:");

        lblNome.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNome.setText("Nome:");

        lblIdade.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblIdade.setText("Idade:");

        lblIdioma.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblIdioma.setText("Idioma:");

        txtProntuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtIdade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tblIdioma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Idioma"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIdioma.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tblIdioma.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblIdioma);

        btnLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        btnAdicionar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus.png"))); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        lblIdioma1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblIdioma1.setText("Salário:");

        javax.swing.GroupLayout pnlProfessorLayout = new javax.swing.GroupLayout(pnlProfessor);
        pnlProfessor.setLayout(pnlProfessorLayout);
        pnlProfessorLayout.setHorizontalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfessorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlProfessorLayout.createSequentialGroup()
                        .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIdioma)
                            .addComponent(lblIdade)
                            .addComponent(lblProntuario)
                            .addComponent(lblNome)
                            .addComponent(lblIdioma1))
                        .addGap(18, 18, 18)
                        .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlProfessorLayout.createSequentialGroup()
                                    .addComponent(cmbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnAdicionar))
                                .addGroup(pnlProfessorLayout.createSequentialGroup()
                                    .addComponent(txtProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLocalizar))
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlProfessorLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addGap(45, 45, 45)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pnlProfessorLayout.setVerticalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProntuario)
                    .addComponent(txtProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizar))
                .addGap(18, 18, 18)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdade)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdioma)
                    .addComponent(cmbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdioma1)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addGroup(pnlProfessorLayout.createSequentialGroup()
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 56, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_ok.png"))); // NOI18N
        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/korganizer.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
  {//GEN-HEADEREND:event_jButton1ActionPerformed

  }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
            if (txtProntuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Antes de pesquisar insira um prontuário por favor!");
            txtProntuario.requestFocus();
        } else {
            ProfessorDAO dAO = new ProfessorDAO();
            Professor p = new Professor();
            try {
                p = dAO.pesquisar(txtProntuario.getText());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex);
            }
            if (p == null) {
                JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado");
                Limpar();
                alterar1();
                txtProntuario.requestFocus();
            } else {
                txtIdade.setText(String.valueOf(p.getIdade()));
                txtNome.setText(p.getNome());
                txtSalario.setText(String.valueOf(p.getSalario()));
                IdiomaDAO idiomaDAO = new IdiomaDAO();
                tabelaIdioma = (DefaultTableModel) tblIdioma.getModel();
                int prontuario = Integer.parseInt(p.getProntuario());
                ArrayList<Idioma> lista = idiomaDAO.getIdiomasByID(prontuario);
                alterar2();
                int idiomas = lista.size();
                if (idiomas > 0) {
                    for (int i = 0; i < idiomas; i++) {
                        Object o[] = {lista.get(i).getI_ID(), lista.get(i).getI_Nome()};
                        tabelaIdioma.addRow(o);
                    }
                }
            }
        }
            this.tipoOperacao = 0;
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpar();
        inicial();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        tabelaIdioma = (DefaultTableModel) tblIdioma.getModel();
        String item = String.valueOf(cmbIdioma.getSelectedItem());

        for (int i = 0; i < tabelaIdioma.getRowCount(); i++) {
            if (tabelaIdioma.getValueAt(i, 1).toString().equals(item)) {
                JOptionPane.showMessageDialog(null, "Idioma já cadastrado");
                return;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (item.equals(list.get(i).getI_Nome())) {
                Object o[] = {list.get(i).getI_ID(), list.get(i).getI_Nome()};
                tabelaIdioma.addRow(o);
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

  private void btnInserirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnInserirActionPerformed
  {//GEN-HEADEREND:event_btnInserirActionPerformed
      this.tipoOperacao = 1;
      inserir();
  }//GEN-LAST:event_btnInserirActionPerformed

  private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAlterarActionPerformed
  {//GEN-HEADEREND:event_btnAlterarActionPerformed
      this.tipoOperacao = 0;
      alterar1();
  }//GEN-LAST:event_btnAlterarActionPerformed

  private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSalvarActionPerformed
  {//GEN-HEADEREND:event_btnSalvarActionPerformed
      if (this.tipoOperacao == 1) {
          if (cmbIdioma.getItemCount() == 0) {
              JOptionPane.showMessageDialog(null, "É obrigatório o cadastro de idiomas!"
                      + "\nFaz-se necessário cadastrar idiomas em Menu - Cadastrar - Idiomas");
              this.dispose();
          } else {
              ProfessorDAO dAO = new ProfessorDAO();
              Professor p = new Professor();
              p.setIdade(Integer.parseInt(txtIdade.getText()));
              p.setNome(txtNome.getText());
              p.setSalario(Double.parseDouble(txtSalario.getText()));
              int codigo = dAO.AutoIncremento();
              if (codigo == -1) {
                  JOptionPane.showMessageDialog(null, "Erro ao cadastrar professor!");
                  this.dispose();
              } else {
                  p.setProntuario(String.valueOf(codigo));
                  try {
                      if (dAO.inserirUsuario(p)) {
                          if (dAO.inserirProfessor(p)) {
                              int quantidadeIdiomas = tblIdioma.getRowCount();
                              if (quantidadeIdiomas > 0) {
                                  for (int i = 0; i < quantidadeIdiomas; i++) {
                                      RelacionamentoDAO rdao = new RelacionamentoDAO();
                                      int id_idioma = (Integer) tabelaIdioma.getValueAt(i, 0);
                                      rdao.inserir(id_idioma, p.getProntuario());
                                  }
                                  JOptionPane.showMessageDialog(null, "Professor inserido com sucesso!");
                              }
                          } else {
                              JOptionPane.showMessageDialog(null, "Erro ao cadastrar professor!");
                              this.dispose();
                          }
                      }
                  } catch (Exception ex) {
                      JOptionPane.showMessageDialog(null, "Erro: " + ex);
                      this.dispose();
                  }
              }
          }
          Limpar();
      } else if (this.tipoOperacao == 0) {
          Professor professor = new Professor();
          professor.setIdade(Integer.parseInt(txtIdade.getText()));
          professor.setNome(txtNome.getText());
          professor.setProntuario(txtProntuario.getText());
          professor.setSalario(Double.parseDouble(txtSalario.getText()));
          ProfessorDAO dAO = new ProfessorDAO();
          try {
          dAO.alterarProfessor(professor);
          } catch (SQLException exception) {
              JOptionPane.showMessageDialog(null, exception, "Erro ao alterar Professor", JOptionPane.ERROR_MESSAGE);
              this.dispose();
          }
          try{
          dAO.alterarUsuario(professor);
          } catch (SQLException exception){
              JOptionPane.showMessageDialog(null, exception, "Erro ao alterar Usuario", JOptionPane.ERROR_MESSAGE);
              this.dispose();
          }
          RelacionamentoDAO rdao = new RelacionamentoDAO();
          try{
          if (rdao.deletar(professor.getProntuario())) {
              for (int i = 0; i < tblIdioma.getRowCount(); i++) {
                  String id_idioma = String.valueOf(tblIdioma.getValueAt(i, 0));
                  rdao.inserir(Integer.parseInt(id_idioma), professor.getProntuario());
              }
          }
          } catch (SQLException exception){
              JOptionPane.showMessageDialog(null, exception, "Erro ao atualizar idiomas", JOptionPane.ERROR_MESSAGE);
              this.dispose();
          }
          JOptionPane.showMessageDialog(null, "Professor alterado com sucesso");
      }
      Limpar();
      inicial();
  }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        if (tblIdioma.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Cara, na boa, seleciona um idioma antes ;)"
                    + "\nNão há idioma(s) a ser(em) excluidos");
        } else {
            tabelaIdioma.removeRow(tblIdioma.getSelectedRow());
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProfessor().setVisible(true);
            }
        });
    }

    private void Limpar() {
        //limpar os campos
        txtProntuario.setText("");
        txtNome.setText("");
        txtIdade.setText("");
        txtSalario.setText("");
        txtProntuario.requestFocus();
        cmbIdioma.removeAllItems();
        clearTable();
        CarregandoCmbox();
    }

    private void Validar() {
        //metodo para limpar dados
        if (txtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário preencher o nome do professor ! ", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            txtNome.requestFocus();
        } else if (txtIdade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário preencher a idade do professor ! ", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            txtIdade.requestFocus();
        } else if (txtSalario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário preencher um salário ! ", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            txtSalario.requestFocus();
        }

    }

    private void inserir() {
        tipoOperacao = 1;
        txtNome.requestFocus();
        txtProntuario.setEditable(false);
        txtNome.setEditable(true);
        txtIdade.setEditable(true);
        txtSalario.setEditable(true);
        cmbIdioma.setEnabled(true);
        btnAdicionar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnRemover.setEnabled(true);
        btnLocalizar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnInserir.setEnabled(false);
    }

    private void alterar1() {
        tipoOperacao = 2;
        txtProntuario.requestFocus();
        txtProntuario.setEditable(true);
        txtNome.setEditable(false);
        txtIdade.setEditable(false);
        txtSalario.setEditable(false);
        cmbIdioma.setEnabled(false);
        btnAdicionar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnRemover.setEnabled(false);
        btnLocalizar.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnInserir.setEnabled(false);
    }

    private void alterar2() {
        txtNome.requestFocus();
        txtProntuario.setEditable(false);
        txtNome.setEditable(true);
        txtIdade.setEditable(true);
        txtSalario.setEditable(true);
        cmbIdioma.setEnabled(true);
        btnAdicionar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnRemover.setEnabled(true);
        btnLocalizar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnInserir.setEnabled(false);
    }

    private void inicial() {
        tipoOperacao = 0;
        txtNome.requestFocus();
        txtProntuario.setEditable(false);
        txtNome.setEditable(false);
        txtIdade.setEditable(false);
        txtSalario.setEditable(false);
        cmbIdioma.setEnabled(false);
        btnAdicionar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnRemover.setEnabled(false);
        btnLocalizar.setEnabled(false);
        btnAlterar.setEnabled(true);
        btnInserir.setEnabled(true);
        clearTable();
    }

    private void clearTable() {
        tabelaIdioma = (DefaultTableModel) tblIdioma.getModel();
        tabelaIdioma.setNumRows(0);
    }

    private void CarregandoCmbox() {
        IdiomaDAO dAO = new IdiomaDAO();
        list = dAO.getIdiomasByID();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastre pelo menos um idioma em:"
                    + "\nMenu - Cadastrar - Idiomas");
            this.dispose();
        } else {
            for (int i = 0; i < list.size(); i++) {
                cmbIdioma.addItem(list.get(i).getI_Nome());
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbIdioma;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblIdioma;
    private javax.swing.JLabel lblIdioma1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblProntuario;
    private javax.swing.JPanel pnlProfessor;
    private javax.swing.JTable tblIdioma;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtProntuario;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
