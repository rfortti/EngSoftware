/*
 esta classe extende a classe generic para usar todos os metodos dela
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vo.AlunoVO;

/**
 *
 * @author Aluno
 */
public class AlunoMDAO extends GenericDAO {

    public AlunoMDAO() {
        super();
    }

    public boolean inserir(AlunoVO aVO) {
        try {
            String sql = "INSERT INTO projeto.tblaluno (Usuario_prontuario, cidade) VALUES (?,?)";
            this.prepareStmte(sql);
            this.stmte.setString(1, aVO.getUsuario_prontuario());
            this.stmte.setString(2, aVO.getCidade());
            this.stmte.execute();
            this.closeAll();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo inserir, classe AlunoDAO" + ex);
            return false;
        }
    }
    
    //pesquisar
    public AlunoVO getAluno(int prontuario) {
        AlunoVO aVO = new AlunoVO();
        String sql = "SELECT * FROM projeto.tblaluno WHERE Usuario_prontuario = ?";
        try {
            this.prepareStmte(sql);
            this.stmte.setInt(1, prontuario);
            ResultSet rs = this.stmte.executeQuery();

            rs.first();
            aVO.setCidade(rs.getString("cidade"));
            //stmte.close();
            this.closeAll();
            rs.close();
            return aVO;
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo getCategoria, classe CategoriaDAO" + ex);
            return null;
        }
    }
    
     public boolean update(AlunoVO aVO) {
        try {
            String sql = "UPDATE projeto.tblaluno SET cidade = ? WHERE Usuario_prontuario = ?";
            this.prepareStmte(sql);
            this.stmte.setString(1, aVO.getCidade());  
            this.stmte.setString(2, aVO.getUsuario_prontuario());
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
