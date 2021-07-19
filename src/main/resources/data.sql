INSERT INTO "PUBLIC"."USER" VALUES
('Player', 1, 'luiz', 5),
('Player', 2, 'anna', 6),
('Player', 3, 'rennan', 20),
('Admin', 4, 'uira 1', NULL),
('Admin', 5, 'uira 2', NULL);

INSERT INTO "PUBLIC"."BOARD" VALUES
( 1,'2021-10-20', 'Board teste1', 4),
( 2,'2021-10-25', 'Board teste2', 4),
( 3,'2021-10-30', 'Board teste3', 5);

INSERT INTO "PUBLIC"."ACHIEVEMENT" VALUES
( 1, 'Coxinha', 5, 1),
( 2, 'Pizza', 7, 1),
( 3, 'Sorvetao', 4, 2),
( 4, 'Sunday', 6, 2),
( 5, 'Dia livre', 15, 3);

INSERT INTO "PUBLIC"."USER_BOARDS" VALUES
(1, 1),
(1, 3),
(1, 2),
(2, 1),
(2, 2),
(3, 1);
