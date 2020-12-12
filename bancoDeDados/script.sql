CREATE TABLE usuario (
  idusuario INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  nome VARCHAR(100) NOT NULL,
  senha VARCHAR(100) NOT NULL,
  admin TINYINT NOT NULL
);


CREATE TABLE imagem (
  idimagem INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  descricao VARCHAR(45) NOT NULL,
  caminho VARCHAR(300) NOT NULL
);


CREATE TABLE permissao (
  idusuario INTEGER NOT NULL,
  idimagem INTEGER NOT NULL,
  excluir BOOLEAN NOT NULL DEFAULT 0,
  visualizar BOOLEAN NOT NULL DEFAULT 0,
  compartilhar BOOLEAN NOT NULL DEFAULT 0,
  PRIMARY KEY (idusuario, idimagem),
  CONSTRAINT fkusuarioimagem
    FOREIGN KEY (idusuario)
    REFERENCES usuario (idusuario),
    
  CONSTRAINT fk_permissao_imagem1
    FOREIGN KEY (idimagem)
    REFERENCES imagem (idimagem)
);
