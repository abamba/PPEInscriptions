#COMPETITION

#Liste des candidats
DROP PROCEDURE IF EXISTS ListeCandidat;
DELIMITER |
CREATE PROCEDURE ListeCandidat(id_comp int)
BEGIN
    select * from Candidat WHERE id_candidat IN (SELECT id_candidat from Inscrire WHERE id_compet = id_comp);
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
CREATE PROCEDURE modComp(id_comp int, nom_comp varchar(25), dateClot date, enEq bool)
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

#Candidats non inscrits
DROP PROCEDURE IF EXISTS getNonInscrits;
DELIMITER |
CREATE PROCEDURE getNonInscrits(id_comp int)
BEGIN
    select * from Candidat WHERE id_candidat NOT IN (SELECT id_candidat from Inscrire WHERE id_compet = id_comp) AND Candidat.sub IN (SELECT enEquipe FROM Competition WHERE id_compet = id_comp);
END |
DELIMITER ;