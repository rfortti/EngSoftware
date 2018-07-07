SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `projeto` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `projeto` ;

-- -----------------------------------------------------
-- Table `projeto`.`tblIdioma`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `projeto`.`tblIdioma` (
  `idIdioma` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idIdioma`) ,
  UNIQUE INDEX `idIdioma_UNIQUE` (`idIdioma` ASC) ,
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`tblUsuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `projeto`.`tblUsuario` (
  `prontuario` VARCHAR(10) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `idade` INT NOT NULL ,
  PRIMARY KEY (`prontuario`) ,
  UNIQUE INDEX `prontuario_UNIQUE` (`prontuario` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`tblAluno`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `projeto`.`tblAluno` (
  `prontuario` VARCHAR(10) NOT NULL ,
  `cidade` VARCHAR(30) NOT NULL ,
  `uf` VARCHAR(2) NULL ,
  `pais` VARCHAR(50) NULL ,
  PRIMARY KEY (`prontuario`) ,
  INDEX `fk_Aluno_Usuario1` (`prontuario` ASC) ,
  CONSTRAINT `fk_Aluno_Usuario1`
    FOREIGN KEY (`prontuario` )
    REFERENCES `projeto`.`tblUsuario` (`prontuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`tblProfessor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `projeto`.`tblProfessor` (
  `salario` DOUBLE NOT NULL ,
  `prontuario` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`prontuario`) ,
  CONSTRAINT `fk_Professor_Usuario1`
    FOREIGN KEY (`prontuario` )
    REFERENCES `projeto`.`tblUsuario` (`prontuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`tblRelacionamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `projeto`.`tblRelacionamento` (
  `ididioma` INT NOT NULL ,
  `prontuario` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`ididioma`, `prontuario`) ,
  INDEX `fk_tblRelacionamento_Usuario1` (`prontuario` ASC) ,
  CONSTRAINT `fk_tblRelacionamento_Idioma1`
    FOREIGN KEY (`ididioma` )
    REFERENCES `projeto`.`tblIdioma` (`idIdioma` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tblRelacionamento_Usuario1`
    FOREIGN KEY (`prontuario` )
    REFERENCES `projeto`.`tblUsuario` (`prontuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`tblDisciplina`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `projeto`.`tblDisciplina` (
  `idDisciplina` INT NOT NULL AUTO_INCREMENT ,
  `nomeDisciplina` VARCHAR(45) NOT NULL ,
  `cargaHorario` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`idDisciplina`) ,
  UNIQUE INDEX `idDisciplina_UNIQUE` (`idDisciplina` ASC),
  UNIQUE INDEX `nomeDisciplina_UNIQUE` (`nomeDisciplina` ASC)  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`tblUsuariolDisciplina`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `projeto`.`tblUsuariolDisciplina` (
  `prontuario` VARCHAR(10) NOT NULL ,
  `idDisciplina` INT NOT NULL ,
  PRIMARY KEY (`prontuario`, `idDisciplina`) ,
  INDEX `fk_tblUsuario_has_tblDisciplina_tblDisciplina1` (`idDisciplina` ASC) ,
  INDEX `fk_tblUsuario_has_tblDisciplina_tblUsuario1` (`prontuario` ASC) ,
  CONSTRAINT `fk_tblUsuario_has_tblDisciplina_tblUsuario1`
    FOREIGN KEY (`prontuario` )
    REFERENCES `projeto`.`tblUsuario` (`prontuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tblUsuario_has_tblDisciplina_tblDisciplina1`
    FOREIGN KEY (`idDisciplina` )
    REFERENCES `projeto`.`tblDisciplina` (`idDisciplina` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


INSERT INTO `projeto`.`tblidioma` (`idIdioma`, `nome`) VALUES (1, 'INGLES');
INSERT INTO `projeto`.`tblidioma` (`idIdioma`, `nome`) VALUES (2, 'PORTUGUES');
INSERT INTO `projeto`.`tblidioma` (`idIdioma`, `nome`) VALUES (3, 'ESPANHOL');

INSERT INTO `projeto`.`tbldisciplina` (`idDisciplina`, `nomeDisciplina`, `cargaHorario`) VALUES (1, 'INGLES', '200');
INSERT INTO `projeto`.`tbldisciplina` (`idDisciplina`, `nomeDisciplina`, `cargaHorario`) VALUES (2, 'PORTUQUES', '300');
INSERT INTO `projeto`.`tbldisciplina` (`idDisciplina`, `nomeDisciplina`, `cargaHorario`) VALUES (3, 'MATEMATICA', '400');


-- criar view Relatorio
drop view if exists relatorio;
create view relatorio as 
SELECT u.nome, u.prontuario, i.nome as idioma  
FROM tblusuario u 
inner join tblrelacionamento r on (u.prontuario = r.prontuario)
inner join tblidioma i on (r.ididioma = i.idIdioma)
order by u.nome;

--
-- Criar View Consulta todos os Usuários

DROP VIEW IF EXISTS ConsultaAllUser;
CREATE VIEW ConsultaAllUser AS
SELECT u.nome, i.nome as idioma
FROM tblusuario AS u, tblidioma AS i
INNER JOIN tblrelacionamento AS r ON i.idIdioma= r.ididioma
WHERE u.prontuario = r.prontuario
ORDER BY u.nome ASC;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
