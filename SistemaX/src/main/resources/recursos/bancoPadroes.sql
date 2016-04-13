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
INSERT INTO usuario (matricula , nomeUsuario, email,senha,foto, papel) VALUES('000000', 'Administrador', 'admin@gmail.com', 'xs123Chg%','jose2.jpg' ,'Administrador');
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
        tipo INT NOT NULL,
        FOREIGN KEY(idbloco) REFERENCES Bloco(id)  ON DELETE CASCADE,
	PRIMARY KEY (id)
);
CREATE SEQUENCE numerosTombamento START 1000000 MAXVALUE 9999999;


CREATE TABLE Material (
    nome VARCHAR(50) NOT NULL, 
    tombamento INT NOT NULL, 
    status VARCHAR(12) NOT NULL DEFAULT Disponivel, 
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
    FOREIGN KEY (id_responsavel) REFERENCES usuario(id),
 PRIMARY KEY (id)

);
CREATE TABLE alocacao (
        idsala INT  ON DELETE CASCADE;
        idevento INT  ON DELETE CASCADE
        FOREIGN KEY (idsala) REFERENCES Sala(id),
        FOREIGN KEY (idevento) REFERENCES Evento(id),
        PRIMARY KEY (idsala,idevento)
);


