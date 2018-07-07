/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/** 
 * Classe referente a tabela tbldisciplina
 * @author Anderson
 * 
 */
public class Disciplina {
  
  private int idDisciplina;
  private String nomeDisciplina;
  private String cargaHorario;

  /**
   * retorna um inteiro com o id da disciplina
   * @return int - ID da disciplina
   */
  public int getIdDisciplina() {
    return idDisciplina;
  }

  /**
   * Seta o id da disciplina
   * @param idDisciplina Int - Id da disciplina
   */
  public void setIdDisciplina(int idDisciplina) {
    this.idDisciplina = idDisciplina;
  }

  /**
   * retorna o nome da disciplina
   * @return String - Nome da disciplina
   */
  public String getNomeDisciplina() {
    return nomeDisciplina;
  }

  /**
   * Seta o nome da disciplina
   * @param nomeDisciplina String - Nome da disciplina
   */
  public void setNomeDisciplina(String nomeDisciplina) {
    this.nomeDisciplina = nomeDisciplina;
  }

  /**
   * Retorna a Carga Horario da disciplina
   * @return String - Carga Horaria
   */
  public String getCargaHorario() {
    return cargaHorario;
  }

  /**
   * Define a carga horaria da disciplina
   * @param cargaHorario String - Carga Horaria
   */
  public void setCargaHorario(String cargaHorario) {
    this.cargaHorario = cargaHorario;
  }
  
  
  
}
