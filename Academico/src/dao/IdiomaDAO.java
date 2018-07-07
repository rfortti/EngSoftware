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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dto.Idioma;

/**
 *
 * @author Janaina & Roberto
 */
public class IdiomaDAO extends GenericDAO {

    public IdiomaDAO() {
        super(); //chama o contrutor da classe mãe extendida(GenericDAO)
    }

    public int AutoIncID() {
        String sql = "SELECT (MAX(idIdioma) + 1) as id FROM tblIdioma";
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
        String sql = "INSERT INTO tblIdioma (idIdioma, nome) VALUES (?, ?)";

        try {
            this.prepareStmte(sql);
            this.stmte.setInt(1, idioma.getIdIdioma());
            this.stmte.setString(2, idioma.getIdioma());
            this.stmte.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean excluir(Idioma idioma) {
        String sql = "DELETE FROM tblIdioma WHERE idIdioma = ?";

        try {
            this.prepareStmte(sql);
            this.stmte.setInt(1, idioma.getIdIdioma());
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
        String sql = "UPDATE tblIdioma SET nome = ? WHERE idIdioma = ?";

        try {
            this.prepareStmte(sql);
            this.stmte.setString(1, idioma.getIdioma());
            this.stmte.setInt(2, idioma.getIdIdioma());
            this.stmte.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
    ALTEREI O NOME AQUI, PORQUE O METODO RETORNA UMA LISTA COM TODOS OS IDIOMAS
    TB MUDEI A FORMA DO METODO PASSANDO UM PARAMETRO,PQ TINHA OUTRO METODO IGUAL
    MUDANDO SOMENTE A SQL, 
    QDO PARAMENTRO = 1 ORDENA PELO ID
    QDO PARAMENTRO = 2 ORDENA PELO NOME DO IDIOMA
    */
    public ArrayList<Idioma> getIdiomas(int parametro) //L I S T A
    {
        ArrayList<Idioma> idioma = new ArrayList<>();

        String sql = "";
        if(parametro == 1){
            //ORDENA PELO ID DO IDIOMA
           sql = "SELECT * FROM tblIdioma ORDER BY idIdioma ASC";
        }else if(parametro == 2){
            //ORDENA PELO NOME DO IDIOMA
            sql = "SELECT * FROM tblIdioma ORDER BY nome ASC";
        }
               
        try {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(sql); //sempre usar quando fazer uma consulta(SELECT)
            rs.beforeFirst();
            while (rs.next()) {
                Idioma i = new Idioma();
                i.setIdIdioma(rs.getInt("idIdioma"));
                i.setIdioma(rs.getString("nome"));
                idioma.add(i);
                //x++;
            }
            return idioma;
        } catch (Exception e) {
            return null;
        } 
    }        

    public ArrayList getIdiomasByID(int idIdioma) //by Jônatas (pf não apague)
    {
        ArrayList idioma = new ArrayList<>();
        String sql = "SELECT * FROM tblrelacionamento inner join tblIdioma "
                + " on (tblrelacionamento.ididioma = tblidioma.idIdioma) "
                + " where prontuario = ? group by tblIdioma.idIdioma;";
        try {
            this.prepareStmte(sql);
            this.stmte.setInt(1, idIdioma);
            ResultSet rs = this.stmte.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                Idioma i = new Idioma();
                i.setIdIdioma(rs.getInt("idIdioma"));
                i.setIdioma(rs.getString("nome"));
                idioma.add(i);
            }
            return idioma;
        } catch (SQLException e) {
            return null;
        }        
    }
    
    public Idioma getIdioma(String nome) {

        Idioma iVO = new Idioma();
        String sql = "SELECT * FROM projeto.tblIdioma WHERE nome = ?";
        try {
            
            this.prepareStmte(sql);
            this.stmte.setString(1, nome);
            ResultSet rs = this.stmte.executeQuery();

            rs.first();
            iVO.setIdIdioma(rs.getInt("idIdioma"));

            stmte.close();
            this.closeAll();
            rs.close();
            return iVO;

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo getCategoria, classe CategoriaDAO" + ex);
            return null;
        }
    }
    
    public List<Idioma> listarIdiomas() {

        try {
                String sql = "SELECT * FROM projeto.tblIdioma";
                this.prepareStmte(sql);                          

            ResultSet rs = this.stmte.executeQuery();
            //monta o array 
            List<Idioma> listaIdiomas = new ArrayList<Idioma>();
            while (rs.next()) {
                Idioma iVO = new Idioma();
                iVO.setIdioma(rs.getString("nome"));
                listaIdiomas.add(iVO);
            }
            rs.close();
            //stmte.close();
            this.closeAll();
            return listaIdiomas;
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo listaEditora, classe Editora" + ex);
            return null;
        }
    }
}
