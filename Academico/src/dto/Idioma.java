/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Janaina & Roberto
 */
public class Idioma {
    
    private int idIdioma;
    private String nome;

  
    public int getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getIdioma()
    {
        return nome;
    }

    public void setIdioma(String nome)
    {
        this.nome = nome;
    }
    
    //metodo to string para retornar o nome do idioma ao inves do codigo no preenchimento do combo
     public String toString(){
        return this.nome;
    }
    
    public boolean equals(Object obj){
        if(obj instanceof Idioma){
            Idioma iVO = (Idioma) obj;
            return iVO.getIdioma().equals(this.getIdioma());
        }else{
            return false;
        }
    }
    
}
