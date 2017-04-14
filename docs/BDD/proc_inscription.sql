# Créer une compétition

DROP PROCEDURE IF EXISTS createComp;
DELIMITER |
CREATE PROCEDURE create_compet(nom varchar(25), dateclot date, equipe bool)
BEGIN
    INSERT INTO COMPETITION (nom_compet, dateClot_compet, enEquipe)
    VALUES (nom, dateclot, equipe);
END |
DELIMITER ;

# Créer un candidat

DROP PROCEDURE IF EXISTS createPers;
DELIMITER |
CREATE PROCEDURE addPersonne(nom_cand varchar(25), prenom varchar(25), mail varchar(25))
BEGIN
    INSERT INTO CANDIDAT (nom_candidat, sub, prenom, mail)
    VALUES (nom_cand, "p", prenom, mail);
END |
DELIMITER ;

# Créer une équipe

DROP PROCEDURE IF EXISTS createEq;
DELIMITER |
CREATE PROCEDURE addEquipe(nom_cand varchar(25), prenom varchar(25), mail varchar(25))
BEGIN
    INSERT INTO CANDIDAT(nom_candidat, sub, prenom, mail)
    VALUES (nom_cand, "s", prenom, mail);
END |
DELIMITER ;