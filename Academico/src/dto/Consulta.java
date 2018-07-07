/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dao.GenericDAO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class Consulta extends GenericDAO {

    public Consulta() {
        super(); //chama o contrutor da classe mãe extendida(GenericDAO)
    }

    private String nome;
    private String idioma;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
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

        String sql = "SELECT u.nome, i.idioma "
                + "FROM tblrelacionamento AS r "
                + "INNER JOIN tblusuario AS u ON u.prontuario = r.Usuario_prontuario "
                + "INNER JOIN tblidioma AS i ON i.id_idioma = r.Idioma_id_idioma "
                + "WHERE u.nome LIKE ?";

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
    
    public ArrayList<Consulta> getAllUsuario() //L I S T A
    {
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();

        String sql = "SELECT * FROM consultaalluser";

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
}
