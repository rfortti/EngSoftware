package forms;

import dao.DisciplinaDAO;
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
import dao.RelacionamentoDisciplinaDAO;
import dto.Disciplina;
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
    private DefaultTableModel tabelaDisciplina;
    private ArrayList<Idioma> listaDeIdiomas;
    private ArrayList<Disciplina> listaDeDisciplina;
    private int tipoOperacao;

    private ProfessorDAO professorDAO;
    private static frmProfessor instance;
    
    public static frmProfessor getInstance()
    {
        if(instance == null)
      {
        instance = new frmProfessor();
        
      }
       
      return instance;
        
    }
    
    frmProfessor() 
    {
        initComponents();

        txtProntuario.setDocument(new AceitaNumeros());
        txtNome.setDocument(new AceitaStrings());
        txtIdade.setDocument(new AceitaNumeros());
        txtProntuario.setDocument(new LimitarNumeros(10));
        txtNome.setDocument(new LimitarLetras(45));
        txtIdade.setDocument(new LimitarNumeros(2));
        txtSalario.setDocument(new AceitaNumerosPonto());
        txtSalario.setDocument(new LimitarNumeros(12));
        CarregandoCmboxIdioma();
        CarregandoCmboxDisciplina();
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
        btnAdicionarIdioma = new javax.swing.JButton();
        btnRemoverIdioma = new javax.swing.JButton();
        lblIdioma1 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblDisciplina = new javax.swing.JLabel();
        cmbDisciplina = new javax.swing.JComboBox();
        btnAdicionarDisciplina = new javax.swing.JButton();
        btnRemoverDisciplina = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDisciplina = new javax.swing.JTable();
        btnIdioma = new javax.swing.JButton();
        btnDisciplina = new javax.swing.JButton();

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

        btnAdicionarIdioma.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAdicionarIdioma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        btnAdicionarIdioma.setText("Adicionar");
        btnAdicionarIdioma.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAdicionarIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarIdiomaActionPerformed(evt);
            }
        });

        btnRemoverIdioma.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnRemoverIdioma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus.png"))); // NOI18N
        btnRemoverIdioma.setText("Remover");
        btnRemoverIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverIdiomaActionPerformed(evt);
            }
        });

        lblIdioma1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblIdioma1.setText("Salário:");

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

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblDisciplina.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblDisciplina.setText("Disciplina:");

        btnAdicionarDisciplina.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAdicionarDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        btnAdicionarDisciplina.setText("Adicionar");
        btnAdicionarDisciplina.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAdicionarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarDisciplinaActionPerformed(evt);
            }
        });

        btnRemoverDisciplina.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnRemoverDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus.png"))); // NOI18N
        btnRemoverDisciplina.setText("Remover");
        btnRemoverDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverDisciplinaActionPerformed(evt);
            }
        });

        tblDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Disciplina"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDisciplina.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblDisciplina);

        btnIdioma.setText("...");
        btnIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdiomaActionPerformed(evt);
            }
        });

        btnDisciplina.setText("...");
        btnDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisciplinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProfessorLayout = new javax.swing.GroupLayout(pnlProfessor);
        pnlProfessor.setLayout(pnlProfessorLayout);
        pnlProfessorLayout.setHorizontalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfessorLayout.createSequentialGroup()
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProfessorLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlProfessorLayout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(lblDisciplina)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProfessorLayout.createSequentialGroup()
                                        .addComponent(cmbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlProfessorLayout.createSequentialGroup()
                                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblIdade)
                                    .addComponent(lblProntuario)
                                    .addComponent(lblNome)
                                    .addComponent(lblIdioma1)
                                    .addComponent(lblIdioma))
                                .addGap(18, 18, 18)
                                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnAdicionarIdioma)
                                        .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(pnlProfessorLayout.createSequentialGroup()
                                                .addComponent(txtProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnLocalizar))
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnAdicionarDisciplina)
                                        .addComponent(btnRemoverIdioma)
                                        .addComponent(btnRemoverDisciplina)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProfessorLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(btnInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar)))
                .addContainerGap())
        );
        pnlProfessorLayout.setVerticalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProntuario)
                    .addComponent(txtProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGap(18, 18, 18)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdade))
                .addGap(19, 19, 19)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdioma1))
                .addGap(13, 13, 13)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdioma)
                    .addComponent(cmbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIdioma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemoverIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisciplina)
                    .addComponent(cmbDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDisciplina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProfessorLayout.createSequentialGroup()
                        .addComponent(btnRemoverDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlProfessorLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        Object o[] = {lista.get(i).getIdIdioma(), lista.get(i).getIdioma()};
                        tabelaIdioma.addRow(o);
                    }
                }
                
                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                tabelaDisciplina = (DefaultTableModel) tblDisciplina.getModel();
                ArrayList<Disciplina> listaDisciplina =  disciplinaDAO.getDisciplinaId(prontuario);/*idiomaDAO.getIdiomasByID(prontuario);*/
                alterar2();
                int disciplinas = listaDisciplina.size();
                if (disciplinas > 0) {
                    for (int i = 0; i < disciplinas; i++) {
                        Object o[] = {listaDisciplina.get(i).getIdDisciplina(), listaDisciplina.get(i).getNomeDisciplina()};
                        tabelaDisciplina.addRow(o);
                    }
                }
            }
        }
        this.tipoOperacao = 0;
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cmbIdioma.removeAllItems();
        cmbDisciplina.removeAllItems();
        Limpar();
        inicial();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAdicionarIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarIdiomaActionPerformed
       //recupera o idioma e insere
        String idioma = String.valueOf(cmbIdioma.getSelectedItem());
        int id = cmbIdioma.getSelectedIndex();//recupera o id do item inserido
        cmbIdioma.removeItemAt(id);//remove ele do combo
               
        Object[] obj = {idioma};
        tabelaIdioma = (DefaultTableModel) tblIdioma.getModel();
        //tIdiomas.addRow(obj);

         for (int i = 0; i < tabelaIdioma.getRowCount(); i++) 
         {
            if (tblIdioma.getValueAt(i, 0).toString().equals(idioma)) 
            {
                JOptionPane.showMessageDialog(null, "Idioma já Adicionado!");
                return;
            }   
         }
         
         tabelaIdioma.addRow(obj);
         /*for (int i = 0; i < listaDeIdiomas.size(); i++) 
         {
            tabelaIdioma.addRow(obj);
         }*/
         
        //verifica se existe algum item no combo, caso não ele é desabilitado
        int qtde_itens_combo = cmbIdioma.getItemCount();
        if (qtde_itens_combo == 0) 
        {
            cmbIdioma.setEnabled(false);
            btnAdicionarIdioma.setEnabled(false);
        }
    }//GEN-LAST:event_btnAdicionarIdiomaActionPerformed

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
      cmbIdioma.removeAllItems();
      cmbDisciplina.removeAllItems();
      
      if (!Validar()) {
          return;
      }
      if (erroSalario(txtSalario.getText())) {
          return;
      }
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

                                  int quantidadeDisciplinas = tblDisciplina.getRowCount();
                                  if (quantidadeDisciplinas > 0) {
                                      for (int i = 0; i < quantidadeDisciplinas; i++) {
                                          RelacionamentoDisciplinaDAO rdDao = new RelacionamentoDisciplinaDAO();
                                          int id_disciplina = (Integer) tabelaDisciplina.getValueAt(i, 0);
                                          rdDao.inserirRelacionamentoD(p.getProntuario(), id_disciplina);
                                      }
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
          try {
              dAO.alterarUsuario(professor);
          } catch (SQLException exception) {
              JOptionPane.showMessageDialog(null, exception, "Erro ao alterar Usuario", JOptionPane.ERROR_MESSAGE);
              this.dispose();
          }
          RelacionamentoDisciplinaDAO rdDao = new RelacionamentoDisciplinaDAO();
          RelacionamentoDAO rdao = new RelacionamentoDAO();
          try {
              rdao.deletar(professor.getProntuario());
                  for (int i = 0; i < tblIdioma.getRowCount(); i++) {
                      String id_idioma = String.valueOf(tblIdioma.getValueAt(i, 0));
                      rdao.inserir(Integer.parseInt(id_idioma), professor.getProntuario());
                  }
              
              rdDao.deletar(professor.getProntuario());
                  for (int i = 0; i < tblDisciplina.getRowCount(); i++) {
                      String id_disciplina = String.valueOf(tblDisciplina.getValueAt(i, 0));
                      rdDao.inserirRelacionamentoD(professor.getProntuario(), Integer.parseInt(id_disciplina));
                  }
              
          } catch (SQLException exception) {
              JOptionPane.showMessageDialog(null, exception, "Erro ao atualizar idiomas e/ou disciplinas", JOptionPane.ERROR_MESSAGE);
              this.dispose();
          }
          JOptionPane.showMessageDialog(null, "Professor alterado com sucesso");
      }
      Limpar();
      inicial();
  }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemoverIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverIdiomaActionPerformed
        // TODO add your handling code here:
        if (tblIdioma.getRowCount() == 0)
      {
        JOptionPane.showMessageDialog(null, "Não há Idioma para remover!!!");
      }
      else
      {
        btnRemoverIdioma.setEnabled(true);
        if (tblIdioma.getSelectedRowCount() == 0) 
        {
            JOptionPane.showMessageDialog(null, "Clique no Idioma para remover!!!");
        } 
        else 
        {
            int idioma = tblIdioma.getSelectedRow();//recupera o id do item inserido
            cmbIdioma.addItem(tabelaIdioma.getValueAt(idioma, 0)); //linha, coluna
        
            tabelaIdioma.removeRow(idioma);
            cmbIdioma.setEnabled(true);
            btnAdicionarIdioma.setEnabled(true);
        }
      }
    }//GEN-LAST:event_btnRemoverIdiomaActionPerformed

    private void btnAdicionarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarDisciplinaActionPerformed
        // TODO add your handling code here:
        //recupera o idioma e insere
        String disciplina = String.valueOf(cmbDisciplina.getSelectedItem());
        int id = cmbDisciplina.getSelectedIndex();//recupera o id do item inserido
        cmbDisciplina.removeItemAt(id);//remove ele do combo
               
        Object[] obj = {disciplina};
        tabelaDisciplina = (DefaultTableModel) tblDisciplina.getModel();
        //tIdiomas.addRow(obj);

         for (int i = 0; i < tabelaDisciplina.getRowCount(); i++) 
         {
            if (tblDisciplina.getValueAt(i, 0).toString().equals(disciplina)) 
            {
                JOptionPane.showMessageDialog(null, "Disciplina já Adicionada!");
                return;
            }   
         }
         
         tabelaDisciplina.addRow(obj);
         /*for (int i = 0; i < listaDeDisciplina.size(); i++) 
         {
            tabelaDisciplina.addRow(obj);
         }*/
         
        //verifica se existe algum item no combo, caso não ele é desabilitado
        int qtde_itens_combo = cmbDisciplina.getItemCount();
        if (qtde_itens_combo == 0) 
        {
            cmbDisciplina.setEnabled(false);
            btnAdicionarIdioma.setEnabled(false);
        }
    }//GEN-LAST:event_btnAdicionarDisciplinaActionPerformed

    private void btnRemoverDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverDisciplinaActionPerformed
        // TODO add your handling code here:
        if (tblDisciplina.getRowCount() == 0)
      {
        JOptionPane.showMessageDialog(null, "Não há disciplina para remover!!!");
      }
      else
      {
        btnRemoverDisciplina.setEnabled(true);
        if (tblDisciplina.getSelectedRowCount() == 0) 
        {
            JOptionPane.showMessageDialog(null, "Clique na disciplina para remover!!!");
        } 
        else 
        {
            int idioma = tblDisciplina.getSelectedRow();//recupera o id do item inserido
            cmbDisciplina.addItem(tabelaDisciplina.getValueAt(idioma, 0)); //linha, coluna
        
            tabelaDisciplina.removeRow(idioma);
            cmbDisciplina.setEnabled(true);
            btnAdicionarDisciplina.setEnabled(true);
        }
      }
    }//GEN-LAST:event_btnRemoverDisciplinaActionPerformed

    private void btnIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdiomaActionPerformed
        // TODO add your handling code here:
        new frmIdioma().setVisible(true);
    }//GEN-LAST:event_btnIdiomaActionPerformed

    private void btnDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisciplinaActionPerformed
        // TODO add your handling code here:
        new frmDisciplina().setVisible(true);
    }//GEN-LAST:event_btnDisciplinaActionPerformed

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
        cmbDisciplina.removeAllItems();
        clearTable();
        CarregandoCmboxIdioma();
        CarregandoCmboxDisciplina();
    }

    /* private void Validar() {
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

     } */
    private void inserir() {
        tipoOperacao = 1;
        txtNome.requestFocus();
        txtProntuario.setEditable(false);
        txtNome.setEditable(true);
        txtIdade.setEditable(true);
        txtSalario.setEditable(true);
        cmbIdioma.setEnabled(true);
        cmbDisciplina.setEnabled(true);
        btnAdicionarIdioma.setEnabled(true);
        btnIdioma.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnRemoverIdioma.setEnabled(true);
        btnLocalizar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnInserir.setEnabled(false);
        btnAdicionarDisciplina.setEnabled(true);
        btnDisciplina.setEnabled(true);
        btnRemoverDisciplina.setEnabled(true);                
    }

    private void alterar1() {
        tipoOperacao = 2;
        txtProntuario.requestFocus();
        txtProntuario.setEditable(true);
        txtNome.setEditable(false);
        txtIdade.setEditable(false);
        txtSalario.setEditable(false);
        cmbIdioma.setEnabled(false);
        cmbDisciplina.setEditable(false);
        btnAdicionarIdioma.setEnabled(false);
        btnIdioma.setEnabled(false);
        btnAdicionarDisciplina.setEnabled(false);
        btnDisciplina.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnRemoverIdioma.setEnabled(false);
        btnRemoverDisciplina.setEnabled(false);
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
        cmbDisciplina.setEditable(true);
        btnAdicionarIdioma.setEnabled(true);
        btnIdioma.setEnabled(true);
        btnAdicionarDisciplina.setEnabled(true);
        btnDisciplina.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnRemoverIdioma.setEnabled(true);
        btnRemoverDisciplina.setEnabled(true);
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
        cmbDisciplina.setEditable(false);
        btnAdicionarIdioma.setEnabled(false);
        btnIdioma.setEnabled(false);
        btnAdicionarDisciplina.setEnabled(false);
        btnDisciplina.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnRemoverIdioma.setEnabled(false);
        btnRemoverDisciplina.setEnabled(false);
        btnLocalizar.setEnabled(false);
        btnAlterar.setEnabled(true);
        btnInserir.setEnabled(true);
        clearTable();
    }

    private void clearTable() {
        tabelaIdioma = (DefaultTableModel) tblIdioma.getModel();
        tabelaIdioma.setNumRows(0);
        tabelaDisciplina = (DefaultTableModel) tblDisciplina.getModel();
        tabelaDisciplina.setNumRows(0);
    }

    private void CarregandoCmboxIdioma() {
        IdiomaDAO dAO = new IdiomaDAO();
        listaDeIdiomas = dAO.getIdiomas(1);
        if (listaDeIdiomas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastre pelo menos um idioma em:"
                    + "\nMenu - Cadastrar - Idiomas");
            this.dispose();
        } else {
            for (int i = 0; i < listaDeIdiomas.size(); i++) {
                cmbIdioma.addItem(listaDeIdiomas.get(i).getIdioma());
            }
        }
    }

    private boolean erroSalario(String salario) {
        try {
            double sal = Double.parseDouble(salario);
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorreto no campo salário!", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            txtSalario.requestFocus();
            return true;
        }
    }

    private boolean Validar() {
        //metodo para limpar dados
        if (txtNome.getText().equals("") || txtIdade.getText().equals("") || txtSalario.getText().equals("") || tabelaIdioma.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos!", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarDisciplina;
    private javax.swing.JButton btnAdicionarIdioma;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDisciplina;
    private javax.swing.JButton btnIdioma;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnRemoverDisciplina;
    private javax.swing.JButton btnRemoverIdioma;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbDisciplina;
    private javax.swing.JComboBox cmbIdioma;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDisciplina;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblIdioma;
    private javax.swing.JLabel lblIdioma1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblProntuario;
    private javax.swing.JPanel pnlProfessor;
    private javax.swing.JTable tblDisciplina;
    private javax.swing.JTable tblIdioma;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtProntuario;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables

    private void CarregandoCmboxDisciplina() {
        DisciplinaDAO dAO = new DisciplinaDAO();
        listaDeDisciplina = dAO.getDisciplinas(2);
        if (listaDeDisciplina.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastre pelo menos uma disciplina em:"
                    + "\nMenu - Cadastrar - Disciplina");
            this.dispose();
        } else {
            for (int i = 0; i < listaDeDisciplina.size(); i++) {
                cmbDisciplina.addItem(listaDeDisciplina.get(i).getNomeDisciplina());
            }
        }
    }
}
