#triggers > date inscription 
#         > candidat existant ? delete ?
#         > compet existante ? delete ?
#         > update, inscription compet ? 

DELIMITER | 

DROP FUNCTION IF EXISTS Insc_ouverte 
CREATE FUNCTION Insc_ouverte (num int) RETURNS bool b 



END |
DELIMITER;