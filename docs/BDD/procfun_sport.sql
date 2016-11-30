#procédures et fonctions Inscriptions Sportives 

#Verification inscription ouverte
DELIMITER | 
DROP FUNCTION IF EXISTS insc_ouvert 
CREATE FUNCTION insc_ouvert (numCompet int) 
BEGIN
	DECLARE datest BOOLEAN;
	DECLARE dateClot DATE;

	SET dateClot = (SELECT dateClot_compet FROM COMPETITION WHERE id_compet = numCompet);

	IF (dateDiff(dateClot, now())<0) 
	   THEN SET datest=FALSE;
	END IF;
RETURN datest;
END |
DELIMITER ; 


#Delete un candidat
DELIMITER | 
DROP PROCEDURE IF EXISTS del_candidat 
CREATE FUNCTION del_candidat (id_c varchar) 
BEGIN 
    DECLARE subtype varchar;
    
    DELETE FROM CANDIDAT WHERE id_candidat=id_c;
    
    SET subtype = (SELECT sub FROM CANDIDAT WHERE ID_candidat=id_c;); 
    IF (subtype = "p" OR subtype = "P")
       THEN DELETE FROM COMPOSER WHERE id_candidat_pers=id_c;
    ELSEIF (subtype = "s" OR subtype = "S")
      THEN  DELETE FROM COMPOSER WHERE id_candidat_squad=id_c;
    END IF
    
END |
DELIMITER ; 

