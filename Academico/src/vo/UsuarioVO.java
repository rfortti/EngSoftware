/*
 classe dos atributos da tblUsuario
 */
package vo;

/**
 *
 * @author Aluno
 */
public class UsuarioVO
{
  //declaração das variaveis
  private String prontuario;
  private String nome;
  private int idade;

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

  public int getIdade()
  {
    return idade;
  }

  public void setIdade(int idade)
  {
    this.idade = idade;
  }
  
}//fim
