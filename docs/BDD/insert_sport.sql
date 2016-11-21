use inscription;

INSERT INTO CANDIDAT VALUES
(1, "Tony", "P","Bullet-Tooth", "qwerty"),
(2, "Boris", "P", "The Blade", "ytrewq"),
(3, "Les Manouches", "e", null , null); 
#(4, "Brick Top", "p", null, "feedem");

INSERT INTO COMPETITION VALUES
(1, "Mondial de flechettes", "2016-06-21", 0),
(2, "Tournoi de bowling", "2016-06-21", 1);

INSERT INTO COMPOSER VALUES
(3, 1),
(3, 2);

INSERT INTO INSCRIRE VALUES
(3, 2),
(2, 1);