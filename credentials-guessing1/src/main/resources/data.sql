DROP TABLE IF EXISTS users;
CREATE TABLE users(UserId INT, UserName TEXT, Password TEXT);
INSERT INTO users VALUES(1,'12345','12345');

DROP TABLE IF EXISTS prefs;
CREATE TABLE prefs(PreferenceId INT, Color TEXT, UserId INT);
INSERT INTO prefs VALUES(1,'RED', 1);
