use inscription;

INSERT INTO CANDIDAT VALUES
(1, "Tony", 0,"Bullet-Tooth", "qwerty"),
(2, "Boris", 0, "The Blade", "ytrewq"),
(3, "Les Manouches", 1, null , null),
(4, "The Wild Bunch", 1, null, "feedem");

INSERT INTO COMPETITION VALUES
(1, "Mondial de flechettes", "2017-06-21", 0),
(2, "Tournoi de bowling", "2017-06-21", 1);

INSERT INTO COMPOSER VALUES
(3, 1),
(3, 2);

INSERT INTO INSCRIRE VALUES
(3, 2),
(2, 1);