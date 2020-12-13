

CREATE TABLE IF NOT EXISTS notificacao(
  idNotificacao INTEGER  PRIMARY KEY AUTOINCREMENT,
  idusuario INTEGER NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  CONSTRAINT fk_Notificacao_usuario1
    FOREIGN KEY (idusuario)
    REFERENCES usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


CREATE TABLE IF NOT EXISTS usuario (
  idusuario INTEGER  PRIMARY KEY AUTOINCREMENT,
  nome VARCHAR(100) NOT NULL,
  senha VARCHAR(100) NOT NULL,
  admin BOOLEAN NOT NULL)
;


CREATE TABLE IF NOT EXISTS imagem (
  idimagem INTEGER PRIMARY KEY AUTOINCREMENT,
  descricao VARCHAR(45) NOT NULL,
  caminho VARCHAR(300) NOT NULL)
;


CREATE TABLE IF NOT EXISTS permissao (
  idusuario INTEGER NOT NULL,
  idimagem INTEGER NOT NULL,
  excluir BOOLEAN NOT NULL,
  visualizar BOOLEAN NOT NULL DEFAULT 0,
  compartilhar BOOLEAN NOT NULL DEFAULT 0,
  PRIMARY KEY (idusuario, idimagem),
   CONSTRAINT fk_usuario_has_imagem_usuario
    FOREIGN KEY (idusuario)
    REFERENCES usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_permissao_imagem1
    FOREIGN KEY (idimagem)
    REFERENCES imagem (idimagem)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

