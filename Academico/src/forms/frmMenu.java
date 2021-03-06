package forms;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Janaina & Roberto
 */
public class frmMenu extends javax.swing.JFrame
{

  /**
   * Creates new form frmMenu
   */
    
    class hora implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Calendar now = Calendar.getInstance();
            lblHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }
    
  public frmMenu()
  {
    initComponents();
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

    desktopPane = new javax.swing.JDesktopPane();
    lblData = new javax.swing.JLabel();
    lblHora = new javax.swing.JLabel();
    lblFundo = new javax.swing.JLabel();
    menuBar = new javax.swing.JMenuBar();
    mnuCadastro = new javax.swing.JMenu();
    mnuAlunos = new javax.swing.JMenuItem();
    mnuDisciplinas = new javax.swing.JMenuItem();
    mnuIdiomas = new javax.swing.JMenuItem();
    mnuProfessores = new javax.swing.JMenuItem();
    mnuConsulta = new javax.swing.JMenu();
    mnuConsultaAluno = new javax.swing.JMenuItem();
    mnuConsultaProfessor = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    mnuConsulta1 = new javax.swing.JMenuItem();
    mnuConsulta2 = new javax.swing.JMenuItem();
    mnuRelatorio = new javax.swing.JMenu();
    mnuRelatorio2 = new javax.swing.JMenuItem();
    mnuSistema = new javax.swing.JMenu();
    mnuSair = new javax.swing.JMenuItem();
    mnuSobre = new javax.swing.JMenu();
    mnuSobre2 = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("IFSP Capivari");
    setResizable(false);
    addWindowListener(new java.awt.event.WindowAdapter()
    {
      public void windowClosing(java.awt.event.WindowEvent evt)
      {
        formWindowClosing(evt);
      }
      public void windowOpened(java.awt.event.WindowEvent evt)
      {
        formWindowOpened(evt);
      }
    });

    desktopPane.setBackground(new java.awt.Color(255, 255, 255));

    lblData.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
    lblData.setForeground(new java.awt.Color(255, 255, 255));
    lblData.setText("Data:");
    desktopPane.add(lblData);
    lblData.setBounds(60, 60, 350, 30);

    lblHora.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
    lblHora.setForeground(new java.awt.Color(255, 255, 255));
    lblHora.setText("Hora:");
    desktopPane.add(lblHora);
    lblHora.setBounds(570, 60, 90, 30);

    lblFundo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/blackBoard.png"))); // NOI18N
    desktopPane.add(lblFundo);
    lblFundo.setBounds(0, 0, 690, 460);

    menuBar.setForeground(new java.awt.Color(255, 255, 255));

    mnuCadastro.setMnemonic('f');
    mnuCadastro.setText("Cadastro");

    mnuAlunos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
    mnuAlunos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alunos.png"))); // NOI18N
    mnuAlunos.setMnemonic('s');
    mnuAlunos.setText("Alunos");
    mnuAlunos.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        mnuAlunosActionPerformed(evt);
      }
    });
    mnuCadastro.add(mnuAlunos);

    mnuDisciplinas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
    mnuDisciplinas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/disciplinas.png"))); // NOI18N
    mnuDisciplinas.setText("Disciplinas");
    mnuDisciplinas.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        mnuDisciplinasActionPerformed(evt);
      }
    });
    mnuCadastro.add(mnuDisciplinas);

    mnuIdiomas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
    mnuIdiomas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/language.png"))); // NOI18N
    mnuIdiomas.setText("Idiomas");
    mnuIdiomas.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        mnuIdiomasActionPerformed(evt);
      }
    });
    mnuCadastro.add(mnuIdiomas);

    mnuProfessores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
    mnuProfessores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/professores.png"))); // NOI18N
    mnuProfessores.setMnemonic('o');
    mnuProfessores.setText("Professores");
    mnuProfessores.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        mnuProfessoresActionPerformed(evt);
      }
    });
    mnuCadastro.add(mnuProfessores);

    menuBar.add(mnuCadastro);

    mnuConsulta.setText("Consulta");

    mnuConsultaAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
    mnuConsultaAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/blue_find.png"))); // NOI18N
    mnuConsultaAluno.setText("Alunos");
    mnuConsultaAluno.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        mnuConsultaAlunoActionPerformed(evt);
      }
    });
    mnuConsulta.add(mnuConsultaAluno);

    mnuConsultaProfessor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
    mnuConsultaProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/orange_find.png"))); // NOI18N
    mnuConsultaProfessor.setText("Professores");
    mnuConsultaProfessor.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        mnuConsultaProfessorActionPerformed(evt);
      }
    });
    mnuConsulta.add(mnuConsultaProfessor);
    mnuConsulta.add(jSeparator1);

    mnuConsulta1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
    mnuConsulta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_1.png"))); // NOI18N
    mnuConsulta1.setText("Disciplina X Aluno");
    mnuConsulta1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        mnuConsulta1ActionPerformed(evt);
      }
    });
    mnuConsulta.add(mnuConsulta1);

    mnuConsulta2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
    mnuConsulta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_1.png"))); // NOI18N
    mnuConsulta2.setText("Disciplina X Professor");
    mnuConsulta2.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        mnuConsulta2ActionPerformed(evt);
      }
    });
    mnuConsulta.add(mnuConsulta2);

    menuBar.add(mnuConsulta);

    mnuRelatorio.setText("Relatório");

    mnuRelatorio2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
    mnuRelatorio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/document-text.png"))); // NOI18N
    mnuRelatorio2.setText("Relatório");
    mnuRelatorio2.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        mnuRelatorio2ActionPerformed(evt);
      }
    });
    mnuRelatorio.add(mnuRelatorio2);

    menuBar.add(mnuRelatorio);

    mnuSistema.setMnemonic('e');
    mnuSistema.setText("Sistema");

    mnuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
    mnuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/door_in.png"))); // NOI18N
    mnuSair.setMnemonic('y');
    mnuSair.setText("Sair");
    mnuSair.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        mnuSairActionPerformed(evt);
      }
    });
    mnuSistema.add(mnuSair);

    menuBar.add(mnuSistema);

    mnuSobre.setMnemonic('h');
    mnuSobre.setText("Sobre");

    mnuSobre2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
    mnuSobre2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/information.png"))); // NOI18N
    mnuSobre2.setText("Sobre");
    mnuSobre2.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        mnuSobre2ActionPerformed(evt);
      }
    });
    mnuSobre.add(mnuSobre2);

    menuBar.add(mnuSobre);

    setJMenuBar(menuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 9, Short.MAX_VALUE))
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void mnuAlunosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mnuAlunosActionPerformed
  {//GEN-HEADEREND:event_mnuAlunosActionPerformed
    // TODO add your handling code here:
      //new frmAluno().setVisible(true);
      frmAluno frmA = frmAluno.getInstance(); 
      frmA.setVisible(true);
      frmA.requestFocus();
  }//GEN-LAST:event_mnuAlunosActionPerformed

    private void mnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSairActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.showConfirmDialog (null, "Tem certeza que deseja sair do sistema ?","Warning",0);// 0 = botão Sim e Não

       if (dialogButton == JOptionPane.YES_OPTION)
       {
            System.exit(0); // fecha a aplicação
       }
    }//GEN-LAST:event_mnuSairActionPerformed

    private void mnuProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProfessoresActionPerformed
        // TODO add your handling code here:
        //new frmProfessor().setVisible(true);
        frmProfessor frmP = frmProfessor.getInstance(); 
        frmP.setVisible(true);
        frmP.requestFocus();
    }//GEN-LAST:event_mnuProfessoresActionPerformed

    private void mnuConsulta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsulta1ActionPerformed
        // TODO add your handling code here:
        //new frmConsulta().setVisible(true);
        frmConsulta frmC1 = frmConsulta.getInstance(); 
        frmC1.setVisible(true);
        frmC1.requestFocus();
    }//GEN-LAST:event_mnuConsulta1ActionPerformed

    private void mnuRelatorio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRelatorio2ActionPerformed
        // TODO add your handling code here:
        //new frmRelatorio().setVisible(true);
        frmRelatorio frmRel = frmRelatorio.getInstance(); 
        frmRel.setVisible(true);
        frmRel.requestFocus();
    }//GEN-LAST:event_mnuRelatorio2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //Pega Data
        Date dataSistema = new Date();
        
        SimpleDateFormat formato = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        //EEEE - mostra o dia da semana por extenso
        lblData.setText(formato.format(dataSistema));
        
        //Pega Hora
        Timer timer = new Timer(1000, new hora());
        timer.start();
    }//GEN-LAST:event_formWindowOpened

    private void mnuSobre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSobre2ActionPerformed
        // TODO add your handling code here:
        //new frmSobre().setVisible(true);
        frmSobre frmS = frmSobre.getInstance(); 
        frmS.setVisible(true);
        frmS.requestFocus();
    }//GEN-LAST:event_mnuSobre2ActionPerformed

    private void mnuIdiomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIdiomasActionPerformed
        // TODO add your handling code here:
        frmIdioma frmI = frmIdioma.getInstance(); 
        frmI.setVisible(true);
        frmI.requestFocus();
        //frmI.setAlwaysOnTop(true);
    }//GEN-LAST:event_mnuIdiomasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int dialogButton = JOptionPane.showConfirmDialog (null, "Tem certeza que deseja sair do sistema ?","Warning",0);// 0 = botão Sim e Não

       if (dialogButton == JOptionPane.YES_OPTION)
       {
            System.exit(0); // fecha a aplicação
       }
       else //if (dialogButton == JOptionPane.NO_OPTION)
       {
           setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       }
    }//GEN-LAST:event_formWindowClosing

    private void mnuDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDisciplinasActionPerformed
        // TODO add your handling code here:
        //new frmDisciplina().setVisible(true);
        frmDisciplina frmD = frmDisciplina.getInstance(); 
        frmD.setVisible(true);
        frmD.requestFocus();
        
    }//GEN-LAST:event_mnuDisciplinasActionPerformed

    private void mnuConsultaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultaAlunoActionPerformed
        // TODO add your handling code here:
        //new frmConsultaAluno().setVisible(true);
        frmConsultaAluno frmCA = frmConsultaAluno.getInstance(); 
        frmCA.setVisible(true);
        frmCA.requestFocus();
    }//GEN-LAST:event_mnuConsultaAlunoActionPerformed

    private void mnuConsultaProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultaProfessorActionPerformed
        // TODO add your handling code here:
        //new frmConsultaProfessor().setVisible(true);
        frmConsultaProfessor frmCP = frmConsultaProfessor.getInstance(); 
        frmCP.setVisible(true);
        frmCP.requestFocus();
    }//GEN-LAST:event_mnuConsultaProfessorActionPerformed

    private void mnuConsulta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsulta2ActionPerformed
        // TODO add your handling code here:
        //new frmConsulta2().setVisible(true);
        frmConsulta2 frmC2 = frmConsulta2.getInstance(); 
        frmC2.setVisible(true);
        frmC2.requestFocus();
    }//GEN-LAST:event_mnuConsulta2ActionPerformed

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
      java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new frmMenu().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JDesktopPane desktopPane;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  private javax.swing.JLabel lblData;
  private javax.swing.JLabel lblFundo;
  private javax.swing.JLabel lblHora;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JMenuItem mnuAlunos;
  private javax.swing.JMenu mnuCadastro;
  private javax.swing.JMenu mnuConsulta;
  private javax.swing.JMenuItem mnuConsulta1;
  private javax.swing.JMenuItem mnuConsulta2;
  private javax.swing.JMenuItem mnuConsultaAluno;
  private javax.swing.JMenuItem mnuConsultaProfessor;
  private javax.swing.JMenuItem mnuDisciplinas;
  private javax.swing.JMenuItem mnuIdiomas;
  private javax.swing.JMenuItem mnuProfessores;
  private javax.swing.JMenu mnuRelatorio;
  private javax.swing.JMenuItem mnuRelatorio2;
  private javax.swing.JMenuItem mnuSair;
  private javax.swing.JMenu mnuSistema;
  private javax.swing.JMenu mnuSobre;
  private javax.swing.JMenuItem mnuSobre2;
  // End of variables declaration//GEN-END:variables

}
