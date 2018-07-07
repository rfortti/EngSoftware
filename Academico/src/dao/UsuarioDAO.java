/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jônatas
 */
public class UsuarioDAO extends GenericDAO{
  
  public UsuarioDAO()
  {
    super();
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
}
