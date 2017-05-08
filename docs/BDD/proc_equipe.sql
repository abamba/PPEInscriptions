#Get membres d'une equipe
DROP PROCEDURE IF EXISTS Composition;
DELIMITER |
CREATE PROCEDURE Composition(id_c_s int)
BEGIN
    SELECT id_candidat, nom_candidat, sub, prenom, mail
    FROM CANDIDAT, COMPOSER
    WHERE CANDIDAT.id_candidat = COMPOSER.id_candidat_pers 
    AND id_candidat_squad = id_c_s;
END |
DELIMITER ; 

#Get équipes d'un membre
DROP PROCEDURE IF EXISTS CompositionEquipe;
DELIMITER |
CREATE PROCEDURE CompositionEquipe(id_c_s int)
BEGIN
    SELECT id_candidat, nom_candidat, sub, prenom, mail
    FROM CANDIDAT, COMPOSER
    WHERE CANDIDAT.id_candidat = COMPOSER.id_candidat_squad
    AND id_candidat_pers = id_c_s;
END |
DELIMITER ; 

#Inscrire un membre à une équipe
DROP PROCEDURE IF EXISTS Compose;
DELIMITER |
CREATE PROCEDURE Compose(id_c int,id_s int)
BEGIN
    INSERT INTO COMPOSER VALUES (id_s,id_c);
END |
DELIMITER ;

#Enlever un membre d'une équipe
DROP PROCEDURE IF EXISTS Decompose;
DELIMITER |
CREATE PROCEDURE Decompose(id_c int,id_s int)
BEGIN
    DELETE FROM COMPOSER WHERE id_candidat_squad = id_s AND id_candidat_pers = id_c;
END |
DELIMITER ;