/*
 esta classe extende a classe generic para usar todos os metodos dela
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import dto.Usuario;

/**
 *
 * @author moises
 */
public class UsuarioDAO extends GenericDAO {

    public UsuarioDAO() {
        super();
    }

    public boolean inserir(Usuario uVO) {
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
    public Usuario getUsuario(int prontuario) {
        Usuario uVO = new Usuario();
        String sql = "SELECT * FROM tblUsuario "
                + "INNER JOIN tblaluno ON (tblaluno.prontuario = tblusuario.prontuario) "
                + "where tblaluno.prontuario = ?;";
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

    public boolean update(Usuario uVO) {
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

    public int AutoIncremento() {
        String sql = "SELECT (MAX(prontuario) + 1) as id FROM tblUsuario";
        int retorno;
        this.prepareStmte(sql);
        ResultSet rs;
        try {
            rs = this.stmte.executeQuery();
            rs.first();
            retorno = rs.getInt("id");
        } catch (Exception ex) {
            return -1;
        }
        if (retorno == 0) {
            return 1;
        }
        return retorno;
    }
    
    public ArrayList<Usuario> getUsuario() //L I S T A
     {
        ArrayList<Usuario> usuario = new ArrayList<Usuario>();
        
        String sql = "SELECT * FROM projeto.tblusuario";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Usuario u = new Usuario();
                
                u.setNome(rs.getString("nome"));
                
                usuario.add(u);
            }
            return usuario;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
}//fim da classe
