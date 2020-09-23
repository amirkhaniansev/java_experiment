-- creating database for users
CREATE DATABASE userDB;

-- creating table in users' database
CREATE TABLE userDB.user (
    id              INT             NOT NULL AUTO_INCREMENT,
    age             INT             NOT NULL,
    name            VARCHAR(255)   CHARSET utf8 NOT NULL,

    CONSTRAINT PK_USER_ID      PRIMARY KEY (id)
);

-- creating non-unique index on User table for name
CREATE INDEX IX_NAME ON userDB.user (name);