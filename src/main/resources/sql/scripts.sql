CREATE TABLE users (
                       username VARCHAR NOT NULL PRIMARY KEY,
                       password VARCHAR NOT NULL,
                       enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
                             username VARCHAR NOT NULL,
                             authority VARCHAR NOT NULL,
                             CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

insert into users values('salam','12345','1');
insert into authorities values('salam','write');

CREATE TABLE customer (
                       id int PRIMARY KEY,
                       email VARCHAR NOT NULL,
                       pwd VARCHAR NOT NULL,
                       role VARCHAR NOT NULL
);

insert into customer values(1,'tur@gmail.com','1234567','admin');