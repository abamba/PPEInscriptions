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
CREATE PROCEDURE createPers(nom_cand varchar(25), prenom varchar(25), mail varchar(25))
BEGIN
    INSERT INTO CANDIDAT (nom_candidat, sub, prenom, mail)
    VALUES (nom_cand, "p", prenom, mail);
END |
DELIMITER ;

# Créer une équipe

DROP PROCEDURE IF EXISTS createEq;
DELIMITER |
CREATE PROCEDURE createEq(nom_cand varchar(25), prenom varchar(25), mail varchar(25))
BEGIN
    INSERT INTO CANDIDAT(nom_candidat, sub, prenom, mail)
    VALUES (nom_cand, "s", prenom, mail);
END |
DELIMITER ;

# Afficher les compétitions

DROP PROCEDURE IF EXISTS afficheComp;
DELIMITER |
CREATE PROCEDURE afficheComp()
BEGIN
    SET @n=0;
    SELECT @n:=@n+1 AS Ligne, a.nom_compet AS Competition, a.dateClot_compet AS Date_cloture, a.enEquipe AS En_equipe FROM Competition a;
END |
DELIMITER ;

# Afficher les personnes

DROP PROCEDURE IF EXISTS affichePers;
DELIMITER |
CREATE PROCEDURE affichePers()
BEGIN
    SET @n=0;
    SELECT @n:=@n+1 AS Ligne, a.nom_candidat AS Nom, a.prenom AS Prenom, a.sub AS E_P, a.mail FROM Candidat a
    WHERE sub = 'p' OR sub = 'P';
END |
DELIMITER ;

# Afficher les équipes

DROP PROCEDURE IF EXISTS afficheEq;
DELIMITER |
CREATE PROCEDURE afficheEq()
BEGIN
    SET @n=0;
    SELECT @n:=@n+1 AS Ligne, a.nom_candidat AS Nom, a.prenom AS Prenom, a.sub AS E_P, a.mail FROM Candidat a
    WHERE sub = 's' OR sub = 'S';
END |
DELIMITER ;
