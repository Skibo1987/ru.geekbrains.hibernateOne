DROP TABLE  users IF EXISTS;
CREATE TABLE IF NOT EXISTS users (id bigserial, score int, name VARCHAR(255), PRIMARY KAY (id));
INSERT INTO users (name, score) VALUE ('Bob', 80),('Jack',80),('John', 80);