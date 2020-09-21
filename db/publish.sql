-- creating database for users
CREATE DATABASE userDB;

-- creating table in users' database
CREATE TABLE userDB.user (
    id              INT             NOT NULL AUTO_INCREMENT,
    age             INT             NOT NULL,
    name            VARCHAR(2000)   CHARSET utf8 NOT NULL,

    CONSTRAINT PK_USER_ID      PRIMARY KEY (id)
);