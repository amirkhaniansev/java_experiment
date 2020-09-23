CREATE TABLE userDB.user (
    id              INT             NOT NULL AUTO_INCREMENT,
    age             INT             NOT NULL,
    name            VARCHAR(255)   CHARSET utf8 NOT NULL,

    CONSTRAINT PK_USER_ID      PRIMARY KEY (id)
);

CREATE INDEX IX_NAME ON userDB.user (name);