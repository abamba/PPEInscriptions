#COMPETITION

#Liste des candidats
DROP PROCEDURE IF EXISTS listeCandidat;
DELIMITER |
CREATE PROCEDURE listeCandidat()
BEGIN
    SELECT * FROM Candidat;
END |
DELIMITER ;

#Liste des compétitions
DROP PROCEDURE IF EXISTS listeComp;
DELIMITER |
CREATE PROCEDURE listeComp()
BEGIN
    SELECT *
    FROM COMPETITION;
END |
DELIMITER ;

#Inscrire un candidat
DROP PROCEDURE IF EXISTS inscrireCandidat;
DELIMITER |
CREATE PROCEDURE inscrireCandidat(id_c int, id_comp int)
BEGIN
    INSERT INTO INSCRIRE(id_candidat,id_compet)
    VALUES (id_c, id_comp);
END |
DELIMITER ;

#Désinscrire un candidat
DROP PROCEDURE IF EXISTS supprCandidat;
DELIMITER |
CREATE PROCEDURE supprCandidat(id_comp int, id_cand int)
BEGIN
    DELETE FROM INSCRIRE
    WHERE id_candidat LIKE id_cand
    AND id_compet LIKE id_comp;
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

#Modifier une compétition
DROP PROCEDURE IF EXISTS modComp;
DELIMITER |
CREATE PROCEDURE modComp(id_comp int, nom_comp int, dateClot date, enEq bool)
BEGIN
    UPDATE COMPETITION
    SET nom_compet = nom_comp, dateClot_compet = dateClot, enEquipe = enEq
    WHERE id_compet = id_comp;
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








#Verification inscription ouverte
DROP FUNCTION IF EXISTS insc_ouvert; 
DELIMITER | 
CREATE FUNCTION insc_ouvert (id_cpt int) RETURNS bool
BEGIN
	DECLARE datest BOOLEAN;
	DECLARE dateClot DATE;
    SET datest =TRUE;
	SET dateClot = (SELECT dateClot_compet FROM COMPETITION WHERE id_compet = id_cpt);

	IF (dateDiff(dateClot, now())<0) 
	   THEN SET datest=FALSE;
	END IF;
RETURN datest;
END |
DELIMITER ;

#Afficher la date de cloture d'une compet
DROP PROCEDURE IF EXISTS getDateCloture_compet;
DELIMITER |
CREATE PROCEDURE getDateCloture_compet(id_comp int)
BEGIN
    SELECT dateClot_compet
    FROM COMPETITION
    WHERE id_compet = id_comp;
END |
DELIMITER ;

#Afficher le nom de la compétition
DROP PROCEDURE IF EXISTS getNom_compet;
DELIMITER | 
CREATE PROCEDURE getNom_compet (id_cpt int) 
BEGIN 
    SELECT id_compet, nom_compet 
    FROM COMPETITION 
    WHERE id_compet=id_cpt;
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