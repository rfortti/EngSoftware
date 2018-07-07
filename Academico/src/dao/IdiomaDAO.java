/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Idioma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Multas
 */
public class IdiomaDAO extends GenericDAO {

    public IdiomaDAO() {
        super(); //chama o contrutor da classe mãe extendida(GenericDAO)
    }

    public int AutoIncID() {
        String sql = "SELECT (MAX(id_idioma) + 1) as id FROM tblidioma";
        this.prepareStmte(sql);
        ResultSet rs;
        int retorno = 0;
        try {
            rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            retorno = rs.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;

    }

    public boolean inserir(Idioma idioma) {
        String sql = "INSERT INTO tblidioma (id_idioma, idioma) VALUES (?, ?)";

        try {
            this.prepareStmte(sql);
            this.stmte.setInt(1, idioma.getI_ID());
            this.stmte.setString(2, idioma.getI_Nome());
            this.stmte.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean excluir(Idioma idioma) {
        String sql = "DELETE FROM tblidioma WHERE id_idioma = ?";

        try {
            this.prepareStmte(sql);
            this.stmte.setInt(1, idioma.getI_ID());
            //this.stmte.execute();

            int exec = this.stmte.executeUpdate();

            if (exec > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editar(Idioma idioma) {
        String sql = "UPDATE tblidioma SET idioma = ? WHERE id_idioma = ?";

        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, idioma.getI_Nome());
            this.stmte.setInt(2, idioma.getI_ID());
            this.stmte.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Idioma getIdiomaByNome(String nome_idioma) {
        Idioma cat = new Idioma();

        String sql = "SELECT * FROM tblidioma WHERE idioma LIKE ?";
        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, nome_idioma + '%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            cat.setI_ID(rs.getInt("id_idioma"));
            cat.setI_Nome(rs.getString("idioma"));
            return cat;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Idioma> getIdiomasByID() //L I S T A
    {
        ArrayList<Idioma> idioma = new ArrayList<>();
        //Categoria[] categorias = new Categoria[200];
        //int x = 0;
        String sql = "SELECT * FROM tblidioma ORDER BY id_idioma ASC";

        try {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(sql); //sempre usar quando fazer uma consulta(SELECT)
            rs.beforeFirst();
            while (rs.next()) {
                Idioma i = new Idioma();
                i.setI_ID(rs.getInt("id_idioma"));
                i.setI_Nome(rs.getString("idioma"));
                idioma.add(i);
                //x++;
            }
            return idioma;
        } catch (Exception e) {
            return null;
        } 
    }

    public ArrayList getIdiomasByID(int id_idioma) //by Jônatas (pf não apague)
    {
        ArrayList idioma = new ArrayList<>();
        String sql = "SELECT * FROM tblrelacionamento inner join tblidioma"
                + " on (tblrelacionamento.Idioma_id_idioma = tblidioma.id_idioma) "
                + "where usuario_prontuario = ? group by tblidioma.id_idioma;";
        try {
            this.prepareStmte(sql);
            this.stmte.setInt(1, id_idioma);
            ResultSet rs = this.stmte.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                Idioma i = new Idioma();
                i.setI_ID(rs.getInt("id_idioma"));
                i.setI_Nome(rs.getString("idioma"));
                idioma.add(i);
            }
            return idioma;
        } catch (SQLException e) {
            return null;
        }
        
    }

    public ArrayList<Idioma> getIdiomasByNome() //L I S T A
    {
        ArrayList<Idioma> idioma = new ArrayList<Idioma>();

        int x = 0;
        String sql = "SELECT * FROM tblidioma ORDER BY idioma ASC";

        try {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)

            while (rs.next()) {
                Idioma i = new Idioma();
                i.setI_ID(rs.getInt("id_idioma"));
                i.setI_Nome(rs.getString("idioma"));
                idioma.add(i);
                x++;
            }
            return idioma;

        } catch (Exception e) {
            return null;
        }
    }
}
