
CREATE SCHEMA IF NOT EXISTS `GEFIPP`;
USE `GEFIPP` ;

-- -----------------------------------------------------
-- Table `GEFIPP`.`projeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GEFIPP`.`projeto` (
  `id_projeto` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` TEXT NULL,
  `valor_total` FLOAT NOT NULL,
  PRIMARY KEY (`id_projeto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GEFIPP`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GEFIPP`.`item` (
  `id_item` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_item`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GEFIPP`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GEFIPP`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `nivel_permissao` INT NOT NULL COMMENT 'nivel_permissao: 1 - ver (o usuário apenas tem poder de leitura); 2 - editar (o usuário tem permissao de leitura e escrita)',
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB;

INSERT INTO `GEFIPP`.`usuario` (nome, login, senha, nivel_permissao) VALUES ('Exemplo de usu�rio super administrador',
 'exemplosuperadmin', 'exemplosuperadmin', 2);

-- -----------------------------------------------------
-- Table `GEFIPP`.`item_do_projeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GEFIPP`.`item_do_projeto` (
  `id_item_do_projeto` INT NOT NULL AUTO_INCREMENT,
  `id_projeto` INT NOT NULL,
  `id_item` INT NOT NULL,
  `valor` FLOAT NOT NULL,
  PRIMARY KEY (`id_item_do_projeto`, `id_projeto`, `id_item`),
  INDEX `fk_projeto_has_item_item1_idx` (`id_item` ASC),
  INDEX `fk_projeto_has_item_projeto_idx` (`id_projeto` ASC),
  CONSTRAINT `fk_projeto_has_item_projeto`
    FOREIGN KEY (`id_projeto`)
    REFERENCES `GEFIPP`.`projeto` (`id_projeto`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_projeto_has_item_item1`
    FOREIGN KEY (`id_item`)
    REFERENCES `GEFIPP`.`item` (`id_item`)
    ON DELETE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GEFIPP`.`projeto_do_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GEFIPP`.`projeto_do_usuario` (
  `id_projeto_do_usuario` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  `id_projeto` INT NOT NULL,
  PRIMARY KEY (`id_projeto_do_usuario`, `id_usuario`, `id_projeto`),
  INDEX `fk_usuario_has_projeto_projeto1_idx` (`id_projeto` ASC),
  INDEX `fk_usuario_has_projeto_usuario1_idx` (`id_usuario` ASC),
  CONSTRAINT `fk_usuario_has_projeto_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `GEFIPP`.`usuario` (`id_usuario`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_usuario_has_projeto_projeto1`
    FOREIGN KEY (`id_projeto`)
    REFERENCES `GEFIPP`.`projeto` (`id_projeto`)
    ON DELETE CASCADE)
ENGINE = InnoDB;