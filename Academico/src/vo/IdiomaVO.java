/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author moises
 */
public class IdiomaVO {
    
    private int id_idioma;
    private String idioma;

  
    public int getId_idioma() {
        return id_idioma;
    }

    public void setId_idioma(int id_idioma) {
        this.id_idioma = id_idioma;
    }

   public String getIdioma()
  {
    return idioma;
  }

  public void setIdioma(String idioma)
  {
    this.idioma = idioma;
  }
    
    //metodo to string para retornar o nome do idioma ao inves do codigo no preenchimento do combo
     public String toString(){
        return this.idioma;
    }
    
    public boolean equals(Object obj){
        if(obj instanceof IdiomaVO){
            IdiomaVO iVO = (IdiomaVO) obj;
            return iVO.getIdioma().equals(this.getIdioma());
        }else{
            return false;
        }
    }
    
}
