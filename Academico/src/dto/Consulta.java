/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dao.GenericDAO;
import forms.frmConsultaAluno;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Janaina & Roberto
 */
public class Consulta extends GenericDAO {

    public Consulta() {
        super(); //chama o contrutor da classe mãe extendida(GenericDAO)
    }

    private String prontuario;
    private String nome;
    private int idade;
    private String cidade;
    private String uf;
    private String pais;
    private String idioma;
    private double salario;
    private String disciplina;
    private String cargahoraria;
    
    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    public String getUF() {
        return uf;
    }

    public void setUF(String uf) {
        this.uf = uf;
    }
    
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    public String getCargaHoraria() {
        return cargahoraria;
    }

    public void setCargaHoraria(String cargahoraria) {
        this.cargahoraria = cargahoraria;
    }
    

    public ArrayList<Consulta> getConsultaByLista(String tipo) //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        String sql = "";
        if (tipo.toUpperCase().equals("ALUNO")) {
            sql = " select * from tblusuario u "
                    + " inner join tblaluno a on (u.prontuario = a.Usuario_prontuario) "
                    + " inner join tblrelacionamento r on (u.prontuario = r.Usuario_prontuario) "
                    + " inner join tblidioma i on (r.Idioma_id_idioma = i.id_idioma) "
                    + " ORDER BY nome, idioma ASC";
        } else if (tipo.toUpperCase().equals("PROFESSOR")) {
            sql = " select * from tblusuario u "
                    + " inner join tblprofessor p on (u.prontuario = p.Usuario_prontuario) "
                    + " inner join tblrelacionamento r on (u.prontuario = r.Usuario_prontuario) "
                    + " inner join tblidioma i on (r.Idioma_id_idioma = i.id_idioma) "
                    + " ORDER BY nome, idioma ASC";
        }

        try {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setNome(rs.getString("nome"));
                c.setIdioma(rs.getString("idioma"));
                consulta.add(c);
            }
            return consulta;

        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Consulta> getIdiomaByUsuario(String nome) //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();

        String sql = " SELECT u.prontuario, u.nome, i.nome AS idioma "
                + " FROM tblRelacionamento AS r "
                + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                + " WHERE u.prontuario LIKE ?";

        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, nome);//+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setNome(rs.getString("nome"));
                c.setIdioma(rs.getString("idioma"));
                consulta.add(c);
            }
            return consulta;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Consulta> getDisciplinaByUsuario(String nome) //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();

        String sql = " SELECT u.prontuario, u.nome, d.nomeDisciplina AS disciplina, d.cargaHorario "
                + " FROM tblusuarioldisciplina AS ud "
                + " INNER JOIN tblUsuario AS u ON u.prontuario = ud.prontuario "
                + " INNER JOIN tblDisciplina AS d ON d.idDisciplina = ud.idDisciplina "
                + " WHERE u.prontuario LIKE ?";

        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, nome);//+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setNome(rs.getString("nome"));
                c.setDisciplina(rs.getString("disciplina"));
                c.setCargaHoraria(rs.getString("cargaHorario"));
                consulta.add(c);
            }
            return consulta;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Consulta> getDisciplinaByProfessor(String nome) //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();

        String sql = " SELECT u.prontuario, u.nome, d.nomeDisciplina AS disciplina, d.cargaHorario "
                + " FROM tblusuarioldisciplina AS ud "
                + " INNER JOIN tblUsuario AS u ON u.prontuario = ud.prontuario "
                + " INNER JOIN tblDisciplina AS d ON d.idDisciplina = ud.idDisciplina "
                + " INNER JOIN tblProfessor AS p ON u.prontuario = p.prontuario "
                + " WHERE u.prontuario LIKE ? ORDER BY u.nome ASC";

        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, nome);//+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setNome(rs.getString("nome"));
                c.setDisciplina(rs.getString("disciplina"));
                c.setCargaHoraria(rs.getString("cargaHorario"));
                consulta.add(c);
            }
            return consulta;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Consulta> getDisciplinaByProfessor2(String nome) //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();

        String sql = " SELECT u.prontuario, u.nome, d.nomeDisciplina AS disciplina, d.cargaHorario "
                + " FROM tblusuarioldisciplina AS ud "
                + " INNER JOIN tblUsuario AS u ON u.prontuario = ud.prontuario "
                + " INNER JOIN tblDisciplina AS d ON d.idDisciplina = ud.idDisciplina "
                + " INNER JOIN tblProfessor AS p ON u.prontuario = p.prontuario "
                + " WHERE u.nome LIKE ? ORDER BY u.nome ASC";

        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, nome+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setNome(rs.getString("nome"));
                c.setDisciplina(rs.getString("disciplina"));
                c.setCargaHoraria(rs.getString("cargaHorario"));
                consulta.add(c);
            }
            return consulta;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Consulta> getDisciplinaByAluno(String nome) //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();

        String sql = " SELECT u.prontuario, u.nome, d.nomeDisciplina AS disciplina, d.cargaHorario "
                + " FROM tblusuarioldisciplina AS ud "
                + " INNER JOIN tblUsuario AS u ON u.prontuario = ud.prontuario "
                + " INNER JOIN tblDisciplina AS d ON d.idDisciplina = ud.idDisciplina "
                + " INNER JOIN tblAluno AS a ON u.prontuario = a.prontuario "
                + " WHERE u.prontuario LIKE ? ORDER BY u.nome ASC";

        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, nome);//+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setNome(rs.getString("nome"));
                c.setDisciplina(rs.getString("disciplina"));
                c.setCargaHoraria(rs.getString("cargaHorario"));
                consulta.add(c);
            }
            return consulta;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Consulta> getDisciplinaByAluno2(String nome) //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();

        String sql = " SELECT u.prontuario, u.nome, d.nomeDisciplina AS disciplina, d.cargaHorario "
                + " FROM tblusuarioldisciplina AS ud "
                + " INNER JOIN tblUsuario AS u ON u.prontuario = ud.prontuario "
                + " INNER JOIN tblDisciplina AS d ON d.idDisciplina = ud.idDisciplina "
                + " INNER JOIN tblAluno AS a ON u.prontuario = a.prontuario "
                + " WHERE u.nome LIKE ? ORDER BY u.nome ASC";

        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, nome+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setNome(rs.getString("nome"));
                c.setDisciplina(rs.getString("disciplina"));
                c.setCargaHoraria(rs.getString("cargaHorario"));
                consulta.add(c);
            }
            return consulta;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Consulta> getAllUsuario() //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();

        String sql = "SELECT * FROM ConsultaAllUser";

        try {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setNome(rs.getString("nome"));
                c.setIdioma(rs.getString("idioma"));
                consulta.add(c);
            }
            return consulta;
        } catch (Exception e) {
            return null;
        }
    }
    
//*************** A L U N O S **********************************************************************************************
    
    public ArrayList<Consulta> getAluno(String nome) //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        
         String sql = " SELECT u.prontuario, u.nome, u.idade, i.nome AS idioma, a.cidade, a.uf, a.pais "
                 + " FROM tblRelacionamento AS r "
                 + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                 + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                 + " INNER JOIN tblAluno AS a ON u.prontuario = a.prontuario "
                 + " WHERE u.nome LIKE ? "
                 + " ORDER BY nome ASC";
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,nome+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //if (rs.first())
            //    JOptionPane.showMessageDialog(null, "X");
            while (rs.next())
            {
                Consulta c = new Consulta();
                c.setProntuario(rs.getString("prontuario"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setIdioma(rs.getString("idioma"));
                c.setCidade(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));
                c.setPais(rs.getString("pais"));
                consulta.add(c);
            }
            return consulta;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Consulta> getAlunoByPront() //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();

        String sql = " SELECT u.prontuario, u.nome, u.idade, i.nome AS idioma, a.cidade, a.uf, a.pais "
                 + " FROM tblRelacionamento AS r "
                 + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                 + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                 + " INNER JOIN tblAluno AS a ON u.prontuario = a.prontuario "
                 + " ORDER BY u.prontuario ASC";

        try {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setProntuario(rs.getString("prontuario"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setIdioma(rs.getString("idioma"));
                c.setCidade(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));
                c.setPais(rs.getString("pais"));
                consulta.add(c);
            }
            return consulta;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Consulta> getAlunoByNome() //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        
         String sql = " SELECT u.prontuario, u.nome, u.idade, i.nome AS idioma, a.cidade, a.uf, a.pais "
                 + " FROM tblRelacionamento AS r "
                 + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                 + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                 + " INNER JOIN tblAluno AS a ON u.prontuario = a.prontuario "
                 + " ORDER BY u.nome ASC";
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //if (rs.first())
            //    JOptionPane.showMessageDialog(null, "X");
            while (rs.next())
            {
                Consulta c = new Consulta();
                c.setProntuario(rs.getString("prontuario"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setIdioma(rs.getString("idioma"));
                c.setCidade(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));
                c.setPais(rs.getString("pais"));
                consulta.add(c);
            }
            return consulta;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Consulta> getAlunoByIdade() //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        
         String sql = " SELECT u.prontuario, u.nome, u.idade, i.nome AS idioma, a.cidade, a.uf, a.pais "
                 + " FROM tblRelacionamento AS r "
                 + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                 + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                 + " INNER JOIN tblAluno AS a ON u.prontuario = a.prontuario "
                 + " ORDER BY u.idade ASC";
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //if (rs.first())
            //    JOptionPane.showMessageDialog(null, "X");
            while (rs.next())
            {
                Consulta c = new Consulta();
                c.setProntuario(rs.getString("prontuario"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setIdioma(rs.getString("idioma"));
                c.setCidade(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));
                c.setPais(rs.getString("pais"));
                consulta.add(c);
            }
            return consulta;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Consulta> getAlunoByIdioma() //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        
         String sql = " SELECT u.prontuario, u.nome, u.idade, i.nome AS idioma, a.cidade, a.uf, a.pais "
                 + " FROM tblRelacionamento AS r "
                 + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                 + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                 + " INNER JOIN tblAluno AS a ON u.prontuario = a.prontuario "
                 + " ORDER BY i.nome ASC";
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //if (rs.first())
            //    JOptionPane.showMessageDialog(null, "X");
            while (rs.next())
            {
                Consulta c = new Consulta();
                c.setProntuario(rs.getString("prontuario"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setIdioma(rs.getString("idioma"));
                c.setCidade(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));
                c.setPais(rs.getString("pais"));
                consulta.add(c);
            }
            return consulta;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Consulta> getAlunoByCidade() //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        
         String sql = " SELECT u.prontuario, u.nome, u.idade, i.nome AS idioma, a.cidade, a.uf, a.pais "
                 + " FROM tblRelacionamento AS r "
                 + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                 + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                 + " INNER JOIN tblAluno AS a ON u.prontuario = a.prontuario "
                 + " ORDER BY a.cidade ASC";
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //if (rs.first())
            //    JOptionPane.showMessageDialog(null, "X");
            while (rs.next())
            {
                Consulta c = new Consulta();
                c.setProntuario(rs.getString("prontuario"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setIdioma(rs.getString("idioma"));
                c.setCidade(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));
                c.setPais(rs.getString("pais"));
                consulta.add(c);
            }
            return consulta;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Consulta> getAlunoByUF() //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        
         String sql = " SELECT u.prontuario, u.nome, u.idade, i.nome AS idioma, a.cidade, a.uf, a.pais "
                 + " FROM tblRelacionamento AS r "
                 + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                 + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                 + " INNER JOIN tblAluno AS a ON u.prontuario = a.prontuario "
                 + " ORDER BY a.uf ASC";
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //if (rs.first())
            //    JOptionPane.showMessageDialog(null, "X");
            while (rs.next())
            {
                Consulta c = new Consulta();
                c.setProntuario(rs.getString("prontuario"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setIdioma(rs.getString("idioma"));
                c.setCidade(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));
                c.setPais(rs.getString("pais"));
                consulta.add(c);
            }
            return consulta;
        }
        catch(Exception e)
        {
            return null;
        }
    }

//*************** P R O F E S S O R E S ************************************************************************************    
    
    public ArrayList<Consulta> getProfessor(String nome) //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        
         String sql = " SELECT u.prontuario, u.nome, u.idade, i.nome AS idioma, p.salario "
                 + " FROM tblRelacionamento AS r "
                 + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                 + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                 + " INNER JOIN tblProfessor AS p ON u.prontuario = p.prontuario "
                 + " WHERE u.nome LIKE ? "
                 + " ORDER BY nome ASC";
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,nome+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //if (rs.first())
            //    JOptionPane.showMessageDialog(null, "X");
            while (rs.next())
            {
                Consulta c = new Consulta();
                c.setProntuario(rs.getString("prontuario"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setIdioma(rs.getString("idioma"));
                c.setSalario(rs.getDouble("salario"));
                consulta.add(c);
            }
            return consulta;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Consulta> getProfessorByPront() //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();

        String sql = " SELECT u.prontuario, u.nome, u.idade, i.nome AS idioma, p.salario "
                 + " FROM tblRelacionamento AS r "
                 + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                 + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                 + " INNER JOIN tblProfessor AS p ON u.prontuario = p.prontuario "
                 + " ORDER BY u.prontuario ASC";

        try {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setProntuario(rs.getString("prontuario"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setIdioma(rs.getString("idioma"));
                c.setSalario(rs.getDouble("salario"));
                consulta.add(c);
            }
            return consulta;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Consulta> getProfessorByNome() //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        
         String sql = " SELECT u.prontuario, u.nome, u.idade, i.nome AS idioma, p.salario "
                 + " FROM tblRelacionamento AS r "
                 + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                 + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                 + " INNER JOIN tblProfessor AS p ON u.prontuario = p.prontuario "
                 + " ORDER BY u.nome ASC";
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //if (rs.first())
            //    JOptionPane.showMessageDialog(null, "X");
            while (rs.next())
            {
                Consulta c = new Consulta();
                c.setProntuario(rs.getString("prontuario"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setIdioma(rs.getString("idioma"));
                c.setSalario(rs.getDouble("salario"));
                consulta.add(c);
            }
            return consulta;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Consulta> getProfessorByIdade() //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        
         String sql = " SELECT u.prontuario, u.nome, u.idade, i.nome AS idioma, p.salario "
                 + " FROM tblRelacionamento AS r "
                 + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                 + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                 + " INNER JOIN tblProfessor AS p ON u.prontuario = p.prontuario "
                 + " ORDER BY u.idade ASC";
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //if (rs.first())
            //    JOptionPane.showMessageDialog(null, "X");
            while (rs.next())
            {
                Consulta c = new Consulta();
                c.setProntuario(rs.getString("prontuario"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setIdioma(rs.getString("idioma"));
                c.setSalario(rs.getDouble("salario"));
                consulta.add(c);
            }
            return consulta;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Consulta> getProfessorByIdioma() //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        
         String sql = " SELECT u.prontuario, u.nome, u.idade, i.nome AS idioma, p.salario "
                 + " FROM tblRelacionamento AS r "
                 + " INNER JOIN tblUsuario AS u ON u.prontuario = r.prontuario "
                 + " INNER JOIN tblIdioma AS i ON i.idIdioma = r.ididioma "
                 + " INNER JOIN tblProfessor AS p ON u.prontuario = p.prontuario "
                 + " ORDER BY i.nome ASC";
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //if (rs.first())
            //    JOptionPane.showMessageDialog(null, "X");
            while (rs.next())
            {
                Consulta c = new Consulta();
                c.setProntuario(rs.getString("prontuario"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setIdioma(rs.getString("idioma"));
                c.setSalario(rs.getDouble("salario"));
                consulta.add(c);
            }
            return consulta;
        }
        catch(Exception e)
        {
            return null;
        }
    }
//***************************************************************************************************************************
    
}