/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Aluno
 */
public class Relatorio{
    private String prontuario;
    private String nome;
    private String idioma;

  public String getProntuario()
  {
    return prontuario;
  }

  public void setProntuario(String prontuario)
  {
    this.prontuario = prontuario;
  }

  public String getNome()
  {
    return nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  public String getIdioma()
  {
    return idioma;
  }

  public void setIdioma(String idioma)
  {
    this.idioma = idioma;
  }
  
}
