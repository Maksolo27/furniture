CREATE SCHEMA IF NOT EXISTS buyers;

CREATE TABLE IF NOT EXISTS buyers.buyer (
                                          id INT,
                                          firstName TEXT NOT NULL,
                                          lastName TEXT NOT NULL,
                                          phone TEXT NOT NULL,
                                          city TEXT NOT NULL,
                                          address TEXT NOT NULL,
                                          PRIMARY KEY (id)
    );