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
import dto.Idioma;
import dto.Relacionamento;

/**
 *
 * @author Jônatas
 */
public class RelacionamentoDAO extends GenericDAO{

    public RelacionamentoDAO() {
        super();
    }
    
    public boolean inserir(int idioma, String prontuario){
        String sql = "insert into tblRelacionamento (ididioma, prontuario) values (?, ?);";
        try {
            prepareStmte(sql);
            stmte.setInt(1, idioma);
            stmte.setString(2, prontuario);
            return stmte.execute();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean inserirRelacionamento(Relacionamento relVO) {
        try {
            String sql = "INSERT INTO projeto.tblrelacionamento (ididioma, prontuario) VALUES (?,?)";
            this.prepareStmte(sql);
            this.stmte.setInt(1, relVO.getIdioma_id_idioma().getIdIdioma());
            this.stmte.setString(2, relVO.getUsuario_prontuario());
            this.stmte.execute();
            this.closeAll();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo inserir, classe RelacionamentoDAO" + ex);
            return false;
        }
    }
    
    public boolean deletar(int idioma, String prontuario){
        String sql = "delete from tblRelacionamento where ididioma = ? && prontuario = ?;";
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
        String sql = "delete from tblRelacionamento where prontuario = ?;";
        try {
            prepareStmte(sql);
            stmte.setString(1, prontuario);
            stmte.execute();
        } catch (SQLException e) {
            throw e;
        }
        
        return true;
    }
    
     public List<Relacionamento> listaDeIdiomas(String prontuario){
        try{
            String sql = "SELECT idioma.ididioma, idioma.nome FROM tblidioma AS idioma INNER JOIN tblrelacionamento AS rel ON rel.ididioma = idioma.ididioma INNER JOIN tblusuario AS us ON us.prontuario = rel.prontuario WHERE us.prontuario = ?";       
            
            this.prepareStmte(sql);
            this.stmte.setString(1, prontuario);            
            ResultSet rs = this.stmte.executeQuery();
            
            List<Relacionamento> listaDeIdiomasPront = new ArrayList<Relacionamento>();
            
            while(rs.next()){
                Relacionamento relVO = new Relacionamento();
                Idioma iVO = new Idioma();

                iVO.setIdioma(rs.getString("nome"));//nome do idioma
                relVO.setIdioma_id_idioma(iVO);

                listaDeIdiomasPront.add(relVO);
            }
            rs.close();
            //this.stmte.close();
            this.closeAll();
            return listaDeIdiomasPront;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo listaDeIdiomas, classe RelacionamentoDAO"+ex);
            return null;
        }
    }
}
