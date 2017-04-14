#COMPETITION

#Liste des candidats
DROP PROCEDURE IF EXISTS ListeCandidat;
DELIMITER |
CREATE PROCEDURE ListeCandidat()
BEGIN
    SELECT * FROM Candidat;
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