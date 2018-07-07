/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import vo.IdiomaVO;

/**
 *
 * @author moises
 */
public class IdiomaMDAO extends GenericDAO {

    public IdiomaMDAO() {
        super();
    }

    public IdiomaVO getIdioma(String nome) {

        IdiomaVO iVO = new IdiomaVO();
        String sql = "SELECT * FROM projeto.tblidioma WHERE idioma = ?";
        try {
            
            this.prepareStmte(sql);
            this.stmte.setString(1, nome);
            ResultSet rs = this.stmte.executeQuery();

            rs.first();
            iVO.setId_idioma(rs.getInt("id_idioma"));

            stmte.close();
            this.closeAll();
            rs.close();
            return iVO;

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo getCategoria, classe CategoriaDAO" + ex);
            return null;
        }
    }
    
    public List<IdiomaVO> listarIdiomas() {

        try {
                String sql = "SELECT * FROM projeto.tblidioma";
                this.prepareStmte(sql);                          

            ResultSet rs = this.stmte.executeQuery();
            //monta o array 
            List<IdiomaVO> listaIdiomas = new ArrayList<IdiomaVO>();
            while (rs.next()) {
                IdiomaVO iVO = new IdiomaVO();
                iVO.setIdioma(rs.getString("idioma"));
                listaIdiomas.add(iVO);
            }
            rs.close();
            //stmte.close();
            this.closeAll();
            return listaIdiomas;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo listaEditora, classe Editora" + ex);
            return null;
        }
    }

}//fim da classe
