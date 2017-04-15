#inscriptions.ajoute(getOptionListeComp());
#inscriptions.ajoute(getOptioninscComp());
#inscriptions.ajoute(getOptiondesinscComp());
#inscriptions.ajoute(getOptionmodNom());
#inscriptions.ajoute(getOptionmodMail());
#inscriptions.ajoute(getOptionsuppPersonne()); 

#PERSONNE 

#Compétitions auxquelles il est inscrit 
DROP PROCEDURE IF EXISTS ListeComp;
DELIMITER | 
CREATE PROCEDURE ListeComp (id_c int) 
BEGIN 
    SELECT nom_compet 
    FROM COMPETITION, INSCRIRE, CANDIDAT 
    WHERE INSCRIRE.id_compet = COMPETITION.id_compet
    AND INSCRIRE.id_candidat = CANDIDAT.id_candidat
    AND CANDIDAT.id_candidat=id_c;
END |
DELIMITER ; 

#Inscrire ce candidat quelque part 
DROP PROCEDURE IF EXISTS inscComp;
DELIMITER |
CREATE PROCEDURE inscComp(id_c int, id_comp int)
BEGIN
    INSERT INTO INSCRIRE(id_candidat,id_compet)
    VALUES (id_c, id_comp);
END |
DELIMITER ; 

#Désinscrire ce candidat de quelque part 
DROP PROCEDURE IF EXISTS desinscComp;
DELIMITER |
CREATE PROCEDURE desinscComp(id_comp int, id_cand int)
BEGIN
    DELETE FROM INSCRIRE
    WHERE id_candidat LIKE id_cand
    AND id_compet LIKE id_comp;
END |
DELIMITER ; 

#Modifier Personne (nom, mail, prénom) 
DROP PROCEDURE IF EXISTS modPers;
DELIMITER |
CREATE PROCEDURE modPers(id_c int, prenom_c varchar(25), nom_c varchar(25), mail_c varchar(25))
BEGIN
    UPDATE CANDIDAT
    SET prenom = prenom_c, nom_candidat = nom_c, mail = mail_c
    WHERE id_candidat = id_c;
END |
DELIMITER ; 

#Supprimer candidat
DROP PROCEDURE IF EXISTS delCandidat;
DELIMITER | 
CREATE PROCEDURE delCandidat(id_c int) 
BEGIN 
    DECLARE subtype varchar(1);
    
    DELETE FROM CANDIDAT WHERE id_candidat=id_c;
    
    SET subtype = (SELECT sub FROM CANDIDAT WHERE id_candidat=id_c); 
    IF (subtype = "p" OR subtype = "P")
       THEN DELETE FROM COMPOSER WHERE id_candidat_pers=id_c;
    ELSEIF (subtype = "s" OR subtype = "S")
       THEN DELETE FROM COMPOSER WHERE id_candidat_squad=id_c;
    END IF;
    
END |
DELIMITER ; 