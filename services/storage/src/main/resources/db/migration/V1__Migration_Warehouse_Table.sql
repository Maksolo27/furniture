CREATE SCHEMA IF NOT EXISTS ware3;

CREATE TABLE IF NOT EXISTS ware3.ware (
                                         id INT,
                                         name TEXT NOT NULL,
                                         price float8 NOT NULL,
                                         PRIMARY KEY (id)
);