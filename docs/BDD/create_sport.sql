drop database if exists inscription;
create database inscription;
use inscription;

#drop table if exists COMPETITION, CANDIDAT, INSCRIPTIONS;


# Table: COMPETITION

CREATE TABLE COMPETITION(
        id_compet          varchar (5) Auto_increment  NOT NULL ,
        nom_compet         Varchar (25) NOT NULL ,
        dateClot_compet    Date NOT NULL ,
        enEquipe           Bool NOT NULL ,
        PRIMARY KEY (id_compet )
)ENGINE=InnoDB;



# Table: CANDIDAT         stocke les squads et les personnes

CREATE TABLE CANDIDAT(
        id_candidat  varchar (5) Auto_increment  NOT NULL ,
        nom_candidat Varchar (25) NOT NULL ,
        sub          Varchar (1) NOT NULL , #pour diff squad et personne
        prenom       Varchar (25) ,
        mail         Varchar (25) ,
        PRIMARY KEY (id_candidat )
)ENGINE=InnoDB;



# Table: INSCRIRE

CREATE TABLE INSCRIRE(
        id_candidat      varchar NOT NULL ,
        id_compet        varchar NOT NULL ,
        PRIMARY KEY (id_candidat ,id_compet )
)ENGINE=InnoDB;



# Table: COMPOSER

CREATE TABLE COMPOSER(
        id_candidat_squad   varchar NOT NULL , #dank
        id_candidat_pers varchar NOT NULL ,
        PRIMARY KEY (id_candidat_EQUIPE ,id_candidat_PERSONNE )
)ENGINE=InnoDB;