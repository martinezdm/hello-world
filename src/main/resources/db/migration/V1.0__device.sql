CREATE TABLE device ( id integer, name text NOT NULL, vol int NOT NULL DEFAULT 0, status boolean NOT NULL DEFAULT FALSE, cmd TEXT NOT NULL DEFAULT '', PRIMARY KEY (id));
INSERT INTO device (id, name) VALUES (1, 'living room'),(2, 'kitchen'),(3, 'bathroom'),(4, 'bedroom');
CREATE TABLE button ( id serial, cmd text NOT NULL, PRIMARY KEY (id));

