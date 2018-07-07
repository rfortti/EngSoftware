/*
classe dos atributos da tblAluno
 */
package vo;

/**
 *
 * @author Aluno
 */
public class AlunoVO
{
  //declaração das variaveis
  private String Usuario_prontuario;
  private String cidade;

  public String getUsuario_prontuario()
  {
    return Usuario_prontuario;
  }

  public void setUsuario_prontuario(String Usuario_prontuario)
  {
    this.Usuario_prontuario = Usuario_prontuario;
  }

  public String getCidade()
  {
    return cidade;
  }

  public void setCidade(String cidade)
  {
    this.cidade = cidade;
  }
  
}//fim
