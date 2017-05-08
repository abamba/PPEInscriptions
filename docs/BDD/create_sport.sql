drop database if exists inscription;
create database inscription;
use inscription;

#drop table if exists COMPETITION, CANDIDAT, INSCRIPTIONS;


# Table: COMPETITION

CREATE TABLE COMPETITION(
        id_compet          int auto_increment  NOT NULL ,
        nom_compet         Varchar (25) NOT NULL ,
        dateClot_compet    Date         NOT NULL ,
        enEquipe           Bool         NOT NULL ,
        PRIMARY KEY (id_compet )
)ENGINE=InnoDB;



# Table: CANDIDAT         stocke les squads et les personnes

CREATE TABLE CANDIDAT(
        id_candidat  int auto_increment  NOT NULL ,
        nom_candidat Varchar (25) NOT NULL ,
        sub          Bool NOT NULL ,
        prenom       Varchar (25) ,
        mail         Varchar (25) ,
        PRIMARY KEY (id_candidat )
)ENGINE=InnoDB;



# Table: INSCRIRE

CREATE TABLE INSCRIRE(
        id_candidat      int NOT NULL ,
        id_compet        int NOT NULL ,
        PRIMARY KEY (id_candidat ,id_compet )
)ENGINE=InnoDB;



# Table: COMPOSER

CREATE TABLE COMPOSER(
        id_candidat_squad   int NOT NULL , 
        id_candidat_pers    int NOT NULL ,
        PRIMARY KEY (id_candidat_squad ,id_candidat_pers )
)ENGINE=InnoDB;


# Table: ENTRAINE

CREATE TABLE ENTRAINE(
    id_candidat_entraineur  int NOT NULL ,
    id_candidat_equipe      int NOT NULL ,
    PRIMARY KEY (id_candidat_equipe)
)ENGINE=InnoDB;