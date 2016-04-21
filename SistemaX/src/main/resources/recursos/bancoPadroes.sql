CREATE TABLE Usuario(
        id SERIAL,
	matricula VARCHAR(6) NOT NULL,
	nomeUsuario VARCHAR(50) NOT NULL,
	email VARCHAR(60) UNIQUE NOT NULL,
	senha VARCHAR(16) NOT NULL UNIQUE, 
	foto VARCHAR(100) NOT NULL,
	papel VARCHAR(35) NOT NULL,
	status BOOLEAN  DEFAULT TRUE, 
	PRIMARY KEY (id) 
);

CREATE TABLE Feriado(
         id SERIAL,
	data DATE NOT NULL,
	nome VARCHAR(30) NOT NULL UNIQUE,
	PRIMARY KEY (nome,data)
);
-- Usuário padrão
INSERT INTO usuario (matricula , nomeUsuario, email,senha,foto, papel) VALUES('000000', 'Administrador', 'admin@gmail.com', 'xs123Chg%','jose2.jpg' ,'Administrador');

CREATE TABLE Bloco(
         id SERIAL,
	nome VARCHAR(50) NOT NULL UNIQUE,
	PRIMARY KEY (id)
);

CREATE SEQUENCE numerosTombamento START 1000000 MAXVALUE 9999999;

CREATE TABLE Sala(
        id SERIAL,
	nome VARCHAR(50) NOT NULL UNIQUE,
        idbloco INT NOT NULL,
        capacidade INT NOT NULL,
        estado INT NOT NULL  DEFAULT 1,
        tipo INT NOT NULL,
        FOREIGN KEY(idbloco) REFERENCES Bloco(id)  ON DELETE CASCADE,
	PRIMARY KEY (id)
);


CREATE TABLE Material (
    descricao VARCHAR(100) NOT NULL, 
    tombamento INT NOT NULL, 
    estado INT NOT NULL DEFAULT 1, 
    local INT DEFAULT NULL, 
    FOREIGN KEY(local) REFERENCES Sala(id),
    PRIMARY KEY (tombamento)
);

CREATE TABLE Evento (
    id SERIAL,
    nome VARCHAR(50) NOT NULL,
    descricao TEXT,
    numeroParticipantes INT NOT NULL,
    idResponsavel INT NOT NULL,
    dataInicio TIMESTAMP NOT NULL,
    dataTermino TIMESTAMP NOT NULL,
    estado INT NOT NULL DEFAULT 1,
    PRIMARY KEY (id)
);

CREATE TABLE alocacao (
        idsala INT NOT NULL,
        idevento INT not null,
        idMaterial INT UNIQUE, 
        FOREIGN KEY (idMaterial) REFERENCES   Material(tombamento) ON DELETE CASCADE,
        FOREIGN KEY (idsala) REFERENCES Sala(id) ON DELETE CASCADE,
        FOREIGN KEY (idevento) REFERENCES Evento(id) ON DELETE CASCADE,
        PRIMARY KEY (idsala,idevento)
);