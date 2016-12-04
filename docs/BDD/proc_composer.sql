#COMPOSER 

#Get équipes d'un membre
DROP PROCEDURE IF EXISTS getEquipes_candidat;
DELIMITER |
CREATE PROCEDURE getEquipes_candidat(id_c_s int)
BEGIN
    SELECT nom_candidat
    FROM CANDIDAT, COMPOSER
    WHERE CANDIDAT.id_candidat = COMPOSER.id_candidat_squad
    AND id_candidat_pers = id_c_s;
END |
DELIMITER ;

#Get membres d'une equipe 
DROP PROCEDURE IF EXISTS getMembres_squad;
DELIMITER |
CREATE PROCEDURE getMembres_squad(id_c_s int)
BEGIN
    SELECT nom_candidat
    FROM CANDIDAT, COMPOSER
    WHERE CANDIDAT.id_candidat = COMPOSER.id_candidat_pers 
    AND id_candidat_squad = id_c_s;
END |
DELIMITER ; 

#Add personne dans une equipe 
DROP PROCEDURE IF EXISTS addEquipe_candidat;
DELIMITER |
CREATE PROCEDURE addEquipe_candidat(id_c int, id_s int)
BEGIN
    IF ((SELECT sub
        FROM CANDIDAT
        WHERE (id_candidat = id_s))="s") THEN
            INSERT INTO COMPOSER VALUES (id_s, id_c);
    END IF;
END |
DELIMITER ;

#Remove personne d'une equipe
DROP PROCEDURE IF EXISTS removeEquipe_candidat;
DELIMITER |
CREATE PROCEDURE removeEquipe_candidat(id_c int, id_s int)
BEGIN
    DELETE FROM COMPOSER
    WHERE id_candidat_squad = id_s
    AND (sub = "p" OR sub = "P")
    AND id_candidat_pers = id_c;
END |
DELIMITER ; 