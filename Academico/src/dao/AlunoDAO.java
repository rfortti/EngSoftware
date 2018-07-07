/*
 esta classe extende a classe generic para usar todos os metodos dela
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import dto.Aluno;

/**
 *
 * @author Aluno
 */
public class AlunoDAO extends GenericDAO {

    public AlunoDAO() {
        super();
    }        

    public boolean inserir(Aluno aVO) {
        try {
            String sql = "INSERT INTO projeto.tblaluno (prontuario, cidade, uf, pais) VALUES (?,?,?,?)";
            this.prepareStmte(sql);
            this.stmte.setString(1, aVO.getProntuario());
            this.stmte.setString(2, aVO.getCidade());
            this.stmte.setString(3, aVO.getUf());
            this.stmte.setString(4, aVO.getPais());
            this.stmte.execute();
            this.closeAll();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo inserir, classe AlunoDAO" + ex);
            return false;
        }
    }
    
    //pesquisar
    public Aluno getAluno(int prontuario) {
        Aluno aVO = new Aluno();
        String sql = "SELECT * FROM projeto.tblaluno WHERE prontuario = ?";
         
        try {
            this.prepareStmte(sql);
            this.stmte.setInt(1, prontuario);
            ResultSet rs = this.stmte.executeQuery();

            rs.first();
            aVO.setCidade(rs.getString("cidade"));
            aVO.setUf(rs.getString("uf"));
            aVO.setPais(rs.getString("pais"));
            //stmte.close();
            this.closeAll();
            rs.close();
            return aVO;
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo getCategoria, classe CategoriaDAO" + ex);
            return null;
        }
    }
    
     public boolean update(Aluno aVO) {
        try {
            String sql = "UPDATE projeto.tblaluno SET cidade = ?, uf = ?, pais = ? WHERE prontuario = ?";
            this.prepareStmte(sql);
            this.stmte.setString(1, aVO.getCidade());  
            this.stmte.setString(2, aVO.getUf());
            this.stmte.setString(3, aVO.getPais());  
            this.stmte.setString(4, aVO.getProntuario());
            this.stmte.execute();
            //this.stmte.close();
            this.closeAll();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo update, classe AlnuoDAO" + ex);
            return false;
        }
    }
    
}//fim da classe
