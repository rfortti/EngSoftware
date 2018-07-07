/*
 esta classe extende a classe generic para usar todos os metodos dela
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vo.UsuarioVO;

/**
 *
 * @author moises
 */
public class UsuarioMDAO extends GenericDAO {
    
   public UsuarioMDAO(){
       super();
   }
    
    public boolean inserir(UsuarioVO uVO) {
        try {
            String sql = "INSERT INTO projeto.tblusuario (prontuario, nome, idade) VALUES (?,?,?)";
            this.prepareStmte(sql);
            this.stmte.setString(1, uVO.getProntuario());
            this.stmte.setString(2, uVO.getNome());
            this.stmte.setInt(3, uVO.getIdade());
            this.stmte.execute();
            this.closeAll();
            return true;
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo inserir, classe UsuarioDAO" + ex);
            return false;
        }
    }
    
    //pesquisar
    public UsuarioVO getUsuario(int prontuario) {
        UsuarioVO uVO = new UsuarioVO();
        String sql = "SELECT * FROM projeto.tblusuario WHERE prontuario = ?";
        try {
            this.prepareStmte(sql);
            this.stmte.setInt(1, prontuario);
            ResultSet rs = this.stmte.executeQuery();

            rs.first();
            uVO.setProntuario(rs.getString("prontuario"));
            uVO.setNome(rs.getString("nome"));
            uVO.setIdade(rs.getInt("idade"));
            //stmte.close();
            this.closeAll();
            rs.close();
            return uVO;
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo getCategoria, classe CategoriaDAO" + ex);
            return null;
        }
    }
    
    public boolean update(UsuarioVO uVO) {
        try {
            String sql = "UPDATE projeto.tblusuario SET nome = ?, idade = ? WHERE prontuario = ?";
            this.prepareStmte(sql);            
            this.stmte.setString(1, uVO.getNome());
            this.stmte.setInt(2, uVO.getIdade());
            this.stmte.setString(3, uVO.getProntuario());
            this.stmte.execute();
            //this.stmte.close();
            this.closeAll();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo update, classe UsuarioDAO" + ex);
            return false;
        }
    }
    
}//fim da classe
