#INSCRIRE 

#tous les candidats inscrits V
DROP PROCEDURE IF EXISTS getCandidats_insc;
DELIMITER |
CREATE PROCEDURE getCandidats_insc(id_cpt int)
BEGIN
    SELECT CANDIDAT.id_candidat, CANDIDAT.nom_candidat
    FROM CANDIDAT, INSCRIRE, COMPETITION
    WHERE CANDIDAT.id_candidat = INSCRIRE.id_candidat 
    AND COMPETITION.id_compet = id_cpt;
END |
DELIMITER ;

#Désinscrit un candidat d'une compétition V
DROP PROCEDURE IF EXISTS desinsc_candid;
DELIMITER |
CREATE PROCEDURE desinsc_candid(id_comp int, id_cand int)
BEGIN
    DELETE FROM INSCRIRE
    WHERE id_candidat LIKE id_cand
    AND id_compet LIKE id_comp;
END |
DELIMITER ;

#Mettre une personne dans une compet V
DROP PROCEDURE IF EXISTS addCompet_candidat;
DELIMITER |
CREATE PROCEDURE addCompet_candidat(id_c int, id_comp int)
BEGIN
    INSERT INTO INSCRIRE(id_candidat,id_compet)
    VALUES (id_c, id_comp);
END |
DELIMITER ;