#CANDIDAT

#Créer un candidat de type équipe
DELIMITER |
DROP PROCEDURE IF EXISTS addEquipe_cand;
CREATE PROCEDURE addEquipe_cand(nom_cand, prenom, mail)
BEGIN
    INSERT INTO CANDIDAT (nom_candidat, sub, prenom, mail)
    VALUES (nom_cand, "s", prenom, mail);
END |
DELIMITER;

#Créer un candidat de type personne
DELIMITER |
DROP PROCEDURE IF EXISTS addPersonne_cand;
CREATE PROCEDURE addPersonne_cand(nom_cand, prenom, mail)
BEGIN
    INSERT INTO CANDIDAT (nom_candidat, sub, prenom, mail)
    VALUES (nom_cand, "p", prenom, mail);
END |
DELIMITER;

#Delete un candidat
DELIMITER | 
DROP PROCEDURE IF EXISTS del_candidat 
CREATE PROCEDURE del_candidat (id_c varchar) 
BEGIN 
    DECLARE subtype varchar;
    
    DELETE FROM CANDIDAT WHERE id_candidat=id_c;
    
    SET subtype = (SELECT sub FROM CANDIDAT WHERE ID_candidat=id_c;); 
    IF (subtype = "p" OR subtype = "P")
       THEN DELETE FROM COMPOSER WHERE id_candidat_pers=id_c;
    ELSEIF (subtype = "s" OR subtype = "S")
      THEN  DELETE FROM COMPOSER WHERE id_candidat_squad=id_c;
    END IF
    
END |
DELIMITER ; 

#Get competitions où est inscrit
DELIMITER | 
DROP PROCEDURE IF EXISTS getCompet_candidat 
CREATE PROCEDURE getCompet_candidat (id_c varchar) 
BEGIN 
    SELECT nom_compet 
    FROM COMPETITION, INSCRIRE, CANDIDAT 
    WHERE INSCRIRE.id_compet = COMPETITION.id_compet
    AND INSCRIRE.id_candidat = CANDIDAT.id_candidat
    AND id_candidat=id_c;
END |
DELIMITER ; 

#Get nom du candidat
DELIMITER | 
DROP PROCEDURE IF EXISTS getNom_candidat 
CREATE PROCEDURE getNom_candidat (id_c varchar) 
BEGIN 
    SELECT nom_candidat 
    FROM CANDIDAT 
    WHERE id_candidat=id_c;
END |
DELIMITER ; 

#Set nom du candidat 
DELIMITER |
DROP PROCEDURE IF EXISTS setNom_candidat;
CREATE PROCEDURE setNom_candidat(id_c varchar, nom_c varchar)
BEGIN
    UPDATE CANDIDAT
    SET nom_candidat = nom_c
    WHERE id_candidat = id_c;
END |
DELIMITER; 

#Get prénom du candidat
DELIMITER | 
DROP PROCEDURE IF EXISTS getPrenom_candidat 
CREATE PROCEDURE getPrenom_candidat (id_c varchar) 
BEGIN 
    SELECT prenom 
    FROM CANDIDAT 
    WHERE id_candidat=id_c;
END |
DELIMITER ;

#Set prénom du candidat
DELIMITER |
DROP PROCEDURE IF EXISTS setPrenom_candidat;
CREATE PROCEDURE setPrenom_candidat(id_c varchar, nom_cand varchar)
BEGIN
    UPDATE CANDIDAT
    SET nom_candidat = nom_cand
    WHERE id_candidat = id_c;
END |
DELIMITER;

#Get mail du candidat 
DELIMITER | 
DROP PROCEDURE IF EXISTS getMail_candidat 
CREATE PROCEDURE getMail_candidat (id_c varchar) 
BEGIN 
    SELECT mail_candidat 
    FROM CANDIDAT 
    WHERE id_candidat=id_c;
END |
DELIMITER ;

#Set mail du candidat 
DELIMITER |
DROP PROCEDURE IF EXISTS setMail_candidat;
CREATE PROCEDURE setMail_candidat(id_c varchar, mail_cand varchar)
BEGIN
    UPDATE CANDIDAT
    SET mail = mail_cand
    WHERE id_candidat = id_c;
END |
DELIMITER;

#Tous les candidats confondus 
DELIMITER | 
DROP PROCEDURE IF EXISTS getCandidat 
CREATE PROCEDURE getCandidat () 
BEGIN 
    SELECT * 
    FROM CANDIDAT;
END |
DELIMITER ;

#Retourne tout les candidats de type personne
DELIMITER |
DROP PROCEDURE IF EXISTS getCandidPersonnes;
CREATE PROCEDURE getCandidPersonnes()
BEGIN
    SELECT id_candidat, nom_candidat, prenom
    FROM CANDIDAT
    WHERE sub = "p";
END |
DELIMITER;

#Retourne tout les candidats de type équipe
DELIMITER |
DROP PROCEDURE IF EXISTS getCandidEquipes;
CREATE PROCEDURE getCandidEquipes()
BEGIN
    SELECT id_candidat, nom_candidat, prenom
    FROM CANDIDAT
    WHERE sub = "s";
END |
DELIMITER;