/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.Idioma;
import dto.Relatorio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Multas
 */
public class RelatorioDAO extends GenericDAO{
       
    public RelatorioDAO()
    {
        super(); //chama o contrutor da classe mãe extendida(GenericDAO)
    }
    
    private int getRelatorioCount(){
        String sql="SELECT COUNT(*) AS quantidade FROM relatorio";
        try{
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery();
            rs.next();
            int i = rs.getInt("quantidade");
            return i;
        }
        catch (Exception e){
            return 0;
        }
    }

    public Relatorio[] getRelatorio(){
      Relatorio [] relatorio;
        String sql="SELECT * FROM relatorio";
        try{
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery();
            int linhas = this.getRelatorioCount();
            relatorio = new Relatorio[linhas];
            int x = 0;
            while(rs.next()){
                Relatorio p = new Relatorio();
                p.setIdioma(rs.getString("idioma"));
                p.setNome(rs.getString("nome"));
                p.setProntuario(rs.getString("prontuario"));
                relatorio[x] = p;
                x++;
            }
            return relatorio;
        }
        catch(Exception e){
            return null;
        }
    }
    
    /*public Idioma getIdiomaByNome(String nome_idioma)
    {
        Idioma cat = new Idioma();
        
        String sql = "select * from relatorio";
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,nome_idioma+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            cat.setI_ID(rs.getInt("id_idioma"));
            cat.setI_Nome(rs.getString("nome"));
            return cat;
        }
        catch(Exception e)
        {
            return null;
        }
    }*/
    
}

