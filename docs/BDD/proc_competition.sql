#COMPETITION

#Verification inscription ouverte
DROP FUNCTION IF EXISTS insc_ouvert; 
DELIMITER | 
CREATE FUNCTION insc_ouvert (id_cpt int) RETURNS bool
BEGIN
	DECLARE datest BOOLEAN;
	DECLARE dateClot DATE;

	SET dateClot = (SELECT dateClot_compet FROM COMPETITION WHERE id_compet = id_cpt);

	IF (dateDiff(dateClot, now())<0) 
	   THEN SET datest=FALSE;
	END IF;
RETURN datest;
END |
DELIMITER ; 

#Retourne toutes les compet
DROP PROCEDURE IF EXISTS getListeComp;
DELIMITER |
CREATE PROCEDURE getListeComp()
BEGIN
    SELECT *
    FROM COMPETITION;
END |
DELIMITER ;

#Créer une compétition
DROP PROCEDURE IF EXISTS create_compet;
DELIMITER |
CREATE PROCEDURE create_compet(nom varchar(25), dateclot date, equipe bool)
BEGIN
    INSERT INTO COMPETITION (nom_compet, dateClot_compet, enEquipe)
    VALUES (nom, dateclot, equipe);
END |
DELIMITER ;

#Avoir la date de cloture d'une compet
DROP PROCEDURE IF EXISTS getDateCloture_compet;
DELIMITER |
CREATE PROCEDURE getDateCloture_compet(id_comp int)
BEGIN
    SELECT dateClot_compet
    FROM COMPETITION
    WHERE id_compet = id_comp;
END |
DELIMITER ;

#Changer la date de cloture d'une compet
DROP PROCEDURE IF EXISTS setDateCloture_compet;
DELIMITER |
CREATE PROCEDURE setDateCloture_compet(id_comp int, d date)
BEGIN
    UPDATE COMPETITION
    SET dateClot_compet = d
    WHERE id_complet = id_comp;
END |
DELIMITER ;

#Delete une compétition
DROP PROCEDURE IF EXISTS del_compet; 
DELIMITER | 
CREATE PROCEDURE del_compet (id_cpt int) 
BEGIN 
    DELETE FROM COMPETITION WHERE id_compet=id_cpt; 
END |
DELIMITER ; 

#Get nom de la compétition
DROP PROCEDURE IF EXISTS getNom_compet;
DELIMITER | 
CREATE PROCEDURE getNom_compet (id_cpt int) 
BEGIN 
    SELECT id_compet, nom_compet 
    FROM COMPETITION 
    WHERE id_compet=id_cpt;
END |
DELIMITER ; 

#Set nom de la compétition 
DROP PROCEDURE IF EXISTS setNom_compet;
DELIMITER |
CREATE PROCEDURE setNom_compet(id_cpt int, nom_cpt varchar(25))
BEGIN
    UPDATE COMPETITION
    SET nom_compet = nom_cpt
    WHERE id_compet = id_cpt;
END |
DELIMITER ; 

#check si c'est en equipe
DROP FUNCTION IF EXISTS estEnEquipe;
DELIMITER | 
CREATE FUNCTION estEnEquipe (id_cpt int) RETURNS bool
BEGIN 
    DECLARE squadTest bool;
    
    SET squadTest = (SELECT enEquipe FROM COMPETITION WHERE id_compet = id_cpt);
    
    RETURN squadTest;
END |
DELIMITER ;