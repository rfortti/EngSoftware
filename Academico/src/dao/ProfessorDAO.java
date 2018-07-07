/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Professor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jônatas
 */
public class ProfessorDAO extends GenericDAO {

    public ProfessorDAO() {
        super();
    }

    public int AutoIncremento() {
        String sql = "SELECT (MAX(prontuario) + 1) as id FROM tblUsuario";
        int retorno;
        this.prepareStmte(sql);
        ResultSet rs;
        try {
            rs = this.stmte.executeQuery();
            rs.first();
            retorno = rs.getInt("id");
        } catch (Exception ex) {
            return -1;
        }
        if (retorno == 0) {
            return 1;
        }
        return retorno;
    }

    public boolean inserirUsuario(Professor professor) throws Exception {
        String sql = "insert into tblUsuario (prontuario, nome, idade) values (?, ?, ?);";

        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, professor.getProntuario());
            this.stmte.setString(2, professor.getNome());
            this.stmte.setInt(3, professor.getIdade());
            this.stmte.execute();
        } catch (SQLException e) {
            throw e;
        }
        return true;
    }

    public boolean inserirProfessor(Professor professor) throws SQLException {
        String sql2 = "insert into tblProfessor (Usuario_prontuario, salario) values (?, ?);";
        try {
            this.prepareStmte(sql2);
            this.stmte.setString(1, professor.getProntuario());
            this.stmte.setDouble(2, professor.getSalario());
            this.stmte.execute();
        } catch (SQLException e) {
            throw e;
        }
        return true;
    }

    public Professor pesquisar(String prontuario) throws SQLException {
        String sql = "SELECT * FROM tblUsuario "
                   + "INNER JOIN tblProfessor ON (tblprofessor.Usuario_prontuario = tblusuario.prontuario) "
                   + "where tblProfessor.Usuario_prontuario = ?;";
        Professor professor = new Professor();
        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, prontuario);
            ResultSet resultSet = this.stmte.executeQuery();
            //resultSet.first();
            if (!resultSet.next())
                return null;
            professor.setNome(resultSet.getString("nome"));
            professor.setProntuario(resultSet.getString("prontuario"));
            professor.setIdade(resultSet.getInt("idade"));
            professor.setSalario(resultSet.getDouble("salario"));
        } catch (SQLException exception) {
            throw exception;
        }
        return professor;
    }

    public ArrayList<Professor> ColecaoProfessor() {
        String sql = "select * tblProfessor;";
        ArrayList professores = new ArrayList();
        try {
            ResultSet resultSet = this.stmte.executeQuery(sql);
            while (resultSet.next()) {
                Professor p = new Professor();
                p.setIdade(resultSet.getInt("idade"));
                p.setNome(resultSet.getString("nome"));
                p.setProntuario(resultSet.getString("Usuario_prontuario"));
                p.setSalario(resultSet.getDouble("salario"));
                professores.add(p);
            }
        } catch (Exception e) {
            return professores;
        }
        return professores;
    }
    
    public boolean alterarUsuario(Professor professor) throws SQLException {
        String sql = "UPDATE tblUsuario SET nome = ?, idade = ? where prontuario = ?;";
        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, professor.getNome());
            this.stmte.setInt(2, professor.getIdade());
            this.stmte.setString(3, professor.getProntuario());
            this.stmte.execute();
        } catch (SQLException e) {
            throw e;
        }
        return true;
    }

    public boolean alterarProfessor(Professor professor) throws SQLException {
        String sql = "UPDATE tblProfessor SET salario = ? where Usuario_prontuario = ?;";
      
        try {
            this.prepareStmte(sql);
            this.stmte.setDouble(1, professor.getSalario());
            this.stmte.setString(2, professor.getProntuario());
            this.stmte.execute();
        } catch (SQLException e) {
            throw e;
        }
        return true;
    }

    public boolean deletar(Professor professor) {
        String sql = "delete from tblProfessor where Usuario_prontuario = ?;";
        String sql2 = "delete from tblUsuario where prontuario = ?;";
        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, professor.getProntuario());
            this.stmte.execute();
            this.prepareStmte(sql2);
            this.stmte.setString(1, professor.getProntuario());
            this.stmte.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
