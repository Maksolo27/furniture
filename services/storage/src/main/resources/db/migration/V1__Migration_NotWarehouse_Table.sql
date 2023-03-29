CREATE SCHEMA IF NOT EXISTS notware1;

CREATE TABLE IF NOT EXISTS notware1.ware (
                                         id INT,
                                         name TEXT NOT NULL,
                                         price float8 NOT NULL,
                                         PRIMARY KEY (id)
);