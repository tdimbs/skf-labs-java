DROP TABLE IF EXISTS users;
CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT, UserName TEXT, Password TEXT, isAdmin BOOLEAN);
INSERT INTO users (Username, Password, isAdmin) VALUES ('johndoe','password1', 0);
INSERT INTO users (Username, Password, isAdmin) VALUES ('user1','password10', 0);
INSERT INTO users (Username, Password, isAdmin) VALUES ('user2','password100', 0);
INSERT INTO users (Username, Password, isAdmin) VALUES ('user3','password11111111', 0);
INSERT INTO users (Username, Password, isAdmin) VALUES ('user4','password1231', 0);
INSERT INTO users (Username, Password, isAdmin) VALUES ('user5','password1444', 0);
INSERT INTO users (Username, Password, isAdmin) VALUES ('user6','password111', 0);
INSERT INTO users (Username, Password, isAdmin) VALUES ('user7','password12', 0);
INSERT INTO users (Username, Password, isAdmin) VALUES ('admin','password444555', 1);
INSERT INTO users (Username, Password, isAdmin) VALUES ('jimcarrey','password88', 0);


DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, surname TEXT, date_of_birth TEXT, api_key TEXT, userId INT );
INSERT INTO user_info(name, surname, date_of_birth, api_key, userId) VALUES ("Jhon","Doe","01/09/1985","klaSKJDOA83847JSDskdjajeb39", 1);
INSERT INTO user_info(name, surname, date_of_birth, api_key, userId) VALUES ("Marc","Zucker","01/09/1985","klajd;aihd9[0jdioha", 2);
INSERT INTO user_info(name, surname, date_of_birth, api_key, userId) VALUES ("Fred","List","01/08/1983","asdkjasd8pu322d8h32d8h2iN", 3);
INSERT INTO user_info(name, surname, date_of_birth, api_key, userId) VALUES ("Jack","Balmore","01/09/1965","PGHJOUKJOK9059069J5J", 4);
INSERT INTO user_info(name, surname, date_of_birth, api_key, userId) VALUES ("Laura","Fresca","09/09/1976","KADSNDCAISDJASIOMAJSIDAJ", 5);
INSERT INTO user_info(name, surname, date_of_birth, api_key, userId) VALUES ("Marta","London","22/04/1985","XCVBCXVBVCXZCVBCX", 6);
INSERT INTO user_info(name, surname, date_of_birth, api_key, userId) VALUES ("Marika","Kovac","17/10/1985","93274146147Y3EUDSBHH", 7);
INSERT INTO user_info(name, surname, date_of_birth, api_key, userId) VALUES ("Alessia","Panatta","10/09/1988","974YD7ASDAS9DAG79TSAD", 8);
INSERT INTO user_info(name, surname, date_of_birth, api_key, userId) VALUES ("Mika","Hakkinen","01/09/1982","AS7RA968GDBVDQIYILDSY7", 9);
INSERT INTO user_info(name, surname, date_of_birth, api_key, userId) VALUES ("Jim","Carrey","1990-01-01","jakshd834oiabvut8bu298bcsiba", 10);


DROP TABLE IF EXISTS posts;
CREATE TABLE posts ( id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, body TEXT, author_id INTEGER, FOREIGN KEY(author_id) REFERENCES users(id));
INSERT INTO posts(title, body, author_id) VALUES ("Hello World","This is the first post of jhon",1);
INSERT INTO posts(title, body, author_id) VALUES ("Woooow","Im the maaaaask",10);
INSERT INTO posts(title, body, author_id) VALUES ("Second Post John","This is the second post of Jhon",1);
