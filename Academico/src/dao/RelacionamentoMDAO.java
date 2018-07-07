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
import vo.RelacionamentoVO;

/**
 *
 * @author moises
 */
public class RelacionamentoMDAO extends GenericDAO {
    
    public RelacionamentoMDAO(){
        super();
    }
    
    public boolean inserirRelacionamento(RelacionamentoVO relVO) {
        try {
            String sql = "INSERT INTO projeto.tblrelacionamento (Idioma_id_idioma, Usuario_prontuario) VALUES (?,?)";
            this.prepareStmte(sql);
            this.stmte.setInt(1, relVO.getIdioma_id_idioma().getId_idioma());
            this.stmte.setString(2, relVO.getUsuario_prontuario());
            this.stmte.execute();
            this.closeAll();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo inserir, classe RelacionamentoDAO" + ex);
            return false;
        }
    }
    
     public boolean update(RelacionamentoVO relVO) {
        try {
            String sql = "UPDATE projeto.tblrelacionamento SET Idioma_id_idioma = ? WHERE Usuario_prontuario = ?";
            this.prepareStmte(sql);
            this.stmte.setInt(1, relVO.getIdioma_id_idioma().getId_idioma());            
            this.stmte.execute();
            //this.stmte.close();
            this.closeAll();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo update, classe RelacionamentoDAO" + ex);
            return false;
        }
    }
    
     public List<RelacionamentoVO> listaDeIdiomas(String prontuario){
        try{
            String sql = "SELECT idioma.idioma, rel.Usuario_prontuario FROM tblidioma AS idioma INNER JOIN tblrelacionamento AS rel ON rel.Idioma_id_idioma = idioma.id_idioma INNER JOIN tblusuario AS us ON us.prontuario = rel.Usuario_prontuario WHERE us.prontuario = ?";       
            
            this.prepareStmte(sql);
            this.stmte.setString(1, prontuario);            
            ResultSet rs = this.stmte.executeQuery();
            
            List<RelacionamentoVO> listaDeIdiomasPront = new ArrayList<RelacionamentoVO>();
            
            while(rs.next()){
                RelacionamentoVO relVO = new RelacionamentoVO();
                IdiomaVO iVO = new IdiomaVO();

                iVO.setIdioma(rs.getString("idioma"));//nome do idioma
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

/*

SELECT idioma.nome, rel.Usuario_prontuario FROM tblidioma AS idioma INNER JOIN
				tblrelacionamento AS rel ON rel.Idioma_id_idioma = idioma.id_idioma INNER JOIN
				tblusuario AS us ON us.prontuario = rel.Usuario_prontuario
*/