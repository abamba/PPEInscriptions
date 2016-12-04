#COMPOSER 

#Get équipes d'un membre
DELIMITER |
DROP PROCEDURE IF EXISTS getEquipes_candidat;
CREATE PROCEDURE getEquipes_candidat(id_c_s varchar)
BEGIN
    SELECT nom_candidat
    FROM CANDIDAT, COMPOSER
    WHERE CANDIDAT.id_candidat = COMPOSER.id_candidat_squad
    AND id_candidat_pers = id_c_s;
END |
DELIMITER;

#Get membres d'une equipe 
DELIMITER |
DROP PROCEDURE IF EXISTS getMembres_squad;
CREATE PROCEDURE getMembres_squad(id_c_s varchar)
BEGIN
    SELECT nom_candidat
    FROM CANDIDAT, COMPOSER
    WHERE CANDIDAT.id_candidat = COMPOSER.id_candidat_pers 
    AND id_candidat_squad = id_c_s;
END |
DELIMITER; 

#Add personne dans une equipe 
DELIMITER |
DROP PROCEDURE IF EXISTS addEquipe_candidat;
CREATE PROCEDURE addEquipe_candidat(id_c varchar, id_s varchar)
BEGIN
    IF ((SELECT sub
        FROM CANDIDAT
        WHERE (id_candidat = id_s))="s") THEN
            INSERT INTO COMPOSER VALUES (id_s, id_c);
    END IF;
END |
DELIMITER;

#Remove personne d'une equipe
DELIMITER |
DROP PROCEDURE IF EXISTS removeEquipe_candidat;
CREATE PROCEDURE removeEquipe_candidat(id_c varchar, id_s varchar)
BEGIN
    DELETE FROM COMPOSER
    WHERE id_candidat_squad = id_s
    AND (sub = "p" OR sub = "P")
    AND id_candidat_pers = id_c;
END |
DELIMITER; 