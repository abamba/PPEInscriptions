#Get membres d'une equipe
DROP PROCEDURE IF EXISTS Composition;
DELIMITER |
CREATE PROCEDURE Composition(id_c_s int)
BEGIN
    SELECT nom_candidat
    FROM CANDIDAT, COMPOSER
    WHERE CANDIDAT.id_candidat = COMPOSER.id_candidat_pers 
    AND id_candidat_squad = id_c_s;
END |
DELIMITER ; 