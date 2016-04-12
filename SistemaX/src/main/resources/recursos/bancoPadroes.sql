CREATE TABLE Usuario(
         id SERIAL,
	matricula VARCHAR(6) NOT NULL,
	nomeUsuario VARCHAR(50) NOT NULL,
	email VARCHAR(60) UNIQUE NOT NULL,
	senha VARCHAR(16) NOT NULL UNIQUE, 
	foto VARCHAR(100) NOT NULL,
	papel VARCHAR(35) NOT NULL,
	status BOOLEAN  DEFAULT TRUE, 
	PRIMARY KEY (matricula) 

);

CREATE TABLE Feriado(
         id SERIAL,
	data DATE NOT NULL,
	nome VARCHAR(30) NOT NULL UNIQUE,
	PRIMARY KEY (nome,data)
);
-- Usuário padrão
CREATE TABLE Bloco(
         id SERIAL,
	nome VARCHAR(50) NOT NULL UNIQUE,
	PRIMARY KEY (id)
);
CREATE TABLE Sala(
        id SERIAL,
	nome VARCHAR(50) NOT NULL UNIQUE,
        idbloco INT NOT NULL,
       capacidade INT NOT NULL,
       status INT NOT NULL,
       tipo NOT NULL,
        FOREIGN KEY(idbloco) REFERENCES Bloco(id)  ON DELETE CASCADE,
	PRIMARY KEY (id)
);
CREATE SEQUENCE numerosTombamento START 1000000 MAXVALUE 9999999;


CREATE TABLE Material (
    nome VARCHAR(50) NOT NULL, 
    tombamento INT NOT NULL, 
    status INT NOT NULL DEFAULT 1, 
    local INT DEFAULT NULL, 
    FOREIGN KEY(local) REFERENCES Sala(id),
    PRIMARY KEY (tombamento)
);

CREATE TABLE Evento (
    id SERIAL,
    nome VARCHAR(50) NOT NULL,
    descricao TEXT,
    numero_participantes INT NOT NULL,
    id_responsavel INT NOT NULL,
    data_inicio TIMESTAMP NOT NULL,
    data_termino TIMESTAMP NOT NULL,
    FOREIGN KEY (id_responsavel) REFERENCES usuario(id)
);
Status API Training Shop Blog About
© 2016 GitHub, Inc. Terms Privacy 

INSERT INTO usuario (matricula , nomeUsuario, email,senha,foto, papel) VALUES('000000', 'Administrador', 'admin@gmail.com', 'admin153Chg%','jose2.jpg' ,'ADMISTRAD0R');
