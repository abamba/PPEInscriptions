#INSCRIRE 

#tous les candidats inscrits
DROP PROCEDURE IF EXISTS getCandidats_insc;
DELIMITER |
CREATE PROCEDURE getCandidats_insc(id_cpt int)
BEGIN
    SELECT id_candidat, nom_candidat
    FROM CANDIDAT, INSCRIRE
    WHERE CANDIDAT.id_candidat = INSCRIRE.id_candidat 
    AND id_compet = id_cpt;
END |
DELIMITER ;

#Désinscrit un candidat d'une compétition
DROP PROCEDURE IF EXISTS desinsc_candid;
DELIMITER |
CREATE PROCEDURE desinsc_candid(id_comp int, id_cand int)
BEGIN
    DELETE FROM INSCRIRE
    WHERE id_candidat LIKE id_cand
    AND id_compet LIKE id_comp;
END |
DELIMITER ;