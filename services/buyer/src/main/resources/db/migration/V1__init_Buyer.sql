CREATE SCHEMA IF NOT EXISTS buyers;

CREATE TABLE IF NOT EXISTS buyers.Buyer (
                                          id INT,
                                          firstName TEXT NOT NULL,
                                          lastName TEXT NOT NULL,
                                          phone TEXT NOT NULL,
                                          city TEXT NOT NULL,
                                          adress TEXT NOT NULL,
                                          price float8 NOT NULL,
                                          PRIMARY KEY (id)
    );