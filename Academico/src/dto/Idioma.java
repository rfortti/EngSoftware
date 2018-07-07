/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.sql.ResultSet;
/**
 *
 * @author Multas
 */
public class Idioma {

    private int i_ID;
    private String i_Nome;
        
    //ALT + Insert (Getter e Setter) gera os métodos  abaixo
    public int getI_ID() {
        return i_ID;
    }

    public void setI_ID(int i_ID) {
        this.i_ID = i_ID;
    }

    public String getI_Nome() {
        return i_Nome;
    }

    public void setI_Nome(String i_Nome) {
        this.i_Nome = i_Nome;
    }
    
}
