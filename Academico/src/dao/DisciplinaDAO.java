/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Disciplina;
import dto.RelatorioDisciplina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anderson
 */
public class DisciplinaDAO extends GenericDAO {

  public boolean insert(Disciplina disciplina) {

    try {
      String sql = "INSERT INTO `tbldisciplina`(`nomeDisciplina`,`cargaHorario`)VALUES(?,?);";
      this.prepareStmte(sql);
      this.stmte.setString(1, disciplina.getNomeDisciplina());
      this.stmte.setString(2, disciplina.getCargaHorario());
      this.stmte.execute();
      this.closeAll();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean update(Disciplina disciplina) {
    try {
      String sql = "UPDATE `tbldisciplina` SET `nomeDisciplina` = ?, `cargaHorario` = ? WHERE `idDisciplina` = ?;";
      this.prepareStmte(sql);
      this.stmte.setString(1, disciplina.getNomeDisciplina());
      this.stmte.setString(2, disciplina.getCargaHorario());
      this.stmte.setInt(3, disciplina.getIdDisciplina());
      this.stmte.execute();
      this.closeAll();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean delete(Disciplina disciplina) {
    try {
      String sql = "DELETE FROM tbldisciplina WHERE idDisciplina = ?;";
      this.prepareStmte(sql);
      this.stmte.setInt(1, disciplina.getIdDisciplina());
      this.stmte.execute();
      this.closeAll();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /*public Disciplina getDisciplinaByID(int id) {
   return getDisciplinaByID(id, "");
   }*/
  public Disciplina getDisciplinaByID(int id) {

    String sql = "SELECT * FROM tbldisciplina where idDisciplina = ? ";

    try {
      this.prepareStmte(sql);
      this.stmte.setInt(1, id);

      ResultSet rs = this.stmte.executeQuery();
      rs.beforeFirst();
      Disciplina disciplina = new Disciplina();
      if (rs.next()) {
        disciplina.setIdDisciplina(rs.getInt("idDisciplina"));
        disciplina.setNomeDisciplina(rs.getString("nomeDisciplina"));
        disciplina.setCargaHorario(rs.getString("cargaHorario"));
        return disciplina;
      } else {
        return null;
      }

    } catch (SQLException e) {
      return null;
    }
  }
  
  public ArrayList<Disciplina> getDisciplinas(int Order){
    ArrayList<Disciplina> disciplina = new ArrayList<>();

        String sql = "";
        if(Order == 1){
            //ORDENA PELO ID DO IDIOMA
           sql = "SELECT * FROM tblDisciplina ORDER BY idDisciplina ASC";
        }else if(Order == 2){
            //ORDENA PELO NOME DO IDIOMA
            sql = "SELECT * FROM tblDisciplina ORDER BY nomeDisciplina ASC";
        }
               
        try {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(sql); //sempre usar quando fazer uma consulta(SELECT)
            rs.beforeFirst();
            while (rs.next()) {
                Disciplina i = new Disciplina();
                i.setIdDisciplina(rs.getInt("idDisciplina"));
                i.setNomeDisciplina(rs.getString("nomeDisciplina"));
                i.setCargaHorario(rs.getString("cargaHorario"));
                disciplina.add(i);
                //x++;
            }
            return disciplina;
        } catch (Exception e) {
            return null;
        } 
  }

  /**
   * Retorna um array de disciplina encontrado no banco de acordo com os
   * criterios de selecao
   *
   * @param id - Id da disciplina
   * @param Tipo - Tipo do retorno. P: Professor. A: Aluno.
   * @return Array de disciplina do tipo Disciplina.
   */
  public ArrayList<RelatorioDisciplina> getDisciplinaRelatorio(String IdDisciplina, String Tipo) {
    ArrayList<RelatorioDisciplina> relatorio = new ArrayList<RelatorioDisciplina>();

    String sqlA = " SELECT a.prontuario, u.nome, d.nomeDisciplina\n"
            + " FROM tblaluno a \n"
            + " inner join tblusuario u on (a.prontuario = u.prontuario)\n"
            + " inner join tblusuarioldisciplina r on (r.prontuario = a.prontuario)\n"
            + " inner join tbldisciplina d on (r.idDisciplina = d.idDisciplina)\n"
            + " where d.idDisciplina like ?";

    String sqlP = " SELECT a.prontuario, u.nome, d.nomeDisciplina\n"
            + " FROM tblprofessor a \n"
            + " inner join tblusuario u on (a.prontuario = u.prontuario)\n"
            + " inner join tblusuarioldisciplina r on (r.prontuario = a.prontuario)\n"
            + " inner join tbldisciplina d on (r.idDisciplina = d.idDisciplina)\n"
            + " where d.idDisciplina like ?";

    String sql = null;
    switch (Tipo) {
      case "A":
        sql = sqlA;
        break;
      case "P":
        sql = sqlP;
        break;
    }

    try {
      this.prepareStmte(sql);
      if (IdDisciplina.equals("0")) {
        IdDisciplina = "%";
      }
      this.stmte.setString(1, IdDisciplina);
      ResultSet rs = this.stmte.executeQuery();
      int x = 0;
      while (rs.next()) {
        RelatorioDisciplina p = new RelatorioDisciplina();
        p.setNome(rs.getString("nome"));
        p.setProntuaio(rs.getString("prontuario"));
        p.setNomeDisciplina(rs.getString("nomeDisciplina"));
        relatorio.add(p);
        x++;
      }
      return relatorio;
    } catch (Exception e) {
      return null;
    }
  }
  
  public Disciplina getDisciplina(String nome) {

        Disciplina d = new Disciplina();
        String sql = "SELECT * FROM projeto.tbldisciplina WHERE nomeDisciplina = ?";
        try {
            
            this.prepareStmte(sql);
            this.stmte.setString(1, nome);
            ResultSet rs = this.stmte.executeQuery();

            rs.first();
            d.setIdDisciplina(rs.getInt("idDisciplina"));

            stmte.close();
            this.closeAll();
            rs.close();
            return d;

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo getCategoria, classe CategoriaDAO" + ex);
            return null;
        }
    }
    
    public ArrayList getDisciplinaId(int idDisciplina) //by Jônatas (pf não apague)
    {
        ArrayList disciplina = new ArrayList<>();
        String sql = "SELECT * FROM tblusuarioldisciplina inner join tbldisciplina "
                + " on tblusuarioldisciplina.iddisciplina = tbldisciplina.iddisciplina "
                + " where prontuario = ? group by tbldisciplina.iddisciplina;";
        try {
            this.prepareStmte(sql);
            this.stmte.setInt(1, idDisciplina);
            ResultSet rs = this.stmte.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                Disciplina d = new Disciplina();
                d.setIdDisciplina(rs.getInt("iddisciplina"));
                d.setCargaHorario(rs.getString("cargaHorario"));
                d.setNomeDisciplina(rs.getString("nomeDisciplina"));
                disciplina.add(d);
            }
            return disciplina;
        } catch (SQLException e) {
            return null;
        }        
    }
}
