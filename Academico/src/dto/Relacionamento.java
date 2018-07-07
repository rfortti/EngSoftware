/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author moises
 */
public class Relacionamento
{

  private Idioma Idioma_id_idioma;

  public Idioma getIdioma_id_idioma()
  {
    return Idioma_id_idioma;
  }

  public void setIdioma_id_idioma(Idioma Idioma_id_idioma)
  {
    this.Idioma_id_idioma = Idioma_id_idioma;
  }
  
  private String Usuario_prontuario;

  public String getUsuario_prontuario()
  {
    return Usuario_prontuario;
  }

  public void setUsuario_prontuario(String Usuario_prontuario)
  {
    this.Usuario_prontuario = Usuario_prontuario;
  }

}
