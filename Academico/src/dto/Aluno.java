/*
 classe dos atributos da tblAluno
 */
package dto;

/**
 *
 * @author Aluno
 */
public class Aluno
{

  private String prontuario;
  private String cidade;
  private String uf;
  private String pais;

  public String getProntuario()
  {
    return prontuario;
  }

  public void setProntuario(String prontuario)
  {
    this.prontuario = prontuario;
  }

  public String getCidade()
  {
    return cidade;
  }

  public void setCidade(String cidade)
  {
    this.cidade = cidade;
  }

  public String getUf()
  {
    return uf;
  }

  public void setUf(String uf)
  {
    this.uf = uf;
  }

  public boolean equals(Object obj)
  {
    if (obj instanceof Aluno)
    {
      Aluno a = (Aluno) obj;
      return a.getUf().equals(this.getUf());
    }
    else
    {
      return false;
    }
  }

  public String getPais()
  {
    return pais;
  }

  //declaração das variaveis
  public void setPais(String pais)
  {
    this.pais = pais;
  }

}//fim
