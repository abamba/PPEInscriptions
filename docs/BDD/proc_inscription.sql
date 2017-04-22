# Créer une compétition

DROP PROCEDURE IF EXISTS createComp;
DELIMITER |
CREATE PROCEDURE createComp(nom varchar(25), dateclot date, equipe bool)
BEGIN
    INSERT INTO COMPETITION (nom_compet, dateClot_compet, enEquipe)
    VALUES (nom, dateclot, equipe);
END |
DELIMITER ;

# Créer un candidat

DROP PROCEDURE IF EXISTS createPers;
DELIMITER |
CREATE PROCEDURE createPers(nom_cand varchar(25),type bool, prenom varchar(25), mail varchar(25))
BEGIN
    INSERT INTO CANDIDAT (nom_candidat, sub, prenom, mail)
    VALUES (nom_cand, type, prenom, mail);
END |
DELIMITER ;

# Afficher les compétitions

DROP PROCEDURE IF EXISTS afficheComp;
DELIMITER |
CREATE PROCEDURE afficheComp()
BEGIN
    SET @n=0;
    SELECT @n:=@n+1 AS Ligne, a.id_compet AS ID, a.nom_compet AS Competition, a.dateClot_compet AS Date_cloture, a.enEquipe AS En_equipe FROM Competition a;
END |
DELIMITER ;

# Afficher les personnes

DROP PROCEDURE IF EXISTS affichePers;
DELIMITER |
CREATE PROCEDURE affichePers()
BEGIN
    SET @n=0;
    SELECT @n:=@n+1 AS Ligne, a.nom_candidat AS Nom, a.prenom AS Prenom, a.sub AS E_P, a.mail FROM Candidat a
    WHERE sub;
END |
DELIMITER ;

# Afficher les équipes

DROP PROCEDURE IF EXISTS afficheEq;
DELIMITER |
CREATE PROCEDURE afficheEq()
BEGIN
    SET @n=0;
    SELECT @n:=@n+1 AS Ligne, a.nom_candidat AS Nom, a.prenom AS Prenom, a.sub AS E_P, a.mail FROM Candidat a
    WHERE !sub;
END |
DELIMITER ;

# Afficher les candidats (équipes + personnes)

DROP PROCEDURE IF EXISTS afficheCand;
DELIMITER |
CREATE PROCEDURE afficheCand()
BEGIN
    SET @n=0;
    SELECT @n:=@n+1 AS Ligne, a.id_candidat AS ID, a.nom_candidat AS Nom, a.prenom AS Prenom, a.sub AS E_P, a.mail FROM Candidat a;
END |
DELIMITER ;
