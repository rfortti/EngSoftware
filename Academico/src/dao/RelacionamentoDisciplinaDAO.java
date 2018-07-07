/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Disciplina;
import dto.Idioma;
import dto.Relacionamento;
import dto.RelacionamentoDisciplina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author moises
 */
public class RelacionamentoDisciplinaDAO extends GenericDAO{
    
    public  RelacionamentoDisciplinaDAO(){
        super();
    }
    
    public boolean inserirRelacionamentoD(RelacionamentoDisciplina relD) {
        try {
            String sql = "INSERT INTO projeto.tblusuarioldisciplina (idDisciplina, prontuario) VALUES (?,?)";
            this.prepareStmte(sql);
            this.stmte.setInt(1, relD.getIdDisciplina().getIdDisciplina());
            this.stmte.setString(2, relD.getProntuario());
            this.stmte.execute();
            this.closeAll();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo inserir, classe RelacionamentoDisciplinaDAO" + ex);
            return false;
        }
    }
    
    public boolean inserirRelacionamentoD(String prontuario, int idDisciplina) {
        String sql = "INSERT INTO projeto.tblusuarioldisciplina (prontuario, idDisciplina) VALUES (?,?)";
        try {            
            this.prepareStmte(sql);
            this.stmte.setString(1, prontuario);
            this.stmte.setInt(2, idDisciplina);
            this.stmte.execute();
            // this.closeAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deletar(String prontuario){
        String sql = "DELETE from projeto.tblusuarioldisciplina WHERE prontuario = ?";
        try {
            prepareStmte(sql);
            stmte.setString(1, prontuario);            
            stmte.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public List<RelacionamentoDisciplina> listaDeDisciplinas(String prontuario){
        try{
            String sql = "SELECT d.idDisciplina, d.nomeDisciplina FROM tbldisciplina AS d INNER JOIN tblusuarioldisciplina AS ud ON ud.idDisciplina = d.idDisciplina INNER JOIN tblusuario AS us ON us.prontuario = ud.prontuario WHERE us.prontuario = ?";       
            
            this.prepareStmte(sql);
            this.stmte.setString(1, prontuario);            
            ResultSet rs = this.stmte.executeQuery();
            
            List<RelacionamentoDisciplina> listaDeDisciplinaP = new ArrayList<RelacionamentoDisciplina>();
            
            while(rs.next()){
                RelacionamentoDisciplina rd = new RelacionamentoDisciplina();
                Disciplina d = new Disciplina();                

                d.setNomeDisciplina(rs.getString("nomeDisciplina"));                
                rd.setIdDisciplina(d);               

                listaDeDisciplinaP.add(rd);
            }
            rs.close();
            //this.stmte.close();
            this.closeAll();
            return listaDeDisciplinaP;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo listaDeDisciplinas"+ex);
            return null;
        }
    }
    
}
