/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;

/**
 *
 * @author Jônatas
 */
public class RelacionamentoDAO extends GenericDAO{

    public RelacionamentoDAO() {
        super();
    }
    
    public boolean inserir(int idioma, String prontuario){
        String sql = "insert into tblRelacionamento (idioma_id_idioma, Usuario_prontuario) values (?, ?);";
        try {
            prepareStmte(sql);
            stmte.setInt(1, idioma);
            stmte.setString(2, prontuario);
            return stmte.execute();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deletar(int idioma, String prontuario){
        String sql = "delete from tblRelacionamento where idioma_id_idioma = ? && Usuario_prontuario = ?;";
        try {
            prepareStmte(sql);
            stmte.setInt(1, idioma);
            stmte.setString(2, prontuario);
            return stmte.execute();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deletar(String prontuario) throws SQLException{
        String sql = "delete from tblRelacionamento where Usuario_prontuario = ?;";
        try {
            prepareStmte(sql);
            stmte.setString(1, prontuario);
            stmte.execute();
        } catch (SQLException e) {
            throw e;
        }
        
        return true;
    }
}
