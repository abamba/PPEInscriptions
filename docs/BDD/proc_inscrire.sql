#INSCRIRE 

#tous les candidats inscrits
DELIMITER |
DROP PROCEDURE IF EXISTS getCandidats_insc;
CREATE PROCEDURE getCandidats_insc(id_cpt varchar)
BEGIN
    SELECT id_candidat, nom_candidat
    FROM CANDIDAT, INSCRIRE
    WHERE CANDIDAT.id_candidat = INSCRIRE.id_candidat 
    AND id_compet = id_cpt;
END |
DELIMITER;

#Désinscrit un candidat d'une compétition
DELIMITER |
DROP PROCEDURE IF EXISTS desinsc_candid;
CREATE PROCEDURE desinsc_candid(id_comp varchar, id_cand varchar)
BEGIN
    DELETE FROM INSCRIRE
    WHERE id_candidat = id_cand
    AND id_compet = id_comp;
END |
DELIMITER;