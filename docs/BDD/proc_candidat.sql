#CANDIDAT

#Créer un candidat de type équipe V
DROP PROCEDURE IF EXISTS addEquipe;
DELIMITER |
CREATE PROCEDURE addEquipe(nom_cand varchar(25), prenom varchar(25), mail varchar(25))
BEGIN
    INSERT INTO CANDIDAT(nom_candidat, sub, prenom, mail)
    VALUES (nom_cand, "s", prenom, mail);
END |
DELIMITER ;

#Créer un candidat de type personne V
DROP PROCEDURE IF EXISTS addPersonne;
DELIMITER |
CREATE PROCEDURE addPersonne(nom_cand varchar(25), prenom varchar(25), mail varchar(25))
BEGIN
    INSERT INTO CANDIDAT (nom_candidat, sub, prenom, mail)
    VALUES (nom_cand, "p", prenom, mail);
END |
DELIMITER ;

#Delete un candidat V
DROP PROCEDURE IF EXISTS delCandidat;
DELIMITER | 
CREATE PROCEDURE delCandidat(id_c int) 
BEGIN 
    DECLARE subtype varchar(1);
    
    DELETE FROM CANDIDAT WHERE id_candidat=id_c;
    
    SET subtype = (SELECT sub FROM CANDIDAT WHERE id_candidat=id_c); 
    IF (subtype = "p" OR subtype = "P")
       THEN DELETE FROM COMPOSER WHERE id_candidat_pers=id_c;
    ELSEIF (subtype = "s" OR subtype = "S")
       THEN DELETE FROM COMPOSER WHERE id_candidat_squad=id_c;
    END IF;
    
END |
DELIMITER ; 

#Get competitions où est inscrit V
DROP PROCEDURE IF EXISTS getCompet_candidat;
DELIMITER | 
CREATE PROCEDURE getCompet_candidat (id_c int) 
BEGIN 
    SELECT nom_compet 
    FROM COMPETITION, INSCRIRE, CANDIDAT 
    WHERE INSCRIRE.id_compet = COMPETITION.id_compet
    AND INSCRIRE.id_candidat = CANDIDAT.id_candidat
    AND CANDIDAT.id_candidat=id_c;
END |
DELIMITER ; 

#Get nom du candidat V
DROP PROCEDURE IF EXISTS getNom_candidat;
DELIMITER | 
CREATE PROCEDURE getNom_candidat (id_c int) 
BEGIN 
    SELECT nom_candidat 
    FROM CANDIDAT 
    WHERE id_candidat=id_c;
END |
DELIMITER ; 

#Set nom du candidat V
DROP PROCEDURE IF EXISTS setNom_candidat;
DELIMITER |
CREATE PROCEDURE setNom_candidat(id_c int, nom_c varchar(25))
BEGIN
    UPDATE CANDIDAT
    SET nom_candidat = nom_c
    WHERE id_candidat = id_c;
END |
DELIMITER ; 

#Get prénom du candidat V
DROP PROCEDURE IF EXISTS getPrenom_candidat;
DELIMITER | 
CREATE PROCEDURE getPrenom_candidat (id_c int) 
BEGIN 
    SELECT prenom 
    FROM CANDIDAT 
    WHERE id_candidat=id_c;
END |
DELIMITER ;

#Set prénom du candidat V
DROP PROCEDURE IF EXISTS setPrenom_candidat;
DELIMITER |
CREATE PROCEDURE setPrenom_candidat(id_c int, prenom_cand varchar(25))
BEGIN
    UPDATE CANDIDAT
    SET prenom = prenom_cand
    WHERE id_candidat = id_c;
END |
DELIMITER ;

#Get mail du candidat V
DROP PROCEDURE IF EXISTS getMail_candidat;
DELIMITER | 
CREATE PROCEDURE getMail_candidat (id_c int) 
BEGIN 
    SELECT mail
    FROM CANDIDAT 
    WHERE id_candidat=id_c;
END |
DELIMITER ;

#Set mail du candidat V
DROP PROCEDURE IF EXISTS setMail_candidat;
DELIMITER |
CREATE PROCEDURE setMail_candidat(id_c int, mail_cand varchar(25))
BEGIN
    UPDATE CANDIDAT
    SET mail = mail_cand
    WHERE id_candidat = id_c;
END |
DELIMITER ;

#Tous les candidats confondus V
DROP PROCEDURE IF EXISTS getCandidat;
DELIMITER | 
CREATE PROCEDURE getCandidat() 
BEGIN 
    SELECT *
    FROM CANDIDAT;
END |
DELIMITER ;

#Retourne tout les candidats de type personne V
DROP PROCEDURE IF EXISTS getCandidPersonnes;
DELIMITER |
CREATE PROCEDURE getCandidPersonnes()
BEGIN
    SELECT id_candidat, nom_candidat, prenom
    FROM CANDIDAT
    WHERE sub = "p";
END |
DELIMITER ;

#Retourne tout les candidats de type équipe V
DROP PROCEDURE IF EXISTS getCandidEquipes;
DELIMITER |
CREATE PROCEDURE getCandidEquipes()
BEGIN
    SELECT id_candidat, nom_candidat, prenom
    FROM CANDIDAT
    WHERE sub = "s";
END |
DELIMITER ;