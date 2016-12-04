#COMPETITION

#Verification inscription ouverte
DELIMITER | 
DROP FUNCTION IF EXISTS insc_ouvert 
CREATE FUNCTION insc_ouvert (numCompet int) 
BEGIN
	DECLARE datest BOOLEAN;
	DECLARE dateClot DATE;

	SET dateClot = (SELECT dateClot_compet FROM COMPETITION WHERE id_compet = numCompet);

	IF (dateDiff(dateClot, now())<0) 
	   THEN SET datest=FALSE;
	END IF;
RETURN datest;
END |
DELIMITER ; 

#Retourne toutes les compet
DELIMITER |
DROP PROCEDURE IF EXISTS getListeComp;
CREATE PROCEDURE getListeComp()
BEGIN
    SELECT *
    FROM COMPETITION;
END |
DELIMITER;

#Créer une compétition
DELIMITER |
DROP PROCEDURE IF EXISTS create_compet;
CREATE PROCEDURE create_compet(nom varchar, dateclot date, equipe bool)
BEGIN
    INSERT INTO COMPETITION (nom_compet, dateClot_compet, enEquipe)
    VALUES (nom, dateclot, equipe);
END |
DELIMITER;

#Avoir la date de cloture d'une compet
DELIMITER |
DROP PROCEDURE IF EXISTS getDateCloture_compet;
CREATE PROCEDURE getDateCloture_compet(id_comp varchar)
BEGIN
    SELECT dateClot_compet
    FROM COMPETITION
    WHERE id_compet = id_comp;
END |
DELIMITER;

#Changer la date de cloture d'une compet
DELIMITER |
DROP PROCEDURE IF EXISTS setDateCloture_compet;
CREATE PROCEDURE setDateCloture_compet(id_comp varchar, d date)
BEGIN
    UPDATE COMPETITION
    SET dateClot_compet = d
    WHERE id_complet = id_comp;
END |
DELIMITER;

#Delete une compétition
DELIMITER | 
DROP PROCEDURE IF EXISTS del_compet 
CREATE PROCEDURE del_compet (id_cpt varchar) 
BEGIN 

    DELETE FROM COMPETITION WHERE id_compet=id_cpt;
    
END |
DELIMITER ; 

#Get nom de la compétition
DELIMITER | 
DROP PROCEDURE IF EXISTS getNom_compet 
CREATE PROCEDURE getNom_compet (id_cpt varchar) 
BEGIN 
    SELECT id_compet, nom_compet 
    FROM COMPETITION 
    WHERE id_compet=id_cpt;
END |
DELIMITER ; 

#Set nom de la compétition 
DELIMITER |
DROP PROCEDURE IF EXISTS setNom_compet;
CREATE PROCEDURE setNom_compet(id_cpt varchar, nom_cpt varchar)
BEGIN
    UPDATE COMPETITION
    SET nom_compet = nom_cpt
    WHERE id_compet = id_cpt;
END |
DELIMITER; 

#check si equipe
DELIMITER | 
DROP FUNCTION IF EXISTS estEnEquipe 
CREATE FUNCTION estEnEquipe (id_cpt varchar) 
BEGIN 
    DECLARE squadTest bool
    
    SET squadTest = (SELECT enEquipe FROM COMPETITION WHERE id_compet = id_cpt;)
    
    RETURN squadTest;
END |
DELIMITER ;