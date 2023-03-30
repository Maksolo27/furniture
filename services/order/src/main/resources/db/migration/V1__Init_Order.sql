CREATE SCHEMA IF NOT EXISTS orders;

CREATE TABLE IF NOT EXISTS orders.order (
                                          orderId INT,
                                          itemName TEXT NOT NULL,
                                          itemPrice float8 NOT NULL,
                                          PRIMARY KEY (orderId)
    );